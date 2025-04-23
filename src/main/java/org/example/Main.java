package org.example;

import org.example.subClasses.Arqueiro;
import org.example.subClasses.Guerreiro;
import org.example.subClasses.Mago;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menuInicial();
    }

    public static void menuInicial() {
        System.out.println("Olá, bem vindo ao mundo de Elarion caro Jogador!!\n");
        boolean isJogando = true;

        while (isJogando) {
            try {
                System.out.println("----Menu de Opções----");
                System.out.println("1. Iniciar um Novo Jogo");
                System.out.println("2. Ler Regras de Jogo");
                System.out.println("0. Fechar do Jogo");
                System.out.print("Digite a sua Opção: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1 -> iniciarNovoJogo();
                    case 2 -> regrasDeJogo();
                    case 0 -> isJogando = false;
                    default -> System.out.println("\nDigite uma Opção Válida.\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nEntrada Inválida, Tente novamente.\n");
                scanner.nextLine();
            }
        }
    }

    public static void iniciarNovoJogo() {
        int classe = escolhaDeClasse();
        System.out.print("\nDigite aqui o nome do seu personagem: ");
        String nomeDoPersonagem = scanner.nextLine();

        switch (classe) {
            case 1 -> {
                Personagem personagem = new Guerreiro(nomeDoPersonagem);
            } case 2 -> {
                Personagem personagem = new Arqueiro(nomeDoPersonagem);
            } case 3 -> {
                Personagem personagem = new Mago(nomeDoPersonagem);
            }
        }
    }

    public static int escolhaDeClasse() {
        int classe = 0;
        boolean isEscolhendo = true;
        while (isEscolhendo) {
            try {
                System.out.println("\n----Menu de Classes----");
                System.out.println("1. Guerreiro");
                System.out.println("Vida - 120 pts / Ataque - 30 pts / Defesa - 40 pts");
                System.out.println("\n2. Arqueiro");
                System.out.println("Vida - 80 pts / Ataque - 50 pts / Defesa - 20 pts");
                System.out.println("\n3. Mago");
                System.out.println("50pts - Vida / 80pts Ataque / 20pts - Defesa");
                System.out.print("Digite aqui sua Opção:");
                int option = scanner.nextInt();

                switch (option) {
                    case 1 -> {
                        classe = 1;
                        isEscolhendo = false;
                    }
                    case 2 -> {
                        classe = 2;
                        isEscolhendo = false;
                    }
                    case 3 -> {
                        classe = 3;
                        isEscolhendo = false;
                    }
                    default -> System.out.println("\nDigite uma Opção Válida.\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nEntrada Inválida, Tente novamente.\n");
                scanner.nextLine();
            }
        }

        return classe;
    }

    public static void regrasDeJogo() {
        System.out.println("\n----Regras de Jogo----");
        System.out.println("O Jogador enfrenta inimigos aletórios em batalhas de turno");
        System.out.println("A cada turno, escolhe entre atacar, defender ou usar item");
        System.out.println("A partida só termina quando todos os inimigos forem derrotados ou o jogodor morrer");

        System.out.println("\n----Personagens----");
        System.out.println("Guerreiro");
        System.out.println("Fortaleza em carne e osso, o Guerreiro avança com bravura — suportando o impacto do inimigo enquanto revida com firmeza");
        System.out.println("Atributos");
        System.out.println("Vida - 120 pontos / Ataque - 30 pontos / Defesa - 40 pontos");

        System.out.println("\nArqueiro");
        System.out.println("Ágil e letal à distância, o Arqueiro troca armadura por precisão — cada flecha é um golpe certeiro rumo à vitória.");
        System.out.println("Atributos");
        System.out.println("Vida - 80 pontos / Ataque - 50 pontos / Defesa - 20 pontos");

        System.out.println("\nMago");
        System.out.println("Frágil no corpo, mas imbatível na mente — o Mago domina as forças arcanas para destruir antes mesmo de ser tocado.");
        System.out.println("Atributos");
        System.out.println("Vida - 50 pontos / Ataque - 80 pontos / Defesa - 20 pontos");

        System.out.println("\nItens");
        System.out.println("Poção de Cura");
        System.out.println("Restaura 20 pontos de Vida (Máximo de 3 por Partida)");
    }
}