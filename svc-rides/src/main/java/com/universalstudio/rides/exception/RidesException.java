package com.universalstudio.rides.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RidesException extends Exception {

	private static final long serialVersionUID = 1L;

	private List<ValidationFailure> msgs = new ArrayList<ValidationFailure>();

	public RidesException() {
	}

	public RidesException(List<ValidationFailure> msgs) {
		super("Validation failed.");
		this.msgs = msgs;
	}

	public RidesException(String msg) {
		super("Validation failed.");
		ValidationFailure vf = new ValidationFailure(null, msg, null, "E");
		this.msgs.add(vf);
	}

	public List<ValidationFailure> getMsgs() {
		return msgs;
	}

	public void setMsgs(List<ValidationFailure> msgs) {
		this.msgs = msgs;
	}

}
