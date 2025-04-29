package org.example.subClasses;

import org.example.Personagem;

public class Guerreiro extends Personagem {
    private final Integer danoAtaqueEspecial = ataque + 10;

    public Guerreiro(String nome) {
        super(nome, 120, 30, 40);
    }

    @Override
    public void atacar(Personagem personagemAlvo) {
        personagemAlvo.tomarDano(ataque);
    }

    public void ataqueEspecial(Personagem personagemAlvo) {
        System.out.println("\nAtaque Especial Mil Cortes\n");
        personagemAlvo.tomarDano(danoAtaqueEspecial);
    }
}
