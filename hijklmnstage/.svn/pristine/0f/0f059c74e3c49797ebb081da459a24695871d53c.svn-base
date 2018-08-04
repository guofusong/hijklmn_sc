package edu.guosong.sc.hijklmnstage.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.guosong.sc.hijklmncommon.dto.RequestDTO;
import edu.guosong.sc.hijklmncommon.util.WebGetter;
import edu.guosong.sc.hijklmnstage.common.ControllerHandler;

public class ControllerProxy {

	private static final Logger log = LoggerFactory.getLogger(ControllerProxy.class);

	public static ModelAndView queryList(ControllerHandler controllerHandler, RequestDTO requestDTO,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		final ModelAndView modelAndView = new ModelAndView();
		try {
			if (requestDTO != null) {
				requestDTO.setSequence(WebGetter.getInteger("sequence", request));
				requestDTO.setSortField(WebGetter.getString("sortField", request));
				requestDTO.setSize(WebGetter.getInteger("size", request));
				if (WebGetter.getInteger("index", request) != null && WebGetter.getInteger("index", request) >= 0
						&& WebGetter.getInteger("size", request) != null && WebGetter.getInteger("size", request) > 0) {
					requestDTO.setIndex(WebGetter.getInteger("size", request) * WebGetter.getInteger("index", request));
				}
			} else {
				requestDTO = new RequestDTO();
				requestDTO.setIndex(0);
				requestDTO.setSize(requestDTO.getSize());
			}
			controllerHandler.assemble(modelAndView, redirectAttributes);
		} catch (Exception e) {
			log.error("hijklmn stage server has an error occurred in handler method.", e);
			modelAndView.setViewName("error/500");
		}
		return modelAndView;
	}

	public static ModelAndView handler(ControllerHandler controllerHandler, RequestDTO requestDTO,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		final ModelAndView modelAndView = new ModelAndView();
		try {
			if (requestDTO != null) {
				requestDTO.setSequence(WebGetter.getInteger("sequence", request));
				requestDTO.setSortField(WebGetter.getString("sortField", request));
				requestDTO.setSize(WebGetter.getInteger("size", request));
				if (WebGetter.getInteger("index", request) != null && WebGetter.getInteger("index", request) >= 0
						&& WebGetter.getInteger("size", request) != null && WebGetter.getInteger("size", request) > 0) {
					requestDTO.setIndex(WebGetter.getInteger("size", request) * WebGetter.getInteger("index", request));
				}
			}
			controllerHandler.assemble(modelAndView, redirectAttributes);
		} catch (Exception e) {
			log.error("hijklmn stage server has an error occurred in handler method.", e);
			modelAndView.setViewName("error/500");
		}

		return modelAndView;

	}

}
