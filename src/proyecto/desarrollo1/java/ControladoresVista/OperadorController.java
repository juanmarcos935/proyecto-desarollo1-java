
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
import java.text.SimpleDateFormat;
import java.util.Date;
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
import proyecto.desarrollo1.java.DAOs.DAOFactura;


public class OperadorController implements Initializable{
    
    @FXML
    private JFXButton botonBuscarFacturaDirecto;

    @FXML
    private JFXTextField pagoDirectoFacturaTF;

    @FXML
    private JFXButton botonPagarFacturaDirecto;

    @FXML
    private JFXTextField verificarPagoBancoFacturaTF;

    @FXML
    private JFXComboBox<String> seleccionBancoComboBox;

    @FXML
    private JFXButton botonBuscarFacturaBanco;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private Label pagoBancoLabel;

    @FXML
    private JFXButton botonBuscarFacturaPagadaEnBanco;

    @FXML
    private JFXComboBox<String> seleccionBancoComboBoxVerificar;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXButton botonCerrarSesion;

    @FXML
    private JFXButton botonPagarFacturaBanco;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXTextField pagoBancoFacturaTF;

    @FXML
    private Label pagoDirectoLabel;

    @FXML
    private Label verificarPagoBancoLabel;

    @FXML
    private JFXButton botonRegistrarPagado;
    
