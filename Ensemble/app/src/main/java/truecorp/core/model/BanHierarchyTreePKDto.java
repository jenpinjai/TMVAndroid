package truecorp.core.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BanHierarchyTreePKDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("treeRootBan")
	private long treeRootBan;

	@JsonProperty("ban")
	private long ban;

	@JsonProperty("effectiveDate")
	private java.util.Date effectiveDate;

	public long getTreeRootBan() {
		return this.treeRootBan;
	}

	public void setTreeRootBan(long treeRootBan) {
		this.treeRootBan = treeRootBan;
	}

	public long getBan() {
		return this.ban;
	}

	public void setBan(long ban) {
		this.ban = ban;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss" ,timezone = "GMT+7")
	public java.util.Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(java.util.Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BanHierarchyTreePKDto)) {
			return false;
		}
		BanHierarchyTreePKDto castOther = (BanHierarchyTreePKDto) other;
		return (this.treeRootBan == castOther.treeRootBan) && (this.ban == castOther.ban)
				&& this.effectiveDate.equals(castOther.effectiveDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.treeRootBan ^ (this.treeRootBan >>> 32)));
		hash = hash * prime + ((int) (this.ban ^ (this.ban >>> 32)));
		hash = hash * prime + this.effectiveDate.hashCode();

		return hash;
	}
}