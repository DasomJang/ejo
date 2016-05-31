package ejo.dailyCoordi.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejo.repository.mapper.DailyCoordiMapper;
import ejo.repository.vo.BoardVO;
import ejo.repository.vo.DailyCoordiVO;


@Service
public class DailyCoordiServiceImpl implements DailyCoordiService {
	
	@Autowired
	private DailyCoordiMapper dao;

//	@Override
//	public List<BoardVO> selectDailyCoordi(BoardVO board) throws Exception {
//		
//		int lastDay = board.getDailyCoordi().getLastDate();
//		List<BoardVO> calList = new ArrayList<>();
//		for (int i = 1; i <= lastDay; i++) {
//			calList.add(null);
//		}
//		return null;
//	}
	
}
