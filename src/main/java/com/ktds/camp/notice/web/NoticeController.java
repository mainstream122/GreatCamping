package com.ktds.camp.notice.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.camp.notice.service.NoticeService;
import com.ktds.camp.notice.vo.NoticeSearchVO;
import com.ktds.camp.notice.vo.NoticeVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;
import io.github.seccoding.web.pager.explorer.PageOption;


@Controller
public class NoticeController {
	
	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@RequestMapping("/customer/noticeWrite")
	public String writeNoticePage() {
		return "notice/noticeWrite";
	}
	
	@RequestMapping("/customer/notice")
	public ModelAndView noticeListPage(NoticeSearchVO noticeSearchVO) {
		//List<NoticeVO> listNoticeVO = noticeService.readAllNotice(noticeSearchVO);
		//int allNoticeCount = noticeService.readAllNoticeCount();
		PageExplorer pageExplorer = noticeService.readAllNotice(noticeSearchVO);
		
		//int totalCount = pageExplorer.getTotalCount();
		 
		PageOption option = new PageOption()
				.formId("pageForm")
                .link("pageNo")
                .prev("[이전]")
                .next("[다음]")
                .pageFormat("@");
		
		String pageNavi = pageExplorer.setData(option)
				// 이전 버튼
					.prevGroup((prevGroupPageNumber, prev) -> {
						return "<a style='width:20px; margin:0px;' onclick=\"movePage('" + prevGroupPageNumber + "')\">" + prev + "</a>";
					})
				
					// 다음 버튼
					.nextGroup((nextGroupPageNumber, next) -> {
						return "<a style='width:20px; margin:0px;' onclick=\"movePage('" + nextGroupPageNumber + "')\">" + next + "</a>";
					})
					// 페이지 버튼
					.pages((pageNo, pageFormat) -> {
						return "<a style='margin-right:5px; border:1px solid #000; padding:5px;' onclick=\"movePage('" + pageNo + "')\">" + pageFormat + "</a>";
					})
					.highlightClassName("selectPage")
					.make();
		
		ModelAndView view = new ModelAndView();
		view.setViewName("notice/noticeList");
		view.addObject("noticeSearchVO",noticeSearchVO);
		view.addObject("pageNavi",pageNavi);
		view.addObject("noticeList", noticeService.readAllNotice(noticeSearchVO));
		
		
		//view.addObject("listNoticeVO", listNoticeVO);
		//view.addObject("allNoticeCount", allNoticeCount);
		
		return view;
	}
	
/*	@RequestMapping("/chart/albumInfo/{musicId}")
	public ModelAndView viewOneAlbumInfo(@PathVariable int musicId) {
		List<ChartVO> chartVOList = chartService.readOneAlbum(musicId);
		int artistId = chartService.readOneAlbum(musicId).get(0).getArtistId();
		List<ChartVO> musicList = chartService.readAllMusicOfOneArtist(artistId);

		ModelAndView view = new ModelAndView();
		view.setViewName("chart/albumInfo");
		view.addObject("chartVOList", chartVOList);
		view.addObject("musicList", musicList);

		return view;
	}*/
	@RequestMapping("/customer/notice/delete/{noticeId}")
	public String doDelete(@PathVariable int noticeId) {
		NoticeVO noticeVO = new NoticeVO();
		
		boolean isSuccess1 = noticeService.deleteNotice(noticeId);
		//boolean isSuccess2 = noticeService.updateNotice(noticeVO);
		
		return "redirect:/customer/noticeWrite";
		
	}
/*	@RequestMapping("/customer/notice/updata/{noticeId}")
	public String doUpdate(@PathVariable int noticeId) {
		boolean isSuccess = noticeSevice.
	}
	*/

}
