/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.ProntuarioDAO;
import br.edu.uniacademia.hospital.model.Prontuarios;
import br.edu.uniacademia.hospital.dao.FuncionarioDAO;
import br.edu.uniacademia.hospital.model.Funcionarios;
import br.edu.uniacademia.hospital.model.Pacientes;
import br.edu.uniacademia.hospital.dao.PacienteDAO;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.event.ActionEvent;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author tassio
 */
@Named
@ViewScoped
public class ProntuarioBean implements Serializable {

    Prontuarios prontuario = new Prontuarios();

    List prontuarios =  new ArrayList();

    Funcionarios funcionario = new Funcionarios();
    
    List funcionarios =  new ArrayList();
    
    Pacientes paciente = new Pacientes();
        
    List pacientes;
    
    public ProntuarioBean() {
        prontuarios = new ProntuarioDAO().buscarTodas();
        prontuario = new Prontuarios();
        funcionarios = new FuncionarioDAO().buscarTodas();
        funcionario = new Funcionarios();
        pacientes = new PacienteDAO().buscarTodos();
        paciente = new Pacientes();
    }

    public void salvar(ActionEvent actionEvent) {
        new ProntuarioDAO().persistir(prontuario);
        prontuarios = new ProntuarioDAO().buscarTodas();
        prontuario = new Prontuarios();
    }

    public void remover(ActionEvent actionEvent) {
        new ProntuarioDAO().remover(prontuario);
        prontuarios = new ProntuarioDAO().buscarTodas();
        prontuario = new Prontuarios();
    }

    public Prontuarios getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuarios prontuario) {
        this.prontuario = prontuario;
    }

    public List getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(List prontuarios) {
        this.prontuarios = prontuarios;
    }
    
    public void setFuncionario(Funcionarios funcionario) {
        this.funcionario = funcionario;
    }

    public List getFuncionarios() {
        return funcionarios;
    }
    
    public Funcionarios getFuncionario() {
        return funcionario;
    }
    
    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public List getPacientes() {
        return pacientes;
    }
    
    public Pacientes getPaciente() {
        return paciente;
    }
}
