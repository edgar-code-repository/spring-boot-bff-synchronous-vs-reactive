package com.example.demo.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContractWrapperResponseDTO {

	private List<ContractDTO> contractsList;
	
}
