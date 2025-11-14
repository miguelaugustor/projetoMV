import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();

        int opcaoUsuario = 0;

        while (opcaoUsuario != 12) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Conta");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Listar Contas");
            System.out.println("6 - Listar Clientes");
            System.out.println("7 - Atualizar Conta");
            System.out.println("8 - Excluir Conta");
            System.out.println("9 - Atualizar Cliente");
            System.out.println("10 - Excluir Cliente");
            System.out.println("11 - Extrato");
            System.out.println("12 - Sair");

            System.out.print("Escolha uma opção: ");
            opcaoUsuario = sc.nextInt();
            sc.nextLine();

            switch (opcaoUsuario) {

                case 1:
                    System.out.println("=== Cadastro de Cliente ===");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF (se PF): ");
                    String cpf = sc.nextLine();

                    System.out.print("CNPJ (se PJ): ");
                    String cnpj = sc.nextLine();

                    System.out.print("Tipo (PF ou PJ): ");
                    String tipo = sc.nextLine().toUpperCase();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Rua: ");
                    String rua = sc.nextLine();
                    System.out.print("Número: ");
                    String numero = sc.nextLine();
                    System.out.print("Complemento: ");
                    String complemento = sc.nextLine();
                    System.out.print("Bairro: ");
                    String bairro = sc.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = sc.nextLine();
                    System.out.print("UF: ");
                    String uf = sc.nextLine();
                    System.out.print("CEP: ");
                    String cep = sc.nextLine();

                    Endereco endereco = new Endereco(rua, numero, complemento, bairro, cidade, uf, cep);
                    Cliente novoCliente = new Cliente(nome, cpf, cnpj, tipo, telefone, endereco);
                    banco.adicionarCliente(novoCliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("=== Criar Conta ===");
                    System.out.print("Digite o ID do cliente: ");
                    int idClienteConta = sc.nextInt();
                    sc.nextLine();

                    Cliente clienteEncontrado = banco.buscarCliente(idClienteConta);
                    if (clienteEncontrado == null) {
                        System.out.println("Cliente não encontrado!");
                        break;
                    }

                    System.out.print("Digite o número da conta: ");
                    int numeroConta = sc.nextInt();
                    sc.nextLine();

                    Conta novaConta = new Conta(numeroConta, clienteEncontrado);
                    banco.adicionarConta(novaConta);
                    System.out.println("Conta criada com sucesso para: " + clienteEncontrado.getNome());
                    break;

                case 3:
                    System.out.println("\n=== Depósito ===");
                    System.out.print("Digite o número da conta: ");
                    int numeroContaDeposito = sc.nextInt();
                    sc.nextLine();

                    Conta contaDeposito = banco.buscarConta(numeroContaDeposito);
                    if (contaDeposito == null) {
                        System.out.println("Conta não encontrada!");
                        break;
                    }

                    System.out.print("Digite o valor para depósito: ");
                    double valorDeposito = sc.nextDouble();
                    sc.nextLine();

                    contaDeposito.depositar(valorDeposito);
                    break;

                case 4:
                    System.out.println("\n=== Saque ===");
                    System.out.print("Digite o número da conta: ");
                    int numeroContaSaque = sc.nextInt();
                    sc.nextLine();

                    Conta contaSaque = banco.buscarConta(numeroContaSaque);
                    if (contaSaque == null) {
                        System.out.println("Conta não encontrada!");
                        break;
                    }

                    System.out.print("Digite o valor para saque: ");
                    double valorSaque = sc.nextDouble();
                    sc.nextLine();

                    contaSaque.sacar(valorSaque);
                    break;

                case 5:
                    System.out.println("\n=== Lista de Contas ===");
                    banco.listarContas();
                    break;

                case 6:
                    System.out.println("\n=== Lista de Clientes ===");
                    banco.listarClientes();
                    break;

                case 7:
                    System.out.print("Digite o número da conta: ");
                    int numContaUpdate = sc.nextInt();
                    sc.nextLine();

                    Conta contaUpdate = banco.buscarConta(numContaUpdate);
                    if (contaUpdate == null) {
                        System.out.println("Conta não encontrada!");
                        break;
                    }

                    System.out.println("O que deseja alterar?");
                    System.out.println("1 - Número da conta");
                    System.out.println("2 - Trocar titular");
                    int opcUpdate = sc.nextInt();
                    sc.nextLine();

                    if (opcUpdate == 1) {
                        System.out.print("Novo número da conta: ");
                        int novoNumero = sc.nextInt();
                        sc.nextLine();
                        contaUpdate.setNumero(novoNumero);
                        System.out.println("Número atualizado!");
                    } else if (opcUpdate == 2) {
                        System.out.print("Digite o ID do novo titular: ");
                        int idNovoTitular = sc.nextInt();
                        sc.nextLine();
                        Cliente novoTitular = banco.buscarCliente(idNovoTitular);
                        if (novoTitular != null) {
                            contaUpdate.setTitular(novoTitular);
                            System.out.println("Titular atualizado!");
                        } else {
                            System.out.println("Cliente não encontrado!");
                        }
                    }
                    break;

                case 8:
                    System.out.print("Digite o número da conta: ");
                    int numeroContaExcluir = sc.nextInt();
                    sc.nextLine();

                    Conta contaExcluir = banco.buscarConta(numeroContaExcluir);
                    if (contaExcluir != null) {
                        banco.removerConta(contaExcluir);
                        System.out.println("Conta removida com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 9:
                    System.out.print("Digite o ID do cliente: ");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();

                    Cliente clienteUpdate = banco.buscarCliente(idUpdate);
                    if (clienteUpdate == null) {
                        System.out.println("Cliente não encontrado!");
                        break;
                    }

                    System.out.println("O que deseja alterar?");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Telefone");
                    System.out.println("3 - Endereço completo");
                    int opcCliente = sc.nextInt();
                    sc.nextLine();

                    switch (opcCliente) {
                        case 1:
                            System.out.print("Novo nome: ");
                            String novoNome = sc.nextLine();
                            clienteUpdate.setNome(novoNome);
                            System.out.println("Nome atualizado!");
                            break;
                        case 2:
                            System.out.print("Novo telefone: ");
                            String novoTelefone = sc.nextLine();
                            clienteUpdate.setTelefone(novoTelefone);
                            System.out.println("Telefone atualizado!");
                            break;
                        case 3:
                            System.out.print("Rua: ");
                            String ruaNova = sc.nextLine();
                            System.out.print("Número: ");
                            String numeroNovo = sc.nextLine();
                            System.out.print("Complemento: ");
                            String complementoNovo = sc.nextLine();
                            System.out.print("Bairro: ");
                            String bairroNovo = sc.nextLine();
                            System.out.print("Cidade: ");
                            String cidadeNova = sc.nextLine();
                            System.out.print("UF: ");
                            String ufNova = sc.nextLine();
                            System.out.print("CEP: ");
                            String cepNovo = sc.nextLine();

                            Endereco novoEndereco = new Endereco(ruaNova, numeroNovo, complementoNovo,
                                    bairroNovo, cidadeNova, ufNova, cepNovo);
                            clienteUpdate.setEndereco(novoEndereco);
                            System.out.println("Endereço atualizado!");
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;

                case 10:
                    System.out.print("Digite o ID do cliente: ");
                    int idExcluir = sc.nextInt();
                    sc.nextLine();

                    boolean removido = banco.removerCliente(idExcluir);
                    if (removido)
                        System.out.println("Cliente removido com sucesso!");
                    else
                        System.out.println("Cliente não encontrado!");
                    break;

                case 11:
                    System.out.print("Digite o número da conta: ");
                    int numContaExtrato = sc.nextInt();
                    sc.nextLine();

                    Conta contaExtrato = banco.buscarConta(numContaExtrato);
                    if (contaExtrato != null) {
                        contaExtrato.exibirExtrato();
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 12:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
