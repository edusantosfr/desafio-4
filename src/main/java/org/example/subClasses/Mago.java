package org.example.subClasses;

import org.example.Personagem;

public class Mago extends Personagem {
    private final Integer danoAtaqueEspecial = ataque * 3;

    public Mago(String nome) {
        super(nome, 50, 20, 20);
    }

    @Override
    public void atacar(Personagem personagemAlvo) {
        personagemAlvo.tomarDano(ataque);
    }

    public void ataqueEspecial(Personagem personagemAlvo, Personagem personagem) {
        System.out.println("\nAtaque Especial Bola de Fogo\n");
        personagemAlvo.tomarDano(danoAtaqueEspecial);
        personagem.tomarDano(10);
    }
}
