package com.sansthas.springmvc.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min=3, max=50)
	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "FATHERNAME", nullable = false)
	private String fatherName;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "USERTYPE")
	private String userType;
	
	@Column(name = "RESADDRESS", nullable = false)
	private String ResidentialAddress;
	
	@Column(name = "SCHCOLADDRESS", nullable = false)
	private String schoolCollAddress;
	
	

	@Column(name = "STATE", nullable = false)
	private String state;
	
	@Column(name = "CITY", nullable = false)
	private String city;

	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(name = "DOB", nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dateOfBirth;
	
	@Column(name = "PINCODE", nullable = false)
	private String pincode;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name = "REGFEES", nullable = false)
	private String regFees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getResidentialAddress() {
		return ResidentialAddress;
	}

	public void setResidentialAddress(String residentialAddress) {
		ResidentialAddress = residentialAddress;
	}

	public String getSchoolCollAddress() {
		return schoolCollAddress;
	}

	public void setSchoolCollAddress(String schoolCollAddress) {
		this.schoolCollAddress = schoolCollAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegFees() {
		return regFees;
	}

	public void setRegFees(String regFees) {
		this.regFees = regFees;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", fatherName=" + fatherName + ", gender=" + gender
				+ ", userType=" + userType + ", ResidentialAddress=" + ResidentialAddress + ", schoolCollAddress="
				+ schoolCollAddress + ", state=" + state + ", city=" + city + ", dateOfBirth=" + dateOfBirth
				+ ", pincode=" + pincode + ", email=" + email + ", regFees=" + regFees + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ResidentialAddress, city, dateOfBirth, email, fatherName, gender, id, name, pincode,
				regFees, schoolCollAddress, state, userType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(ResidentialAddress, other.ResidentialAddress) && Objects.equals(city, other.city)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(email, other.email)
				&& Objects.equals(fatherName, other.fatherName) && Objects.equals(gender, other.gender)
				&& id == other.id && Objects.equals(name, other.name) && Objects.equals(pincode, other.pincode)
				&& Objects.equals(regFees, other.regFees) && Objects.equals(schoolCollAddress, other.schoolCollAddress)
				&& Objects.equals(state, other.state) && Objects.equals(userType, other.userType);
	}

	
	

}
