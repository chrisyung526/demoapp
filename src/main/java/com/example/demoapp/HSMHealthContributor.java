package com.example.demoapp;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("HSM")
public class HSMHealthContributor implements HealthIndicator, HealthContributor {

    @Override
    public Health health() {
        // you do some checking here
        // eg. get the Key, do an AES Encryption
        // if error, return Health.outOfService().withException(ex).build();
        return Health.up().withDetail("HSM module","Some Module Name Here").withDetail("AES Encrypt","Success").build();
    }

}