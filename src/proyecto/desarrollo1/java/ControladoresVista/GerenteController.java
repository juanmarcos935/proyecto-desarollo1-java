
package proyecto.desarrollo1.java.ControladoresVista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import proyecto.desarrollo1.java.DAOs.DAOCliente;
import proyecto.desarrollo1.java.Modelo.Cliente;
import proyecto.desarrollo1.java.DAOs.DAOFactura;
import proyecto.desarrollo1.java.Modelo.Factura;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GerenteController implements Initializable{
    
    @FXML
    private Label borrarClientesLabel;

    @FXML
    private JFXTextField cedulaClienteRegistroTF;

    @FXML
    private JFXTextField nombreClienteRegistroTF;

    @FXML
    private JFXTextField direccionClienteRegistroTF;

    @FXML
    private JFXTextField muestraApellidoTFCliente;

    @FXML
    private JFXButton botonRegistroCliente;

    @FXML
    private JFXTextField cedulaConsultaClienteTF;

    @FXML
    private JFXButton botonBuscarActivarInactivarCliente;

    @FXML
    private Label consultarClientesLabel;

    @FXML
    private Label modificacionClienteLabel;

    @FXML
    private JFXButton botonBuscarConsultaCliente;

    @FXML
    private JFXButton botonBorrarCliente;

    @FXML
    private JFXTextField apellidoClienteMODRegistroTF;

    @FXML
    private JFXTextField muestraCiudadTFCliente;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXButton botonCerrarSesion;

    @FXML
    private JFXTextField ciudadClienteMODRegistroTF;

    @FXML
    private Label muestraDireccionLabelCliente;

    @FXML
    private JFXButton botonBuscarCedulaModificar;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXTextField direccionClienteMODRegistroTF;

    @FXML
    private JFXButton mostrarInfoBotonConsultaCliente;

    @FXML
    private JFXTextField apellidoClienteRegistroTF;

    @FXML
    private JFXTextField cedulaBuscarActivarInactivarClienteTF;

    @FXML
    private JFXTextField muestraEstadoTFCliente;

    @FXML
    private Label muestraCiudadLabelCliente;

    @FXML
    private JFXTextField ciudadClienteRegistroTF;

    @FXML
    private JFXTextField muestraNombreTFCliente;

    @FXML
    private JFXButton botonBuscarClienteBorrar;

    @FXML
    private JFXTextField muestraTipoTFCliente;

    @FXML
    private Label activarInactivarClienteLabel;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXComboBox<String> comboBoxActivarInactivarCliente;

    @FXML
    private Label muestraTipoLabelCliente;

    @FXML
    private JFXComboBox<String> tipoMODClienteComboBox;

    @FXML
    private JFXComboBox<String> tipoClienteComboBox;

    @FXML
    private JFXButton botonModificarCliente;

    @FXML
    private JFXButton botonGuardarCambiosActivarInactivarCliente;

    @FXML
    private Label muestraNombreLabelCliente;

    @FXML
    private Label muestraEstadoLabelCliente;

    @FXML
    private JFXTextField muestraDireccionTFCliente;

    @FXML
    private JFXTextField cedulaClienteMODRegistroTF;

    @FXML
    private JFXTextField nombreClienteMODRegistroTF;

    @FXML
    private Label registroClienteLabel;

    @FXML
    private JFXTextField cedulaClienteABorrarTF;

    @FXML
    private Label muestraApellidoLabelCliente;
    
    @FXML
    private Label asociarVentaPlanConCliente;
    
    @FXML 
    private JFXTextField cedulaClientePlan;
    
    @FXML
    private JFXButton botonBuscarCedulaClientePlan;
    
    @FXML
    private JFXComboBox<String> comboBoxPlan;
    
    @FXML
    private JFXTextField lineaTelefonicaPlan;
    
    @FXML
    private JFXButton botonAsociarPlanCliente;
    
    @FXML
    private JFXComboBox<String> opcionRenovacionLineaComboBox;
    
    @FXML
    private JFXButton botonInformacionRenovacion;
    
    @FXML
    private Label facturacionLabel;
    
    @FXML
    private JFXTextField lineaFacturaTF;
    
    @FXML
    private JFXButton botonBuscarFactura;
    
    @FXML
    private JFXButton botonGenerarFactura;
    
    @FXML
    void botonGenerarFacturaAction(ActionEvent event) throws JRException, FileNotFoundException, IOException {
        try {
            
            String linea = lineaFacturaTF.getText();
            
            DAOFactura daofactura = new DAOFactura();
            
            int opc_renov = daofactura.obtenerOpcionRenovacionConLinea(linea);
            boolean opcion_renovacion = false;
            
            if(opc_renov == 0)
            {
                opcion_renovacion = false;
            }
            else if(opc_renov == 1)
            {
                opcion_renovacion = true;
            }
            
            int id_contrato = daofactura.obtenerIDContratoConLinea(linea);
            int id_cliente = daofactura.obtenerIDClienteConLinea(linea);
            int id_plan = daofactura.obtenerIDPlanConLinea(linea);
            
            String cc_cliente = daofactura.obtenerCedulaClienteconID(id_cliente);
            String nombre_cliente = daofactura.obtenerNombreCompletoClienteconID(id_cliente);
            String direccion_cliente = daofactura.obtenerDireccionClienteconID(id_cliente);
            String ciudad_cliente = daofactura.obtenerCiudadClienteconID(id_cliente);
            
            String nombre_plan = daofactura.obtenerNombrePlanConID(id_plan);

            
            
            int consumo_minutos = 0;
            double consumo_datos = 0;
            int consumo_mensajes = 0;
            int consumo_minutos_whatsapp = 0;
            int consumo_chat_whatsapp = 0;
            int consumo_facebook = 0;
            
            int consumo_waze = 0;
            int consumo_llamada_eeuu = 0;
            int consumo_llamada_canada = 0;
            int consumo_llamada_puertorico = 0;
            double consumo_datos_compartir = 0;
            
            switch(id_plan)
            {
                case 1:
                    consumo_minutos = obtenerConsumoMinutos(daofactura.obtenerMinutosPlanConID(id_plan));
                    consumo_datos = obtenerConsumoDatos(daofactura.obtenerDatosPlanConID(id_plan), opcion_renovacion);
                    consumo_mensajes = obtenerConsumoMensajes(daofactura.obtenerMensajesPlanConID(id_plan), opcion_renovacion);
                    consumo_minutos_whatsapp = obtenerConsumoMinutosWhatsapp(daofactura.obtenerMinutosWhatsappPlanConID(id_plan), opcion_renovacion);
                    consumo_chat_whatsapp = obtenerConsumoChatWhatsapp(daofactura.obtenerChatWhatsappPlanConID(id_plan), opcion_renovacion);
                    consumo_facebook = obtenerConsumoFacebook(daofactura.obtenerFacebookPlanConID(id_plan), opcion_renovacion);

                    consumo_waze = 0;
                    consumo_llamada_eeuu = 0;
                    consumo_llamada_canada = 0;
                    consumo_llamada_puertorico = 0;
                    consumo_datos_compartir = 0;
                    break;
                case 2:
                    consumo_minutos = obtenerConsumoMinutos(daofactura.obtenerMinutosPlanConID(id_plan));
                    consumo_datos = obtenerConsumoDatos(daofactura.obtenerDatosPlanConID(id_plan), opcion_renovacion);
                    consumo_mensajes = obtenerConsumoMensajes(daofactura.obtenerMensajesPlanConID(id_plan), opcion_renovacion);
                    consumo_minutos_whatsapp = obtenerConsumoMinutosWhatsapp(daofactura.obtenerMinutosWhatsappPlanConID(id_plan), opcion_renovacion);
                    consumo_chat_whatsapp = obtenerConsumoChatWhatsapp(daofactura.obtenerChatWhatsappPlanConID(id_plan), opcion_renovacion);
                    consumo_facebook = obtenerConsumoFacebook(daofactura.obtenerFacebookPlanConID(id_plan), opcion_renovacion);

                    consumo_waze = 0;
                    consumo_llamada_eeuu = 0;
                    consumo_llamada_canada = 0;
                    consumo_llamada_puertorico = 0;
                    consumo_datos_compartir = 0;
                    break;
                case 3:
                    consumo_minutos = obtenerConsumoMinutos(daofactura.obtenerMinutosPlanConID(id_plan));
                    consumo_datos = obtenerConsumoDatos(daofactura.obtenerDatosPlanConID(id_plan), opcion_renovacion);
                    consumo_mensajes = obtenerConsumoMensajes(daofactura.obtenerMensajesPlanConID(id_plan), opcion_renovacion);
                    consumo_minutos_whatsapp = obtenerConsumoMinutosWhatsapp(daofactura.obtenerMinutosWhatsappPlanConID(id_plan), opcion_renovacion);
                    consumo_chat_whatsapp = obtenerConsumoChatWhatsapp(daofactura.obtenerChatWhatsappPlanConID(id_plan), opcion_renovacion);
                    consumo_facebook = obtenerConsumoFacebook(daofactura.obtenerFacebookPlanConID(id_plan), opcion_renovacion);

                    consumo_waze = 0;
                    consumo_llamada_eeuu = 0;
                    consumo_llamada_canada = 0;
                    consumo_llamada_puertorico = 0;
                    consumo_datos_compartir = 0;
                    break;
                case 4:
                    consumo_minutos = obtenerConsumoMinutos(daofactura.obtenerMinutosPlanConID(id_plan));
                    consumo_datos = obtenerConsumoDatos(daofactura.obtenerDatosPlanConID(id_plan), opcion_renovacion);
                    consumo_mensajes = obtenerConsumoMensajes(200, opcion_renovacion);
                    consumo_minutos_whatsapp = obtenerConsumoMinutosWhatsapp(700, opcion_renovacion);
                    consumo_chat_whatsapp = obtenerConsumoChatWhatsapp(600, opcion_renovacion);
                    consumo_facebook = obtenerConsumoFacebook(600, opcion_renovacion);

                    consumo_waze = obtenerConsumoWaze(600, opcion_renovacion);
                    consumo_llamada_eeuu = 0;
                    consumo_llamada_canada = 0;
                    consumo_llamada_puertorico = 0;
                    consumo_datos_compartir = 0;
                    break;
                case 5:
                    consumo_minutos = obtenerConsumoMinutos(1500);
                    consumo_datos = obtenerConsumoDatos(daofactura.obtenerDatosPlanConID(id_plan), opcion_renovacion);
                    consumo_mensajes = obtenerConsumoMensajes(200, opcion_renovacion);
                    consumo_minutos_whatsapp = obtenerConsumoMinutosWhatsapp(700, opcion_renovacion);
                    consumo_chat_whatsapp = obtenerConsumoChatWhatsapp(600, opcion_renovacion);
                    consumo_facebook = obtenerConsumoFacebook(600, opcion_renovacion);

                    consumo_waze = obtenerConsumoWaze(600, opcion_renovacion);
                    consumo_llamada_eeuu = obtenerConsumoLlamadaEEUU(500, opcion_renovacion);
                    consumo_llamada_canada = obtenerConsumoLlamadaCanada(500, opcion_renovacion);
                    consumo_llamada_puertorico = obtenerConsumoLlamadaPuertoRico(500, opcion_renovacion);
                    consumo_datos_compartir = obtenerConsumoDatosCompartir(3, false);
                    break;
            }
            
            int cargo_basico = daofactura.obtenerCostoPlanConID(id_plan);
            double cargo_min_adicionales = 0;
            
            if(consumo_minutos > daofactura.obtenerMinutosPlanConID(id_plan))
            {
                double min_adicional = daofactura.obtenerCostoPlanConID(id_plan) / daofactura.obtenerMinutosPlanConID(id_plan);
                int mins_adicionales = consumo_minutos - daofactura.obtenerMinutosPlanConID(id_plan);
                cargo_min_adicionales = min_adicional * mins_adicionales;
            }
            
            
            int cargo_renovaciones = 0;
            
            if(consumo_datos > daofactura.obtenerDatosPlanConID(id_plan) || consumo_mensajes > daofactura.obtenerMensajesPlanConID(id_plan) || consumo_minutos_whatsapp > daofactura.obtenerMinutosWhatsappPlanConID(id_plan) || consumo_chat_whatsapp > daofactura.obtenerChatWhatsappPlanConID(id_plan) || consumo_facebook > daofactura.obtenerFacebookPlanConID(id_plan))
            {
                cargo_renovaciones = daofactura.obtenerCostoPlanConID(id_plan) / 2;
            }
            
            int ajuste_peso = (int) Math.round(cargo_min_adicionales);
            
            int total_pago = cargo_basico + ajuste_peso + cargo_renovaciones;
            
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fecha_expedicion = dateFormat.format(date);

            Date date2 = new Date();
            Calendar c = Calendar.getInstance(); 
            c.setTime(date2);
            c.add(Calendar.DATE, 15);
            date2 = c.getTime();
            String fecha_vencimiento = dateFormat.format(date2);
            
            daofactura.registrarFactura(id_contrato, cc_cliente, nombre_cliente, direccion_cliente, ciudad_cliente, nombre_plan, linea, consumo_minutos, consumo_datos, consumo_mensajes, consumo_minutos_whatsapp, consumo_chat_whatsapp, consumo_facebook, consumo_waze, consumo_llamada_eeuu, consumo_llamada_canada, consumo_llamada_puertorico, consumo_datos_compartir, cargo_basico, cargo_min_adicionales, cargo_renovaciones, ajuste_peso, total_pago, fecha_expedicion, fecha_vencimiento);
            
            Map<String, Object> parameters = new HashMap<String, Object>();
            
            Factura factura = daofactura.obtenerFacturaStringPDF(linea, fecha_expedicion);
            
            List<Factura> facturas = Arrays.asList(factura);
            
            InputStream is = GerenteController.class.getResourceAsStream("factura_celusoft.jrxml");
            JasperReport report = JasperCompileManager.compileReport(is);
            
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(facturas);
            
            JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
        
            ByteArrayOutputStream output = new ByteArrayOutputStream();
        
            JasperExportManager.exportReportToPdfStream(print, output);
            
            final String PDF_FILE = "/home/marcos/proyecto-desarrollo1-java/src/proyecto/desarrollo1/java/ControladoresVista/factura_" +  linea + "_" + fecha_expedicion + ".pdf";
        
            OutputStream pdfFile = new FileOutputStream(new File(PDF_FILE));

            pdfFile.write(output.toByteArray());

            pdfFile.flush();

            pdfFile.close();
            
            Alert facturaGenerada = new Alert(AlertType.INFORMATION);
            facturaGenerada.setWidth(900);
            facturaGenerada.setTitle("Facturación realizada");
            facturaGenerada.setHeaderText("La factura ha sido guardada en la Base de Datos");
            facturaGenerada.setContentText("La factura en PDF ha sido generada en la ruta: \n" + PDF_FILE);
            facturaGenerada.showAndWait();
            
        } catch (SQLException ex) {
            Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void botonBuscarFacturaAction(ActionEvent event) {
        if(lineaFacturaTF.getText().equals(""))
        {
            Alert warningBuscarLineaVacio = new Alert(AlertType.WARNING);
            warningBuscarLineaVacio.setTitle("Campo de Línea a Buscar Vacío");
            warningBuscarLineaVacio.setHeaderText("El campo de la línea a buscar esta vacío");
            warningBuscarLineaVacio.showAndWait();
        }
        else
        {
            try {
                String lineaABuscar = lineaFacturaTF.getText();
                
                DAOFactura daofactura = new DAOFactura();
                
                int respuesta_existe;
                
                respuesta_existe = daofactura.existePlanConLinea(lineaABuscar);
                
                if(respuesta_existe == 1)
                {
                    Alert lineaEncontrada = new Alert(AlertType.INFORMATION);
                    lineaEncontrada.setTitle("Linea encontrada");
                    lineaEncontrada.setHeaderText("La linea existe");
                    lineaEncontrada.setContentText("La linea " + lineaABuscar + " se encuentra en la Base \n de Datos");
                    lineaEncontrada.showAndWait();
                    botonGenerarFactura.setDisable(false);
                }
                else
                if(respuesta_existe == 0)
                {
                    Alert errorNoExisteLinea = new Alert(AlertType.ERROR);
                    errorNoExisteLinea.setTitle("Línea inexistente");
                    errorNoExisteLinea.setHeaderText("Dicha línea no existe");
                    errorNoExisteLinea.setContentText("La línea introducida no existe y no \n está asociada a ningún plan ni cliente");
                    errorNoExisteLinea.showAndWait();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    @FXML
    void botonInformacionRenovacionAction(ActionEvent event) {
        Alert informacionRenovacion = new Alert(AlertType.INFORMATION);
        informacionRenovacion.setTitle("Información sobre Renovación");
        informacionRenovacion.setHeaderText("Cuando hayas consumido todos los datos, mensajes y servicios adicionales de \n tu Plan debes seleccionar lo que sucederá");
        informacionRenovacion.setContentText("Selecciona Si si deseas que cuando se acaben, se te cobre el 50% del valor del \n plan para que se efectue una recarga igual de los servicios, de lo contrario selecciona No");
        informacionRenovacion.showAndWait();
    }
    
    @FXML
    void botonRegistroClienteAction(ActionEvent event) {
        
        if(nombreClienteRegistroTF.getText().equals("") && apellidoClienteRegistroTF.getText().equals("") && direccionClienteRegistroTF.getText().equals("") && ciudadClienteRegistroTF.getText().equals("") && cedulaClienteRegistroTF.getText().equals(""))
        {
            Alert warningCamposVaciosRegistroCliente = new Alert(AlertType.WARNING);
            warningCamposVaciosRegistroCliente.setTitle("Campos Vacíos");
            warningCamposVaciosRegistroCliente.setHeaderText("Debe rellenar todos los campos del Registro");
            warningCamposVaciosRegistroCliente.showAndWait();
        }
        else 
        {
            try {
               String tipoClienteRegistroString = tipoClienteComboBox.getValue();

               int tipoClienteRegistro = 0;

               if(tipoClienteRegistroString == "Natural")
               {
                  tipoClienteRegistro = 1;
               }
               else
               if(tipoClienteRegistroString == "Corporativo")
               {
                  tipoClienteRegistro = 2;
               }

               String nombreClienteRegistro = nombreClienteRegistroTF.getText();
               String apellidoClienteRegistro = apellidoClienteRegistroTF.getText();
               String direccionClienteRegistro = direccionClienteRegistroTF.getText();
               String ciudadClienteRegistro = ciudadClienteRegistroTF.getText();
               String cedulaClienteRegistro = cedulaClienteRegistroTF.getText();

               DAOCliente daocliente = new DAOCliente();

               daocliente.registrarCliente(tipoClienteRegistro, nombreClienteRegistro, apellidoClienteRegistro, direccionClienteRegistro, ciudadClienteRegistro, cedulaClienteRegistro);

               Alert avisoRegistroClienteExitoso = new Alert(AlertType.INFORMATION);
               avisoRegistroClienteExitoso.setTitle("Registro de Cliente Exitoso");
               avisoRegistroClienteExitoso.setHeaderText("Se ha realizado el registro del Cliente exitosamente");
               avisoRegistroClienteExitoso.showAndWait();

           } catch (SQLException ex) {
               Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
           }   
        }   
    }
    
    @FXML
    void botonBuscarCedulaClientePlanAction(ActionEvent event) {
        
        if(cedulaClientePlan.getText().equals(""))
        {
            Alert warningBuscarCedulaClientePlanVacio = new Alert(AlertType.WARNING);
            warningBuscarCedulaClientePlanVacio.setTitle("Campo de Cédula a Buscar Vacío");
            warningBuscarCedulaClientePlanVacio.setHeaderText("El campo de la cédula del cliente a buscar esta vacío");
            warningBuscarCedulaClientePlanVacio.showAndWait();
        }
        else
        {
            try {
                String cedulaDeBusqueda = cedulaClientePlan.getText();
                
                DAOCliente daocliente = new DAOCliente();
                
                int respuesta = 0;
                
                respuesta = daocliente.verificarSiExisteClienteConCedula(cedulaDeBusqueda);
                
                if(respuesta == 1)
                {
                    Alert informacionClienteVincularPlanEncontrado = new Alert(AlertType.INFORMATION);
                    informacionClienteVincularPlanEncontrado.setTitle("Cliente encontrado");
                    informacionClienteVincularPlanEncontrado.setHeaderText("El cliente que ha consultado efectivamente está en la Base de Datos");
                    informacionClienteVincularPlanEncontrado.setContentText("Puede realizar la vinculación del cliente");
                    informacionClienteVincularPlanEncontrado.showAndWait();
                    comboBoxPlan.setDisable(false);
                    lineaTelefonicaPlan.setDisable(false);
                    botonAsociarPlanCliente.setDisable(false);
                    opcionRenovacionLineaComboBox.setDisable(false);
                    botonInformacionRenovacion.setDisable(false);
                }
                else
                {
                    Alert clienteInexistenteEnBD = new Alert(AlertType.ERROR);
                    clienteInexistenteEnBD.setTitle("Error: Cliente no encontrado");
                    clienteInexistenteEnBD.setHeaderText("El cliente con la cedula especificado no existe en la Base de Datos");
                    clienteInexistenteEnBD.showAndWait();
                }         
            } catch (SQLException ex) {
                Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
            
        }
    }
    
    @FXML
    void botonAsociarPlanClienteAction(ActionEvent event) {
        
        try {
            
            String cedulaDeBusqueda = cedulaClientePlan.getText();
            
            DAOCliente daocliente = new DAOCliente();
            
            int idCliente = daocliente.obtenerIDClienteConCedula(cedulaDeBusqueda);
            
            String planNombre = comboBoxPlan.getValue();
            
            int idPlan = daocliente.obtenerIDPlanConNombre(planNombre);
            
            String linea_telefonica = lineaTelefonicaPlan.getText();
            
            String opcionRenovacionString = opcionRenovacionLineaComboBox.getValue();
            
            int opcion_renovacion = 0;
            
            if(opcionRenovacionString.equals("Si"))
            {
                opcion_renovacion = 1;
            }
            else if(opcionRenovacionString.equals("No"))
            {
                opcion_renovacion = 0;
            }
            
            daocliente.registrarPlan(idPlan, idCliente, linea_telefonica, opcion_renovacion);
            
            
            
            Alert informationPlanRegistrado = new Alert(AlertType.INFORMATION);
            informationPlanRegistrado.setTitle("Plan Registrado con exito");
            informationPlanRegistrado.setHeaderText("Se ha registrado el plan " + planNombre + "al cliente con cedula " + cedulaDeBusqueda + " asociado al numero telefonico " + linea_telefonica);

            informationPlanRegistrado.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void botonCerrarSesionAction(ActionEvent event) throws IOException {
        
        Alert confirmationCerrarSesion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationCerrarSesion.setTitle("Cierre de Sesión");
        confirmationCerrarSesion.setHeaderText("¿Estás seguro de cerrar sesión como Gerente y volver a la pantalla de Login principal?");

        Optional<ButtonType> result = confirmationCerrarSesion.showAndWait();
        if (result.get() == ButtonType.OK){
            Stage stageviejo = (Stage) botonCerrarSesion.getScene().getWindow();
            
            
            FXMLLoader loaderLoginCierreSesion = new FXMLLoader();
            loaderLoginCierreSesion.setLocation(getClass().getClassLoader().getResource("proyecto/desarrollo1/java/Vista/Login.fxml"));
            Parent root = loaderLoginCierreSesion.load();
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("CeluSoft");
            stage.show();
            
            stageviejo.hide();
            
        } else {
            confirmationCerrarSesion.close();
        }
    }

    @FXML
    void botonBuscarCedulaModificarAction(ActionEvent event) {
        
        if(cedulaClienteMODRegistroTF.getText().equals(""))
        {
            Alert warningBuscarCedulaClienteRegistroVacio = new Alert(AlertType.WARNING);
            warningBuscarCedulaClienteRegistroVacio.setTitle("Campo de Cédula a Buscar Vacío");
            warningBuscarCedulaClienteRegistroVacio.setHeaderText("El campo de la cédula del cliente a buscar esta vacío");
            warningBuscarCedulaClienteRegistroVacio.showAndWait();
        }
        else
        {
            try {
                String cedulaDeBusqueda = cedulaClienteMODRegistroTF.getText();
                
                DAOCliente daocliente = new DAOCliente();
                
                int respuesta = 0;
                
                respuesta = daocliente.verificarSiExisteClienteConCedula(cedulaDeBusqueda);
                
                if(respuesta == 1)
                {
                    Alert informacionClienteAModificarEncontrado = new Alert(AlertType.INFORMATION);
                    informacionClienteAModificarEncontrado.setTitle("Cliente encontrado");
                    informacionClienteAModificarEncontrado.setHeaderText("El cliente que ha consultado efectivamente está en la Base de Datos");
                    informacionClienteAModificarEncontrado.setContentText("Puede realizar la modificación del cliente");
                    informacionClienteAModificarEncontrado.showAndWait();
                    nombreClienteMODRegistroTF.setDisable(false);
                    apellidoClienteMODRegistroTF.setDisable(false);
                    direccionClienteMODRegistroTF.setDisable(false);
                    ciudadClienteMODRegistroTF.setDisable(false);
                    botonModificarCliente.setDisable(false);
                    tipoMODClienteComboBox.setDisable(false);
                }
                else
                {
                    Alert clienteInexistenteEnBD = new Alert(AlertType.ERROR);
                    clienteInexistenteEnBD.setTitle("Error: Cliente no encontrado");
                    clienteInexistenteEnBD.setHeaderText("El cliente con la cedula especificado no existe en la Base de Datos");
                    clienteInexistenteEnBD.showAndWait();
                }         
            } catch (SQLException ex) {
                Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }

    @FXML
    void botonModificarClienteAction(ActionEvent event) {
        try {
            
            String cedulaDeBusqueda = cedulaClienteMODRegistroTF.getText();
            
            DAOCliente daocliente = new DAOCliente();
            
            int tipo_inicial = 0;
            
            tipo_inicial = daocliente.obtenerTipoClienteConCedula(cedulaDeBusqueda);
            
            int tipo_a_modificar = 0;
            
            String tipoAModificarString = tipoMODClienteComboBox.getValue();
            
            if(tipoAModificarString.equals("Natural"))
            {
                tipo_a_modificar = 1;
            }
            else
            if(tipoAModificarString.equals("Corporativo"))
            {
                tipo_a_modificar = 2;
            }
            
            Cliente miCliente;
            miCliente = daocliente.consultaCliente(cedulaDeBusqueda);
            
            if(tipo_inicial == tipo_a_modificar && nombreClienteMODRegistroTF.getText().equals("") && apellidoClienteMODRegistroTF.getText().equals("") && direccionClienteMODRegistroTF.getText().equals("") && ciudadClienteMODRegistroTF.getText().equals(""))
            {
                Alert alertWarningCamposModificar = new Alert(AlertType.WARNING);
                alertWarningCamposModificar.setTitle("Sin modificaciones registradas");
                alertWarningCamposModificar.setHeaderText("No ha registrado ningún cambio, ha dejado los campos de texto vacíos");
                alertWarningCamposModificar.showAndWait();
            }
            else
            if(nombreClienteMODRegistroTF.getText().equals(miCliente.getNombre()) || apellidoClienteMODRegistroTF.getText().equals(miCliente.getApellido()) || direccionClienteMODRegistroTF.getText().equals(miCliente.getDireccion()) || ciudadClienteMODRegistroTF.getText().equals(miCliente.getCiudad()))
            {
                Alert alertWarningCamposModificar2 = new Alert(AlertType.WARNING);
                alertWarningCamposModificar2.setTitle("Campos ha modificar con contenidos iguales a los ya registrados");
                alertWarningCamposModificar2.setHeaderText("Algun(os) campo(s) que ha escrito para su modificación son iguales a los anteriores");
                alertWarningCamposModificar2.setContentText("Esto quiere decir que ha rellenado un campo con su valor antiguo, por favor rellene el campo con una entrada nueva, Si en realidad no desea modificar dicho campo, dejelo vacío");
                alertWarningCamposModificar2.showAndWait();
            }
            else
            {
                String nombreClienteModificar = nombreClienteMODRegistroTF.getText();
                String apellidoClienteModificar = apellidoClienteMODRegistroTF.getText();
                String direccionClienteModificar = direccionClienteMODRegistroTF.getText();
                String ciudadClienteModificar = ciudadClienteMODRegistroTF.getText();
                
                daocliente.modificarCliente(cedulaDeBusqueda, tipo_a_modificar, nombreClienteModificar, apellidoClienteModificar, direccionClienteModificar, ciudadClienteModificar);
                
                Alert informationModificacionUsuarioExitoso = new Alert(AlertType.INFORMATION);
                informationModificacionUsuarioExitoso.setTitle("Modificación de Cliente exitosa");
                informationModificacionUsuarioExitoso.setHeaderText("Se ha llevado a cabo de manera exitosa la Modificación del Cliente");
                informationModificacionUsuarioExitoso.showAndWait();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void botonGuardarCambiosActivarInactivarAction(ActionEvent event) {
        
        try {
            
            String cedulaDeBusqueda = cedulaBuscarActivarInactivarClienteTF.getText();
            DAOCliente daocliente = new DAOCliente();
            int estado_inicial = -1;
            int estado_final = -1;
            
            estado_inicial = daocliente.obtenerEstadoClienteConCedula(cedulaDeBusqueda);
            
            String opcionSeleccionada = comboBoxActivarInactivarCliente.getValue();
            
            if(opcionSeleccionada.equals("Activar cliente") && estado_inicial == 1)
            {
                Alert errorClienteYaActivo = new Alert(AlertType.ERROR);
                errorClienteYaActivo.setTitle("El cliente ya está activo");
                errorClienteYaActivo.setHeaderText("El cliente seleccionado ya se encuentra activo");
                errorClienteYaActivo.showAndWait();
            }
            else 
            if(opcionSeleccionada.equals("Inactivar cliente") && estado_inicial == 0)
            {
                Alert errorClienteYaInactivo = new Alert(AlertType.ERROR);
                errorClienteYaInactivo.setTitle("El cliente ya está inactivo");
                errorClienteYaInactivo.setHeaderText("El cliente seleccionado ya se encuentra inactivo");
                errorClienteYaInactivo.showAndWait();
            }
            else
            if(opcionSeleccionada.equals("Activar cliente") && estado_inicial == 0)
            {
                estado_final = 1;
                daocliente.cambiarEstadoDeCliente(cedulaDeBusqueda, estado_final);
                Alert activacionClienteExitosa = new Alert(AlertType.INFORMATION);
                activacionClienteExitosa.setTitle("Activación de cliente exitosa");
                activacionClienteExitosa.setHeaderText("La activación del cliente se ha llevado a cabo de manera exitosa");
                activacionClienteExitosa.showAndWait();
            }
            else
            if(opcionSeleccionada.equals("Inactivar cliente") && estado_inicial == 1)
            {
               estado_final = 0;
               daocliente.cambiarEstadoDeCliente(cedulaDeBusqueda, estado_final);
               Alert inactivacionClienteExitosa = new Alert(AlertType.INFORMATION);
               inactivacionClienteExitosa.setTitle("Inactivación de cliente exitosa");
               inactivacionClienteExitosa.setHeaderText("La inactivación del cliente se ha llevado a cabo de manera exitosa");
               inactivacionClienteExitosa.showAndWait();
            }

        } catch (SQLException ex) {
            Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void botonBuscarActivarInactivarAction(ActionEvent event) {
        
        try {
            
            String cedulaDeBusqueda = cedulaBuscarActivarInactivarClienteTF.getText();
            
            int respuesta = 0;
            
            DAOCliente daocliente = new DAOCliente();
            
            respuesta = daocliente.verificarSiExisteClienteConCedula(cedulaDeBusqueda);
            
            if(respuesta == 1)
            {
                Alert informacionClienteActivarInactivarEncontrado = new Alert(AlertType.INFORMATION);
                informacionClienteActivarInactivarEncontrado.setTitle("Cliente encontrado");
                informacionClienteActivarInactivarEncontrado.setHeaderText("El cliente que ha consultado efectivamente está en la Base de Datos");
                informacionClienteActivarInactivarEncontrado.setContentText("Puede realizar la activación/inactivación del cliente");
                informacionClienteActivarInactivarEncontrado.showAndWait();
                comboBoxActivarInactivarCliente.setDisable(false);
                botonGuardarCambiosActivarInactivarCliente.setDisable(false);
            }
            else
            {
                Alert clienteInexistenteEnBD = new Alert(AlertType.ERROR);
                clienteInexistenteEnBD.setTitle("Error: Cliente no encontrado");
                clienteInexistenteEnBD.setHeaderText("El cliente con la cedula especificado no existe en la Base de Datos");
                clienteInexistenteEnBD.showAndWait();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void botonBuscarConsultaClienteAction(ActionEvent event) {
        
        try {
            
            String cedulaDeBusqueda = cedulaConsultaClienteTF.getText();
            
            int respuesta = 0;
            
            DAOCliente daocliente = new DAOCliente();
            
            respuesta = daocliente.verificarSiExisteClienteConCedula(cedulaDeBusqueda);
            
            if(respuesta == 1)
            {
                Alert informacionClienteActivarInactivarEncontrado = new Alert(AlertType.INFORMATION);
                informacionClienteActivarInactivarEncontrado.setTitle("Cliente encontrado");
                informacionClienteActivarInactivarEncontrado.setHeaderText("El cliente que ha consultado efectivamente está en la Base de Datos");
                informacionClienteActivarInactivarEncontrado.setContentText("Puede consultar la información del cliente");
                informacionClienteActivarInactivarEncontrado.showAndWait();
                mostrarInfoBotonConsultaCliente.setDisable(false);
            }
            else
            {
                Alert clienteInexistenteEnBD = new Alert(AlertType.ERROR);
                clienteInexistenteEnBD.setTitle("Error: Cliente no encontrado");
                clienteInexistenteEnBD.setHeaderText("El cliente con la cedula especificado no existe en la Base de Datos");
                clienteInexistenteEnBD.showAndWait();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    void mostrarInfoBotonConsultaClienteAction(ActionEvent event) {
        
        try {
            
            String cedulaDeBusqueda = cedulaConsultaClienteTF.getText();
            
            DAOCliente daocliente = new DAOCliente();
            
            Cliente miCliente;
            
            miCliente = daocliente.consultaCliente(cedulaDeBusqueda);
            
            
            muestraNombreTFCliente.setText(miCliente.getNombre());
            muestraApellidoTFCliente.setText(miCliente.getApellido());
            muestraDireccionTFCliente.setText(miCliente.getDireccion());
            muestraCiudadTFCliente.setText(miCliente.getCiudad());
            
            int tipo_cliente = miCliente.getTipo();
            int estado_cliente = miCliente.getEstado();
            
            if(tipo_cliente == 1)
            {
                muestraTipoTFCliente.setText("Natural");
            }
            else
            if(tipo_cliente == 2)
            {
                muestraTipoTFCliente.setText("Corporativo");
            }
            
            if(estado_cliente == 0)
            {
                muestraEstadoTFCliente.setText("Inactivo");
            }
            else
            if(estado_cliente == 1)
            {
                muestraEstadoTFCliente.setText("Activo");
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void botonBuscarClienteBorrarAction(ActionEvent event) {
        
        try {
            String cedulaDeBusqueda = cedulaClienteABorrarTF.getText();
            
            DAOCliente daocliente = new DAOCliente();
            
            int respuesta = 0;
            
            respuesta = daocliente.verificarSiExisteClienteConCedula(cedulaDeBusqueda);
            
            if(respuesta == -1)
            {
                Alert errorClienteNoEncontrado = new Alert(AlertType.ERROR);
                errorClienteNoEncontrado.setTitle("Error: Cliente con Cedula proveidaNo Encontrado");
                errorClienteNoEncontrado.setHeaderText("No existe tal cliente con la cedula indicada");
                errorClienteNoEncontrado.showAndWait();
            }
            else
                if(respuesta == 1)
                {
                    Alert infoUsuarioEncontradoBorrarU = new Alert(AlertType.INFORMATION);
                    infoUsuarioEncontradoBorrarU.setTitle("Cliente encontrado");
                    infoUsuarioEncontradoBorrarU.setHeaderText("El cliente con la cedula especificada si existe, fue encontrado en la Base de Datos");
                    infoUsuarioEncontradoBorrarU.setContentText("Puede realizar el borrado del Cliente");
                    infoUsuarioEncontradoBorrarU.showAndWait();
                    botonBorrarCliente.setDisable(false);
                }
        } catch (SQLException ex) {
            Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }

    @FXML
    void botonBorrarClienteAction(ActionEvent event) {
        
        Alert confirmationBorrarCliente = new Alert(AlertType.CONFIRMATION);
        confirmationBorrarCliente.setTitle("Borrado de Cliente");
        confirmationBorrarCliente.setHeaderText("¿Está seguro de borrar el cliente seleccionado?");
        confirmationBorrarCliente.setContentText("Se borrará toda la información ligada al cliente en la base de datos. Esta acción no se podrá deshacer");
        
        
        String cedulaDeBusqueda = cedulaClienteABorrarTF.getText();
        
        
        Optional<ButtonType> result = confirmationBorrarCliente.showAndWait();
        if (result.get() == ButtonType.OK){
            
            try {
                DAOCliente daocliente = new DAOCliente();
                
                daocliente.borrarClienteConCedula(cedulaDeBusqueda);
                
                Alert infoUsuarioBorradoExito = new Alert(AlertType.INFORMATION);
                infoUsuarioBorradoExito.setTitle("Borrado de Usuario exitoso");
                infoUsuarioBorradoExito.setHeaderText("El usuario ha sido borrado de la Base de Datos exitosamente");
                infoUsuarioBorradoExito.setContentText("Recuerde que esta acción no se puede deshacer y es para siempre");
                infoUsuarioBorradoExito.showAndWait();
            } catch (SQLException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            confirmationBorrarCliente.close();
        }
        
        System.out.println("Borrado de Cliente");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        comboBoxActivarInactivarCliente.getItems().add("Activar cliente");
        comboBoxActivarInactivarCliente.getItems().add("Inactivar cliente");
        
        tipoMODClienteComboBox.getItems().add("Natural");
        tipoMODClienteComboBox.getItems().add("Corporativo");
        
        tipoClienteComboBox.getItems().add("Natural");
        tipoClienteComboBox.getItems().add("Corporativo");
        
        comboBoxPlan.getItems().add("Plan 1");
        comboBoxPlan.getItems().add("Plan 2");
        comboBoxPlan.getItems().add("Plan 3");
        comboBoxPlan.getItems().add("Plan 4");
        comboBoxPlan.getItems().add("Plan 5");
        
        opcionRenovacionLineaComboBox.getItems().add("Si");
        opcionRenovacionLineaComboBox.getItems().add("No");
        
        
        try {
            FXMLLoader loaderGerenteVBox = new FXMLLoader();
            loaderGerenteVBox.setLocation(getClass().getClassLoader().getResource("proyecto/desarrollo1/java/Vista/GerenteVBox.fxml"));
            VBox gerenteBox = loaderGerenteVBox.load();
            drawer.setSidePane(gerenteBox);
            
            for (Node node: gerenteBox.getChildren())
            {
                if(node.getId() != null)
                {
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                        switch(node.getId())
                        {
                            case "BotonRegistrarClientes" : 
                                // Cerramos Facturacion
                                facturacionLabel.setVisible(false);
                                lineaFacturaTF.setVisible(false);
                                botonBuscarFactura.setVisible(false);
                                botonGenerarFactura.setVisible(false);
                                botonGenerarFactura.setDisable(true);
                                // Cerrar Registra Plan
                                asociarVentaPlanConCliente.setVisible(false);
                                cedulaClientePlan.setVisible(false);
                                botonBuscarCedulaClientePlan.setVisible(false);
                                comboBoxPlan.setVisible(false);
                                lineaTelefonicaPlan.setVisible(false);
                                botonAsociarPlanCliente.setVisible(false);
                                comboBoxPlan.setDisable(true);
                                lineaTelefonicaPlan.setDisable(true);
                                botonAsociarPlanCliente.setDisable(true);
                                opcionRenovacionLineaComboBox.setVisible(false);
                                botonInformacionRenovacion.setVisible(false);
                                opcionRenovacionLineaComboBox.setDisable(true);
                                botonInformacionRenovacion.setDisable(true);
                                // Cerrar Borrar
                                borrarClientesLabel.setVisible(false);
                                cedulaClienteABorrarTF.setVisible(false);
                                botonBuscarClienteBorrar.setVisible(false);
                                botonBorrarCliente.setVisible(false);
                                botonBorrarCliente.setDisable(true);
                                // Cerrar Consultar
                                consultarClientesLabel.setVisible(false);
                                cedulaConsultaClienteTF.setVisible(false);
                                botonBuscarConsultaCliente.setVisible(false);
                                mostrarInfoBotonConsultaCliente.setVisible(false);
                                muestraNombreTFCliente.setVisible(false);
                                muestraApellidoTFCliente.setVisible(false);
                                muestraDireccionTFCliente.setVisible(false);
                                muestraCiudadTFCliente.setVisible(false);
                                muestraTipoTFCliente.setVisible(false);
                                muestraEstadoTFCliente.setVisible(false);
                                muestraNombreLabelCliente.setVisible(false);
                                muestraApellidoLabelCliente.setVisible(false);
                                muestraDireccionLabelCliente.setVisible(false);
                                muestraCiudadLabelCliente.setVisible(false);
                                muestraTipoLabelCliente.setVisible(false);
                                muestraEstadoLabelCliente.setVisible(false);
                                mostrarInfoBotonConsultaCliente.setDisable(true);
                                muestraNombreTFCliente.setText("");
                                muestraApellidoTFCliente.setText("");
                                muestraDireccionTFCliente.setText("");
                                muestraCiudadTFCliente.setText("");
                                muestraTipoTFCliente.setText("");
                                muestraEstadoTFCliente.setText("");
                                // Cerrar Activar Inactivar
                                activarInactivarClienteLabel.setVisible(false);
                                cedulaBuscarActivarInactivarClienteTF.setVisible(false);
                                comboBoxActivarInactivarCliente.setVisible(false);
                                botonGuardarCambiosActivarInactivarCliente.setVisible(false);
                                botonBuscarActivarInactivarCliente.setVisible(false);
                                comboBoxActivarInactivarCliente.setDisable(true);
                                botonGuardarCambiosActivarInactivarCliente.setDisable(true);
                                // Cerrar Modificar
                                modificacionClienteLabel.setVisible(false);
                                cedulaClienteMODRegistroTF.setVisible(false);
                                botonBuscarCedulaModificar.setVisible(false);
                                nombreClienteMODRegistroTF.setVisible(false);
                                apellidoClienteMODRegistroTF.setVisible(false);
                                direccionClienteMODRegistroTF.setVisible(false);
                                ciudadClienteMODRegistroTF.setVisible(false);
                                botonModificarCliente.setVisible(false);
                                tipoMODClienteComboBox.setVisible(false);
                                nombreClienteMODRegistroTF.setDisable(true);
                                apellidoClienteMODRegistroTF.setDisable(true);
                                direccionClienteMODRegistroTF.setDisable(true);
                                ciudadClienteMODRegistroTF.setDisable(true);
                                botonModificarCliente.setDisable(true);
                                tipoMODClienteComboBox.setDisable(true);
                                // Abrir Registro
                                registroClienteLabel.setVisible(true);
                                tipoClienteComboBox.setVisible(true);
                                nombreClienteRegistroTF.setVisible(true);
                                apellidoClienteRegistroTF.setVisible(true);
                                direccionClienteRegistroTF.setVisible(true);
                                ciudadClienteRegistroTF.setVisible(true);
                                cedulaClienteRegistroTF.setVisible(true);
                                botonRegistroCliente.setVisible(true);
                                break;
                            case "BotonModificarClientes" : 
                                // Cerramos Facturacion
                                facturacionLabel.setVisible(false);
                                lineaFacturaTF.setVisible(false);
                                botonBuscarFactura.setVisible(false);
                                botonGenerarFactura.setVisible(false);
                                botonGenerarFactura.setDisable(true);
                                // Cerrar Registra Plan
                                asociarVentaPlanConCliente.setVisible(false);
                                cedulaClientePlan.setVisible(false);
                                botonBuscarCedulaClientePlan.setVisible(false);
                                comboBoxPlan.setVisible(false);
                                lineaTelefonicaPlan.setVisible(false);
                                botonAsociarPlanCliente.setVisible(false);
                                comboBoxPlan.setDisable(true);
                                lineaTelefonicaPlan.setDisable(true);
                                botonAsociarPlanCliente.setDisable(true);
                                opcionRenovacionLineaComboBox.setVisible(false);
                                botonInformacionRenovacion.setVisible(false);
                                opcionRenovacionLineaComboBox.setDisable(true);
                                botonInformacionRenovacion.setDisable(true);
                                // Cerrar Borrar
                                borrarClientesLabel.setVisible(false);
                                cedulaClienteABorrarTF.setVisible(false);
                                botonBuscarClienteBorrar.setVisible(false);
                                botonBorrarCliente.setVisible(false);
                                botonBorrarCliente.setDisable(true);
                                // Cerrar Consultar
                                consultarClientesLabel.setVisible(false);
                                cedulaConsultaClienteTF.setVisible(false);
                                botonBuscarConsultaCliente.setVisible(false);
                                mostrarInfoBotonConsultaCliente.setVisible(false);
                                muestraNombreTFCliente.setVisible(false);
                                muestraApellidoTFCliente.setVisible(false);
                                muestraDireccionTFCliente.setVisible(false);
                                muestraCiudadTFCliente.setVisible(false);
                                muestraTipoTFCliente.setVisible(false);
                                muestraEstadoTFCliente.setVisible(false);
                                muestraNombreLabelCliente.setVisible(false);
                                muestraApellidoLabelCliente.setVisible(false);
                                muestraDireccionLabelCliente.setVisible(false);
                                muestraCiudadLabelCliente.setVisible(false);
                                muestraTipoLabelCliente.setVisible(false);
                                muestraEstadoLabelCliente.setVisible(false);
                                mostrarInfoBotonConsultaCliente.setDisable(true);
                                muestraNombreTFCliente.setText("");
                                muestraApellidoTFCliente.setText("");
                                muestraDireccionTFCliente.setText("");
                                muestraCiudadTFCliente.setText("");
                                muestraTipoTFCliente.setText("");
                                muestraEstadoTFCliente.setText("");
                                // Cerrar Activar Inactivar
                                activarInactivarClienteLabel.setVisible(false);
                                cedulaBuscarActivarInactivarClienteTF.setVisible(false);
                                comboBoxActivarInactivarCliente.setVisible(false);
                                botonGuardarCambiosActivarInactivarCliente.setVisible(false);
                                botonBuscarActivarInactivarCliente.setVisible(false);
                                comboBoxActivarInactivarCliente.setDisable(true);
                                botonGuardarCambiosActivarInactivarCliente.setDisable(true);
                                // Cerrar Registro
                                registroClienteLabel.setVisible(false);
                                tipoClienteComboBox.setVisible(false);
                                nombreClienteRegistroTF.setVisible(false);
                                apellidoClienteRegistroTF.setVisible(false);
                                direccionClienteRegistroTF.setVisible(false);
                                ciudadClienteRegistroTF.setVisible(false);
                                cedulaClienteRegistroTF.setVisible(false);
                                botonRegistroCliente.setVisible(false);
                                // Abrir Modificar
                                modificacionClienteLabel.setVisible(true);
                                cedulaClienteMODRegistroTF.setVisible(true);
                                botonBuscarCedulaModificar.setVisible(true);
                                nombreClienteMODRegistroTF.setVisible(true);
                                apellidoClienteMODRegistroTF.setVisible(true);
                                direccionClienteMODRegistroTF.setVisible(true);
                                ciudadClienteMODRegistroTF.setVisible(true);
                                botonModificarCliente.setVisible(true);
                                tipoMODClienteComboBox.setVisible(true);
                                break;
                            case "BotonActivarInactivarClientes" :
                                // Cerramos Facturacion
                                facturacionLabel.setVisible(false);
                                lineaFacturaTF.setVisible(false);
                                botonBuscarFactura.setVisible(false);
                                botonGenerarFactura.setVisible(false);
                                botonGenerarFactura.setDisable(true);
                                // Cerrar Registra Plan
                                asociarVentaPlanConCliente.setVisible(false);
                                cedulaClientePlan.setVisible(false);
                                botonBuscarCedulaClientePlan.setVisible(false);
                                comboBoxPlan.setVisible(false);
                                lineaTelefonicaPlan.setVisible(false);
                                botonAsociarPlanCliente.setVisible(false);
                                comboBoxPlan.setDisable(true);
                                lineaTelefonicaPlan.setDisable(true);
                                botonAsociarPlanCliente.setDisable(true);
                                opcionRenovacionLineaComboBox.setVisible(false);
                                botonInformacionRenovacion.setVisible(false);
                                opcionRenovacionLineaComboBox.setDisable(true);
                                botonInformacionRenovacion.setDisable(true);
                                // Cerrar Borrar
                                borrarClientesLabel.setVisible(false);
                                cedulaClienteABorrarTF.setVisible(false);
                                botonBuscarClienteBorrar.setVisible(false);
                                botonBorrarCliente.setVisible(false);
                                botonBorrarCliente.setDisable(true);
                                // Cerrar Consultar
                                consultarClientesLabel.setVisible(false);
                                cedulaConsultaClienteTF.setVisible(false);
                                botonBuscarConsultaCliente.setVisible(false);
                                mostrarInfoBotonConsultaCliente.setVisible(false);
                                muestraNombreTFCliente.setVisible(false);
                                muestraApellidoTFCliente.setVisible(false);
                                muestraDireccionTFCliente.setVisible(false);
                                muestraCiudadTFCliente.setVisible(false);
                                muestraTipoTFCliente.setVisible(false);
                                muestraEstadoTFCliente.setVisible(false);
                                muestraNombreLabelCliente.setVisible(false);
                                muestraApellidoLabelCliente.setVisible(false);
                                muestraDireccionLabelCliente.setVisible(false);
                                muestraCiudadLabelCliente.setVisible(false);
                                muestraTipoLabelCliente.setVisible(false);
                                muestraEstadoLabelCliente.setVisible(false);
                                mostrarInfoBotonConsultaCliente.setDisable(true);
                                muestraNombreTFCliente.setText("");
                                muestraApellidoTFCliente.setText("");
                                muestraDireccionTFCliente.setText("");
                                muestraCiudadTFCliente.setText("");
                                muestraTipoTFCliente.setText("");
                                muestraEstadoTFCliente.setText("");
                                // Cerrar Modificar
                                modificacionClienteLabel.setVisible(false);
                                cedulaClienteMODRegistroTF.setVisible(false);
                                botonBuscarCedulaModificar.setVisible(false);
                                nombreClienteMODRegistroTF.setVisible(false);
                                apellidoClienteMODRegistroTF.setVisible(false);
                                direccionClienteMODRegistroTF.setVisible(false);
                                ciudadClienteMODRegistroTF.setVisible(false);
                                botonModificarCliente.setVisible(false);
                                tipoMODClienteComboBox.setVisible(false);
                                nombreClienteMODRegistroTF.setDisable(true);
                                apellidoClienteMODRegistroTF.setDisable(true);
                                direccionClienteMODRegistroTF.setDisable(true);
                                ciudadClienteMODRegistroTF.setDisable(true);
                                botonModificarCliente.setDisable(true);
                                tipoMODClienteComboBox.setDisable(true);
                                // Cerrar Registro
                                registroClienteLabel.setVisible(false);
                                tipoClienteComboBox.setVisible(false);
                                nombreClienteRegistroTF.setVisible(false);
                                apellidoClienteRegistroTF.setVisible(false);
                                direccionClienteRegistroTF.setVisible(false);
                                ciudadClienteRegistroTF.setVisible(false);
                                cedulaClienteRegistroTF.setVisible(false);
                                botonRegistroCliente.setVisible(false);
                                // Abrir Activar Inactivar
                                Alert avisoInformativoActivarSuspenderCliente = new Alert(AlertType.INFORMATION);
                                avisoInformativoActivarSuspenderCliente.setWidth(500);
                                avisoInformativoActivarSuspenderCliente.setTitle("Información acerca de la Activación/Suspensión de Cliente");
                                avisoInformativoActivarSuspenderCliente.setHeaderText("Activar o suspender a un Cliente");
                                avisoInformativoActivarSuspenderCliente.setContentText("Sirve para permitir o no que un Cliente adquiera más Planes");
                                avisoInformativoActivarSuspenderCliente.showAndWait();
                                activarInactivarClienteLabel.setVisible(true);
                                cedulaBuscarActivarInactivarClienteTF.setVisible(true);
                                comboBoxActivarInactivarCliente.setVisible(true);
                                botonGuardarCambiosActivarInactivarCliente.setVisible(true);
                                botonBuscarActivarInactivarCliente.setVisible(true);
                                break;
                            case "BotonRegistraVentaPlan" : 
                                // Cerramos Facturacion
                                facturacionLabel.setVisible(false);
                                lineaFacturaTF.setVisible(false);
                                botonBuscarFactura.setVisible(false);
                                botonGenerarFactura.setVisible(false);
                                botonGenerarFactura.setDisable(true);
                                // Cerrar Borrar
                                borrarClientesLabel.setVisible(false);
                                cedulaClienteABorrarTF.setVisible(false);
                                botonBuscarClienteBorrar.setVisible(false);
                                botonBorrarCliente.setVisible(false);
                                botonBorrarCliente.setDisable(true);
                                // Cerrar Consultar
                                consultarClientesLabel.setVisible(false);
                                cedulaConsultaClienteTF.setVisible(false);
                                botonBuscarConsultaCliente.setVisible(false);
                                mostrarInfoBotonConsultaCliente.setVisible(false);
                                muestraNombreTFCliente.setVisible(false);
                                muestraApellidoTFCliente.setVisible(false);
                                muestraDireccionTFCliente.setVisible(false);
                                muestraCiudadTFCliente.setVisible(false);
                                muestraTipoTFCliente.setVisible(false);
                                muestraEstadoTFCliente.setVisible(false);
                                muestraNombreLabelCliente.setVisible(false);
                                muestraApellidoLabelCliente.setVisible(false);
                                muestraDireccionLabelCliente.setVisible(false);
                                muestraCiudadLabelCliente.setVisible(false);
                                muestraTipoLabelCliente.setVisible(false);
                                muestraEstadoLabelCliente.setVisible(false);
                                mostrarInfoBotonConsultaCliente.setDisable(true);
                                muestraNombreTFCliente.setText("");
                                muestraApellidoTFCliente.setText("");
                                muestraDireccionTFCliente.setText("");
                                muestraCiudadTFCliente.setText("");
                                muestraTipoTFCliente.setText("");
                                muestraEstadoTFCliente.setText("");
                                // Cerrar Activar Inactivar
                                activarInactivarClienteLabel.setVisible(false);
                                cedulaBuscarActivarInactivarClienteTF.setVisible(false);
                                comboBoxActivarInactivarCliente.setVisible(false);
                                botonGuardarCambiosActivarInactivarCliente.setVisible(false);
                                botonBuscarActivarInactivarCliente.setVisible(false);
                                comboBoxActivarInactivarCliente.setDisable(true);
                                botonGuardarCambiosActivarInactivarCliente.setDisable(true);
                                // Cerrar Modificar
                                modificacionClienteLabel.setVisible(false);
                                cedulaClienteMODRegistroTF.setVisible(false);
                                botonBuscarCedulaModificar.setVisible(false);
                                nombreClienteMODRegistroTF.setVisible(false);
                                apellidoClienteMODRegistroTF.setVisible(false);
                                direccionClienteMODRegistroTF.setVisible(false);
                                ciudadClienteMODRegistroTF.setVisible(false);
                                botonModificarCliente.setVisible(false);
                                tipoMODClienteComboBox.setVisible(false);
                                nombreClienteMODRegistroTF.setDisable(true);
                                apellidoClienteMODRegistroTF.setDisable(true);
                                direccionClienteMODRegistroTF.setDisable(true);
                                ciudadClienteMODRegistroTF.setDisable(true);
                                botonModificarCliente.setDisable(true);
                                tipoMODClienteComboBox.setDisable(true);
                                // Cerrar Registro
                                registroClienteLabel.setVisible(false);
                                tipoClienteComboBox.setVisible(false);
                                nombreClienteRegistroTF.setVisible(false);
                                apellidoClienteRegistroTF.setVisible(false);
                                direccionClienteRegistroTF.setVisible(false);
                                ciudadClienteRegistroTF.setVisible(false);
                                cedulaClienteRegistroTF.setVisible(false);
                                botonRegistroCliente.setVisible(false);
                                // Abrir Registra Plan
                                asociarVentaPlanConCliente.setVisible(true);
                                cedulaClientePlan.setVisible(true);
                                botonBuscarCedulaClientePlan.setVisible(true);
                                comboBoxPlan.setVisible(true);
                                lineaTelefonicaPlan.setVisible(true);
                                botonAsociarPlanCliente.setVisible(true);
                                opcionRenovacionLineaComboBox.setVisible(true);
                                botonInformacionRenovacion.setVisible(true);
                                break;
                            case "BotonConsultarClientes" :
                                // Cerramos Facturacion
                                facturacionLabel.setVisible(false);
                                lineaFacturaTF.setVisible(false);
                                botonBuscarFactura.setVisible(false);
                                botonGenerarFactura.setVisible(false);
                                botonGenerarFactura.setDisable(true);
                                // Cerrar Registra Plan
                                asociarVentaPlanConCliente.setVisible(false);
                                cedulaClientePlan.setVisible(false);
                                botonBuscarCedulaClientePlan.setVisible(false);
                                comboBoxPlan.setVisible(false);
                                lineaTelefonicaPlan.setVisible(false);
                                botonAsociarPlanCliente.setVisible(false);
                                comboBoxPlan.setDisable(true);
                                lineaTelefonicaPlan.setDisable(true);
                                botonAsociarPlanCliente.setDisable(true);
                                opcionRenovacionLineaComboBox.setVisible(false);
                                botonInformacionRenovacion.setVisible(false);
                                opcionRenovacionLineaComboBox.setDisable(true);
                                botonInformacionRenovacion.setDisable(true);
                                // Cerrar Borrar
                                borrarClientesLabel.setVisible(false);
                                cedulaClienteABorrarTF.setVisible(false);
                                botonBuscarClienteBorrar.setVisible(false);
                                botonBorrarCliente.setVisible(false);
                                botonBorrarCliente.setDisable(true);
                                // Cerrar Activar Inactivar
                                activarInactivarClienteLabel.setVisible(false);
                                cedulaBuscarActivarInactivarClienteTF.setVisible(false);
                                comboBoxActivarInactivarCliente.setVisible(false);
                                botonGuardarCambiosActivarInactivarCliente.setVisible(false);
                                botonBuscarActivarInactivarCliente.setVisible(false);
                                comboBoxActivarInactivarCliente.setDisable(true);
                                botonGuardarCambiosActivarInactivarCliente.setDisable(true);
                                // Cerrar Modificar
                                modificacionClienteLabel.setVisible(false);
                                cedulaClienteMODRegistroTF.setVisible(false);
                                botonBuscarCedulaModificar.setVisible(false);
                                nombreClienteMODRegistroTF.setVisible(false);
                                apellidoClienteMODRegistroTF.setVisible(false);
                                direccionClienteMODRegistroTF.setVisible(false);
                                ciudadClienteMODRegistroTF.setVisible(false);
                                botonModificarCliente.setVisible(false);
                                tipoMODClienteComboBox.setVisible(false);
                                nombreClienteMODRegistroTF.setDisable(true);
                                apellidoClienteMODRegistroTF.setDisable(true);
                                direccionClienteMODRegistroTF.setDisable(true);
                                ciudadClienteMODRegistroTF.setDisable(true);
                                botonModificarCliente.setDisable(true);
                                tipoMODClienteComboBox.setDisable(true);
                                // Cerrar Registro
                                registroClienteLabel.setVisible(false);
                                tipoClienteComboBox.setVisible(false);
                                nombreClienteRegistroTF.setVisible(false);
                                apellidoClienteRegistroTF.setVisible(false);
                                direccionClienteRegistroTF.setVisible(false);
                                ciudadClienteRegistroTF.setVisible(false);
                                cedulaClienteRegistroTF.setVisible(false);
                                botonRegistroCliente.setVisible(false);
                                // Abrir Consultar
                                consultarClientesLabel.setVisible(true);
                                cedulaConsultaClienteTF.setVisible(true);
                                botonBuscarConsultaCliente.setVisible(true);
                                mostrarInfoBotonConsultaCliente.setVisible(true);
                                muestraNombreTFCliente.setVisible(true);
                                muestraApellidoTFCliente.setVisible(true);
                                muestraDireccionTFCliente.setVisible(true);
                                muestraCiudadTFCliente.setVisible(true);
                                muestraTipoTFCliente.setVisible(true);
                                muestraEstadoTFCliente.setVisible(true);
                                muestraNombreLabelCliente.setVisible(true);
                                muestraApellidoLabelCliente.setVisible(true);
                                muestraDireccionLabelCliente.setVisible(true);
                                muestraCiudadLabelCliente.setVisible(true);
                                muestraTipoLabelCliente.setVisible(true);
                                muestraEstadoLabelCliente.setVisible(true);
                                break;
                            case "BotonBorrarClientes": 
                                // Cerramos Facturacion
                                facturacionLabel.setVisible(false);
                                lineaFacturaTF.setVisible(false);
                                botonBuscarFactura.setVisible(false);
                                botonGenerarFactura.setVisible(false);
                                botonGenerarFactura.setDisable(true);
                                // Cerrar Registra Plan
                                asociarVentaPlanConCliente.setVisible(false);
                                cedulaClientePlan.setVisible(false);
                                botonBuscarCedulaClientePlan.setVisible(false);
                                comboBoxPlan.setVisible(false);
                                lineaTelefonicaPlan.setVisible(false);
                                botonAsociarPlanCliente.setVisible(false);
                                comboBoxPlan.setDisable(true);
                                lineaTelefonicaPlan.setDisable(true);
                                botonAsociarPlanCliente.setDisable(true);
                                opcionRenovacionLineaComboBox.setVisible(false);
                                botonInformacionRenovacion.setVisible(false);
                                opcionRenovacionLineaComboBox.setDisable(true);
                                botonInformacionRenovacion.setDisable(true);
                                // Cerrar Consultar
                                consultarClientesLabel.setVisible(false);
                                cedulaConsultaClienteTF.setVisible(false);
                                botonBuscarConsultaCliente.setVisible(false);
                                mostrarInfoBotonConsultaCliente.setVisible(false);
                                muestraNombreTFCliente.setVisible(false);
                                muestraApellidoTFCliente.setVisible(false);
                                muestraDireccionTFCliente.setVisible(false);
                                muestraCiudadTFCliente.setVisible(false);
                                muestraTipoTFCliente.setVisible(false);
                                muestraEstadoTFCliente.setVisible(false);
                                muestraNombreLabelCliente.setVisible(false);
                                muestraApellidoLabelCliente.setVisible(false);
                                muestraDireccionLabelCliente.setVisible(false);
                                muestraCiudadLabelCliente.setVisible(false);
                                muestraTipoLabelCliente.setVisible(false);
                                muestraEstadoLabelCliente.setVisible(false);
                                mostrarInfoBotonConsultaCliente.setDisable(true);
                                muestraNombreTFCliente.setText("");
                                muestraApellidoTFCliente.setText("");
                                muestraDireccionTFCliente.setText("");
                                muestraCiudadTFCliente.setText("");
                                muestraTipoTFCliente.setText("");
                                muestraEstadoTFCliente.setText("");
                                // Cerrar Activar Inactivar
                                activarInactivarClienteLabel.setVisible(false);
                                cedulaBuscarActivarInactivarClienteTF.setVisible(false);
                                comboBoxActivarInactivarCliente.setVisible(false);
                                botonGuardarCambiosActivarInactivarCliente.setVisible(false);
                                botonBuscarActivarInactivarCliente.setVisible(false);
                                comboBoxActivarInactivarCliente.setDisable(true);
                                botonGuardarCambiosActivarInactivarCliente.setDisable(true);
                                // Cerrar Modificar
                                modificacionClienteLabel.setVisible(false);
                                cedulaClienteMODRegistroTF.setVisible(false);
                                botonBuscarCedulaModificar.setVisible(false);
                                nombreClienteMODRegistroTF.setVisible(false);
                                apellidoClienteMODRegistroTF.setVisible(false);
                                direccionClienteMODRegistroTF.setVisible(false);
                                ciudadClienteMODRegistroTF.setVisible(false);
                                botonModificarCliente.setVisible(false);
                                tipoMODClienteComboBox.setVisible(false);
                                nombreClienteMODRegistroTF.setDisable(true);
                                apellidoClienteMODRegistroTF.setDisable(true);
                                direccionClienteMODRegistroTF.setDisable(true);
                                ciudadClienteMODRegistroTF.setDisable(true);
                                botonModificarCliente.setDisable(true);
                                tipoMODClienteComboBox.setDisable(true);
                                // Cerrar Registro
                                registroClienteLabel.setVisible(false);
                                tipoClienteComboBox.setVisible(false);
                                nombreClienteRegistroTF.setVisible(false);
                                apellidoClienteRegistroTF.setVisible(false);
                                direccionClienteRegistroTF.setVisible(false);
                                ciudadClienteRegistroTF.setVisible(false);
                                cedulaClienteRegistroTF.setVisible(false);
                                botonRegistroCliente.setVisible(false);
                                // Abrimos Borrar
                                borrarClientesLabel.setVisible(true);
                                cedulaClienteABorrarTF.setVisible(true);
                                botonBuscarClienteBorrar.setVisible(true);
                                botonBorrarCliente.setVisible(true);
                                break;
                            case "BotonFacturacion":
                                // Cerrar Borrar
                                borrarClientesLabel.setVisible(false);
                                cedulaClienteABorrarTF.setVisible(false);
                                botonBuscarClienteBorrar.setVisible(false);
                                botonBorrarCliente.setVisible(false);
                                botonBorrarCliente.setDisable(true);
                                // Cerrar Registra Plan
                                asociarVentaPlanConCliente.setVisible(false);
                                cedulaClientePlan.setVisible(false);
                                botonBuscarCedulaClientePlan.setVisible(false);
                                comboBoxPlan.setVisible(false);
                                lineaTelefonicaPlan.setVisible(false);
                                botonAsociarPlanCliente.setVisible(false);
                                comboBoxPlan.setDisable(true);
                                lineaTelefonicaPlan.setDisable(true);
                                botonAsociarPlanCliente.setDisable(true);
                                opcionRenovacionLineaComboBox.setVisible(false);
                                botonInformacionRenovacion.setVisible(false);
                                opcionRenovacionLineaComboBox.setDisable(true);
                                botonInformacionRenovacion.setDisable(true);
                                // Cerrar Consultar
                                consultarClientesLabel.setVisible(false);
                                cedulaConsultaClienteTF.setVisible(false);
                                botonBuscarConsultaCliente.setVisible(false);
                                mostrarInfoBotonConsultaCliente.setVisible(false);
                                muestraNombreTFCliente.setVisible(false);
                                muestraApellidoTFCliente.setVisible(false);
                                muestraDireccionTFCliente.setVisible(false);
                                muestraCiudadTFCliente.setVisible(false);
                                muestraTipoTFCliente.setVisible(false);
                                muestraEstadoTFCliente.setVisible(false);
                                muestraNombreLabelCliente.setVisible(false);
                                muestraApellidoLabelCliente.setVisible(false);
                                muestraDireccionLabelCliente.setVisible(false);
                                muestraCiudadLabelCliente.setVisible(false);
                                muestraTipoLabelCliente.setVisible(false);
                                muestraEstadoLabelCliente.setVisible(false);
                                mostrarInfoBotonConsultaCliente.setDisable(true);
                                muestraNombreTFCliente.setText("");
                                muestraApellidoTFCliente.setText("");
                                muestraDireccionTFCliente.setText("");
                                muestraCiudadTFCliente.setText("");
                                muestraTipoTFCliente.setText("");
                                muestraEstadoTFCliente.setText("");
                                // Cerrar Activar Inactivar
                                activarInactivarClienteLabel.setVisible(false);
                                cedulaBuscarActivarInactivarClienteTF.setVisible(false);
                                comboBoxActivarInactivarCliente.setVisible(false);
                                botonGuardarCambiosActivarInactivarCliente.setVisible(false);
                                botonBuscarActivarInactivarCliente.setVisible(false);
                                comboBoxActivarInactivarCliente.setDisable(true);
                                botonGuardarCambiosActivarInactivarCliente.setDisable(true);
                                // Cerrar Modificar
                                modificacionClienteLabel.setVisible(false);
                                cedulaClienteMODRegistroTF.setVisible(false);
                                botonBuscarCedulaModificar.setVisible(false);
                                nombreClienteMODRegistroTF.setVisible(false);
                                apellidoClienteMODRegistroTF.setVisible(false);
                                direccionClienteMODRegistroTF.setVisible(false);
                                ciudadClienteMODRegistroTF.setVisible(false);
                                botonModificarCliente.setVisible(false);
                                tipoMODClienteComboBox.setVisible(false);
                                nombreClienteMODRegistroTF.setDisable(true);
                                apellidoClienteMODRegistroTF.setDisable(true);
                                direccionClienteMODRegistroTF.setDisable(true);
                                ciudadClienteMODRegistroTF.setDisable(true);
                                botonModificarCliente.setDisable(true);
                                tipoMODClienteComboBox.setDisable(true);
                                // Cerrar Registro
                                registroClienteLabel.setVisible(false);
                                tipoClienteComboBox.setVisible(false);
                                nombreClienteRegistroTF.setVisible(false);
                                apellidoClienteRegistroTF.setVisible(false);
                                direccionClienteRegistroTF.setVisible(false);
                                ciudadClienteRegistroTF.setVisible(false);
                                cedulaClienteRegistroTF.setVisible(false);
                                botonRegistroCliente.setVisible(false);
                                // Abrimos Facturacion
                                facturacionLabel.setVisible(true);
                                lineaFacturaTF.setVisible(true);
                                botonBuscarFactura.setVisible(true);
                                botonGenerarFactura.setVisible(true);
                                break;
                        }
                        
                        
                    });
                }
            }
            
            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
            transition.setRate(-1);
            hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e -> {
                transition.setRate(transition.getRate()* - 1);
                transition.play();
                
                if(drawer.isOpened())
                {
                    drawer.close();
                }
                else
                {
                    drawer.open();
                }
                
            }));
            
        } catch (IOException ex) {
            Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private static int obtenerConsumoChatWhatsapp(int chatWhatsappPlan, boolean renovacionPlan) {
        org.me.celusoft.WebServiceMain_Service service = new org.me.celusoft.WebServiceMain_Service();
        org.me.celusoft.WebServiceMain port = service.getWebServiceMainPort();
        return port.obtenerConsumoChatWhatsapp(chatWhatsappPlan, renovacionPlan);
    }

    private static double obtenerConsumoDatos(double datosPlan, boolean renovacionPlan) {
        org.me.celusoft.WebServiceMain_Service service = new org.me.celusoft.WebServiceMain_Service();
        org.me.celusoft.WebServiceMain port = service.getWebServiceMainPort();
        return port.obtenerConsumoDatos(datosPlan, renovacionPlan);
    }

    private static double obtenerConsumoDatosCompartir(double datosCompartirPlan, boolean renovacionPlan) {
        org.me.celusoft.WebServiceMain_Service service = new org.me.celusoft.WebServiceMain_Service();
        org.me.celusoft.WebServiceMain port = service.getWebServiceMainPort();
        return port.obtenerConsumoDatosCompartir(datosCompartirPlan, renovacionPlan);
    }

    private static int obtenerConsumoFacebook(int facebookPlan, boolean renovacionPlan) {
        org.me.celusoft.WebServiceMain_Service service = new org.me.celusoft.WebServiceMain_Service();
        org.me.celusoft.WebServiceMain port = service.getWebServiceMainPort();
        return port.obtenerConsumoFacebook(facebookPlan, renovacionPlan);
    }

    private static int obtenerConsumoLlamadaCanada(int llamadaCanadaPlan, boolean renovacionPlan) {
        org.me.celusoft.WebServiceMain_Service service = new org.me.celusoft.WebServiceMain_Service();
        org.me.celusoft.WebServiceMain port = service.getWebServiceMainPort();
        return port.obtenerConsumoLlamadaCanada(llamadaCanadaPlan, renovacionPlan);
    }

    private static int obtenerConsumoLlamadaEEUU(int llamadaEeuuPlan, boolean renovacionPlan) {
        org.me.celusoft.WebServiceMain_Service service = new org.me.celusoft.WebServiceMain_Service();
        org.me.celusoft.WebServiceMain port = service.getWebServiceMainPort();
        return port.obtenerConsumoLlamadaEEUU(llamadaEeuuPlan, renovacionPlan);
    }

    private static int obtenerConsumoLlamadaPuertoRico(int llamadaPuertoricoPlan, boolean renovacionPlan) {
        org.me.celusoft.WebServiceMain_Service service = new org.me.celusoft.WebServiceMain_Service();
        org.me.celusoft.WebServiceMain port = service.getWebServiceMainPort();
        return port.obtenerConsumoLlamadaPuertoRico(llamadaPuertoricoPlan, renovacionPlan);
    }

    private static int obtenerConsumoMensajes(int mensajesPlan, boolean renovacionPlan) {
        org.me.celusoft.WebServiceMain_Service service = new org.me.celusoft.WebServiceMain_Service();
        org.me.celusoft.WebServiceMain port = service.getWebServiceMainPort();
        return port.obtenerConsumoMensajes(mensajesPlan, renovacionPlan);
    }

    private static int obtenerConsumoMinutos(int minutosPlan) {
        org.me.celusoft.WebServiceMain_Service service = new org.me.celusoft.WebServiceMain_Service();
        org.me.celusoft.WebServiceMain port = service.getWebServiceMainPort();
        return port.obtenerConsumoMinutos(minutosPlan);
    }

    private static int obtenerConsumoMinutosWhatsapp(int minutosWhatsappPlan, boolean renovacionPlan) {
        org.me.celusoft.WebServiceMain_Service service = new org.me.celusoft.WebServiceMain_Service();
        org.me.celusoft.WebServiceMain port = service.getWebServiceMainPort();
        return port.obtenerConsumoMinutosWhatsapp(minutosWhatsappPlan, renovacionPlan);
    }

    private static int obtenerConsumoWaze(int wazePlan, boolean renovacionPlan) {
        org.me.celusoft.WebServiceMain_Service service = new org.me.celusoft.WebServiceMain_Service();
        org.me.celusoft.WebServiceMain port = service.getWebServiceMainPort();
        return port.obtenerConsumoWaze(wazePlan, renovacionPlan);
    }

    
    
    

    
}
