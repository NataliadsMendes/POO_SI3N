import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        // Solicitar dados do jogador
        String nome = InOut.leString("Digite o nome do jogador: ");
        String sobrenome = InOut.leString("Digite o sobrenome do jogador: ");
        String apelido = InOut.leString("Digite o apelido do jogador: ");
        String nacionalidade = InOut.leString("Digite a nacionalidade do jogador: ");
        int idJogador = InOut.leInt("Digite o ID do jogador: ");
        String cpf = InOut.leString("Digite o CPF do jogador: ");

        // Criando o jogador
        Jogador jogador = new Jogador(idJogador, cpf, nome, sobrenome, apelido, nacionalidade);

        // Exibir mensagem com informações do jogador
        InOut.MsgDeInformacao("Jogador Criado", "Jogador " + nome + " " + sobrenome + " foi criado com sucesso!");

        // Criar um jogo fictício
        Jogo jogoFicticio = new Jogo(1, "Pato vs Ganso", 10.0, 1000.0, 5000.0);

        // Apostas
        boolean continuar = true;
        while (continuar) {
            InOut.MsgSemIcone("Menu", "Escolha uma opção:");
            int opcao = InOut.leInt("1. Criar Aposta\n2. Ver Créditos\n3. Sair\nEscolha a opção: ");

            switch (opcao) {
                case 1:
                    // Criar uma aposta
                    double valorAposta = InOut.leDouble("Digite o valor da aposta: ");
                    Aposta aposta = new Aposta(jogador, jogoFicticio, valorAposta);
                    InOut.MsgDeInformacao("Aposta Criada", "Aposta de R$" + valorAposta + " realizada com sucesso!");
                    break;

                case 2:
                    // Exibir saldo de créditos do jogador
                    InOut.MsgDeInformacao("Créditos", "Saldo atual: R$" + jogador.getCredito().getSaldo());
                    break;

                case 3:
                    continuar = false;
                    InOut.MsgDeInformacao("Saindo", "Saindo do sistema...");
                    break;

                default:
                    InOut.MsgDeAviso("Opção Inválida", "Escolha uma opção válida.");
                    break;
            }
        }
    }
}
