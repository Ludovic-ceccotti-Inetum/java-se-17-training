package com.example.httpClient;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class httpClientTest {

    @Test
    public void testClient() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://euw1.api.riotgames.com/lol/platform/v3/champion-rotations"))
                .header("X-Riot-Token","RGAPI-bba8af16-a395-4540-9ee9-de348f5e930b")
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    @Test
    public void testClient2() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://ddragon.leagueoflegends.com/cdn/14.22.1/data/en_US/champion.json"))
                .header("X-Riot-Token","RGAPI-bba8af16-a395-4540-9ee9-de348f5e930b")
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
