package proyecto.desarrollo1.java.Modelo;

public class Factura {

    private String id_factura;
    private String id_contrato;
    private String cc_cliente;
    private String nombre_cliente;
    private String direccion_cliente;
    private String ciudad_cliente;
    private String nombre_plan;
    private String linea;
    private String consumo_minutos;
    private String consumo_datos;
    private String consumo_mensajes;
    private String consumo_minutos_whatsapp;
    private String consumo_chat_whatsapp;
    private String consumo_facebook;
    private String consumo_waze;
    private String consumo_llamada_eeuu;
    private String consumo_llamada_canada;
    private String consumo_llamada_puertorico;
    private String consumo_datos_compartir;
    private String cargo_basico;
    private String cargo_min_adicionales;
    private String cargo_renovaciones;
    private String ajuste_peso;
    private String total_pago;
    private String fecha_expedicion;
    private String fecha_vencimiento;

    public Factura(String id_factura, String id_contrato, String cc_cliente, String nombre_cliente, String direccion_cliente, String ciudad_cliente, String nombre_plan, String linea, String consumo_minutos, String consumo_datos, String consumo_mensajes, String consumo_minutos_whatsapp, String consumo_chat_whatsapp, String consumo_facebook, String consumo_waze, String consumo_llamada_eeuu, String consumo_llamada_canada, String consumo_llamada_puertorico, String consumo_datos_compartir, String cargo_basico, String cargo_min_adicionales, String cargo_renovaciones, String ajuste_peso, String total_pago, String fecha_expedicion, String fecha_vencimiento) {
        this.id_factura = id_factura;
        this.id_contrato = id_contrato;
        this.cc_cliente = cc_cliente;
        this.nombre_cliente = nombre_cliente;
        this.direccion_cliente = direccion_cliente;
        this.ciudad_cliente = ciudad_cliente;
        this.nombre_plan = nombre_plan;
        this.linea = linea;
        this.consumo_minutos = consumo_minutos;
        this.consumo_datos = consumo_datos;
        this.consumo_mensajes = consumo_mensajes;
        this.consumo_minutos_whatsapp = consumo_minutos_whatsapp;
        this.consumo_chat_whatsapp = consumo_chat_whatsapp;
        this.consumo_facebook = consumo_facebook;
        this.consumo_waze = consumo_waze;
        this.consumo_llamada_eeuu = consumo_llamada_eeuu;
        this.consumo_llamada_canada = consumo_llamada_canada;
        this.consumo_llamada_puertorico = consumo_llamada_puertorico;
        this.consumo_datos_compartir = consumo_datos_compartir;
        this.cargo_basico = cargo_basico;
        this.cargo_min_adicionales = cargo_min_adicionales;
        this.cargo_renovaciones = cargo_renovaciones;
        this.ajuste_peso = ajuste_peso;
        this.total_pago = total_pago;
        this.fecha_expedicion = fecha_expedicion;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getId_factura() {
        return id_factura;
    }

    public String getId_contrato() {
        return id_contrato;
    }

    public String getCc_cliente() {
        return cc_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public String getCiudad_cliente() {
        return ciudad_cliente;
    }

    public String getNombre_plan() {
        return nombre_plan;
    }

    public String getLinea() {
        return linea;
    }

    public String getConsumo_minutos() {
        return consumo_minutos;
    }

    public String getConsumo_datos() {
        return consumo_datos;
    }

    public String getConsumo_mensajes() {
        return consumo_mensajes;
    }

    public String getConsumo_minutos_whatsapp() {
        return consumo_minutos_whatsapp;
    }

    public String getConsumo_chat_whatsapp() {
        return consumo_chat_whatsapp;
    }

    public String getConsumo_facebook() {
        return consumo_facebook;
    }

    public String getConsumo_waze() {
        return consumo_waze;
    }

    public String getConsumo_llamada_eeuu() {
        return consumo_llamada_eeuu;
    }

    public String getConsumo_llamada_canada() {
        return consumo_llamada_canada;
    }

    public String getConsumo_llamada_puertorico() {
        return consumo_llamada_puertorico;
    }

    public String getConsumo_datos_compartir() {
        return consumo_datos_compartir;
    }

    public String getCargo_basico() {
        return cargo_basico;
    }

    public String getCargo_min_adicionales() {
        return cargo_min_adicionales;
    }

    public String getCargo_renovaciones() {
        return cargo_renovaciones;
    }

    public String getAjuste_peso() {
        return ajuste_peso;
    }

    public String getTotal_pago() {
        return total_pago;
    }

    public String getFecha_expedicion() {
        return fecha_expedicion;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    
    

    
}
