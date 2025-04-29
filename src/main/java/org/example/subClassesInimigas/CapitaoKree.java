package org.example.subClassesInimigas;

import org.example.Personagem;

public class CapitaoKree extends Personagem {
    public CapitaoKree(String nome) {
        super(nome, 200, 15, 10);
    }

    @Override
    public void atacar(Personagem personagemAlvo) {
        personagemAlvo.tomarDano(ataque);
    }
}
