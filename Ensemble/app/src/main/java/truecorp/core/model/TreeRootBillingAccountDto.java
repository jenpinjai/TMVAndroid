package truecorp.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TreeRootBillingAccountDto  implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonProperty("ban")
	private long ban;

	@JsonProperty("accountCategory")
	private String accountCategory;

	@JsonProperty("accountType")
	private String accountType;

	@JsonProperty("addValidInd")
	private String addValidInd;

	@JsonProperty("applicationId")
	private String applicationId;

	@JsonProperty("arBalance")
	private BigDecimal arBalance;

	@JsonProperty("arCaapMethod")
	private String arCaapMethod;

	@JsonProperty("arCompanyType")
	private String arCompanyType;

	@JsonProperty("arDebtRecoveryCode")
	private String arDebtRecoveryCode;

	@JsonProperty("arHandleCourtInd")
	private String arHandleCourtInd;

	@JsonProperty("arLawyerCode")
	private String arLawyerCode;

	@JsonProperty("arLawyerDate")
	private Date arLawyerDate;

	@JsonProperty("arProject")
	private String arProject;

	@JsonProperty("arResponsbltyGp")
	private String arResponsbltyGp;

	@JsonProperty("arSuitDataStatus")
	private String arSuitDataStatus;

	@JsonProperty("arTransType")
	private String arTransType;

	@JsonProperty("arWoInd")
	private String arWoInd;

	@JsonProperty("banStatus")
	private String banStatus;

	@JsonProperty("barringInd")
	private String barringInd;

	@JsonProperty("billCycle")
	private BigDecimal billCycle;

	@JsonProperty("billingLanguage")
	private String billingLanguage;

	@JsonProperty("blBillCycleMonth")
	private BigDecimal blBillCycleMonth;

	@JsonProperty("blBillFormat")
	private String blBillFormat;

	@JsonProperty("blBillProdInd")
	private String blBillProdInd;

	@JsonProperty("blCallMngrRepId")
	private BigDecimal blCallMngrRepId;

	@JsonProperty("blChangeCycleInd")
	private String blChangeCycleInd;

	@JsonProperty("blChgCycleReqStts")
	private String blChgCycleReqStts;

	@JsonProperty("blCompltDate")
	private Date blCompltDate;

	@JsonProperty("blCompltStatus")
	private String blCompltStatus;

	@JsonProperty("blDiskBillRepId")
	private BigDecimal blDiskBillRepId;

	@JsonProperty("blDocumentType")
	private String blDocumentType;

	@JsonProperty("blDunLetterDate")
	private Date blDunLetterDate;

	@JsonProperty("blHierBanInd")
	private String blHierBanInd;

	@JsonProperty("blLastCycCode")
	private BigDecimal blLastCycCode;

	@JsonProperty("blLastCycRunMnth")
	private BigDecimal blLastCycRunMnth;

	@JsonProperty("blLastCycRunYear")
	private BigDecimal blLastCycRunYear;

	@JsonProperty("blLastProdDate")
	private Date blLastProdDate;

	@JsonProperty("blMidCycleCallReq")
	private BigDecimal blMidCycleCallReq;

	@JsonProperty("blNewCycle")
	private BigDecimal blNewCycle;

	@JsonProperty("blNewCycleMonth")
	private BigDecimal blNewCycleMonth;

	@JsonProperty("blNewProdFreq")
	private BigDecimal blNewProdFreq;

	@JsonProperty("blProdFreq")
	private BigDecimal blProdFreq;

	@JsonProperty("blReqEndGracePrd")
	private Date blReqEndGracePrd;

	@JsonProperty("blReqStGracePrd")
	private Date blReqStGracePrd;

	@JsonProperty("blSpclBanCode")
	private String blSpclBanCode;

	@JsonProperty("blSuspRcRateType")
	private String blSuspRcRateType;

	@JsonProperty("blVatExemptDate")
	private Date blVatExemptDate;

	@JsonProperty("blVatExemptInd")
	private String blVatExemptInd;

	@JsonProperty("blVatExemptRefNo")
	private String blVatExemptRefNo;

	@JsonProperty("blVatExemptRsnCd")
	private String blVatExemptRsnCd;

	@JsonProperty("blVatRegNum")
	private String blVatRegNum;

	@JsonProperty("blZeroBalanceInd")
	private String blZeroBalanceInd;

	@JsonProperty("brandCode")
	private String brandCode;

	@JsonProperty("colAgncyAsdAmt")
	private BigDecimal colAgncyAsdAmt;

	@JsonProperty("colAgncyAsdDate")
	private Date colAgncyAsdDate;

	@JsonProperty("colAgncyCode")
	private String colAgncyCode;

	@JsonProperty("colAssignedColl")
	private String colAssignedColl;

	@JsonProperty("colCategoryNo")
	private BigDecimal colCategoryNo;

	@JsonProperty("colClmCalcAmt")
	private BigDecimal colClmCalcAmt;

	@JsonProperty("colClmCategoryNo")
	private BigDecimal colClmCategoryNo;

	@JsonProperty("colClmDelinqSts")
	private String colClmDelinqSts;

	@JsonProperty("colClmDelinqStsDate")
	private Date colClmDelinqStsDate;

	@JsonProperty("colClmNextStepDate")
	private Date colClmNextStepDate;

	@JsonProperty("colClmNextStepNo")
	private BigDecimal colClmNextStepNo;

	@JsonProperty("colClmNextStpAprCod")
	private String colClmNextStpAprCod;

	@JsonProperty("colClmNextStpAprCol")
	private String colClmNextStpAprCol;

	@JsonProperty("colClmOvwrtCd")
	private String colClmOvwrtCd;

	@JsonProperty("colClmOvwrtDate")
	private Date colClmOvwrtDate;

	@JsonProperty("colClmPathCode")
	private String colClmPathCode;

	@JsonProperty("colClmWaiveDate")
	private Date colClmWaiveDate;

	@JsonProperty("colClmWaiveEndDate")
	private Date colClmWaiveEndDate;

	@JsonProperty("colClmWaiveInd")
	private String colClmWaiveInd;

	@JsonProperty("colClmWaiveRsn")
	private String colClmWaiveRsn;

	@JsonProperty("colClmWaiveUid")
	private String colClmWaiveUid;

	@JsonProperty("colCode")
	private String colCode;

	@JsonProperty("colColctAsdDate")
	private Date colColctAsdDate;

	@JsonProperty("colDelinqStatus")
	private String colDelinqStatus;

	@JsonProperty("colDelinqStsDate")
	private Date colDelinqStsDate;

	@JsonProperty("colFirstCntctDate")
	private Date colFirstCntctDate;

	@JsonProperty("colFixedPath")
	private String colFixedPath;

	@JsonProperty("colNextStepDate")
	private Date colNextStepDate;

	@JsonProperty("colNextStepNo")
	private BigDecimal colNextStepNo;

	@JsonProperty("colNextStpAprCod")
	private String colNextStpAprCod;

	@JsonProperty("colNextStpAprCol")
	private String colNextStpAprCol;

	@JsonProperty("colPaInd")
	private String colPaInd;

	@JsonProperty("colPathCode")
	private String colPathCode;

	@JsonProperty("colRepGroup")
	private String colRepGroup;

	@JsonProperty("colSuspColTypes")
	private String colSuspColTypes;

	@JsonProperty("colWaiveEndDate")
	private Date colWaiveEndDate;

	@JsonProperty("colWaiverDate")
	private Date colWaiverDate;

	@JsonProperty("colWaiverInd")
	private String colWaiverInd;

	@JsonProperty("colWaiverRsnCd")
	private String colWaiverRsnCd;

	@JsonProperty("colWaiverUid")
	private String colWaiverUid;

	@JsonProperty("comfCallDetail")
	private String comfCallDetail;

	@JsonProperty("compCrdLmt")
	private BigDecimal compCrdLmt;

	@JsonProperty("companyRegisterNum")
	private String companyRegisterNum;

	@JsonProperty("companyTaxNum")
	private BigDecimal companyTaxNum;

	@JsonProperty("convRunNo")
	private BigDecimal convRunNo;

	@JsonProperty("crdlmtUpdDate")
	private Date crdlmtUpdDate;

	@JsonProperty("creditLimitAmt")
	private BigDecimal creditLimitAmt;

	@JsonProperty("csAddrSendInd")
	private String csAddrSendInd;

	@JsonProperty("csBanTrxOffInd")
	private String csBanTrxOffInd;

	@JsonProperty("csComEndDate")
	private Date csComEndDate;

	@JsonProperty("csComOrigNoMonth")
	private BigDecimal csComOrigNoMonth;

	@JsonProperty("csComReasonCode")
	private String csComReasonCode;

	@JsonProperty("csComStartDate")
	private Date csComStartDate;

	@JsonProperty("csDiscountCnt")
	private BigDecimal csDiscountCnt;

	@JsonProperty("csFollowUpsState")
	private String csFollowUpsState;

	@JsonProperty("csHandleByCtnInd")
	private String csHandleByCtnInd;

	@JsonProperty("csInitiationReason")
	private String csInitiationReason;

	@JsonProperty("csLockMechanism")
	private String csLockMechanism;

	@JsonProperty("csMinReqCtns")
	private BigDecimal csMinReqCtns;

	@JsonProperty("csOpenCtnExist")
	private String csOpenCtnExist;

	@JsonProperty("csPenPerMissCtn")
	private BigDecimal csPenPerMissCtn;

	@JsonProperty("csRelatedAccount")
	private BigDecimal csRelatedAccount;

	@JsonProperty("csSpecMemoInd")
	private String csSpecMemoInd;

	@JsonProperty("currRootBan")
	private BigDecimal currRootBan;

	@JsonProperty("currencyCode")
	private String currencyCode;

	@JsonProperty("currencyEffDate")
	private Date currencyEffDate;

	@JsonProperty("custSegment")
	private String custSegment;

	@JsonProperty("customer")
	private CustomerDto customer;

	@JsonProperty("dealerCode")
	private String dealerCode;

	@JsonProperty("defaultBen")
	private BigDecimal defaultBen;

	@JsonProperty("dlServiceCode")
	private String dlServiceCode;

	@JsonProperty("dlUpdateStamp")
	private BigDecimal dlUpdateStamp;

	@JsonProperty("dsptCounter")
	private BigDecimal dsptCounter;

	@JsonProperty("dsptWaiverCounter")
	private BigDecimal dsptWaiverCounter;

	@JsonProperty("euArBalance")
	private BigDecimal euArBalance;

	@JsonProperty("euColAgnAsdAmt")
	private BigDecimal euColAgnAsdAmt;

	@JsonProperty("euCompCrdLmt")
	private BigDecimal euCompCrdLmt;

	@JsonProperty("euCreditLimitAmt")
	private BigDecimal euCreditLimitAmt;

	@JsonProperty("euCsPenMissCtn")
	private BigDecimal euCsPenMissCtn;

	@JsonProperty("euUnallocatedAmt")
	private BigDecimal euUnallocatedAmt;

	@JsonProperty("forceFreqInd")
	private String forceFreqInd;

	@JsonProperty("fppId")
	private BigDecimal fppId;

	@JsonProperty("fppInd")
	private String fppInd;

	@JsonProperty("frameContractId")
	private BigDecimal frameContractId;

	@JsonProperty("hideLastDigitInd")
	private String hideLastDigitInd;

	@JsonProperty("histLastDate")
	private Date histLastDate;

	@JsonProperty("lastBckCode")
	private String lastBckCode;

	@JsonProperty("location")
	private String location;

	@JsonProperty("nextRootBan")
	private BigDecimal nextRootBan;

	@JsonProperty("nextRootBanEffDt")
	private String nextRootBanEffDt;

	@JsonProperty("operatorId")
	private BigDecimal operatorId;

	@JsonProperty("partRootBan")
	private BigDecimal partRootBan;

	@JsonProperty("payValidInd")
	private String payValidInd;

	@JsonProperty("randomGroup")
	private BigDecimal randomGroup;

	@JsonProperty("revenueSegment")
	private String revenueSegment;

	@JsonProperty("serviceLevel")
	private String serviceLevel;

	@JsonProperty("signOffAgreement")
	private String signOffAgreement;

	@JsonProperty("spMemoId")
	private BigDecimal spMemoId;

	@JsonProperty("startServiceDate")
	private Date startServiceDate;

	@JsonProperty("statusActvCode")
	private String statusActvCode;

	@JsonProperty("statusActvRsnCode")
	private String statusActvRsnCode;

	@JsonProperty("statusIssueDate")
	private Date statusIssueDate;

	@JsonProperty("statusLastDate")
	private Date statusLastDate;

	@JsonProperty("stmtInvInd")
	private String stmtInvInd;

	@JsonProperty("stmtReqInd")
	private String stmtReqInd;

	@JsonProperty("sysCreationDate")
	private Date sysCreationDate;

	@JsonProperty("sysUpdateDate")
	private Date sysUpdateDate;

	@JsonProperty("timeInBusiness")
	private String timeInBusiness;

	@JsonProperty("uidNumber")
	private String uidNumber;

	@JsonProperty("unallocatedAmt")
	private BigDecimal unallocatedAmt;
	
	@JsonProperty("addressNameLink")
	private List<AddressNameLinkDto> addressNameLink;

	public long getBan() {
		return this.ban;
	}

	public void setBan(long ban) {
		this.ban = ban;
	}

	public String getAccountCategory() {
		return this.accountCategory;
	}

	public void setAccountCategory(String accountCategory) {
		this.accountCategory = accountCategory;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAddValidInd() {
		return this.addValidInd;
	}

	public void setAddValidInd(String addValidInd) {
		this.addValidInd = addValidInd;
	}

	public String getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public BigDecimal getArBalance() {
		return this.arBalance;
	}

	public void setArBalance(BigDecimal arBalance) {
		this.arBalance = arBalance;
	}

	public String getArCaapMethod() {
		return this.arCaapMethod;
	}

	public void setArCaapMethod(String arCaapMethod) {
		this.arCaapMethod = arCaapMethod;
	}

	public String getArCompanyType() {
		return this.arCompanyType;
	}

	public void setArCompanyType(String arCompanyType) {
		this.arCompanyType = arCompanyType;
	}

	public String getArDebtRecoveryCode() {
		return this.arDebtRecoveryCode;
	}

	public void setArDebtRecoveryCode(String arDebtRecoveryCode) {
		this.arDebtRecoveryCode = arDebtRecoveryCode;
	}

	public String getArHandleCourtInd() {
		return this.arHandleCourtInd;
	}

	public void setArHandleCourtInd(String arHandleCourtInd) {
		this.arHandleCourtInd = arHandleCourtInd;
	}

	public String getArLawyerCode() {
		return this.arLawyerCode;
	}

	public void setArLawyerCode(String arLawyerCode) {
		this.arLawyerCode = arLawyerCode;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getArLawyerDate() {
		return this.arLawyerDate;
	}

	public void setArLawyerDate(Date arLawyerDate) {
		this.arLawyerDate = arLawyerDate;
	}

	public String getArProject() {
		return this.arProject;
	}

	public void setArProject(String arProject) {
		this.arProject = arProject;
	}

	public String getArResponsbltyGp() {
		return this.arResponsbltyGp;
	}

	public void setArResponsbltyGp(String arResponsbltyGp) {
		this.arResponsbltyGp = arResponsbltyGp;
	}

	public String getArSuitDataStatus() {
		return this.arSuitDataStatus;
	}

	public void setArSuitDataStatus(String arSuitDataStatus) {
		this.arSuitDataStatus = arSuitDataStatus;
	}

	public String getArTransType() {
		return this.arTransType;
	}

	public void setArTransType(String arTransType) {
		this.arTransType = arTransType;
	}

	public String getArWoInd() {
		return this.arWoInd;
	}

	public void setArWoInd(String arWoInd) {
		this.arWoInd = arWoInd;
	}

	public String getBanStatus() {
		return this.banStatus;
	}

	public void setBanStatus(String banStatus) {
		this.banStatus = banStatus;
	}

	public String getBarringInd() {
		return this.barringInd;
	}

	public void setBarringInd(String barringInd) {
		this.barringInd = barringInd;
	}

	public BigDecimal getBillCycle() {
		return this.billCycle;
	}

	public void setBillCycle(BigDecimal billCycle) {
		this.billCycle = billCycle;
	}

	public String getBillingLanguage() {
		return this.billingLanguage;
	}

	public void setBillingLanguage(String billingLanguage) {
		this.billingLanguage = billingLanguage;
	}

	public BigDecimal getBlBillCycleMonth() {
		return this.blBillCycleMonth;
	}

	public void setBlBillCycleMonth(BigDecimal blBillCycleMonth) {
		this.blBillCycleMonth = blBillCycleMonth;
	}

	public String getBlBillFormat() {
		return this.blBillFormat;
	}

	public void setBlBillFormat(String blBillFormat) {
		this.blBillFormat = blBillFormat;
	}

	public String getBlBillProdInd() {
		return this.blBillProdInd;
	}

	public void setBlBillProdInd(String blBillProdInd) {
		this.blBillProdInd = blBillProdInd;
	}

	public BigDecimal getBlCallMngrRepId() {
		return this.blCallMngrRepId;
	}

	public void setBlCallMngrRepId(BigDecimal blCallMngrRepId) {
		this.blCallMngrRepId = blCallMngrRepId;
	}

	public String getBlChangeCycleInd() {
		return this.blChangeCycleInd;
	}

	public void setBlChangeCycleInd(String blChangeCycleInd) {
		this.blChangeCycleInd = blChangeCycleInd;
	}

	public String getBlChgCycleReqStts() {
		return this.blChgCycleReqStts;
	}

	public void setBlChgCycleReqStts(String blChgCycleReqStts) {
		this.blChgCycleReqStts = blChgCycleReqStts;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getBlCompltDate() {
		return this.blCompltDate;
	}

	public void setBlCompltDate(Date blCompltDate) {
		this.blCompltDate = blCompltDate;
	}

	public String getBlCompltStatus() {
		return this.blCompltStatus;
	}

	public void setBlCompltStatus(String blCompltStatus) {
		this.blCompltStatus = blCompltStatus;
	}

	public BigDecimal getBlDiskBillRepId() {
		return this.blDiskBillRepId;
	}

	public void setBlDiskBillRepId(BigDecimal blDiskBillRepId) {
		this.blDiskBillRepId = blDiskBillRepId;
	}

	public String getBlDocumentType() {
		return this.blDocumentType;
	}

	public void setBlDocumentType(String blDocumentType) {
		this.blDocumentType = blDocumentType;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getBlDunLetterDate() {
		return this.blDunLetterDate;
	}

	public void setBlDunLetterDate(Date blDunLetterDate) {
		this.blDunLetterDate = blDunLetterDate;
	}

	public String getBlHierBanInd() {
		return this.blHierBanInd;
	}

	public void setBlHierBanInd(String blHierBanInd) {
		this.blHierBanInd = blHierBanInd;
	}

	public BigDecimal getBlLastCycCode() {
		return this.blLastCycCode;
	}

	public void setBlLastCycCode(BigDecimal blLastCycCode) {
		this.blLastCycCode = blLastCycCode;
	}

	public BigDecimal getBlLastCycRunMnth() {
		return this.blLastCycRunMnth;
	}

	public void setBlLastCycRunMnth(BigDecimal blLastCycRunMnth) {
		this.blLastCycRunMnth = blLastCycRunMnth;
	}

	public BigDecimal getBlLastCycRunYear() {
		return this.blLastCycRunYear;
	}

	public void setBlLastCycRunYear(BigDecimal blLastCycRunYear) {
		this.blLastCycRunYear = blLastCycRunYear;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getBlLastProdDate() {
		return this.blLastProdDate;
	}

	public void setBlLastProdDate(Date blLastProdDate) {
		this.blLastProdDate = blLastProdDate;
	}

	public BigDecimal getBlMidCycleCallReq() {
		return this.blMidCycleCallReq;
	}

	public void setBlMidCycleCallReq(BigDecimal blMidCycleCallReq) {
		this.blMidCycleCallReq = blMidCycleCallReq;
	}

	public BigDecimal getBlNewCycle() {
		return this.blNewCycle;
	}

	public void setBlNewCycle(BigDecimal blNewCycle) {
		this.blNewCycle = blNewCycle;
	}

	public BigDecimal getBlNewCycleMonth() {
		return this.blNewCycleMonth;
	}

	public void setBlNewCycleMonth(BigDecimal blNewCycleMonth) {
		this.blNewCycleMonth = blNewCycleMonth;
	}

	public BigDecimal getBlNewProdFreq() {
		return this.blNewProdFreq;
	}

	public void setBlNewProdFreq(BigDecimal blNewProdFreq) {
		this.blNewProdFreq = blNewProdFreq;
	}

	public BigDecimal getBlProdFreq() {
		return this.blProdFreq;
	}

	public void setBlProdFreq(BigDecimal blProdFreq) {
		this.blProdFreq = blProdFreq;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getBlReqEndGracePrd() {
		return this.blReqEndGracePrd;
	}

	public void setBlReqEndGracePrd(Date blReqEndGracePrd) {
		this.blReqEndGracePrd = blReqEndGracePrd;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getBlReqStGracePrd() {
		return this.blReqStGracePrd;
	}

	public void setBlReqStGracePrd(Date blReqStGracePrd) {
		this.blReqStGracePrd = blReqStGracePrd;
	}

	public String getBlSpclBanCode() {
		return this.blSpclBanCode;
	}

	public void setBlSpclBanCode(String blSpclBanCode) {
		this.blSpclBanCode = blSpclBanCode;
	}

	public String getBlSuspRcRateType() {
		return this.blSuspRcRateType;
	}

	public void setBlSuspRcRateType(String blSuspRcRateType) {
		this.blSuspRcRateType = blSuspRcRateType;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getBlVatExemptDate() {
		return this.blVatExemptDate;
	}

	public void setBlVatExemptDate(Date blVatExemptDate) {
		this.blVatExemptDate = blVatExemptDate;
	}

	public String getBlVatExemptInd() {
		return this.blVatExemptInd;
	}

	public void setBlVatExemptInd(String blVatExemptInd) {
		this.blVatExemptInd = blVatExemptInd;
	}

	public String getBlVatExemptRefNo() {
		return this.blVatExemptRefNo;
	}

	public void setBlVatExemptRefNo(String blVatExemptRefNo) {
		this.blVatExemptRefNo = blVatExemptRefNo;
	}

	public String getBlVatExemptRsnCd() {
		return this.blVatExemptRsnCd;
	}

	public void setBlVatExemptRsnCd(String blVatExemptRsnCd) {
		this.blVatExemptRsnCd = blVatExemptRsnCd;
	}

	public String getBlVatRegNum() {
		return this.blVatRegNum;
	}

	public void setBlVatRegNum(String blVatRegNum) {
		this.blVatRegNum = blVatRegNum;
	}

	public String getBlZeroBalanceInd() {
		return this.blZeroBalanceInd;
	}

	public void setBlZeroBalanceInd(String blZeroBalanceInd) {
		this.blZeroBalanceInd = blZeroBalanceInd;
	}

	public String getBrandCode() {
		return this.brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public BigDecimal getColAgncyAsdAmt() {
		return this.colAgncyAsdAmt;
	}

	public void setColAgncyAsdAmt(BigDecimal colAgncyAsdAmt) {
		this.colAgncyAsdAmt = colAgncyAsdAmt;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getColAgncyAsdDate() {
		return this.colAgncyAsdDate;
	}

	public void setColAgncyAsdDate(Date colAgncyAsdDate) {
		this.colAgncyAsdDate = colAgncyAsdDate;
	}

	public String getColAgncyCode() {
		return this.colAgncyCode;
	}

	public void setColAgncyCode(String colAgncyCode) {
		this.colAgncyCode = colAgncyCode;
	}

	public String getColAssignedColl() {
		return this.colAssignedColl;
	}

	public void setColAssignedColl(String colAssignedColl) {
		this.colAssignedColl = colAssignedColl;
	}

	public BigDecimal getColCategoryNo() {
		return this.colCategoryNo;
	}

	public void setColCategoryNo(BigDecimal colCategoryNo) {
		this.colCategoryNo = colCategoryNo;
	}

	public BigDecimal getColClmCalcAmt() {
		return this.colClmCalcAmt;
	}

	public void setColClmCalcAmt(BigDecimal colClmCalcAmt) {
		this.colClmCalcAmt = colClmCalcAmt;
	}

	public BigDecimal getColClmCategoryNo() {
		return this.colClmCategoryNo;
	}

	public void setColClmCategoryNo(BigDecimal colClmCategoryNo) {
		this.colClmCategoryNo = colClmCategoryNo;
	}

	public String getColClmDelinqSts() {
		return this.colClmDelinqSts;
	}

	public void setColClmDelinqSts(String colClmDelinqSts) {
		this.colClmDelinqSts = colClmDelinqSts;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getColClmDelinqStsDate() {
		return this.colClmDelinqStsDate;
	}

	public void setColClmDelinqStsDate(Date colClmDelinqStsDate) {
		this.colClmDelinqStsDate = colClmDelinqStsDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getColClmNextStepDate() {
		return this.colClmNextStepDate;
	}

	public void setColClmNextStepDate(Date colClmNextStepDate) {
		this.colClmNextStepDate = colClmNextStepDate;
	}

	public BigDecimal getColClmNextStepNo() {
		return this.colClmNextStepNo;
	}

	public void setColClmNextStepNo(BigDecimal colClmNextStepNo) {
		this.colClmNextStepNo = colClmNextStepNo;
	}

	public String getColClmNextStpAprCod() {
		return this.colClmNextStpAprCod;
	}

	public void setColClmNextStpAprCod(String colClmNextStpAprCod) {
		this.colClmNextStpAprCod = colClmNextStpAprCod;
	}

	public String getColClmNextStpAprCol() {
		return this.colClmNextStpAprCol;
	}

	public void setColClmNextStpAprCol(String colClmNextStpAprCol) {
		this.colClmNextStpAprCol = colClmNextStpAprCol;
	}

	public String getColClmOvwrtCd() {
		return this.colClmOvwrtCd;
	}

	public void setColClmOvwrtCd(String colClmOvwrtCd) {
		this.colClmOvwrtCd = colClmOvwrtCd;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getColClmOvwrtDate() {
		return this.colClmOvwrtDate;
	}

	public void setColClmOvwrtDate(Date colClmOvwrtDate) {
		this.colClmOvwrtDate = colClmOvwrtDate;
	}

	public String getColClmPathCode() {
		return this.colClmPathCode;
	}

	public void setColClmPathCode(String colClmPathCode) {
		this.colClmPathCode = colClmPathCode;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getColClmWaiveDate() {
		return this.colClmWaiveDate;
	}

	public void setColClmWaiveDate(Date colClmWaiveDate) {
		this.colClmWaiveDate = colClmWaiveDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getColClmWaiveEndDate() {
		return this.colClmWaiveEndDate;
	}

	public void setColClmWaiveEndDate(Date colClmWaiveEndDate) {
		this.colClmWaiveEndDate = colClmWaiveEndDate;
	}

	public String getColClmWaiveInd() {
		return this.colClmWaiveInd;
	}

	public void setColClmWaiveInd(String colClmWaiveInd) {
		this.colClmWaiveInd = colClmWaiveInd;
	}

	public String getColClmWaiveRsn() {
		return this.colClmWaiveRsn;
	}

	public void setColClmWaiveRsn(String colClmWaiveRsn) {
		this.colClmWaiveRsn = colClmWaiveRsn;
	}

	public String getColClmWaiveUid() {
		return this.colClmWaiveUid;
	}

	public void setColClmWaiveUid(String colClmWaiveUid) {
		this.colClmWaiveUid = colClmWaiveUid;
	}

	public String getColCode() {
		return this.colCode;
	}

	public void setColCode(String colCode) {
		this.colCode = colCode;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getColColctAsdDate() {
		return this.colColctAsdDate;
	}

	public void setColColctAsdDate(Date colColctAsdDate) {
		this.colColctAsdDate = colColctAsdDate;
	}

	public String getColDelinqStatus() {
		return this.colDelinqStatus;
	}

	public void setColDelinqStatus(String colDelinqStatus) {
		this.colDelinqStatus = colDelinqStatus;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getColDelinqStsDate() {
		return this.colDelinqStsDate;
	}

	public void setColDelinqStsDate(Date colDelinqStsDate) {
		this.colDelinqStsDate = colDelinqStsDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getColFirstCntctDate() {
		return this.colFirstCntctDate;
	}

	public void setColFirstCntctDate(Date colFirstCntctDate) {
		this.colFirstCntctDate = colFirstCntctDate;
	}

	public String getColFixedPath() {
		return this.colFixedPath;
	}

	public void setColFixedPath(String colFixedPath) {
		this.colFixedPath = colFixedPath;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getColNextStepDate() {
		return this.colNextStepDate;
	}

	public void setColNextStepDate(Date colNextStepDate) {
		this.colNextStepDate = colNextStepDate;
	}

	public BigDecimal getColNextStepNo() {
		return this.colNextStepNo;
	}

	public void setColNextStepNo(BigDecimal colNextStepNo) {
		this.colNextStepNo = colNextStepNo;
	}

	public String getColNextStpAprCod() {
		return this.colNextStpAprCod;
	}

	public void setColNextStpAprCod(String colNextStpAprCod) {
		this.colNextStpAprCod = colNextStpAprCod;
	}

	public String getColNextStpAprCol() {
		return this.colNextStpAprCol;
	}

	public void setColNextStpAprCol(String colNextStpAprCol) {
		this.colNextStpAprCol = colNextStpAprCol;
	}

	public String getColPaInd() {
		return this.colPaInd;
	}

	public void setColPaInd(String colPaInd) {
		this.colPaInd = colPaInd;
	}

	public String getColPathCode() {
		return this.colPathCode;
	}

	public void setColPathCode(String colPathCode) {
		this.colPathCode = colPathCode;
	}

	public String getColRepGroup() {
		return this.colRepGroup;
	}

	public void setColRepGroup(String colRepGroup) {
		this.colRepGroup = colRepGroup;
	}

	public String getColSuspColTypes() {
		return this.colSuspColTypes;
	}

	public void setColSuspColTypes(String colSuspColTypes) {
		this.colSuspColTypes = colSuspColTypes;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getColWaiveEndDate() {
		return this.colWaiveEndDate;
	}

	public void setColWaiveEndDate(Date colWaiveEndDate) {
		this.colWaiveEndDate = colWaiveEndDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getColWaiverDate() {
		return this.colWaiverDate;
	}

	public void setColWaiverDate(Date colWaiverDate) {
		this.colWaiverDate = colWaiverDate;
	}

	public String getColWaiverInd() {
		return this.colWaiverInd;
	}

	public void setColWaiverInd(String colWaiverInd) {
		this.colWaiverInd = colWaiverInd;
	}

	public String getColWaiverRsnCd() {
		return this.colWaiverRsnCd;
	}

	public void setColWaiverRsnCd(String colWaiverRsnCd) {
		this.colWaiverRsnCd = colWaiverRsnCd;
	}

	public String getColWaiverUid() {
		return this.colWaiverUid;
	}

	public void setColWaiverUid(String colWaiverUid) {
		this.colWaiverUid = colWaiverUid;
	}

	public String getComfCallDetail() {
		return this.comfCallDetail;
	}

	public void setComfCallDetail(String comfCallDetail) {
		this.comfCallDetail = comfCallDetail;
	}

	public BigDecimal getCompCrdLmt() {
		return this.compCrdLmt;
	}

	public void setCompCrdLmt(BigDecimal compCrdLmt) {
		this.compCrdLmt = compCrdLmt;
	}

	public String getCompanyRegisterNum() {
		return this.companyRegisterNum;
	}

	public void setCompanyRegisterNum(String companyRegisterNum) {
		this.companyRegisterNum = companyRegisterNum;
	}

	public BigDecimal getCompanyTaxNum() {
		return this.companyTaxNum;
	}

	public void setCompanyTaxNum(BigDecimal companyTaxNum) {
		this.companyTaxNum = companyTaxNum;
	}

	public BigDecimal getConvRunNo() {
		return this.convRunNo;
	}

	public void setConvRunNo(BigDecimal convRunNo) {
		this.convRunNo = convRunNo;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getCrdlmtUpdDate() {
		return this.crdlmtUpdDate;
	}

	public void setCrdlmtUpdDate(Date crdlmtUpdDate) {
		this.crdlmtUpdDate = crdlmtUpdDate;
	}

	public BigDecimal getCreditLimitAmt() {
		return this.creditLimitAmt;
	}

	public void setCreditLimitAmt(BigDecimal creditLimitAmt) {
		this.creditLimitAmt = creditLimitAmt;
	}

	public String getCsAddrSendInd() {
		return this.csAddrSendInd;
	}

	public void setCsAddrSendInd(String csAddrSendInd) {
		this.csAddrSendInd = csAddrSendInd;
	}

	public String getCsBanTrxOffInd() {
		return this.csBanTrxOffInd;
	}

	public void setCsBanTrxOffInd(String csBanTrxOffInd) {
		this.csBanTrxOffInd = csBanTrxOffInd;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getCsComEndDate() {
		return this.csComEndDate;
	}

	public void setCsComEndDate(Date csComEndDate) {
		this.csComEndDate = csComEndDate;
	}

	public BigDecimal getCsComOrigNoMonth() {
		return this.csComOrigNoMonth;
	}

	public void setCsComOrigNoMonth(BigDecimal csComOrigNoMonth) {
		this.csComOrigNoMonth = csComOrigNoMonth;
	}

	public String getCsComReasonCode() {
		return this.csComReasonCode;
	}

	public void setCsComReasonCode(String csComReasonCode) {
		this.csComReasonCode = csComReasonCode;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getCsComStartDate() {
		return this.csComStartDate;
	}

	public void setCsComStartDate(Date csComStartDate) {
		this.csComStartDate = csComStartDate;
	}

	public BigDecimal getCsDiscountCnt() {
		return this.csDiscountCnt;
	}

	public void setCsDiscountCnt(BigDecimal csDiscountCnt) {
		this.csDiscountCnt = csDiscountCnt;
	}

	public String getCsFollowUpsState() {
		return this.csFollowUpsState;
	}

	public void setCsFollowUpsState(String csFollowUpsState) {
		this.csFollowUpsState = csFollowUpsState;
	}

	public String getCsHandleByCtnInd() {
		return this.csHandleByCtnInd;
	}

	public void setCsHandleByCtnInd(String csHandleByCtnInd) {
		this.csHandleByCtnInd = csHandleByCtnInd;
	}

	public String getCsInitiationReason() {
		return this.csInitiationReason;
	}

	public void setCsInitiationReason(String csInitiationReason) {
		this.csInitiationReason = csInitiationReason;
	}

	public String getCsLockMechanism() {
		return this.csLockMechanism;
	}

	public void setCsLockMechanism(String csLockMechanism) {
		this.csLockMechanism = csLockMechanism;
	}

	public BigDecimal getCsMinReqCtns() {
		return this.csMinReqCtns;
	}

	public void setCsMinReqCtns(BigDecimal csMinReqCtns) {
		this.csMinReqCtns = csMinReqCtns;
	}

	public String getCsOpenCtnExist() {
		return this.csOpenCtnExist;
	}

	public void setCsOpenCtnExist(String csOpenCtnExist) {
		this.csOpenCtnExist = csOpenCtnExist;
	}

	public BigDecimal getCsPenPerMissCtn() {
		return this.csPenPerMissCtn;
	}

	public void setCsPenPerMissCtn(BigDecimal csPenPerMissCtn) {
		this.csPenPerMissCtn = csPenPerMissCtn;
	}

	public BigDecimal getCsRelatedAccount() {
		return this.csRelatedAccount;
	}

	public void setCsRelatedAccount(BigDecimal csRelatedAccount) {
		this.csRelatedAccount = csRelatedAccount;
	}

	public String getCsSpecMemoInd() {
		return this.csSpecMemoInd;
	}

	public void setCsSpecMemoInd(String csSpecMemoInd) {
		this.csSpecMemoInd = csSpecMemoInd;
	}

	public BigDecimal getCurrRootBan() {
		return this.currRootBan;
	}

	public void setCurrRootBan(BigDecimal currRootBan) {
		this.currRootBan = currRootBan;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getCurrencyEffDate() {
		return this.currencyEffDate;
	}

	public void setCurrencyEffDate(Date currencyEffDate) {
		this.currencyEffDate = currencyEffDate;
	}

	public String getCustSegment() {
		return this.custSegment;
	}

	public void setCustSegment(String custSegment) {
		this.custSegment = custSegment;
	}

	public String getDealerCode() {
		return this.dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public BigDecimal getDefaultBen() {
		return this.defaultBen;
	}

	public void setDefaultBen(BigDecimal defaultBen) {
		this.defaultBen = defaultBen;
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

	public BigDecimal getDsptCounter() {
		return this.dsptCounter;
	}

	public void setDsptCounter(BigDecimal dsptCounter) {
		this.dsptCounter = dsptCounter;
	}

	public BigDecimal getDsptWaiverCounter() {
		return this.dsptWaiverCounter;
	}

	public void setDsptWaiverCounter(BigDecimal dsptWaiverCounter) {
		this.dsptWaiverCounter = dsptWaiverCounter;
	}

	public BigDecimal getEuArBalance() {
		return this.euArBalance;
	}

	public void setEuArBalance(BigDecimal euArBalance) {
		this.euArBalance = euArBalance;
	}

	public BigDecimal getEuColAgnAsdAmt() {
		return this.euColAgnAsdAmt;
	}

	public void setEuColAgnAsdAmt(BigDecimal euColAgnAsdAmt) {
		this.euColAgnAsdAmt = euColAgnAsdAmt;
	}

	public BigDecimal getEuCompCrdLmt() {
		return this.euCompCrdLmt;
	}

	public void setEuCompCrdLmt(BigDecimal euCompCrdLmt) {
		this.euCompCrdLmt = euCompCrdLmt;
	}

	public BigDecimal getEuCreditLimitAmt() {
		return this.euCreditLimitAmt;
	}

	public void setEuCreditLimitAmt(BigDecimal euCreditLimitAmt) {
		this.euCreditLimitAmt = euCreditLimitAmt;
	}

	public BigDecimal getEuCsPenMissCtn() {
		return this.euCsPenMissCtn;
	}

	public void setEuCsPenMissCtn(BigDecimal euCsPenMissCtn) {
		this.euCsPenMissCtn = euCsPenMissCtn;
	}

	public BigDecimal getEuUnallocatedAmt() {
		return this.euUnallocatedAmt;
	}

	public void setEuUnallocatedAmt(BigDecimal euUnallocatedAmt) {
		this.euUnallocatedAmt = euUnallocatedAmt;
	}

	public String getForceFreqInd() {
		return this.forceFreqInd;
	}

	public void setForceFreqInd(String forceFreqInd) {
		this.forceFreqInd = forceFreqInd;
	}

	public BigDecimal getFppId() {
		return this.fppId;
	}

	public void setFppId(BigDecimal fppId) {
		this.fppId = fppId;
	}

	public String getFppInd() {
		return this.fppInd;
	}

	public void setFppInd(String fppInd) {
		this.fppInd = fppInd;
	}

	public BigDecimal getFrameContractId() {
		return this.frameContractId;
	}

	public void setFrameContractId(BigDecimal frameContractId) {
		this.frameContractId = frameContractId;
	}

	public String getHideLastDigitInd() {
		return this.hideLastDigitInd;
	}

	public void setHideLastDigitInd(String hideLastDigitInd) {
		this.hideLastDigitInd = hideLastDigitInd;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getHistLastDate() {
		return this.histLastDate;
	}

	public void setHistLastDate(Date histLastDate) {
		this.histLastDate = histLastDate;
	}

	public String getLastBckCode() {
		return this.lastBckCode;
	}

	public void setLastBckCode(String lastBckCode) {
		this.lastBckCode = lastBckCode;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigDecimal getNextRootBan() {
		return this.nextRootBan;
	}

	public void setNextRootBan(BigDecimal nextRootBan) {
		this.nextRootBan = nextRootBan;
	}

	public String getNextRootBanEffDt() {
		return this.nextRootBanEffDt;
	}

	public void setNextRootBanEffDt(String nextRootBanEffDt) {
		this.nextRootBanEffDt = nextRootBanEffDt;
	}

	public BigDecimal getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(BigDecimal operatorId) {
		this.operatorId = operatorId;
	}

	public BigDecimal getPartRootBan() {
		return this.partRootBan;
	}

	public void setPartRootBan(BigDecimal partRootBan) {
		this.partRootBan = partRootBan;
	}

	public String getPayValidInd() {
		return this.payValidInd;
	}

	public void setPayValidInd(String payValidInd) {
		this.payValidInd = payValidInd;
	}

	public BigDecimal getRandomGroup() {
		return this.randomGroup;
	}

	public void setRandomGroup(BigDecimal randomGroup) {
		this.randomGroup = randomGroup;
	}

	public String getRevenueSegment() {
		return this.revenueSegment;
	}

	public void setRevenueSegment(String revenueSegment) {
		this.revenueSegment = revenueSegment;
	}

	public String getServiceLevel() {
		return this.serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public String getSignOffAgreement() {
		return this.signOffAgreement;
	}

	public void setSignOffAgreement(String signOffAgreement) {
		this.signOffAgreement = signOffAgreement;
	}

	public BigDecimal getSpMemoId() {
		return this.spMemoId;
	}

	public void setSpMemoId(BigDecimal spMemoId) {
		this.spMemoId = spMemoId;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getStartServiceDate() {
		return this.startServiceDate;
	}

	public void setStartServiceDate(Date startServiceDate) {
		this.startServiceDate = startServiceDate;
	}

	public String getStatusActvCode() {
		return this.statusActvCode;
	}

	public void setStatusActvCode(String statusActvCode) {
		this.statusActvCode = statusActvCode;
	}

	public String getStatusActvRsnCode() {
		return this.statusActvRsnCode;
	}

	public void setStatusActvRsnCode(String statusActvRsnCode) {
		this.statusActvRsnCode = statusActvRsnCode;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getStatusIssueDate() {
		return this.statusIssueDate;
	}

	public void setStatusIssueDate(Date statusIssueDate) {
		this.statusIssueDate = statusIssueDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getStatusLastDate() {
		return this.statusLastDate;
	}

	public void setStatusLastDate(Date statusLastDate) {
		this.statusLastDate = statusLastDate;
	}

	public String getStmtInvInd() {
		return this.stmtInvInd;
	}

	public void setStmtInvInd(String stmtInvInd) {
		this.stmtInvInd = stmtInvInd;
	}

	public String getStmtReqInd() {
		return this.stmtReqInd;
	}

	public void setStmtReqInd(String stmtReqInd) {
		this.stmtReqInd = stmtReqInd;
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

	public String getTimeInBusiness() {
		return this.timeInBusiness;
	}

	public void setTimeInBusiness(String timeInBusiness) {
		this.timeInBusiness = timeInBusiness;
	}

	public String getUidNumber() {
		return this.uidNumber;
	}

	public void setUidNumber(String uidNumber) {
		this.uidNumber = uidNumber;
	}

	public BigDecimal getUnallocatedAmt() {
		return this.unallocatedAmt;
	}

	public void setUnallocatedAmt(BigDecimal unallocatedAmt) {
		this.unallocatedAmt = unallocatedAmt;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public List<AddressNameLinkDto> getAddressNameLink() {
		return addressNameLink;
	}

	public void setAddressNameLink(List<AddressNameLinkDto> addressNameLink) {
		this.addressNameLink = addressNameLink;
	}

}
