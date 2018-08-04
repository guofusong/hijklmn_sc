package edu.guosong.sc.hijklmnmediaserver.controller;

import java.nio.ByteBuffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.guosong.sc.hijklmncommon.dto.MediaDTO;
import edu.guosong.sc.hijklmncommon.dto.RequestResult;
import edu.guosong.sc.hijklmncommon.param.StringOption;
import edu.guosong.sc.hijklmncommon.param.WebOption;
import edu.guosong.sc.hijklmncommon.util.EncodeUtil;
import edu.guosong.sc.hijklmncommon.util.FileUtil;
import edu.guosong.sc.hijklmncommon.util.StringUtil;
import edu.guosong.sc.hijklmnmediaserver.common.ControllerHandler;
import edu.guosong.sc.hijklmnmediaserver.common.MediaUrlConfig;

@RestController
public class MediaController {

	@Autowired
	private MediaUrlConfig mediaUrlConfig;

	@RequestMapping(value = "/media/upload")
	public RequestResult upload(@RequestBody MediaDTO mediaDTO) {

		return ControllerProxy.handler(new ControllerHandler() {

			@Override
			public void assemble(RequestResult requestResult) throws Exception {

				String saveName = StringUtil.generatorRandom32l() + StringOption.DOT + mediaDTO.getSuffix();
				byte[] b = EncodeUtil.decode(mediaDTO.getData());
				String localPath = null;
				String requestPath = null;

				switch (mediaDTO.getMediaType()) {
				case "image":
					localPath = mediaUrlConfig.getImageLocalPath();
					requestPath = mediaUrlConfig.getImageRequestPath();
					break;
				case "sound":
					localPath = mediaUrlConfig.getSoundLocalPath();
					requestPath = mediaUrlConfig.getSoundRequestPath();
					break;
				case "video":
					localPath = mediaUrlConfig.getVideoLocalPath();
					requestPath = mediaUrlConfig.getVideoRequestPath();
					break;
				default:
					break;
				}

				FileUtil.write(localPath, saveName, ByteBuffer.wrap(b));

				requestResult.put(WebOption.NAME, saveName);

				requestResult.put(WebOption.PATH, requestPath);

			}

		});

	}

}
