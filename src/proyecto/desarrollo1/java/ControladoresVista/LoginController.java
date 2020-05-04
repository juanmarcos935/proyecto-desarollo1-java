
package proyecto.desarrollo1.java.ControladoresVista;

import com.jfoenix.controls.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import proyecto.desarrollo1.java.DAOs.DAOUsuario;


/**
 *
 * @author marcos
 */
public class LoginController implements Initializable {
    @FXML 
    private JFXButton iniciarSesionJFXButton;
    
    @FXML
    private JFXTextField loginTextField;
    
    @FXML
    private JFXPasswordField passwordField;
    
    @FXML
    private JFXButton cerrarProgramaJFXButton;
    
    @FXML
    private void iniciarSesionKey(KeyEvent event) throws IOException, SQLException
    {
        if(event.getCode() == KeyCode.ENTER)
        {
            Stage stage = (Stage) iniciarSesionJFXButton.getScene().getWindow();
        
            String login = loginTextField.getText();
            String password = passwordField.getText();
        
            if(login.equals("") || password.equals(""))
            {
                Alert warningLoginVacio = new Alert(AlertType.INFORMATION);
                warningLoginVacio.setTitle("Campos Vacíos");
                warningLoginVacio.setHeaderText("Tiene uno o mas campos vacíos en el Login");
                warningLoginVacio.showAndWait();
            }
            else
            {
                int response = 0, response2 = 0;
                DAOUsuario daousuario = new DAOUsuario();

                try 
                {
                    response = daousuario.usuarioConsultaLoginPassword_DevuelveActivo(login, password);
                } 
                catch (SQLException ex) 
                {
                    ex.printStackTrace();
                }

                try 
                {
                    response2 = daousuario.usuario_ConsultaLogin_DevuelveTipo(login);
                } 
                catch (SQLException ex) 
                {
                    ex.printStackTrace();
                }

                switch (response) {
                            case -1:
                                    Alert errorCredenciales = new Alert(AlertType.ERROR);
                                    errorCredenciales.setTitle("Error en credenciales");
                                    errorCredenciales.setHeaderText("Login y/o contraseña incorrectos");
                                    errorCredenciales.showAndWait();
                                break;
                            case 0:
                                    Alert errorUsuarioInactivo = new Alert(AlertType.ERROR);
                                    errorUsuarioInactivo.setTitle("Usuario desactivado");
                                    errorUsuarioInactivo.setHeaderText("Su usuario se encuentra desactivado, por favor contacte al administrador del sistema");
                                    errorUsuarioInactivo.showAndWait();
                                break;
                            case 1:
                                switch (response2) {
                                    case 1:
                                            Alert avisoInicioSesionExitosoAdmin = new Alert(AlertType.INFORMATION);
                                            avisoInicioSesionExitosoAdmin.setTitle("Entrando a CeluSoft como Administrador");
                                            avisoInicioSesionExitosoAdmin.setHeaderText("Inicio de Sesión Exitoso como Administrador");
                                            avisoInicioSesionExitosoAdmin.showAndWait();
                                            stage.close();
                                            FXMLLoader loaderAdmin = new FXMLLoader();
                                            loaderAdmin.setLocation(getClass().getClassLoader().getResource("proyecto/desarrollo1/java/Vista/Admin.fxml"));
                                            Parent rootAdmin = loaderAdmin.load();
                                            Scene sceneAdmin = new Scene(rootAdmin);
                                            Stage stageAdmin = new Stage();
                                            stageAdmin.setScene(sceneAdmin);
                                            stageAdmin.setTitle("CeluSoft como Administrador");
                                            stageAdmin.show();
                                        break;
                                    case 2:
                                            Alert avisoInicioSesionExitosoGerente = new Alert(AlertType.INFORMATION);
                                            avisoInicioSesionExitosoGerente.setTitle("Entrando a CeluSoft como Gerente");
                                            avisoInicioSesionExitosoGerente.setHeaderText("Inicio de Sesión Exitoso como Gerente");
                                            avisoInicioSesionExitosoGerente.showAndWait();
                                            stage.close();
                                            FXMLLoader loaderGerente = new FXMLLoader();
                                            loaderGerente.setLocation(getClass().getClassLoader().getResource("proyecto/desarrollo1/java/Vista/Gerente.fxml"));
                                            Parent rootGerente = loaderGerente.load();
                                            Scene sceneGerente = new Scene(rootGerente);
                                            Stage stageGerente = new Stage();
                                            stageGerente.setScene(sceneGerente);
                                            stageGerente.setTitle("CeluSoft como Gerente");
                                            stageGerente.show();
                                        break;
                                    case 3:
                                            Alert avisoInicioSesionExitosoOperador = new Alert(AlertType.INFORMATION);
                                            avisoInicioSesionExitosoOperador.setTitle("Entrando a CeluSoft como Operador");
                                            avisoInicioSesionExitosoOperador.setHeaderText("Inicio de Sesión Exitoso como Operador");
                                            avisoInicioSesionExitosoOperador.showAndWait();
                                            stage.close();
                                            FXMLLoader loaderOperador = new FXMLLoader();
                                            loaderOperador.setLocation(getClass().getClassLoader().getResource("proyecto/desarrollo1/java/Vista/Operador.fxml"));
                                            Parent rootOperador = loaderOperador.load();
                                            Scene sceneOperador = new Scene(rootOperador);
                                            Stage stageOperador = new Stage();
                                            stageOperador.setScene(sceneOperador);
                                            stageOperador.setTitle("CeluSoft como Operador");
                                            stageOperador.show();
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            default:
                                break;
                        }
            }
        }
    }
    
    @FXML
    private void iniciarSesionAction(ActionEvent event) throws IOException, SQLException {
        
        Stage stage = (Stage) iniciarSesionJFXButton.getScene().getWindow();
        
        String login = loginTextField.getText();
        String password = passwordField.getText();
        
        if(login.equals("") || password.equals(""))
        {
            Alert warningLoginVacio = new Alert(AlertType.INFORMATION);
            warningLoginVacio.setTitle("Campos Vacíos");
            warningLoginVacio.setHeaderText("Tiene uno o mas campos vacíos en el Login");
            warningLoginVacio.showAndWait();
        }
        else
        {
            int response = 0, response2 = 0;
            DAOUsuario daousuario = new DAOUsuario();
            
            try 
            {
                response = daousuario.usuarioConsultaLoginPassword_DevuelveActivo(login, password);
            } 
            catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
            
            try 
            {
                response2 = daousuario.usuario_ConsultaLogin_DevuelveTipo(login);
            } 
            catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
            
            switch (response) {
                        case -1:
                                Alert errorCredenciales = new Alert(AlertType.ERROR);
                                errorCredenciales.setTitle("Error en credenciales");
                                errorCredenciales.setHeaderText("Login y/o contraseña incorrectos");
                                errorCredenciales.showAndWait();
                            break;
                        case 0:
                                Alert errorUsuarioInactivo = new Alert(AlertType.ERROR);
                                errorUsuarioInactivo.setTitle("Usuario desactivado");
                                errorUsuarioInactivo.setHeaderText("Su usuario se encuentra desactivado, por favor contacte al administrador del sistema");
                                errorUsuarioInactivo.showAndWait();
                            break;
                        case 1:
                            switch (response2) {
                                case 1:
                                        Alert avisoInicioSesionExitosoAdmin = new Alert(AlertType.INFORMATION);
                                        avisoInicioSesionExitosoAdmin.setTitle("Entrando a CeluSoft como Administrador");
                                        avisoInicioSesionExitosoAdmin.setHeaderText("Inicio de Sesión Exitoso como Administrador");
                                        avisoInicioSesionExitosoAdmin.showAndWait();
                                        stage.close();
                                        FXMLLoader loaderAdmin = new FXMLLoader();
                                        loaderAdmin.setLocation(getClass().getClassLoader().getResource("proyecto/desarrollo1/java/Vista/Admin.fxml"));
                                        Parent rootAdmin = loaderAdmin.load();
                                        Scene sceneAdmin = new Scene(rootAdmin);
                                        Stage stageAdmin = new Stage();
                                        stageAdmin.setScene(sceneAdmin);
                                        stageAdmin.show();
                                    break;
                                case 2:
                                        Alert avisoInicioSesionExitosoGerente = new Alert(AlertType.INFORMATION);
                                        avisoInicioSesionExitosoGerente.setTitle("Entrando a CeluSoft como Gerente");
                                        avisoInicioSesionExitosoGerente.setHeaderText("Inicio de Sesión Exitoso como Gerente");
                                        avisoInicioSesionExitosoGerente.showAndWait();
                                        stage.close();
                                        FXMLLoader loaderGerente = new FXMLLoader();
                                        loaderGerente.setLocation(getClass().getClassLoader().getResource("proyecto/desarrollo1/java/Vista/Gerente.fxml"));
                                        Parent rootGerente = loaderGerente.load();
                                        Scene sceneGerente = new Scene(rootGerente);
                                        Stage stageGerente = new Stage();
                                        stageGerente.setScene(sceneGerente);
                                        stageGerente.show();
                                    break;
                                case 3:
                                        Alert avisoInicioSesionExitosoOperador = new Alert(AlertType.INFORMATION);
                                        avisoInicioSesionExitosoOperador.setTitle("Entrando a CeluSoft como Operador");
                                        avisoInicioSesionExitosoOperador.setHeaderText("Inicio de Sesión Exitoso como Operador");
                                        avisoInicioSesionExitosoOperador.showAndWait();
                                        stage.close();
                                        FXMLLoader loaderOperador = new FXMLLoader();
                                        loaderOperador.setLocation(getClass().getClassLoader().getResource("proyecto/desarrollo1/java/Vista/Operador.fxml"));
                                        Parent rootOperador = loaderOperador.load();
                                        Scene sceneOperador = new Scene(rootOperador);
                                        Stage stageOperador = new Stage();
                                        stageOperador.setScene(sceneOperador);
                                        stageOperador.show();
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                    }
        }
    
    }
    
    @FXML
    private void cerrarProgramaAction(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) cerrarProgramaJFXButton.getScene().getWindow();
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Cierre de Programa");
        alert.setHeaderText("¿Está seguro de cerrar el programa CeluSoft?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            stage.close();
        } else {
            alert.close();
        }
        
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
