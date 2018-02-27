package truecorp.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentActivityDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private PaymentActivityPKDto id;

	@JsonProperty("actvAmt")
	private BigDecimal actvAmt;

	@JsonProperty("actvBillSeqNo")
	private BigDecimal actvBillSeqNo;

	@JsonProperty("actvCode")
	private String actvCode;

	@JsonProperty("actvDate")
	private Date actvDate;

	@JsonProperty("actvReasonCode")
	private String actvReasonCode;

	@JsonProperty("bankAccountNo")
	private String bankAccountNo;

	@JsonProperty("bankCode")
	private String bankCode;

	@JsonProperty("ben")
	private BigDecimal ben;

	@JsonProperty("blIgnoreInd")
	private String blIgnoreInd;

	@JsonProperty("convRunNo")
	private BigDecimal convRunNo;

	@JsonProperty("dckChargeSeqNo")
	private BigDecimal dckChargeSeqNo;

	@JsonProperty("depositDate")
	private Date depositDate;

	@JsonProperty("euActvAmt")
	private BigDecimal euActvAmt;

	@JsonProperty("exceptionRsnCode")
	private String exceptionRsnCode;

	@JsonProperty("fntBan")
	private BigDecimal fntBan;

	@JsonProperty("fuCategory")
	private String fuCategory;

	@JsonProperty("fuThreadSeqNo")
	private BigDecimal fuThreadSeqNo;

	@JsonProperty("postingPeriod")
	private BigDecimal postingPeriod;

	private String transactionType;

	public PaymentActivityDto() {
	}

	public PaymentActivityPKDto getId() {
		return this.id;
	}

	public void setId(PaymentActivityPKDto id) {
		this.id = id;
	}

	public BigDecimal getActvAmt() {
		return this.actvAmt;
	}

	public void setActvAmt(BigDecimal actvAmt) {
		this.actvAmt = actvAmt;
	}

	public BigDecimal getActvBillSeqNo() {
		return this.actvBillSeqNo;
	}

	public void setActvBillSeqNo(BigDecimal actvBillSeqNo) {
		this.actvBillSeqNo = actvBillSeqNo;
	}

	public String getActvCode() {
		return this.actvCode;
	}

	public void setActvCode(String actvCode) {
		this.actvCode = actvCode;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getActvDate() {
		return this.actvDate;
	}

	public void setActvDate(Date actvDate) {
		this.actvDate = actvDate;
	}

	public String getActvReasonCode() {
		return this.actvReasonCode;
	}

	public void setActvReasonCode(String actvReasonCode) {
		this.actvReasonCode = actvReasonCode;
	}

	public String getBankAccountNo() {
		return this.bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public BigDecimal getBen() {
		return this.ben;
	}

	public void setBen(BigDecimal ben) {
		this.ben = ben;
	}

	public String getBlIgnoreInd() {
		return this.blIgnoreInd;
	}

	public void setBlIgnoreInd(String blIgnoreInd) {
		this.blIgnoreInd = blIgnoreInd;
	}

	public BigDecimal getConvRunNo() {
		return this.convRunNo;
	}

	public void setConvRunNo(BigDecimal convRunNo) {
		this.convRunNo = convRunNo;
	}

	public BigDecimal getDckChargeSeqNo() {
		return this.dckChargeSeqNo;
	}

	public void setDckChargeSeqNo(BigDecimal dckChargeSeqNo) {
		this.dckChargeSeqNo = dckChargeSeqNo;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getDepositDate() {
		return this.depositDate;
	}

	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}

	public BigDecimal getEuActvAmt() {
		return this.euActvAmt;
	}

	public void setEuActvAmt(BigDecimal euActvAmt) {
		this.euActvAmt = euActvAmt;
	}

	public String getExceptionRsnCode() {
		return this.exceptionRsnCode;
	}

	public void setExceptionRsnCode(String exceptionRsnCode) {
		this.exceptionRsnCode = exceptionRsnCode;
	}

	public BigDecimal getFntBan() {
		return this.fntBan;
	}

	public void setFntBan(BigDecimal fntBan) {
		this.fntBan = fntBan;
	}

	public String getFuCategory() {
		return this.fuCategory;
	}

	public void setFuCategory(String fuCategory) {
		this.fuCategory = fuCategory;
	}

	public BigDecimal getFuThreadSeqNo() {
		return this.fuThreadSeqNo;
	}

	public void setFuThreadSeqNo(BigDecimal fuThreadSeqNo) {
		this.fuThreadSeqNo = fuThreadSeqNo;
	}

	public BigDecimal getPostingPeriod() {
		return this.postingPeriod;
	}

	public void setPostingPeriod(BigDecimal postingPeriod) {
		this.postingPeriod = postingPeriod;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}