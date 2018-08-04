package edu.guosong.sc.hijklmncommon.dto;

import java.util.Date;

public class PictureCommentDTO extends RequestDTO {

	private Integer commentId;

	private String pictureId;

	private String author;

	private String content;

	private Integer favourNumber;

	private Date writeDate;

	private Integer isvalid;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getPictureId() {
		return pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getFavourNumber() {
		return favourNumber;
	}

	public void setFavourNumber(Integer favourNumber) {
		this.favourNumber = favourNumber;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}

}
