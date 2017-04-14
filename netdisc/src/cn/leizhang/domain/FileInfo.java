package cn.leizhang.domain;

public class FileInfo {
	
	private String filename;
	private String realpath;
	//private String savepath;
	private String description;
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getRealpath() {
		return realpath;
	}
	public void setRealpath(String realpath) {
		this.realpath = realpath;
	}
	
//	public String getSavepath() {
//		return savepath;
//	}
//	public void setSavepath(String savepath) {
//		this.savepath = savepath;
//	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
