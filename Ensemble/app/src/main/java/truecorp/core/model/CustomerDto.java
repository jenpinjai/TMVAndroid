package truecorp.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class CustomerDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("customerId")
	private long customerId;

	@JsonProperty("accPassword")
	private String accPassword;

	@JsonProperty("agent")
	private String agent;

	@JsonProperty("applicationId")
	private String applicationId;

	@JsonProperty("assistantId")
	private BigDecimal assistantId;

	@JsonProperty("birthDate")
	private Date birthDate;

	@JsonProperty("birthPlace")
	private String birthPlace;

	@JsonProperty("blackListInd")
	private String blackListInd;

	@JsonProperty("blackListLevel")
	private String blackListLevel;

	@JsonProperty("blockAutoMail")
	private String blockAutoMail;

	@JsonProperty("businessEstDate")
	private Date businessEstDate;

	@JsonProperty("certificateAuthority")
	private String certificateAuthority;

	@JsonProperty("certificateNumber")
	private String certificateNumber;

	@JsonProperty("certificateType")
	private String certificateType;

	@JsonProperty("contactCoutryCode")
	private String contactCoutryCode;

	@JsonProperty("contactFaxno")
	private String contactFaxno;

	@JsonProperty("contactLanguage")
	private String contactLanguage;

	@JsonProperty("contactTelno")
	private String contactTelno;

	@JsonProperty("contactTnExtno")
	private BigDecimal contactTnExtno;

	@JsonProperty("convRunNo")
	private BigDecimal convRunNo;

	@JsonProperty("csmTreatmentLevel")
	private String csmTreatmentLevel;

	@JsonProperty("csrCode")
	private String csrCode;

	@JsonProperty("dlServiceCode")
	private String dlServiceCode;

	@JsonProperty("dlUpdateStamp")
	private BigDecimal dlUpdateStamp;

	@JsonProperty("email")
	private String email;

	@JsonProperty("emplotmentType")
	private String emplotmentType;

	@JsonProperty("employeePosition")
	private String employeePosition;

	@JsonProperty("employeeQty")
	private BigDecimal employeeQty;

	@JsonProperty("employmentDt")
	private String employmentDt;

	@JsonProperty("employmentTime")
	private String employmentTime;

	@JsonProperty("emplyrName")
	private String emplyrName;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("gurCrCardExpDt")
	private Date gurCrCardExpDt;

	@JsonProperty("gurCrCardNo")
	private String gurCrCardNo;

	@JsonProperty("gurCrCardType")
	private String gurCrCardType;

	@JsonProperty("homeTelno")
	private String homeTelno;

	@JsonProperty("idExprDate")
	private Date idExprDate;

	@JsonProperty("idType")
	private String idType;

	@JsonProperty("legacyCustomerNum")
	private String legacyCustomerNum;

	@JsonProperty("letterByEmailInd")
	private String letterByEmailInd;

	@JsonProperty("letterSendInd")
	private String letterSendInd;

	@JsonProperty("mailSupressionInd")
	private String mailSupressionInd;

	@JsonProperty("marketingChannel")
	private String marketingChannel;

	@JsonProperty("nationality")
	private String nationality;

	@JsonProperty("operatorId")
	private BigDecimal operatorId;

	@JsonProperty("otherExtno")
	private BigDecimal otherExtno;

	@JsonProperty("otherTelno")
	private String otherTelno;

	@JsonProperty("otherTnType")
	private String otherTnType;

	@JsonProperty("personalDetailsInd")
	private String personalDetailsInd;

	@JsonProperty("poaInd")
	private String poaInd;

	@JsonProperty("profession")
	private String profession;

	@JsonProperty("proof")
	private String proof;

	@JsonProperty("salary")
	private String salary;

	@JsonProperty("salesRep")
	private String salesRep;

	@JsonProperty("sicCode")
	private BigDecimal sicCode;

	@JsonProperty("sysCreationDate")
	private Date sysCreationDate;

	@JsonProperty("sysUpdateDate")
	private Date sysUpdateDate;

	@JsonProperty("technicalContact")
	private String technicalContact;

	@JsonProperty("verifiedDate")
	private Date verifiedDate;

	@JsonProperty("workFaxNo")
	private String workFaxNo;

	@JsonProperty("workPlace")
	private String workPlace;

	@JsonProperty("workTelno")
	private String workTelno;

	@JsonProperty("workTnExtno")
	private BigDecimal workTnExtno;

	@JsonProperty("yearsInBusiness")
	private BigDecimal yearsInBusiness;

	private String certificateDesc;
	
	public CustomerDto() {
	}

	public long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getAccPassword() {
		return this.accPassword;
	}

	public void setAccPassword(String accPassword) {
		this.accPassword = accPassword;
	}

	public String getAgent() {
		return this.agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public BigDecimal getAssistantId() {
		return this.assistantId;
	}

	public void setAssistantId(BigDecimal assistantId) {
		this.assistantId = assistantId;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getBlackListInd() {
		return this.blackListInd;
	}

	public void setBlackListInd(String blackListInd) {
		this.blackListInd = blackListInd;
	}

	public String getBlackListLevel() {
		return this.blackListLevel;
	}

	public void setBlackListLevel(String blackListLevel) {
		this.blackListLevel = blackListLevel;
	}

	public String getBlockAutoMail() {
		return this.blockAutoMail;
	}

	public void setBlockAutoMail(String blockAutoMail) {
		this.blockAutoMail = blockAutoMail;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getBusinessEstDate() {
		return this.businessEstDate;
	}

	public void setBusinessEstDate(Date businessEstDate) {
		this.businessEstDate = businessEstDate;
	}

	public String getCertificateAuthority() {
		return this.certificateAuthority;
	}

	public void setCertificateAuthority(String certificateAuthority) {
		this.certificateAuthority = certificateAuthority;
	}

	public String getCertificateNumber() {
		return this.certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getCertificateType() {
		return this.certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getContactCoutryCode() {
		return this.contactCoutryCode;
	}

	public void setContactCoutryCode(String contactCoutryCode) {
		this.contactCoutryCode = contactCoutryCode;
	}

	public String getContactFaxno() {
		return this.contactFaxno;
	}

	public void setContactFaxno(String contactFaxno) {
		this.contactFaxno = contactFaxno;
	}

	public String getContactLanguage() {
		return this.contactLanguage;
	}

	public void setContactLanguage(String contactLanguage) {
		this.contactLanguage = contactLanguage;
	}

	public String getContactTelno() {
		return this.contactTelno;
	}

	public void setContactTelno(String contactTelno) {
		this.contactTelno = contactTelno;
	}

	public BigDecimal getContactTnExtno() {
		return this.contactTnExtno;
	}

	public void setContactTnExtno(BigDecimal contactTnExtno) {
		this.contactTnExtno = contactTnExtno;
	}

	public BigDecimal getConvRunNo() {
		return this.convRunNo;
	}

	public void setConvRunNo(BigDecimal convRunNo) {
		this.convRunNo = convRunNo;
	}

	public String getCsmTreatmentLevel() {
		return this.csmTreatmentLevel;
	}

	public void setCsmTreatmentLevel(String csmTreatmentLevel) {
		this.csmTreatmentLevel = csmTreatmentLevel;
	}

	public String getCsrCode() {
		return this.csrCode;
	}

	public void setCsrCode(String csrCode) {
		this.csrCode = csrCode;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmplotmentType() {
		return this.emplotmentType;
	}

	public void setEmplotmentType(String emplotmentType) {
		this.emplotmentType = emplotmentType;
	}

	public String getEmployeePosition() {
		return this.employeePosition;
	}

	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}

	public BigDecimal getEmployeeQty() {
		return this.employeeQty;
	}

	public void setEmployeeQty(BigDecimal employeeQty) {
		this.employeeQty = employeeQty;
	}

	public String getEmploymentDt() {
		return this.employmentDt;
	}

	public void setEmploymentDt(String employmentDt) {
		this.employmentDt = employmentDt;
	}

	public String getEmploymentTime() {
		return this.employmentTime;
	}

	public void setEmploymentTime(String employmentTime) {
		this.employmentTime = employmentTime;
	}

	public String getEmplyrName() {
		return this.emplyrName;
	}

	public void setEmplyrName(String emplyrName) {
		this.emplyrName = emplyrName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getGurCrCardExpDt() {
		return this.gurCrCardExpDt;
	}

	public void setGurCrCardExpDt(Date gurCrCardExpDt) {
		this.gurCrCardExpDt = gurCrCardExpDt;
	}

	public String getGurCrCardNo() {
		return this.gurCrCardNo;
	}

	public void setGurCrCardNo(String gurCrCardNo) {
		this.gurCrCardNo = gurCrCardNo;
	}

	public String getGurCrCardType() {
		return this.gurCrCardType;
	}

	public void setGurCrCardType(String gurCrCardType) {
		this.gurCrCardType = gurCrCardType;
	}

	public String getHomeTelno() {
		return this.homeTelno;
	}

	public void setHomeTelno(String homeTelno) {
		this.homeTelno = homeTelno;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getIdExprDate() {
		return this.idExprDate;
	}

	public void setIdExprDate(Date idExprDate) {
		this.idExprDate = idExprDate;
	}

	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getLegacyCustomerNum() {
		return this.legacyCustomerNum;
	}

	public void setLegacyCustomerNum(String legacyCustomerNum) {
		this.legacyCustomerNum = legacyCustomerNum;
	}

	public String getLetterByEmailInd() {
		return this.letterByEmailInd;
	}

	public void setLetterByEmailInd(String letterByEmailInd) {
		this.letterByEmailInd = letterByEmailInd;
	}

	public String getLetterSendInd() {
		return this.letterSendInd;
	}

	public void setLetterSendInd(String letterSendInd) {
		this.letterSendInd = letterSendInd;
	}

	public String getMailSupressionInd() {
		return this.mailSupressionInd;
	}

	public void setMailSupressionInd(String mailSupressionInd) {
		this.mailSupressionInd = mailSupressionInd;
	}

	public String getMarketingChannel() {
		return this.marketingChannel;
	}

	public void setMarketingChannel(String marketingChannel) {
		this.marketingChannel = marketingChannel;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public BigDecimal getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(BigDecimal operatorId) {
		this.operatorId = operatorId;
	}

	public BigDecimal getOtherExtno() {
		return this.otherExtno;
	}

	public void setOtherExtno(BigDecimal otherExtno) {
		this.otherExtno = otherExtno;
	}

	public String getOtherTelno() {
		return this.otherTelno;
	}

	public void setOtherTelno(String otherTelno) {
		this.otherTelno = otherTelno;
	}

	public String getOtherTnType() {
		return this.otherTnType;
	}

	public void setOtherTnType(String otherTnType) {
		this.otherTnType = otherTnType;
	}

	public String getPersonalDetailsInd() {
		return this.personalDetailsInd;
	}

	public void setPersonalDetailsInd(String personalDetailsInd) {
		this.personalDetailsInd = personalDetailsInd;
	}

	public String getPoaInd() {
		return this.poaInd;
	}

	public void setPoaInd(String poaInd) {
		this.poaInd = poaInd;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getProof() {
		return this.proof;
	}

	public void setProof(String proof) {
		this.proof = proof;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getSalesRep() {
		return this.salesRep;
	}

	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}

	public BigDecimal getSicCode() {
		return this.sicCode;
	}

	public void setSicCode(BigDecimal sicCode) {
		this.sicCode = sicCode;
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

	public String getTechnicalContact() {
		return this.technicalContact;
	}

	public void setTechnicalContact(String technicalContact) {
		this.technicalContact = technicalContact;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getVerifiedDate() {
		return this.verifiedDate;
	}

	public void setVerifiedDate(Date verifiedDate) {
		this.verifiedDate = verifiedDate;
	}

	public String getWorkFaxNo() {
		return this.workFaxNo;
	}

	public void setWorkFaxNo(String workFaxNo) {
		this.workFaxNo = workFaxNo;
	}

	public String getWorkPlace() {
		return this.workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getWorkTelno() {
		return this.workTelno;
	}

	public void setWorkTelno(String workTelno) {
		this.workTelno = workTelno;
	}

	public BigDecimal getWorkTnExtno() {
		return this.workTnExtno;
	}

	public void setWorkTnExtno(BigDecimal workTnExtno) {
		this.workTnExtno = workTnExtno;
	}

	public BigDecimal getYearsInBusiness() {
		return this.yearsInBusiness;
	}

	public void setYearsInBusiness(BigDecimal yearsInBusiness) {
		this.yearsInBusiness = yearsInBusiness;
	}

	public String getCertificateDesc() {
		return certificateDesc;
	}

	public void setCertificateDesc(String certificateDesc) {
		this.certificateDesc = certificateDesc;
	}

}