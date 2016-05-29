package ejo.item.service;

import java.util.Map;

import ejo.repository.vo.ItemFileVO;

public interface ItemService {
	public Map<String, Object> detailItem(ItemFileVO item) throws Exception;
}
