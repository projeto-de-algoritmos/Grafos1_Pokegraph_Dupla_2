import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {PokemonService} from './pokemon.service';
import {Pokemon} from './pokemons';
import {MatSelectChange} from "@angular/material/select";
import {MatDialog} from "@angular/material/dialog";
import {ModalWinnerComponent} from "../modal-winner/modal-winner.component";


@Component({
  selector: 'app-pokemon-select',
  templateUrl: './pokemon-select.component.html',
  styleUrls: ['./pokemon-select.component.css']
})
export class PokemonSelectComponent implements OnInit {

  options: any[] = [];
  imageAlt: any;
  imageSourceSelf: any;
  imageSourceOther: any;
  firstPokemon: any = null;
  secondPokemon: any = null;

  pokemonForm = this.formBuilder.group({
    pokemon1: '',
    pokemon2: '',
  });

  constructor(
    private pokemonService: PokemonService,
    private formBuilder: FormBuilder,
    public dialog: MatDialog,
  ) {

  }

  ngOnInit(): void {
    console.log(this.firstPokemon)
    this.pokemonService.listPokemon().subscribe((response: any) => {
      response.map((pokemon: Pokemon) => {
        this.extract(pokemon);
      });
      this.options = response
      console.log(this.options)
    });
  }

  openDialog(response: any): void {
    const dialogRef = this.dialog.open(ModalWinnerComponent, {
      width: '500px',
      height: '500px',
      data: response,
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  extract(pokemon: Pokemon) {
    return {
      id: pokemon.id,
      name: pokemon.name,
      url: pokemon.url
    };
  }


  loadPokemonSelf($event: MatSelectChange) {
    if($event.value !== null){
      this.imageSourceSelf = $event.value.url
      this.firstPokemon = $event.value.id
    } else {
      this.firstPokemon = $event.value
    }
  }
  loadPokemonOther($event: MatSelectChange) {
    if($event.value !== null){
      this.imageSourceOther = $event.value.url
      this.secondPokemon = $event.value.id
    } else {
      this.secondPokemon = $event.value
    }
  }

  battle() {
    this.pokemonService.battlePokemon(this.firstPokemon, this.secondPokemon).subscribe((response: any) => {
      this.openDialog(response);
    });

  }
}
