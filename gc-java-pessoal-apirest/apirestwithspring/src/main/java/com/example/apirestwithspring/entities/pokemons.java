package com.example.apirestwithspring.entities;

import java.util.List;

public record pokemons(
        int count,
        String next,
        String previous,
        List<pokemonDTO> results
) {
}
