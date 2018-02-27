package truecorp.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressNameLinkDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("linkSeqNo")
	private long linkSeqNo;

	@JsonProperty("addressData")
	private AddressDataDto addressData;

	@JsonProperty("adrCity")
	private String adrCity;

	@JsonProperty("adrZip")
	private String adrZip;

	@JsonProperty("applicationId")
	private String applicationId;

	@JsonProperty("ban")
	private BigDecimal ban;

	@JsonProperty("ben")
	private BigDecimal ben;

	@JsonProperty("convRunNo")
	private BigDecimal convRunNo;

	@JsonProperty("customer")
	private CustomerDto customer;

	@JsonProperty("dlServiceCode")
	private String dlServiceCode;

	@JsonProperty("dlUpdateStamp")
	private BigDecimal dlUpdateStamp;

	@JsonProperty("effectiveDate")
	private Date effectiveDate;

	@JsonProperty("expirationDate")
	private Date expirationDate;

	@JsonProperty("firstControl")
	private String firstControl;

	@JsonProperty("foreignSeqNo")
	private BigDecimal foreignSeqNo;

	@JsonProperty("lastControl")
	private String lastControl;

	@JsonProperty("linkType")
	private String linkType;

	@JsonProperty("nameData")
	private NameDataDto nameData;

	@JsonProperty("operatorId")
	private BigDecimal operatorId;

	@JsonProperty("subscriberNo")
	private String subscriberNo;

	@JsonProperty("sysCreationDate")
	private Date sysCreationDate;

	@JsonProperty("sysUpdateDate")
	private Date sysUpdateDate;

	public long getLinkSeqNo() {
		return this.linkSeqNo;
	}

	public void setLinkSeqNo(long linkSeqNo) {
		this.linkSeqNo = linkSeqNo;
	}

	public String getAdrCity() {
		return this.adrCity;
	}

	public void setAdrCity(String adrCity) {
		this.adrCity = adrCity;
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

	public BigDecimal getBan() {
		return this.ban;
	}

	public void setBan(BigDecimal ban) {
		this.ban = ban;
	}

	public BigDecimal getBen() {
		return this.ben;
	}

	public void setBen(BigDecimal ben) {
		this.ben = ben;
	}

	public BigDecimal getConvRunNo() {
		return this.convRunNo;
	}

	public void setConvRunNo(BigDecimal convRunNo) {
		this.convRunNo = convRunNo;
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getFirstControl() {
		return this.firstControl;
	}

	public void setFirstControl(String firstControl) {
		this.firstControl = firstControl;
	}

	public BigDecimal getForeignSeqNo() {
		return this.foreignSeqNo;
	}

	public void setForeignSeqNo(BigDecimal foreignSeqNo) {
		this.foreignSeqNo = foreignSeqNo;
	}

	public String getLastControl() {
		return this.lastControl;
	}

	public void setLastControl(String lastControl) {
		this.lastControl = lastControl;
	}

	public String getLinkType() {
		return this.linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}

	public BigDecimal getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(BigDecimal operatorId) {
		this.operatorId = operatorId;
	}

	public String getSubscriberNo() {
		return this.subscriberNo;
	}

	public void setSubscriberNo(String subscriberNo) {
		this.subscriberNo = subscriberNo;
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

	public AddressDataDto getAddressData() {
		if (addressData == null) {
			addressData = new AddressDataDto();
		}
		return addressData;
	}

	public void setAddressData(AddressDataDto addressData) {
		this.addressData = addressData;
	}

	public CustomerDto getCustomer() {
		if (customer == null) {
			customer = new CustomerDto();
		}
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public NameDataDto getNameData() {
		if (nameData == null) {
			nameData = new NameDataDto();
		}
		return nameData;
	}

	public void setNameData(NameDataDto nameData) {
		this.nameData = nameData;
	}
}