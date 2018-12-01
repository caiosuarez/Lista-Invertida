/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import java.util.ArrayList;


public class Lista {
    
    private No primeiro;
    private No ultimo;
    private int numeroDeElementos;
    private String nome;
    
    public Lista(String nome) {
        this.primeiro = null;
        this.ultimo = null;
        this.numeroDeElementos = 0;
        this.nome = nome;
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public int getNumeroDeElementos() {
        return numeroDeElementos;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroDeElementos(int numeroDeElementos) {
        this.numeroDeElementos = numeroDeElementos;
    }
    
    public boolean ehVazia() {
        return (this.primeiro == null);
    }
    
    public void inserir(int numeroPosicaoAluno) {
        No novo = new No(numeroPosicaoAluno);
        if(this.ehVazia()){
            this.primeiro = novo;
        } else {
            this.ultimo.setProximo(novo);
        }
        this.ultimo = novo;
        this.numeroDeElementos++;
        
    }
    
    public ArrayList<Integer> percorreLista() {        //retorna um array com todos os elementos da lista (será util na classe do diretorio para imprimir os elementos)
        ArrayList<Integer> indices = new ArrayList<>();
        No aux = this.primeiro;
        for(int i = 0; i<=this.numeroDeElementos -1; i++) {
            indices.add(aux.getNumeroPosicaoAluno());
            aux = aux.getProximo();
        }
        return indices;
    }
    

    
    public boolean remover(int numeroPosicaoAluno) {
        No atual = this.primeiro;
        Boolean resultado = false;
        if(ehVazia()) {
            return false;
        }
        if(atual.getNumeroPosicaoAluno() == numeroPosicaoAluno) {
            this.removeDoComeco();
            resultado = true;
            return resultado;
        }
        if(this.ultimo.getNumeroPosicaoAluno() == numeroPosicaoAluno) {
            this.removeDoFim();
            resultado = true;
            return resultado;
        }
        
        for(int i = 0; i<=this.numeroDeElementos -2; i++) {
            if(atual.getProximo().getNumeroPosicaoAluno() == numeroPosicaoAluno) {
                No remove = atual.getProximo();
                atual.setProximo(remove.getProximo());
                remove.setProximo(null);
                this.numeroDeElementos--;
                resultado = true;
                break;
            } else {
                atual = atual.getProximo();
            }
        }
        return resultado;        
    }
    
    
    public void removeDoFim() {
        No atual = this.primeiro;
        No anterior = null;
        
        while(atual.getProximo() != null) {
            anterior = atual;
            atual = atual.getProximo();
        }
        this.ultimo = anterior;
        anterior.setProximo(null);
        this.numeroDeElementos--;
    }
    
    public void removeDoComeco() {
        this.primeiro = primeiro.getProximo();
        this.numeroDeElementos--;
    }
    
    public void teste() {
        ArrayList<Integer> impressao = this.percorreLista();
        for(int x : impressao) {
            System.out.println(x);
        }
    }
    
    public boolean estaNaLista(int numeroPosicaoAluno) {
        boolean esta = false;
        No atual = this.primeiro;
        while(atual != null) {
            if(atual.getNumeroPosicaoAluno() == numeroPosicaoAluno) {
                esta = true;
            }
            atual = atual.getProximo();
        }
        return esta;
    }
}
