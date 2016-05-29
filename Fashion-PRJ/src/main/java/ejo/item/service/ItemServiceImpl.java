package ejo.item.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejo.repository.mapper.ItemMapperImpl;
import ejo.repository.vo.ItemFileVO;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapperImpl dao;

	@Override
	public Map<String, Object> detailItem(ItemFileVO item) throws Exception {
		List<ItemFileVO> itemFile = dao.selectItemFile(item);
		Map<String, Object> result = new HashMap<>();
		result.put("item", itemFile);
		return result;
	}
}
