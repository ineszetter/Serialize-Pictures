/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.DataAdapters;

import Persistencia.JDBCMySQL;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * tblFotografiasAdapter
 * @author IZETTER 10-10-2019
 */
public class tblFotografiasAdapter {
    
    JDBCMySQL conn = new JDBCMySQL();
    Connection c = null;
    
    /**
     * Método general de inserción a tblfotos
     * IZETTER 10-10-2019
     * @param titulo
     * @param imagen
     * @return int / id de imagen
     */
    public int Insert(String titulo, FileInputStream imagen) {
     int exito = 0;
        try {
            
            c = conn.connectionDB();

            PreparedStatement stmt;
            stmt = c.prepareStatement("INSERT INTO tblfotografias "
                    + "(titulo"
                    + ",imagen) "
                    + "VALUES (?,?);");

            stmt.setString(1, titulo);
            stmt.setBlob(2, imagen);
            exito = stmt.executeUpdate();

            stmt.close();
            return exito;
        } catch (SQLException ex) {
            Logger.getLogger(tblFotografiasAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.desconectar(c);
        }
        return exito;
    }

}
