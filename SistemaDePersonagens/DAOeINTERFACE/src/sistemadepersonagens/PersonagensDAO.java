/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadepersonagens;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Pedrovisk
 */

public class PersonagensDAO {

    public void cadastrar(Personagens perso) throws ClassNotFoundException, SQLException {
        Connection con = conexaosql.getConexao();
        String SQL = "insert into personagens (nome, descricao, avaliacao) values (?,?,?)";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setString(1, perso.getNome());
        comando.setString(2, perso.getDescricao());
        comando.setDouble(3, perso.getAvaliacao());
        comando.execute();
        con.close();
    }

    public void deletar(Personagens perso) throws ClassNotFoundException, SQLException {
        Connection con = conexaosql.getConexao();
        String SQL = "delete from personagens where id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setInt(1, perso.getId());
        comando.execute();
        con.close();
    }

    public void atualizar(Personagens perso) throws ClassNotFoundException, SQLException {
        Connection con = conexaosql.getConexao();
        String SQL = "update personagens set nome = ?, descricao = ?, avaliacao = ? where id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setString(1, perso.getNome());
        comando.setString(2, perso.getDescricao());
        comando.setDouble(3, perso.getAvaliacao());
        comando.setInt(4, perso.getId());
        comando.execute();
        con.close();
    }

    public Personagens consultar(Personagens perso) throws ClassNotFoundException, SQLException {
        Connection con = conexaosql.getConexao();
        String SQL = "select * from personagens where id=?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setInt(1, perso.getId());
        ResultSet rs = comando.executeQuery();
        Personagens p = new Personagens();
        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));
            p.setAvaliacao(rs.getDouble("avaliacao"));
        }
        con.close();
        return p;
    }

    public List<Personagens> consultarLista() throws ClassNotFoundException, SQLException {
        Connection con = conexaosql.getConexao();
        String SQL = "select * from personagens";
        PreparedStatement comando = con.prepareStatement(SQL);
        ResultSet rs = comando.executeQuery();
        List<Personagens> Lperso = new ArrayList<>();

        while (rs.next()) {
            Personagens p = new Personagens();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));
            p.setAvaliacao(rs.getDouble("avaliacao"));
            Lperso.add(p);
        }

        con.close();
        return Lperso;
    }
}
