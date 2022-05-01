package org.sweetrooms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipementDto {
	private Long equipementId;
	private String equipementLabel;
	private String equipementCode;

}
