package com.iu.s1.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public ModelAndView fixException() {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("message", "관리자에게 문의하세요");
		mv.setViewName("common/error_500");
		return mv;
	}
}
