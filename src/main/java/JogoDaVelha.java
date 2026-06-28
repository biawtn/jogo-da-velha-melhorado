import java.util.Scanner;

class JogoDaVelha
{
    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;

    public JogoDaVelha(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro)
    {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = tabuleiro;
    }

    public void iniciar()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual é o seu nome? ");
        String nomeJogador = scanner.nextLine();
        System.out.println();

        char marcaEscolhida = pedirSimbolo(scanner);
        char marcaBot = (marcaEscolhida == 'X') ? 'O' : 'X';

        jogador1 = new JogadorHumano(marcaEscolhida);
        jogador2 = new JogadorVirtual(marcaBot);

        String ultimoAJogar = "";
        int rodada = 1;

        while (!tabuleiro.acabouOJogo()) {
            System.out.println("=== Rodada " + rodada + " ===\n");

            int[] jogada;
            do {
                jogada = jogador1.obterJogada(tabuleiro);
            } while (!tabuleiro.jogar(jogador1, jogada[0], jogada[1], nomeJogador, true));
            ultimoAJogar = nomeJogador;
            System.out.println();

            if (tabuleiro.acabouOJogo()) break;

            int[] jogadaBot;
            do {
                jogadaBot = jogador2.obterJogada(tabuleiro);
            } while (!tabuleiro.jogar(jogador2, jogadaBot[0], jogadaBot[1], "Bot", false));
            ultimoAJogar = "Bot";

            rodada++;
        }

        if (tabuleiro.haUmVencedor()) {
            System.out.println(ultimoAJogar + " venceu o jogo!");
        } else {
            System.out.println("Empate! Ninguém venceu.");
        }
    }

    private char pedirSimbolo(Scanner scanner)
    {
        char escolha = ' ';
        while (escolha != 'X' && escolha != 'O') {
            System.out.print("Escolha seu símbolo ('X' ou 'O'): ");
            String entrada = scanner.nextLine().toUpperCase();
            if (!entrada.isEmpty()) escolha = entrada.charAt(0);
            if (escolha != 'X' && escolha != 'O')
                System.out.println("Símbolo inválido, tente novamente.");
            System.out.println();
        }
        return escolha;
    }

    public static void main(String[] args)
    {
        Jogador j1 = new JogadorHumano('X');
        Jogador j2 = new JogadorVirtual('O');
        Tabuleiro tab = new Tabuleiro();
        new JogoDaVelha(j1, j2, tab).iniciar();
    }
}