package edu.guosong.sc.hijklmnadmin.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.guosong.sc.hijklmnadmin.common.ControllerHandler;
import edu.guosong.sc.hijklmnadmin.common.RequestConfig;
import edu.guosong.sc.hijklmnadmin.common.RequestOption;
import edu.guosong.sc.hijklmncommon.dto.MediaDTO;
import edu.guosong.sc.hijklmncommon.dto.PictureCategoryDTO;
import edu.guosong.sc.hijklmncommon.dto.PictureDTO;
import edu.guosong.sc.hijklmncommon.dto.RequestResult;
import edu.guosong.sc.hijklmncommon.param.MediaType;
import edu.guosong.sc.hijklmncommon.param.RequestUrlOption;
import edu.guosong.sc.hijklmncommon.param.ResultParam;
import edu.guosong.sc.hijklmncommon.param.StringOption;
import edu.guosong.sc.hijklmncommon.param.WebOption;
import edu.guosong.sc.hijklmncommon.po.Picture;
import edu.guosong.sc.hijklmncommon.util.EncodeUtil;
import edu.guosong.sc.hijklmncommon.util.JSONUtil;
import edu.guosong.sc.hijklmncommon.util.StringUtil;

@Controller
@RequestMapping("/picture")
public class PictureController {

	@Autowired
	private RequestConfig requestConfig;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/addPicturePage")
	public ModelAndView addPicturePage(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
				modelAndView.setViewName("addPicturePage");
				PictureCategoryDTO pictureCategoryDTO = new PictureCategoryDTO();
				pictureCategoryDTO.setIsvalid(1);
				ResponseEntity<RequestResult> responseEntity = restTemplate.postForEntity(
						requestConfig.getHijklmndbserver() + RequestUrlOption.DB_PICTURE_VIEWPICTURECATEGORY,
						pictureCategoryDTO, RequestResult.class);

				RequestResult requestResult = responseEntity.getBody();
				if (requestResult.getCode() != 1) {
					modelAndView.setViewName(RequestOption.ERROR500);
					return;
				}
				modelAndView.addObject(WebOption.PICTURECATEGORY,
						JSONUtil.str2List(requestResult.get(WebOption.ITEMS), List.class));
			}
		}, null, request, redirectAttributes);
	}

	@RequestMapping("/addPicture")
	public ModelAndView addPicture(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes, MultipartFile image, Picture picture) {
		return ControllerProxy.handler(new ControllerHandler() {

			@Override
			public void assemble(ModelAndView modelAndView, RedirectAttributes redirectAttributes) throws IOException {

				String filename = image.getOriginalFilename();
				String data = EncodeUtil.encode(image.getBytes());

				MediaDTO mediaDTO = new MediaDTO();

				mediaDTO.setData(data);
				mediaDTO.setMediaType(MediaType.image.name());
				mediaDTO.setSuffix(StringUtil.generatorSuffix(filename, StringOption.SPLITDOT));

				ResponseEntity<RequestResult> responseEntity = restTemplate.postForEntity(
						requestConfig.getHijklmnmediaserver() + RequestUrlOption.MEDIA_UPLOAD, mediaDTO,
						RequestResult.class);

				RequestResult requestResult = responseEntity.getBody();
				if (requestResult.getCode() != 1) {
					redirectAttributes.addFlashAttribute(WebOption.RESULT, ResultParam.syserr.desc());
					modelAndView.setViewName(RequestOption.REDIRECTHOME);
					return;
				}

				picture.setPicId(StringUtil.generatorRandom20l());
				picture.setIsvalid(1);
				picture.setBrowseTimes(0);
				picture.setFavourNumber(0);
				picture.setOnlineDatetime(new Date());
				picture.setPicUrl(requestResult.get(WebOption.PATH).toString());
				picture.setPicName(requestResult.get(WebOption.NAME).toString());
				ResponseEntity<RequestResult> responseEntity1 = restTemplate.postForEntity(
						requestConfig.getHijklmndbserver() + RequestUrlOption.DB_PICTURE_ADDPICTURE, picture,
						RequestResult.class);

				RequestResult requestResult1 = responseEntity1.getBody();
				if (requestResult1.getCode() != 1) {
					redirectAttributes.addFlashAttribute(WebOption.RESULT, ResultParam.syserr.desc());
					modelAndView.setViewName(RequestOption.ERROR500);
					return;
				}

				modelAndView.setViewName("redirect:/picture/viewPicture");

			}
		}, null, request, redirectAttributes);
	}

	@RequestMapping("/viewPicture")
	public ModelAndView viewPicture(HttpServletRequest request, RedirectAttributes redirectAttributes,
			PictureDTO pictureDTO) {
		return ControllerProxy.handler(new ControllerHandler() {

			@Override
			public void assemble(ModelAndView modelAndView, RedirectAttributes redirectAttributes) throws Exception {
				pictureDTO.setSortField("online_datetime");
				pictureDTO.setSequence(1);
				if (pictureDTO.getIndex() == null || pictureDTO.getIndex() < 0) {
					pictureDTO.setIndex(0);
				}
				pictureDTO.setIsvalid(1);

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

				modelAndView.setViewName("viewPicture");

			}
		}, pictureDTO, request, redirectAttributes);

	}

}
