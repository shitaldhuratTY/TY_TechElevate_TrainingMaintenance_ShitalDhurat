package com.tyss.trainingmaintenance.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Batch_Info")
public class BatchInfo {
	
	@Id	
	@GenericGenerator(name = "string_based_custom_sequence", strategy = "com.tyss.trainingmaintenance.dto.BatchIdGenerator")
	@GeneratedValue(generator="string_based_custom_sequence")
	@Column(name="Batch_Code")
	private String batchCode;
	@Column(name="Client")
	private String client;
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getBatchType() {
		return batchType;
	}
	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}
	public double getFeeInfo() {
		return feeInfo;
	}
	public void setFeeInfo(double feeInfo) {
		this.feeInfo = feeInfo;
	}
	public double getCostPerCandidate() {
		return costPerCandidate;
	}
	public void setCostPerCandidate(double costPerCandidate) {
		this.costPerCandidate = costPerCandidate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTraineeType() {
		return traineeType;
	}
	public void setTraineeType(String traineeType) {
		this.traineeType = traineeType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getModeOfTraining() {
		return modeOfTraining;
	}
	public void setModeOfTraining(String modeOfTraining) {
		this.modeOfTraining = modeOfTraining;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	@Column(name="Technology")
	private String technology;
	@Column(name="Batch_Type")
	private String batchType;
	@Column(name="Fee_Info")
	private double feeInfo;
	@Column(name="Cost_Per_Candidate")
	private double costPerCandidate;
	@Column(name="Location")
	private String location;
	@Column(name="Trainee_Type")
	private String traineeType;
	@Column(name="Start_Date")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date startDate;
	@Column(name="End_Date")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date endDate;
	@Column(name="Mode_Of_Training")
	private String modeOfTraining;
	@Column(name="Invoice_Date")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date invoiceDate;

}
