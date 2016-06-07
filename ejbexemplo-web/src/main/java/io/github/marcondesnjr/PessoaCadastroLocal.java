/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr;

import java.sql.SQLException;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
@Remote
public interface PessoaCadastroLocal {
    public void inserir(String cpf, String nome) throws SQLException;
    public Map<String,String> listar() throws SQLException;
}
