/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.Enderecos;
import br.edu.uniacademia.hospital.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author tassi
 */
public class EnderecoDAO {

    public static EnderecoDAO EnderecoDAO;

    public static EnderecoDAO getInstance() {
        if (EnderecoDAO == null) {
            EnderecoDAO = new EnderecoDAO();
        }
        return EnderecoDAO;
    }

    public Enderecos buscar(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Enderecos a where a.idEndereco =:id ");
        query.setParameter("id", id);

        List<Enderecos> enderecos = query.getResultList();
        if (enderecos != null && enderecos.size() > 0) {
            return enderecos.get(0);
        }

        return null;
    }

    public List<Enderecos> buscarTodos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Enderecos As a");
        return query.getResultList();
    }


}
