package org.BancoBlueMoon;

import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bem-vindo ao Banco BlueMoon!");

        // Coleta de dados do cliente
        String nome = JOptionPane.showInputDialog("Digite seu nome: ");
        int idade = obterIdade();
        String cpf = obterCpf();
        String email = obterEmail();
        String cep = obterCep();
        String endereco = Endereco.buscarEndereco(cep);
        if (endereco == null) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o endereço. Operação cancelada.");
            return;
        }

        String numeroCasa = JOptionPane.showInputDialog("Digite o número da sua casa: ");
        if (numeroCasa == null || numeroCasa.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Número da casa não informado. Operação cancelada.");
            return;
        }

        // Criar o objeto Cliente
        Cliente cliente = new Cliente(nome, idade, cpf, email, cep, endereco, numeroCasa);

        // Exibir os dados do cliente
        String dadosCliente = "✅ Cadastro realizado com sucesso! ✅\n\n" +
                "\n -Nome: " + cliente.getNome() +
                "\n -Idade: " + cliente.getIdade() +
                "\n -CPF: " + cliente.getCpf() +
                "\n -E-mail: " + cliente.getEmail() +
                "\n -Endereço:" + cliente.getEndereco() +
                "\n - Número: " + numeroCasa;

        JOptionPane.showMessageDialog(null, dadosCliente, "Dados do Cliente", JOptionPane.INFORMATION_MESSAGE);

        // Criar a conta bancária
        ContaBancaria conta = new ContaBancaria();
        menuBanco(conta, cliente);
    }

    public static int obterIdade() {
        int idadeFinal = -1;
        while (idadeFinal < 0) {
            String idade = JOptionPane.showInputDialog("Digite sua idade: ");
            if (idade == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                System.exit(0);
            }
            try {
                idadeFinal = Integer.parseInt(idade);
                if (idadeFinal < 18) {
                    JOptionPane.showMessageDialog(null, "Você precisa ter 18 anos ou mais para acessar o Banco BlueMoon.");
                    idadeFinal = -1;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número válido para a idade.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return idadeFinal;
    }

    public static String obterCpf() {
        String cpf = "";
        while (true) {
            cpf = JOptionPane.showInputDialog("Digite seu CPF (11 dígitos):");
            if (cpf == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                System.exit(0);
            }
            cpf = cpf.trim();
            if (!cpf.matches("\\d{11}")) {
                JOptionPane.showMessageDialog(null, "Erro: O CPF deve conter somente 11 números.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        }
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public static String obterEmail() {
        String email = "";
        while (true) {
            email = JOptionPane.showInputDialog("Digite seu e-mail: ");
            if (email == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                System.exit(0);
            }
            if (!email.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b")) {
                JOptionPane.showMessageDialog(null, "Erro: O e-mail informado não é válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        }
        return email;
    }

    public static String obterCep() {
        String cep = "";
        while (true) {
            cep = JOptionPane.showInputDialog("Digite seu CEP (8 dígitos numéricos): ");
            if (cep == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                System.exit(0);
            }
            if (!cep.matches("\\d{8}")) {
                JOptionPane.showMessageDialog(null, "Erro: O CEP informado não é válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        }
        return cep;
    }

    public static void menuBanco(ContaBancaria conta, Cliente cliente) {
        while (true) {
            String[] opcoes = {"Comprar", "Depositar", "Consultar saldo", "Sacar", "Cartão de Credito", "Faturas", "Sair"};
            String escolha = (String) JOptionPane.showInputDialog(null, "Selecione uma opção:", "Banco BlueMoon",
                    JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == null || escolha.equals("Sair")) {
                JOptionPane.showMessageDialog(null, "Operação cancelada! Obrigado por usar o Banco BlueMoon!");
                break;
            }

            if (escolha.equals("Comprar")) {
                String objetoCompraStr = JOptionPane.showInputDialog("Qual sua compra?: ");
                double valorCompra = Double.parseDouble(JOptionPane.showInputDialog("Qual valor da compra?: "));
                int unidadeCompra = Integer.parseInt(JOptionPane.showInputDialog("Quantas unidades você irá comprar?: "));

                // Calcula o valor total da compra
                double valorCompraFinal = unidadeCompra * valorCompra;

                // Exibe a mensagem formatada corretamente
                JOptionPane.showMessageDialog(null, String.format(
                        "Compra de %d unidades de %s no valor de R$ %.2f realizada com sucesso!",
                        unidadeCompra, objetoCompraStr, valorCompraFinal));

                // Calcula o cashback
                double cashback = (valorCompraFinal > 3000) ? valorCompraFinal * 0.10 : 0.0;
                if (cashback > 0) {
                    JOptionPane.showMessageDialog(null, String.format(
                            "Parabéns! Você ganhou um cashback de R$ %.2f!", cashback));
                }

                // Adiciona o valor da compra à fatura do cartão de crédito
                conta.adicionarFatura(valorCompraFinal);

            } else if (escolha.equals("Cartão de Credito")) {
                // Exibe a fatura atual do cartão de crédito
                JOptionPane.showMessageDialog(null, String.format(
                        "A sua fatura atual é de: R$ %.2f", conta.getFaturaCartaoCredito()));

            } else if (escolha.equals("Depositar")) {
                double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a depositar:"));
                conta.depositar(valorDeposito);

            } else if (escolha.equals("Consultar saldo")) {
                JOptionPane.showMessageDialog(null, String.format("Seu saldo atual é de: R$ %.2f", conta.getSaldo()));

            } else if (escolha.equals("Sacar")) {
                double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a sacar:"));
                conta.sacar(valorSaque);

            }

            if (escolha.equals("Faturas")) {
                Fatura.gerarFaturaPDF(cliente, conta);
            }




        }
    }


    }









