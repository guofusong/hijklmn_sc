package edu.guosong.sc.hijklmndbserver.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.guosong.sc.hijklmncommon.dto.PictureCategoryDTO;
import edu.guosong.sc.hijklmncommon.po.PictureCategory;
import edu.guosong.sc.hijklmndbserver.mapper.PictureCategoryMapper;
import edu.guosong.sc.hijklmndbserver.service.IPictureCategoryService;

@Service("pictureCategoryService")
public class PictureCategoryServiceImpl implements IPictureCategoryService {

	@Resource
	private PictureCategoryMapper pictureCategoryMapper;

	@Override
	public List<PictureCategory> queryPictureCategoryList(PictureCategoryDTO pictureCategoryDTO) {
		return pictureCategoryMapper.queryList(pictureCategoryDTO);
	}

	@Override
	public Integer addPictureCategory(PictureCategory pictureCategory) {
		return pictureCategoryMapper.insertSelective(pictureCategory);
	}

	@Override
	public Integer deletePictureCategory(Integer categoryId) {
		return pictureCategoryMapper.deleteByPrimaryKey(categoryId);
	}

	@Override
	public Integer updatePictureCategory(PictureCategory pictureCategory) {
		return pictureCategoryMapper.updateByPrimaryKeySelective(pictureCategory);
	}

	@Override
	public Integer increasePictureCategoryPictureNumber(PictureCategory pictureCategory) {
		return pictureCategoryMapper.increasePictureCategoryPictureNumber(pictureCategory);
	}

	@Override
	public Integer discreasePictureCategoryPictureNumber(PictureCategory pictureCategory) {
		return pictureCategoryMapper.discreasePictureCategoryPictureNumber(pictureCategory);
	}

}
