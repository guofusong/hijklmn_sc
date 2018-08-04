package edu.guosong.sc.hijklmndbserver.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.guosong.sc.hijklmncommon.dto.PictureCommentDTO;
import edu.guosong.sc.hijklmncommon.po.PictureComment;
import edu.guosong.sc.hijklmndbserver.mapper.PictureCommentMapper;
import edu.guosong.sc.hijklmndbserver.service.IPictureCommentService;

@Service("pictureCommentService")
public class PictureCommentServiceImpl implements IPictureCommentService {

	@Resource
	private PictureCommentMapper pictureCommentMapper;

	@Override
	public List<PictureComment> queryPictureCommentList(PictureCommentDTO pictureCommentDTO) {
		return pictureCommentMapper.queryList(pictureCommentDTO);
	}

	@Override
	public int addPictureComment(PictureComment pictureComment) {
		return pictureCommentMapper.insertSelective(pictureComment);
	}

	@Override
	public int like(Integer commentId) {
		return pictureCommentMapper.like(commentId);
	}

	@Override
	public int unLike(Integer commentId) {
		return pictureCommentMapper.unLike(commentId);
	}

	@Override
	public PictureComment selectByPrimaryKey(int commentId) {
		return pictureCommentMapper.selectByPrimaryKey(commentId);
	}

}
