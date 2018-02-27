package truecorp.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BanHierarchyTreeDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private BanHierarchyTreePKDto id;

	@JsonProperty("applicationId")
	private String applicationId;

	@JsonProperty("dlServiceCode")
	private String dlServiceCode;

	@JsonProperty("dlUpdateStamp")
	private BigDecimal dlUpdateStamp;

	@JsonProperty("effectiveDate")
	private Date effectiveDate;
	
	@JsonProperty("expirationDate")
	private Date expirationDate;

	@JsonProperty("nodeUtcPlan")
	private String nodeUtcPlan;

	@JsonProperty("operatorId")
	private BigDecimal operatorId;

	@JsonProperty("parentBan")
	private BigDecimal parentBan;

	@JsonProperty("sysCreationDate")
	private Date sysCreationDate;

	@JsonProperty("sysUpdateDate")
	private Date sysUpdateDate;

	@JsonProperty("treeLevel")
	private BigDecimal treeLevel;
	
	@JsonProperty("parentBillingAccount")
	private ParentBillingAccountDto parentBillingAccount;
	
	@JsonProperty("treeRootBillingAccount")
	private TreeRootBillingAccountDto treeRootBillingAccount;
	

	public BanHierarchyTreePKDto getId() {
		return this.id;
	}

	public void setId(BanHierarchyTreePKDto id) {
		this.id = id;
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getNodeUtcPlan() {
		return this.nodeUtcPlan;
	}

	public void setNodeUtcPlan(String nodeUtcPlan) {
		this.nodeUtcPlan = nodeUtcPlan;
	}

	public BigDecimal getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(BigDecimal operatorId) {
		this.operatorId = operatorId;
	}

	public BigDecimal getParentBan() {
		return this.parentBan;
	}

	public void setParentBan(BigDecimal parentBan) {
		this.parentBan = parentBan;
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

	public BigDecimal getTreeLevel() {
		return this.treeLevel;
	}

	public void setTreeLevel(BigDecimal treeLevel) {
		this.treeLevel = treeLevel;
	}

	public ParentBillingAccountDto getParentBillingAccount() {
		return parentBillingAccount;
	}

	public void setParentBillingAccount(ParentBillingAccountDto parentBillingAccount) {
		this.parentBillingAccount = parentBillingAccount;
	}

	public TreeRootBillingAccountDto getTreeRootBillingAccount() {
		return treeRootBillingAccount;
	}

	public void setTreeRootBillingAccount(TreeRootBillingAccountDto treeRootBillingAccount) {
		this.treeRootBillingAccount = treeRootBillingAccount;
	}

}