/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab;

import Apresentacao.Tela;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 08801473931
 */
public class Dados {
    
   private Aluno[] alunos;
   private DiretorioAberto dirCidades;
   private DiretorioAberto dirCursos;
   private DiretorioFechado dirIaa;
   private Tela tela;
   private int posicao;
   
   
   public Dados() {
       this.alunos = new Aluno[100];
       this.dirCidades = new DiretorioAberto();
       this.dirCursos = new DiretorioAberto();
       this.dirIaa = new DiretorioFechado();
       this.tela = new Tela(this);
       this.posicao = 0;          
   }
   
   public void inclusao(Aluno aluno) {
       try {
           this.verificaId(aluno.getId());
       } catch(Exception ex) {
           System.out.println("id ja existente");
           return;
       }
       alunos[posicao] = aluno;
       dirCidades.inclui(aluno.getCidade(), posicao);
       dirCursos.inclui(aluno.getCurso(), posicao);
       dirIaa.incluir(aluno.getIaa(), posicao);
       this.posicao++;
   }
   
   public void inclusao(int id, String nome, String curso, String cidade, double iaa) {
       try {
           this.verificaId(id);
           this.verificaIaa(iaa);
       } catch(Exception ex) {
           System.out.println("id ja existente ou iaa inserido maior que 10");
           return;
       }
       Aluno novoAluno = new Aluno(id, nome, curso, cidade, iaa);
       alunos[posicao] = novoAluno;
       dirCidades.inclui(novoAluno.getCidade(), posicao);
       dirCursos.inclui(novoAluno.getCurso(), posicao);
       dirIaa.incluir(novoAluno.getIaa(), posicao);
       this.posicao++;
   }
   
   public void verificaId(int id) throws Exception {
       for(int i = 0; i < posicao; i++) {
           if(alunos[i] != null) {
               if(alunos[i].getId() == id) {
                   throw new Exception("id existente");
               }
           }
       }
   }
   
   public void buscaSimplesCurso(String nomeCurso) {
       ArrayList<Integer> impressao = new ArrayList<>();
       try {
           impressao = dirCursos.consuelta(nomeCurso);
       } catch (Exception ex) {
           System.out.println("curso nao encontrado");
           return;
       }
       if(impressao.isEmpty()) {
           this.tela.mensagemListaVazia();
           return;
       }
       for(int x : impressao) {
           Aluno aluno = alunos[x];
           tela.exibeAluno(aluno);
       }
       
   }
   
   public ArrayList<Integer> buscaCompostaCurso(String nomeCurso) {
       ArrayList<Integer> impressao = new ArrayList<>();
       try {
           impressao = dirCursos.consuelta(nomeCurso);
       } catch (Exception ex) {
           System.out.println("curso nao encontrado ou lista vazia");
        }
       if(impressao.isEmpty()) {
           this.tela.mensagemListaVazia();
       }
       
       return impressao;
   }   
   
   public void buscaSimplesCidade(String nomeCidade) {
       ArrayList<Integer> impressao = new ArrayList<>();
       try {
           impressao = dirCidades.consuelta(nomeCidade);
       } catch (Exception ex) {
           System.out.println("cidade não encontrada");
           return;
       }
       if(impressao.isEmpty()) {
           this.tela.mensagemListaVazia();
       }
       for(int x : impressao) {
           Aluno aluno = alunos[x];
           tela.exibeAluno(aluno);
       }
       
   }
   
   public ArrayList<Integer> buscaCompostaCidade(String nomeCidade) {
        ArrayList<Integer> impressao = new ArrayList<>();
        try {
           impressao = dirCidades.consuelta(nomeCidade);
        } catch (Exception ex) {
            System.out.println("cidade não encontrada");
          }
        if(impressao.isEmpty()) {
           this.tela.mensagemListaVazia();
        }
        
        return impressao;
   }
   
