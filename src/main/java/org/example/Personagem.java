package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Personagem {
    protected String nome;
    protected Integer vida;
    protected Integer ataque;
    protected Integer defensa;
    protected boolean defendendo = false;

    protected final List<String> inventario = new ArrayList<>();

    public Personagem(String nome, Integer vida, Integer ataque, Integer defensa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public abstract void atacar(Personagem personagemAlvo);

    public void tomarDano(int ataque) {
        int finalDamage = defendendo ? ataque / 2 : ataque;
        vida -= finalDamage;
        if (vida < 0) vida = 0;
        defendendo = false;
    }

    public void defender() {
        System.out.println("\n" + nome + " está se defendendo!\n");
        defendendo = true;
    }

    public void usarPocao() {
        if (!inventario.isEmpty()) {
            inventario.remove("Poção de Vida");
            vida += 20;
            System.out.println("\nVocê se curou em 20 pontos\n");
        }
    }

    public void adicionarPocao() {
        for (int i = 0; i < 3; i++){
            inventario.add("Poção de Vida");
        }
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
