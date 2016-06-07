/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.ejbexemplo.desk;

import io.github.marcondesnjr.PessoaCadastroLocal;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class Main {
    public static void main(String[] args) throws SQLException, NamingException, IOException {
        while(true){
           Properties props = new Properties();
            props.load(new FileInputStream("jndi.properties"));
            InitialContext ctx = new InitialContext(props);
            PessoaCadastroLocal pc = (PessoaCadastroLocal) ctx.lookup("java:global/ejbexemplo-ejb/PessoaCadastro!io.github.marcondesnjr.PessoaCadastroLocal");
            Map<String, String> pessoas = pc.listar();
            for(String key:pessoas.keySet()){
                System.out.println(key + " : " + pessoas.get(key));
            }
        }
    }
}
