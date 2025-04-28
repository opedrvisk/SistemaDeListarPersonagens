/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexaocomsql;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Pedrovisk
 */
public class Conexaocomsql {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Bem vindo ao cadastro de personagens! \n O que voce gostaria de fazer? \n 1)Cadastrar\n 2)Deletar\n 3)Atualizar\n 4)Consultar");

        Personagens p = new Personagens();
        int escolha = entrada.nextInt();

        if (escolha == 1) {
            entrada.nextLine();
            System.out.println("Insira o nome do personagem: ");
            String nome = entrada.nextLine();
            System.out.println("Insira a descricao do personagem: ");
            String descricao = entrada.nextLine();
            System.out.println("Insira sua avaliacao sobre o personagem, entre 0 a 10: ");
            double avaliacao = entrada.nextDouble();
            p.setNome(nome);
            p.setDescricao(descricao);
            p.setAvaliacao(avaliacao);
            try {
                p.cadastrar();
                entrada.nextLine();
                System.out.println("Personagem cadastrado com sucesso!");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
            
            
        } else if (escolha == 2) {
            entrada.nextLine();
            System.out.println("Qual produto voce quer apagar? ");
            int id = entrada.nextInt();
            entrada.nextLine();
            p.setId(id);
            try {
                p.deletar();
                System.out.println("Deletado com sucesso.");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
            
            
        } else if (escolha == 3) {
            entrada.nextLine();
            System.out.println("Qual personagem voce quer atualizar? ");
            int id = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Qual o nome do novo personagem? ");
            String nome = entrada.nextLine();
            System.out.println("Qual a descricao do novo personagem? ");
            String descricao = entrada.nextLine();
            System.out.println("Qual a avaliacao do do novo personagem ?");
            double avaliacao = entrada.nextDouble();
            p.setId(id);
            p.setNome(nome);
            p.setDescricao(descricao);
            p.setAvaliacao(avaliacao);
            try {
                p.atualizar();
                System.out.println("Personagem atualizado com sucesso!");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
            
            
        } else if (escolha == 4) {
            entrada.nextLine();
            System.out.println("Qual personagem voce quer consultar? ");
            int id = entrada.nextInt();
            entrada.nextLine();
            p.setId(id);
            try {
                Personagens pc = p.consultar();
                if (pc.getDescricao() != null) {
                    System.out.println("Id do personagem: " + pc.getId());
                    System.out.println("Nome do personagem: " + pc.getNome());
                    System.out.println("Descricao do personagem: " + pc.getDescricao());
                    System.out.println("Avaliacao do personagem: " + pc.getAvaliacao());
                }
                else{
                    System.out.println("Id nao encontrado. ");                
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }
}
