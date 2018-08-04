package edu.guosong.sc.hijklmnstage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.guosong.sc.hijklmncommon.dto.PictureCommentDTO;
import edu.guosong.sc.hijklmncommon.dto.PictureDTO;
import edu.guosong.sc.hijklmncommon.dto.RequestResult;
import edu.guosong.sc.hijklmncommon.param.RequestUrlOption;
import edu.guosong.sc.hijklmncommon.param.ResultParam;
import edu.guosong.sc.hijklmncommon.param.WebOption;
import edu.guosong.sc.hijklmncommon.po.Picture;
import edu.guosong.sc.hijklmncommon.po.PictureComment;
import edu.guosong.sc.hijklmncommon.util.JSONUtil;
import edu.guosong.sc.hijklmnstage.common.ControllerHandler;
import edu.guosong.sc.hijklmnstage.common.RequestConfig;
import edu.guosong.sc.hijklmnstage.common.RequestOption;

@Controller
@RequestMapping("/picture")
public class PictureController {

	@Autowired
	private RequestConfig requestConfig;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/view")
	public ModelAndView view(HttpServletRequest request, RedirectAttributes redirectAttributes, PictureDTO pictureDTO) {
		return ControllerProxy.queryList(new ControllerHandler() {
			@Override
			public void assemble(ModelAndView modelAndView, RedirectAttributes redirectAttributes) throws Exception {
				modelAndView.setViewName("picture");
				ResponseEntity<RequestResult> responseEntity = restTemplate.postForEntity(
						requestConfig.getHijklmndbserver() + RequestUrlOption.DB_PICTURE_QUERYPICTURE, pictureDTO,
						RequestResult.class);

				RequestResult requestResult = responseEntity.getBody();
				if (requestResult.getCode() != 1) {
					redirectAttributes.addFlashAttribute(WebOption.RESULT, ResultParam.syserr.desc());
					modelAndView.setViewName(RequestOption.ERROR500);
					return;
				}

				modelAndView.addObject(WebOption.ITEMS,
						JSONUtil.str2List(requestResult.get(WebOption.ITEMS), List.class));

				modelAndView.addObject(WebOption.MEDIASERVER, requestConfig.getHijklmnmediaserver());

			}
		}, pictureDTO, request, redirectAttributes);
	}

	@RequestMapping("/info/{picId}")
	public ModelAndView info(HttpServletRequest request, RedirectAttributes redirectAttributes,
			@PathVariable("picId") String picId) {
		return ControllerProxy.queryList(new ControllerHandler() {
			@Override
			public void assemble(ModelAndView modelAndView, RedirectAttributes redirectAttributes) throws Exception {
				PictureDTO pictureDTO = new PictureDTO();
				pictureDTO.setPicId(picId);
				pictureDTO.setIsvalid(1);
				modelAndView.setViewName("pictureInfo");
				ResponseEntity<RequestResult> responseEntity = restTemplate.postForEntity(
						requestConfig.getHijklmndbserver() + RequestUrlOption.DB_PICTURE_QUERYPICTURE, pictureDTO,
						RequestResult.class);

				RequestResult requestResult = responseEntity.getBody();

				if (requestResult.getCode() != 1) {
					redirectAttributes.addFlashAttribute(WebOption.RESULT, ResultParam.syserr.desc());
					modelAndView.setViewName(RequestOption.ERROR500);
					return;
				}

				@SuppressWarnings("unchecked")
				List<Picture> pictures = (List<Picture>) JSONUtil.str2List(requestResult.get(WebOption.ITEMS),
						List.class);

				if (pictures == null || pictures.size() == 0) {
					modelAndView.addObject(WebOption.ITEM, new Picture());
				} else {
					modelAndView.addObject(WebOption.ITEM, pictures.get(0));
				}

				PictureCommentDTO pictureCommentDTO = new PictureCommentDTO();
				pictureCommentDTO.setIsvalid(1);
				pictureCommentDTO.setPictureId(picId);
				responseEntity = restTemplate.postForEntity(
						requestConfig.getHijklmndbserver() + RequestUrlOption.DB_PICTURE_QUERYPICTURECOMMENT,
						pictureCommentDTO, RequestResult.class);

				requestResult = responseEntity.getBody();

				if (requestResult.getCode() != 1) {
					redirectAttributes.addFlashAttribute(WebOption.RESULT, ResultParam.syserr.desc());
					modelAndView.setViewName(RequestOption.ERROR500);
					return;
				}

				@SuppressWarnings("unchecked")
				List<PictureComment> pictureComments = (List<PictureComment>) JSONUtil
						.str2List(requestResult.get(WebOption.ITEMS), List.class);

				modelAndView.addObject(WebOption.ITEMS, pictureComments);

				modelAndView.addObject(WebOption.MEDIASERVER, requestConfig.getHijklmnmediaserver());

			}
		}, null, request, redirectAttributes);
	}
	
//	@RequestMapping("/addPictureComment")
//	@ResponseBody
//	public PictureComment addPictureComment(HttpServletRequest request) {
//		return ControllerProxy.handler(new ControllerHandler() {
//
//			@Override
//			public void assemble(ModelAndView modelAndView, RedirectAttributes redirectAttributes) throws Exception {
//				
//			}}, null, request, null);
//	}
	

}
