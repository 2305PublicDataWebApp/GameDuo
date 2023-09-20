package com.norazo.gg.report.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.norazo.gg.notice.domain.PageInfo;
import com.norazo.gg.report.domain.Report;
import com.norazo.gg.report.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	private ReportService service;
	
	@RequestMapping(value="/report/write.gg", method = RequestMethod.GET)
	public ModelAndView showWriteForm(ModelAndView mv) {
		mv.setViewName("report/write");
		return mv;
	}
	
	@RequestMapping(value="/report/write.gg", method = RequestMethod.POST)
	public ModelAndView reportRegister(
			ModelAndView mv
			, @ModelAttribute Report report
			, HttpSession session
			, HttpServletRequest request) {
		try {
			String reportWriter = (String)session.getAttribute("memberName");
			System.out.println("reportWriter" + reportWriter);
			if(reportWriter != null && !reportWriter.equals("")) {
				report.setReportWriter(reportWriter);
				
			int result = service.insertReport(report);
			mv.setViewName("redirect:/report/list.gg");
		}else {
			mv.addObject("msg", "로그인 정보가 존재하지 않습니다.");
			mv.addObject("error", "로그인이 필요합니다.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/serviceFailed");
		}
	
	}catch(Exception e) {
		mv.addObject("msg", "신고게시글 등록이 완료하지 않습니다.");
		mv.addObject("error", e.getMessage());
		mv.addObject("url", "/report/write.gg");
		mv.setViewName("common/serviceFailed");
	}
		return mv;

	}
	@RequestMapping(value="/report/detail.gg", method = RequestMethod.GET)
	public ModelAndView ReportDetail(ModelAndView mv
			, @RequestParam("reportNo") Integer reportNo) {
		try {
			Report reportOne = service.selectReportByNo(reportNo);
			
			if(reportOne != null) {
				
				mv.addObject("report",reportOne);
				mv.setViewName("report/detail");
			}else {
				mv.addObject("msg", "로그인 정보가 존재하지 않습니다.");
				mv.addObject("error", "로그인이 필요합니다.");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/serviceFailed");
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			mv.addObject("msg", "신고게시글 등록이 완료하지 않습니다.");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/report/write.gg");
			mv.setViewName("common/serviceFailed");
		}
		return mv;

	}
	
	@RequestMapping(value="/report/modify.gg", method = RequestMethod.GET)
	public ModelAndView showReportModify(ModelAndView mv
			,@RequestParam("reportNo") Integer reportNo) {
		try {
			Report report = service.selectReportByNo(reportNo);
			mv.addObject("report", report);
			mv.setViewName("report/modify");
		} catch (Exception e) {
			mv.addObject("msg", "신고게시글 등록이 완료되지 않았습니다.");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/report/write.gg");
			mv.setViewName("common/serviceFailed");
		}
		return mv;

	}
	
	@RequestMapping(value="/report/modify.gg", method=RequestMethod.POST)
	public ModelAndView reportModify(ModelAndView mv
			, @ModelAttribute Report report
			, HttpServletRequest request
			, HttpSession session
			) {
		try {
			String memberName = (String)session.getAttribute("memberName");
			String reportWriter = report.getReportWriter();
			if(reportWriter != null && reportWriter.equals(memberName)) {
				int result = service.updateReport(report);
				if(result > 0) {
					mv.setViewName("redirect:/report/detail.gg?reportNo="+report.getReportNo());
				}else {
					mv.addObject("msg", "신고게시글 수정이 완료하지 않습니다.");
					mv.addObject("error", "신고게시글 수정 실패");
					mv.addObject("url", "/report/modify.gg?reportNo="+report.getReportNo());
					mv.setViewName("common/serviceFailed");
				}
			}else {
				mv.addObject("msg", "신고게시글 수정 권한이 없습니다.");
				mv.addObject("error", "신고게시글 수정 불가");
				mv.addObject("url", "/report/modify.gg?reportNo="+report.getReportNo());
				mv.setViewName("common/serviceFailed");
			}
		}catch (Exception e) {
			mv.addObject("msg", "신고게시글 수정이 완료하지 않습니다.");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/report/modify.gg?reportNo="+report.getReportNo());
			mv.setViewName("common/serviceFailed");
		}
		return mv;
	
	}

	@RequestMapping(value="/report/list.gg", method=RequestMethod.GET)
	public ModelAndView showReportList(
			@RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, ModelAndView mv) {
		try {
			Integer totalCount = service.getListCount();
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
//			System.out.println("pInfo값:" + pInfo);
			List<Report> rList = service.selectReport(pInfo);
			if(!rList.isEmpty()) {
				mv.addObject("rList", rList).addObject("pInfo", pInfo).setViewName("report/list");
			}else {
				mv.addObject("msg", "신고게시글 조회가 완료되지 않았습니다");
				mv.addObject("error", "신고게시글 상세 조회 실패");
				mv.addObject("url", "/report/list.gg");
				mv.setViewName("common/serviceFailed");
			}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의 바랍니다.");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/report/write.gg");
			mv.setViewName("common/serviceFailed");
		}
		return mv;
	}
	
		
		private PageInfo getPageInfo(Integer currentPage, Integer totalCount) {
			int recordCountPerPage = 10; // 한페이징보여질 갯수
			int naviCountPerPage = 10; // 몇개씩할건지
			int naviTotalCount;
			
			naviTotalCount = (int)Math.ceil((double)totalCount/recordCountPerPage); //내장객에 올림 Math.ceil ex) 102 /10 = 10.2 => 11.0 앞에잇는 int로 0을잘라서 넣게함!
			int startNavi = ((int)((double)currentPage/naviCountPerPage+0.9)-1)*naviCountPerPage+1;
			int endNavi = startNavi + naviCountPerPage -1;
			if(endNavi > naviTotalCount) {
				endNavi = naviTotalCount;
			}
			PageInfo pInfo = new PageInfo(currentPage, totalCount, naviTotalCount, recordCountPerPage, naviCountPerPage, startNavi, endNavi);
			return pInfo;
		}
		
		@RequestMapping(value="/report/delete.gg", method=RequestMethod.GET)
		public ModelAndView reportDelete(ModelAndView mv
				, @RequestParam("reportNo") Integer reportNo) {
			try {
				Report report = new Report();
				report.setReportNo(reportNo);
					int result = service.deleteReport(report);
					System.out.println("result값"+result);
					if(result > 0) {
						mv.setViewName("redirect:/report/list.gg");
					} else {
						mv.addObject("msg", "게시글 삭제가 완료되지 않았습니다.");
						mv.addObject("error", "게시글 삭제 불가");
						mv.addObject("url", "/report/list.gg");
						mv.setViewName("common/serviceFailed");
					}
			}catch (Exception e) {
				mv.addObject("msg", "관리자에게 문의바랍니다.");
				mv.addObject("error", e.getMessage());
				mv.addObject("url", "/report/list.gg");
				mv.setViewName("common/serviceFailed");
			}
			return mv;
		}
}




