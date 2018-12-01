/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab;


import Apresentacao.TelaDiretorioFechado;
import List.Lista;
import java.util.ArrayList;

/**
 *
 * @author 08801473931
 */
public class DiretorioFechado {
    
    private Lista[] dados;
    private TelaDiretorioFechado telaDiretorioFechado;
    
    
    public DiretorioFechado() {
        this.dados = new Lista[4];
        dados[0] = new Lista("ruim");
        dados[1] = new Lista("razoavel");
        dados[2] = new Lista("bom");
        dados[3] = new Lista("otimo");
        this.telaDiretorioFechado = new TelaDiretorioFechado(this);
    }
    
    public int calculaGrupo(double iaa) {
        int grupo = 0;
        if(iaa > 2.5 && iaa <= 5) {
            grupo = 1;
        }
        if(iaa > 5 && iaa <= 7.5) {
            grupo = 2;
        }
        if(iaa > 7.5 && iaa <= 10) {
            grupo = 3;
        }
        return grupo;
    }
    
    public void incluir(double iaa, int posicao) { 
        int grupo = this.calculaGrupo(iaa);
        dados[grupo].inserir(posicao);
    }
    
    public void excluir(int posicao) {
        int j = 0;
        for(int i = 0; i < 4; i++) {
           if(dados[i].estaNaLista(posicao)) {
               j++;
               dados[i].remover(posicao);
           }
            
        }
        if(j == 0) {
             this.telaDiretorioFechado.mensagemElementoNaoEncontrado();   
         }
    }
    /*
    public void consulta(Double iaa) { //so pra testar no metodo main
        int grupo = this.calculaGrupo(iaa);
        ArrayList<Integer> impressao = dados[grupo].percorreLista();
        for(int y : impressao) {
            System.out.println(y);
        }
        
    }
    */
    void incluir(int iaa, int posicao) {
        double iaaa = (double) iaa;
        int grupo = this.calculaGrupo(iaaa);
        dados[grupo].inserir(posicao);
    
    }
    /*
    public void consulta(int i) { //
        Double iaa = (double) i;
        int grupo = this.calculaGrupo(iaa);
        ArrayList<Integer> impressao = dados[grupo].percorreLista();
        for(int y : impressao) {
            System.out.println(y);
        }
    }
    */
        public void consultaFudida(int nivel) { //parametro passa um nivel entre 0 e 3, 0(sendo o mais baixo) e quer que retorne todos os iaas com o mesmo nivel
            ArrayList<Integer> impressao = new ArrayList<>();
            for(int i = nivel; i < 4; i++) {
            ArrayList<Integer> x = dados[i].percorreLista();
                for(int z : x) {
                impressao.add(z);
                }
            }
            for(int y : impressao) {
            System.out.println(y);
            }
        }
        
        public ArrayList<Integer> consulta(int nivel) throws Exception {
            if(nivel > 3) {
                throw new Exception("nivel errado");
            }
            ArrayList<Integer> impressao = dados[nivel].percorreLista();            
            return impressao;
        }
        
        
        
        
        
        
}
