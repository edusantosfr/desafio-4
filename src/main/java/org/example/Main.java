package org.example;

import org.example.subClasses.Arqueiro;
import org.example.subClasses.Guerreiro;
import org.example.subClasses.Mago;
import org.example.subClassesInimigas.CapitaoKree;
import org.example.subClassesInimigas.Lacaio;
import org.example.subClassesInimigas.ReiKree;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static Random random = new Random();

    public static Integer contagemDoAtaqueEspecial;
    public static Integer classe;
    public static Boolean ganhou = false;

    public static void main(String[] args) {
        menuInicial();
    }

    public static void menuInicial() {
        System.out.println("\nOlá, bem vindo ao mundo de Elarion caro Jogador!!\n");
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
        scanner.nextLine();
        System.out.print("\nDigite aqui o nome do seu personagem: ");
        String nomeDoPersonagem = scanner.nextLine();

        //escolha da Classe do Jogador
        classe = escolhaDeClasse();
        Personagem personagem = null;

        int quantidadeDeRounds = 3;
        partidas:
        for (int i = 0; i < quantidadeDeRounds; i++) {
            switch (classe) {
                case 1 -> personagem = new Guerreiro(nomeDoPersonagem);
                case 2 -> personagem = new Arqueiro(nomeDoPersonagem);
                case 3 -> personagem = new Mago(nomeDoPersonagem);
            }

            //escolha da Classe do Inimigo
            int classeInimigo = i + 1;
            Personagem personagemInimigo = null;
            switch (classeInimigo) {
                case 1 -> personagemInimigo = new Lacaio("Lacaio Kree");
                case 2 -> personagemInimigo = new CapitaoKree("Capitão dos Kree");
                case 3 -> personagemInimigo = new ReiKree("Rei dos Kree");
            }

            System.out.println("\nInício da Batalha!");
            boolean turnoPersonagem = true;

            //caixas de texto do jogo
            caixasTextoJogo(i + 1);

            //adiciona as 3 poções inicias de cada partida
            assert personagem != null;
            personagem.adicionarPocao();

            //permite 1 ataque especial ao começo da partida
            contagemDoAtaqueEspecial = 0;

            while (personagem.estaVivo()) {
                if (!personagemInimigo.estaVivo()) break;
                try {
                    personagem.exibirStatus();
                    personagemInimigo.exibirStatus();

                    Personagem atual = turnoPersonagem ? personagem : personagemInimigo;
                    Personagem oponente = turnoPersonagem ? personagemInimigo : personagem;

                    //escolha da ação
                    int option = 0;
                    if (atual == personagemInimigo) {
                        System.out.println();
                        option = iaDeTurnoInimigo();
                    } else {
                        boolean condition = true;
                        while (condition || option < 1 || option > 4) {
                            option = turnoPersonagem(atual.getName(), !personagem.inventario.isEmpty());
                            if (personagem.inventario.isEmpty() && option == 3) {
                                System.out.println("\nSeu inventário está vazio");
                            } else if (contagemDoAtaqueEspecial != 0 && option == 4){
                                System.out.println("\nVocê já usou seu ataque especial nesta partida");
                            } else {
                                condition = false;
                            }
                        }
                    }

                    //execução da ação
                    switch (option) {
                        case 1 -> {
                            System.out.println("\nO " + atual.getName() + " ataca diretamente!\n");
                            atual.atacar(oponente);
                        }
                        case 2 -> atual.defender();
                        case 3 -> {
                            if (!personagem.inventario.isEmpty()){
                                atual.usarPocao();
                            }
                        }
                        case 4 -> {
                            if (contagemDoAtaqueEspecial == 0){
                                if (atual instanceof Guerreiro) {
                                    ((Guerreiro) atual).ataqueEspecial(oponente);
                                } else if (atual instanceof Arqueiro) {
                                    ((Arqueiro) atual).ataqueEspecial(oponente);
                                } else if (atual instanceof Mago) {
                                    ((Mago) atual).ataqueEspecial(oponente, atual);
                                }
                                contagemDoAtaqueEspecial++;
                            }
                        }
                    }

                    //troca de turno
                    turnoPersonagem = !turnoPersonagem;
                } catch (InputMismatchException e) {
                    System.out.println("\nEntrada Inválida, Tente novamente.\n");
                    scanner.nextLine();
                }
                if (!personagem.estaVivo()) {
                    break partidas;
                }
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
                System.out.println("Vida - 50 pts / Ataque - 80 pts / Defesa - 20 pts");
                System.out.print("\nDigite aqui sua Opção: ");
                int option = scanner.nextInt();
                scanner.nextLine();

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

    public static Integer turnoPersonagem(String name, boolean isInvetarioEmpty) {
        int option;
        System.out.println("\nTurno de " + name + ":");
        System.out.println("O que pretende fazer em seu turno?");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        if (isInvetarioEmpty){
            System.out.println("3. Usar Poção");
        }
        if (contagemDoAtaqueEspecial == 0){
            System.out.println("4. Ataque Especial (1 por partida)");
        }
        System.out.print("Digite aqui sua Opção: ");
        option = scanner.nextInt();

        return option;
    }

    public static void caixasTextoJogo(Integer round) {
        switch (round) {
            case 1 -> {
                System.out.println("\nO primeiro Round está começando...");
                System.out.println("O primeiro que irá infrentar será o Lacaio Kree\n");
            }
            case 2 -> {
                System.out.println("\nOlha só, você sobreviveu ao primeiro round...");
                System.out.println("Quem você enfrentará agora é o Capitão do exército Kree. Boa sorte.");
                System.out.println("Poucos passam dessa parte.\n");
            }
            case 3 -> {
                System.out.println("\nBoa demais, caramba, não esperava tanto de alguém tão... Ah, você sabe.");
                System.out.println("O último inimigo a ser enfrentado é o Rei do raça Kree, ninguém nunca chegou tão longe. Boa sorte.");
                System.out.println("Você vai precisar...\n");
            }
        }
    }

    public static Integer iaDeTurnoInimigo() {
        int escolha = random.nextInt(1, 100);
        int option;

        if (escolha < 30) {
            option = 2;
        } else {
            option = 1;
        }

        return option;
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

        System.out.println("\n----Inimigos----");
        System.out.println("Lacaio Kree");
        System.out.println("Atributos");
        System.out.println("Vida - 120 pontos / Ataque - 10 pontos / Defesa - 5 pontos");

        System.out.println("\nCapitão dos Kree");
        System.out.println("Atributos");
        System.out.println("Vida - 200 pontos / Ataque - 15 pontos / Defesa - 10 pontos");

        System.out.println("\nRei dos Kree");
        System.out.println("Atributos");
        System.out.println("Vida - 340 pontos / Ataque - 20 pontos / Defesa - 25 pontos");

        System.out.println("\n----Itens----");
        System.out.println("Poção de Cura");
        System.out.println("Restaura 20 pontos de Vida (Máximo de 3 por Partida)\n");
    }
}