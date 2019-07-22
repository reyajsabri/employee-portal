package com.employee.portal.app.vo;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author reyaj.ahmed
 *
 */
public class EmployeeSearchCriteriaVO {

	@NotNull
	private String searchBy;
	
	@NotNull
	private String orderBy;
	
	public EmployeeSearchCriteriaVO(@JsonProperty("searchBy") String searchBy,
			@JsonProperty("orderBy") String orderBy) {
		
		this.searchBy = searchBy;
		this.orderBy = orderBy;
	}
}
