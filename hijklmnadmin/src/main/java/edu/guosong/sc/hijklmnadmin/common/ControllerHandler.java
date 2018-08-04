package edu.guosong.sc.hijklmnadmin.common;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ControllerHandler {

	public void assemble(ModelAndView modelAndView, RedirectAttributes redirectAttributes) throws Exception;

}
