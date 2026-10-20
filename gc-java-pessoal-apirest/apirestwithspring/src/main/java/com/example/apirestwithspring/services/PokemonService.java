package com.example.apirestwithspring.services;

import com.example.apirestwithspring.entities.Pokemon;
import com.example.apirestwithspring.entities.pokemonDTO;
import com.example.apirestwithspring.entities.pokemons;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Objects;

@Service
public class PokemonService {

    private final RestClient client;

    public PokemonService(RestClient.Builder builder) {
        this.client = RestClient.builder().baseUrl("https://pokeapi.co/api/v2").build();
    }

    public String getPokemonByName(String pokemon_name) {
        return Objects.requireNonNull(client.get()
                        .uri("/pokemon/{pokemon_name}", pokemon_name)
                        .retrieve()
                        .body(Pokemon.class))
                .toString();
    }

    public List<pokemonDTO> getALLpokemon(int limit) {
        pokemons response = Objects.requireNonNull(client.get()
                .uri("/pokemon?Limit=" + limit + "&offset=0")
                .retrieve()
                .body(pokemons.class));

        return response.results().stream()
                .map(pokemon -> new pokemonDTO(
                        pokemon.name(),
                        pokemon.url()
                ))
                .toList();
    }
}
