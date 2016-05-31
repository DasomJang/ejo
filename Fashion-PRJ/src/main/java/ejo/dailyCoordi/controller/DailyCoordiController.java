package ejo.dailyCoordi.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ejo.dailyCoordi.service.DailyCoordiService;
import ejo.repository.vo.BoardVO;
import ejo.repository.vo.DailyCoordiVO;

@Controller
@RequestMapping("/dailyCoordi")
public class DailyCoordiController {
	
	@Autowired
	private DailyCoordiService dailyCoordiService;
	
	@RequestMapping("/calendar.do")
	public void detailItem(
			@RequestParam(value="month", required=false) Integer month, 
			@RequestParam(value="year", required=false) Integer year, 
			@RequestParam(value="action", required=false) Integer action, BoardVO board, Model model) throws Exception {
		
		int currYear = 0; // if it is not retrieved from incoming URL (month=) then it is set to current year
		int currMonth = 0; // same as year

		//build 2 calendars
		Calendar c = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();

		if (action == null) // Check to see if we should set the year and month to the current
		{
			currMonth = c.get(Calendar.MONTH);
			currYear = c.get(Calendar.YEAR);
			cal.set(currYear, currMonth, 1);
		}

		else {
			currMonth = month;
			currYear = year;
			cal.set(currYear, currMonth, 1);
			if (action == 1) {
				cal.add(Calendar.MONTH, 1);
			} else {
				cal.add(Calendar.MONTH, -1);
			}
			currMonth = cal.get(Calendar.MONTH);
			currYear = cal.get(Calendar.YEAR);
		}

//		DailyCoordiVO dailyCoordiVO = new DailyCoordiVO();
//		dailyCoordiVO.setLastDate(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//		List<BoardVO>calListCoordi = dailyCoordiService.selectDailyCoordi(board);
		String cCalDate = getDateName(cal.get(Calendar.MONTH)) + " " + cal.get(Calendar.YEAR);
		model.addAttribute("cCalDate", cCalDate);
		model.addAttribute("currYear", currYear);
		model.addAttribute("currMonth", currMonth);
		model.addAttribute("boxSize", "100");
		model.addAttribute("week", cal.get(Calendar.DAY_OF_WEEK));
		model.addAttribute("lastDate", cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//		model.addAttribute("calListCoordi",calListCoordi);

	}

	public boolean isDate(int m, int d, int y) {
		m -= 1;
		Calendar c = Calendar.getInstance();
		c.setLenient(false);

		try {
			c.set(y, m, d);
			Date dt = c.getTime();
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}
	
	public String getDateName(int monthNumber) {
		String strReturn = "";
		switch (monthNumber) {
		case 0:
			strReturn = "January";
			break;
		case 1:
			strReturn = "February";
			break;
		case 2:
			strReturn = "March";
			break;
		case 3:
			strReturn = "April";
			break;
		case 4:
			strReturn = "May";
			break;
		case 5:
			strReturn = "June";
			break;
		case 6:
			strReturn = "July";
			break;
		case 7:
			strReturn = "August";
			break;
		case 8:
			strReturn = "September";
			break;
		case 9:
			strReturn = "October";
			break;
		case 10:
			strReturn = "November";
			break;
		case 11:
			strReturn = "December";
			break;
		}
		return strReturn;
	}
}
