package edu.guosong.sc.hijklmnmediaserver.common;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import edu.guosong.sc.hijklmncommon.util.DirUtil;

@Component
public class MediaUrlConfig {

	private static final Logger log = LoggerFactory.getLogger(MediaUrlConfig.class);

	public final String PREFIX = "file:";

	private String imageLocalPath;

	private String soundLocalPath;

	private String videoLocalPath;

	private String imageRequestPath;

	private String soundRequestPath;

	private String videoRequestPath;

	public String getImageLocalPath() {
		return imageLocalPath;
	}

	public void init() {
		boolean createDir;
		File local = new File(imageLocalPath);
		if (!local.exists() || local.isFile()) {
			createDir = DirUtil.createAbsoluteDir(imageLocalPath);
			if (!createDir) {
				log.info("路径创建失败！[imageLocalPath:" + imageLocalPath + "]");
				System.exit(0);
			}
		}
		local = new File(soundLocalPath);
		if (!local.exists() || local.isFile()) {
			createDir = DirUtil.createAbsoluteDir(soundLocalPath);
			if (!createDir) {
				log.info("路径创建失败！[soundLocalPath:" + soundLocalPath + "]");
				System.exit(0);
			}
		}
		local = new File(videoLocalPath);
		if (!local.exists() || local.isFile()) {
			createDir = DirUtil.createAbsoluteDir(videoLocalPath);
			if (!createDir) {
				log.info("路径创建失败！[videoLocalPath:" + videoLocalPath + "]");
				System.exit(0);
			}
		}
		if (!imageLocalPath.endsWith("\\")) {
			imageLocalPath += "\\";
		}
		if (!soundLocalPath.endsWith("\\")) {
			soundLocalPath += "\\";
		}
		if (!videoLocalPath.endsWith("\\")) {
			videoLocalPath += "\\";
		}
		log.info("媒体存储路径检查成功！");

	}

	@Value("${imageLocalPath}")
	public void setImageLocalPath(String imageLocalPath) {
		this.imageLocalPath = imageLocalPath;
	}

	public String getSoundLocalPath() {
		return soundLocalPath;
	}

	@Value("${soundLocalPath}")
	public void setSoundLocalPath(String soundLocalPath) {
		this.soundLocalPath = soundLocalPath;
	}

	public String getVideoLocalPath() {
		return videoLocalPath;
	}

	@Value("${videoLocalPath}")
	public void setVideoLocalPath(String videoLocalPath) {
		this.videoLocalPath = videoLocalPath;
	}

	public String getImageRequestPath() {
		return imageRequestPath;
	}

	@Value("${imageRequestPath}")
	public void setImageRequestPath(String imageRequestPath) {
		this.imageRequestPath = imageRequestPath;
	}

	public String getSoundRequestPath() {
		return soundRequestPath;
	}

	@Value("${soundRequestPath}")
	public void setSoundRequestPath(String soundRequestPath) {
		this.soundRequestPath = soundRequestPath;
	}

	public String getVideoRequestPath() {
		return videoRequestPath;
	}

	@Value("${videoRequestPath}")
	public void setVideoRequestPath(String videoRequestPath) {
		this.videoRequestPath = videoRequestPath;
	}

}
