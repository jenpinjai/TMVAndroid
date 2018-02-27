package truecorp.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the FILE_CONTROL database table.
 * 
 * @author Supot Saelao
 * @version 1.0
 */

public class FileControlDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fileName;
	private Date sysCreationDate;
	private String filePath;
	private String fileStatus;
	private Integer recQuantity;
	private Integer operatorId;
	private String applicationId;
	private String dlServiceCode;
	private Integer dlUpdateStamp;
	private String pgmName;
	private String pgmErrMsg;
	private Date sysUpdateDate;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getSysCreationDate() {
		return sysCreationDate;
	}

	public void setSysCreationDate(Date sysCreationDate) {
		this.sysCreationDate = sysCreationDate;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public Integer getRecQuantity() {
		return recQuantity;
	}

	public void setRecQuantity(Integer recQuantity) {
		this.recQuantity = recQuantity;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getDlServiceCode() {
		return dlServiceCode;
	}

	public void setDlServiceCode(String dlServiceCode) {
		this.dlServiceCode = dlServiceCode;
	}

	public Integer getDlUpdateStamp() {
		return dlUpdateStamp;
	}

	public void setDlUpdateStamp(Integer dlUpdateStamp) {
		this.dlUpdateStamp = dlUpdateStamp;
	}

	public String getPgmName() {
		return pgmName;
	}

	public void setPgmName(String pgmName) {
		this.pgmName = pgmName;
	}

	public String getPgmErrMsg() {
		return pgmErrMsg;
	}

	public void setPgmErrMsg(String pgmErrMsg) {
		this.pgmErrMsg = pgmErrMsg;
	}

	public Date getSysUpdateDate() {
		return sysUpdateDate;
	}

	public void setSysUpdateDate(Date sysUpdateDate) {
		this.sysUpdateDate = sysUpdateDate;
	}
}