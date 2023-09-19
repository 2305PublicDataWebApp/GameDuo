package com.norazo.gg.notice.controller;

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

import com.norazo.gg.notice.domain.Notice;
import com.norazo.gg.notice.domain.PageInfo;
import com.norazo.gg.notice.service.NoticeService;


@Controller
public class NoticeController {
			
		@Autowired
		private NoticeService nService;
		
		@RequestMapping(value="/notice/write.gg", method = RequestMethod.GET)
		public ModelAndView showWriteForm(ModelAndView mv) {
			mv.setViewName("notice/write");
			return mv;
		}
		
		@RequestMapping(value="/notice/write.gg", method = RequestMethod.POST)
		public ModelAndView noticeRegister(
				ModelAndView mv
				, @ModelAttribute Notice notice
				, HttpSession session
				, HttpServletRequest request) {
			try {
				String noticeAdmin = (String)session.getAttribute("memberId");
				System.out.println("noticeAdmin" + noticeAdmin);
				if(noticeAdmin != null && !noticeAdmin.equals("")) {
					notice.setNoticeAdmin(noticeAdmin);
					
				int result = nService.insertNotice(notice);
				mv.setViewName("redirect:/notice/list.gg");
			}else {
				mv.addObject("msg", "로그인 정보가 존재하지 않습니다.");
				mv.addObject("error", "로그인이 필요합니다.");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/serviceFailed");
			}
		
		}catch(Exception e) {
			mv.addObject("msg", "공지사항 등록이 완료하지 않습니다.");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/notice/write.gg");
			mv.setViewName("common/serviceFailed");
		}
			return mv;

		}
		@RequestMapping(value="/notice/detail.gg", method = RequestMethod.GET)
		public ModelAndView NoticeDetail(ModelAndView mv
				, @RequestParam("noticeNo") Integer noticeNo) {
			try {
				Notice noticeOne = nService.selectNoticeByNo(noticeNo);
				
				if(noticeOne != null) {
					
					mv.addObject("notice",noticeOne);
					mv.setViewName("notice/detail");
				}else {
					mv.addObject("msg", "로그인 정보가 존재하지 않습니다.");
					mv.addObject("error", "로그인이 필요합니다.");
					mv.addObject("url", "/index.jsp");
					mv.setViewName("common/serviceFailed");
				}
				
				
			}catch (Exception e) {
				// TODO: handle exception
				mv.addObject("msg", "공지사항 등록이 완료하지 않습니다.");
				mv.addObject("error", e.getMessage());
				mv.addObject("url", "/notice/write.gg");
				mv.setViewName("common/serviceFailed");
			}
			return mv;

		}
		
		@RequestMapping(value="/notice/modify.gg", method = RequestMethod.GET)
		public ModelAndView showNoticeModify(ModelAndView mv
				,@RequestParam("noticeNo") Integer noticeNo) {
			try {
				Notice notice = nService.selectNoticeByNo(noticeNo);
				mv.addObject("notice", notice);
				mv.setViewName("notice/modify");
			} catch (Exception e) {
				mv.addObject("msg", "공지사항 등록이 완료되지 않았습니다.");
				mv.addObject("error", e.getMessage());
				mv.addObject("url", "/notice/write.gg");
				mv.setViewName("common/serviceFailed");
			}
			return mv;

		}
				

		
		@RequestMapping(value="/notice/modify.gg", method=RequestMethod.POST)
		public ModelAndView noticeModify(ModelAndView mv
				, @ModelAttribute Notice notice
				, HttpServletRequest request
				, HttpSession session
				) {
			try {
				String memberId = (String)session.getAttribute("memberId");
				String NoticeAdmin = notice.getNoticeAdmin();
				if(NoticeAdmin != null && NoticeAdmin.equals(memberId)) {
<<<<<<< HEAD
					
				
				int result = nService.updateNotice(notice);
				if(result > 0) {
					mv.setViewName("redirect:/notice/detail.gg?noticeNo="+notice.getNoticeNo());
=======
					int result = nService.updateNotice(notice);
					if(result > 0) {
						mv.setViewName("redirect:/notice/detail.gg?noticeNo="+notice.getNoticeNo());
					}else {
						mv.addObject("msg", "공지사항 수정이 완료하지 않습니다.");
						mv.addObject("error", "공지사항 수정 실패");
						mv.addObject("url", "/notice/modify.gg?noticeNo="+notice.getNoticeNo());
						mv.setViewName("common/serviceFailed");
					}
>>>>>>> branch 'master' of https://github.com/2305PublicDataWebApp/GameDuo.git
				}else {
					mv.addObject("msg", "공지사항 수정이 완료하지 않습니다.");
					mv.addObject("error", "공지사항 수정 실패");
					mv.addObject("url", "/notice/modify.gg?noticeNo="+notice.getNoticeNo());
					mv.setViewName("common/serviceFailed");
				}
			}catch (Exception e) {
				mv.addObject("msg", "공지사항 수정이 완료하지 않습니다.");
				mv.addObject("error", e.getMessage());
				mv.addObject("url", "/notice/modify.gg?noticeNo="+notice.getNoticeNo());
				mv.setViewName("common/serviceFailed");
			}
			return mv;
		
		}

		
//			@RequestMapping(value="/notice/list.gg", method = RequestMethod.GET)
//			public ModelAndView showNoticeList(ModelAndView mv) {
//				mv.setViewName("notice/list");
//				return mv;
//			}
//			@RequestMapping(value="/notice/list.gg",method = RequestMethod.GET)
//			public ModelAndView showNoticeList(
//					@RequestParam(value="page", required = false, defaultValue = "1")Integer currentPage
//					,HttpServletRequest request
//					,ModelAndView mv) {
//				try {
//					Integer totalCount = nService.getListCount();
//					PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
//					System.out.println("pInfo:" + pInfo);
//					List<Notice> NList = nService.selectNotice(pInfo);
//					if(!NList.isEmpty()) {
//						mv.addObject("NList", NList).addObject("pInfo",pInfo).setViewName("notice/list");
//					}else {
//						mv.addObject("msg","공지사항 등록이 완료되지 않1았습니다.");
//						mv.addObject("error","공지사항 상세조회 실패");
//						mv.addObject("url","/notice/list.gg");
//						mv.setViewName("common/serviceFailed");
//					}
//					
//				}catch (Exception e) {
//					mv.addObject("msg","공지사항 목록 조회가 완료되지 않았습니다.");
//					mv.addObject("error","공지사항 상세조회 실패");
//					mv.addObject("url", "/notice/write.gg");
//					mv.setViewName("common/serviceFailed");
//				}
//				
//				return mv;
//		}
		
		@RequestMapping(value="/notice/list.gg", method=RequestMethod.GET)
		public ModelAndView showNoticeList(
				@RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
				, ModelAndView mv) {
			try {
				Integer totalCount = nService.getListCount();
				PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
//				System.out.println("pInfo값:" + pInfo);
				List<Notice> nList = nService.selectNotice(pInfo);
				if(!nList.isEmpty()) {
					mv.addObject("nList", nList).addObject("pInfo", pInfo).setViewName("notice/list");
				}else {
					mv.addObject("msg", "공지사항 조회가 완료되지 않았습니다");
					mv.addObject("error", "공지사항 상세 조회 실패");
					mv.addObject("url", "/notice/list.gg");
					mv.setViewName("common/serviceFailed");
				}
			} catch (Exception e) {
				mv.addObject("msg", "공지사항 조회가 완료되지 않았습니다");
				mv.addObject("error", e.getMessage());
				mv.addObject("url", "/notice/write.gg");
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
}

