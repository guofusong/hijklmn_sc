package edu.guosong.sc.hijklmnmediaserver.aspectj;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import edu.guosong.sc.hijklmncommon.dto.MediaDTO;
import edu.guosong.sc.hijklmncommon.dto.RequestResult;
import edu.guosong.sc.hijklmncommon.param.MediaType;
import edu.guosong.sc.hijklmncommon.param.ResultParam;

@Aspect
@Component
public class CheckMediaParamAspectJ {

	private static final Logger log = LoggerFactory.getLogger(CheckMediaParamAspectJ.class);

	@Pointcut("execution(** edu.guosong.sc.hijklmnmediaserver.controller.MediaController.upload(..))")
	public void upload() {
	}

	@Around("upload()")
	public Object checkUpload(ProceedingJoinPoint jp) {

		final RequestResult requestResult = new RequestResult();
		try {
			final Object[] objs = jp.getArgs();
			MediaDTO mediaDTO = (MediaDTO) objs[0];
			if (StringUtils.isBlank(mediaDTO.getMediaType()) || StringUtils.isBlank(mediaDTO.getSuffix())
					|| StringUtils.isBlank(mediaDTO.getData())) {
				requestResult.setCode(ResultParam.emptyparam.code());
				requestResult.setReason(ResultParam.emptyparam.desc());
				return requestResult;
			}
			if (!(mediaDTO.getMediaType().equals(MediaType.image.type())
					|| mediaDTO.getMediaType().equals(MediaType.sound.type())
					|| mediaDTO.getMediaType().equals(MediaType.video.type()))) {
				requestResult.setCode(ResultParam.invalidparam.code());
				requestResult.setReason(ResultParam.invalidparam.desc());
				return requestResult;
			}

			return jp.proceed();

		} catch (Throwable e) {
			log.error("Hijklmn Media Server ERR method ： checkUpload 。" + e);
			requestResult.setCode(ResultParam.syserr.code());
			requestResult.setReason(ResultParam.syserr.desc());
			return requestResult;
		}

	}

}
