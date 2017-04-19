/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigosfonte;

/**
 *
 * @author ecsan
 */
public class Pessoa {
    private String nome;
    private String cpf;
    //private String email;
    private String rg;
    private int idade;

    Pessoa(String nome, String cpf, String rg, int idade) {
        setNome(nome);
        setCpf(cpf);
        setRg(rg);
        setIdade(idade);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
/*
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
*/
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
