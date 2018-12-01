/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab;

/**
 *
 * @author 08801473931
 */
public class Aluno {
    
    private int id; 
    private String nome;
    private String curso;
    private String cidade;
    private double iaa;

    public Aluno(int id, String nome, String curso, String cidade, double iaa) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.cidade = cidade;
        this.iaa = iaa;
    }
    
    public Aluno(int id, String nome, String curso, String cidade, int iaa) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.cidade = cidade;
        this.iaa = (double) iaa;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getIaa() {
        return iaa;
    }

    public void setIaa(double iaa) {
        this.iaa = iaa;
    }
    
    
    
    
    
    
}
