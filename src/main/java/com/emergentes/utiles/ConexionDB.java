
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    static public String driver="com.mysql.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/bd_comercial";
    static public String usuario = "root";
    static public String password = "";

    protected Connection conn = null;

    public ConexionDB() {
        try {
            //especificacion del driver
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            //verificar si la conexion fue exitosa
            if (conn != null){
                System.out.println("Conexion OK: "+ conn);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el driver: " + ex.getMessage());
            
        }catch (SQLException ex){
            System.out.println("Error al realizar la conexion: " + ex.getMessage());
        }
    } 
    
    public Connection conectar()
    {
        return conn;
    }
    public void desconectar()
    {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexion: "+ex.getMessage());
        }
    }

}
