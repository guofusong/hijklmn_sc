package edu.guosong.sc.hijklmndbserver.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.guosong.sc.hijklmncommon.dto.PictureCommentDTO;
import edu.guosong.sc.hijklmncommon.dto.RequestResult;
import edu.guosong.sc.hijklmncommon.param.WebOption;
import edu.guosong.sc.hijklmncommon.po.PictureComment;
import edu.guosong.sc.hijklmncommon.util.JSONUtil;
import edu.guosong.sc.hijklmndbserver.common.ControllerHandler;
import edu.guosong.sc.hijklmndbserver.service.IPictureCommentService;

@RestController
@RequestMapping("/picture")
public class PictureCommentController {

	@Autowired
	private IPictureCommentService pictureCommentService;

	@RequestMapping(value = "/queryPictureComment", method = RequestMethod.POST)
	public RequestResult queryPictureComment(@RequestBody PictureCommentDTO pictureCommentDTO) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(RequestResult requestResult) throws Exception {
				requestResult.put(WebOption.ITEMS,
						JSONUtil.bean2Str(pictureCommentService.queryPictureCommentList(pictureCommentDTO)));
			}
		});
	}
	
	@RequestMapping(value="/addPictureComment",method=RequestMethod.POST)
	public RequestResult addPictureComment(@RequestBody PictureComment pictureComment) {
		return ControllerProxy.handler(new ControllerHandler() {

			@Override
			public void assemble(RequestResult requestResult) throws Exception {
				pictureComment.setIsvalid(1);
				pictureComment.setFavourNumber(0);
				pictureComment.setWriteDate(new Date());
				pictureCommentService.addPictureComment(pictureComment);
				requestResult.put(WebOption.ITEM, JSONUtil.bean2Str(pictureComment));
			}
			
		});
	}
	
	@RequestMapping(value="/likePictureComment",method=RequestMethod.POST)
	public RequestResult likePictureComment(int commentId) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(RequestResult requestResult) throws Exception {
				pictureCommentService.like(commentId);
				PictureComment pictureComment = pictureCommentService.selectByPrimaryKey(commentId);
				if(pictureComment == null) {
					requestResult.put(WebOption.ITEM, 0);
				}else {
					requestResult.put(WebOption.ITEM, pictureComment.getFavourNumber());
				}
			}
		});
	}
	
	@RequestMapping(value="/unLikePictureComment",method=RequestMethod.POST)
	public RequestResult unLikePictureComment(int commentId) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(RequestResult requestResult) throws Exception {
				pictureCommentService.unLike(commentId);
				PictureComment pictureComment = pictureCommentService.selectByPrimaryKey(commentId);
				if(pictureComment == null) {
					requestResult.put(WebOption.ITEM, 0);
				}else {
					requestResult.put(WebOption.ITEM, pictureComment.getFavourNumber());
				}
			}
		});
	}

}
