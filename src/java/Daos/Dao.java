/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Exception.DaoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author d00133633
 */
public class Dao {

    private DataSource datasource;
    /**
     *takes in the source of database connections and stores it
     * @param myDataSource the data source is passed in so the dao can access the database
     */
        public Dao(DataSource myDataSource) {
        this.datasource = myDataSource;
    } 

    /**
     *for pooled connections
     * exceptions go to the catch were the datasource is made, its a fix so Junit will work
     * the database context is also in the context.xml file so if its changed here it must be changed there too
     */
        public Dao() {
        final String DATASOURCE_CONTEXT = "jdbc/database";
        try {
            Context initialContext = new InitialContext();
            DataSource ds = (DataSource) initialContext.lookup("java:comp/env/" + DATASOURCE_CONTEXT);
            if (ds != null) {
                datasource = ds;
            }
        } catch (Exception ex) {
            datasource = new MyDataSource();
        }
    }
    /**
     *Pooled getConnection
     * @return conn which is the connection to the datasource
     * @throws DaoException is thrown if something is wrong with the dao
     * like if the context info was not matching
     */
        public Connection getConnection() throws DaoException {
        Connection conn = null;
        try {
            if (datasource != null) {
                conn = datasource.getConnection();
            } else {
                System.out.println(("Failed to lookup datasource."));
            }
        } catch (SQLException ex2) {
            System.out.println("Connection failed " + ex2.getMessage());
            System.exit(2); // exit
        }
        return conn;
    }

    /**
     *closes the connection to the datasource
     * @param con the conection to the datasource is passed in so it can be closed
     * @throws DaoException is thrown if something is wrong with the dao
     * like if the context info was not matching
     */
    public void freeConnection(Connection con) throws DaoException {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to free connection: " + e.getMessage());
            System.exit(1);
        }
    }
}
