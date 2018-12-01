/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab;

import List.Lista;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 08801473931
 */
public class Trab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Dados dados = new Dados();
        dados.inicia();
       //System.out.println(dados.teste(8.6));

     
     /*   
        Lista lista = new Lista("computacao");
        lista.inserir(6);
        lista.inserir(7);
        lista.inserir(9);
        lista.inserir(15);
        lista.inserir(14);
        lista.inserir(8);
        lista.inserir(16);

        
        lista.remover(8);
        lista.remover(14);
        lista.remover(16);
        lista.teste();
        
        Aluno aluno = new Aluno(1, "caio", "sistemas", "floripa", 5.12);
        System.out.println(aluno.getCidade());
         System.out.println(lista.estaNaLista(15));

        DiretorioAberto dirCidade = new DiretorioAberto();
        
        dirCidade.inclui("palhoca", 1);
        dirCidade.inclui("palhoca", 0);
        dirCidade.inclui("palhoca", 3);
        dirCidade.inclui("Palhoca", 3);
        dirCidade.inclui("floripa", 5);

        
        
        dirCidade.consulta("palhoca");
        System.out.println("//////////////////////////////");
        
        DiretorioFechado dirIaa = new DiretorioFechado();
        
        dirIaa.incluir(3.14, 0);
        dirIaa.incluir(4, 4);
        dirIaa.incluir(7.14, 2);
        dirIaa.incluir(8, 3);
        
        dirIaa.consultaFudida(0);
        
        
        
        
        
        /*
        
        Dados dados = new Dados();
        Aluno aluno = new Aluno(1, "caio", "sistemas", "floripa", 5.83);
        Aluno aluno2 = new Aluno(2, "gabriel", "computacao", "floripa", 6.83);
        Aluno aluno3 = new Aluno(2, "gabriela", "computacao", "palhoca", 6.83);
        dados.inclusao(aluno);
        dados.inclusao(aluno2);
        dados.inclusao(aluno3);
       // dados.exclusao(aluno2);
     //   dados.exclusao(aluno);
        dados.buscaSimplesCurso("computacao");
        dados.buscaSimplesCidade("palhoca");
        System.out.println("......................");
       try {
           dados.exclusao(aluno3);
          // dados.exclusao(aluno);
       } catch(Exception ex) {
           System.out.println("aluno n existe");
       }
       dados.buscaSimplesCurso("computacao");
        
        
        
        */
       
        

     
     
        
        
    }
    
}
