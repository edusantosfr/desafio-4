package org.example.subClassesInimigas;

import org.example.Personagem;

public class ReiKree extends Personagem {
    public ReiKree(String nome) {
        super(nome, 340, 20, 25);
    }

    @Override
    public void atacar(Personagem personagemAlvo) {
        personagemAlvo.tomarDano(ataque);
    }
}
