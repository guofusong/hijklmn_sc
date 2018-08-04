package edu.guosong.sc.hijklmnadmin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.guosong.sc.hijklmnadmin.common.ControllerHandler;
import edu.guosong.sc.hijklmnadmin.common.RequestConfig;
import edu.guosong.sc.hijklmnadmin.common.RequestOption;
import edu.guosong.sc.hijklmncommon.dto.MenuDTO;
import edu.guosong.sc.hijklmncommon.dto.RequestResult;
import edu.guosong.sc.hijklmncommon.param.RequestUrlOption;
import edu.guosong.sc.hijklmncommon.param.ResultParam;
import edu.guosong.sc.hijklmncommon.param.WebOption;
import edu.guosong.sc.hijklmncommon.po.Menu;
import edu.guosong.sc.hijklmncommon.po.User;
import edu.guosong.sc.hijklmncommon.util.HttpUtil;
import edu.guosong.sc.hijklmncommon.util.JSONUtil;
import edu.guosong.sc.hijklmncommon.util.SecurityUtil;
import edu.guosong.sc.hijklmncommon.util.WebGetter;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private RequestConfig requestConfig;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
				// 清空session
				HttpUtil.initSession(request);

				// 跳转登录
				modelAndView.setViewName(RequestOption.REDIRECTLOGIN);
			}
		}, null, request, null);
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, RedirectAttributes redirectAttributes) {

		return ControllerProxy.handler(new ControllerHandler() {

			@Override
			public void assemble(ModelAndView modelAndView, RedirectAttributes redirectAttributes) {

				String username = WebGetter.getString("username", request);

				String password = WebGetter.getString("password", request);

				User tempUser = new User();

				tempUser.setUsername(username);

				tempUser.setPassword(SecurityUtil.MD5(SecurityUtil.SHA1(password)));

				ResponseEntity<RequestResult> responseEntity = restTemplate.postForEntity(
						requestConfig.getHijklmndbserver() + RequestUrlOption.DB_USER_LOGIN, tempUser,
						RequestResult.class);

				RequestResult requestResult = responseEntity.getBody();
				if (requestResult.getCode() != 1) {
					redirectAttributes.addFlashAttribute(WebOption.RESULT, ResultParam.syserr.desc());
					modelAndView.setViewName(RequestOption.REDIRECTLOGIN);
					return;
				}

				User user = (User) JSONUtil.str2Bean(requestResult.get(WebOption.ITEM), User.class);
				if (user == null) {
					redirectAttributes.addFlashAttribute(WebOption.RESULT, ResultParam.invalidaccoundorpwd.desc());
					modelAndView.setViewName(RequestOption.REDIRECTLOGIN);
					return;
				}

				user.setPassword(null);

				request.getSession().setAttribute(WebOption.USER, user);

				MenuDTO menuDTO = new MenuDTO();
				menuDTO.setIsvalid(1);

				ResponseEntity<RequestResult> responseEntity1 = restTemplate.postForEntity(
						requestConfig.getHijklmndbserver() + RequestUrlOption.DB_SYS_VIEWMENU, menuDTO,
						RequestResult.class);

				RequestResult requestResult1 = responseEntity1.getBody();
				if (requestResult1.getCode() != 1) {
					redirectAttributes.addFlashAttribute(WebOption.RESULT, ResultParam.syserr.desc());
					modelAndView.setViewName(RequestOption.ERROR500);
					return;
				}

				@SuppressWarnings("unchecked")
				List<Menu> menus = (List<Menu>) JSONUtil.str2List(requestResult1.get(WebOption.ITEMS), List.class);

				request.getSession().setAttribute(WebOption.MENU, menus);

				modelAndView.setViewName("home");

			}
		}, null, request, redirectAttributes);

	}

}
