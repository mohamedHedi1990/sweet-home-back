package org.sweetrooms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.sweetrooms.enumeration.ReservationStatus;
import org.sweetrooms.enumeration.RoleCode;
import org.sweetrooms.persistence.entities.*;
import org.sweetrooms.persistence.repositories.*;
import org.thymeleaf.spring4.SpringTemplateEngine;

import java.util.Date;

@SpringBootApplication
public class SweetroomsApplication implements CommandLineRunner {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private LodgerRepository lodgerRepository;
	@Autowired
	private AnnouncementRepository announcementRepository;
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

    	/*this.reservationRepository.save(new Reservation(null, 5, ReservationStatus.PENDING,
				new Date(), new Date(), (this.lodgerRepository.findById((long) 13).get()), this.announcementRepository.findById((long) 1).get()));

		this.reservationRepository.save(new Reservation(null, 5, ReservationStatus.PENDING,
				new Date(), new Date(), (this.lodgerRepository.findById((long) 17).get()), this.announcementRepository.findById((long) 6).get()));

		this.reservationRepository.save(new Reservation(null, 5, ReservationStatus.PENDING,
				new Date(), new Date(), (this.lodgerRepository.findById((long) 18).get()), this.announcementRepository.findById((long) 1).get()));

		this.reservationRepository.save(new Reservation(null, 5, ReservationStatus.PENDING,
				new Date(), new Date(), (this.lodgerRepository.findById((long) 17).get()), this.announcementRepository.findById((long) 7).get()));

		this.reservationRepository.save(new Reservation(null, 5, ReservationStatus.PENDING,
				new Date(), new Date(), (this.lodgerRepository.findById((long) 13).get()), this.announcementRepository.findById((long) 1).get()));
*/
	}
}
