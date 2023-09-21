package com.norazo.gg.board.controller;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.norazo.gg.board.domain.Board;
import com.norazo.gg.board.domain.Reply;
import com.norazo.gg.board.service.BoardService;
import com.norazo.gg.board.service.ReplyService;
import com.norazo.gg.notice.domain.PageInfo;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService bService;
	@Autowired
	private ReplyService rService;
	
	@RequestMapping(value="/write.gg", method=RequestMethod.GET)
	public ModelAndView showWriteForm(ModelAndView mv) {
		mv.setViewName("board/write");
		return mv;
	}
	
	@RequestMapping(value="/write.gg", method=RequestMethod.POST)
	public ModelAndView boardRegister(
			ModelAndView mv
			, @ModelAttribute Board board
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			, HttpSession session
			, HttpServletRequest request) {
		try {
			String boardWriter = (String)session.getAttribute("memberName");
			if(boardWriter != null && !boardWriter.equals("")) {
				board.setBoardWriter(boardWriter);
			if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				Map<String, Object> bMap = this.saveFile(request, uploadFile);
				board.setBoardFilename((String)bMap.get("fileName"));
				board.setBoardFileRename((String)bMap.get("fileRename"));
				board.setBoardFilepath((String)bMap.get("filePath"));
				board.setBoardFileLength((long)bMap.get("fileLength"));
				}
			int result = bService.insertBoard(board);
			mv.setViewName("redirect:/board/list.gg");
			} else {
				mv.addObject("msg", "로그인 정보가 존재하지 않습니다.");
				mv.addObject("error", "로그인이 필요합니다.");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/serviceFailed");
			}
		} catch (Exception e) {
			mv.addObject("msg", "게시글 등록이 완료되지 않았습니다");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/serviceFailed");
		}	
		return mv;
	}
	
	@RequestMapping(value="/modify.gg", method=RequestMethod.GET)
	public ModelAndView showModifyForm(ModelAndView mv
			, @RequestParam("boardNo") Integer boardNo) {
		try {
			Board board = bService.selectBoardByNo(boardNo);
			mv.addObject("board", board);
			mv.setViewName("board/modify");
		} catch (Exception e) {
			mv.addObject("msg", "게시글 수정페이지 조회가 완료되지 않았습니다.");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/board/detail.gg");
			mv.setViewName("common/serviceFailed");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/modify.gg", method=RequestMethod.POST)
	public ModelAndView boardModify(ModelAndView mv, @ModelAttribute Board board,
	        @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile,
	        HttpSession session, HttpServletRequest request,
	        @RequestParam(value="deleteFile", required=false) boolean deleteFile) { 
	    try {
	        String memberName = (String)session.getAttribute("memberName");
	        String boardWriter = board.getBoardWriter();
	        if (boardWriter != null && boardWriter.equals(memberName)) {
	            if (deleteFile) {
	                String fileRename = board.getBoardFileRename();
	                if (fileRename != null) {
	                    deleteFile(fileRename, request);
	                    board.setBoardFilename(null);
	                    board.setBoardFileRename(null);
	                    board.setBoardFilepath(null);
	                    board.setBoardFileLength(0);
	                }
	            }
	            if (uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
	                String fileRename = board.getBoardFileRename();
	                if (fileRename != null) {
	                    this.deleteFile(fileRename, request);
	                }
	                Map<String, Object> bFileMap = this.saveFile(request, uploadFile);
	                board.setBoardFilename((String)bFileMap.get("fileName"));
	                board.setBoardFileRename((String)bFileMap.get("fileRename"));
	                board.setBoardFilepath((String)bFileMap.get("filePath"));
	                board.setBoardFileLength((long)bFileMap.get("fileLength"));
	            }
	            int result = bService.updateBoard(board);
	            if (result > 0) {
	                mv.setViewName("redirect:/board/detail.gg?boardNo=" + board.getBoardNo());
	            } else {
	                mv.addObject("msg", "게시글 수정이 완료되지 않았습니다.");
	                mv.addObject("error", "게시글 수정 실패");
	                mv.addObject("url", "/board/modify.gg?boardNo=" + board.getBoardNo());
	                mv.setViewName("common/serviceFailed");
	            }
	        } else {
	            mv.addObject("msg", "게시글 수정 권한이 없습니다.");
	            mv.addObject("error", "게시글 수정 불가");
	            mv.addObject("url", "/board/modify.gg?boardNo=" + board.getBoardNo());
	            mv.setViewName("common/serviceFailed");
	        }
	    } catch (Exception e) {
	        mv.addObject("msg", "관리자에게 문의바랍니다.");
	        mv.addObject("error", e.getMessage());
	        mv.addObject("url", "/board/modify.gg?boardNo=" + board.getBoardNo());
	        mv.setViewName("common/serviceFailed");
	    }
	    return mv;
	}

	@RequestMapping(value="/search.gg", method=RequestMethod.GET)
	public String searchNoticeList(
			@RequestParam("searchCondition") String searchCondition
		, @RequestParam("searchKeyword") String searchKeyword
		, @RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
		, Model model) {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("searchCondition", searchCondition); 
			paramMap.put("searchKeyword", searchKeyword);
			int totalCount = bService.getListCount(paramMap);
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			List<Board> searchList = bService.searchBoardsByKeyword(pInfo, paramMap);
			
			if(!searchList.isEmpty()) {
				model.addAttribute("searchCondition", searchCondition);
				model.addAttribute("searchKeyword", searchKeyword);
				model.addAttribute("pInfo", pInfo);
				model.addAttribute("sList", searchList);
				return "board/search";
			} else {
				model.addAttribute("msg", "데이터 조회가 완료되지 않았습니다.");
				model.addAttribute("error", "공지사항 제목으로 조회 실패");
				model.addAttribute("url", "/list.gg");
				return "common/serviceFailed";
			}
		}
	
	@RequestMapping(value="/delete.gg", method=RequestMethod.GET)
	public ModelAndView boardDelete(ModelAndView mv
			, @RequestParam("boardNo") Integer boardNo) {
		try {
			Board board = new Board();
			board.setBoardNo(boardNo);
				int result = bService.deleteBoard(board);
				System.out.println("result값"+result);
				if(result > 0) {
					mv.setViewName("redirect:/board/list.gg");
				} else {
					mv.addObject("msg", "게시글 삭제가 완료되지 않았습니다.");
					mv.addObject("error", "게시글 삭제 불가");
					mv.addObject("url", "/board/list.gg");
					mv.setViewName("common/serviceFailed");
				}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의바랍니다~");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/board/list.gg");
			mv.setViewName("common/serviceFailed");
		}
		return mv;
	}
	@RequestMapping(value="/list.gg", method=RequestMethod.GET)
	public ModelAndView showBoardList(
			@RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, ModelAndView mv) {
		try {
			Integer totalCount = bService.getListCount();
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			List<Board> bList = bService.selectBoardList(pInfo);
			if(!bList.isEmpty()) {
				mv.addObject("bList", bList).addObject("pInfo", pInfo).setViewName("board/list");
			}else {
				mv.addObject("msg", "게시글 조회가 완료되지 않았습니다");
				mv.addObject("error", "게시글 상세 조회 실패");
				mv.addObject("url", "/board/list.gg");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "게시글 조회가 완료되지 않았습니다");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/board/write.gg");
			mv.setViewName("common/serviceFailed");
		}
		return mv;
	}
	
	@RequestMapping(value="/detail.gg", method=RequestMethod.GET)
	public ModelAndView showBoardDetail(ModelAndView mv
			, @RequestParam("boardNo") Integer boardNo) {
		try {
			Board boardOne = bService.selectBoardByNo(boardNo);
			if(boardOne != null) {
				List<Reply> replyList = rService.selectReplyList(boardNo);
				System.out.println("replyList값" + replyList);
				if(replyList.size() > 0) {
					mv.addObject("rList", replyList);
				}
				mv.addObject("board", boardOne);
				mv.setViewName("board/detail");
			}else {
				mv.addObject("msg", "게시글 조회가 완료되지 않았습니다");
				mv.addObject("msg", "게시글 조회 실패");
				mv.addObject("url", "/board/list.gg");
				mv.setViewName("common/serviceFailed");
			}
		} catch (Exception e) {
			mv.addObject("msg", "게시글 조회가 완료되지 않았습니다");
			mv.addObject("msg", e.getMessage());
			mv.addObject("url", "/board/list.gg");
			mv.setViewName("common/serviceFailed");
		}
		return mv;
	}

	public PageInfo getPageInfo(Integer currentPage, Integer totalCount) {
			int recordCountPerPage = 20;
			int naviCountPerPage = 10;
			int naviTotalCount;
			naviTotalCount = (int)Math.ceil((double)totalCount/recordCountPerPage);
			int startNavi = ((int)((double)currentPage/naviCountPerPage+0.9)-1)*naviCountPerPage+1;
			int endNavi = startNavi + naviCountPerPage - 1;
			if(endNavi > naviTotalCount) {
				endNavi = naviTotalCount;
			}
			PageInfo pInfo = new PageInfo(currentPage, totalCount, naviTotalCount, recordCountPerPage, naviCountPerPage, startNavi, endNavi);
			return pInfo;
		}

	public Map<String, Object> saveFile(HttpServletRequest request, MultipartFile uploadFile) throws Exception {
		Map<String, Object> fileMap = new HashMap<String, Object>();
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\buploadFiles";
		String fileName = uploadFile.getOriginalFilename();
		String extension
			= fileName.substring(fileName.lastIndexOf(".")+1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileRename = sdf.format(new Date(System.currentTimeMillis()))+"."+extension;
		File saveFolder = new File(savePath);
		if(!saveFolder.exists()) {
			saveFolder.mkdir();
		}
		File saveFile = new File(savePath+"\\"+fileRename);
		uploadFile.transferTo(saveFile);
		long fileLength = uploadFile.getSize();
		fileMap.put("fileName", fileName);
		fileMap.put("fileRename", fileRename);
		fileMap.put("filePath", "../resources/buploadFiles/"+fileRename);
		fileMap.put("fileLength", fileLength);
		return fileMap;
	}
	
	private void deleteFile(String fileRename, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String delPath = root + "\\buploadFiles\\" + fileRename;
		File delFile = new File(delPath);
		if(delFile.exists()) {
			delFile.delete();
		}
	}
}