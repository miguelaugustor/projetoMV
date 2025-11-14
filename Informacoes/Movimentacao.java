import java.time.LocalDate;

public class Movimentacao {
    private int id;
    private LocalDate data;
    private double valor;
    private String tipo;
    private Conta conta;

    public Movimentacao(int id, LocalDate data, double valor, String tipo, Conta conta) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.conta = conta;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public Conta getConta() {
        return conta;
    }

    public void exibirMovimentacao() {
        System.out.println("---------------------------");
        System.out.println("ID: " + id);
        System.out.println("Data: " + data);
        System.out.println("Tipo: " + (tipo.equals("C") ? "Crédito" : "Débito"));
        System.out.println("Valor: R$ " + valor);
        System.out.println("Conta: " + conta.getNumeroConta());
        System.out.println("---------------------------");
    }
}
