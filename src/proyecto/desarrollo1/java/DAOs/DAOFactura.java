
package proyecto.desarrollo1.java.DAOs;

import java.sql.SQLException;
import proyecto.desarrollo1.java.BD.ConsultasBD;
import proyecto.desarrollo1.java.Modelo.Factura;


public class DAOFactura {
    
    private ConsultasBD consultorBD = new ConsultasBD();
    
    public int existePlanConLinea(String linea) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.existePlanConLinea(linea);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public String obtenerNombrePlanConID(int id_plan) throws SQLException
    {
        consultorBD.empezarConexion();
        String response = consultorBD.obtenerNombrePlanConID(id_plan);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public int obtenerIDContratoConLinea(String linea) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.obtenerIDContratoConLinea(linea);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public int obtenerIDPlanConLinea(String linea) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.obtenerIDPlanConLinea(linea);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public String obtenerCedulaClienteconID(int id_cliente) throws SQLException
    {
        consultorBD.empezarConexion();
        String response = consultorBD.obtenerCedulaClienteconID(id_cliente);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public String obtenerNombreCompletoClienteconID(int id_cliente) throws SQLException
    {
        consultorBD.empezarConexion();
        String response = consultorBD.obtenerNombreCompletoClienteconID(id_cliente);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public String obtenerDireccionClienteconID(int id_cliente) throws SQLException
    {
        consultorBD.empezarConexion();
        String response = consultorBD.obtenerDireccionClienteconID(id_cliente);
        consultorBD.cerrarConexion();
        return response;
    }
    
    
    
}
