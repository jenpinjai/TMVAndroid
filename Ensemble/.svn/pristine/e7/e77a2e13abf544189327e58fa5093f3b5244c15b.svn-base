/*
* -----------------------------------------------------------------------------------
* Copyright © 2018 by True Information Technology Co.,Ltd. All rights reserved
* -----------------------------------------------------------------------------------
*/
package truecorp.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Supot Saelao
 * @version 1.0
 */
public class AdjustmentDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long ban;
	private String subscriberNo;
	private String reason;
	private BigDecimal amount;
	private String creditNoteNo;
	private Long operatorId;
	private Date logicalDate;
	private Long entSeqNo;
	private Long taxSeqNo;
	private String invoicePeriod;
	
	@JsonIgnore
	private String invDesc;
	
	@JsonIgnore
	private BigDecimal avlAmount;
	
	public Long getBan() {
		return ban;
	}

	public void setBan(Long ban) {
		this.ban = ban;
	}

	public String getSubscriberNo() {
		return subscriberNo;
	}

	public void setSubscriberNo(String subscriberNo) {
		this.subscriberNo = subscriberNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCreditNoteNo() {
		return creditNoteNo;
	}

	public void setCreditNoteNo(String creditNoteNo) {
		this.creditNoteNo = creditNoteNo;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public Date getLogicalDate() {
		return logicalDate;
	}

	public void setLogicalDate(Date logicalDate) {
		this.logicalDate = logicalDate;
	}

	public Long getEntSeqNo() {
		return entSeqNo;
	}

	public void setEntSeqNo(Long entSeqNo) {
		this.entSeqNo = entSeqNo;
	}

	public Long getTaxSeqNo() {
		return taxSeqNo;
	}

	public void setTaxSeqNo(Long taxSeqNo) {
		this.taxSeqNo = taxSeqNo;
	}

	public void setInvoicePeriod(String invoicePeriod) {
		this.invoicePeriod = invoicePeriod;
	}

	public String getInvoicePeriod() {
		return invoicePeriod;
	}

	@JsonIgnore
	public String getInvDesc() {
		return invDesc;
	}

	@JsonIgnore
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
	}
	
	@JsonIgnore
	public BigDecimal getAvlAmount() {
		return avlAmount;
	}

	@JsonIgnore
	public void setAvlAmount(BigDecimal avlAmount) {
		this.avlAmount = avlAmount;
	}

	@Override
	public String toString() {
		return "AdjustmentDto [ban=" + ban + ", subscriberNo=" + subscriberNo + ", reason=" + reason + ", amount="
				+ amount + ", creditNoteNo=" + creditNoteNo + ", operatorId=" + operatorId + ", logicalDate="
				+ logicalDate + ", entSeqNo=" + entSeqNo + ", taxSeqNo=" + taxSeqNo + "]";
	}
	
	

}
