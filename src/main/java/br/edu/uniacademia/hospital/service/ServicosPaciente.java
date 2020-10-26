/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.service;

import br.edu.uniacademia.hospital.dao.PacienteDAO;
import br.edu.uniacademia.hospital.model.Pacientes;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author tassi
 */
@Path("servicosPaciente")
@RequestScoped
public class ServicosPaciente {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicosTipoFuncionarioResource
     */
    public ServicosPaciente() {
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizar(Pacientes tf) {
        PacienteDAO.getInstance().persistir(tf);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void gravar(Pacientes tf) {
        PacienteDAO.getInstance().persistir(tf);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pacientes> buscarTodos() {
        return PacienteDAO.getInstance().buscarTodos();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pacientes buscar(Pacientes tf) {
        return PacienteDAO.getInstance().buscar(tf.getNomePaciente());
    }

    @DELETE
    @Path("{id}")
    public void remover(Pacientes tf) {
        PacienteDAO.getInstance().remover(tf);
    }

}
