package truecorp.core.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobControlDto {
	
	@JsonProperty("jobname")
	private String jobname;

	@JsonProperty("errmsg")
	private String errmsg;

	@JsonProperty("jobend")
	private Date jobend;

	@JsonProperty("jobpid")
	private BigDecimal jobpid;

	@JsonProperty("jobstart")
	private Date jobstart;

	@JsonProperty("jobstatus")
	private String jobstatus;

	@JsonProperty("runseq")
	private BigDecimal runseq;

	@JsonProperty("username")
	private String username;
	
	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss")
	public Date getJobend() {
		return jobend;
	}

	public void setJobend(Date jobend) {
		this.jobend = jobend;
	}

	public BigDecimal getJobpid() {
		return jobpid;
	}

	public void setJobpid(BigDecimal jobpid) {
		this.jobpid = jobpid;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss")
	public Date getJobstart() {
		return jobstart;
	}

	public void setJobstart(Date jobstart) {
		this.jobstart = jobstart;
	}

	public String getJobstatus() {
		return jobstatus;
	}

	public void setJobstatus(String jobstatus) {
		this.jobstatus = jobstatus;
	}

	public BigDecimal getRunseq() {
		return runseq;
	}

	public void setRunseq(BigDecimal runseq) {
		this.runseq = runseq;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}
