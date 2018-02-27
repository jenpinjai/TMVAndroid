/*
 * ----------------------------------------------------------------------------
 * Copyright © 2016 by True Information Technology Co.,Ltd. All rights reserved
 * ----------------------------------------------------------------------------
 */
package truecorp.core.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Supot Saelao
 * @version 1.0
 */
@JsonIgnoreProperties(value = {"selected", "disabled", "readonly"})
public class SelectItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String value;
	private String label;
	private String valueDesc;
	private boolean selected;
	private boolean disabled;
	private boolean readonly;	
	
	public SelectItem() {
		
	}
	
	public SelectItem(String value, String label) {
		this.value = value;
		this.label = label;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValueDesc() {
		return valueDesc;
	}

	public void setValueDesc(String valueDesc) {
		this.valueDesc = valueDesc;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	@Override
    public boolean equals(Object other) {
        return (other instanceof SelectItem) && (value != null)
            ? value.equals(((SelectItem) other).value)
            : (other == this);
    }

    @Override
    public int hashCode() {
        return (value != null)
            ? (this.getClass().hashCode() + value.hashCode())
            : super.hashCode();
    }
    
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
