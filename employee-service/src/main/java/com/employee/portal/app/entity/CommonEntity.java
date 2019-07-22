package com.employee.portal.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * @author reyaj.ahmed
 *
 */
@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Employee.class})
public class CommonEntity {
	
	@OneToOne
	@JoinColumn(name = "CREATED_BY")
	@XmlAttribute(name="createdBy")
	private Employee createdBy;
	
	@Column(name= "ACTIVE", length = 1)
	@XmlAttribute(name="active")
	private char active;
	
	@Column(name= "VERSION")
	@XmlAttribute(name="version")
	private int version;
	
	@CreatedDate
	@Column(name= "CREATED_ON")
	@XmlAttribute(name="createdOn")
	private LocalDateTime createdOn;
	
	@LastModifiedDate
	@Column(name= "UPDATED_ON")
	@XmlAttribute(name="updatedOn")
	private LocalDateTime updatedOn;
	
	@OneToOne
	@JoinColumn(name = "UPDATED_BY")
	@XmlAttribute(name="updatedBy")
	private Employee updatedBy;

	public Employee getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}

	public char getActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Employee getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Employee updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}
