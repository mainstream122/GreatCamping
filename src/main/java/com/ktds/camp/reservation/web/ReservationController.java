package com.ktds.camp.reservation.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.camp.reservation.service.ReservationService;
import com.ktds.camp.reservation.vo.DateData;
import com.ktds.camp.reservation.vo.ReservationVO;

@Controller
public class ReservationController {
	
	private ReservationService reservationService;
	
	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	//예약의 달력 등록창
	@RequestMapping("/reservation/calendar")
	public ModelAndView viewCalendar() {
//		Date 
//		Timestamp date = new Timestamp(String.format(arg0, arg1));
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String[] cells = date.split("-");
		String year = cells[0];
		String month = cells[1];
		String day = cells[2];
		
		System.out.println("333" + date);
		
		
		ModelAndView view = new ModelAndView();
		view.addObject("year", year);
		view.addObject("month", month);
		view.addObject("day", day);
		view.setViewName("reservation/calendar");
		
		return view;
	}
	
	//예약의 달력2
	@RequestMapping("/reservation/reservationCalendar")
	public ModelAndView viewListCalendar() {
		
		List<ReservationVO> reservationList = reservationService.readAllReservation();
		List<Map<String, String>> reservation = new ArrayList<Map<String, String>>();
		
		
		for(int i=0;i<reservationList.size();i++) {
			Map<String, String> map = new HashMap<>();
			
			map.put("mId", reservationList.get(i).getMemberId());
			map.put("rCheckIn", reservationList.get(i).getrCheckIn());
			map.put("rCheckOut", reservationList.get(i).getrCheckOut());
			
			reservation.add(map);
		}
		
		reservation.forEach(System.out::println);
		System.out.println(reservationList.get(0).getrId());
		
		ModelAndView view = new ModelAndView();
		view.addObject("reservation", reservation);
		view.setViewName("reservation/reservationCalendar");
		
		return view;
	}
	
	@RequestMapping("/calendar")
	@ResponseBody
	public List<Map<String, String>> calendar() {
		List<ReservationVO> reservationList = reservationService.readAllReservation();
		List<Map<String, String>> reservation = new ArrayList<Map<String, String>>();
		
		
		for(int i=0;i<reservationList.size();i++) {
			Map<String, String> map = new HashMap<>();
			
			map.put("mId", reservationList.get(i).getMemberId());
			map.put("rCheckIn", reservationList.get(i).getrCheckIn());
			map.put("rCheckOut", reservationList.get(i).getrCheckOut());
			
			reservation.add(map);
		}
		
		return reservation;
	}
	
	//예약의 조건 등록창
	@RequestMapping("/reservation/condition")
	public String viewCondition() {
		return "reservation/condition";
	}
	
	//예약의 상세확인 등록창
	@RequestMapping("/reservation/orderInfo")
	public String viewOrderInfo() {
		return "/reservation/orderInfo";
	}
	
	
	@RequestMapping(value = "calendar.do", method = RequestMethod.GET)
	public String calendar(Model model, HttpServletRequest request, DateData dateData){
		
		Calendar cal = Calendar.getInstance();
		DateData calendarData;
		//검색 날짜
		if(dateData.getDate().equals("")&&dateData.getMonth().equals("")){
			dateData = new DateData(String.valueOf(cal.get(Calendar.YEAR)),String.valueOf(cal.get(Calendar.MONTH)),String.valueOf(cal.get(Calendar.DATE)),null);
		}
		//검색 날짜 end

		Map<String, Integer> today_info =  dateData.today_info(dateData);
		List<DateData> dateList = new ArrayList<DateData>();
		
		//실질적인 달력 데이터 리스트에 데이터 삽입 시작.
		//일단 시작 인덱스까지 아무것도 없는 데이터 삽입
		for(int i=1; i<today_info.get("start"); i++){
			calendarData= new DateData(null, null, null, null);
			dateList.add(calendarData);
		}
		
		//날짜 삽입
		for (int i = today_info.get("startDay"); i <= today_info.get("endDay"); i++) {
			if(i==today_info.get("today")){
				calendarData= new DateData(String.valueOf(dateData.getYear()), String.valueOf(dateData.getMonth()), String.valueOf(i), "today");
			}else{
				calendarData= new DateData(String.valueOf(dateData.getYear()), String.valueOf(dateData.getMonth()), String.valueOf(i), "normal_date");
			}
			dateList.add(calendarData);
		}

		//달력 빈곳 빈 데이터로 삽입
		int index = 7-dateList.size()%7;
		
		if(dateList.size()%7!=0){
			
			for (int i = 0; i < index; i++) {
				calendarData= new DateData(null, null, null, null);
				dateList.add(calendarData);
			}
		}
		System.out.println(dateList);
		
		//배열에 담음
		model.addAttribute("dateList", dateList);		//날짜 데이터 배열
		model.addAttribute("today_info", today_info);
		return "calendar";
	}
	
	public ModelAndView calendarTest() {
		
		int[] month = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		
		ModelAndView view = new ModelAndView();
		view.addObject("");
		view.setViewName("");
		
		return view;
	}	
	
	public boolean test() {
		String value = "121";
		StringBuffer buffer = new StringBuffer(value);
		if(buffer.equals(buffer.reverse())) {
			return true;
		}		
		return false;
	}

}