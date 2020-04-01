/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.desarrollo1.java.Control;

import java.sql.SQLException;
import proyecto.desarrollo1.java.DB.ConsultasBD;
import proyecto.desarrollo1.java.Modelo.Cliente;

/**
 *
 * @author chatarrita
 */
public class DAOCliente {
    
    private ConsultasBD consultorBD = new ConsultasBD();
    
    public void registrarCliente(int tipo, String nombre, String apellido, String direccion, String ciudad, String cedula) throws SQLException
    {
        Cliente client = new Cliente(1, tipo, nombre, apellido, direccion, ciudad, cedula, 1);
        consultorBD.empezarConexion();
        consultorBD.registrarCliente(client);
        consultorBD.cerrarConexion();
    }
    
    public int loginClienteEstado(String cedula) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.clienteEstado(cedula);
        consultorBD.cerrarConexion();
        return response;
    }
    
}
