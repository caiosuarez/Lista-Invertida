/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;


public class No {
    
    private int numeroPosicaoAluno;
    private No proximo;
    
    public No(int numeroPosicaoAluno) {
        this.numeroPosicaoAluno = numeroPosicaoAluno;
        this.proximo = null;
    }

    public int getNumeroPosicaoAluno() {
        return numeroPosicaoAluno;
    }

    public void setNumeroPosicaoAluno(int numeroPosicaoAluno) {
        this.numeroPosicaoAluno = numeroPosicaoAluno;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    
    
    
}
