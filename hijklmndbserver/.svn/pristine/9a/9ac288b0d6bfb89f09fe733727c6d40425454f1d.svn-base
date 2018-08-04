package edu.guosong.sc.hijklmndbserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.guosong.sc.hijklmncommon.dto.MenuDTO;
import edu.guosong.sc.hijklmncommon.dto.RequestResult;
import edu.guosong.sc.hijklmncommon.param.WebOption;
import edu.guosong.sc.hijklmncommon.util.JSONUtil;
import edu.guosong.sc.hijklmndbserver.common.ControllerHandler;
import edu.guosong.sc.hijklmndbserver.service.IMenuService;

@RestController
@RequestMapping("/sys")
public class SysController {

	@Autowired
	private IMenuService menuService;

	@RequestMapping("/viewMenu")
	public RequestResult viewMenu(@RequestBody MenuDTO menuDTO) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(RequestResult requestResult) {
				requestResult.put(WebOption.ITEMS, JSONUtil.bean2Str(menuService.queryMenuList(menuDTO)));
			}
		});
	}

}
