/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.servico.Pessoa;
import br.edu.ifsul.servico.ServicoPessoaService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Matheus
 */
@Stateless
public class PessoaDAO implements Serializable {
    
    private ServicoPessoaService cliente;
    
    public PessoaDAO(){
        cliente = new ServicoPessoaService();
    }
    
    public List<Pessoa> getListaPessoas(){
        return cliente.getServicoPessoaPort().listaPessoas();
    }
    
    public void inserir(Pessoa obj){
        cliente.getServicoPessoaPort().inserir(obj);
    }
    
    public void alterar(Pessoa obj){
        cliente.getServicoPessoaPort().alterar(obj);
    }    
    
    public void remover(Integer id){
        cliente.getServicoPessoaPort().remover(id);
    }

    public ServicoPessoaService getCliente() {
        return cliente;
    }

    public void setCliente(ServicoPessoaService cliente) {
        this.cliente = cliente;
    }
}

