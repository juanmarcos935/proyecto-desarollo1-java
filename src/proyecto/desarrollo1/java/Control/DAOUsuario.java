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
    
    public void registrarUsuario(int tipo, String login, String password, String nombre, String apellido, int cedula, int telefono, int activo) throws SQLException
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


}
