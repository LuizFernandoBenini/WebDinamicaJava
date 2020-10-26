/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.PacienteDAO;
import br.edu.uniacademia.hospital.model.Pacientes;
import br.edu.uniacademia.hospital.dao.EnderecoDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import javax.faces.event.ActionEvent;

import java.util.List;
import javax.enterprise.inject.New;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PacienteBean implements Serializable {

    Pacientes paciente = new Pacientes();

    List pacientes = new ArrayList();
    
    List enderecos;
    
    Enderecos endereco;
    
    
    public PacienteBean() {
        pacientes = new PacienteDAO().buscarTodos();
        paciente = new Pacientes();
        enderecos = new EnderecoDAO().buscarTodos();
    }

    public void salvar(ActionEvent actionEvent) {
        paciente.setEndereco(getEndereco());
     
        new PacienteDAO().persistir(paciente);
        pacientes = new PacienteDAO().buscarTodos();
        paciente = new Pacientes();
    }

    public void remover(ActionEvent actionEvent) {
        new PacienteDAO().remover(paciente);
        pacientes = new PacienteDAO().buscarTodos();
        paciente = new Pacientes();
    }

    
    
    
    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public List getPacientes() {
        return pacientes;
    }

    public void setPacientes(List pacientes) {
        this.pacientes = pacientes;
    }

   
    
    public Enderecos getEndereco() {
        return endereco;
    }

    public void setEndereco(Enderecos endereco) {
        this.endereco = endereco;
    }
    
    
    public List getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List enderecos) {
            this.enderecos = enderecos;
    }
}
