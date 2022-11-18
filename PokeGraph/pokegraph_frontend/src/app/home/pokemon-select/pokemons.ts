export interface Pokemon {
  id: number;
  name: string;
  url: string;
  firstType: string;
  secondType: string;
}

export type Pokemons = Array<Pokemon>;
