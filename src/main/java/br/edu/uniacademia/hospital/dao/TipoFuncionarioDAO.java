/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.TipoFuncionario;
import br.edu.uniacademia.hospital.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author tassi
 */
public class TipoFuncionarioDAO {

    public static TipoFuncionarioDAO tipoFuncionarioDAO;

    public static TipoFuncionarioDAO getInstance() {
        if (tipoFuncionarioDAO == null) {
            tipoFuncionarioDAO = new TipoFuncionarioDAO();
        }
        return tipoFuncionarioDAO;
    }

    public TipoFuncionario buscar(String nome) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from TipoFuncionario a where a.nomeTipoFuncionario =:nome ");
        query.setParameter("nome", nome);

        List<TipoFuncionario> tipoFuncionario = query.getResultList();
        if (tipoFuncionario != null && tipoFuncionario.size() > 0) {
            return tipoFuncionario.get(0);
        }

        return null;
    }
    
    
    
    public TipoFuncionario buscarPorId(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from TipoFuncionario a where a.idtipoFuncionario =:id ");
        query.setParameter("id", id);

        List<TipoFuncionario> tipoFuncionario = query.getResultList();
        if (tipoFuncionario != null && tipoFuncionario.size() > 0) {
            return tipoFuncionario.get(0);
        }

        return null;
    }

    public List<TipoFuncionario> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from TipoFuncionario As a");
        return query.getResultList();
    }

    public void remover(TipoFuncionario tipoFuncionario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(tipoFuncionario)) {
            tipoFuncionario = em.merge(tipoFuncionario);
        }
        em.remove(tipoFuncionario);
        em.getTransaction().commit();
    }

    public TipoFuncionario persistir(TipoFuncionario tipoFuncionario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            tipoFuncionario = em.merge(tipoFuncionario);
            em.getTransaction().commit();
            System.out.println("Registro TipoFuncionario gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoFuncionario;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from TipoFuncionario ");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
