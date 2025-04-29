package org.example.subClassesInimigas;

import org.example.Personagem;

public class Lacaio extends Personagem {
    public Lacaio(String nome) {
        super(nome, 120, 10, 5);
    }

    @Override
    public void atacar(Personagem personagemAlvo) {
        personagemAlvo.tomarDano(ataque);
    }
}
