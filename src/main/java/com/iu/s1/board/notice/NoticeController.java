package com.iu.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	@ModelAttribute("boardName")
	public String getBoardName() {
		return "notice";
	}
	
	@GetMapping("list")
	public ModelAndView getBbsList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BbsDTO> noticeDTOs = noticeService.getBoardList(pager);
		mv.addObject("list", noticeDTOs);
		mv.setViewName("board/list");
		return mv;
	}
	
	
}
