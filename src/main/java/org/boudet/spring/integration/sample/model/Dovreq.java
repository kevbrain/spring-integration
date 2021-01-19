package org.boudet.spring.integration.sample.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Dovreq implements Serializable {

	private String from;
	
	private String to;
	
	private String msg;
	
	
}
