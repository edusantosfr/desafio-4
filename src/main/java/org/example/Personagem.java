package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Personagem {
    protected String nome;
    protected Integer vida;
    protected Integer ataque;
    protected Integer defensa;
    protected boolean defending = false;

    private List<String> inventario = new ArrayList<>();

    public Personagem(String nome, Integer vida, Integer ataque, Integer defensa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public abstract void atacar(Personagem personagemAlvo);

    public void tomarDano(int ataque) {
        int finalDamage = defending ? ataque / 2 : ataque; // reduz dano se estiver defendendo
        vida -= finalDamage;
        if (vida < 0) vida = 0;
        defending = false; // defesa só vale para 1 turno
    }

    public void defender() {
        System.out.println(nome + " está se defendendo!");
        defending = true;
    }

    public void usarPocao() {
        vida += 20;
    }

    public boolean estaVivo(){
        return vida > 0;
    }

    public void exibirStatus() {
        System.out.println(nome + " ainda tem " + vida + " pontos de vida.");
    }

    public String getName() {
        return nome;
    }

}
