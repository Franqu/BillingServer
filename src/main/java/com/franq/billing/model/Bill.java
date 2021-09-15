package com.franq.billing.model;

import java.util.Date;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bill implements IBill {

	private final UUID id;
	
	private String phoneNumberCaller;
	private String phoneNumberReceiver;
	private boolean ongoing;
	private long lenght; // długość połączenia (okres czasu w przypadku rozmowy telefonicznej, ilość
							// znaków w przypadku SMS
	private long size; // wielkość bajtowa
	private Date callTime; // data wystąpięnia
	private EConnectionType connetionType;

	public Bill(UUID id, @JsonProperty("phoneNumberCaller") String phoneNumberCaller,
			@JsonProperty("phoneNumberReceiver") String phoneNumberReceiver, @JsonProperty("ongoing") boolean ongoing,
			@JsonProperty("size") long size, @JsonProperty("lenght") long lenght, @JsonProperty("callTime") Date callTime,
			@JsonProperty("connectionType") EConnectionType connetionType) {
		this.id = id;
		this.phoneNumberCaller = phoneNumberCaller;
		this.phoneNumberReceiver = phoneNumberReceiver;
		this.ongoing = ongoing;
		this.size = size;
		this.lenght = lenght;
		this.callTime = callTime;
		this.connetionType = connetionType;
	}

	public String getPhoneNumberCaller() {
		return phoneNumberCaller;
	}

	public void setPhoneNumberCaller(String phoneNumberCaller) {
		this.phoneNumberCaller = phoneNumberCaller;
	}

	public String getPhoneNumberReceiver() {
		return phoneNumberReceiver;
	}

	public void setPhoneNumberReceiver(String phoneNumberReceiver) {
		this.phoneNumberReceiver = phoneNumberReceiver;
	}

	public boolean isOngoing() {
		return ongoing;
	}

	public void setOngoing(boolean ongoing) {
		this.ongoing = ongoing;
	}

	public long getLenght() {
		return lenght;
	}

	public void setLenght(long lenght) {
		this.lenght = lenght;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getCallTime() {
		return callTime;
	}

	public void setCallTime(Date callTime) {
		this.callTime = callTime;
	}

	public EConnectionType getConnetionType() {
		return connetionType;
	}

	public void setConnetionType(EConnectionType connetionType) {
		this.connetionType = connetionType;
	}

	public UUID getId() {
		return id;
	}

	@Override
	public void generateRandomBill() {

	}

	@Override
	public void saveBill() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getBill() {
		// TODO Auto-generated method stub

	}

}
