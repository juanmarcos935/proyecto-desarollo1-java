
package proyecto.desarrollo1.java.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class AccesoBD {
    
    private final String driver = "org.postgresql.Driver";
    protected final String usuario = "postgres";
    protected final String clave = "11111";
    protected final String ip = "localhost";
    protected final String puerto = "5432";
    protected final String database = "celusoft";
    protected final String url = "jdbc:postgresql://"; 
    private Connection conexion = null;
    
    public Connection conectarBD()
    {
            try {
            Class.forName(driver);
                System.out.println("Driver Cargado");
            } 
            catch( ClassNotFoundException e ) {
                System.out.println("No se pudo cargar el driver: "+e.getMessage());
            }

            try{               
                conexion = DriverManager.getConnection(url+ ip  +":" + puerto + "/" + database , usuario, clave);
                System.out.println("Conexion Exitosa a la BD" );
                return conexion;
             } 
            
            catch( SQLException e ) 
            {
                System.out.println("No se pudo abrir la Base de Datos: "+e.getMessage() );
                return null;
            }

    }
    
    public Connection getConnection()
    {
        if (conexion == null) 
        {
            return this.conectarBD();
        }
        
        else
        {
            return conexion;      
        }            
    }
    
    public void cerrarConexion(Connection connec) throws SQLException
    {
        try
        {
            if(connec != null)
            {
                connec.close();
            }
        }
        catch(SQLException e)
        {
            System.out.println("Fue imposible hacer la conexion");
        }
    }
    
}
