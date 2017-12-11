package com.ktds.camp.main.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.camp.notice.service.NoticeService;
import com.ktds.camp.notice.vo.NoticeSearchVO;
import com.ktds.camp.notice.vo.NoticeVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

@Controller
public class MainController{
	
	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@RequestMapping("/")
	public ModelAndView viewIndexPage() {
		ModelAndView result = new ModelAndView();
		result.setViewName("main/index");
		result.addObject("isMainPage","TRUE");
		
		NoticeSearchVO noticeSearchVO = new NoticeSearchVO();
		noticeSearchVO.setPageNo("0");
		PageExplorer noticeExplorer = noticeService.readAllNotice(noticeSearchVO);
		List<NoticeVO> noticeList = noticeExplorer.getList();
		result.addObject("noticeList", noticeList);
		
		return result;
	}
	
	
	@RequestMapping("/main")
	public String footerPage() {
		return "common/footer/footer";
	}
}
