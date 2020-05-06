
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
    
    public int obtenerIDContratoConLinea(String linea) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.obtenerIDContratoConLinea(linea);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public int obtenerIDClienteConLinea(String linea) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.obtenerIDClienteConLinea(linea);
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
    
    public String obtenerCiudadClienteconID(int id_cliente) throws SQLException
    {
        consultorBD.empezarConexion();
        String response = consultorBD.obtenerCiudadClienteconID(id_cliente);
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
    
    public int obtenerOpcionRenovacionConLinea(String linea) throws SQLException
    {
        consultorBD.empezarConexion();
        int response = consultorBD.obtenerOpcionRenovacionConLinea(linea);
        consultorBD.cerrarConexion();
        return response;
    }
    
    public int obtenerCostoPlanConID(int id_plan) throws SQLException
    {
       consultorBD.empezarConexion();
       int response = consultorBD.obtenerCostoPlanConID(id_plan);
       consultorBD.cerrarConexion();
       return response; 
    }
    
    public int obtenerMinutosPlanConID(int id_plan) throws SQLException
    {
       consultorBD.empezarConexion();
       int response = consultorBD.obtenerMinutosPlanConID(id_plan);
       consultorBD.cerrarConexion();
       return response; 
    }
    
    public double obtenerDatosPlanConID(int id_plan) throws SQLException
    {
       consultorBD.empezarConexion();
       double response = consultorBD.obtenerDatosPlanConID(id_plan);
       consultorBD.cerrarConexion();
       return response; 
    }
    
    public int obtenerMensajesPlanConID(int id_plan) throws SQLException
    {
       consultorBD.empezarConexion();
       int response = consultorBD.obtenerMensajesPlanConID(id_plan);
       consultorBD.cerrarConexion();
       return response; 
    }
    
    public int obtenerMinutosWhatsappPlanConID(int id_plan) throws SQLException
    {
       consultorBD.empezarConexion();
       int response = consultorBD.obtenerMinutosWhatsappPlanConID(id_plan);
       consultorBD.cerrarConexion();
       return response; 
    }
    
    public int obtenerChatWhatsappPlanConID(int id_plan) throws SQLException
    {
       consultorBD.empezarConexion();
       int response = consultorBD.obtenerChatWhatsappPlanConID(id_plan);
       consultorBD.cerrarConexion();
       return response; 
    }
    
    public int obtenerFacebookPlanConID(int id_plan) throws SQLException
    {
       consultorBD.empezarConexion();
       int response = consultorBD.obtenerFacebookPlanConID(id_plan);
       consultorBD.cerrarConexion();
       return response; 
    }
    
    public void registrarFactura(int id_contrato, String cc_cliente, String nombre_cliente, String direccion_cliente, String ciudad_cliente, String nombre_plan, String linea, int consumo_minutos, double consumo_datos, int consumo_mensajes, int consumo_minutos_whatsapp, int consumo_chat_whatsapp, int consumo_facebook, int consumo_waze, int consumo_llamada_eeuu, int consumo_llamada_canada, int consumo_llamada_puertorico, double consumo_datos_compartir, int cargo_basico, double cargo_min_adicionales, int cargo_renovaciones, int ajuste_peso, int total_pago, String fecha_expedicion, String fecha_vencimiento) throws SQLException
    {
        consultorBD.empezarConexion();
        consultorBD.registrarFactura(id_contrato, cc_cliente, nombre_cliente, direccion_cliente, ciudad_cliente, nombre_plan, linea, consumo_minutos, consumo_datos, consumo_mensajes, consumo_minutos_whatsapp, consumo_chat_whatsapp, consumo_facebook, consumo_waze, consumo_llamada_eeuu, consumo_llamada_canada, consumo_llamada_puertorico, consumo_datos_compartir, cargo_basico, cargo_min_adicionales, cargo_renovaciones, ajuste_peso, total_pago, fecha_expedicion, fecha_vencimiento);
        consultorBD.cerrarConexion();
    }
    
    public Factura obtenerFacturaStringPDF(String linea, String fecha_expedicion) throws SQLException
    {
        consultorBD.empezarConexion();
        Factura factura = consultorBD.obtenerFacturaStringPDF(linea, fecha_expedicion);
        consultorBD.cerrarConexion();
        return factura;
    }
    
}
