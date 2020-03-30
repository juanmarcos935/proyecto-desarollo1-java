/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.desarrollo1.java.Control;


import java.sql.SQLException;
import proyecto.desarrollo1.java.DB.ConsultasBD;
import proyecto.desarrollo1.java.Modelo.Usuario;

public class DAOUsuario {
    
    private ConsultasBD consultorBD = new ConsultasBD();
    private int autoincrement = 3;
    
    public void registrarUsuario(int tipo, String login, String password, String nombre, String apellido, String cedula, String telefono, int activo) throws SQLException
    {
        Usuario user = new Usuario(autoincrement, tipo, login, password, nombre, apellido, cedula, telefono, activo);
        consultorBD.empezarConexion();
        consultorBD.registrarUsuario(user);
        consultorBD.cerrarConexion();
        autoincrement++;
    }
    
    public int loginUsuarioTipo(String login, String password) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.loginTipo(login, password);
        consultorBD.cerrarConexion();
        return response;
    }
    
    
    public int loginUsuarioActivo(String login, String password) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.loginActivo(login, password);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public int loginUsuarioActivo2(String login) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.loginActivo2(login);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public int loginUsuarioActivo3(String login) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.loginActivo3(login);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public int soloLogin(String login) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.consultaLogin(login);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public void modificarUsuario(String loginviejo, int tipo, String nombre, String apellido, String cedula, String telefono, String login, String contraseña) throws SQLException
    {
        consultorBD.empezarConexion();
        consultorBD.modificarUsuario(loginviejo, tipo, nombre, apellido, cedula, telefono, login, contraseña);
        consultorBD.cerrarConexion();
    }
    
    public void cambiarEstado(String login, int activo) throws SQLException
    {
        consultorBD.empezarConexion();
        consultorBD.cambiarEstado(login, activo);
        consultorBD.cerrarConexion();
    }

}
