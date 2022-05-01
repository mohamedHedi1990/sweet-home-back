package org.sweetrooms.business.mappers;

import org.sweetrooms.dtos.EquipementDto;
import org.sweetrooms.persistence.entities.Equipement;

public class EquipementMapper {

	public static EquipementDto toEquipementDto(Equipement equipement) {
		return new EquipementDto(equipement.getEquipementId(), equipement.getEquipementLabel(),
				equipement.getEquipementCode());
	}
	
	public static Equipement toEquipement(EquipementDto equipement) {
		return new Equipement(equipement.getEquipementId(), equipement.getEquipementLabel(),
				equipement.getEquipementCode());
	}

}
