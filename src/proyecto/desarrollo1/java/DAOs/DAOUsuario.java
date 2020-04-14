
package proyecto.desarrollo1.java.DAOs;


import java.sql.SQLException;
import proyecto.desarrollo1.java.BD.ConsultasBD;
import proyecto.desarrollo1.java.Modelo.Usuario;

public class DAOUsuario {
    
    private ConsultasBD consultorBD = new ConsultasBD();
    
    public int usuarioConsultaLoginPassword_DevuelveActivo(String login, String password) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.usuario_ConsultaLoginPassword_DevuelveActivo(login, password);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public int usuario_ConsultaLogin_DevuelveTipo(String login) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.usuario_ConsultaLogin_DevuelveTipo(login);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public void registrarUsuario(int tipo, String login, String password, String nombre, String apellido, String cedula, String telefono, int activo) throws SQLException
    {
        Usuario user = new Usuario(1, tipo, login, password, nombre, apellido, cedula, telefono, activo);
        consultorBD.empezarConexion();
        consultorBD.registrarUsuario(user);
        consultorBD.cerrarConexion();
    }
    
    public int verificarSiExisteUsuarioConLogin(String login) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.verificarSiExisteUsuarioConLogin(login);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public void modificarUsuario(String loginviejo, int tipo, String nombre, String apellido, String cedula, String telefono, String login, String contraseña) throws SQLException
    {
        consultorBD.empezarConexion();
        consultorBD.modificarUsuario(loginviejo, tipo, nombre, apellido, cedula, telefono, login, contraseña);
        consultorBD.cerrarConexion();
    }
    
    public int verificarEstadoDeUsuarioConLogin(String login) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.verificarEstadoDeUsuarioConLogin(login);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public void cambiarEstadoDeUsuario(String login, int activo) throws SQLException
    {
        consultorBD.empezarConexion();
        consultorBD.cambiarEstadoDeUsuario(login, activo);
        consultorBD.cerrarConexion();
    }
    
    public Usuario consultaUsuario(String login)throws SQLException
    {
        consultorBD.empezarConexion();
        Usuario response = consultorBD.consultaUsuario(login);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public void borrarUsuarioConLogin(String login) throws SQLException
    {
        consultorBD.empezarConexion();
        consultorBD.borrarUsuarioConLogin(login);
        consultorBD.cerrarConexion();
    }
    
}