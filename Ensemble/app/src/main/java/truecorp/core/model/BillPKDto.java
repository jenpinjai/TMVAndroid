package truecorp.core.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class BillPKDto implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@JsonProperty("ban")
	private long ban;

	@JsonProperty("billSeqNo")
	private long billSeqNo;

	@JsonProperty("ben")
	private long ben;

	public BillPKDto() {
	}

	public long getBan() {
		return this.ban;
	}

	public void setBan(long ban) {
		this.ban = ban;
	}

	public long getBillSeqNo() {
		return this.billSeqNo;
	}

	public void setBillSeqNo(long billSeqNo) {
		this.billSeqNo = billSeqNo;
	}

	public long getBen() {
		return this.ben;
	}

	public void setBen(long ben) {
		this.ben = ben;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BillPKDto)) {
			return false;
		}
		BillPKDto castOther = (BillPKDto) other;
		return (this.ban == castOther.ban) && (this.billSeqNo == castOther.billSeqNo) && (this.ben == castOther.ben);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.ban ^ (this.ban >>> 32)));
		hash = hash * prime + ((int) (this.billSeqNo ^ (this.billSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.ben ^ (this.ben >>> 32)));

		return hash;
	}
}
