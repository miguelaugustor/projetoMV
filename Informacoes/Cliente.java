import java.time.LocalDate;

public class Cliente {
    private static int contador = 1;
    private int id;
    private String nome;
    private String cpf;
    private String cnpj;
    private String tipo;
    private String telefone;
    private LocalDate dataCadastro;
    private Endereco endereco;

    public Cliente(String nome, String cpf, String cnpj, String tipo, String telefone, Endereco endereco) {
        this.id = contador++;
        this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.tipo = tipo;
        this.telefone = telefone;
        this.dataCadastro = LocalDate.now();
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Cliente ID: " + id + " | Nome: " + nome +
                " | Tipo: " + tipo + " | Telefone: " + telefone +
                " | Endereço: " + endereco +
                " | Desde: " + dataCadastro;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public void setTelefone(String novoTelefone) {
        this.telefone = novoTelefone;
    }

    public void setEndereco(Endereco novoEndereco) {
        this.endereco = novoEndereco;
    }
}
