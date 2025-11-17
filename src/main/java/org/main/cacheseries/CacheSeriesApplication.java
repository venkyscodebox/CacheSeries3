package org.main.cacheseries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching  
public class CacheSeriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheSeriesApplication.class, args);
    }

}
