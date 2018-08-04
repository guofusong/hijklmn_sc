package edu.guosong.sc.hijklmnstage.common;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.guosong.sc.hijklmncommon.dto.RequestResult;

public interface ControllerHandler {

	public void assemble(ModelAndView modelAndView, RedirectAttributes redirectAttributes) throws Exception;
	
}
