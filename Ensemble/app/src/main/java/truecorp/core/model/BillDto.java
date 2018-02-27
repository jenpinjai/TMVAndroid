package truecorp.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private BillPKDto id;

	@JsonProperty("accountCategory")
	private String accountCategory;

	@JsonProperty("accountType")
	private String accountType;

	@JsonProperty("actualBalanceAmt")
	private BigDecimal actualBalanceAmt;

	@JsonProperty("applyMktMsgInd")
	private String applyMktMsgInd;

	@JsonProperty("banStatus")
	private String banStatus;

	@JsonProperty("banStatusDate")
	private Date banStatusDate;

	@JsonProperty("bankAccountNo")
	private String bankAccountNo;

	@JsonProperty("bankCode")
	private String bankCode;

	@JsonProperty("benStatus")
	private String benStatus;

	@JsonProperty("benStatusDate")
	private Date benStatusDate;

	@JsonProperty("bfSpecialFormat")
	private String bfSpecialFormat;

	@JsonProperty("billCalcRunDate")
	private Date billCalcRunDate;

	@JsonProperty("billConfStatus")
	private String billConfStatus;

	@JsonProperty("billDate")
	private Date billDate;

	@JsonProperty("billDueAmt")
	private BigDecimal billDueAmt;

	@JsonProperty("billDueDate")
	private Date billDueDate;

	@JsonProperty("billFormat")
	private String billFormat;

	@JsonProperty("billFrequency")
	private BigDecimal billFrequency;

	@JsonProperty("billProdRunDate")
	private Date billProdRunDate;

	@JsonProperty("billStatusDate")
	private Date billStatusDate;

	@JsonProperty("billingStatus")
	private String billingStatus;

	@JsonProperty("blDocumentType")
	private String blDocumentType;

	@JsonProperty("blLocalMailingInd")
	private String blLocalMailingInd;

	@JsonProperty("blprepOcRcAmt")
	private BigDecimal blprepOcRcAmt;

	@JsonProperty("blprepUcCrdtAmt")
	private BigDecimal blprepUcCrdtAmt;

	@JsonProperty("brandCode")
	private String brandCode;

	@JsonProperty("callMngrRepId")
	private BigDecimal callMngrRepId;

	@JsonProperty("carryOverInd")
	private String carryOverInd;

	@JsonProperty("changeCycleInd")
	private String changeCycleInd;

	@JsonProperty("convRunNo")
	private BigDecimal convRunNo;

	@JsonProperty("creditCardNo")
	private String creditCardNo;

	@JsonProperty("creditCardType")
	private String creditCardType;

	@JsonProperty("currAirUcChrgAmt")
	private BigDecimal currAirUcChrgAmt;

	@JsonProperty("currDiscountAmt")
	private BigDecimal currDiscountAmt;

	@JsonProperty("currOcChrgAmt")
	private BigDecimal currOcChrgAmt;

	@JsonProperty("currOcCrdtAmt")
	private BigDecimal currOcCrdtAmt;

	@JsonProperty("currRcChrgAmt")
	private BigDecimal currRcChrgAmt;

	@JsonProperty("currRcCrdtAmt")
	private BigDecimal currRcCrdtAmt;

	@JsonProperty("currUcCrdtAmt")
	private BigDecimal currUcCrdtAmt;

	@JsonProperty("currencyCode")
	private String currencyCode;

	@JsonProperty("cycleCloseDate")
	private Date cycleCloseDate;

	@JsonProperty("cycleCode")
	private BigDecimal cycleCode;

	@JsonProperty("cycleRunMonth")
	private BigDecimal cycleRunMonth;

	@JsonProperty("cycleRunYear")
	private BigDecimal cycleRunYear;

	@JsonProperty("diskBillRepId")
	private BigDecimal diskBillRepId;

	@JsonProperty("dunningLetterInd")
	private String dunningLetterInd;

	@JsonProperty("euActualBalance")
	private BigDecimal euActualBalance;

	@JsonProperty("euCurrDiscount")
	private BigDecimal euCurrDiscount;

	@JsonProperty("euCurrOcChrg")
	private BigDecimal euCurrOcChrg;

	@JsonProperty("euCurrOcCrdt")
	private BigDecimal euCurrOcCrdt;

	@JsonProperty("euCurrRcChrg")
	private BigDecimal euCurrRcChrg;

	@JsonProperty("euCurrRcCrdt")
	private BigDecimal euCurrRcCrdt;

	@JsonProperty("euCurrUcChrg")
	private BigDecimal euCurrUcChrg;

	@JsonProperty("euCurrUcCrdt")
	private BigDecimal euCurrUcCrdt;

	@JsonProperty("euOverdueAmt")
	private BigDecimal euOverdueAmt;

	@JsonProperty("euOverpymAmt")
	private BigDecimal euOverpymAmt;

	@JsonProperty("euPastDueAmt")
	private BigDecimal euPastDueAmt;

	@JsonProperty("euPrevBalance")
	private BigDecimal euPrevBalance;

	@JsonProperty("euPymReceiveAmt")
	private BigDecimal euPymReceiveAmt;

	@JsonProperty("euTaxTotInvAmt")
	private BigDecimal euTaxTotInvAmt;

	@JsonProperty("euTotBanLvlDiscount")
	private BigDecimal euTotBanLvlDiscount;

	@JsonProperty("euTotBanOcUtcAmt")
	private BigDecimal euTotBanOcUtcAmt;

	@JsonProperty("euTotBanRcUtcAmt")
	private BigDecimal euTotBanRcUtcAmt;

	@JsonProperty("euTotBanRcvOcUtc")
	private BigDecimal euTotBanRcvOcUtc;

	@JsonProperty("euTotBanRcvRcUtc")
	private BigDecimal euTotBanRcvRcUtc;

	@JsonProperty("euTotBanRcvUcUtc")
	private BigDecimal euTotBanRcvUcUtc;

	@JsonProperty("euTotBanUcUtcAmt")
	private BigDecimal euTotBanUcUtcAmt;

	@JsonProperty("euTotBilledAdj")
	private BigDecimal euTotBilledAdj;

	@JsonProperty("euTotBilledChrg")
	private BigDecimal euTotBilledChrg;

	@JsonProperty("euTotHierDiscountAmt")
	private BigDecimal euTotHierDiscountAmt;

	@JsonProperty("euTotSubsDiscount")
	private BigDecimal euTotSubsDiscount;

	@JsonProperty("euTotTreeDiscount")
	private BigDecimal euTotTreeDiscount;

	@JsonProperty("euTotalDueAmt")
	private BigDecimal euTotalDueAmt;

	@JsonProperty("invSeqNo")
	private BigDecimal invSeqNo;

	@JsonProperty("invoiceNumber")
	private String invoiceNumber;

	@JsonProperty("languageInd")
	private String languageInd;

	@JsonProperty("latePymBaseAmt")
	private BigDecimal latePymBaseAmt;

	@JsonProperty("latePymChrgAmt")
	private BigDecimal latePymChrgAmt;

	@JsonProperty("manualHndlByOpid")
	private BigDecimal manualHndlByOpid;

	@JsonProperty("manualHndlReqOpid")
	private BigDecimal manualHndlReqOpid;

	@JsonProperty("nmAdrLinkSeqNo")
	private BigDecimal nmAdrLinkSeqNo;

	@JsonProperty("numOfCtns")
	private BigDecimal numOfCtns;

	@JsonProperty("overdueAmt")
	private BigDecimal overdueAmt;

	@JsonProperty("overpymAmt")
	private BigDecimal overpymAmt;

	@JsonProperty("paperBillInd")
	private String paperBillInd;

	@JsonProperty("pastDueAmt")
	private BigDecimal pastDueAmt;

	@JsonProperty("paymentMethod")
	private String paymentMethod;

	@JsonProperty("personalDetailsInd")
	private String personalDetailsInd;

	@JsonProperty("ppChangeDate")
	private Date ppChangeDate;

	@JsonProperty("prdCvrgEndDate")
	private Date prdCvrgEndDate;

	@JsonProperty("prdCvrgStrtDate")
	private Date prdCvrgStrtDate;

	@JsonProperty("prevBalanceAmt")
	private BigDecimal prevBalanceAmt;

	@JsonProperty("prevDueDate")
	private Date prevDueDate;

	@JsonProperty("processCycleCode")
	private BigDecimal processCycleCode;

	private BigDecimal processCycleMonth;

	@JsonProperty("processCycleYear")
	private BigDecimal processCycleYear;

	@JsonProperty("productionRequest")
	private String productionRequest;

	@JsonProperty("productionType")
	private String productionType;

	@JsonProperty("prtCategory")
	private String prtCategory;

	@JsonProperty("pymReceivedAmt")
	private BigDecimal pymReceivedAmt;

	@JsonProperty("rootBan")
	private BigDecimal rootBan;

	private Date startServiceDate;

	@JsonProperty("summaryPageInd")
	private String summaryPageInd;

	@JsonProperty("taxSeqNo")
	private BigDecimal taxSeqNo;

	@JsonProperty("taxTotalInvAmount")
	private BigDecimal taxTotalInvAmount;

	@JsonProperty("taxableAmt")
	private BigDecimal taxableAmt;

	@JsonProperty("totBanLvlDiscount")
	private BigDecimal totBanLvlDiscount;

	@JsonProperty("totBanOcUtcAmt")
	private BigDecimal totBanOcUtcAmt;

	@JsonProperty("totBanRcUtcAmt")
	private BigDecimal totBanRcUtcAmt;

	@JsonProperty("totBanRcvOcUtc")
	private BigDecimal totBanRcvOcUtc;

	@JsonProperty("totBanRcvRcUtc")
	private BigDecimal totBanRcvRcUtc;

	@JsonProperty("totBanRcvUcUtc")
	private BigDecimal totBanRcvUcUtc;

	@JsonProperty("totBanUcUtcAmt")
	private BigDecimal totBanUcUtcAmt;

	@JsonProperty("totCallDurSec")
	private BigDecimal totCallDurSec;

	@JsonProperty("totHierDiscountAmt")
	private BigDecimal totHierDiscountAmt;

	@JsonProperty("totSubsDiscount")
	private BigDecimal totSubsDiscount;

	@JsonProperty("totTreeDiscount")
	private BigDecimal totTreeDiscount;

	@JsonProperty("totalBilledAdjust")
	private BigDecimal totalBilledAdjust;

	@JsonProperty("totalBilledCharge")
	private BigDecimal totalBilledCharge;

	@JsonProperty("totalDueAmt")
	private BigDecimal totalDueAmt;

	@JsonProperty("treeLevel")
	private BigDecimal treeLevel;
	
	@JsonProperty("sysUpdateDate")
	private Date sysUpdateDate;
	
	@JsonProperty("sysCreationDate")
	private Date sysCreationDate;

	public BillPKDto getId() {
		return this.id;
	}

	public void setId(BillPKDto id) {
		this.id = id;
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

	public BigDecimal getActualBalanceAmt() {
		return this.actualBalanceAmt;
	}

	public void setActualBalanceAmt(BigDecimal actualBalanceAmt) {
		this.actualBalanceAmt = actualBalanceAmt;
	}

	public String getApplyMktMsgInd() {
		return this.applyMktMsgInd;
	}

	public void setApplyMktMsgInd(String applyMktMsgInd) {
		this.applyMktMsgInd = applyMktMsgInd;
	}

	public String getBanStatus() {
		return this.banStatus;
	}

	public void setBanStatus(String banStatus) {
		this.banStatus = banStatus;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getBanStatusDate() {
		return this.banStatusDate;
	}

	public void setBanStatusDate(Date banStatusDate) {
		this.banStatusDate = banStatusDate;
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

	public String getBenStatus() {
		return this.benStatus;
	}

	public void setBenStatus(String benStatus) {
		this.benStatus = benStatus;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getBenStatusDate() {
		return this.benStatusDate;
	}

	public void setBenStatusDate(Date benStatusDate) {
		this.benStatusDate = benStatusDate;
	}

	public String getBfSpecialFormat() {
		return this.bfSpecialFormat;
	}

	public void setBfSpecialFormat(String bfSpecialFormat) {
		this.bfSpecialFormat = bfSpecialFormat;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getBillCalcRunDate() {
		return this.billCalcRunDate;
	}

	public void setBillCalcRunDate(Date billCalcRunDate) {
		this.billCalcRunDate = billCalcRunDate;
	}

	public String getBillConfStatus() {
		return this.billConfStatus;
	}

	public void setBillConfStatus(String billConfStatus) {
		this.billConfStatus = billConfStatus;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getBillDate() {
		return this.billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public BigDecimal getBillDueAmt() {
		return this.billDueAmt;
	}

	public void setBillDueAmt(BigDecimal billDueAmt) {
		this.billDueAmt = billDueAmt;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getBillDueDate() {
		return this.billDueDate;
	}

	public void setBillDueDate(Date billDueDate) {
		this.billDueDate = billDueDate;
	}

	public String getBillFormat() {
		return this.billFormat;
	}

	public void setBillFormat(String billFormat) {
		this.billFormat = billFormat;
	}

	public BigDecimal getBillFrequency() {
		return this.billFrequency;
	}

	public void setBillFrequency(BigDecimal billFrequency) {
		this.billFrequency = billFrequency;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getBillProdRunDate() {
		return this.billProdRunDate;
	}

	public void setBillProdRunDate(Date billProdRunDate) {
		this.billProdRunDate = billProdRunDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getBillStatusDate() {
		return this.billStatusDate;
	}

	public void setBillStatusDate(Date billStatusDate) {
		this.billStatusDate = billStatusDate;
	}

	public String getBillingStatus() {
		return this.billingStatus;
	}

	public void setBillingStatus(String billingStatus) {
		this.billingStatus = billingStatus;
	}

	public String getBlDocumentType() {
		return this.blDocumentType;
	}

	public void setBlDocumentType(String blDocumentType) {
		this.blDocumentType = blDocumentType;
	}

	public String getBlLocalMailingInd() {
		return this.blLocalMailingInd;
	}

	public void setBlLocalMailingInd(String blLocalMailingInd) {
		this.blLocalMailingInd = blLocalMailingInd;
	}

	public BigDecimal getBlprepOcRcAmt() {
		return this.blprepOcRcAmt;
	}

	public void setBlprepOcRcAmt(BigDecimal blprepOcRcAmt) {
		this.blprepOcRcAmt = blprepOcRcAmt;
	}

	public BigDecimal getBlprepUcCrdtAmt() {
		return this.blprepUcCrdtAmt;
	}

	public void setBlprepUcCrdtAmt(BigDecimal blprepUcCrdtAmt) {
		this.blprepUcCrdtAmt = blprepUcCrdtAmt;
	}

	public String getBrandCode() {
		return this.brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public BigDecimal getCallMngrRepId() {
		return this.callMngrRepId;
	}

	public void setCallMngrRepId(BigDecimal callMngrRepId) {
		this.callMngrRepId = callMngrRepId;
	}

	public String getCarryOverInd() {
		return this.carryOverInd;
	}

	public void setCarryOverInd(String carryOverInd) {
		this.carryOverInd = carryOverInd;
	}

	public String getChangeCycleInd() {
		return this.changeCycleInd;
	}

	public void setChangeCycleInd(String changeCycleInd) {
		this.changeCycleInd = changeCycleInd;
	}

	public BigDecimal getConvRunNo() {
		return this.convRunNo;
	}

	public void setConvRunNo(BigDecimal convRunNo) {
		this.convRunNo = convRunNo;
	}

	public String getCreditCardNo() {
		return this.creditCardNo;
	}

	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public String getCreditCardType() {
		return this.creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public BigDecimal getCurrAirUcChrgAmt() {
		return this.currAirUcChrgAmt;
	}

	public void setCurrAirUcChrgAmt(BigDecimal currAirUcChrgAmt) {
		this.currAirUcChrgAmt = currAirUcChrgAmt;
	}

	public BigDecimal getCurrDiscountAmt() {
		return this.currDiscountAmt;
	}

	public void setCurrDiscountAmt(BigDecimal currDiscountAmt) {
		this.currDiscountAmt = currDiscountAmt;
	}

	public BigDecimal getCurrOcChrgAmt() {
		return this.currOcChrgAmt;
	}

	public void setCurrOcChrgAmt(BigDecimal currOcChrgAmt) {
		this.currOcChrgAmt = currOcChrgAmt;
	}

	public BigDecimal getCurrOcCrdtAmt() {
		return this.currOcCrdtAmt;
	}

	public void setCurrOcCrdtAmt(BigDecimal currOcCrdtAmt) {
		this.currOcCrdtAmt = currOcCrdtAmt;
	}

	public BigDecimal getCurrRcChrgAmt() {
		return this.currRcChrgAmt;
	}

	public void setCurrRcChrgAmt(BigDecimal currRcChrgAmt) {
		this.currRcChrgAmt = currRcChrgAmt;
	}

	public BigDecimal getCurrRcCrdtAmt() {
		return this.currRcCrdtAmt;
	}

	public void setCurrRcCrdtAmt(BigDecimal currRcCrdtAmt) {
		this.currRcCrdtAmt = currRcCrdtAmt;
	}

	public BigDecimal getCurrUcCrdtAmt() {
		return this.currUcCrdtAmt;
	}

	public void setCurrUcCrdtAmt(BigDecimal currUcCrdtAmt) {
		this.currUcCrdtAmt = currUcCrdtAmt;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getCycleCloseDate() {
		return this.cycleCloseDate;
	}

	public void setCycleCloseDate(Date cycleCloseDate) {
		this.cycleCloseDate = cycleCloseDate;
	}

	public BigDecimal getCycleCode() {
		return this.cycleCode;
	}

	public void setCycleCode(BigDecimal cycleCode) {
		this.cycleCode = cycleCode;
	}

	public BigDecimal getCycleRunMonth() {
		return this.cycleRunMonth;
	}

	public void setCycleRunMonth(BigDecimal cycleRunMonth) {
		this.cycleRunMonth = cycleRunMonth;
	}

	public BigDecimal getCycleRunYear() {
		return this.cycleRunYear;
	}

	public void setCycleRunYear(BigDecimal cycleRunYear) {
		this.cycleRunYear = cycleRunYear;
	}

	public BigDecimal getDiskBillRepId() {
		return this.diskBillRepId;
	}

	public void setDiskBillRepId(BigDecimal diskBillRepId) {
		this.diskBillRepId = diskBillRepId;
	}

	public String getDunningLetterInd() {
		return this.dunningLetterInd;
	}

	public void setDunningLetterInd(String dunningLetterInd) {
		this.dunningLetterInd = dunningLetterInd;
	}

	public BigDecimal getEuActualBalance() {
		return this.euActualBalance;
	}

	public void setEuActualBalance(BigDecimal euActualBalance) {
		this.euActualBalance = euActualBalance;
	}

	public BigDecimal getEuCurrDiscount() {
		return this.euCurrDiscount;
	}

	public void setEuCurrDiscount(BigDecimal euCurrDiscount) {
		this.euCurrDiscount = euCurrDiscount;
	}

	public BigDecimal getEuCurrOcChrg() {
		return this.euCurrOcChrg;
	}

	public void setEuCurrOcChrg(BigDecimal euCurrOcChrg) {
		this.euCurrOcChrg = euCurrOcChrg;
	}

	public BigDecimal getEuCurrOcCrdt() {
		return this.euCurrOcCrdt;
	}

	public void setEuCurrOcCrdt(BigDecimal euCurrOcCrdt) {
		this.euCurrOcCrdt = euCurrOcCrdt;
	}

	public BigDecimal getEuCurrRcChrg() {
		return this.euCurrRcChrg;
	}

	public void setEuCurrRcChrg(BigDecimal euCurrRcChrg) {
		this.euCurrRcChrg = euCurrRcChrg;
	}

	public BigDecimal getEuCurrRcCrdt() {
		return this.euCurrRcCrdt;
	}

	public void setEuCurrRcCrdt(BigDecimal euCurrRcCrdt) {
		this.euCurrRcCrdt = euCurrRcCrdt;
	}

	public BigDecimal getEuCurrUcChrg() {
		return this.euCurrUcChrg;
	}

	public void setEuCurrUcChrg(BigDecimal euCurrUcChrg) {
		this.euCurrUcChrg = euCurrUcChrg;
	}

	public BigDecimal getEuCurrUcCrdt() {
		return this.euCurrUcCrdt;
	}

	public void setEuCurrUcCrdt(BigDecimal euCurrUcCrdt) {
		this.euCurrUcCrdt = euCurrUcCrdt;
	}

	public BigDecimal getEuOverdueAmt() {
		return this.euOverdueAmt;
	}

	public void setEuOverdueAmt(BigDecimal euOverdueAmt) {
		this.euOverdueAmt = euOverdueAmt;
	}

	public BigDecimal getEuOverpymAmt() {
		return this.euOverpymAmt;
	}

	public void setEuOverpymAmt(BigDecimal euOverpymAmt) {
		this.euOverpymAmt = euOverpymAmt;
	}

	public BigDecimal getEuPastDueAmt() {
		return this.euPastDueAmt;
	}

	public void setEuPastDueAmt(BigDecimal euPastDueAmt) {
		this.euPastDueAmt = euPastDueAmt;
	}

	public BigDecimal getEuPrevBalance() {
		return this.euPrevBalance;
	}

	public void setEuPrevBalance(BigDecimal euPrevBalance) {
		this.euPrevBalance = euPrevBalance;
	}

	public BigDecimal getEuPymReceiveAmt() {
		return this.euPymReceiveAmt;
	}

	public void setEuPymReceiveAmt(BigDecimal euPymReceiveAmt) {
		this.euPymReceiveAmt = euPymReceiveAmt;
	}

	public BigDecimal getEuTaxTotInvAmt() {
		return this.euTaxTotInvAmt;
	}

	public void setEuTaxTotInvAmt(BigDecimal euTaxTotInvAmt) {
		this.euTaxTotInvAmt = euTaxTotInvAmt;
	}

	public BigDecimal getEuTotBanLvlDiscount() {
		return this.euTotBanLvlDiscount;
	}

	public void setEuTotBanLvlDiscount(BigDecimal euTotBanLvlDiscount) {
		this.euTotBanLvlDiscount = euTotBanLvlDiscount;
	}

	public BigDecimal getEuTotBanOcUtcAmt() {
		return this.euTotBanOcUtcAmt;
	}

	public void setEuTotBanOcUtcAmt(BigDecimal euTotBanOcUtcAmt) {
		this.euTotBanOcUtcAmt = euTotBanOcUtcAmt;
	}

	public BigDecimal getEuTotBanRcUtcAmt() {
		return this.euTotBanRcUtcAmt;
	}

	public void setEuTotBanRcUtcAmt(BigDecimal euTotBanRcUtcAmt) {
		this.euTotBanRcUtcAmt = euTotBanRcUtcAmt;
	}

	public BigDecimal getEuTotBanRcvOcUtc() {
		return this.euTotBanRcvOcUtc;
	}

	public void setEuTotBanRcvOcUtc(BigDecimal euTotBanRcvOcUtc) {
		this.euTotBanRcvOcUtc = euTotBanRcvOcUtc;
	}

	public BigDecimal getEuTotBanRcvRcUtc() {
		return this.euTotBanRcvRcUtc;
	}

	public void setEuTotBanRcvRcUtc(BigDecimal euTotBanRcvRcUtc) {
		this.euTotBanRcvRcUtc = euTotBanRcvRcUtc;
	}

	public BigDecimal getEuTotBanRcvUcUtc() {
		return this.euTotBanRcvUcUtc;
	}

	public void setEuTotBanRcvUcUtc(BigDecimal euTotBanRcvUcUtc) {
		this.euTotBanRcvUcUtc = euTotBanRcvUcUtc;
	}

	public BigDecimal getEuTotBanUcUtcAmt() {
		return this.euTotBanUcUtcAmt;
	}

	public void setEuTotBanUcUtcAmt(BigDecimal euTotBanUcUtcAmt) {
		this.euTotBanUcUtcAmt = euTotBanUcUtcAmt;
	}

	public BigDecimal getEuTotBilledAdj() {
		return this.euTotBilledAdj;
	}

	public void setEuTotBilledAdj(BigDecimal euTotBilledAdj) {
		this.euTotBilledAdj = euTotBilledAdj;
	}

	public BigDecimal getEuTotBilledChrg() {
		return this.euTotBilledChrg;
	}

	public void setEuTotBilledChrg(BigDecimal euTotBilledChrg) {
		this.euTotBilledChrg = euTotBilledChrg;
	}

	public BigDecimal getEuTotHierDiscountAmt() {
		return this.euTotHierDiscountAmt;
	}

	public void setEuTotHierDiscountAmt(BigDecimal euTotHierDiscountAmt) {
		this.euTotHierDiscountAmt = euTotHierDiscountAmt;
	}

	public BigDecimal getEuTotSubsDiscount() {
		return this.euTotSubsDiscount;
	}

	public void setEuTotSubsDiscount(BigDecimal euTotSubsDiscount) {
		this.euTotSubsDiscount = euTotSubsDiscount;
	}

	public BigDecimal getEuTotTreeDiscount() {
		return this.euTotTreeDiscount;
	}

	public void setEuTotTreeDiscount(BigDecimal euTotTreeDiscount) {
		this.euTotTreeDiscount = euTotTreeDiscount;
	}

	public BigDecimal getEuTotalDueAmt() {
		return this.euTotalDueAmt;
	}

	public void setEuTotalDueAmt(BigDecimal euTotalDueAmt) {
		this.euTotalDueAmt = euTotalDueAmt;
	}

	public BigDecimal getInvSeqNo() {
		return this.invSeqNo;
	}

	public void setInvSeqNo(BigDecimal invSeqNo) {
		this.invSeqNo = invSeqNo;
	}

	public String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getLanguageInd() {
		return this.languageInd;
	}

	public void setLanguageInd(String languageInd) {
		this.languageInd = languageInd;
	}

	public BigDecimal getLatePymBaseAmt() {
		return this.latePymBaseAmt;
	}

	public void setLatePymBaseAmt(BigDecimal latePymBaseAmt) {
		this.latePymBaseAmt = latePymBaseAmt;
	}

	public BigDecimal getLatePymChrgAmt() {
		return this.latePymChrgAmt;
	}

	public void setLatePymChrgAmt(BigDecimal latePymChrgAmt) {
		this.latePymChrgAmt = latePymChrgAmt;
	}

	public BigDecimal getManualHndlByOpid() {
		return this.manualHndlByOpid;
	}

	public void setManualHndlByOpid(BigDecimal manualHndlByOpid) {
		this.manualHndlByOpid = manualHndlByOpid;
	}

	public BigDecimal getManualHndlReqOpid() {
		return this.manualHndlReqOpid;
	}

	public void setManualHndlReqOpid(BigDecimal manualHndlReqOpid) {
		this.manualHndlReqOpid = manualHndlReqOpid;
	}

	public BigDecimal getNmAdrLinkSeqNo() {
		return this.nmAdrLinkSeqNo;
	}

	public void setNmAdrLinkSeqNo(BigDecimal nmAdrLinkSeqNo) {
		this.nmAdrLinkSeqNo = nmAdrLinkSeqNo;
	}

	public BigDecimal getNumOfCtns() {
		return this.numOfCtns;
	}

	public void setNumOfCtns(BigDecimal numOfCtns) {
		this.numOfCtns = numOfCtns;
	}

	public BigDecimal getOverdueAmt() {
		return this.overdueAmt;
	}

	public void setOverdueAmt(BigDecimal overdueAmt) {
		this.overdueAmt = overdueAmt;
	}

	public BigDecimal getOverpymAmt() {
		return this.overpymAmt;
	}

	public void setOverpymAmt(BigDecimal overpymAmt) {
		this.overpymAmt = overpymAmt;
	}

	public String getPaperBillInd() {
		return this.paperBillInd;
	}

	public void setPaperBillInd(String paperBillInd) {
		this.paperBillInd = paperBillInd;
	}

	public BigDecimal getPastDueAmt() {
		return this.pastDueAmt;
	}

	public void setPastDueAmt(BigDecimal pastDueAmt) {
		this.pastDueAmt = pastDueAmt;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPersonalDetailsInd() {
		return this.personalDetailsInd;
	}

	public void setPersonalDetailsInd(String personalDetailsInd) {
		this.personalDetailsInd = personalDetailsInd;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getPpChangeDate() {
		return this.ppChangeDate;
	}

	public void setPpChangeDate(Date ppChangeDate) {
		this.ppChangeDate = ppChangeDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getPrdCvrgEndDate() {
		return this.prdCvrgEndDate;
	}

	public void setPrdCvrgEndDate(Date prdCvrgEndDate) {
		this.prdCvrgEndDate = prdCvrgEndDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getPrdCvrgStrtDate() {
		return this.prdCvrgStrtDate;
	}

	public void setPrdCvrgStrtDate(Date prdCvrgStrtDate) {
		this.prdCvrgStrtDate = prdCvrgStrtDate;
	}

	public BigDecimal getPrevBalanceAmt() {
		return this.prevBalanceAmt;
	}

	public void setPrevBalanceAmt(BigDecimal prevBalanceAmt) {
		this.prevBalanceAmt = prevBalanceAmt;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getPrevDueDate() {
		return this.prevDueDate;
	}

	public void setPrevDueDate(Date prevDueDate) {
		this.prevDueDate = prevDueDate;
	}

	public BigDecimal getProcessCycleCode() {
		return this.processCycleCode;
	}

	public void setProcessCycleCode(BigDecimal processCycleCode) {
		this.processCycleCode = processCycleCode;
	}

	public BigDecimal getProcessCycleMonth() {
		return this.processCycleMonth;
	}

	public void setProcessCycleMonth(BigDecimal processCycleMonth) {
		this.processCycleMonth = processCycleMonth;
	}

	public BigDecimal getProcessCycleYear() {
		return this.processCycleYear;
	}

	public void setProcessCycleYear(BigDecimal processCycleYear) {
		this.processCycleYear = processCycleYear;
	}

	public String getProductionRequest() {
		return this.productionRequest;
	}

	public void setProductionRequest(String productionRequest) {
		this.productionRequest = productionRequest;
	}

	public String getProductionType() {
		return this.productionType;
	}

	public void setProductionType(String productionType) {
		this.productionType = productionType;
	}

	public String getPrtCategory() {
		return this.prtCategory;
	}

	public void setPrtCategory(String prtCategory) {
		this.prtCategory = prtCategory;
	}

	public BigDecimal getPymReceivedAmt() {
		return this.pymReceivedAmt;
	}

	public void setPymReceivedAmt(BigDecimal pymReceivedAmt) {
		this.pymReceivedAmt = pymReceivedAmt;
	}

	public BigDecimal getRootBan() {
		return this.rootBan;
	}

	public void setRootBan(BigDecimal rootBan) {
		this.rootBan = rootBan;
	}

	public Date getStartServiceDate() {
		return this.startServiceDate;
	}

	public void setStartServiceDate(Date startServiceDate) {
		this.startServiceDate = startServiceDate;
	}

	public String getSummaryPageInd() {
		return this.summaryPageInd;
	}

	public void setSummaryPageInd(String summaryPageInd) {
		this.summaryPageInd = summaryPageInd;
	}

	public BigDecimal getTaxSeqNo() {
		return this.taxSeqNo;
	}

	public void setTaxSeqNo(BigDecimal taxSeqNo) {
		this.taxSeqNo = taxSeqNo;
	}

	public BigDecimal getTaxTotalInvAmount() {
		return this.taxTotalInvAmount;
	}

	public void setTaxTotalInvAmount(BigDecimal taxTotalInvAmount) {
		this.taxTotalInvAmount = taxTotalInvAmount;
	}

	public BigDecimal getTaxableAmt() {
		return this.taxableAmt;
	}

	public void setTaxableAmt(BigDecimal taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public BigDecimal getTotBanLvlDiscount() {
		return this.totBanLvlDiscount;
	}

	public void setTotBanLvlDiscount(BigDecimal totBanLvlDiscount) {
		this.totBanLvlDiscount = totBanLvlDiscount;
	}

	public BigDecimal getTotBanOcUtcAmt() {
		return this.totBanOcUtcAmt;
	}

	public void setTotBanOcUtcAmt(BigDecimal totBanOcUtcAmt) {
		this.totBanOcUtcAmt = totBanOcUtcAmt;
	}

	public BigDecimal getTotBanRcUtcAmt() {
		return this.totBanRcUtcAmt;
	}

	public void setTotBanRcUtcAmt(BigDecimal totBanRcUtcAmt) {
		this.totBanRcUtcAmt = totBanRcUtcAmt;
	}

	public BigDecimal getTotBanRcvOcUtc() {
		return this.totBanRcvOcUtc;
	}

	public void setTotBanRcvOcUtc(BigDecimal totBanRcvOcUtc) {
		this.totBanRcvOcUtc = totBanRcvOcUtc;
	}

	public BigDecimal getTotBanRcvRcUtc() {
		return this.totBanRcvRcUtc;
	}

	public void setTotBanRcvRcUtc(BigDecimal totBanRcvRcUtc) {
		this.totBanRcvRcUtc = totBanRcvRcUtc;
	}

	public BigDecimal getTotBanRcvUcUtc() {
		return this.totBanRcvUcUtc;
	}

	public void setTotBanRcvUcUtc(BigDecimal totBanRcvUcUtc) {
		this.totBanRcvUcUtc = totBanRcvUcUtc;
	}

	public BigDecimal getTotBanUcUtcAmt() {
		return this.totBanUcUtcAmt;
	}

	public void setTotBanUcUtcAmt(BigDecimal totBanUcUtcAmt) {
		this.totBanUcUtcAmt = totBanUcUtcAmt;
	}

	public BigDecimal getTotCallDurSec() {
		return this.totCallDurSec;
	}

	public void setTotCallDurSec(BigDecimal totCallDurSec) {
		this.totCallDurSec = totCallDurSec;
	}

	public BigDecimal getTotHierDiscountAmt() {
		return this.totHierDiscountAmt;
	}

	public void setTotHierDiscountAmt(BigDecimal totHierDiscountAmt) {
		this.totHierDiscountAmt = totHierDiscountAmt;
	}

	public BigDecimal getTotSubsDiscount() {
		return this.totSubsDiscount;
	}

	public void setTotSubsDiscount(BigDecimal totSubsDiscount) {
		this.totSubsDiscount = totSubsDiscount;
	}

	public BigDecimal getTotTreeDiscount() {
		return this.totTreeDiscount;
	}

	public void setTotTreeDiscount(BigDecimal totTreeDiscount) {
		this.totTreeDiscount = totTreeDiscount;
	}

	public BigDecimal getTotalBilledAdjust() {
		return this.totalBilledAdjust;
	}

	public void setTotalBilledAdjust(BigDecimal totalBilledAdjust) {
		this.totalBilledAdjust = totalBilledAdjust;
	}

	public BigDecimal getTotalBilledCharge() {
		return this.totalBilledCharge;
	}

	public void setTotalBilledCharge(BigDecimal totalBilledCharge) {
		this.totalBilledCharge = totalBilledCharge;
	}

	public BigDecimal getTotalDueAmt() {
		return this.totalDueAmt;
	}

	public void setTotalDueAmt(BigDecimal totalDueAmt) {
		this.totalDueAmt = totalDueAmt;
	}

	public BigDecimal getTreeLevel() {
		return this.treeLevel;
	}

	public void setTreeLevel(BigDecimal treeLevel) {
		this.treeLevel = treeLevel;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getSysUpdateDate() {
		return sysUpdateDate;
	}

	public void setSysUpdateDate(Date sysUpdateDate) {
		this.sysUpdateDate = sysUpdateDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public Date getSysCreationDate() {
		return sysCreationDate;
	}

	public void setSysCreationDate(Date sysCreationDate) {
		this.sysCreationDate = sysCreationDate;
	}

}