/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.desarollo1.java.DB;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author chatarrita
 */
public class ConsultasBD {
    
    private AccesoBD accesobd;
    private Connection connec;
    
    public void empezarConexion()
    {
        connec = accesobd.conectarBD();
    }
    
    public void cerrarConexion() throws SQLException
    {
        accesobd.cerrarConexion(connec);
    }
    
}
