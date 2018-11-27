package com.football.auth;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;


@SpringBootApplication
public class AuthApplication {
    private static final Logger LOGGER = LogManager.getLogger(AuthApplication.class);

    public static void main(String[] args) {
//        SpringApplication.run(AuthApplication.class, args);
        long id = System.currentTimeMillis();
        LOGGER.info("[B][" + id + "] >>>>>>>>>>>>>>>>>>>>>>>>>> Start AuthApplication ...");
        SpringApplication app = new SpringApplication(AuthApplication.class);

        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String ipServer = "localhost";
        try {
            ipServer = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            ipServer = env.getProperty("server.address") != null ? env.getProperty("server.address") : "localhost";
        }
        LOGGER.info("----------------------------------------------------------");
        LOGGER.info("   Application         : " + env.getProperty("spring.application.name"));
        LOGGER.info("   Url                 : " + protocol + "://" + ipServer + ":" + env.getProperty("server.port"));
        LOGGER.info("   Profile(s)          : " + env.getActiveProfiles()[0]);
        LOGGER.info("----------------------------------------------------------");

        LOGGER.info("[E][" + id + "][Duration = " + (System.currentTimeMillis() - id) + "] >>>>>>>>>>>>>>>>>>>>>>>>>> End Start AuthApplication ...");
    }

}
