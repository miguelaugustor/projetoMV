import java.util.ArrayList;
import java.time.LocalDate;

public class Conta {

    private int numeroConta;
    private Cliente titular;
    private double saldo;
    private ArrayList<Movimentacao> movimentacoes;
    private static int contadorMov = 1;

    public Conta(int numeroConta, Cliente titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
        this.movimentacoes = new ArrayList<>();
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumero(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            movimentacoes.add(new Movimentacao(contadorMov++, LocalDate.now(), valor, "C", this));
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            movimentacoes.add(new Movimentacao(contadorMov++, LocalDate.now(), valor, "D", this));
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido!");
        }
    }

    public void exibirExtrato() {
        System.out.println("\n=== Extrato da Conta " + numeroConta + " ===");
        if (movimentacoes.isEmpty()) {
            System.out.println("Nenhuma movimentação realizada.");
        } else {
            for (Movimentacao m : movimentacoes) {
                m.exibirMovimentacao();
            }
        }
        System.out.println("Saldo atual: R$ " + saldo);
    }
}
