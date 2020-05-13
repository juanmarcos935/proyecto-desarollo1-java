package proyecto.desarrollo1.java.ControladoresVista;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import javafx.scene.input.MouseEvent;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import proyecto.desarrollo1.java.DAOs.DAOUsuario;
import proyecto.desarrollo1.java.Modelo.Usuario;

public class AdminController implements Initializable {
    
    @FXML
    private Label modificacionUsuarioLabel;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXButton botonCerrarSesion;

    @FXML
    private Label consultarUsuariosLabel;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXTextField apellidoRegistroTF;

    @FXML
    private JFXTextField loginNuevoUsuarioModificarTF;

    @FXML
    private JFXPasswordField contraseñaUsuarioModificarTF;

    @FXML
    private JFXButton botonGuardarCambiosActivarInactivar;

    @FXML
    private JFXTextField muestraApellidoTF;

    @FXML
    private JFXTextField muestraEstadoTF;

    @FXML
    private JFXButton mostrarInfoBotonConsultaUsuario;

    @FXML
    private Label activarInactivarUsuarioLabel;

    @FXML
    private JFXTextField loginConsultaUsuarioTF;

    @FXML
    private JFXPasswordField passwordConfRegistroTF;

    @FXML
    private JFXTextField nombreRegistroTF;

    @FXML
    private JFXButton botonBorrarUsuario;

    @FXML
    private JFXTextField telefonoRegistroTF;

    @FXML
    private Label borrarUsuariosLabel;

    @FXML
    private Label muestraRolLabel;

    @FXML
    private Label muestraApellidoLabel;

    @FXML
    private JFXButton botonRegistroUsuario;

    @FXML
    private JFXTextField loginUsuarioABorrarTF;

    @FXML
    private JFXTextField nombreUsuarioModificarTF;

    @FXML
    private JFXTextField muestraNombreTF;

    @FXML
    private JFXButton botonBuscarLoginModificar;

    @FXML
    private Label muestraNombreLabel;

    @FXML
    private Label muestraTelefonoLabel;

    @FXML
    private JFXTextField muestraTelefonoTF;

    @FXML
    private JFXTextField muestraCedulaTF;

    @FXML
    private Label muestraEstadoLabel;

    @FXML
    private JFXTextField loginBuscarActivarInactivarTF;

    @FXML
    private JFXTextField apellidoUsuarioModificarTF;

    @FXML
    private JFXComboBox<String> rolesComboBox;

    @FXML
    private JFXTextField cedulaRegistroTF;

    @FXML
    private Label registroUsuarioLabel;

    @FXML
    private JFXTextField loginRegistroTF;

    @FXML
    private JFXTextField muestraRolTF;

    @FXML
    private JFXButton botonBuscarUsuarioBorrar;

    @FXML
    private Label muestraCedulaLabel;

    @FXML
    private JFXToggleButton activoToggle;

    @FXML
    private JFXComboBox<String> comboBoxActivarInactivar;

    @FXML
    private JFXPasswordField passwordRegistroTF;

    @FXML
    private JFXPasswordField contraseñaConfUsuarioModificarTF;

    @FXML
    private JFXButton botonModificarUsuario;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXTextField cedulaUsuarioModificarTF;

    @FXML
    private JFXButton botonBuscarConsultaUsuario;

    @FXML
    private JFXTextField loginUsuarioModificarTF;

    @FXML
    private JFXButton botonBuscarActivarInactivar;

    @FXML
    private JFXTextField telefonoUsuarioModificarTF;
    
    @FXML
    private JFXComboBox<String> cambiarTipoDeUsuarioComboBox;
    
