/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
@Stateless
public class PessoaCadastro implements PessoaCadastroLocal {
    
    @Inject
    private Connection conn;

    public PessoaCadastro() {
    }

    @Override
    public void inserir(String cpf, String nome) throws SQLException{
        QueryRunner qr = new QueryRunner();
        qr.update(conn,"INSERT INTO PESSOA VALUES(?,?)",cpf,nome);
    }
    
    public Map<String,String> listar() throws SQLException{
        QueryRunner qr = new QueryRunner();
        ResultSetHandler<Map<String,String>> rs = new ResultSetHandler() {
            @Override
            public Map<String,String> handle(ResultSet rs) throws SQLException {
                Map<String,String> map = new HashMap<>();
                while(rs.next()){
                    map.put(rs.getString("cpf"), rs.getString("nome"));
                }
                return map;
            }
        };
      return qr.query(conn, "SELECT * FROM PESSOA", rs);
    }
    
    @PreDestroy
    public void destroy(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
