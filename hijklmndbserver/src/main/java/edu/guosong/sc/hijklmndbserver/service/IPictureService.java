package edu.guosong.sc.hijklmndbserver.service;

import java.util.List;

import edu.guosong.sc.hijklmncommon.dto.PictureDTO;
import edu.guosong.sc.hijklmncommon.po.Picture;

public interface IPictureService {

	Picture queryPicture(PictureDTO pictureDTO);

	List<Picture> queryPictureList(PictureDTO pictureDTO);

	Picture selectByPrimaryKey(String mId);
	
	int addPicture(Picture picture);
	
	int like(String pictureId);
	
	int unLike(String pictureId);

}
