package com.sl.bookingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Component
public class PassengerClient {
    private final RestClient restClient;

    @Autowired
    public PassengerClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("http://passenger-service")
                .build();
    }

    public Optional<PassengerDto> getPassengerById(Long id) {
        try {
            PassengerDto passenger = restClient.get()
                    .uri("/passengers/{id}", id)
                    .retrieve()
                    .body(PassengerDto.class);
            return Optional.ofNullable(passenger);
        } catch (HttpClientErrorException.NotFound e) {
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
