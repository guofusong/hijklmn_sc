package edu.guosong.sc.hijklmndbserver.mapper;

import edu.guosong.sc.hijklmncommon.po.Picture;

public interface PictureMapper extends CommonMapper<Picture> {
	
	int like(String pictureId);
	
	int unLike(String pictureId);
	
}