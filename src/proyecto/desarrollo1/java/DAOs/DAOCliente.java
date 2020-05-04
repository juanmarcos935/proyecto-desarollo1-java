
package proyecto.desarrollo1.java.DAOs;

import java.sql.SQLException;
import proyecto.desarrollo1.java.BD.ConsultasBD;
import proyecto.desarrollo1.java.Modelo.Cliente;

public class DAOCliente {
    
    private ConsultasBD consultorBD = new ConsultasBD();
    
    public void registrarCliente(int tipo, String nombre, String apellido, String direccion, String ciudad, String cedula) throws SQLException
    {
        Cliente client = new Cliente(1, tipo, nombre, apellido, direccion, ciudad, cedula, 1);
        consultorBD.empezarConexion();
        consultorBD.registrarCliente(client);
        consultorBD.cerrarConexion();
    }
    
    public int verificarSiExisteClienteConCedula(String cedula) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.verificarSiExisteClienteConCedula(cedula);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public int obtenerTipoClienteConCedula(String cedula) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.obtenerTipoClienteConCedula(cedula);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public Cliente consultaCliente(String cedula) throws SQLException
    {
        consultorBD.empezarConexion();
        Cliente response = consultorBD.consultaCliente(cedula);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public void modificarCliente(String documento_cliente, int tipo, String nombre, String apellido , String direccion,String ciudad) throws SQLException
    {
        consultorBD.empezarConexion();
        consultorBD.modificarCliente(documento_cliente, tipo, nombre, apellido, direccion, ciudad);
        consultorBD.cerrarConexion();
    }
    
    public void cambiarEstadoDeCliente(String cedula, int nuevo) throws SQLException
    {
        consultorBD.empezarConexion();
        consultorBD.cambiarEstadoDeCliente(cedula, nuevo);
        consultorBD.cerrarConexion();
    }
    
    public int obtenerEstadoClienteConCedula(String cedula) throws SQLException
    {
        consultorBD.empezarConexion();
        int respuesta = consultorBD.obtenerEstadoClienteConCedula(cedula);
        consultorBD.cerrarConexion();
        return respuesta;
    }
    
    public void borrarClienteConCedula(String cedula) throws SQLException
    {
        consultorBD.empezarConexion();
        consultorBD.borrarClienteConCedula(cedula);
        consultorBD.cerrarConexion();
    }
    
    public int obtenerIDClienteConCedula(String cedula) throws SQLException
    {
        consultorBD.empezarConexion();
        int respuesta = consultorBD.obtenerIDClienteConCedula(cedula);
        consultorBD.cerrarConexion();
        return respuesta;
    }
    
    public int obtenerIDPlanConNombre(String nombre_plan) throws SQLException
    {
        consultorBD.empezarConexion();
        int respuesta = consultorBD.obtenerIDPlanConNombre(nombre_plan);
        consultorBD.cerrarConexion();
        return respuesta;
    }
    
    public void registrarPlan(int id_plan, int id_cliente, String linea, int opcion_renovacion) throws SQLException
    {
        consultorBD.empezarConexion();
        consultorBD.registrarPlan(id_plan, id_cliente, linea, opcion_renovacion);
        consultorBD.cerrarConexion();
    }
    
}
