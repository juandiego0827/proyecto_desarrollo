/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.desarrollo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class ConexionBD {
    Connection conexion=null;
    String url="jdbc:postgresql://queenie.db.elephantsql.com:5432/gvlglauf";
    String usuario="gvlglauf";
    String contrasenia="ad65Xl6wqHk-G1_L9ro8func2C7nGQLC";
    
    public Connection conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            conexion =DriverManager.getConnection(url, usuario, contrasenia);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar "+e);
        }
        return conexion;
    }
    
    public void cerrar() throws SQLException{
        conexion.close();
    }
}