import java.time.LocalDate;
import java.util.Scanner;

public class Credito {
    private double saldo;
    private String moeda;
    private LocalDate validade;
    private boolean bloqueado;

    public Credito() {
        this.saldo = 0.0;
        this.moeda = "BRL";
        this.validade = LocalDate.now().plusDays(30);
        this.bloqueado = false;
    }

    public Credito(double saldo, String moeda, LocalDate validade, boolean bloqueado) {
        this.saldo = saldo;
        this.moeda = moeda;
        this.validade = validade;
        this.bloqueado = bloqueado;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean estaDisponivel() {
        return !bloqueado && validade.isAfter(LocalDate.now()) && saldo > 0;
    }

    public void adicionar(double valor) {
        if (!bloqueado && validade.isAfter(LocalDate.now()) && valor > 0) {
            this.saldo += valor;
        }
    }

    public boolean retirar(double valor) {
        if (!bloqueado && validade.isAfter(LocalDate.now()) && valor > 0 && saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public static Credito criarCredito() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor inicial do saldo: ");
        double saldo = scanner.nextDouble();

        System.out.print("Digite a moeda (ex: BRL): ");
        String moeda = scanner.next();

        System.out.print("Digite a quantidade de dias para validade: ");
        int dias = scanner.nextInt();
        LocalDate validade = LocalDate.now().plusDays(dias);

        System.out.print("A conta está bloqueada? (S/N): ");
        char bloqueadoChar = scanner.next().toUpperCase().charAt(0);
        boolean bloqueado = (bloqueadoChar == 'S');

        return new Credito(saldo, moeda, validade, bloqueado);
    }

    public static Credito exibirInfo() {
        Credito credito = Credito.criarCredito();

        System.out.println("\n=== Informações do Crédito ===");
        System.out.println("Saldo: " + credito.getSaldo());
        System.out.println("Moeda: " + credito.moeda);
        System.out.println("Validade: " + credito.validade);
        System.out.println("Bloqueado: " + credito.bloqueado);
        return credito;
    }
}
