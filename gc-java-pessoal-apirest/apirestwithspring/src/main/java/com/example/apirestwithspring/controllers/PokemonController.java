package com.example.apirestwithspring.controllers;

import com.example.apirestwithspring.entities.pokemonDTO;
import com.example.apirestwithspring.services.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokeApi")
public class PokemonController {

    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping("/pokemon/{pokemon_name}")
    public String whoIsThatPokemon (@PathVariable String pokemon_name){
        return service.getPokemonByName(pokemon_name);
    }
    @GetMapping("/pokemon/limt/{limit}")
    public List<pokemonDTO> ALLpokemon (@PathVariable int limit){
        return service.getALLpokemon(limit);
    }

}
