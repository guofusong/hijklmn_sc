package edu.guosong.sc.hijklmndbserver.service;

import java.util.List;

import edu.guosong.sc.hijklmncommon.dto.PictureCommentDTO;
import edu.guosong.sc.hijklmncommon.po.PictureComment;

public interface IPictureCommentService {

	List<PictureComment> queryPictureCommentList(PictureCommentDTO pictureCommentDTO);
	
	int addPictureComment(PictureComment pictureComment);
	
	int like(Integer commentId);
	
	int unLike(Integer commentId);
	
	PictureComment selectByPrimaryKey(int commentId);
	
}
