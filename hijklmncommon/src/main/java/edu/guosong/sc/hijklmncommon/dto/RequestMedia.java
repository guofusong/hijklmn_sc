package edu.guosong.sc.hijklmncommon.dto;

import java.io.Serializable;

public class RequestMedia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2141958799509147707L;

	private String mediaType;

	private String filename;

	private String suffix;

	private String data;

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
