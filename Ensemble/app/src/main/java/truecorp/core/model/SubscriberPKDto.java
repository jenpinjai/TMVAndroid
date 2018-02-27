package truecorp.core.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class SubscriberPKDto implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@JsonProperty("subscriberNo")
	private String subscriberNo;

	@JsonProperty("customerId")
	private long customerId;

	public SubscriberPKDto() {
	}

	public String getSubscriberNo() {
		return this.subscriberNo;
	}

	public void setSubscriberNo(String subscriberNo) {
		this.subscriberNo = subscriberNo;
	}

	public long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SubscriberPKDto)) {
			return false;
		}
		SubscriberPKDto castOther = (SubscriberPKDto) other;
		return this.subscriberNo.equals(castOther.subscriberNo) && (this.customerId == castOther.customerId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.subscriberNo.hashCode();
		hash = hash * prime + ((int) (this.customerId ^ (this.customerId >>> 32)));

		return hash;
	}
}