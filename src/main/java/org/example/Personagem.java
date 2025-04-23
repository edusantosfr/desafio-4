package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Personagem {
    protected String nome;
    protected Integer vida;
    protected Integer ataque;
    protected Integer defensa;

    private List<String> inventario = new ArrayList<>();

    public Personagem(String nome, Integer vida, Integer ataque, Integer defensa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public abstract void atacar(Personagem personagemAlvo);

    public Integer defender(int ataque) {
        ataque -= defensa;
        if (ataque < 0) ataque = 0;

        return ataque;
    }

    public void tomarDano(int ataque) {
        vida -= ataque;
        if (vida < 0) vida = 0;
    }

    public boolean estaVivo(){
        return vida > 0;
    }
}
