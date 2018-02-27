package truecorp.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class SubscriberDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private SubscriberPKDto id;

	@JsonProperty("activateWaiverRsn")
	private String activateWaiverRsn;

	@JsonProperty("agrContractExpireDate")
	private Date agrContractExpireDate;

	@JsonProperty("agrContractNumber")
	private String agrContractNumber;

	@JsonProperty("agrContractStartDate")
	private Date agrContractStartDate;

	@JsonProperty("agrFee")
	private BigDecimal agrFee;

	@JsonProperty("agrProposition")
	private String agrProposition;

	@JsonProperty("agrTerms")
	private BigDecimal agrTerms;

	@JsonProperty("allocationCode1")
	private String allocationCode1;

	@JsonProperty("allocationCode2")
	private String allocationCode2;

	@JsonProperty("applicationDate")
	private Date applicationDate;

	@JsonProperty("applicationId")
	private String applicationId;

	@JsonProperty("areaCode")
	private String areaCode;

	@JsonProperty("barringInd")
	private String barringInd;

	@JsonProperty("birthDate")
	private Date birthDate;

	@JsonProperty("broughtBan")
	private BigDecimal broughtBan;

	@JsonProperty("cdLicense")
	private String cdLicense;

	@JsonProperty("commisionVariant")
	private String commisionVariant;

	@JsonProperty("commitOrigNoMonth")
	private BigDecimal commitOrigNoMonth;

	@JsonProperty("commitStartDate")
	private Date commitStartDate;

	@JsonProperty("commitmentEndDate")
	private String commitmentEndDate;

	@JsonProperty("contactLanguage")
	private String contactLanguage;

	@JsonProperty("contractInd")
	private String contractInd;

	@JsonProperty("convRunNo")
	private BigDecimal convRunNo;

	@JsonProperty("covergenceFlag")
	private String covergenceFlag;

	@JsonProperty("creditLimit")
	private BigDecimal creditLimit;

	@JsonProperty("creditLimitDate")
	private Date creditLimitDate;

	@JsonProperty("creditLimitRsnCode")
	private String creditLimitRsnCode;

	@JsonProperty("creditResultId")
	private BigDecimal creditResultId;

	@JsonProperty("csRelatedBan")
	private BigDecimal csRelatedBan;

	@JsonProperty("ctnSeqNo")
	private BigDecimal ctnSeqNo;

	@JsonProperty("customerBan")
	private BigDecimal customerBan;

	@JsonProperty("dealerCode")
	private String dealerCode;

	@JsonProperty("defaultOcBen")
	private BigDecimal defaultOcBen;

	@JsonProperty("defaultRcBen")
	private BigDecimal defaultRcBen;

	@JsonProperty("defaultUcBen")
	private BigDecimal defaultUcBen;

	@JsonProperty("deleteCallCd")
	private String deleteCallCd;

	@JsonProperty("dlServiceCode")
	private String dlServiceCode;

	@JsonProperty("dlUpdateStamp")
	private BigDecimal dlUpdateStamp;

	@JsonProperty("docId")
	private String docId;

	@JsonProperty("earliestActvDate")
	private Date earliestActvDate;

	@JsonProperty("effectiveDate")
	private Date effectiveDate;

	@JsonProperty("euReqDepositAmt")
	private BigDecimal euReqDepositAmt;

	@JsonProperty("externalId")
	private String externalId;

	@JsonProperty("firstChangePpInd")
	private String firstChangePpInd;

	@JsonProperty("hideLastDigitInd")
	private String hideLastDigitInd;

	@JsonProperty("initActivationDate")
	private Date initActivationDate;

	@JsonProperty("initialDealerCode")
	private String initialDealerCode;

	@JsonProperty("insurClaimsCnt")
	private BigDecimal insurClaimsCnt;

	@JsonProperty("internetUserId")
	private String internetUserId;

	@JsonProperty("listedInd")
	private String listedInd;

	@JsonProperty("marketingChannel")
	private String marketingChannel;

	@JsonProperty("networkCode")
	private String networkCode;

	@JsonProperty("nextBan")
	private BigDecimal nextBan;

	@JsonProperty("nextBanMoveDate")
	private Date nextBanMoveDate;

	@JsonProperty("nextCtn")
	private String nextCtn;

	@JsonProperty("nextCtnChgDate")
	private Date nextCtnChgDate;

	@JsonProperty("niceNumWaiveInd")
	private String niceNumWaiveInd;

	@JsonProperty("niceNumWaiveRsn")
	private String niceNumWaiveRsn;

	@JsonProperty("niceNumberInd")
	private String niceNumberInd;

	@JsonProperty("niceNumberReason")
	private String niceNumberReason;

	@JsonProperty("noticeDate")
	private String noticeDate;

	@JsonProperty("operatorId")
	private BigDecimal operatorId;

	@JsonProperty("orderEntryNum")
	private String orderEntryNum;

	@JsonProperty("portFromNpCode")
	private String portFromNpCode;

	@JsonProperty("portFromSpCode")
	private String portFromSpCode;

	@JsonProperty("portToNpCode")
	private String portToNpCode;

	@JsonProperty("portToSpCode")
	private String portToSpCode;

	@JsonProperty("portedNumberInd")
	private String portedNumberInd;

	@JsonProperty("posFlag")
	private String posFlag;

	@JsonProperty("preSelectionInd")
	private String preSelectionInd;

	@JsonProperty("productSubtype")
	private String productSubtype;

	@JsonProperty("productType")
	private String productType;

	@JsonProperty("proofDate")
	private Date proofDate;

	@JsonProperty("proofInd")
	private String proofInd;

	@JsonProperty("prvBan")
	private BigDecimal prvBan;

	@JsonProperty("prvBanMoveDate")
	private Date prvBanMoveDate;

	@JsonProperty("prvCtn")
	private String prvCtn;

	@JsonProperty("prvCtnChgDate")
	private Date prvCtnChgDate;

	@JsonProperty("relatedMsisdn")
	private String relatedMsisdn;

	@JsonProperty("reqDepositAmt")
	private BigDecimal reqDepositAmt;

	@JsonProperty("reqEndGracePeriod")
	private Date reqEndGracePeriod;

	@JsonProperty("reqStGracePeriod")
	private Date reqStGracePeriod;

	@JsonProperty("retentionCode")
	private String retentionCode;

	@JsonProperty("smsLanguage")
	private String smsLanguage;

	@JsonProperty("subActvLocation")
	private String subActvLocation;

	@JsonProperty("subGroupNo")
	private BigDecimal subGroupNo;

	@JsonProperty("subStatus")
	private String subStatus;

	@JsonProperty("subStatusDate")
	private Date subStatusDate;

	@JsonProperty("subStatusLastAct")
	private String subStatusLastAct;

	@JsonProperty("subStatusRsnCode")
	private String subStatusRsnCode;

	@JsonProperty("subStsIssueDate")
	private Date subStsIssueDate;

	@JsonProperty("subscriberPassword")
	private String subscriberPassword;

	@JsonProperty("suspRcRateType")
	private String suspRcRateType;

	@JsonProperty("sysCreationDate")
	private Date sysCreationDate;

	@JsonProperty("sysUpdateDate")
	private Date sysUpdateDate;

	@JsonProperty("temporaryInd")
	private String temporaryInd;

	@JsonProperty("wpDqInd")
	private String wpDqInd;

	@JsonProperty("wpElectInd")
	private String wpElectInd;

	@JsonProperty("wpId")
	private String wpId;

	@JsonProperty("wpPrintInd")
	private String wpPrintInd;

	@JsonProperty("wpStatus")
	private String wpStatus;

	public SubscriberDto() {
	}

	public SubscriberPKDto getId() {
		return this.id;
	}

	public void setId(SubscriberPKDto id) {
		this.id = id;
	}

	public String getActivateWaiverRsn() {
		return this.activateWaiverRsn;
	}

	public void setActivateWaiverRsn(String activateWaiverRsn) {
		this.activateWaiverRsn = activateWaiverRsn;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getAgrContractExpireDate() {
		return this.agrContractExpireDate;
	}

	public void setAgrContractExpireDate(Date agrContractExpireDate) {
		this.agrContractExpireDate = agrContractExpireDate;
	}

	public String getAgrContractNumber() {
		return this.agrContractNumber;
	}

	public void setAgrContractNumber(String agrContractNumber) {
		this.agrContractNumber = agrContractNumber;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getAgrContractStartDate() {
		return this.agrContractStartDate;
	}

	public void setAgrContractStartDate(Date agrContractStartDate) {
		this.agrContractStartDate = agrContractStartDate;
	}

	public BigDecimal getAgrFee() {
		return this.agrFee;
	}

	public void setAgrFee(BigDecimal agrFee) {
		this.agrFee = agrFee;
	}

	public String getAgrProposition() {
		return this.agrProposition;
	}

	public void setAgrProposition(String agrProposition) {
		this.agrProposition = agrProposition;
	}

	public BigDecimal getAgrTerms() {
		return this.agrTerms;
	}

	public void setAgrTerms(BigDecimal agrTerms) {
		this.agrTerms = agrTerms;
	}

	public String getAllocationCode1() {
		return this.allocationCode1;
	}

	public void setAllocationCode1(String allocationCode1) {
		this.allocationCode1 = allocationCode1;
	}

	public String getAllocationCode2() {
		return this.allocationCode2;
	}

	public void setAllocationCode2(String allocationCode2) {
		this.allocationCode2 = allocationCode2;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getApplicationDate() {
		return this.applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getBarringInd() {
		return this.barringInd;
	}

	public void setBarringInd(String barringInd) {
		this.barringInd = barringInd;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public BigDecimal getBroughtBan() {
		return this.broughtBan;
	}

	public void setBroughtBan(BigDecimal broughtBan) {
		this.broughtBan = broughtBan;
	}

	public String getCdLicense() {
		return this.cdLicense;
	}

	public void setCdLicense(String cdLicense) {
		this.cdLicense = cdLicense;
	}

	public String getCommisionVariant() {
		return this.commisionVariant;
	}

	public void setCommisionVariant(String commisionVariant) {
		this.commisionVariant = commisionVariant;
	}

	public BigDecimal getCommitOrigNoMonth() {
		return this.commitOrigNoMonth;
	}

	public void setCommitOrigNoMonth(BigDecimal commitOrigNoMonth) {
		this.commitOrigNoMonth = commitOrigNoMonth;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getCommitStartDate() {
		return this.commitStartDate;
	}

	public void setCommitStartDate(Date commitStartDate) {
		this.commitStartDate = commitStartDate;
	}

	public String getCommitmentEndDate() {
		return this.commitmentEndDate;
	}

	public void setCommitmentEndDate(String commitmentEndDate) {
		this.commitmentEndDate = commitmentEndDate;
	}

	public String getContactLanguage() {
		return this.contactLanguage;
	}

	public void setContactLanguage(String contactLanguage) {
		this.contactLanguage = contactLanguage;
	}

	public String getContractInd() {
		return this.contractInd;
	}

	public void setContractInd(String contractInd) {
		this.contractInd = contractInd;
	}

	public BigDecimal getConvRunNo() {
		return this.convRunNo;
	}

	public void setConvRunNo(BigDecimal convRunNo) {
		this.convRunNo = convRunNo;
	}

	public String getCovergenceFlag() {
		return this.covergenceFlag;
	}

	public void setCovergenceFlag(String covergenceFlag) {
		this.covergenceFlag = covergenceFlag;
	}

	public BigDecimal getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Date getCreditLimitDate() {
		return this.creditLimitDate;
	}

	public void setCreditLimitDate(Date creditLimitDate) {
		this.creditLimitDate = creditLimitDate;
	}

	public String getCreditLimitRsnCode() {
		return this.creditLimitRsnCode;
	}

	public void setCreditLimitRsnCode(String creditLimitRsnCode) {
		this.creditLimitRsnCode = creditLimitRsnCode;
	}

	public BigDecimal getCreditResultId() {
		return this.creditResultId;
	}

	public void setCreditResultId(BigDecimal creditResultId) {
		this.creditResultId = creditResultId;
	}

	public BigDecimal getCsRelatedBan() {
		return this.csRelatedBan;
	}

	public void setCsRelatedBan(BigDecimal csRelatedBan) {
		this.csRelatedBan = csRelatedBan;
	}

	public BigDecimal getCtnSeqNo() {
		return this.ctnSeqNo;
	}

	public void setCtnSeqNo(BigDecimal ctnSeqNo) {
		this.ctnSeqNo = ctnSeqNo;
	}

	public BigDecimal getCustomerBan() {
		return this.customerBan;
	}

	public void setCustomerBan(BigDecimal customerBan) {
		this.customerBan = customerBan;
	}

	public String getDealerCode() {
		return this.dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public BigDecimal getDefaultOcBen() {
		return this.defaultOcBen;
	}

	public void setDefaultOcBen(BigDecimal defaultOcBen) {
		this.defaultOcBen = defaultOcBen;
	}

	public BigDecimal getDefaultRcBen() {
		return this.defaultRcBen;
	}

	public void setDefaultRcBen(BigDecimal defaultRcBen) {
		this.defaultRcBen = defaultRcBen;
	}

	public BigDecimal getDefaultUcBen() {
		return this.defaultUcBen;
	}

	public void setDefaultUcBen(BigDecimal defaultUcBen) {
		this.defaultUcBen = defaultUcBen;
	}

	public String getDeleteCallCd() {
		return this.deleteCallCd;
	}

	public void setDeleteCallCd(String deleteCallCd) {
		this.deleteCallCd = deleteCallCd;
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

	public String getDocId() {
		return this.docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getEarliestActvDate() {
		return this.earliestActvDate;
	}

	public void setEarliestActvDate(Date earliestActvDate) {
		this.earliestActvDate = earliestActvDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public BigDecimal getEuReqDepositAmt() {
		return this.euReqDepositAmt;
	}

	public void setEuReqDepositAmt(BigDecimal euReqDepositAmt) {
		this.euReqDepositAmt = euReqDepositAmt;
	}

	public String getExternalId() {
		return this.externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getFirstChangePpInd() {
		return this.firstChangePpInd;
	}

	public void setFirstChangePpInd(String firstChangePpInd) {
		this.firstChangePpInd = firstChangePpInd;
	}

	public String getHideLastDigitInd() {
		return this.hideLastDigitInd;
	}

	public void setHideLastDigitInd(String hideLastDigitInd) {
		this.hideLastDigitInd = hideLastDigitInd;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getInitActivationDate() {
		return this.initActivationDate;
	}

	public void setInitActivationDate(Date initActivationDate) {
		this.initActivationDate = initActivationDate;
	}

	public String getInitialDealerCode() {
		return this.initialDealerCode;
	}

	public void setInitialDealerCode(String initialDealerCode) {
		this.initialDealerCode = initialDealerCode;
	}

	public BigDecimal getInsurClaimsCnt() {
		return this.insurClaimsCnt;
	}

	public void setInsurClaimsCnt(BigDecimal insurClaimsCnt) {
		this.insurClaimsCnt = insurClaimsCnt;
	}

	public String getInternetUserId() {
		return this.internetUserId;
	}

	public void setInternetUserId(String internetUserId) {
		this.internetUserId = internetUserId;
	}

	public String getListedInd() {
		return this.listedInd;
	}

	public void setListedInd(String listedInd) {
		this.listedInd = listedInd;
	}

	public String getMarketingChannel() {
		return this.marketingChannel;
	}

	public void setMarketingChannel(String marketingChannel) {
		this.marketingChannel = marketingChannel;
	}

	public String getNetworkCode() {
		return this.networkCode;
	}

	public void setNetworkCode(String networkCode) {
		this.networkCode = networkCode;
	}

	public BigDecimal getNextBan() {
		return this.nextBan;
	}

	public void setNextBan(BigDecimal nextBan) {
		this.nextBan = nextBan;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getNextBanMoveDate() {
		return this.nextBanMoveDate;
	}

	public void setNextBanMoveDate(Date nextBanMoveDate) {
		this.nextBanMoveDate = nextBanMoveDate;
	}

	public String getNextCtn() {
		return this.nextCtn;
	}

	public void setNextCtn(String nextCtn) {
		this.nextCtn = nextCtn;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getNextCtnChgDate() {
		return this.nextCtnChgDate;
	}

	public void setNextCtnChgDate(Date nextCtnChgDate) {
		this.nextCtnChgDate = nextCtnChgDate;
	}

	public String getNiceNumWaiveInd() {
		return this.niceNumWaiveInd;
	}

	public void setNiceNumWaiveInd(String niceNumWaiveInd) {
		this.niceNumWaiveInd = niceNumWaiveInd;
	}

	public String getNiceNumWaiveRsn() {
		return this.niceNumWaiveRsn;
	}

	public void setNiceNumWaiveRsn(String niceNumWaiveRsn) {
		this.niceNumWaiveRsn = niceNumWaiveRsn;
	}

	public String getNiceNumberInd() {
		return this.niceNumberInd;
	}

	public void setNiceNumberInd(String niceNumberInd) {
		this.niceNumberInd = niceNumberInd;
	}

	public String getNiceNumberReason() {
		return this.niceNumberReason;
	}

	public void setNiceNumberReason(String niceNumberReason) {
		this.niceNumberReason = niceNumberReason;
	}

	public String getNoticeDate() {
		return this.noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public BigDecimal getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(BigDecimal operatorId) {
		this.operatorId = operatorId;
	}

	public String getOrderEntryNum() {
		return this.orderEntryNum;
	}

	public void setOrderEntryNum(String orderEntryNum) {
		this.orderEntryNum = orderEntryNum;
	}

	public String getPortFromNpCode() {
		return this.portFromNpCode;
	}

	public void setPortFromNpCode(String portFromNpCode) {
		this.portFromNpCode = portFromNpCode;
	}

	public String getPortFromSpCode() {
		return this.portFromSpCode;
	}

	public void setPortFromSpCode(String portFromSpCode) {
		this.portFromSpCode = portFromSpCode;
	}

	public String getPortToNpCode() {
		return this.portToNpCode;
	}

	public void setPortToNpCode(String portToNpCode) {
		this.portToNpCode = portToNpCode;
	}

	public String getPortToSpCode() {
		return this.portToSpCode;
	}

	public void setPortToSpCode(String portToSpCode) {
		this.portToSpCode = portToSpCode;
	}

	public String getPortedNumberInd() {
		return this.portedNumberInd;
	}

	public void setPortedNumberInd(String portedNumberInd) {
		this.portedNumberInd = portedNumberInd;
	}

	public String getPosFlag() {
		return this.posFlag;
	}

	public void setPosFlag(String posFlag) {
		this.posFlag = posFlag;
	}

	public String getPreSelectionInd() {
		return this.preSelectionInd;
	}

	public void setPreSelectionInd(String preSelectionInd) {
		this.preSelectionInd = preSelectionInd;
	}

	public String getProductSubtype() {
		return this.productSubtype;
	}

	public void setProductSubtype(String productSubtype) {
		this.productSubtype = productSubtype;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getProofDate() {
		return this.proofDate;
	}

	public void setProofDate(Date proofDate) {
		this.proofDate = proofDate;
	}

	public String getProofInd() {
		return this.proofInd;
	}

	public void setProofInd(String proofInd) {
		this.proofInd = proofInd;
	}

	public BigDecimal getPrvBan() {
		return this.prvBan;
	}

	public void setPrvBan(BigDecimal prvBan) {
		this.prvBan = prvBan;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getPrvBanMoveDate() {
		return this.prvBanMoveDate;
	}

	public void setPrvBanMoveDate(Date prvBanMoveDate) {
		this.prvBanMoveDate = prvBanMoveDate;
	}

	public String getPrvCtn() {
		return this.prvCtn;
	}

	public void setPrvCtn(String prvCtn) {
		this.prvCtn = prvCtn;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getPrvCtnChgDate() {
		return this.prvCtnChgDate;
	}

	public void setPrvCtnChgDate(Date prvCtnChgDate) {
		this.prvCtnChgDate = prvCtnChgDate;
	}

	public String getRelatedMsisdn() {
		return this.relatedMsisdn;
	}

	public void setRelatedMsisdn(String relatedMsisdn) {
		this.relatedMsisdn = relatedMsisdn;
	}

	public BigDecimal getReqDepositAmt() {
		return this.reqDepositAmt;
	}

	public void setReqDepositAmt(BigDecimal reqDepositAmt) {
		this.reqDepositAmt = reqDepositAmt;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getReqEndGracePeriod() {
		return this.reqEndGracePeriod;
	}

	public void setReqEndGracePeriod(Date reqEndGracePeriod) {
		this.reqEndGracePeriod = reqEndGracePeriod;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getReqStGracePeriod() {
		return this.reqStGracePeriod;
	}

	public void setReqStGracePeriod(Date reqStGracePeriod) {
		this.reqStGracePeriod = reqStGracePeriod;
	}

	public String getRetentionCode() {
		return this.retentionCode;
	}

	public void setRetentionCode(String retentionCode) {
		this.retentionCode = retentionCode;
	}

	public String getSmsLanguage() {
		return this.smsLanguage;
	}

	public void setSmsLanguage(String smsLanguage) {
		this.smsLanguage = smsLanguage;
	}

	public String getSubActvLocation() {
		return this.subActvLocation;
	}

	public void setSubActvLocation(String subActvLocation) {
		this.subActvLocation = subActvLocation;
	}

	public BigDecimal getSubGroupNo() {
		return this.subGroupNo;
	}

	public void setSubGroupNo(BigDecimal subGroupNo) {
		this.subGroupNo = subGroupNo;
	}

	public String getSubStatus() {
		return this.subStatus;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getSubStatusDate() {
		return this.subStatusDate;
	}

	public void setSubStatusDate(Date subStatusDate) {
		this.subStatusDate = subStatusDate;
	}

	public String getSubStatusLastAct() {
		return this.subStatusLastAct;
	}

	public void setSubStatusLastAct(String subStatusLastAct) {
		this.subStatusLastAct = subStatusLastAct;
	}

	public String getSubStatusRsnCode() {
		return this.subStatusRsnCode;
	}

	public void setSubStatusRsnCode(String subStatusRsnCode) {
		this.subStatusRsnCode = subStatusRsnCode;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getSubStsIssueDate() {
		return this.subStsIssueDate;
	}

	public void setSubStsIssueDate(Date subStsIssueDate) {
		this.subStsIssueDate = subStsIssueDate;
	}

	public String getSubscriberPassword() {
		return this.subscriberPassword;
	}

	public void setSubscriberPassword(String subscriberPassword) {
		this.subscriberPassword = subscriberPassword;
	}

	public String getSuspRcRateType() {
		return this.suspRcRateType;
	}

	public void setSuspRcRateType(String suspRcRateType) {
		this.suspRcRateType = suspRcRateType;
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

	public String getTemporaryInd() {
		return this.temporaryInd;
	}

	public void setTemporaryInd(String temporaryInd) {
		this.temporaryInd = temporaryInd;
	}

	public String getWpDqInd() {
		return this.wpDqInd;
	}

	public void setWpDqInd(String wpDqInd) {
		this.wpDqInd = wpDqInd;
	}

	public String getWpElectInd() {
		return this.wpElectInd;
	}

	public void setWpElectInd(String wpElectInd) {
		this.wpElectInd = wpElectInd;
	}

	public String getWpId() {
		return this.wpId;
	}

	public void setWpId(String wpId) {
		this.wpId = wpId;
	}

	public String getWpPrintInd() {
		return this.wpPrintInd;
	}

	public void setWpPrintInd(String wpPrintInd) {
		this.wpPrintInd = wpPrintInd;
	}

	public String getWpStatus() {
		return this.wpStatus;
	}

	public void setWpStatus(String wpStatus) {
		this.wpStatus = wpStatus;
	}

}