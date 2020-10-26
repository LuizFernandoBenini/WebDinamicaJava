/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.service;

import br.edu.uniacademia.hospital.dao.ProntuarioDAO;
import br.edu.uniacademia.hospital.model.Prontuarios;
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
@Path("servicosProntuario")
@RequestScoped
public class ServicosProntuario {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicosTipoFuncionarioResource
     */
    public ServicosProntuario() {
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizar(Prontuarios tf) {
        ProntuarioDAO.getInstance().persistir(tf);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void gravar(Prontuarios tf) {
        ProntuarioDAO.getInstance().persistir(tf);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prontuarios> buscarTodos() {
        return ProntuarioDAO.getInstance().buscarTodas();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prontuarios buscar(Prontuarios tf) {
        return ProntuarioDAO.getInstance().buscar(tf.getDescricao());
    }

    @DELETE
    @Path("{id}")
    public void remover(Prontuarios tf) {
        ProntuarioDAO.getInstance().remover(tf);
    }

}
