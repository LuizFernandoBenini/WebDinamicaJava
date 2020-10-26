/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.Pacientes;
import br.edu.uniacademia.hospital.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author tassi
 */
public class PacienteDAO {

    public static PacienteDAO pacienteDAO;

    public static PacienteDAO getInstance() {
        if (pacienteDAO == null) {
            pacienteDAO = new PacienteDAO();
        }
        return pacienteDAO;
    }

    public Pacientes buscar(String nome) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Pacientes a where a.nomePaciente =:nome ");
        query.setParameter("nome", nome);

        List<Pacientes> pacientes = query.getResultList();
        if (pacientes != null && pacientes.size() > 0) {
            return pacientes.get(0);
        }

        return null;
    }
    
        public Pacientes buscarPorId(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Pacientes a where a.idPaciente =:id ");
        query.setParameter("id", id);

        List<Pacientes> pacientes = query.getResultList();
        if (pacientes != null && pacientes.size() > 0) {
            return pacientes.get(0);
        }

        return null;
    }

    public List<Pacientes> buscarTodos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Pacientes As a");
        return query.getResultList();
    }

    public void remover(Pacientes Paciente) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(Paciente)) {
            Paciente = em.merge(Paciente);
        }
        em.remove(Paciente);
        em.getTransaction().commit();
    }

    public Pacientes persistir(Pacientes Paciente) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            Paciente = em.merge(Paciente);
            em.getTransaction().commit();
            System.out.println("Registro Paciente gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Paciente;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from Pacientes ");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
