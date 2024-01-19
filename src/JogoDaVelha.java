public class JogoDaVelha {

    String jogoVelha[][] = new String[3][3];
    String player;

    // Contrutor onde inicia o jogo com todas as casas vasinhas
    JogoDaVelha() {
        for (int n = 0; n < 3; n++) {
            for (int i = 0; i < 3; i++) {
                this.jogoVelha[n][i] = " ";
            }
        }
    }

    // Um metodo para imprimir o Andamento do jogo
    void mostrarAndamento() {
        System.out.println("Coluna:   1    2    3");
        System.out.printf("Linha: 1   %s |  %s  | %s\n", this.jogoVelha[0][0], this.jogoVelha[0][1], this.jogoVelha[0][2]);
        System.out.printf("       2   %s |  %s  | %s\n", this.jogoVelha[1][0], this.jogoVelha[1][1], this.jogoVelha[1][2]);
        System.out.printf("       3   %s |  %s  | %s", this.jogoVelha[2][0], this.jogoVelha[2][1], this.jogoVelha[2][2]);
    }

    // Método onde verifica a linha e a coluna são validas e realiza o jogo ou retorna mensagem de escolha invalida
    void verificarEscolha(String linha, String coluna) {
        // Verifico se a linha e a coluca escolhida pelo jogador são validos
        if (coluna.equals("1") || coluna.equals("2") || coluna.equals("3")) {
            if (linha.equals("1") || linha.equals("2") || linha.equals("3")) {
                // Marco a escolha do player na casa escolhida
                this.jogoVelha[(Integer.parseInt(linha) - 1)][(Integer.parseInt(coluna) - 1)] = player;
            } else {
                // Retono uma mensagem dizendo que a linha escolhida não existe
                System.out.printf("A linha %s não existe\n", linha);
            }
        } else {
            // Retono uma mensagem dizendo que a coluna escolhida não existe
            System.out.printf("A coluna %s não existe.\n", coluna);
        }
    }

    String verificadorVencedor() {

        int pontoX = 0;
        String campeao = " ";

        for (int l = 0; l < 3; l++) {
            pontoX = 0;
            for (int c = 0; c < 2; c++) {
                if (this.jogoVelha[l][c].equals(this.jogoVelha[l][c+1]) && (this.jogoVelha[l][c].equals(" ") != true)) {
                    pontoX += 1;
                }
            }
            if (pontoX == 2) {
                campeao = this.jogoVelha[l][2];
                break;
            }
        }

        if (pontoX != 2) {
            for (int c = 0; c < 3; c++) {
                pontoX = 0;
                for (int l = 0; l < 2; l++) {
                    if (this.jogoVelha[l][c].equals(this.jogoVelha[l+1][c]) && (this.jogoVelha[l][c].equals(" ") != true)) {
                        pontoX += 1;
                    }
                }
                if (pontoX == 2) {
                    campeao = this.jogoVelha[2][c];
                    break;
                }
            }
        }

        if (pontoX != 2) {
            if (this.jogoVelha[1][1].equals(this.jogoVelha[0][0]) && this.jogoVelha[1][1].equals(this.jogoVelha[2][2]) ||
                    this.jogoVelha[1][1].equals(this.jogoVelha[0][2]) && this.jogoVelha[1][1].equals(this.jogoVelha[2][0])) {

                campeao = this.jogoVelha[1][1];

            }
        }
        return campeao;
    }

    void mensagemVencedor () {
        System.out.printf("\n\nParabéns Player %S você foi o CAMPEÃO desse jogo!!!!\n\n", this.verificadorVencedor());
        mostrarAndamento();
    }

}
