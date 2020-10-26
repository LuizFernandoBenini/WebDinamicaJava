/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.Funcionarios;
import br.edu.uniacademia.hospital.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author tassi
 */
public class FuncionarioDAO {

    public static FuncionarioDAO FuncionarioDAO;

    public static FuncionarioDAO getInstance() {
        if (FuncionarioDAO == null) {
            FuncionarioDAO = new FuncionarioDAO();
        }
        return FuncionarioDAO;
    }

    public Funcionarios buscar(String nome) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Funcionarios a where a.nomeFuncionario =:nome ");
        query.setParameter("nome", nome);

        List<Funcionarios> funcionarios = query.getResultList();
        if (funcionarios != null && funcionarios.size() > 0) {
            return funcionarios.get(0);
        }

        return null;
    }
        public Funcionarios buscarPorId(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Funcionarios a where a.idFuncionario =:id ");
        query.setParameter("id", id);

        List<Funcionarios> funcionarios = query.getResultList();
        if (funcionarios != null && funcionarios.size() > 0) {
            return funcionarios.get(0);
        }

        return null;
    }

    public List<Funcionarios> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Funcionarios As a");
        return query.getResultList();
    }

    public void remover(Funcionarios Funcionarios) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(Funcionarios)) {
            Funcionarios = em.merge(Funcionarios);
        }
        em.remove(Funcionarios);
        em.getTransaction().commit();
    }

    public Funcionarios persistir(Funcionarios Funcionarios) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            Funcionarios = em.merge(Funcionarios);
            em.getTransaction().commit();
            System.out.println("Registro Funcionario gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Funcionarios;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from Funcionarios ");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
