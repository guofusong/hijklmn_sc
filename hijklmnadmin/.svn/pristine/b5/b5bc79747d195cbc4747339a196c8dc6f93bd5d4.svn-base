package edu.guosong.sc.hijklmnadmin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.guosong.sc.hijklmnadmin.common.ControllerHandler;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(ModelAndView modelAndView, RedirectAttributes redirectAttributes) throws Exception {
				modelAndView.setViewName("home");
			}
		}, null, request, redirectAttributes);
	}

}
