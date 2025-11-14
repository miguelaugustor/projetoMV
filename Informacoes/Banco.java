import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes;
    private ArrayList<Conta> contas;

    public Banco() {
        clientes = new ArrayList<>();
        contas = new ArrayList<>();
    }

    public void adicionarCliente(Cliente c) {
        clientes.add(c);
    }

    public Cliente buscarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    public boolean removerCliente(int id) {
        Cliente c = buscarCliente(id);
        if (c != null) {
            clientes.remove(c);
            return true;
        }
        return false;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }
        System.out.println("\n=== Lista de Clientes ===");
        for (Cliente c : clientes) {
            System.out.println("-------------------------");
            System.out.println("ID: " + c.getId());
            System.out.println("Nome: " + c.getNome());
            System.out.println("CPF: " + c.getCpf());
            System.out.println("CNPJ: " + c.getCnpj());
            System.out.println("Tipo: " + c.getTipo());
            System.out.println("Telefone: " + c.getTelefone());
            Endereco e = c.getEndereco();
            System.out.println("Endereço: " + e.getRua() + ", " + e.getNumero() + ", " + e.getComplemento());
            System.out.println(e.getBairro() + ", " + e.getCidade() + " - " + e.getUf() + ", CEP: " + e.getCep());
        }
        System.out.println("-------------------------");
    }

    public void adicionarConta(Conta c) {
        contas.add(c);
    }

    public Conta buscarConta(int numero) {
        for (Conta c : contas) {
            if (c.getNumeroConta() == numero)
                return c;
        }
        return null;
    }

    public void removerConta(Conta c) {
        contas.remove(c);
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada!");
            return;
        }
        System.out.println("\n=== Lista de Contas ===");
        for (Conta c : contas) {
            System.out.println("-------------------------");
            System.out.println("Número da conta: " + c.getNumeroConta());
            System.out.println("Titular: " + c.getTitular().getNome());
            System.out.printf("Saldo: R$ %.2f\n", c.getSaldo());
        }
        System.out.println("-------------------------");
    }
}
