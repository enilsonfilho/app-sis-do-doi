package br.com.sisdodoi.DAO;

import br.com.sisdodoi.model.PrincipioAtivo;
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
public class PrincipioAtivoDAOImpl implements GenericDAO {

    private Connection conn;

    public PrincipioAtivoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        PrincipioAtivo principioAtivo = (PrincipioAtivo) object;
        PreparedStatement stmt = null;
        String sql = "Insert into principio_ativo(nome_principio_ativo,observacao_principio_ativo) "
                + "values(?,?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, principioAtivo.getNomePrincipioAtivo());
            stmt.setString(2, principioAtivo.getObservacaoPrincipioAtivo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Problemas ao cadastrar Principios Ativo! Erro:" + ex.getMessage());
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
        String sql = "select pa.* from principio_ativo pa order by pa.nome_principio_ativo;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                PrincipioAtivo principioAtivo = new PrincipioAtivo();
                principioAtivo.setIdPrincipioAtivo(rs.getInt("id_principio_ativo"));
                principioAtivo.setNomePrincipioAtivo(rs.getString("nome_principio_ativo"));
                principioAtivo.setObservacaoPrincipioAtivo(rs.getString("observacao_principio_ativo"));
                resultado.add(principioAtivo);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar P.A.! Erro:" + ex.getMessage());
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
        String sql = "Delete from principio_ativo where id_principio_ativo=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir P.A.!Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao excluir P.A.! Erro:" + ex.getMessage());
                ex.printStackTrace();
            }

        }

    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PrincipioAtivo principioAtivo = null;
        String sql = "select p.* from principio_ativo p where p.id_principio_ativo=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            if (rs.next()) {
                principioAtivo = new PrincipioAtivo();
                principioAtivo.setIdPrincipioAtivo(rs.getInt("id_principio_ativo"));
                principioAtivo.setNomePrincipioAtivo(rs.getString("nome_principio_ativo"));
                principioAtivo.setObservacaoPrincipioAtivo(rs.getString("observacao_principio_ativo"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar P.A.! Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexao! Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return principioAtivo;
    }

    @Override
    public Boolean alterar(Object object) {
        PrincipioAtivo principioAtivo = (PrincipioAtivo) object;
        PreparedStatement stmt = null;
        String sql = "update principio_ativo set nome_principio_ativo=?, observacao_principio_ativo=? where id_principio_ativo=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, principioAtivo.getNomePrincipioAtivo());
            stmt.setString(2, principioAtivo.getObservacaoPrincipioAtivo());
            stmt.setInt(3, principioAtivo.getIdPrincipioAtivo());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.err.println("Problemas ao alterar Principio Ativo! Erro:" + ex.getMessage());
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
