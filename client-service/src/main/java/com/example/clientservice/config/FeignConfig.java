package com.example.clientservice.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
   private ObjectMapper customObjectMapper() {
       ObjectMapper objectMapper = new ObjectMapper();
       objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
       objectMapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
       objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
       objectMapper.registerModule(new JavaTimeModule());
       objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

       return objectMapper;
   }
}
