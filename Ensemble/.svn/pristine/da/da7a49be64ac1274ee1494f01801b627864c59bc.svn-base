/*
* -----------------------------------------------------------------------------------
* Copyright © 2018 by True Information Technology Co.,Ltd. All rights reserved
* -----------------------------------------------------------------------------------
*/
package truecorp.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Supot Saelao
 * @version 1.0
 */
public class RestResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final int OK = 200;
	
	protected int status;
	protected String message;
	protected List<String> errors;

	public RestResponse() {
		super();
	}

	public RestResponse(int status) {
		super();
		this.status = status;
	}

	public RestResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public RestResponse(int status, String message, List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public void addError(String err) {
		if (err == null || err.trim().isEmpty()) {
			return;
		}

		if (errors == null) {
			errors = new ArrayList<>();
		}
		errors.add(err);
	}
	
	@JsonIgnore
	public boolean isSuccess() {
		return (OK == status);
	}
	
	@JsonIgnore
	public boolean isError() {
		return !isSuccess();
	}
}
