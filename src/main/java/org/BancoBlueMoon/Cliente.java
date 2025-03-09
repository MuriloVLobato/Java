package org.BancoBlueMoon;

public class Cliente {
    private String nome;
    private int idade;
    private String cpf;
    private String email;
    private String cep;
    private String endereco;
    private String numeroCasa;

    public Cliente(String nome, int idade, String cpf, String email, String cep, String endereco, String numeroCasa) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.numeroCasa = numeroCasa;
    }



    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

}



