import java.util.ArrayList;    // Cria listas dinâmicas que crescem conforme adicionamos elementos.
import java.util.Iterator;     // Permite percorrer e remover elementos de uma lista com segurança.
import java.util.List;         // É uma interface que representa listas — usada para generalizar.
import java.util.Scanner;

// * Classe que representa um Jogador no Sistema BET.
// * Cada jogador possui informações pessoais, créditos e apostas realizadas.

public class Jogador {

    // Atributos privados
    private final int idJogador;           // Identificador único (imutável)
    private final String cpf;              // CPF do jogador (imutável)
    private String nome;
    private String sobrenome;
    private String apelido;
    private String nacionalidade;
    private final Credito credito;               // Créditos disponíveis para apostas
    private final List<Aposta> aposta;          // Histórico de apostas do jogador

    // Lista estática para controle de jogadores (gerenciador simples)
    // lista com o repositório interno de todos os jogadores cadastrados no sistema
    private static final List<Jogador> listaJogadores = new ArrayList<>();

    // Construtor da classe Jogador.
    public Jogador(int idJogador, String cpf, String nome, String sobrenome, String apelido, String nacionalidade) {
        this.idJogador = idJogador;
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.apelido = apelido;
        this.nacionalidade = nacionalidade;
        this.credito = new Credito();  // Inicializa a classe Creditos para controlar os créditos
        this.aposta = new ArrayList<>();
        listaJogadores.add(this);  // Adiciona automaticamente o jogador à lista global

    }

    public static Jogador criarJogador() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do jogador: ");
        int idJogador = scanner.nextInt();
        scanner.nextLine(); // Para capturar o \n após o nextInt

        System.out.print("Digite o CPF do jogador: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o nome do jogador: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o sobrenome do jogador: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Digite o apelido do jogador: ");
        String apelido = scanner.nextLine();

        System.out.print("Digite a nacionalidade do jogador: ");
        String nacionalidade = scanner.nextLine();

        // Cria e retorna o novo jogador com os dados informados
        return new Jogador(idJogador, cpf, nome, sobrenome, apelido, nacionalidade);
    }

    // Getters
    public int getIdJogador() {
        return idJogador;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getApelido() {
        return apelido;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public Credito getCredito() {
        return credito;
    }

    public List<Aposta> getApostas() {
        return aposta;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    // * Métodos de aposta
    public boolean adicionarAposta(Aposta aposta) {
        if (aposta != null && aposta.getValorApostado() <= this.credito.getSaldo()) {
            this.aposta.add(aposta);
            this.retirarCreditos(aposta.getValorApostado());
            return true;
        }
        return false;
    }

    public void retirarCreditos(double valor) {
        this.credito.retirar(valor);
    }

    // * Métodos de gerenciamento de jogadores
    // Adiciona um jogador à lista geral.
    public static void adicionarJogador(Jogador jogador) {
        if (jogador != null) {
            listaJogadores.add(jogador);
        }
    }

    //Remove um jogador pelo CPF.
    public static boolean removerJogadorPorCpf(String cpf) {
        Iterator<Jogador> iterator = listaJogadores.iterator();
        while (iterator.hasNext()) {
            Jogador jogador = iterator.next();
            if (jogador.getCpf().equals(cpf)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    //* Lista todos os jogadores registrados.
    public static List<Jogador> getListaJogadores() {
        return listaJogadores;
    }

    public String toString() {
        return "Jogador #" + idJogador + " | " + apelido + " (" + nome + " " + sobrenome + ") - CPF: " + cpf;
    }


}
