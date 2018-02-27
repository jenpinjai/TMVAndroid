package truecorp.core.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundPKDto implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("ban")
	private long ban;

	@JsonProperty("entSeqNo")
	private long entSeqNo;

	@JsonProperty("actvSeqNo")
	private long actvSeqNo;

	public RefundPKDto() {
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

	
}