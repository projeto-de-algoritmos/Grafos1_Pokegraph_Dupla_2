package br.com.pokegraph.service;

import br.com.pokegraph.dto.PokemonDTO;
import br.com.pokegraph.exception.EmptyListPokemonException;
import br.com.pokegraph.exception.NoExistentPokemonException;
import br.com.pokegraph.model.Pokemon;
import br.com.pokegraph.repository.PokemonRepository;
import br.com.pokegraph.utils.MatrixUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {
    private final PokemonRepository repository;

    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }

    public List<PokemonDTO> listAll(){
        List<PokemonDTO> pokemonDTOList = new ArrayList<>();
        List<Pokemon> pokemonList = repository.findAll();
        pokemonList.forEach(pokemon -> pokemonDTOList.add(new PokemonDTO(pokemon)));
        if (pokemonDTOList.isEmpty()) {
            throw new EmptyListPokemonException("Não existe pokêmon's cadastrados!");
        }
        return pokemonDTOList;
    }


    public PokemonDTO battlePokemon(Long firstPokemonId, Long secondPokemonId) {
        Optional<Pokemon> firstPokemon = repository.findById(firstPokemonId);
        Optional<Pokemon> secondPokemon = repository.findById(secondPokemonId);
        PokemonDTO winnerPokemon = new PokemonDTO();
        if (firstPokemon.isPresent() && secondPokemon.isPresent()) {
            // pegamos o id do tipo que será a linha que compararemos

            // Pokemon 1 ataca o tipo 1 do pokemon 2 usando seu primeiro tipo
            int i1 = Math.toIntExact(firstPokemon.get().getFirstType().getId());
            int j1 = Math.toIntExact(secondPokemon.get().getFirstType().getId());

            Float result1 = MatrixUtils.result(i1, j1);

            // Pokemon 1 ataca o tipo 2 do pokemon 2 usando seu segundo tipo
            int i2 = Math.toIntExact(firstPokemon.get().getFirstType().getId());
            int j2 = Math.toIntExact(secondPokemon.get().getSecondType().getId());

            Float result2 = MatrixUtils.result(i2, j2);

            // Pokemon 1 ataca o tipo 1 do pokemon 2 usando seu primeiro tipo
            int i3 = Math.toIntExact(firstPokemon.get().getSecondType().getId());
            int j3 = Math.toIntExact(secondPokemon.get().getFirstType().getId());

            Float result3 = MatrixUtils.result(i3, j3);

            // Pokemon 2 ataca o tipo 2 do pokemon 2 usando seu segundo tipo
            int i4 = Math.toIntExact(firstPokemon.get().getSecondType().getId());
            int j4 = Math.toIntExact(secondPokemon.get().getSecondType().getId());

            Float result4 = MatrixUtils.result(i4, j4);

            // Pokemon 1 ataca o tipo 1 do pokemon 2 usando seu primeiro tipo
            int i5 = Math.toIntExact(secondPokemon.get().getFirstType().getId());
            int j5 = Math.toIntExact(firstPokemon.get().getFirstType().getId());

            Float result5 = MatrixUtils.result(i5, j5);

            // Pokemon 1 ataca o tipo 2 do pokemon 2 usando seu segundo tipo
            int i6 = Math.toIntExact(secondPokemon.get().getSecondType().getId());
            int j6 = Math.toIntExact(firstPokemon.get().getFirstType().getId());

            Float result6 = MatrixUtils.result(i6, j6);

            // Pokemon 1 ataca o tipo 1 do pokemon 2 usando seu primeiro tipo
            int i7 = Math.toIntExact(secondPokemon.get().getFirstType().getId());
            int j7 = Math.toIntExact(firstPokemon.get().getSecondType().getId());

            Float result7 = MatrixUtils.result(i7, j7);

            // Pokemon 2 ataca o tipo 2 do pokemon 2 usando seu segundo tipo
            int i8 = Math.toIntExact(secondPokemon.get().getSecondType().getId());
            int j8 = Math.toIntExact(firstPokemon.get().getSecondType().getId());

            Float result8 = MatrixUtils.result(i8, j8);

            Float resultado = result1 + result2 + result3 + result4;
            Float resultado2 = result5 + result6 + result7 + result8;

            if (resultado > resultado2){
                winnerPokemon = new PokemonDTO(firstPokemon.get());
            } else {
                winnerPokemon = new PokemonDTO(secondPokemon.get());
            }

        } else {
            throw new NoExistentPokemonException("Não existe pokêmon's cadastrados para esse id: " + firstPokemon);
        }

        return winnerPokemon;

    }
}
