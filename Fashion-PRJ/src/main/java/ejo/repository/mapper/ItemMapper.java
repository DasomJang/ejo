package ejo.repository.mapper;

import java.util.List;

import ejo.repository.vo.ItemFileVO;

public interface ItemMapper {
	public List<ItemFileVO> selectItemFile(ItemFileVO item) throws Exception;
}
