/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mezzari.nota.model;

/**
 *
 * @author Thiago
 */
public class Pessoa {
    public int id;
    public String nome;
    public String cpf;
    public String login;
    public String senha;

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public Pessoa(int id, String nome, String cpf, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
    }

    public Pessoa() {
    }
}
