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
			}
			if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				Map<String, Object> bMap = this.saveFile(request, uploadFile);
				board.setBoardFilename((String)bMap.get("fileName"));
				board.setBoardFileRename((String)bMap.get("fileRename"));
				board.setBoardFilepath((String)bMap.get("filePath"));
				board.setBoardFileLength((long)bMap.get("fileLength"));
			}
			int result = bService.insertBoard(board);
			mv.setViewName("redirect:/board/list.gg");
		} catch (Exception e) {
			mv.addObject("msg", "게시글 등록이 완료되지 않았습니다");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/serviceFailed");
		}	
		return mv;
	}
	
	@RequestMapping(value="/detail.gg", method=RequestMethod.GET)
	public ModelAndView showBoardDetail(ModelAndView mv
			, @RequestParam("boardNo") Integer boardNo) {
		try {
			Board boardOne = bService.selectBoardNo(boardNo);
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
				mv.addObject("url", "/board/list.kh");
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
	
	
	
	
	
	
	
	
	public PageInfo getPageInfo(Integer currentPage, Integer totalCount) {
			int recordCountPerPage = 10;
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
	
	
//	public Map<String, Object> saveFile(HttpServletRequest request, MultipartFile uploadFile) throws Exception {
//		Map<String, Object> fileMap = new HashMap<String, Object>();
//		String root = request.getSession().getServletContext().getRealPath("resources");
//		String savePath = root + "\\buploadFiles";
//		String fileName = uploadFile.getOriginalFilename();
//		String extension = fileName.substring(fileName.lastIndexOf(".")+1);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//		String fileRename = sdf.format(new Date(System.currentTimeMillis())) + "." + extension;
//		File saveFolder = new File(savePath);
//		if(!saveFolder.exists()) {
//			saveFolder.mkdir();
//		}
//		// 파일 저장
//		File saveFile = new File(savePath+"\\"+fileRename);
//		uploadFile.transferTo(saveFile);
//		long fileLength = uploadFile.getSize();
//		// 파일 정보 리턴
//		fileMap.put("fileName", fileName);
//		fileMap.put("fileRename", fileRename);
//		fileMap.put("filePath", "../resources/buploadFiles/"+fileRename);
//		fileMap.put("fileLength", fileLength);
//		return fileMap;
//	}
	private Map<String, Object> saveFile(HttpServletRequest request, MultipartFile uploadFile) throws Exception {
		
		Map<String, Object> fileMap = new HashMap<String, Object>();
		// resources 경로 구하기
		String root = request.getSession().getServletContext().getRealPath("resources");
		// 파일 저장경로 구하기
		String savePath = root + "\\buploadFiles";
		// 파일 이름 구하기
		String fileName = uploadFile.getOriginalFilename();
		// 파일 확장자 구하기
		String extension = uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf(".")+1); //.을 포함하지않으려 +1
		// 시간으로 파일 리네임
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHss");
		String fileRename =sdf.format(new Date(System.currentTimeMillis()))+"."+extension;
		
		// 파일 저장 전 폴더 만들기
		File saveFolder = new File(savePath);
		if(!saveFolder.exists()) {
			saveFolder.mkdir();
		}
		// 파일 저장
		File saveFile = new File(savePath+"\\"+fileRename);
		uploadFile.transferTo(saveFile);
		long fileLength = uploadFile.getSize(); // 여기 long이라 위에 object 여기 String쓰면 위에 String으로 쓸수는 있음
		// 파일 정보 리턴
		fileMap.put("fileName", fileName);
		fileMap.put("fileRename", fileRename);
		fileMap.put("filePath", "../resources/buploadFiles"+fileRename);
		fileMap.put("fileLength", fileLength);
	
		return fileMap;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}