/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.FuncionarioDAO;
import br.edu.uniacademia.hospital.model.Funcionarios;
import br.edu.uniacademia.hospital.dao.TipoFuncionarioDAO;
import br.edu.uniacademia.hospital.model.TipoFuncionario;
import br.edu.uniacademia.hospital.dao.EnderecoDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
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
public class FuncionarioBean implements Serializable {

    Funcionarios funcionario = new Funcionarios();

    List funcionarios = new ArrayList();
    
    TipoFuncionario tipoFuncionario = new TipoFuncionario();
    
    List tipoFuncionarios = new ArrayList();
    
    Enderecos endereco = new Enderecos();
    
    List enderecos = new ArrayList();

    public FuncionarioBean() {
        funcionarios = new FuncionarioDAO().buscarTodas();
        funcionario = new Funcionarios();
        tipoFuncionarios = new TipoFuncionarioDAO().buscarTodas();
        tipoFuncionario = new TipoFuncionario();
        endereco = new Enderecos();
        enderecos =  new EnderecoDAO().buscarTodos();
        
    }

    public void salvar(ActionEvent actionEvent) {
        new FuncionarioDAO().persistir(funcionario);
        funcionarios = new FuncionarioDAO().buscarTodas();
        funcionario = new Funcionarios();
    }

    public void remover(ActionEvent actionEvent) {
        new FuncionarioDAO().remover(funcionario);
        funcionarios = new FuncionarioDAO().buscarTodas();
        funcionario = new Funcionarios();
    }

    public Funcionarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionarios funcionario) {
        this.funcionario = funcionario;
    }

    public List getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List funcionarios) {
        this.funcionarios = funcionarios;
    }
    
      public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }
      
    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public List getTipoFuncionarios() {
        return tipoFuncionarios;
    }

    public void setTipoFuncionarios(List tipoFuncionarios) {
        this.tipoFuncionarios = tipoFuncionarios;
    }
    
    
    
      public void setEndereco(Enderecos endereco) {
        this.endereco = endereco;
    }
      
    public Enderecos getEndereco() {
        return endereco;
    }

    public List getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List enderecos) {
        this.enderecos = enderecos;
    }

}
