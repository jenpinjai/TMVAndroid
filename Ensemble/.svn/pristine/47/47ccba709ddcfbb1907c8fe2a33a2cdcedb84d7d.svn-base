/*
* -----------------------------------------------------------------------------------
* Copyright © 2018 by True Information Technology Co.,Ltd. All rights reserved
* -----------------------------------------------------------------------------------
*/
package truecorp.core.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Supot Saelao
 * @version 1.0
 */
public class RestRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String requestId;
	protected Clients client;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}
	
	@JsonIgnore
	public boolean isClientWeb() {
		return (Clients.WEB == client);
	}
	
	@JsonIgnore
	public boolean isClientBatch() {
		return (Clients.BATCH == client);
	}
	
	@JsonIgnore
	public boolean isClientMobile() {
		return (Clients.MOBILE == client);
	}
}
