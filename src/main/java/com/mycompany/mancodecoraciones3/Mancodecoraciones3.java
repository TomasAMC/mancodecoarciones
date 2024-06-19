
package com.mycompany.mancodecoraciones3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mancodecoraciones3 {
    public static void main(String[] args) {
        String usuarios="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/mancodecoraciones3";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuarios, password);
            statement =conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //insertar datos
            statement.execute("INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `email`) VALUES (NULL, 'camila', '', '');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //actualizacion de datos    
            
            statement.execute("UPDATE `usuarios` SET `nombre` = 'santiago', `apellido` = 'guzman', `email` = 'pareja@gmail.com' WHERE `usuarios`.`id` = 3;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //elimar datos
           
            statement.execute("DELETE FROM usuarios WHERE `usuarios`.`id` = 5");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mancodecoraciones3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
