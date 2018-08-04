package edu.guosong.sc.hijklmncommon.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RequestResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2551731786928021041L;

	private Integer pageIndex;

	private Integer pageSize;

	private Integer pageTotal;

	private Integer pageDesc;

	private String pageField;

	private Integer code;

	private String reason;

	private Map<String, Object> result = new HashMap<>();

	public void put(String key, Object value) {
		result.put(key, value);
	}

	public Object get(String key) {
		return result.get(key);
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Integer getPageDesc() {
		return pageDesc;
	}

	public void setPageDesc(Integer pageDesc) {
		this.pageDesc = pageDesc;
	}

	public String getPageField() {
		return pageField;
	}

	public void setPageField(String pageField) {
		this.pageField = pageField;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

}
