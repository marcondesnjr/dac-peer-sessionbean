/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class DataBaseConfig {

    public DataBaseConfig() {
    }
    
    @Produces
    public Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
        Properties prop = new Properties();
        prop.load(this.getClass().getResourceAsStream("/database/db.properties"));
        Class.forName(prop.getProperty("driver"));
        Connection con = DriverManager.getConnection(prop.getProperty("url"), prop);
        return con;
    }
    
}
