/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.desarrollo1.java.Control;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public int clienteIdConCedula(String cedula) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.clienteIdConCedula(cedula);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public int planIdConNombre(String plan_nombre) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.planIdConNombre(plan_nombre);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public void registrarPlan(int id_plan, int id_cliente, String telefono) throws SQLException
    {
        consultorBD.empezarConexion();
        consultorBD.registrarPlan(id_plan, id_cliente, telefono);
        consultorBD.cerrarConexion();
    }
    
    public int contratoIdConIdPlanIdClienteTelefono(int id_plan, int id_cliente, String telefono) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.contratoIdConIdPlanIdClienteTelefono(id_plan, id_cliente, telefono);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public void registrarGerentePlan(int id_contrato, int id_usuario) throws SQLException
    {
        consultorBD.empezarConexion();
        consultorBD.registrarGerentePlan(id_contrato, id_usuario);
        consultorBD.cerrarConexion();
    }
    
        public void cambiarEstado(String cedula, int nuevo) throws SQLException
    {
        consultorBD.empezarConexion();
        consultorBD.cambiarEstadoCliente(cedula, nuevo);
        consultorBD.cerrarConexion();
    }
}
