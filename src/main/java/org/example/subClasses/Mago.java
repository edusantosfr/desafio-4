package org.example.subClasses;

import org.example.Personagem;

public class Mago extends Personagem {

    public Mago(String nome) {
        super(nome, 50, 80, 20);
    }

    @Override
    public void atacar(Personagem personagemAlvo) {
        personagemAlvo.tomarDano(ataque);
    }
}
