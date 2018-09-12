package com.matheus.zoo_m171.Model;

/**
 * Created by android on 06/09/2018.
 */

public class Animal {

    private int id;
    private double idade;
    private String nome;
    private Categoria categoria;

    public Animal(){

    }
    public Animal(int id, double idade, String nome, Categoria categoria) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nome;
    }
}
