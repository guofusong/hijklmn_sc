package edu.guosong.sc.hijklmndbserver.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.guosong.sc.hijklmncommon.dto.PictureDTO;
import edu.guosong.sc.hijklmncommon.po.Picture;
import edu.guosong.sc.hijklmndbserver.mapper.PictureMapper;
import edu.guosong.sc.hijklmndbserver.service.IPictureService;

@Service("pictureService")
public class PictureServiceImpl implements IPictureService {

	@Resource
	private PictureMapper pictureMapper;

	@Override
	public Picture queryPicture(PictureDTO pictureDTO) {
		return pictureMapper.query(pictureDTO);
	}

	@Override
	public List<Picture> queryPictureList(PictureDTO pictureDTO) {
		return pictureMapper.queryList(pictureDTO);
	}

	@Override
	public int addPicture(Picture picture) {
		return pictureMapper.insert(picture);
	}

	@Override
	public Picture selectByPrimaryKey(String mId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int like(String pictureId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int unLike(String pictureId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
