package edu.guosong.sc.hijklmnmediaserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.guosong.sc.hijklmncommon.dto.RequestResult;
import edu.guosong.sc.hijklmncommon.param.ResultParam;
import edu.guosong.sc.hijklmnmediaserver.common.ControllerHandler;

public class ControllerProxy {

	private static final Logger log = LoggerFactory.getLogger(ControllerProxy.class);

	public static RequestResult handler(ControllerHandler controllerHandler) {
		final RequestResult requestResult = new RequestResult();
		try {
			controllerHandler.assemble(requestResult);
			requestResult.setCode(ResultParam.success.code());
			requestResult.setReason(ResultParam.success.desc());
		} catch (Exception e) {
			log.error("hijklmn media server an error occurred in handler method.", e);
			requestResult.setCode(ResultParam.syserr.code());
			requestResult.setReason(ResultParam.syserr.desc());
		}
		return requestResult;
	}

}
