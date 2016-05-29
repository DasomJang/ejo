package ejo.repository.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ejo.repository.vo.ItemFileVO;

@Repository
public class ItemMapperImpl implements ItemMapper {

	@Autowired
	private SqlSessionTemplate session;
	private static final String ITEM_MAPPER_NAMESPACE = "ejo.repository.mapper.ItemMapper";
	
	public List<ItemFileVO> selectItemFile(ItemFileVO item) throws Exception {
		return session.selectList(ITEM_MAPPER_NAMESPACE + ".selectItemFile", item);
	}

}
