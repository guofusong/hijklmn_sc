package edu.guosong.sc.hijklmndbserver.service;

import java.util.List;

import edu.guosong.sc.hijklmncommon.dto.PictureCategoryDTO;
import edu.guosong.sc.hijklmncommon.po.PictureCategory;

public interface IPictureCategoryService {

	List<PictureCategory> queryPictureCategoryList(PictureCategoryDTO pictureCategoryDTO);

	Integer addPictureCategory(PictureCategory pictureCategory);

	Integer deletePictureCategory(Integer categoryId);

	Integer updatePictureCategory(PictureCategory pictureCategory);

	// 添加图片数量
	Integer increasePictureCategoryPictureNumber(PictureCategory pictureCategory);

	// 减少图片数量
	Integer discreasePictureCategoryPictureNumber(PictureCategory pictureCategory);

}
