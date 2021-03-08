package com.hmrc.crimedata.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CrimeDetails {
	
	private String category;
	
	private String location_type;
	
	private String location_subtype;
	
	private String persistent_id;
	
	private String month;
	
	private Location location;
	
	private String context;
	
	private OutcomeStatus outcome_status;
	
	public CrimeDetails() {

	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLocation_type() {
		return location_type;
	}

	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}

	public String getLocation_subtype() {
		return location_subtype;
	}

	public void setLocation_subtype(String location_subtype) {
		this.location_subtype = location_subtype;
	}

	public String getPersistent_id() {
		return persistent_id;
	}

	public void setPersistent_id(String persistent_id) {
		this.persistent_id = persistent_id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public OutcomeStatus getOutcome_status() {
		return outcome_status;
	}

	public void setOutcome_status(OutcomeStatus outcome_status) {
		this.outcome_status = outcome_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((location_subtype == null) ? 0 : location_subtype.hashCode());
		result = prime * result + ((location_type == null) ? 0 : location_type.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((outcome_status == null) ? 0 : outcome_status.hashCode());
		result = prime * result + ((persistent_id == null) ? 0 : persistent_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrimeDetails other = (CrimeDetails) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (location_subtype == null) {
			if (other.location_subtype != null)
				return false;
		} else if (!location_subtype.equals(other.location_subtype))
			return false;
		if (location_type == null) {
			if (other.location_type != null)
				return false;
		} else if (!location_type.equals(other.location_type))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (outcome_status == null) {
			if (other.outcome_status != null)
				return false;
		} else if (!outcome_status.equals(other.outcome_status))
			return false;
		if (persistent_id == null) {
			if (other.persistent_id != null)
				return false;
		} else if (!persistent_id.equals(other.persistent_id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CrimeDetails [category=" + category + ", location_type=" + location_type + ", location_subtype="
				+ location_subtype + ", persistent_id=" + persistent_id + ", month=" + month + ", location=" + location
				+ ", context=" + context + ", outcome_status=" + outcome_status + "]";
	}	

}