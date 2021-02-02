package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
public class ContractDTO {

	private String contractId;
	private String clientId;
	private String productId;
	private String description;
	private LocalDate creationDate;
	
}
