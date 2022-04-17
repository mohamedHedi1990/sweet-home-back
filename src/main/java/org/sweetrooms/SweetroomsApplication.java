package org.sweetrooms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.sweetrooms.enumeration.RoleCode;
import org.sweetrooms.persistence.entities.City;
import org.sweetrooms.persistence.entities.Country;
import org.sweetrooms.persistence.entities.Role;
import org.sweetrooms.persistence.repositories.CityRepository;
import org.sweetrooms.persistence.repositories.CountryRepository;
import org.sweetrooms.persistence.repositories.RoleRepository;

@SpringBootApplication
public class SweetroomsApplication implements CommandLineRunner {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private CityRepository cityRepository;
    private static final Logger logger = LoggerFactory.getLogger(SweetroomsApplication.class);
    public static void main(String[] args) {

        SpringApplication.run(SweetroomsApplication.class, args);
        logger.info("------------ The sweet rooms server was sucessuflly started ---");
    }
    @Override
    public void run(String... arg0) throws Exception {
    	logger.info("------------ PROCESS TO EXECUTE WHEN STARTING THE SERVER  ---");
    	Role adminRole = this.roleRepository.findByRoleCode(RoleCode.ADMINISTRATOR);
    	if(adminRole == null) {
    		adminRole = new Role();
    		adminRole.setRoleCode(RoleCode.ADMINISTRATOR);
    		adminRole.setRoleLabel("ADMINISTRATEUR");
    		this.roleRepository.save(adminRole);
    	}
    	Role lodgerRole = this.roleRepository.findByRoleCode(RoleCode.LODGER);
    	if(lodgerRole == null) {
    		lodgerRole = new Role();
    		lodgerRole.setRoleCode(RoleCode.LODGER);
    		lodgerRole.setRoleLabel("LOCATAIRE");
    		this.roleRepository.save(lodgerRole);
    	}
    	Role ownerRole = this.roleRepository.findByRoleCode(RoleCode.OWNER);
    	if(ownerRole == null) {
    		ownerRole = new Role();
    		ownerRole.setRoleCode(RoleCode.OWNER);
    		ownerRole.setRoleLabel("PROPRIETAIRE");
    		this.roleRepository.save(ownerRole);
    	}
    	
    	Country tnCountry = this.countryRepository.findByCountryCode("TN");
    	if(tnCountry == null) {
    		tnCountry = new Country();
    		tnCountry.setCountryCode("TN");
    		tnCountry.setCountryLabel("Tunisie");
    		tnCountry = this.countryRepository.save(tnCountry);
    	}
    	
    	//cities
    	City tunis = this.cityRepository.findByCityCode("TUNIS");
    	if(tunis == null) {
    		tunis = new City();
    		tunis.setCityCode("TUNIS");
    		tunis.setCityLabel("Tunis");
    		tunis.setCountry(tnCountry);
    		tunis = this.cityRepository.save(tunis);
    	}
    	City ariana = this.cityRepository.findByCityCode("ARIANA");
    	if(ariana == null) {
    		ariana = new City();
    		ariana.setCityCode("ARIANA");
    		ariana.setCityLabel("Ariana");
    		ariana.setCountry(tnCountry);
    		ariana = this.cityRepository.save(ariana);
    	}
    	City nabeul = this.cityRepository.findByCityCode("NABEUL");
    	if(nabeul == null) {
    		nabeul = new City();
    		nabeul.setCityCode("NABEUL");
    		nabeul.setCityLabel("Nabeul");
    		nabeul.setCountry(tnCountry);
    		nabeul = this.cityRepository.save(nabeul);
    	}
    	City sfax = this.cityRepository.findByCityCode("SFAX");
    	if(sfax == null) {
    		sfax = new City();
    		sfax.setCityCode("SFAX");
    		sfax.setCityLabel("Sfax");
    		sfax.setCountry(tnCountry);
    		sfax = this.cityRepository.save(sfax);
    	}
    	
    }

}
