/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.desarrollo1.java.DB;

import proyecto.desarrollo1.java.Modelo.Cliente;
import proyecto.desarrollo1.java.Modelo.Usuario;

import proyecto.desarrollo1.java.Vista.JFramePrincipal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author chatarrita
 */
public class ConsultasBD {
    
    private AccesoBD accesobd;
    private Connection connec;
    
    public void empezarConexion()
    {
        connec = accesobd.conectarBD();
    }
    
    public void cerrarConexion() throws SQLException
    {
        accesobd.cerrarConexion(connec);
    }
    
    public String login(String login, String password) throws SQLException
    {
        String consulta_sql_login = "SELECT * FROM usuario WHERE usuario_login='" + login + "' AND usuario_password='" + password + "';";
        Statement st = connec.createStatement();
        ResultSet rs = st.executeQuery(consulta_sql_login);
        if(rs.next())
        {
            String consulta_sql2 = "SELECT usuario_tipo FROM usuario WHERE usuario_login='" + login + "' AND usuario_password='" + password + "';";
            Statement st2 = connec.createStatement();
            ResultSet rs2 = st2.executeQuery(consulta_sql2);
            String tipo = rs2.getString("usuario_tipo");
            return tipo;
        }
        else
        {
            return "FALLIDO";
        }
    }
    
}
