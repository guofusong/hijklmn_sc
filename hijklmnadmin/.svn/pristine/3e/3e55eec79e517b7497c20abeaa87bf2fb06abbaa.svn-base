package edu.guosong.sc.hijklmnadmin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.guosong.sc.hijklmnadmin.common.ControllerHandler;
import edu.guosong.sc.hijklmncommon.param.WebOption;
import edu.guosong.sc.hijklmncommon.po.User;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
				User user = (User) request.getSession().getAttribute(WebOption.USER);
				if (user == null) {
					modelAndView.setViewName("login");
				} else {
					modelAndView.setViewName("home");
				}
			}
		}, null, request, null);
	}

}
