package edu.guosong.sc.hijklmndbserver.mapper;

import edu.guosong.sc.hijklmncommon.po.PictureComment;

public interface PictureCommentMapper extends CommonMapper<PictureComment> {
	
	int like(int commentId);
	
	int unLike(int commentId);
	
}