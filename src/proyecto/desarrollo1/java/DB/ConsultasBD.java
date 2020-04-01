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
    
    public int consultaLogin(String login) throws SQLException
    {
        String consulta_sql_login = "SELECT * FROM usuario WHERE usuario_login='" + login + "';";
        Statement st = connec.createStatement();
        ResultSet rs = st.executeQuery(consulta_sql_login);
        if(rs.next())
        {   
            System.out.println("Si hay usuario valido");
            return 1;
        }
        else
        {
            return -1;
        }
    }
    
    public int loginActivo2(String login) throws SQLException
    {
        String consulta_sql_login = "SELECT * FROM usuario WHERE usuario_login='" + login + "';";
        Statement st = connec.createStatement();
        ResultSet rs = st.executeQuery(consulta_sql_login);
        if(rs.next())
        {   
            System.out.println("Por ahora login y contraseña exitosos");
            int activo = 0;
            activo = rs.getInt(9);
            return activo;
        }
        else
        {
            return -1;
        }
    }
    
    public int loginActivo3(String login) throws SQLException
    {
        int activo = 0;
        String consulta_sql_login = "SELECT * FROM usuario WHERE usuario_login='" + login + "';";
        Statement st = connec.createStatement();
        ResultSet rs = st.executeQuery(consulta_sql_login);
        if(rs.next())
        {   
            activo = rs.getInt(9);
            return activo;
        }
        else
        {
            return -1;
        }
    }
    
    public int loginTipo(String login, String password) throws SQLException
    {
        String consulta_sql_login = "SELECT * FROM usuario WHERE usuario_login='" + login + "' AND usuario_password='" + password + "';";
        Statement st = connec.createStatement();
        ResultSet rs = st.executeQuery(consulta_sql_login);
        if(rs.next())
        {   
            System.out.println("Por ahora login y contraseña exitosos");
            int tipo = 0;
            tipo = rs.getInt(2);
            return tipo;
        }
        else
        {
            return -1;
        }
    }
    
    public int soloLoginTipo(String login) throws SQLException
    {
        String consulta_sql_login = "SELECT * FROM usuario WHERE usuario_login='" + login + "'" + ";";
        Statement st = connec.createStatement();
        ResultSet rs = st.executeQuery(consulta_sql_login);
        if(rs.next())
        {   
            int tipo = 0;
            tipo = rs.getInt(2);
            return tipo;
        }
        else
        {
            return -1;
        }
    }
    
    public int loginActivo(String login, String password) throws SQLException
    {
        String consulta_sql_login = "SELECT * FROM usuario WHERE usuario_login='" + login + "' AND usuario_password='" + password + "';";
        Statement st = connec.createStatement();
        ResultSet rs = st.executeQuery(consulta_sql_login);
        if(rs.next())
        {   
            int activo = 0;
            activo = rs.getInt(9);
            return activo;
        }
        else
        {
            return -1;
        }
    }
    

    
    
    
    public void registrarUsuario(Usuario user) throws SQLException
    {
        int operacion;
        String consulta_sql_registrar_usuario = "INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apellidos, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, " + user.getTipo() + ", '" + user.getLogin() + "', '" + user.getPassword() + "', '" + user.getNombre() + "', '" + user.getApellido() + "', '" + user.getCedula() + "', '" + user.getTelefono() + "', " + user.getActivo() + ");";
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
    
    public void registrarCliente(Cliente client) throws SQLException
    {
        int operacion;
        String consulta_sql_registrar_cliente = "INSERT INTO cliente (id_cliente, cliente_tipo, cliente_nombre, cliente_apellidos, cliente_direccion, cliente_ciudad, cliente_cc, cliente_estado) VALUES (default, " + client.getTipo() + ", '" + client.getNombre() + "', '" + client.getApellido() + "', '" + client.getDireccion() + "', '" + client.getCiudad() + "', '" + client.getCedula() + "', default);";
        try
        {
            Statement st = connec.createStatement();
            operacion = st.executeUpdate(consulta_sql_registrar_cliente);
            System.out.println("Registro de cliente exitoso");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void cambiarEstado(String loginviejo, int activo)
    {
        int operacion;
        String consulta = "UPDATE usuario SET usuario_estado = " + activo + " WHERE usuario_login = '" + loginviejo + "';";
        try
        {
            Statement st = connec.createStatement();
            operacion = st.executeUpdate(consulta);
            System.out.println("Modificacion de estado de usuario exitosa");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void modificarUsuario(String loginviejo, int tipo, String nombre, String apellido, String cedula, String telefono, String login, String contraseña) throws SQLException
    {
        int operacion;
        String string1 = "";
        String string2 = "";
        String string3 = "";
        String string4 = "";
        String string5 = "";
        String string6 = "";
        String string7 = "";
        switch (tipo) {
            case 1:
                string1 = "usuario_tipo = 1";
                break;
            case 2:
                string1 = "usuario_tipo = 2";
                break;
            case 3:
                string1 = "usuario_tipo = 3";
                break;
            default:
                break;
        }
        
        if(!nombre.equals(""))
        {
            string2 = ", usuario_nombre = '" + nombre + "'";
        }
        
        if(!apellido.equals(""))
        {
            string3 = ", usuario_apellidos = '" + apellido + "'";
        }
        
        if(!cedula.equals(""))
        {
            string4 = ", usuario_cc = '" + cedula + "'";
        }
        
        if(!telefono.equals(""))
        {
            string5 = ", usuario_telefono = '" + telefono  + "'";
        }
        
        if(!login.equals(""))
        {
            string6 = ", usuario_login = '" + login + "'";
        }
        
        if(!contraseña.equals(""))
        {
            string7 = ", usuario_password = '" + contraseña + "'";
        }
        
        String consulta_sql_modificar_usuario = "UPDATE usuario SET " + string1 + string2 + string3 + string4 + string5 + string6 + string7 + " WHERE usuario_login='" + loginviejo + "';";
        System.out.println(consulta_sql_modificar_usuario);
        
        try
        {
            Statement st = connec.createStatement();
            operacion = st.executeUpdate(consulta_sql_modificar_usuario);
            System.out.println("Modificacion de usuario exitosa");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    
}
