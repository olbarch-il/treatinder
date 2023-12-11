package com.treat.treatinder.service.finder.api;

import com.treat.treatinder.constants.AnimalsTypes;
import com.treat.treatinder.model.dto.AnimalResponse;
import com.treat.treatinder.model.dto.TokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
public class DogFinderClient implements FinderApiClient {
    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final String clientId;
    private final String clientSecret;
    private String accessToken;
    private Instant tokenExpiration;

    public DogFinderClient(RestTemplate restTemplate,
                           @Value("${petfinder.api.url}") String baseUrl,
                           @Value("${petfinder.client.id}") String clientId,
                           @Value("${petfinder.client.secret}") String clientSecret) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public synchronized void ensureValidToken() {
        if (accessToken == null || Instant.now().isAfter(tokenExpiration)) {
            refreshToken();
        }
    }

    private void refreshToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String requestBody = "grant_type=client_credentials&client_id=" + clientId + "&client_secret=" + clientSecret;

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<TokenResponse> response = restTemplate.postForEntity(baseUrl + "/oauth2/token", request,
                TokenResponse.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            accessToken = response.getBody().getAccess_token();
            tokenExpiration = Instant.now().plusSeconds(response.getBody().getExpires_in());
        }
    }

    @Override
    public AnimalResponse fetchAnimals(int page, int limit, AnimalsTypes type) {
        ensureValidToken();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = baseUrl + "/animals" + "?type=" + type + "&limit=" + limit + "&page=" + page;
        ResponseEntity<AnimalResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, AnimalResponse.class);
        return response.getBody();
    }
}
