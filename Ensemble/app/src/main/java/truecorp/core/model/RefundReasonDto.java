package truecorp.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundReasonDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("refundReasonCode")
	private String refundReasonCode;

	@JsonProperty("applicationId")
	private String applicationId;

	@JsonProperty("dlServiceCode")
	private String dlServiceCode;

	@JsonProperty("dlUpdateStamp")
	private BigDecimal dlUpdateStamp;

	@JsonProperty("manRfnInd")
	private String manRfnInd;

	@JsonProperty("operatorId")
	private BigDecimal operatorId;

	@JsonProperty("processCode")
	private String processCode;

	@JsonProperty("refundApplMethod")
	private String refundApplMethod;

	@JsonProperty("refundDesc")
	private String refundDesc;

	@JsonProperty("refundShortDesc")
	private String refundShortDesc;

	@JsonProperty("sysCreationDate")
	private Date sysCreationDate;

	@JsonProperty("sysUpdateDate")
	private Date sysUpdateDate;

	public RefundReasonDto() {
	}

	public String getRefundReasonCode() {
		return this.refundReasonCode;
	}

	public void setRefundReasonCode(String refundReasonCode) {
		this.refundReasonCode = refundReasonCode;
	}

	public String getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getDlServiceCode() {
		return this.dlServiceCode;
	}

	public void setDlServiceCode(String dlServiceCode) {
		this.dlServiceCode = dlServiceCode;
	}

	public BigDecimal getDlUpdateStamp() {
		return this.dlUpdateStamp;
	}

	public void setDlUpdateStamp(BigDecimal dlUpdateStamp) {
		this.dlUpdateStamp = dlUpdateStamp;
	}

	public String getManRfnInd() {
		return this.manRfnInd;
	}

	public void setManRfnInd(String manRfnInd) {
		this.manRfnInd = manRfnInd;
	}

	public BigDecimal getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(BigDecimal operatorId) {
		this.operatorId = operatorId;
	}

	public String getProcessCode() {
		return this.processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getRefundApplMethod() {
		return this.refundApplMethod;
	}

	public void setRefundApplMethod(String refundApplMethod) {
		this.refundApplMethod = refundApplMethod;
	}

	public String getRefundDesc() {
		return this.refundDesc;
	}

	public void setRefundDesc(String refundDesc) {
		this.refundDesc = refundDesc;
	}

	public String getRefundShortDesc() {
		return this.refundShortDesc;
	}

	public void setRefundShortDesc(String refundShortDesc) {
		this.refundShortDesc = refundShortDesc;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getSysCreationDate() {
		return this.sysCreationDate;
	}

	public void setSysCreationDate(Date sysCreationDate) {
		this.sysCreationDate = sysCreationDate;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getSysUpdateDate() {
		return this.sysUpdateDate;
	}

	public void setSysUpdateDate(Date sysUpdateDate) {
		this.sysUpdateDate = sysUpdateDate;
	}

}