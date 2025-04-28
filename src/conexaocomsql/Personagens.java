/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexaocomsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedrovisk
 */
public class Personagens {

    private int id;
    private String nome;
    private String descricao;
    private double avaliacao;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Connection getConexao() throws ClassNotFoundException, SQLException {
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/conexaocomjava";
        String USER = "root";
        String PASSWORD = "";
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void cadastrar() throws ClassNotFoundException, SQLException {
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("insert into personagens (nome, descricao, avaliacao) values (?,?,?)");
        comando.setString(1, nome);
        comando.setString(2, descricao);
        comando.setDouble(3, avaliacao);
        comando.execute();
        con.close();
    }

    public void deletar() throws ClassNotFoundException, SQLException {
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("delete from personagens where id = ?");
        comando.setInt(1, id);
        comando.execute();
        con.close();
    }

    public void atualizar() throws ClassNotFoundException, SQLException {
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("update personagens set nome = ?, descricao = ?, avaliacao = ? where id = ?");
        comando.setString(1, nome);
        comando.setString(2, descricao);
        comando.setDouble(3, avaliacao);
        comando.setInt(4, id);
        comando.execute();
        con.close();
    }
    
    public Personagens consultar() throws ClassNotFoundException, SQLException {
        Connection con = getConexao();
        String SQL = "select * from personagens where id=?";
        PreparedStatement comando = con.prepareStatement (SQL);
        comando.setInt(1, id);
        ResultSet resultado = comando.executeQuery();
        Personagens p = new Personagens();
        if (resultado.next()) {
            p.setId(resultado.getInt("id"));
            p.setNome(resultado.getString("nome"));
            p.setDescricao(resultado.getString("descricao"));
            p.setAvaliacao(resultado.getDouble("avaliacao"));
        }
        con.close();
        return p;
    }
        
}
