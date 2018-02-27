/*
* -----------------------------------------------------------------------------------
* Copyright © 2018 by True Information Technology Co.,Ltd. All rights reserved
* -----------------------------------------------------------------------------------
*/
package truecorp.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Supot Saelao
 * @version 1.0
 */
public class ManualPaymentDto implements Serializable {
	private static final long serialVersionUID = 1752119466491353952L;

	private String clientName;
	private String user;
	private String sourceId;
	private String sourceCode;
	private List<ManualPaymentRecord> records;

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public List<ManualPaymentRecord> getRecords() {
		return records;
	}

	public void setRecords(List<ManualPaymentRecord> records) {
		this.records = records;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public void addRecord(ManualPaymentRecord record) {
		if (records == null) {
			records = new ArrayList<>();
		}
		records.add(record);
	}
}
