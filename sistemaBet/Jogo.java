/**
 * Classe que representa um Jogo no Sistema BET.
 * Cada jogo possui um ID, descrição, limites de aposta, status e resultado.
 */
public class Jogo {

    private final int idJogo;              // Identificador único do jogo
    private String descricao;              // Descrição do jogo (ex: "Flamengo vs Vasco")
    private double apostaMin;              // Valor mínimo permitido para apostas
    private double apostaMax;              // Valor máximo permitido para apostas
    private double premio;                 // Valor do prêmio que será distribuído
    private boolean finalizado;            // Indica se o jogo já foi finalizado
    private String resultado;              // Resultado final do jogo (ex: "2x1")

    public Jogo(int idJogo, String descricao, double apostaMin, double apostaMax, double premio) {
        this.idJogo = idJogo;
        this.descricao = descricao;
        this.apostaMin = apostaMin;
        this.apostaMax = apostaMax;
        this.premio = premio;
        this.finalizado = false;
        this.resultado = "Pendente";
    }

    // Getters
    public int getIdJogo() {
        return idJogo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getApostaMin() {
        return apostaMin;
    }

    public double getApostaMax() {
        return apostaMax;
    }

    public double getPremio() {
        return premio;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public String getResultado() {
        return resultado;
    }

    // Setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setApostaMin(double apostaMin) {
        this.apostaMin = apostaMin;
    }

    public void setApostaMax(double apostaMax) {
        this.apostaMax = apostaMax;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public void finalizarJogo(String resultado) {
        this.resultado = resultado;
        this.finalizado = true;
    }

    @Override
    public String toString() {
        return "Jogo #" + idJogo +
                " - " + descricao +
                " | Min: R$" + apostaMin +
                " | Max: R$" + apostaMax +
                " | Prêmio: R$" + premio +
                " | Resultado: " + resultado +
                (finalizado ? " (Finalizado)" : " (Aberto)");
    }
}
