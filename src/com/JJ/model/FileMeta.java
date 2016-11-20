package com.JJ.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//ignore "bytes" when return json format
@JsonIgnoreProperties({"bytes"}) 
public class FileMeta {
	private Integer imageId;
	private String fileName;
    private String fileSize;
    private String fileType;
    private Integer imageStagingId;
    private Integer sequence;
    private byte[] bytes;

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getImageStagingId() {
		return imageStagingId;
	}

	public void setImageStagingId(Integer imageStagingId) {
		this.imageStagingId = imageStagingId;
	}
    
}
