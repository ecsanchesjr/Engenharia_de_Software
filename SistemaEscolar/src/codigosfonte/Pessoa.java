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
    private String rg;
    private int idade;
    private String user;
    private int re;
    private int tipo;
    private String email;
    
    public static Pessoa per;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRe() {
        return re;
    }

    public void setRe(int re) {
        this.re = re;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public static Pessoa getInstance(){
        if(per == null){
            per = new Pessoa();
        }
        return(per);
    }
    
    public void setP(String nome, String cpf, String rg, int idade, String user){
        this.setNome(nome);
        this.setRg(rg);
        this.setCpf(cpf);
        this.setIdade(idade);
        this.setUser(user);
    }
    
    public void setP(String nome, String cpf, String rg, int idade, String user ,String email){
        this.setNome(nome);
        this.setRg(rg);
        this.setCpf(cpf);
        this.setIdade(idade);
        this.setUser(user);
        this.setEmail(email);
    }
    
    public void setP(String nome, String cpf, String rg, int idade){
        this.setNome(nome);
        this.setRg(rg);
        this.setCpf(cpf);
        this.setIdade(idade);
    }
}
