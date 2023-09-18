package com.norazo.gg.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.norazo.gg.board.domain.Reply;
import com.norazo.gg.board.service.ReplyService;


@Controller
@RequestMapping("/reply")
public class ReplyController {
	@Autowired
	private ReplyService rService;
	
	@RequestMapping(value="/add.gg", method=RequestMethod.POST)
	public ModelAndView insertReply(ModelAndView mv
			, @ModelAttribute Reply reply
			, HttpSession session) {
		String url = "";
		try {
			String replyWriter = (String)session.getAttribute("memberName");
			if(replyWriter != null && !replyWriter.equals("")) {
				reply.setReplyWriter(replyWriter);
				int result = rService.insertReply(reply);
				url = "/board/detail.gg?boardNo="+reply.getRefBoardNo();
				if(result > 0) {
					mv.setViewName("redirect:"+url);
				}else {
					mv.addObject("msg", "댓글 등록이 완료되지 않았습니다");
					mv.addObject("msg", "댓글 등록 실패");
					mv.addObject("url", url);
					mv.setViewName("common/serviceFailed");
				}
			}else {
				mv.addObject("msg", "로그인이 되지 않았습니다.");
				mv.addObject("error", "로그인 정보 확인 실패 ");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/serviceFailed");
			}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의 바랍니다");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", url);
			mv.setViewName("common/serviceFailed");
		}
		
		return mv;
	}
	@RequestMapping(value="/update.gg", method=RequestMethod.POST)
	public ModelAndView updateReply(ModelAndView mv
			, @ModelAttribute Reply reply
			, HttpSession session) {
		String url = "";
		try {
			String replyWriter = (String)session.getAttribute("memberName");
			if(replyWriter != null && !replyWriter.equals("")) {
				reply.setReplyWriter(replyWriter);
				url = "/board/detail.gg?boardNo="+reply.getRefBoardNo();
				int result = rService.updateReply(reply);
				mv.setViewName("redirect:"+url);
			}else {
				mv.addObject("msg", "로그인이 되지 않았습니다.");
				mv.addObject("msg", "로그인 정보 확인 실패 ");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/serviceFailed");
			}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의 바랍니다");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", url);
			mv.setViewName("common/serviceFailed");
		}
		return mv;
	}
	
	@RequestMapping(value="/delete.gg", method=RequestMethod.GET)
	public ModelAndView deleteReply(ModelAndView mv
			, @ModelAttribute Reply reply
			, HttpSession session
			) {
		String url =""; 
		try {
			String memberId = (String)session.getAttribute("memberId"); // 세션에서 아이디 가져오기(많이씀까먹지말긔!!)
			String replyWriter = reply.getReplyWriter();
			url = "/board/detail.gg?boardNo="+reply.getRefBoardNo();
				if(replyWriter != null && replyWriter.equals(memberId)) { //널포인트익셉션방지
				int result = rService.deleteReply(reply);
				if(result > 0) {
					// 성공
					mv.setViewName("redirect:"+url);
				} else {
					// 실패
					mv.addObject("msg", "댓글 삭제가 완료되지 않았습니다.");
					mv.addObject("error", "댓글 삭제 실패");
					mv.addObject("url", url);
					mv.setViewName("common/serviceFailed");
				}
			} else {
				mv.addObject("msg", "자신의 댓글만 삭제할 수 있습니다.");
				mv.addObject("error", "댓글 삭제 불가");
				mv.addObject("url", url);
				mv.setViewName("common/serviceFailed");
			}		
			
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의바랍니다.");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", url);
			mv.setViewName("common/serviceFailed");
		}
		
		
		return mv;
	}
}
