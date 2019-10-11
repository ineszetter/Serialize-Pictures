/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JDBCMySQL
 * @author IZETTER 10-10-2019
 */
public class JDBCMySQL {

    private static Connection conn;

    /**
     * IZETTER 10-10-2019
     * Método general de conexión
     * @return Connection
     */
    public Connection connectionDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/fotografias", "root", "passw0rd");
            } catch (SQLException ex) {
                Logger.getLogger(JDBCMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn == null) {
                return null;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    /**
     * IZETTER 10-10-2019
     * Método general de desconexión
     * @param conn
     */
    public void desconectar(Connection conn) {

        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