   public void buscaSimplesIaa(int nivel) {
       ArrayList<Integer> impressao = new ArrayList<>();
       try {
           impressao = dirIaa.consulta(nivel);
       } catch (Exception ex) {
           System.out.println("nivel deve ser entre 0 e 3");
           return;
       }
       if(impressao.isEmpty()) {
           this.tela.mensagemListaVazia();
           return;
       }
       for(int x : impressao) {
           Aluno aluno = alunos[x];
           tela.exibeAluno(aluno);
       }
   }
   
   public ArrayList<Integer> buscaCompostaIaa(int nivel) {
       ArrayList<Integer> impressao = new ArrayList<>();
       try {
           impressao = dirIaa.consulta(nivel);
       } catch (Exception ex) {
           System.out.println("nivel deve ser entre 0 e 3");
          
       }
       if(impressao.isEmpty()) {
           this.tela.mensagemListaVazia();           
       }
       
       return impressao;
   }
   
   public ArrayList<Integer> interseccao(ArrayList<Integer> array1, ArrayList<Integer> array2) {
       ArrayList<Integer> impressao = new ArrayList<>();
       for(int x : array1) {
           for(int y : array2) {
               if(x == y) {
                   impressao.add(y);
               }
           }
       }
       return impressao;
   }
   
   public void imprimeArray(ArrayList<Integer> array) {
       for(int x : array) {
           this.tela.exibeAluno(alunos[x]);
       }
       
   }
   
   
   
   public void exclusao(Aluno aluno) throws Exception {
        if(aluno == null) {
            throw new Exception("aluno nao existe"); 
            //return; (talvez precise, mas acho que nao)
        }
       int x = 500;
       if(this.arrayVazio()) {
           this.tela.mensagemListaVazia();

       }
       for(int i = 0; i < posicao; i++) {
            if(alunos[i] != null) {
                Aluno alunoArray = alunos[i];
                if(aluno.getId() == alunoArray.getId() && aluno.getNome().equalsIgnoreCase(alunoArray.getNome())) {
                x = i;
                this.dirCidades.exclui(i);
                this.dirCursos.exclui(i);
                this.dirIaa.excluir(i);
                alunos[i] = null;
                break;
                }
           }  
       }
       if(x == 500) {
           tela.mensagemAlunoNaoEncontrado();
       } 
   }
   
   public void exibeAlunos() {
       if(this.haAlunos() == false) {
           this.tela.mensagemNaoHaAlunosCadastrados();
           return;
       }
       
       for(int i = 0; i < posicao; i++) {
           if(alunos[i] != null) {
               Aluno aluno = alunos[i];
               this.tela.exibeAluno(aluno);
           }
       }
   }
   
   public void CarregarDados() {
       Aluno aluno = new Aluno(37, "caio", "sistemas", "floripa", 1.5);
       Aluno aluno2 = new Aluno(34, "gabriel", "sistemas", "joinvile", 2.7);
       Aluno aluno3 = new Aluno(32, "eduardo", "computacao", "lages", 6);
       Aluno aluno4 = new Aluno(33, "roberto", "matematica", "floripa", 8);
       
       this.inclusao(aluno);
       this.inclusao(aluno2);
       this.inclusao(aluno3);
       this.inclusao(aluno4);
       
       this.tela.mensagemAlunosCarregados();
       
   }
   
   public boolean haAlunos() {
       if(this.arrayVazio()) {
           this.tela.mensagemNaoHaAlunosCadastrados();
           return false;
       }
       
       return true;
   }
  
   
   public boolean arrayVazio() {
       int k = 0;
       for(int i = 0; i < posicao; i++) {
           if(alunos[i] != null) {
               k++;
           }
       }
       if(k == 0) {
           return true;
       }
       
       return false;
   }
   
   public void inicia() {
       this.tela.exibirTela();
   }

    private void verificaIaa(double iaa) throws Exception {
        if(iaa > 10) {
            throw new Exception("iaa maior que 10");
        }
    }
    
    public Aluno getAluno(int id) {
        for(int i = 0; i < posicao; i++) {
            if(alunos[i] != null) {
                if(alunos[i].getId() == id) {
                    Aluno aluno = alunos[i];
                    return aluno;
                }
            }
        }
        return null;
    }
   
   public double teste(double x) {
       double y = x;
       return y;
   }
   
   
   
   
    
   
    
}
