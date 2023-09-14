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
		@RequestMapping(value="/notice/write.gg",method = RequestMethod.POST)
		public ModelAndView noticeRegister(
				ModelAndView mv
				, @ModelAttribute Notice notice
				, HttpSession session
				, HttpServletRequest request) {
			try {
				String noticeAdmin = (String)session.getAttribute("memberId");
				System.out.println("noticeWrite" + noticeAdmin);
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
			mv.addObject("msg", "게시글 등록이 완료하지 않습니다.");
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
				mv.addObject("msg", "게시글 등록이 완료하지 않습니다.");
				mv.addObject("error", e.getMessage());
				mv.addObject("url", "/notice/write.gg");
				mv.setViewName("common/serviceFailed");
			}
			return mv;

		}
			

		
			@RequestMapping(value="/notice/list.gg", method = RequestMethod.GET)
			public ModelAndView showNoticeList(ModelAndView mv) {
				mv.setViewName("notice/list");
				return mv;
			}
			@RequestMapping(value="/notice/list.gg",method = RequestMethod.POST)
			public ModelAndView showNoticeList(
					@RequestParam(value="page", required = false, defaultValue = "1")Integer crrentPage,
					HttpServletRequest request
					,ModelAndView mv) {
				try {
					Integer totalCount = nService.getListCount();
					PageInfo pInfo = this.getPageInfo(crrentPage, totalCount);
<<<<<<< HEAD
					System.out.println("pInfo:" + pInfo);
=======
					System.out.println("pInfo" + pInfo);
>>>>>>> branch 'master' of https://github.com/2305PublicDataWebApp/GameDuo.git
					List<Notice> NList = nService.selectNotice(pInfo);
					if(!NList.isEmpty()) {
						mv.addObject("NList", NList).addObject("pInfo",pInfo).setViewName("notice/list");
					}else {
						mv.addObject("msg","게시글 등록이 완료되지 않았습니다.");
						mv.addObject("error","게시글 상세조회 실패");
						mv.addObject("url","/notice/list.gg");
						mv.setViewName("common/serviceFailed");
					}
					
				}catch (Exception e) {
					// TODO: handle exception
					mv.addObject("msg","게시글 등록이 완료되지 않았습니다.");
					mv.addObject("error","게시글 상세조회 실패");
					mv.addObject("url", "/notice/write.gg");
					mv.setViewName("common/serviceFailed");
				}
				
				return mv;
		}
			private PageInfo getPageInfo(Integer crrentPage, Integer totalCount) {
				// TODO Auto-generated method stub
				
				
				return null;
			}
}

