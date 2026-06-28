import java.util.Random;

class JogadorVirtual extends Jogador
{
    private Random rng;

    public JogadorVirtual(char simbolo)
    {
        super(simbolo);
        this.rng = new Random();
    }

    public int[] obterJogada(Tabuleiro tabuleiro)
    {
        int linha = rng.nextInt(3);
        int coluna = rng.nextInt(3);
        return new int[]{linha, coluna};
 }
}
