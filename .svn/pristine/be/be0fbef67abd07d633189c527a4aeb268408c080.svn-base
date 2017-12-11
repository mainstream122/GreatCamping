package com.ktds.camp.qna.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.camp.qna.service.QnaService;
import com.ktds.camp.qna.vo.QnaVO;

@Controller
public class QnaController {
	
	private QnaService qnaService;

	public void setQnaService(QnaService qnaService) {
		this.qnaService = qnaService;
	}
	
	@RequestMapping("/qnaList")
	public ModelAndView qnaList() {
		ModelAndView view = new ModelAndView();
		view.setViewName("qna/qnaList");
		view.addObject("qnaList", qnaService.readAllQnaList());
		
		return view;
	}
	
	@RequestMapping("/qnaView/{qnaId}")
	public ModelAndView qnaViewPage(@PathVariable int qnaId) {
		ModelAndView view = new ModelAndView("qna/qnaView");
		view.addObject("qna", "");
		
		return view;
	}
	
	@RequestMapping(value="/qnaWrite", method=RequestMethod.GET)
	public ModelAndView qnaWritePage() {
		ModelAndView view = new ModelAndView("qna/qnaWrite");
		return view;
	}
	
	@RequestMapping(value="/qnaWrite", method=RequestMethod.POST)
	public String qnaWriteSend(QnaVO qnaVO) {
		
		if ( qnaVO.getQnaSecretYn() == null ) {
			qnaVO.setQnaSecretYn("N");
		}
		
		qnaService.createQna(qnaVO);
		
		return "redirect:/qnaList";
	}
	

}
