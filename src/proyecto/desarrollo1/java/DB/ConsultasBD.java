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
    
    private AccesoBD accesobd = new AccesoBD();
    private Connection connec;
    
    public void empezarConexion() throws SQLException
    {
        connec = accesobd.getConnection();
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
            System.out.println("Por ahora login y contraseña exitosos");
            System.out.println(rs.getString(2));
            return rs.getString(2).toString();
        }
        else
        {
            return "FALLIDO";
        }
    }
    
    
    
    public void registrarUsuario(Usuario user) throws SQLException
    {
        int operacion;
        String consulta_sql_registrar_usuario = "INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apelldios, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, '" + user.getTipo() + "', '" + user.getLogin() + "', '" + user.getPassword() + "', '" + user.getNombre() + "', '" + user.getApellido() + "', " + user.getCedula() + ", " + user.getTelefono() + ", " + user.isActivo() + ");";
        try
        {
            Statement st = connec.createStatement();
            operacion = st.executeUpdate(consulta_sql_registrar_usuario);
            System.out.println("Registro de usuario exitoso");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
