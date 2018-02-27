/*
* -----------------------------------------------------------------------------------
* Copyright © 2561 by True Information Technology Co.,Ltd. All rights reserved
* -----------------------------------------------------------------------------------
*/
package truecorp.core.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
* @author Sucha55
* @version 1.0
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundRequestDto extends RestRequest {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("ban")
	private long ban;
	
	private long entSeqNo;
	
	@JsonProperty("operatorId")
	private long operatorId;
	
	@JsonProperty("actvReasonCode")
	private String actvReasonCode;
	
	@JsonProperty("actvAmt")
	private Double actvAmt;
	
	@JsonProperty("billComment")
	private String billComment;
	
	@JsonProperty("euActvAmt")
	private Double euActvAmt;
	
	@JsonProperty("cnNumber")
	private String cnNumber;

	private Date atcvDate;
	
	public long getBan() {
		return ban;
	}

	public void setBan(long ban) {
		this.ban = ban;
	}

	public long getEntSeqNo() {
		return entSeqNo;
	}

	public void setEntSeqNo(long entSeqNo) {
		this.entSeqNo = entSeqNo;
	}

	public long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(long operatorId) {
		this.operatorId = operatorId;
	}

	public String getActvReasonCode() {
		return actvReasonCode;
	}

	public void setActvReasonCode(String actvReasonCode) {
		this.actvReasonCode = actvReasonCode;
	}

	public Double getActvAmt() {
		return actvAmt;
	}

	public void setActvAmt(Double actvAmt) {
		this.actvAmt = actvAmt;
	}

	public String getBillComment() {
		return billComment;
	}

	public void setBillComment(String billComment) {
		this.billComment = billComment;
	}

	public Double getEuActvAmt() {
		return euActvAmt;
	}

	public void setEuActvAmt(Double euActvAmt) {
		this.euActvAmt = euActvAmt;
	}

	public String getCnNumber() {
		return cnNumber;
	}

	public void setCnNumber(String cnNumber) {
		this.cnNumber = cnNumber;
	}

	public Date getAtcvDate() {
		return atcvDate;
	}

	public void setAtcvDate(Date atcvDate) {
		this.atcvDate = atcvDate;
	}

}
