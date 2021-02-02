package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.ContractWrapperResponseDTO;
import com.example.demo.dto.WrapperResponseDTO;

import lombok.extern.java.Log;

@RestController
@Log
public class ContractsByClientController {

	@Autowired
	private RestTemplate restTemplate;	
	
	@GetMapping("/clientInfo")
	public WrapperResponseDTO getClientInfo() {
		log.info("[ContractsByClientController][getClientInfo][START]");
	
		WrapperResponseDTO wrapperResponse = new WrapperResponseDTO();
		
		String urlClient = "http://localhost:8801/clients/1";
		String urlContractsByClient = "http://localhost:8802/clients/1/contracts";		
		
		log.info("[ContractsByClientController][getClientInfo][date before calling first endpoint: " + LocalDateTime.now() + "]");
		ClientDTO clientResponse = restTemplate.getForObject(urlClient, ClientDTO.class);
		
		log.info("[ContractsByClientController][getClientInfo][date after calling first endpoint: " + LocalDateTime.now() + "]");
		ContractWrapperResponseDTO contractWrapperResponse = restTemplate.getForObject(urlContractsByClient, ContractWrapperResponseDTO.class);
		
		log.info("[ContractsByClientController][getClientInfo][date after calling second endpoint: " + LocalDateTime.now() + "]");
		wrapperResponse.setClient(clientResponse);
		wrapperResponse.setContractWrapper(contractWrapperResponse);
		
		log.info("[ContractsByClientController][getClientInfo][END]");
		return wrapperResponse;
		
	}
	
}
