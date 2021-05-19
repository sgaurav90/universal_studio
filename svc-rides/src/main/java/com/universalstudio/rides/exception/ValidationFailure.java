package com.universalstudio.rides.exception;

import java.io.Serializable;

public class ValidationFailure implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2708290494163945068L;

	private String fldNm;
	private String msgTxt;
	private String msgId;
	private String msgTyp;

	public ValidationFailure() {
	}

	public ValidationFailure(String fldNm, String msgTxt, String msgId, String msgTyp) {
		super();
		this.fldNm = fldNm;
		this.msgTxt = msgTxt;
		this.msgId = msgId;
		this.msgTyp = msgTyp;
	}

	public ValidationFailure(String msgTxt, String msgTyp) {
		super();
		this.fldNm = "";
		this.msgTxt = msgTxt;
		this.msgId = "";
		this.msgTyp = msgTyp;
	}

	public String getFldNm() {
		return fldNm;
	}

	public void setFldNm(String fldNm) {
		this.fldNm = fldNm;
	}

	public String getMsgTxt() {
		return msgTxt;
	}

	public void setMsgTxt(String msgTxt) {
		this.msgTxt = msgTxt;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgTyp() {
		return msgTyp;
	}

	public void setMsgTyp(String msgTyp) {
		this.msgTyp = msgTyp;
	}

}
