package edu.guosong.sc.hijklmncommon.po;

import java.util.Date;

public class Picture {
	private String picId;

	private Integer categoryId;

	private String picUrl;

	private String picName;

	private String title;

	private String source;

	private String author;

	private String tag;

	private String picDesc;

	private Integer favourNumber;

	private Date onlineDatetime;

	private Integer browseTimes;

	private Integer isvalid;

	public String getPicId() {
		return picId;
	}

	public void setPicId(String picId) {
		this.picId = picId == null ? null : picId.trim();
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl == null ? null : picUrl.trim();
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source == null ? null : source.trim();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag == null ? null : tag.trim();
	}

	public String getPicDesc() {
		return picDesc;
	}

	public void setPicDesc(String picDesc) {
		this.picDesc = picDesc == null ? null : picDesc.trim();
	}

	public Integer getFavourNumber() {
		return favourNumber;
	}

	public void setFavourNumber(Integer favourNumber) {
		this.favourNumber = favourNumber;
	}

	public Date getOnlineDatetime() {
		return onlineDatetime;
	}

	public void setOnlineDatetime(Date onlineDatetime) {
		this.onlineDatetime = onlineDatetime;
	}

	public Integer getBrowseTimes() {
		return browseTimes;
	}

	public void setBrowseTimes(Integer browseTimes) {
		this.browseTimes = browseTimes;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}
}