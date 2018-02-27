/*
 * -----------------------------------------------------------------------------------
 * Copyright © 2018 by True Information Technology Co.,Ltd. All rights reserved
 * -----------------------------------------------------------------------------------
 */
package truecorp.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Supot Saelao
 * @version 1.0
 */
public class ManualPaymentRecord implements Serializable {
	private static final long serialVersionUID = -4511280312263651826L;
	private String rowId;
	private String recordType;
	private Date custPymDate;
	private Long ban;
	private BigDecimal amount;
	private BigDecimal amountDue;
	private String billMonth;
	private String subscriberNo;
	private String batchNo;
	private String batchLineNo;
	private String description;
	private String receiptId;
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public Date getCustPymDate() {
		return custPymDate;
	}

	public void setCustPymDate(Date custPymDate) {
		this.custPymDate = custPymDate;
	}

	public Long getBan() {
		return ban;
	}

	public void setBan(Long ban) {
		this.ban = ban;
	}

	public BigDecimal getAmount() {
		if (amount == null) {
			amount = BigDecimal.ZERO;
		}
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmountDue() {
		if (amountDue == null) {
			amountDue = BigDecimal.ZERO;
		}
		return amountDue;
	}

	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}

	public String getBillMonth() {
		return billMonth;
	}

	public void setBillMonth(String billMonth) {
		this.billMonth = billMonth;
	}

	public String getSubscriberNo() {
		return subscriberNo;
	}

	public void setSubscriberNo(String subscriberNo) {
		this.subscriberNo = subscriberNo;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getBatchLineNo() {
		return batchLineNo;
	}

	public void setBatchLineNo(String batchLineNo) {
		this.batchLineNo = batchLineNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (rowId != null ? rowId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof ManualPaymentRecord)) {
			return false;
		}
		ManualPaymentRecord other = (ManualPaymentRecord) object;
		if ((this.rowId == null && other.rowId != null) || (this.rowId != null && !this.rowId.equals(other.rowId))) {
			return false;
		}
		return true;
	}

}
