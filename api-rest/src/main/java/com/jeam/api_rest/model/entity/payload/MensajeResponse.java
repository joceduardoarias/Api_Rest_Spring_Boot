package com.jeam.api_rest.model.entity.payload;

import java.io.Serializable;

import lombok.*;

@Data
@ToString
@Builder
public class MensajeResponse implements Serializable {
	private String mensaje;
	private Object data;	
}
