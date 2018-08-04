package edu.guosong.sc.hijklmnstage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.guosong.sc.hijklmncommon.dto.PictureDTO;
import edu.guosong.sc.hijklmnstage.common.ControllerHandler;
import edu.guosong.sc.hijklmnstage.common.RequestConfig;

@Controller
@RequestMapping("/video")
public class VideoController {

	@Autowired
	private RequestConfig requestConfig;

	@RequestMapping("/view")
	public ModelAndView view(HttpServletRequest request, RedirectAttributes redirectAttributes, PictureDTO pictureDTO) {
		return ControllerProxy.queryList(new ControllerHandler() {
			@Override
			public void assemble(ModelAndView modelAndView, RedirectAttributes redirectAttributes) throws Exception {
				modelAndView.setViewName("video");
			}
		}, null, request, redirectAttributes);
	}

}
