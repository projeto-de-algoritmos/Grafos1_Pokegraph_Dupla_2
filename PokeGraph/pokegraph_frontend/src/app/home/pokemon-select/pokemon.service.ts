import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Pokemons} from './pokemons';
import {Observable} from "rxjs";

const API = 'api';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  constructor(private http: HttpClient) { }

  listPokemon(): Observable<Pokemons> {
    return this.http.get<Pokemons>(`${API}/pokemons`);
  }

  battlePokemon(firstPokemonId: number, secondPokemonId: number): Observable<Pokemons> {
    return this.http.post<Pokemons>(`${API}/battle/${firstPokemonId}/${secondPokemonId}`, {});
  }
}
