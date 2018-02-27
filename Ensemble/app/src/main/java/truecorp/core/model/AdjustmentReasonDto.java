package truecorp.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdjustmentReasonDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("reasonCode")
	private String reasonCode;

	@JsonProperty("adjActvCode")
	private String adjActvCode;

	@JsonProperty("adjCategory")
	private String adjCategory;

	@JsonProperty("adjDefAmt")
	private BigDecimal adjDefAmt;

	@JsonProperty("adjDefAmtOverInd")
	private String adjDefAmtOverInd;

	@JsonProperty("adjDsc")
	private String adjDsc;

	@JsonProperty("adjShortDsc")
	private String adjShortDsc;

	@JsonProperty("applicationId")
	private String applicationId;

	@JsonProperty("banAdjTaxCode")
	private String banAdjTaxCode;

	@JsonProperty("banExmpTaxCode")
	private String banExmpTaxCode;

	@JsonProperty("blIgnoreInd")
	private String blIgnoreInd;

	@JsonProperty("blInclPrstInd")
	private String blInclPrstInd;

	@JsonProperty("blTxtOvrInd")
	private String blTxtOvrInd;

	@JsonProperty("dcRedInd")
	private String dcRedInd;

	@JsonProperty("dlServiceCode")
	private String dlServiceCode;

	@JsonProperty("dlUpdateStamp")
	private BigDecimal dlUpdateStamp;

	@JsonProperty("euAdjDefAmt")
	private BigDecimal euAdjDefAmt;

	@JsonProperty("invType")
	private String invType;

	@JsonProperty("manAdjInd")
	private String manAdjInd;
	
	@JsonProperty("network")
	private String network;

	@JsonProperty("operatorId")
	private BigDecimal operatorId;

	@JsonProperty("processCode")
	private String processCode;
	
	@JsonProperty("product")
	private String product;

	@JsonProperty("sysCreationDate")
	private Date sysCreationDate;

	@JsonProperty("sysUpdateDate")
	private Date sysUpdateDate;

	@JsonProperty("taxCode")
	private String taxCode;

	@JsonProperty("taxInd")
	private String taxInd;

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getAdjActvCode() {
		return adjActvCode;
	}

	public void setAdjActvCode(String adjActvCode) {
		this.adjActvCode = adjActvCode;
	}

	public String getAdjCategory() {
		return adjCategory;
	}

	public void setAdjCategory(String adjCategory) {
		this.adjCategory = adjCategory;
	}

	public BigDecimal getAdjDefAmt() {
		return adjDefAmt;
	}

	public void setAdjDefAmt(BigDecimal adjDefAmt) {
		this.adjDefAmt = adjDefAmt;
	}

	public String getAdjDefAmtOverInd() {
		return adjDefAmtOverInd;
	}

	public void setAdjDefAmtOverInd(String adjDefAmtOverInd) {
		this.adjDefAmtOverInd = adjDefAmtOverInd;
	}

	public String getAdjDsc() {
		return adjDsc;
	}

	public void setAdjDsc(String adjDsc) {
		this.adjDsc = adjDsc;
	}

	public String getAdjShortDsc() {
		return adjShortDsc;
	}

	public void setAdjShortDsc(String adjShortDsc) {
		this.adjShortDsc = adjShortDsc;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getBanAdjTaxCode() {
		return banAdjTaxCode;
	}

	public void setBanAdjTaxCode(String banAdjTaxCode) {
		this.banAdjTaxCode = banAdjTaxCode;
	}

	public String getBanExmpTaxCode() {
		return banExmpTaxCode;
	}

	public void setBanExmpTaxCode(String banExmpTaxCode) {
		this.banExmpTaxCode = banExmpTaxCode;
	}

	public String getBlIgnoreInd() {
		return blIgnoreInd;
	}

	public void setBlIgnoreInd(String blIgnoreInd) {
		this.blIgnoreInd = blIgnoreInd;
	}

	public String getBlInclPrstInd() {
		return blInclPrstInd;
	}

	public void setBlInclPrstInd(String blInclPrstInd) {
		this.blInclPrstInd = blInclPrstInd;
	}

	public String getBlTxtOvrInd() {
		return blTxtOvrInd;
	}

	public void setBlTxtOvrInd(String blTxtOvrInd) {
		this.blTxtOvrInd = blTxtOvrInd;
	}

	public String getDcRedInd() {
		return dcRedInd;
	}

	public void setDcRedInd(String dcRedInd) {
		this.dcRedInd = dcRedInd;
	}

	public String getDlServiceCode() {
		return dlServiceCode;
	}

	public void setDlServiceCode(String dlServiceCode) {
		this.dlServiceCode = dlServiceCode;
	}

	public BigDecimal getDlUpdateStamp() {
		return dlUpdateStamp;
	}

	public void setDlUpdateStamp(BigDecimal dlUpdateStamp) {
		this.dlUpdateStamp = dlUpdateStamp;
	}

	public BigDecimal getEuAdjDefAmt() {
		return euAdjDefAmt;
	}

	public void setEuAdjDefAmt(BigDecimal euAdjDefAmt) {
		this.euAdjDefAmt = euAdjDefAmt;
	}

	public String getInvType() {
		return invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}

	public String getManAdjInd() {
		return manAdjInd;
	}

	public void setManAdjInd(String manAdjInd) {
		this.manAdjInd = manAdjInd;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public BigDecimal getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(BigDecimal operatorId) {
		this.operatorId = operatorId;
	}

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getSysCreationDate() {
		return sysCreationDate;
	}

	public void setSysCreationDate(Date sysCreationDate) {
		this.sysCreationDate = sysCreationDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getSysUpdateDate() {
		return sysUpdateDate;
	}

	public void setSysUpdateDate(Date sysUpdateDate) {
		this.sysUpdateDate = sysUpdateDate;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getTaxInd() {
		return taxInd;
	}

	public void setTaxInd(String taxInd) {
		this.taxInd = taxInd;
	}
}
