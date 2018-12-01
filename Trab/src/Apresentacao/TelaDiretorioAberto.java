/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import java.util.Scanner;
import trab.DiretorioAberto;


public class TelaDiretorioAberto {
    
    private DiretorioAberto owner;
    private Scanner sc;
    
        public TelaDiretorioAberto(DiretorioAberto owner) {
        this.owner = owner;
        this.sc = new Scanner(System.in);
    }

    public void mensagemCursoOuCidadeNaoEncontrado() {
        System.out.println("curso ou cidade não encontrado");
    }

    public void mensagemListaVazia() {
        System.out.println("tela vazia");
    }

    public void mensagemElementoNaoEncontrado() {
        System.out.println("elemento nao encontrado");
    }
    
}
