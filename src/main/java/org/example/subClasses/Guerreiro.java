package org.example.subClasses;

import org.example.Personagem;

public class Guerreiro extends Personagem {

    public Guerreiro(String nome) {
        super(nome, 120, 30, 40);
    }

    @Override
    public void atacar(Personagem personagemAlvo) {
        personagemAlvo.tomarDano(ataque);
    }
}
