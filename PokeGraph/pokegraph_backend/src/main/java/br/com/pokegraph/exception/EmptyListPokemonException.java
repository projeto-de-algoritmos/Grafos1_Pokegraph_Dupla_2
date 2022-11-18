package br.com.pokegraph.exception;

import lombok.Getter;

@Getter
public class EmptyListPokemonException extends RuntimeException {
    private final String message;

    public EmptyListPokemonException(String message){
        super(message);
        this.message = message;
    }
}
