package com.mcnz.rps;

public class GameSummary {

	String clientGesture;
	String serverGesture;
	String result;
	java.util.Date date;
	
	public GameSummary(){}

	public String getClientGesture() {
		return clientGesture;
	}
	public void setClientGesture(String clientGesture) {
		this.clientGesture = clientGesture;
	}
	public String getServerGesture() {
		return serverGesture;
	}
	public void setServerGesture(String serverGesture) {
		this.serverGesture = serverGesture;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public GameSummary(String clientGesture, String serverGesture, String result) {
		super();
		this.clientGesture = clientGesture;
		this.serverGesture = serverGesture;
		this.result = result;
		date = new java.util.Date();
	}
	@Override
	public String toString() {
		return "GameSummary [clientGesture=" + clientGesture
				+ ", serverGesture=" + serverGesture + ", result=" + result
				+ ", date=" + date + "]";
	}
	
	
}