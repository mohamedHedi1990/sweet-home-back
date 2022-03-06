package org.sweetrooms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SweetroomsApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(SweetroomsApplication.class);
    public static void main(String[] args) {

        SpringApplication.run(SweetroomsApplication.class, args);
        logger.info("------------ The sweet rooms server was sucessuflly started ---");
    }
    @Override
    public void run(String... arg0) throws Exception {
        System.out.println("xxxx");
    }

}
