package edu.guosong.sc.hijklmndbserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.guosong.sc.hijklmncommon.dto.PictureDTO;
import edu.guosong.sc.hijklmncommon.dto.RequestResult;
import edu.guosong.sc.hijklmncommon.param.WebOption;
import edu.guosong.sc.hijklmncommon.po.Picture;
import edu.guosong.sc.hijklmncommon.util.JSONUtil;
import edu.guosong.sc.hijklmndbserver.common.ControllerHandler;
import edu.guosong.sc.hijklmndbserver.service.IPictureService;

@RestController
@RequestMapping("/picture")
public class PictureController {

	@Autowired
	private IPictureService pictureService;

	@RequestMapping(value = "/addPicture", method = RequestMethod.POST)
	public RequestResult addPicture(@RequestBody Picture picture) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(RequestResult requestResult) {
				requestResult.put(WebOption.RESULT, pictureService.addPicture(picture));
			}
		});
	}

	@RequestMapping(value = "/queryPicture", method = RequestMethod.POST)
	public RequestResult queryPicture(@RequestBody PictureDTO pictureDTO) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(RequestResult requestResult) throws Exception {
				requestResult.put(WebOption.ITEMS, JSONUtil.bean2Str(pictureService.queryPictureList(pictureDTO)));
			}
		});
	}
	
	@RequestMapping(value = "/likePicture", method = RequestMethod.POST)
	public RequestResult likePicture(String pictureId) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(RequestResult requestResult) throws Exception {
				pictureService.like(pictureId);
				Picture picture = pictureService.selectByPrimaryKey(pictureId);
				if(picture == null) {
					requestResult.put(WebOption.ITEM, 0);
				}else {
					requestResult.put(WebOption.ITEM, picture.getFavourNumber());
				}
			}
		});
	}

	@RequestMapping(value = "/unLikePicture", method = RequestMethod.POST)
	public RequestResult unLikePicture(String pictureId) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(RequestResult requestResult) throws Exception {
				pictureService.unLike(pictureId);
				Picture picture = pictureService.selectByPrimaryKey(pictureId);
				if(picture == null) {
					requestResult.put(WebOption.ITEM, 0);
				}else {
					requestResult.put(WebOption.ITEM, picture.getFavourNumber());
				}
			}
		});
	}
	
}
