package com.mcnz.rps.moai;


public class GameSummary {

	private Gesture clientGesture;
	private Gesture serverGesture;
	private Result result;
	private java.util.Date date = new java.util.Date();
	
	public GameSummary(){}
	
	public GameSummary(Gesture clientGesture, Gesture serverGesture, Result result) {
		super();
		this.clientGesture = clientGesture;
		this.serverGesture = serverGesture;
		this.result = result;
		this.date = new java.util.Date();
	}
	
	public Gesture getClientGesture() {
		return clientGesture;
	}
	public void setClientGesture(Gesture clientGesture) {
		this.clientGesture = clientGesture;
	}
	public Gesture getServerGesture() {
		return serverGesture;
	}
	public void setServerGesture(Gesture serverGesture) {
		this.serverGesture = serverGesture;
	}
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}

}







