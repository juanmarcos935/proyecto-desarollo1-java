
package proyecto.desarrollo1.java.ControladoresVista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import proyecto.desarrollo1.java.DAOs.DAOCliente;
import proyecto.desarrollo1.java.Modelo.Cliente;


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
            
            int idCliente = daocliente.obtenerEstadoClienteConCedula(cedulaDeBusqueda);
            
            String planNombre = comboBoxPlan.getValue();
            
            int idPlan = daocliente.obtenerIDPlanConNombre(planNombre);
            
            String linea_telefonica = lineaTelefonicaPlan.getText();
            
            daocliente.registrarPlan(idPlan, idCliente, linea_telefonica);
            
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
                                break;
                            case "BotonConsultarClientes" :
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
}
