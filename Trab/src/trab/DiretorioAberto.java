/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab;

import Apresentacao.TelaDiretorioAberto;
import List.Lista;
import java.util.ArrayList;

/**
 *
 * @author 08801473931
 */
public class DiretorioAberto {
    
    private Lista[] dados;
    private int indice;
    private TelaDiretorioAberto tela;
    
    
    
    public DiretorioAberto() {
       dados = new Lista[50];
      this.indice = 0;
    }
    
 /*   public void incluir(String x, int posicao) {
        for(int i = 0; i<= indice; i++) {
            
            if() {
                dados[i].inserir(posicao);
                System.out.println("topzera");
                break;
            } else {
                dados[indice] = new Lista(x);
                dados[indice].inserir(posicao);
                indice++;
                 System.out.println("topster");
                break;
            }
        }
        
    }
*/
    
    
     public boolean inclui(String x, int posicao) {
        boolean resultado = false;
        for(int i = 0; i< indice; i++) {
            if(indice == 0) {
                break;
            } else {
                if(dados[i].getNome().equalsIgnoreCase(x)) {
                    dados[i].inserir(posicao);
                    resultado = true;
                    return resultado;
                }   
            }  
        }
        dados[indice] = new Lista(x);
        dados[indice].inserir(posicao);
        indice++;
        resultado = true;
        return resultado;
        
    }
     
     public void consulta(String x) {  //esse era so pra testar no metodo main
         int j = 0;
         if(this.indice == 0) {
                 this.tela.mensagemListaVazia();
                 //tratar com exceção depois
         }
         for(int i = 0; i< indice; i++) {
             
            if(dados[i].getNome().equalsIgnoreCase(x)) {
                j++;
                Lista lista = dados[i];
                ArrayList<Integer> impressao = lista.percorreLista();
                for(int y : impressao) {
                    System.out.println(y);
                }
                break;
            } 
            
         }
         if(j == 0) {
             this.tela.mensagemCursoOuCidadeNaoEncontrado();
        }
     }
     
     public ArrayList<Integer> consuelta(String x) throws Exception {
         ArrayList<Integer> impressao = new ArrayList<>();
         int j = 0;
         if(this.indice == 0) {
             throw new Exception("lista vazia");

         }
         
        for(int i = 0; i < indice; i++) {
            if(dados[i].getNome().equalsIgnoreCase(x)) {
                j++;
                Lista lista = dados[i];
                impressao = lista.percorreLista();
                break;
            }
        }
        if(j == 0) {
            throw new Exception("curso ou cidade nao encontrado");

        }
        return impressao;        
     }
     
     public void exclui(int posicao) {
          int j = 0;
         if(this.indice == 0) {
             this.tela.mensagemListaVazia();
         }
         for(int i = 0; i < indice; i++) {
             Lista lista = dados[i];
             if(lista.estaNaLista(posicao)) {
                 j++;
                 lista.remover(posicao);
             }
         }
         if(j == 0) {
             this.tela.mensagemElementoNaoEncontrado();   
         }
     }
    
}
