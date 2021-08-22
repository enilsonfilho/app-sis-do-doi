package br.com.sisdodoi.DAO;

import java.util.List;

/**
 *
 * @author Enilson Filho
 */
public interface GenericDAO {

    public Boolean cadastrar(Object object);

    public List<Object> listar();

    public void excluir(Integer idObject);

    public Object carregar(int idObject);

    public Boolean alterar(Object object);

}
