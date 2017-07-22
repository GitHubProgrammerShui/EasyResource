package org.resource.exception;

public class ResourceException extends Exception {
	private String reason;

	public ResourceException(String reason){
		this.reason=reason;
	}
	
	public String getReason() {
		return reason;
	}
	
	@Override
	public String toString() {
		return "org.resource.exception.ResourceException:"+reason;
	}
}
