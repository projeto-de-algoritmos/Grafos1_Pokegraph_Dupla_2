package br.com.pokegraph.enumeration;

import lombok.Getter;

@Getter
public enum Type {
    NORMAL(0L, "Normal"), // 0
    FIRE(1L, "Fire"), // 1
    WATER(2L, "Water"), // 2
    GRASS(3L, "Grass"), // 3
    ELECTRIC(4L, "Electric"), // 4
    ICE(5L, "Ice"), // 5
    FIGHTING(6L, "Fighting"), // 6
    POISON(7L, "Poison"), // 7
    GROUND(8L, "Ground"), // 8
    FLYING(9L, "Flying"), // 9
    PSYCHIC(10L, "Psychic"), // 10
    BUG(11L, "Bug"), // 11
    ROCK(12L, "Rock"), // 12
    GHOST(13L, "Ghost"), // 13
    DRAGON(14L, "Dragon"), // 14
    DARK(15L, "Dark"), // 15
    STEEL(16L, "Steel"), // 16
    FAIRY(17L, "Fairy"),  // 17
    NONE(18L, "None")
    ;

    private final Long id;
    private final String name;

    Type(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
