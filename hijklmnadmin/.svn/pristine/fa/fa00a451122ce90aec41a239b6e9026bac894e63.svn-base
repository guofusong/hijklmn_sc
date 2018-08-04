package edu.guosong.sc.hijklmnadmin.aspectj;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.guosong.sc.hijklmnadmin.common.RequestOption;
import edu.guosong.sc.hijklmncommon.dto.UserDTO;
import edu.guosong.sc.hijklmncommon.param.ResultParam;
import edu.guosong.sc.hijklmncommon.param.WebOption;

@Aspect
@Component
public class CheckUserParamAspectJ {

	private static final Logger log = LoggerFactory.getLogger(CheckUserParamAspectJ.class);

	@Pointcut("execution(**  edu.guosong.sc.hijklmnadmin.controller.UserController.login(..))")
	public void login() {
	}

	@Around("login()")
	public Object checkLogin(ProceedingJoinPoint jp) {
		ModelAndView modelAndView = new ModelAndView();
		Object[] objs = jp.getArgs();
		RedirectAttributes redirectAttributes = (RedirectAttributes) objs[1];
		UserDTO userDTO = (UserDTO) objs[2];
		try {
			if (userDTO == null) {
				modelAndView.setViewName(RequestOption.REDIRECTLOGIN);
				redirectAttributes.addFlashAttribute(WebOption.RESULT, ResultParam.emptyparam.desc());
				return modelAndView;
			}
			if (!(StringUtils.isBlank(userDTO.getUsername()) || StringUtils.isBlank(userDTO.getPassword()))) {
				return jp.proceed();
			}
			redirectAttributes.addFlashAttribute(WebOption.RESULT, ResultParam.emptyparam.desc());
		} catch (Throwable e) {
			log.error("Admin ERR method ： checkLogin 。" + e);
			modelAndView.setViewName(RequestOption.REDIRECTLOGIN);
		}
		return modelAndView;

	}

}
