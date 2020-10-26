/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.Prontuarios;
import br.edu.uniacademia.hospital.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author tassi
 */
public class ProntuarioDAO {

    public static ProntuarioDAO prontuarioDAO;

    public static ProntuarioDAO getInstance() {
        if (prontuarioDAO == null) {
            prontuarioDAO = new ProntuarioDAO();
        }
        return prontuarioDAO;
    }

    public Prontuarios buscar(String descricao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Prontuarios a where a.descricao =:descricao ");
        query.setParameter("descricao", descricao);

        List<Prontuarios> prontuarios = query.getResultList();
        if (prontuarios != null && prontuarios.size() > 0) {
            return prontuarios.get(0);
        }

        return null;
    }

    public List<Prontuarios> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Prontuarios As a");
        return query.getResultList();
    }

    public void remover(Prontuarios prontuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(prontuario)) {
            prontuario = em.merge(prontuario);
        }
        em.remove(prontuario);
        em.getTransaction().commit();
    }

    public Prontuarios persistir(Prontuarios prontuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            prontuario = em.merge(prontuario);
            em.getTransaction().commit();
            System.out.println("Registro de Prontuario gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prontuario;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from Prontuarios ");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
