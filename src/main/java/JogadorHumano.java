import java.util.Scanner;

class JogadorHumano extends Jogador
{
    private Scanner scanner;

    public JogadorHumano(char simbolo)
    {
        super(simbolo);
        this.scanner = new Scanner(System.in);
    }

    public int[] obterJogada(Tabuleiro tabuleiro)
    {
        int linha = lerNumero("Linha (0-2): ", 0, 2);
        int coluna = lerNumero("Coluna (0-2): ", 0, 2);
        return new int[]{linha, coluna};
    }

    private int lerNumero(String msg, int min, int max)
    {
        int valor = -1;
        while (valor < min || valor > max) {
            System.out.print(msg);
            valor = scanner.nextInt();
            if (valor < min || valor > max)
                System.out.println("Valor inválido, use entre " + min + " e " + max + ".");
            System.out.println();
        }
        scanner.nextLine();
        return valor;
    }
}