    @FXML
    void botonBuscarFacturaDirectoAction(ActionEvent event) {
        
        String idFacturaBuscar = pagoDirectoFacturaTF.getText();
        
        if(idFacturaBuscar.equals(""))
        {
            Alert campoFacturaVacio = new Alert(AlertType.WARNING);
            campoFacturaVacio.setTitle("Campo de ID Factura vacío");
            campoFacturaVacio.setHeaderText("Campo de ID Factura a buscar vacío");
            campoFacturaVacio.setContentText("Por favor ingresa un ID factura para poder buscar");
            campoFacturaVacio.showAndWait();
        }
        else
        {
            try {
                
                DAOFactura daofactura = new DAOFactura();
                int id_factura = Integer.parseInt(idFacturaBuscar);
                int respuesta = daofactura.existeFacturaConIDFactura(id_factura);
                
                if(respuesta == 1)
                {
                    Alert facturaEncontrada = new Alert(AlertType.INFORMATION);
                    facturaEncontrada.setTitle("Factura encontrada");
                    facturaEncontrada.setHeaderText("Factura encontrada exitosamente");
                    facturaEncontrada.setContentText("La factura correspondiente al ID Factura proveido existe en la Base de Datos");
                    facturaEncontrada.showAndWait();
                    botonPagarFacturaDirecto.setDisable(false);
                }
                else
                {
                    Alert facturaInexistente = new Alert(AlertType.ERROR);
                    facturaInexistente.setTitle("Factura inexistente");
                    facturaInexistente.setHeaderText("No existe tal factura");
                    facturaInexistente.setContentText("No existe factura correspondiente al ID Factura proveido");
                    facturaInexistente.showAndWait();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(OperadorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @FXML
    void botonPagarFacturaDirectoAction(ActionEvent event) {
        
        try {
            
            
            DAOFactura daofactura = new DAOFactura();
            String idFacturaBuscar = pagoDirectoFacturaTF.getText();
            int id_factura = Integer.parseInt(idFacturaBuscar);
            int total_pago = daofactura.obtenerPagoTotalConIDFactura(id_factura);
            
            Alert confirmacionPago = new Alert(AlertType.CONFIRMATION);
            confirmacionPago.setTitle("Confirmación de Pago");
            confirmacionPago.setHeaderText("Confirmar pago de Factura # " + idFacturaBuscar);
            confirmacionPago.setContentText("La Factura # " + idFacturaBuscar + " figura con un valor de " + total_pago + " . ¿Desea cancelar este valor y pagar la Factura?");

            Optional<ButtonType> result = confirmacionPago.showAndWait();
            if (result.get() == ButtonType.OK){
                
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fecha_pago = dateFormat.format(date);
                
                daofactura.pagarFacturaConIDFactura(id_factura);
                daofactura.fechaFacturaPagadaConIDFactura(id_factura, fecha_pago);
                
                Alert pagoFacturaRealizado = new Alert(AlertType.INFORMATION);
                pagoFacturaRealizado.setTitle("Pago de factura realizado exitosamente");
                pagoFacturaRealizado.setHeaderText("El pago de la factura se realizó correctamente");
                pagoFacturaRealizado.setContentText("La factura # " + idFacturaBuscar + " figura como pagada de manera exitosa");
                pagoFacturaRealizado.showAndWait();
                
            } else {
                
                Alert transaccionCancelada = new Alert(AlertType.ERROR);
                transaccionCancelada.setTitle("Transacción cancelada");
                transaccionCancelada.setHeaderText("Transacción cancelada");
                transaccionCancelada.setContentText("El pago de la Factura # " + idFacturaBuscar + " no se ha completado y la Factura no figurará como pagada.");
                transaccionCancelada.showAndWait();
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OperadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    void botonBuscarFacturaBancoAction(ActionEvent event) {
        
        String idFacturaBuscar = pagoBancoFacturaTF.getText();
        
        if(idFacturaBuscar.equals(""))
        {
            Alert campoFacturaVacio = new Alert(AlertType.WARNING);
            campoFacturaVacio.setTitle("Campo de ID Factura vacío");
            campoFacturaVacio.setHeaderText("Campo de ID Factura a buscar vacío");
            campoFacturaVacio.setContentText("Por favor ingresa un ID factura para poder buscar");
            campoFacturaVacio.showAndWait();
        }
        else
        {
            try {
                
                DAOFactura daofactura = new DAOFactura();
                int id_factura = Integer.parseInt(idFacturaBuscar);
                int respuesta = daofactura.existeFacturaConIDFactura(id_factura);
                
                if(respuesta == 1)
                {
                    Alert facturaEncontrada = new Alert(AlertType.INFORMATION);
                    facturaEncontrada.setTitle("Factura encontrada");
                    facturaEncontrada.setHeaderText("Factura encontrada exitosamente");
                    facturaEncontrada.setContentText("La factura correspondiente al ID Factura proveido existe en la Base de Datos");
                    facturaEncontrada.showAndWait();
                    botonPagarFacturaBanco.setDisable(false);
                    seleccionBancoComboBox.setDisable(false);
                }
                else
                {
                    Alert facturaInexistente = new Alert(AlertType.ERROR);
                    facturaInexistente.setTitle("Factura inexistente");
                    facturaInexistente.setHeaderText("No existe tal factura");
                    facturaInexistente.setContentText("No existe factura correspondiente al ID Factura proveido");
                    facturaInexistente.showAndWait();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(OperadorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @FXML
    void botonPagarFacturaBancoAction(ActionEvent event) {
        
        try {
            
            
            DAOFactura daofactura = new DAOFactura();
            String idFacturaBuscar = pagoBancoFacturaTF.getText();
            int id_factura = Integer.parseInt(idFacturaBuscar);
            int total_pago = daofactura.obtenerPagoTotalConIDFactura(id_factura);
            
            String opcionBanco = seleccionBancoComboBox.getValue();
            int id_banco = 0;
                
            if(opcionBanco.equals("Banco 1"))
            {
                id_banco = 1;
            }
            else if(opcionBanco.equals("Banco 2"))
            {
                id_banco = 2;
            }
            
            Alert confirmacionPago = new Alert(AlertType.CONFIRMATION);
            confirmacionPago.setTitle("Confirmación de Pago en Banco");
            confirmacionPago.setHeaderText("Confirmar pago de Factura # " + idFacturaBuscar);
            confirmacionPago.setContentText("La Factura # " + idFacturaBuscar + " figura con un valor de " + total_pago + " . ¿Desea cancelar este valor y pagar la Factura en Banco?");

            Optional<ButtonType> result = confirmacionPago.showAndWait();
            if (result.get() == ButtonType.OK){
                
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fecha_pago = dateFormat.format(date);
                
                daofactura.registrarPagoDeFacturaEnBanco(id_banco, id_factura, fecha_pago);
                
                Alert pagoFacturaRealizado = new Alert(AlertType.INFORMATION);
                pagoFacturaRealizado.setTitle("Pago de factura en Banco realizado exitosamente");
                pagoFacturaRealizado.setHeaderText("El pago de la factura en Banco se realizó correctamente");
                pagoFacturaRealizado.setContentText("La factura # " + idFacturaBuscar + " figura como pagada en Banco de manera exitosa");
                pagoFacturaRealizado.showAndWait();
                
            } else {
                
                Alert transaccionCancelada = new Alert(AlertType.ERROR);
                transaccionCancelada.setTitle("Transacción cancelada");
                transaccionCancelada.setHeaderText("Transacción cancelada");
                transaccionCancelada.setContentText("El pago de la Factura # " + idFacturaBuscar + " no se ha completado y la Factura no figurará como pagada.");
                transaccionCancelada.showAndWait();
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OperadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    void botonBuscarFacturaPagadaEnBancoAction(ActionEvent event) {

        String idFacturaBuscar = verificarPagoBancoFacturaTF.getText();
        
        if(idFacturaBuscar.equals(""))
        {
            Alert campoFacturaVacio = new Alert(AlertType.WARNING);
            campoFacturaVacio.setTitle("Campo de ID Factura vacío");
            campoFacturaVacio.setHeaderText("Campo de ID Factura a buscar vacío");
            campoFacturaVacio.setContentText("Por favor ingresa un ID factura para poder buscar");
            campoFacturaVacio.showAndWait();
        }
        else
        {
            try {
                
                DAOFactura daofactura = new DAOFactura();
                int id_factura = Integer.parseInt(idFacturaBuscar);
                
                String opcionBanco = seleccionBancoComboBoxVerificar.getValue();
                int id_banco = 0;
                
                if(opcionBanco.equals("Banco 1"))
                {
                    id_banco = 1;
                }
                else if(opcionBanco.equals("Banco 2"))
                {
                    id_banco = 2;
                }
                
                int respuesta = daofactura.existePagoEnBancoConIDFacturaEIDBanco(id_factura, id_banco);
                
                if(respuesta == 1)
                {
                    Alert facturaEncontrada = new Alert(AlertType.INFORMATION);
                    facturaEncontrada.setTitle("Factura pagada en Banco encontrada");
                    facturaEncontrada.setHeaderText("Factura pagada en Banco encontrada exitosamente");
                    facturaEncontrada.setContentText("La factura correspondiente al ID Factura proveido si fue pagada en el Banco proveido");
                    facturaEncontrada.showAndWait();
                    botonRegistrarPagado.setDisable(false);
                }
                else
                {
                    Alert facturaInexistente = new Alert(AlertType.ERROR);
                    facturaInexistente.setTitle("La factura no ha sido pagada en el Banco");
                    facturaInexistente.setHeaderText("No existe pago de tal factura");
                    facturaInexistente.setContentText("Actualmente no se encuentra registro de pago de la factura proveida en el Banco seleccionado");
                    facturaInexistente.showAndWait();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(OperadorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @FXML
    void botonRegistrarPagadoAction(ActionEvent event) {
        
        try {
            
            
            DAOFactura daofactura = new DAOFactura();
            
            String idFacturaBuscar = verificarPagoBancoFacturaTF.getText();
            int id_factura = Integer.parseInt(idFacturaBuscar);
            
            String opcionBanco = seleccionBancoComboBoxVerificar.getValue();
            int id_banco = 0;
                
            if(opcionBanco.equals("Banco 1"))
            {
                id_banco = 1;
            }
            else if(opcionBanco.equals("Banco 2"))
            {
                id_banco = 2;
            }
            
            String fecha_pago = daofactura.obtenerFechaDePagoEnBancoConIDFacturaEIDBanco(id_factura, id_banco);
                
            daofactura.pagarFacturaConIDFactura(id_factura);
            daofactura.fechaFacturaPagadaConIDFactura(id_factura, fecha_pago);
                
            Alert registroPagoEnBancoRealizado = new Alert(AlertType.INFORMATION);
            registroPagoEnBancoRealizado.setTitle("Registro de pago en banco exitoso");
            registroPagoEnBancoRealizado.setHeaderText("El registro de pago en banco se realizó correctamente");
            registroPagoEnBancoRealizado.setContentText("La factura # " + idFacturaBuscar + " figura como pagada de manera exitosa en la Base de Datos de la Empresa");
            registroPagoEnBancoRealizado.showAndWait();
            
        } catch (SQLException ex) {
            Logger.getLogger(OperadorController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        seleccionBancoComboBox.getItems().add("Banco 1");
        seleccionBancoComboBox.getItems().add("Banco 2");
        
        seleccionBancoComboBoxVerificar.getItems().add("Banco 1");
        seleccionBancoComboBoxVerificar.getItems().add("Banco 2");
        
        try {
            FXMLLoader loaderOperadorVBox = new FXMLLoader();
            loaderOperadorVBox.setLocation(getClass().getClassLoader().getResource("proyecto/desarrollo1/java/Vista/OperadorVBox.fxml"));
            VBox operadorBox = loaderOperadorVBox.load();
            drawer.setSidePane(operadorBox);
            
            for (Node node: operadorBox.getChildren())
            {
                if(node.getId() != null)
                {
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                        switch(node.getId())
                        {
                            case "BotonPagarEmpresa" :
                                // Cerramos Verificar
                                verificarPagoBancoLabel.setVisible(false);
                                verificarPagoBancoFacturaTF.setVisible(false);
                                seleccionBancoComboBoxVerificar.setVisible(false);
                                botonBuscarFacturaPagadaEnBanco.setVisible(false);
                                botonRegistrarPagado.setVisible(false);
                                botonRegistrarPagado.setDisable(true);
                                // Cerramos Banco
                                pagoBancoLabel.setVisible(false);
                                pagoBancoFacturaTF.setVisible(false);
                                seleccionBancoComboBox.setVisible(false);
                                botonBuscarFacturaBanco.setVisible(false);
                                botonPagarFacturaBanco.setVisible(false);
                                seleccionBancoComboBox.setDisable(true);
                                botonPagarFacturaBanco.setDisable(true);
                                // Abrimos Directo
                                pagoDirectoLabel.setVisible(true);
                                pagoDirectoFacturaTF.setVisible(true);
                                botonBuscarFacturaDirecto.setVisible(true);
                                botonPagarFacturaDirecto.setVisible(true);
                                break;
                            case "BotonPagarBanco" :
                                // Cerramos Verificar
                                verificarPagoBancoLabel.setVisible(false);
                                verificarPagoBancoFacturaTF.setVisible(false);
                                seleccionBancoComboBoxVerificar.setVisible(false);
                                botonBuscarFacturaPagadaEnBanco.setVisible(false);
                                botonRegistrarPagado.setVisible(false);
                                botonRegistrarPagado.setDisable(true);
                                // Cerramos Directo
                                pagoDirectoLabel.setVisible(false);
                                pagoDirectoFacturaTF.setVisible(false);
                                botonBuscarFacturaDirecto.setVisible(false);
                                botonPagarFacturaDirecto.setVisible(false);
                                botonPagarFacturaDirecto.setDisable(true);
                                // Abrimos Banco
                                pagoBancoLabel.setVisible(true);
                                pagoBancoFacturaTF.setVisible(true);
                                seleccionBancoComboBox.setVisible(true);
                                botonBuscarFacturaBanco.setVisible(true);
                                botonPagarFacturaBanco.setVisible(true);
                                break;
                            case "BotonVerificarPagoBanco" :
                                // Cerramos Banco
                                pagoBancoLabel.setVisible(false);
                                pagoBancoFacturaTF.setVisible(false);
                                seleccionBancoComboBox.setVisible(false);
                                botonBuscarFacturaBanco.setVisible(false);
                                botonPagarFacturaBanco.setVisible(false);
                                seleccionBancoComboBox.setDisable(true);
                                botonPagarFacturaBanco.setDisable(true);
                                // Cerramos Directo
                                pagoDirectoLabel.setVisible(false);
                                pagoDirectoFacturaTF.setVisible(false);
                                botonBuscarFacturaDirecto.setVisible(false);
                                botonPagarFacturaDirecto.setVisible(false);
                                botonPagarFacturaDirecto.setDisable(true);
                                // Abrimos Verificar
                                verificarPagoBancoLabel.setVisible(true);
                                verificarPagoBancoFacturaTF.setVisible(true);
                                seleccionBancoComboBoxVerificar.setVisible(true);
                                botonBuscarFacturaPagadaEnBanco.setVisible(true);
                                botonRegistrarPagado.setVisible(true);
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