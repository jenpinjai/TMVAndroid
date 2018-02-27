package truecorp.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDataDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("addressId")
	private long addressId;

	@JsonProperty("accomodation")
	private String accomodation;

	@JsonProperty("accomodationCd")
	private String accomodationCd;

	@JsonProperty("adrAttention")
	private String adrAttention;

	@JsonProperty("adrCity")
	private String adrCity;

	@JsonProperty("adrCountry")
	private String adrCountry;

	@JsonProperty("adrFieldedInd")
	private String adrFieldedInd;

	@JsonProperty("adrLocation")
	private String adrLocation;

	@JsonProperty("adrPob")
	private String adrPob;

	@JsonProperty("adrPrimaryLn")
	private String adrPrimaryLn;

	@JsonProperty("adrSecondaryLn")
	private String adrSecondaryLn;

	@JsonProperty("adrSinceDate")
	private Date adrSinceDate;

	@JsonProperty("adrState")
	private String adrState;

	@JsonProperty("adrStreetName")
	private String adrStreetName;

	@JsonProperty("adrType")
	private String adrType;

	@JsonProperty("adrValidityCode")
	private String adrValidityCode;

	@JsonProperty("adrVillage")
	private String adrVillage;

	@JsonProperty("adrZip")
	private String adrZip;

	@JsonProperty("applicationId")
	private String applicationId;

	@JsonProperty("billFormat")
	private String billFormat;

	@JsonProperty("convRunNo")
	private BigDecimal convRunNo;

	@JsonProperty("district")
	private String district;

	@JsonProperty("dlServiceCode")
	private String dlServiceCode;

	@JsonProperty("dlUpdateStamp")
	private BigDecimal dlUpdateStamp;

	@JsonProperty("numOfBillCopies")
	private BigDecimal numOfBillCopies;

	@JsonProperty("operatorId")
	private BigDecimal operatorId;

	@JsonProperty("subDistrict")
	private String subDistrict;

	@JsonProperty("summaryPageInd")
	private String summaryPageInd;

	@JsonProperty("sysCreationDate")
	private Date sysCreationDate;

	@JsonProperty("sysUpdateDate")
	private Date sysUpdateDate;

	@JsonProperty("timeAtAddr")
	private String timeAtAddr;

	public long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAccomodation() {
		return this.accomodation;
	}

	public void setAccomodation(String accomodation) {
		this.accomodation = accomodation;
	}

	public String getAccomodationCd() {
		return this.accomodationCd;
	}

	public void setAccomodationCd(String accomodationCd) {
		this.accomodationCd = accomodationCd;
	}

	public String getAdrAttention() {
		return this.adrAttention;
	}

	public void setAdrAttention(String adrAttention) {
		this.adrAttention = adrAttention;
	}

	public String getAdrCity() {
		return this.adrCity;
	}

	public void setAdrCity(String adrCity) {
		this.adrCity = adrCity;
	}

	public String getAdrCountry() {
		return this.adrCountry;
	}

	public void setAdrCountry(String adrCountry) {
		this.adrCountry = adrCountry;
	}

	public String getAdrFieldedInd() {
		return this.adrFieldedInd;
	}

	public void setAdrFieldedInd(String adrFieldedInd) {
		this.adrFieldedInd = adrFieldedInd;
	}

	public String getAdrLocation() {
		return this.adrLocation;
	}

	public void setAdrLocation(String adrLocation) {
		this.adrLocation = adrLocation;
	}

	public String getAdrPob() {
		return this.adrPob;
	}

	public void setAdrPob(String adrPob) {
		this.adrPob = adrPob;
	}

	public String getAdrPrimaryLn() {
		return this.adrPrimaryLn;
	}

	public void setAdrPrimaryLn(String adrPrimaryLn) {
		this.adrPrimaryLn = adrPrimaryLn;
	}

	public String getAdrSecondaryLn() {
		return this.adrSecondaryLn;
	}

	public void setAdrSecondaryLn(String adrSecondaryLn) {
		this.adrSecondaryLn = adrSecondaryLn;
	}

	public Date getAdrSinceDate() {
		return this.adrSinceDate;
	}

	public void setAdrSinceDate(Date adrSinceDate) {
		this.adrSinceDate = adrSinceDate;
	}

	public String getAdrState() {
		return this.adrState;
	}

	public void setAdrState(String adrState) {
		this.adrState = adrState;
	}

	public String getAdrStreetName() {
		return this.adrStreetName;
	}

	public void setAdrStreetName(String adrStreetName) {
		this.adrStreetName = adrStreetName;
	}

	public String getAdrType() {
		return this.adrType;
	}

	public void setAdrType(String adrType) {
		this.adrType = adrType;
	}

	public String getAdrValidityCode() {
		return this.adrValidityCode;
	}

	public void setAdrValidityCode(String adrValidityCode) {
		this.adrValidityCode = adrValidityCode;
	}

	public String getAdrVillage() {
		return this.adrVillage;
	}

	public void setAdrVillage(String adrVillage) {
		this.adrVillage = adrVillage;
	}

	public String getAdrZip() {
		return this.adrZip;
	}

	public void setAdrZip(String adrZip) {
		this.adrZip = adrZip;
	}

	public String getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getBillFormat() {
		return this.billFormat;
	}

	public void setBillFormat(String billFormat) {
		this.billFormat = billFormat;
	}

	public BigDecimal getConvRunNo() {
		return this.convRunNo;
	}

	public void setConvRunNo(BigDecimal convRunNo) {
		this.convRunNo = convRunNo;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public BigDecimal getNumOfBillCopies() {
		return this.numOfBillCopies;
	}

	public void setNumOfBillCopies(BigDecimal numOfBillCopies) {
		this.numOfBillCopies = numOfBillCopies;
	}

	public BigDecimal getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(BigDecimal operatorId) {
		this.operatorId = operatorId;
	}

	public String getSubDistrict() {
		return this.subDistrict;
	}

	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}

	public String getSummaryPageInd() {
		return this.summaryPageInd;
	}

	public void setSummaryPageInd(String summaryPageInd) {
		this.summaryPageInd = summaryPageInd;
	}

	public Date getSysCreationDate() {
		return this.sysCreationDate;
	}

	public void setSysCreationDate(Date sysCreationDate) {
		this.sysCreationDate = sysCreationDate;
	}

	public Date getSysUpdateDate() {
		return this.sysUpdateDate;
	}

	public void setSysUpdateDate(Date sysUpdateDate) {
		this.sysUpdateDate = sysUpdateDate;
	}

	public String getTimeAtAddr() {
		return this.timeAtAddr;
	}

	public void setTimeAtAddr(String timeAtAddr) {
		this.timeAtAddr = timeAtAddr;
	}

}