package truecorp.core.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class PaymentActivityPKDto implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@JsonProperty("ban")
	private long ban;

	@JsonProperty("entSeqNo")
	private long entSeqNo;

	@JsonProperty("actvSeqNo")
	private long actvSeqNo;

	public PaymentActivityPKDto() {
	}

	public long getBan() {
		return this.ban;
	}

	public void setBan(long ban) {
		this.ban = ban;
	}

	public long getEntSeqNo() {
		return this.entSeqNo;
	}

	public void setEntSeqNo(long entSeqNo) {
		this.entSeqNo = entSeqNo;
	}

	public long getActvSeqNo() {
		return this.actvSeqNo;
	}

	public void setActvSeqNo(long actvSeqNo) {
		this.actvSeqNo = actvSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PaymentActivityPKDto)) {
			return false;
		}
		PaymentActivityPKDto castOther = (PaymentActivityPKDto) other;
		return (this.ban == castOther.ban) && (this.entSeqNo == castOther.entSeqNo)
				&& (this.actvSeqNo == castOther.actvSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.ban ^ (this.ban >>> 32)));
		hash = hash * prime + ((int) (this.entSeqNo ^ (this.entSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.actvSeqNo ^ (this.actvSeqNo >>> 32)));

		return hash;
	}
}