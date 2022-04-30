package org.sweetrooms.business.mappers;

import org.sweetrooms.client.dtos.response.EquipementResponse;
import org.sweetrooms.persistence.entities.EquipementAnnoncement;

public class EquipementMapper {
	
	public static EquipementResponse toEquipementFromEquipeAnnounce(EquipementAnnoncement ea)
	{
		return new EquipementResponse(ea.getEquipement().getEquipementLabel()
				,ea.getEquipement().getEquipementCode());
	}
	
	private EquipementMapper() {
		
	}

}
