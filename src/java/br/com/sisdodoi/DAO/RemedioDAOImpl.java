package br.com.sisdodoi.DAO;

import br.com.sisdodoi.model.Remedio;
import br.com.sisdodoi.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Enilson Filho
 */
public class RemedioDAOImpl implements GenericDAO {

    private Connection conn;

    public RemedioDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        Remedio remedio = (Remedio) object;
        PreparedStatement stmt = null;
        String sql = "Insert into remedio(nome_remedio,preco_remedio) "
                + "values(?,?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, remedio.getNomeRemedio());
            stmt.setDouble(2, remedio.getPrecoRemedio());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Problemas ao cadastrar Remedio! Erro:" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.err.println("Problemas ao fechar conexão!Erro:" + ex.getMessage());
                ex.printStackTrace();

            }
        }

    }

    @Override
    public List<Object> listar() {

        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select rm.* from remedio rm order by rm.nome_remedio;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Remedio remedio = new Remedio();
                remedio.setIdRemedio(rs.getInt("id_remedio"));
                remedio.setNomeRemedio(rs.getString("nome_remedio"));
                remedio.setPrecoRemedio(rs.getDouble("preco_remedio"));
                resultado.add(remedio);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Remedio! Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexao! Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;

    }

    @Override
    public void excluir(Integer idObject) {
        PreparedStatement stmt = null;
        String sql = "Delete from remedio where id_remedio=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Remedio!Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao excluir Remedio! Erro:" + ex.getMessage());
                ex.printStackTrace();
            }

        }

    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Remedio remedio = null;
        String sql = "select r.* from remedio r where r.id_remedio=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            if (rs.next()) {
                remedio = new Remedio();
                remedio.setIdRemedio(rs.getInt("id_remedio"));
                remedio.setNomeRemedio(rs.getString("nome_remedio"));
                remedio.setPrecoRemedio(rs.getDouble("preco_remedio"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Remedio! Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexao! Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return remedio;
    }

    @Override
    public Boolean alterar(Object object) {
        Remedio remedio = (Remedio) object;
        PreparedStatement stmt = null;
        String sql = "update remedio set nome_remedio=?, preco_remedio=? where id_remedio=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, remedio.getNomeRemedio());
            stmt.setString(2, remedio.DoublePrecoRemedio());
            stmt.setInt(3, remedio.getIdRemedio());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.err.println("Problemas ao alterar Remedio! Erro:" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.err.println("Problemas ao fechar conexao!Erro:" + ex.getMessage());
                ex.printStackTrace();

            }
        }
    }
}
