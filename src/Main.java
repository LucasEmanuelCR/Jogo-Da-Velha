
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Instancio um objeto do tipo Scanner para receber entradas do usuário pelo terminal
        Scanner entry = new Scanner(System.in);

        JogoDaVelha novoJogo = new JogoDaVelha();

        boolean b = true;

        novoJogo.player = "X";
        do{

            novoJogo.mostrarAndamento();

            System.out.printf("\n\nVez do jogador %s", novoJogo.player);
            System.out.printf("\nColuna: ");
            String coluna = entry.next();
            System.out.printf("\nLinha: ");
            String linha = entry.next();

            novoJogo.verificarEscolha(linha, coluna);

            if (novoJogo.player.equals("X")) {
                novoJogo.player = "O";
            }else{
                novoJogo.player = "X";
            }

        }while(novoJogo.verificadorVencedor().equals(" "));

        novoJogo.mensagemVencedor();

        // Finalizo o Scanner para liberar recursos de memória
        entry.close();
    }
}