    @FXML
    void botonRegistroUsuarioAction(ActionEvent event) {
        
        if(loginRegistroTF.getText().equals("") || passwordRegistroTF.getText().equals("") || passwordConfRegistroTF.getText().equals("") || nombreRegistroTF.getText().equals("") || apellidoRegistroTF.getText().equals("") || cedulaRegistroTF.getText().equals("") || telefonoRegistroTF.getText().equals(""))
        {
            Alert alertWarningCamposRegistro = new Alert(AlertType.WARNING);
            alertWarningCamposRegistro.setTitle("Campos Vacíos");
            alertWarningCamposRegistro.setHeaderText("Debe rellenar todos los campos del registro");
            alertWarningCamposRegistro.showAndWait();
        }
        else
        if(!passwordRegistroTF.getText().equals(passwordConfRegistroTF.getText()))
        {
            Alert errorCredencialesRegistro = new Alert(AlertType.ERROR);
            errorCredencialesRegistro.setTitle("Error en credenciales");
            errorCredencialesRegistro.setHeaderText("Las contraseñas no coinciden");
            errorCredencialesRegistro.showAndWait();
        }
        else
        {
            try {
                int tipo = 0;
                String tipoCB = rolesComboBox.getValue();
                
                if(tipoCB.equals("Administrador"))
                {
                    tipo = 1;
                }
                else
                    if(tipoCB.equals("Gerente"))
                    {
                        tipo = 2;
                    }
                    else
                        if(tipoCB.equals("Operador"))
                        {
                            tipo = 3;
                        }
                
                int activo = 0;
                boolean activoTB = activoToggle.isSelected();
                
                if(activoTB == false)
                {
                    activo = 0;
                }
                else
                    if(activoTB == true)
                    {
                        activo = 1;
                    }
                
                String loginUsuarioRegistrar = loginRegistroTF.getText();
                String contraseñaUsuarioRegistrar = passwordRegistroTF.getText();
                String nombreUsuarioRegistrar = nombreRegistroTF.getText();
                String apellidoUsuarioRegistrar = apellidoRegistroTF.getText();
                String cedulaUsuarioRegistrar = cedulaRegistroTF.getText();
                String telefonoUsuarioRegistrar = telefonoRegistroTF.getText();
                
                DAOUsuario daousuario = new DAOUsuario();
                
                daousuario.registrarUsuario(tipo, loginUsuarioRegistrar, contraseñaUsuarioRegistrar, nombreUsuarioRegistrar, apellidoUsuarioRegistrar, cedulaUsuarioRegistrar, telefonoUsuarioRegistrar, activo);
                
                Alert informationRegistroUsuarioExitoso = new Alert(AlertType.INFORMATION);
                informationRegistroUsuarioExitoso.setTitle("Registro de Usuario exitoso");
                informationRegistroUsuarioExitoso.setHeaderText("Se ha llevado a cabo de manera exitosa el Registro del Usuario");
                informationRegistroUsuarioExitoso.showAndWait();
                
            } catch (SQLException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    @FXML
    void botonBuscarUsuarioBorrarAction(ActionEvent event) {
        
        try {
            String loginDeBusqueda = loginUsuarioABorrarTF.getText();
            
            DAOUsuario daousuario = new DAOUsuario();
            
            int respuesta = 0;
            
            respuesta = daousuario.verificarSiExisteUsuarioConLogin(loginDeBusqueda);
            
            if(respuesta == -1)
            {
                Alert errorUsuarioNoEncontrado = new Alert(AlertType.ERROR);
                errorUsuarioNoEncontrado.setTitle("Error: Usuario con Login proveido No Encontrado");
                errorUsuarioNoEncontrado.setHeaderText("No existe tal usuario con el login indicado");
                errorUsuarioNoEncontrado.showAndWait();
            }
            else
            if(respuesta == 1)
            {
                Alert infoUsuarioEncontradoBorrarU = new Alert(AlertType.INFORMATION);
                infoUsuarioEncontradoBorrarU.setTitle("Usuario encontrado");
                infoUsuarioEncontradoBorrarU.setHeaderText("El usuario con el login especificado si existe, fue encontrado en la Base de Datos");
                infoUsuarioEncontradoBorrarU.setContentText("Puede realizar el borrado del Usuario");
                infoUsuarioEncontradoBorrarU.showAndWait();
                botonBorrarUsuario.setDisable(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }

    @FXML
    void botonBorrarUsuarioAction(ActionEvent event) {
        
        Alert confirmationBorrarUsuario = new Alert(AlertType.CONFIRMATION);
        confirmationBorrarUsuario.setTitle("Borrado de Usuario");
        confirmationBorrarUsuario.setHeaderText("¿Está seguro de borrar el usuario seleccionado?");
        confirmationBorrarUsuario.setContentText("Se borrará toda la información ligada al usuario en la base de datos. Esta acción no se podrá deshacer");
        
        String loginDeBusqueda = loginUsuarioABorrarTF.getText();
        
        
        Optional<ButtonType> result = confirmationBorrarUsuario.showAndWait();
        if (result.get() == ButtonType.OK){
            
            try {
                DAOUsuario daousuario = new DAOUsuario();
                
                daousuario.borrarUsuarioConLogin(loginDeBusqueda);
                
                Alert infoUsuarioBorradoExito = new Alert(AlertType.INFORMATION);
                infoUsuarioBorradoExito.setTitle("Borrado de Usuario exitoso");
                infoUsuarioBorradoExito.setHeaderText("El usuario ha sido borrado de la Base de Datos exitosamente");
                infoUsuarioBorradoExito.setContentText("Recuerde que esta acción no se puede deshacer y es para siempre");
                infoUsuarioBorradoExito.showAndWait();
            } catch (SQLException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            confirmationBorrarUsuario.close();
        }

    }
    
    
    @FXML
    void botonBuscarConsultaUsuarioAction(ActionEvent event) {
        
        try {
            
            String loginDeBusqueda = loginConsultaUsuarioTF.getText();
            
            DAOUsuario daousuario = new DAOUsuario();
            
            int respuesta = 0;
            
            respuesta = daousuario.verificarSiExisteUsuarioConLogin(loginDeBusqueda);
            
            if(respuesta == -1)
            {
                Alert errorUsuarioNoEncontrado = new Alert(AlertType.ERROR);
                errorUsuarioNoEncontrado.setTitle("Error: Usuario con Login proveido No Encontrado");
                errorUsuarioNoEncontrado.setHeaderText("No existe tal usuario con el login indicado");
                errorUsuarioNoEncontrado.showAndWait();
            }
            else
            if(respuesta == 1)
            {
                Alert infoUsuarioEncontradoConsultarU = new Alert(AlertType.INFORMATION);
                infoUsuarioEncontradoConsultarU.setTitle("Usuario encontrado");
                infoUsuarioEncontradoConsultarU.setHeaderText("El usuario con el login especificado si existe, fue encontrado en la Base de Datos");
                infoUsuarioEncontradoConsultarU.setContentText("Puede realizar la consulta de la información del Usuario");
                infoUsuarioEncontradoConsultarU.showAndWait();
                mostrarInfoBotonConsultaUsuario.setDisable(false);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void mostrarInfoBotonConsultaUsuarioAction(ActionEvent event) {
        
        try {
            String loginDeBusqueda = loginConsultaUsuarioTF.getText();
            
            DAOUsuario daousuario = new DAOUsuario();
            
            Usuario miUsuario;
            
            miUsuario = daousuario.consultaUsuario(loginDeBusqueda);
            
            muestraNombreTF.setText(miUsuario.getNombre());
            muestraApellidoTF.setText(miUsuario.getApellido());
            muestraCedulaTF.setText(miUsuario.getCedula());
            muestraTelefonoTF.setText(miUsuario.getTelefono());
            
            int tipo = miUsuario.getTipo();
            
            switch(tipo)
            {
                case 1:
                    muestraRolTF.setText("Administrador");
                    break;
                case 2:
                    muestraRolTF.setText("Gerente");
                    break;
                case 3:
                    muestraRolTF.setText("Operador");
                    break;
            }
            
            int estado = miUsuario.getActivo();
            
            if(estado == 1)
            {
                muestraEstadoTF.setText("Activado/Habilitado");
            }
            else
            {
                muestraEstadoTF.setText("Inactivado/Inhabilitado");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    @FXML
    void botonModificarUsuarioAction(ActionEvent event) {
        
        try {
            String loginDeBusqueda = loginUsuarioModificarTF.getText();
            
            DAOUsuario daousuario = new DAOUsuario();
            
            int tipo_inicial = 0;
            
            tipo_inicial = daousuario.usuario_ConsultaLogin_DevuelveTipo(loginDeBusqueda);
            
            int tipo_a_modificar = 0;
        
            String tipoModifCB = cambiarTipoDeUsuarioComboBox.getValue();

            switch(tipoModifCB)
            {
                case "Administrador":
                    tipo_a_modificar = 1;
                    break;
                case "Gerente":
                    tipo_a_modificar = 2;
                    break;
                case "Operador":
                    tipo_a_modificar = 3;
                    break;
            }
            
            Usuario miUsuario;
            miUsuario = daousuario.consultaUsuario(loginDeBusqueda);

            if(tipo_inicial == tipo_a_modificar && nombreUsuarioModificarTF.getText().equals("") && apellidoUsuarioModificarTF.getText().equals("") && cedulaUsuarioModificarTF.getText().equals("") && telefonoUsuarioModificarTF.getText().equals("") && loginNuevoUsuarioModificarTF.getText().equals("") && contraseñaUsuarioModificarTF.getText().equals("") && contraseñaConfUsuarioModificarTF.getText().equals(""))
            {
                Alert alertWarningCamposModificar = new Alert(AlertType.WARNING);
                alertWarningCamposModificar.setTitle("Sin modificaciones registradas");
                alertWarningCamposModificar.setHeaderText("No ha registrado ningún cambio, ha dejado los campos de texto vacíos");
                alertWarningCamposModificar.showAndWait();
            }
            else
            if(nombreUsuarioModificarTF.getText().equals(miUsuario.getNombre()) || apellidoUsuarioModificarTF.getText().equals(miUsuario.getApellido()) || cedulaUsuarioModificarTF.getText().equals(miUsuario.getCedula()) || telefonoUsuarioModificarTF.getText().equals(miUsuario.getTelefono()) || loginNuevoUsuarioModificarTF.getText().equals(miUsuario.getLogin()) || contraseñaUsuarioModificarTF.getText().equals(miUsuario.getPassword()) || contraseñaConfUsuarioModificarTF.getText().equals(miUsuario.getPassword()))
            {
                Alert alertWarningCamposModificar2 = new Alert(AlertType.WARNING);
                alertWarningCamposModificar2.setTitle("Campos ha modificar con contenidos iguales a los ya registrados");
                alertWarningCamposModificar2.setHeaderText("Algun(os) campo(s) que ha escrito para su modificación son iguales a los anteriores");
                alertWarningCamposModificar2.setContentText("Esto quiere decir que ha rellenado un campo con su valor antiguo, por favor rellene el campo con una entrada nueva, Si en realidad no desea modificar dicho campo, dejelo vacío");
                alertWarningCamposModificar2.showAndWait();
            }
            else
            if(!contraseñaUsuarioModificarTF.getText().equals(contraseñaConfUsuarioModificarTF.getText()))
            {
                Alert errorCredencialesModificar = new Alert(AlertType.ERROR);
                errorCredencialesModificar.setTitle("Error en credenciales");
                errorCredencialesModificar.setHeaderText("Las contraseñas no coinciden");
                errorCredencialesModificar.showAndWait();
            }
            else
            {
                String nombreUsuarioModificar = nombreUsuarioModificarTF.getText();
                String apellidoUsuarioModificar = apellidoUsuarioModificarTF.getText();
                String cedulaUsuarioModificar = cedulaUsuarioModificarTF.getText();
                String telefonoUsuarioModificar = telefonoUsuarioModificarTF.getText();
                String loginUsuarioModificar = loginNuevoUsuarioModificarTF.getText();
                String contraseñaUsuarioModificar = contraseñaUsuarioModificarTF.getText();
                
                daousuario.modificarUsuario(loginDeBusqueda, tipo_a_modificar, nombreUsuarioModificar, apellidoUsuarioModificar, cedulaUsuarioModificar, telefonoUsuarioModificar, loginUsuarioModificar, contraseñaUsuarioModificar);
                
                
                Alert informationModificacionUsuarioExitoso = new Alert(AlertType.INFORMATION);
                informationModificacionUsuarioExitoso.setTitle("Modificación de Usuario exitosa");
                informationModificacionUsuarioExitoso.setHeaderText("Se ha llevado a cabo de manera exitosa la Modificación del Usuario");
                informationModificacionUsuarioExitoso.showAndWait();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    @FXML
    void botonBuscarActivarInactivarAction(ActionEvent event) {
        
        if(loginBuscarActivarInactivarTF.getText().equals(""))
        {
            Alert warningLoginBuscarActivarInactivar = new Alert(AlertType.WARNING);
            warningLoginBuscarActivarInactivar.setTitle("Campo de Login de Usuario a buscar vacío");
            warningLoginBuscarActivarInactivar.setHeaderText("No se ha proporcionado un login de usuario para consultar su existencia");
            warningLoginBuscarActivarInactivar.showAndWait();
        }
        else
        {
            try {
                String loginDeBusqueda = loginBuscarActivarInactivarTF.getText();
                
                DAOUsuario daousuario = new DAOUsuario();
                
                int estado_inicial;
                
                estado_inicial = daousuario.verificarEstadoDeUsuarioConLogin(loginDeBusqueda);
                
                switch(estado_inicial)
                {
                    case 1:
                        Alert informationUsuarioActivo = new Alert(AlertType.INFORMATION);
                        informationUsuarioActivo.setTitle("Usuario activo");
                        informationUsuarioActivo.setHeaderText("El usuario que ha consultado existe y está actualmente activo");
                        informationUsuarioActivo.showAndWait();
                        comboBoxActivarInactivar.setDisable(false);
                        botonGuardarCambiosActivarInactivar.setDisable(false);
                        break;
                    case 0:
                        Alert informationUsuarioInactivo = new Alert(AlertType.INFORMATION);
                        informationUsuarioInactivo.setTitle("Usuario inactivo");
                        informationUsuarioInactivo.setHeaderText("El usuario que ha consultado existe y está actualmente inactivo");
                        informationUsuarioInactivo.showAndWait();
                        comboBoxActivarInactivar.setDisable(false);
                        botonGuardarCambiosActivarInactivar.setDisable(false);
                        break;
                    default:
                        Alert errorUsuarioNoEncontradoActivarInactivar = new Alert(AlertType.ERROR);
                        errorUsuarioNoEncontradoActivarInactivar.setTitle("Usuario no encontrado");
                        errorUsuarioNoEncontradoActivarInactivar.setHeaderText("El usuario que ha consultado no existe en la Base de Datos");
                        errorUsuarioNoEncontradoActivarInactivar.showAndWait();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    @FXML
    void botonGuardarCambiosActivarInactivarAction(ActionEvent event) {
        try {
            
            String loginDeBusqueda = loginBuscarActivarInactivarTF.getText();
            int activo_inicial = 0;
            DAOUsuario daousuario = new DAOUsuario();
            
            activo_inicial = daousuario.verificarEstadoDeUsuarioConLogin(loginDeBusqueda);
            
            String opcion_seleccionada = comboBoxActivarInactivar.getValue();
            
            int activo_final;
            
            if(opcion_seleccionada.equals("Activar usuario") && activo_inicial == 1)
            {
                Alert errorYaActivo = new Alert(AlertType.ERROR);
                errorYaActivo.setTitle("Usuario actualmente activado");
                errorYaActivo.setHeaderText("El usuario ya se encuentra activado en el sistema");
                errorYaActivo.setContentText("No se puede activar debido a que ya está activado");
                errorYaActivo.showAndWait();
            }
            else
            if(opcion_seleccionada.equals("Inactivar usuario") && activo_inicial == 0)
            {
                Alert errorYaInactivo = new Alert(AlertType.ERROR);
                errorYaInactivo.setTitle("Usuario actualmente inactivado");
                errorYaInactivo.setHeaderText("El usuario ya se encuentra inactivado en el sistema");
                errorYaInactivo.setContentText("No se puede inactivar debido a que ya está inactivado");
                errorYaInactivo.showAndWait();
            }
            else
            if(opcion_seleccionada.equals("Activar usuario") && activo_inicial == 0)
            {
                activo_final = 1;
                daousuario.cambiarEstadoDeUsuario(loginDeBusqueda, activo_final);
                
                Alert usuarioActivadoExitosamente = new Alert(AlertType.INFORMATION);
                usuarioActivadoExitosamente.setTitle("Usuario activado/habilitado exitosamente");
                usuarioActivadoExitosamente.setHeaderText("El usuario ha sido activado/habilitado exitosamente");
                usuarioActivadoExitosamente.showAndWait();
            }
            else
            if(opcion_seleccionada.equals("Inactivar usuario") && activo_inicial == 1)
            {
               activo_final = 0; 
               daousuario.cambiarEstadoDeUsuario(loginDeBusqueda, activo_final);
               
               Alert usuarioInactivadoExitosamente = new Alert(AlertType.INFORMATION);
               usuarioInactivadoExitosamente.setTitle("Usuario inactivado/inhabilitado exitosamente");
               usuarioInactivadoExitosamente.setHeaderText("El usuario ha sido inactivado/inhabilitado exitosamente");
               usuarioInactivadoExitosamente.showAndWait();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void botonBuscarLoginModificarAction(ActionEvent event) {
        
        if(loginUsuarioModificarTF.getText().equals(""))
        {
            Alert warningLoginBuscarModif = new Alert(AlertType.WARNING);
            warningLoginBuscarModif.setTitle("Campo de Login de Usuario a buscar vacío");
            warningLoginBuscarModif.setHeaderText("No se ha proporcionado un login de usuario para consultar su existencia");
            warningLoginBuscarModif.showAndWait();
        }
        else
        {
            try {
                
                String loginABuscar = loginUsuarioModificarTF.getText();
                DAOUsuario daousuario = new DAOUsuario();
                int respuesta;
                
                respuesta = daousuario.verificarSiExisteUsuarioConLogin(loginABuscar);
                
                if(respuesta == 1)
                {
                    Alert infoUsuarioEncontradoMOD = new Alert(AlertType.INFORMATION);
                    infoUsuarioEncontradoMOD.setTitle("Usuario encontrado");
                    infoUsuarioEncontradoMOD.setHeaderText("El usuario con el login especificado si existe, fue encontrado en la Base de Datos");
                    infoUsuarioEncontradoMOD.setContentText("Puede realizar modificaciones sobre la información del Usuario");
                    infoUsuarioEncontradoMOD.showAndWait();
                    
                    int respuesta_tipo = daousuario.usuario_ConsultaLogin_DevuelveTipo(loginABuscar);
                    
                    switch(respuesta_tipo)
                    {
                        case 1:
                            cambiarTipoDeUsuarioComboBox.setValue("Administrador");
                            break;
                        case 2:
                            cambiarTipoDeUsuarioComboBox.setValue("Gerente");
                            break;
                        case 3:
                            cambiarTipoDeUsuarioComboBox.setValue("Operador");
                            break;
                    }
                    
                    cambiarTipoDeUsuarioComboBox.setDisable(false);
                    nombreUsuarioModificarTF.setDisable(false);
                    apellidoUsuarioModificarTF.setDisable(false);
                    cedulaUsuarioModificarTF.setDisable(false);
                    telefonoUsuarioModificarTF.setDisable(false);
                    loginNuevoUsuarioModificarTF.setDisable(false);
                    contraseñaUsuarioModificarTF.setDisable(false);
                    contraseñaConfUsuarioModificarTF.setDisable(false);
                    botonModificarUsuario.setDisable(false);
                }
                else
                {
                    Alert errorUsuarioNoEncontrado = new Alert(AlertType.ERROR);
                    errorUsuarioNoEncontrado.setTitle("Error: Usuario con Login proveido No Encontrado");
                    errorUsuarioNoEncontrado.setHeaderText("No existe tal usuario con el login indicado");
                    errorUsuarioNoEncontrado.showAndWait();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    @FXML
    void botonCerrarSesionAction(ActionEvent event) throws IOException {
        
        Alert confirmationCerrarSesion = new Alert(AlertType.CONFIRMATION);
        confirmationCerrarSesion.setTitle("Cierre de Sesión");
        confirmationCerrarSesion.setHeaderText("¿Estás seguro de cerrar sesión como Administador y volver a la pantalla de Login principal?");

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
        
        comboBoxActivarInactivar.getItems().add("Activar usuario");
        comboBoxActivarInactivar.getItems().add("Inactivar usuario");
        
        rolesComboBox.getItems().add("Administrador");
        rolesComboBox.getItems().add("Gerente");
        rolesComboBox.getItems().add("Operador");
        
        cambiarTipoDeUsuarioComboBox.getItems().add("Administrador");
        cambiarTipoDeUsuarioComboBox.getItems().add("Gerente");
        cambiarTipoDeUsuarioComboBox.getItems().add("Operador");
        
        
        try {
            FXMLLoader loaderAdminVBox = new FXMLLoader();
            loaderAdminVBox.setLocation(getClass().getClassLoader().getResource("proyecto/desarrollo1/java/Vista/AdminVBox.fxml"));
            VBox adminBox = loaderAdminVBox.load();
            drawer.setSidePane(adminBox);
            
            for (Node node: adminBox.getChildren())
            {
                if(node.getId() != null)
                {
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                        switch(node.getId())
                        {
                            case "BotonRegistrarUsuarios" : 
                                // Cerramos Borrar
                                borrarUsuariosLabel.setVisible(false);
                                loginUsuarioABorrarTF.setVisible(false);
                                botonBuscarUsuarioBorrar.setVisible(false);
                                botonBorrarUsuario.setVisible(false);
                                botonBorrarUsuario.setDisable(true);
                                // Cerramos Consultar 
                                consultarUsuariosLabel.setVisible(false);
                                loginConsultaUsuarioTF.setVisible(false);
                                botonBuscarConsultaUsuario.setVisible(false);
                                mostrarInfoBotonConsultaUsuario.setVisible(false);
                                muestraNombreTF.setVisible(false);
                                muestraApellidoTF.setVisible(false);
                                muestraCedulaTF.setVisible(false);
                                muestraTelefonoTF.setVisible(false);
                                muestraRolTF.setVisible(false);
                                muestraEstadoTF.setVisible(false);
                                muestraNombreLabel.setVisible(false);
                                muestraApellidoLabel.setVisible(false);
                                muestraCedulaLabel.setVisible(false);
                                muestraTelefonoLabel.setVisible(false);
                                muestraRolLabel.setVisible(false);
                                muestraEstadoLabel.setVisible(false);
                                mostrarInfoBotonConsultaUsuario.setDisable(true);
                                muestraNombreTF.setText("");
                                muestraApellidoTF.setText("");
                                muestraCedulaTF.setText("");
                                muestraTelefonoTF.setText("");
                                muestraRolTF.setText("");
                                muestraEstadoTF.setText("");
                                // Cerramos Activar / inactivar
                                activarInactivarUsuarioLabel.setVisible(false);
                                loginBuscarActivarInactivarTF.setVisible(false);
                                botonBuscarActivarInactivar.setVisible(false);
                                comboBoxActivarInactivar.setVisible(false);
                                botonGuardarCambiosActivarInactivar.setVisible(false);
                                comboBoxActivarInactivar.setDisable(true);
                                botonGuardarCambiosActivarInactivar.setDisable(true);
                                // Cerramos Modificar
                                modificacionUsuarioLabel.setVisible(false);
                                loginUsuarioModificarTF.setVisible(false);
                                botonBuscarLoginModificar.setVisible(false);
                                nombreUsuarioModificarTF.setVisible(false);
                                apellidoUsuarioModificarTF.setVisible(false);
                                cedulaUsuarioModificarTF.setVisible(false);
                                telefonoUsuarioModificarTF.setVisible(false);
                                loginNuevoUsuarioModificarTF.setVisible(false);
                                contraseñaUsuarioModificarTF.setVisible(false);
                                contraseñaConfUsuarioModificarTF.setVisible(false);
                                botonModificarUsuario.setVisible(false);
                                nombreUsuarioModificarTF.setDisable(true);
                                apellidoUsuarioModificarTF.setDisable(true);
                                cedulaUsuarioModificarTF.setDisable(true);
                                telefonoUsuarioModificarTF.setDisable(true);
                                loginNuevoUsuarioModificarTF.setDisable(true);
                                contraseñaUsuarioModificarTF.setDisable(true);
                                contraseñaConfUsuarioModificarTF.setDisable(true);
                                botonModificarUsuario.setDisable(true);
                                cambiarTipoDeUsuarioComboBox.setVisible(false);
                                cambiarTipoDeUsuarioComboBox.setDisable(true);
                                // Abrimos Registro
                                registroUsuarioLabel.setVisible(true);
                                rolesComboBox.setVisible(true);
                                loginRegistroTF.setVisible(true);
                                passwordRegistroTF.setVisible(true);
                                passwordConfRegistroTF.setVisible(true);
                                nombreRegistroTF.setVisible(true);
                                apellidoRegistroTF.setVisible(true);
                                cedulaRegistroTF.setVisible(true);
                                telefonoRegistroTF.setVisible(true);
                                activoToggle.setVisible(true);
                                botonRegistroUsuario.setVisible(true);
                                break;
                            case "BotonModificarUsuarios" : 
                                // Cerramos Borrar
                                borrarUsuariosLabel.setVisible(false);
                                loginUsuarioABorrarTF.setVisible(false);
                                botonBuscarUsuarioBorrar.setVisible(false);
                                botonBorrarUsuario.setVisible(false);
                                botonBorrarUsuario.setDisable(true);
                                // Cerramos Consultar 
                                consultarUsuariosLabel.setVisible(false);
                                loginConsultaUsuarioTF.setVisible(false);
                                botonBuscarConsultaUsuario.setVisible(false);
                                mostrarInfoBotonConsultaUsuario.setVisible(false);
                                muestraNombreTF.setVisible(false);
                                muestraApellidoTF.setVisible(false);
                                muestraCedulaTF.setVisible(false);
                                muestraTelefonoTF.setVisible(false);
                                muestraRolTF.setVisible(false);
                                muestraEstadoTF.setVisible(false);
                                muestraNombreLabel.setVisible(false);
                                muestraApellidoLabel.setVisible(false);
                                muestraCedulaLabel.setVisible(false);
                                muestraTelefonoLabel.setVisible(false);
                                muestraRolLabel.setVisible(false);
                                muestraEstadoLabel.setVisible(false);
                                mostrarInfoBotonConsultaUsuario.setDisable(true);
                                muestraNombreTF.setText("");
                                muestraApellidoTF.setText("");
                                muestraCedulaTF.setText("");
                                muestraTelefonoTF.setText("");
                                muestraRolTF.setText("");
                                muestraEstadoTF.setText("");
                                // Cerramos Activar / inactivar
                                activarInactivarUsuarioLabel.setVisible(false);
                                loginBuscarActivarInactivarTF.setVisible(false);
                                botonBuscarActivarInactivar.setVisible(false);
                                comboBoxActivarInactivar.setVisible(false);
                                botonGuardarCambiosActivarInactivar.setVisible(false);
                                comboBoxActivarInactivar.setDisable(true);
                                botonGuardarCambiosActivarInactivar.setDisable(true);
                                // Cerramos Registro
                                registroUsuarioLabel.setVisible(false);
                                rolesComboBox.setVisible(false);
                                loginRegistroTF.setVisible(false);
                                passwordRegistroTF.setVisible(false);
                                passwordConfRegistroTF.setVisible(false);
                                nombreRegistroTF.setVisible(false);
                                apellidoRegistroTF.setVisible(false);
                                cedulaRegistroTF.setVisible(false);
                                telefonoRegistroTF.setVisible(false);
                                activoToggle.setVisible(false);
                                botonRegistroUsuario.setVisible(false);
                                // Abrimos Modificar
                                modificacionUsuarioLabel.setVisible(true);
                                loginUsuarioModificarTF.setVisible(true);
                                botonBuscarLoginModificar.setVisible(true);
                                nombreUsuarioModificarTF.setVisible(true);
                                apellidoUsuarioModificarTF.setVisible(true);
                                cedulaUsuarioModificarTF.setVisible(true);
                                telefonoUsuarioModificarTF.setVisible(true);
                                loginNuevoUsuarioModificarTF.setVisible(true);
                                contraseñaUsuarioModificarTF.setVisible(true);
                                contraseñaConfUsuarioModificarTF.setVisible(true);
                                botonModificarUsuario.setVisible(true);
                                cambiarTipoDeUsuarioComboBox.setVisible(true);
                                break;
                            case "ActivarInactivarUsuarios" :
                                // Cerramos Borrar
                                borrarUsuariosLabel.setVisible(false);
                                loginUsuarioABorrarTF.setVisible(false);
                                botonBuscarUsuarioBorrar.setVisible(false);
                                botonBorrarUsuario.setVisible(false);
                                botonBorrarUsuario.setDisable(true);
                                // Cerramos Consultar 
                                consultarUsuariosLabel.setVisible(false);
                                loginConsultaUsuarioTF.setVisible(false);
                                botonBuscarConsultaUsuario.setVisible(false);
                                mostrarInfoBotonConsultaUsuario.setVisible(false);
                                muestraNombreTF.setVisible(false);
                                muestraApellidoTF.setVisible(false);
                                muestraCedulaTF.setVisible(false);
                                muestraTelefonoTF.setVisible(false);
                                muestraRolTF.setVisible(false);
                                muestraEstadoTF.setVisible(false);
                                muestraNombreLabel.setVisible(false);
                                muestraApellidoLabel.setVisible(false);
                                muestraCedulaLabel.setVisible(false);
                                muestraTelefonoLabel.setVisible(false);
                                muestraRolLabel.setVisible(false);
                                muestraEstadoLabel.setVisible(false);
                                mostrarInfoBotonConsultaUsuario.setDisable(true);
                                muestraNombreTF.setText("");
                                muestraApellidoTF.setText("");
                                muestraCedulaTF.setText("");
                                muestraTelefonoTF.setText("");
                                muestraRolTF.setText("");
                                muestraEstadoTF.setText("");
                                // Cerramos Modificar
                                modificacionUsuarioLabel.setVisible(false);
                                loginUsuarioModificarTF.setVisible(false);
                                botonBuscarLoginModificar.setVisible(false);
                                nombreUsuarioModificarTF.setVisible(false);
                                apellidoUsuarioModificarTF.setVisible(false);
                                cedulaUsuarioModificarTF.setVisible(false);
                                telefonoUsuarioModificarTF.setVisible(false);
                                loginNuevoUsuarioModificarTF.setVisible(false);
                                contraseñaUsuarioModificarTF.setVisible(false);
                                contraseñaConfUsuarioModificarTF.setVisible(false);
                                botonModificarUsuario.setVisible(false);
                                nombreUsuarioModificarTF.setDisable(true);
                                apellidoUsuarioModificarTF.setDisable(true);
                                cedulaUsuarioModificarTF.setDisable(true);
                                telefonoUsuarioModificarTF.setDisable(true);
                                loginNuevoUsuarioModificarTF.setDisable(true);
                                contraseñaUsuarioModificarTF.setDisable(true);
                                contraseñaConfUsuarioModificarTF.setDisable(true);
                                botonModificarUsuario.setDisable(true);
                                cambiarTipoDeUsuarioComboBox.setVisible(false);
                                cambiarTipoDeUsuarioComboBox.setDisable(true);
                                // Cerramos Registro
                                registroUsuarioLabel.setVisible(false);
                                rolesComboBox.setVisible(false);
                                loginRegistroTF.setVisible(false);
                                passwordRegistroTF.setVisible(false);
                                passwordConfRegistroTF.setVisible(false);
                                nombreRegistroTF.setVisible(false);
                                apellidoRegistroTF.setVisible(false);
                                cedulaRegistroTF.setVisible(false);
                                telefonoRegistroTF.setVisible(false);
                                activoToggle.setVisible(false);
                                botonRegistroUsuario.setVisible(false);
                                // Abrimos Activar / inactivar
                                activarInactivarUsuarioLabel.setVisible(true);
                                loginBuscarActivarInactivarTF.setVisible(true);
                                botonBuscarActivarInactivar.setVisible(true);
                                comboBoxActivarInactivar.setVisible(true);
                                botonGuardarCambiosActivarInactivar.setVisible(true);
                                break;
                            case "ConsultarUsuarios" : 
                                // Cerramos Borrar
                                borrarUsuariosLabel.setVisible(false);
                                loginUsuarioABorrarTF.setVisible(false);
                                botonBuscarUsuarioBorrar.setVisible(false);
                                botonBorrarUsuario.setVisible(false);
                                botonBorrarUsuario.setDisable(true);
                                // Cerramos Activar / inactivar
                                activarInactivarUsuarioLabel.setVisible(false);
                                loginBuscarActivarInactivarTF.setVisible(false);
                                botonBuscarActivarInactivar.setVisible(false);
                                comboBoxActivarInactivar.setVisible(false);
                                botonGuardarCambiosActivarInactivar.setVisible(false);
                                comboBoxActivarInactivar.setDisable(true);
                                botonGuardarCambiosActivarInactivar.setDisable(true);
                                // Cerramos Modificar
                                modificacionUsuarioLabel.setVisible(false);
                                loginUsuarioModificarTF.setVisible(false);
                                botonBuscarLoginModificar.setVisible(false);
                                nombreUsuarioModificarTF.setVisible(false);
                                apellidoUsuarioModificarTF.setVisible(false);
                                cedulaUsuarioModificarTF.setVisible(false);
                                telefonoUsuarioModificarTF.setVisible(false);
                                loginNuevoUsuarioModificarTF.setVisible(false);
                                contraseñaUsuarioModificarTF.setVisible(false);
                                contraseñaConfUsuarioModificarTF.setVisible(false);
                                botonModificarUsuario.setVisible(false);
                                nombreUsuarioModificarTF.setDisable(true);
                                apellidoUsuarioModificarTF.setDisable(true);
                                cedulaUsuarioModificarTF.setDisable(true);
                                telefonoUsuarioModificarTF.setDisable(true);
                                loginNuevoUsuarioModificarTF.setDisable(true);
                                contraseñaUsuarioModificarTF.setDisable(true);
                                contraseñaConfUsuarioModificarTF.setDisable(true);
                                botonModificarUsuario.setDisable(true);
                                cambiarTipoDeUsuarioComboBox.setVisible(false);
                                cambiarTipoDeUsuarioComboBox.setDisable(true);
                                // Cerramos Registro
                                registroUsuarioLabel.setVisible(false);
                                rolesComboBox.setVisible(false);
                                loginRegistroTF.setVisible(false);
                                passwordRegistroTF.setVisible(false);
                                passwordConfRegistroTF.setVisible(false);
                                nombreRegistroTF.setVisible(false);
                                apellidoRegistroTF.setVisible(false);
                                cedulaRegistroTF.setVisible(false);
                                telefonoRegistroTF.setVisible(false);
                                activoToggle.setVisible(false);
                                botonRegistroUsuario.setVisible(false);
                                // Abrimos Consultar 
                                consultarUsuariosLabel.setVisible(true);
                                loginConsultaUsuarioTF.setVisible(true);
                                botonBuscarConsultaUsuario.setVisible(true);
                                mostrarInfoBotonConsultaUsuario.setVisible(true);
                                muestraNombreTF.setVisible(true);
                                muestraApellidoTF.setVisible(true);
                                muestraCedulaTF.setVisible(true);
                                muestraTelefonoTF.setVisible(true);
                                muestraRolTF.setVisible(true);
                                muestraEstadoTF.setVisible(true);
                                muestraNombreLabel.setVisible(true);
                                muestraApellidoLabel.setVisible(true);
                                muestraCedulaLabel.setVisible(true);
                                muestraTelefonoLabel.setVisible(true);
                                muestraRolLabel.setVisible(true);
                                muestraEstadoLabel.setVisible(true);
                                break;
                            case "BorrarUsuarios" : 
                                // Cerramos Consultar 
                                consultarUsuariosLabel.setVisible(false);
                                loginConsultaUsuarioTF.setVisible(false);
                                botonBuscarConsultaUsuario.setVisible(false);
                                mostrarInfoBotonConsultaUsuario.setVisible(false);
                                muestraNombreTF.setVisible(false);
                                muestraApellidoTF.setVisible(false);
                                muestraCedulaTF.setVisible(false);
                                muestraTelefonoTF.setVisible(false);
                                muestraRolTF.setVisible(false);
                                muestraEstadoTF.setVisible(false);
                                muestraNombreLabel.setVisible(false);
                                muestraApellidoLabel.setVisible(false);
                                muestraCedulaLabel.setVisible(false);
                                muestraTelefonoLabel.setVisible(false);
                                muestraRolLabel.setVisible(false);
                                muestraEstadoLabel.setVisible(false);
                                mostrarInfoBotonConsultaUsuario.setDisable(true);
                                muestraNombreTF.setText("");
                                muestraApellidoTF.setText("");
                                muestraCedulaTF.setText("");
                                muestraTelefonoTF.setText("");
                                muestraRolTF.setText("");
                                muestraEstadoTF.setText("");
                                // Cerramos Activar / inactivar
                                activarInactivarUsuarioLabel.setVisible(false);
                                loginBuscarActivarInactivarTF.setVisible(false);
                                botonBuscarActivarInactivar.setVisible(false);
                                comboBoxActivarInactivar.setVisible(false);
                                botonGuardarCambiosActivarInactivar.setVisible(false);
                                comboBoxActivarInactivar.setDisable(true);
                                botonGuardarCambiosActivarInactivar.setDisable(true);
                                // Cerramos Modificar
                                modificacionUsuarioLabel.setVisible(false);
                                loginUsuarioModificarTF.setVisible(false);
                                botonBuscarLoginModificar.setVisible(false);
                                nombreUsuarioModificarTF.setVisible(false);
                                apellidoUsuarioModificarTF.setVisible(false);
                                cedulaUsuarioModificarTF.setVisible(false);
                                telefonoUsuarioModificarTF.setVisible(false);
                                loginNuevoUsuarioModificarTF.setVisible(false);
                                contraseñaUsuarioModificarTF.setVisible(false);
                                contraseñaConfUsuarioModificarTF.setVisible(false);
                                botonModificarUsuario.setVisible(false);
                                nombreUsuarioModificarTF.setDisable(true);
                                apellidoUsuarioModificarTF.setDisable(true);
                                cedulaUsuarioModificarTF.setDisable(true);
                                telefonoUsuarioModificarTF.setDisable(true);
                                loginNuevoUsuarioModificarTF.setDisable(true);
                                contraseñaUsuarioModificarTF.setDisable(true);
                                contraseñaConfUsuarioModificarTF.setDisable(true);
                                botonModificarUsuario.setDisable(true);
                                cambiarTipoDeUsuarioComboBox.setVisible(false);
                                cambiarTipoDeUsuarioComboBox.setDisable(true);
                                // Cerramos Registro
                                registroUsuarioLabel.setVisible(false);
                                rolesComboBox.setVisible(false);
                                loginRegistroTF.setVisible(false);
                                passwordRegistroTF.setVisible(false);
                                passwordConfRegistroTF.setVisible(false);
                                nombreRegistroTF.setVisible(false);
                                apellidoRegistroTF.setVisible(false);
                                cedulaRegistroTF.setVisible(false);
                                telefonoRegistroTF.setVisible(false);
                                activoToggle.setVisible(false);
                                botonRegistroUsuario.setVisible(false);
                                // Abrimos Borrar
                                borrarUsuariosLabel.setVisible(true);
                                loginUsuarioABorrarTF.setVisible(true);
                                botonBuscarUsuarioBorrar.setVisible(true);
                                botonBorrarUsuario.setVisible(true);
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
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    
}
