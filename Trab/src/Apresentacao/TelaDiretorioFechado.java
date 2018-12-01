/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import java.util.Scanner;
import trab.DiretorioFechado;


public class TelaDiretorioFechado {
    
    private DiretorioFechado owner;
    private Scanner sc;
    
    public TelaDiretorioFechado(DiretorioFechado owner) {
        this.owner = owner;
        this.sc = new Scanner(System.in);
    }

    public void mensagemElementoNaoEncontrado() {
        System.out.println("elemento não encontrado");
    }
    
}
