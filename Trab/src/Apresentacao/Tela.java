/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import java.util.ArrayList;
import java.util.Scanner;
import trab.Aluno;
import trab.Dados;


public class Tela {
    
    private Dados owner;
    private Scanner sc;
    
    public Tela(Dados owner) {
        this.owner = owner;
        this.sc = new Scanner(System.in);
    }
    
    	public void exibirTela() {
		int opcao = 0;
		do {
			System.out.println("\nBem vindo");
			System.out.println("digite 1 para carregar dados");
			System.out.println("Digite 2 para cadastrar aluno");
			System.out.println("Digite 3 para excluir aluno");
			System.out.println("Digite 4 para listar alunos cadastrados");
			System.out.println("Digite 5 para fazer uma busca simples");
			System.out.println("Digite 6 para fazer uma busca composta");
			System.out.println("Digite 0 para encerrar");
			opcao = this.sc.nextInt();
			try {
				this.trataOpcao(opcao);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (opcao != 0);
                System.exit(0);
	}
        
        public void trataOpcao(int opcao) {
            switch (opcao) {
                case 1:
                    this.owner.CarregarDados();
                    break;
                case 2:
                    this.telaCadastroAluno();
                    break;
                case 3:
                    this.telaExclusaoAluno();
                    break;
                case 4:
                    this.owner.exibeAlunos();
                    break;
                case 5:
                    this.telaBuscaSimples();
                    break;
                case 6:
                    this.telaBuscaComposta();
                    break;
            }
            
        }
    

    public void mensagemAlunoNaoEncontrado() {
        System.out.println("aluno nao encontrado\n");
    }

    public void mensagemListaVazia() {
        System.out.println("lista vazia");
    }
    
    public void exibeAluno(Aluno aluno) {
        System.out.println("-----------------------------");
        System.out.println("ID aluno: " + aluno.getId() + "\nNome aluno: " + aluno.getNome() + "\n Curso: " + aluno.getCurso() + "\n Cidade: " + aluno.getCidade() + "\n iaa: " + aluno.getIaa());
    }

    public void mensagemNaoHaAlunosCadastrados() {
        System.out.println("nao há alunos cadastrados");
    }

    private void telaCadastroAluno() {
        try {
            System.out.println("\nBem vindo a tela de cadastro de aluno");
            System.out.println("\nInsira o nome do aluno");
            String nome = this.sc.next();
        
            System.out.println("\nInsira o id do aluno");
            int id = this.sc.nextInt();
        
            System.out.println("\nInsira o curso do aluno");
            String curso = this.sc.next();
        
            System.out.println("\nInsira a cidade do aluno");
            String cidade = this.sc.next();
        
            System.out.println("\nInsira o iaa do aluno");
            Double iaa = this.sc.nextDouble(); 
        
            this.owner.inclusao(id, nome, curso, cidade, iaa);
            System.out.println("\nAluno cadastrado com sucesso");
        } catch(Exception ex) {
            System.out.println("formato incorreto de preenchimento");
            this.sc.nextLine();
	    return;
        }
        
        
        
    }

    private void telaExclusaoAluno() {
        try {
            if(!this.owner.haAlunos()) {
                return;
            }    
            System.out.println("\nBem vindo a tela de remocao de alunos");
            System.out.println("\nInsira o id do aluno a ser removido");
            int id = this.sc.nextInt();
            Aluno alunoARemover = owner.getAluno(id);
            owner.exclusao(alunoARemover);
            System.out.println("\nAluno removido com sucesso");
            } catch(Exception ex) {
            System.out.println("aluno nao existente");
            this.sc.nextLine();
	    return;
        }
        
        
    }

    private void telaBuscaSimples() {
        try {
            System.out.println("\nBem vindo a tela de busca simples");
            System.out.println("\nDigite 1 para busca por curso, 2 para busca por cidade e 3 para busca por iaa");
            int selecaoBusca = this.sc.nextInt();
            if(selecaoBusca == 1) {
            System.out.println("\nDigite o nome do curso a ser buscado");
            String nomeCurso = this.sc.next();
            owner.buscaSimplesCurso(nomeCurso);
            }
            if(selecaoBusca == 2) {
            System.out.println("\nDigite o nome da cidade a ser buscada");
            String nomeCidade = this.sc.next();
            owner.buscaSimplesCidade(nomeCidade);
            }
            if(selecaoBusca == 3) {
            System.out.println("\nDigite 0 para ver todos os alunos com iaa nível RUIM");
            System.out.println("\nDigite 1 para ver todos os alunos com iaa nível RAZOAVEL");
            System.out.println("\nDigite 2 para ver todos os alunos com iaa nível BOM");
            System.out.println("\nDigite 3 para ver todos os alunos com iaa nível OTIMO");
            int iaa = this.sc.nextInt();
            owner.buscaSimplesIaa(iaa);
            }
            
        } catch(Exception ex) {
            System.out.println("formato incrreto de preenchimento");
            this.sc.nextLine();
	    return;
        }

        
        
    }
    

    private void telaBuscaComposta() {
        try {
            System.out.println("\nBem vindo a tela de busca combinada");
            System.out.println("\nDigite 1 para fazer uma busca combinada entre Curso e cidade");
            System.out.println("\nDigite 2 para fazer uma busca combinada entre Curso e Iaa");
            System.out.println("\nDigite 3 para fazer uma busca combinada entre Cidade e Iaa");
            int selecaoBusca = this.sc.nextInt();
            if(selecaoBusca == 1) {
            System.out.println("digite o nome do curso");
            String nomeCurso = this.sc.next();
            System.out.println("digite o nome da cidade");
            String nomeCidade = this.sc.next();
            ArrayList<Integer> array1 = this.owner.buscaCompostaCurso(nomeCurso);
            ArrayList<Integer> array2 = this.owner.buscaCompostaCidade(nomeCidade);
            ArrayList<Integer> impressao = this.owner.interseccao(array1, array2);
            this.owner.imprimeArray(impressao);  
            }
            if(selecaoBusca == 2) {
            System.out.println("digite o nome do curso");
            String nomeCurso = this.sc.next();
            System.out.println("de 0 a 3, digite o nivel de iaa desejado ");
            int nivel = this.sc.nextInt();
            ArrayList<Integer> array1 = this.owner.buscaCompostaCurso(nomeCurso);
            ArrayList<Integer> array2 = this.owner.buscaCompostaIaa(nivel);
            ArrayList<Integer> impressao = this.owner.interseccao(array1, array2);
            this.owner.imprimeArray(impressao);
            }
            if(selecaoBusca == 3) {
            System.out.println("digite o nome da cidade");
            String nomeCidade = this.sc.next();
            System.out.println("de 0 a 3, digite o nivel de iaa desejado ");
            int nivel = this.sc.nextInt();
            ArrayList<Integer> array1 = this.owner.buscaCompostaCidade(nomeCidade);
            ArrayList<Integer> array2 = this.owner.buscaCompostaIaa(nivel);
            ArrayList<Integer> impressao = this.owner.interseccao(array1, array2);
            this.owner.imprimeArray(impressao);
            }
        } catch(Exception ex) {
            System.out.println("formato incorreto de preenchimento");
            this.sc.nextLine();
	    return;
        }
        
    }

    public void mensagemAlunosCarregados() {
       System.out.println("dados carregados com sucesso");
    }
    
    
    
    
}
