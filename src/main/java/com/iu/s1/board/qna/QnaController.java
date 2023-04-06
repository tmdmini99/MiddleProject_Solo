package com.iu.s1.board.qna;

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
@RequestMapping(value = "/qna/*")
public class QnaController {

	
	@Autowired
	private QnaService qnaService;
	
	
	@ModelAttribute("boardName")
	public String getBoardName() {
		return "qna";
	}
	@GetMapping("list")
	public ModelAndView getBbsList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<QnaDTO>  ar= qnaService.getBoardList(pager);
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		return mv;
	}
	@GetMapping("detail")
	public ModelAndView getBoardDetail(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		
		mv.setViewName("board/detail");
		return mv;
	}
}
