/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemadepersonagens;

/**
 *
 * @author Pedrovisk
 */
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Pedrovisk
 */
public class SistemaDePersonagens {

    public static void main(String[] args) {

        try {
            PersonagensDAO pdao = new PersonagensDAO();
            Personagens p = new Personagens();
            p.setNome("Anastasia Hoshin");
            p.setDescricao("Comerciante de Kararagi");
            p.setAvaliacao(8.5);
            pdao.cadastrar(p);
            System.out.println("Cadastrado com sucesso.");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
}
}