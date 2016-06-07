/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
@Named
@RequestScoped
public class PessoaManagedBean {
    private String cpf;
    private String nome;

    public PessoaManagedBean() {
    }

    public void cadastrar() throws NamingException, SQLException, IOException{
        InitialContext ic = new InitialContext();
        PessoaCadastroLocal pc = (PessoaCadastroLocal) ic.lookup("java:global/ejbexemplo-ejb/PessoaCadastro!io.github.marcondesnjr.PessoaCadastroLocal");
        pc.inserir(cpf, nome);
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.redirect("pessoas.jsf");
    }
    
    public Map<String,String> listar() throws NamingException, SQLException{
        InitialContext ic = new InitialContext();
        PessoaCadastroLocal pc = (PessoaCadastroLocal) ic.lookup("java:global/ejbexemplo-ejb/PessoaCadastro!io.github.marcondesnjr.PessoaCadastroLocal");
        return pc.listar();
    }
    
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

}
