package edu.guosong.sc.hijklmndbserver.mapper;

import java.util.List;

import edu.guosong.sc.hijklmncommon.dto.RequestDTO;

public interface CommonMapper<T> {

	int deleteByPrimaryKey(Integer mId);

	int insert(T t);

	int insertSelective(T t);

	T selectByPrimaryKey(Integer mId);
	
	T selectByPrimaryKey(String mId);
	
	int updateByPrimaryKeySelective(T t);

	int updateByPrimaryKey(T t);

	List<T> queryList(RequestDTO requestDTO);

	T query(RequestDTO requestDTO);

}
