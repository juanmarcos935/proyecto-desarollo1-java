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
    
    public void registrarUsuario(int id, String tipo, String login, String password, String nombre, String apellido, int cedula, int telefono, boolean activo) throws SQLException
    {
        Usuario user = new Usuario(id, tipo, login, password, nombre, apellido, cedula, telefono, activo);
        consultorBD.empezarConexion();
        consultorBD.registrarUsuario(user);
        consultorBD.cerrarConexion();
    }

}
