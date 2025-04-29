import java.time.LocalDateTime;

// Classe que representa uma Aposta no Sistema BET.
// Cada aposta está associada a um jogador, um jogo e possui um valor.
public class Aposta {

    private static int proximoId = 1;  // Usado para gerar ID único automaticamente

    private final int idAposta;
    private final Jogador jogador;           // Jogador que fez a aposta
    private final Jogo jogo;                 // Jogo no qual a aposta foi feita
    private final double valorApostado;      // Valor em créditos apostado
    private final LocalDateTime dataHora;    // Data e hora em que a aposta foi feita
    private StatusAposta status;             // Estado da aposta (pendente, ganha, perdida)

    // Enum interno que define os estados possíveis de uma Aposta
    public enum StatusAposta {
        PENDENTE,
        GANHA,
        PERDIDA
    }

    public Aposta(Jogador jogador, Jogo jogo, double valorApostado) {
        this.idAposta = proximoId++;
        this.jogador = jogador;
        this.jogo = jogo;
        this.valorApostado = valorApostado;
        this.dataHora = LocalDateTime.now();
        this.status = StatusAposta.PENDENTE;

        // Registra a aposta no jogador automaticamente
        jogador.adicionarAposta(this);
    }

    // Getters
    public int getIdAposta() {
        return idAposta;
    }

    public double getValorApostado() {
        return valorApostado;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public StatusAposta getStatus() {
        return status;
    }

    // Setter para atualizar o status da aposta
    public void setStatus(StatusAposta status) {
        this.status = status;
    }

    public void finalizarAposta(boolean venceu) {
        if (status == StatusAposta.PENDENTE) {
            // Atualiza o status com base no resultado da aposta
            if (venceu) {
                this.status = StatusAposta.GANHA;
            } else {
                this.status = StatusAposta.PERDIDA;
            }
        } else {
            System.out.println("Aposta já foi finalizada.");
        }
    }

    public String toString() {
        return "Aposta #" + idAposta +
                " | Jogador: " + jogador.getApelido() +
                " | Jogo: " + jogo.getDescricao() +
                " | Valor: R$" + valorApostado +
                " | Status: " + status +
                " | Data: " + dataHora;
    }

}