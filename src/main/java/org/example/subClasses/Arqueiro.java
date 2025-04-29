package org.example.subClasses;

import org.example.Personagem;

public class Arqueiro extends Personagem {
    private final Integer danoAtaqueEspecial = ataque * 2;

    public Arqueiro(String nome) {
        super(nome, 80, 50, 0);
    }

    @Override
    public void atacar(Personagem personagemAlvo) {
        personagemAlvo.tomarDano(ataque);
    }

    public void ataqueEspecial(Personagem personagemAlvo) {
        System.out.println("\nAtaque Especial Chuva de Flechas\n");
        personagemAlvo.tomarDano(danoAtaqueEspecial);
    }
}
