
package proyecto.desarollo1.java.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marcos
 */
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
                System.out.println( "Driver Cargado" );
            } 
            catch( ClassNotFoundException e ) {
                System.out.println( "No se pudo cargar el driver: "+e.getMessage());
            }

            try{               
                conexion = DriverManager.getConnection(url+ ip  +":" + puerto + "/" + database , usuario, clave);
                System.out.println( "Conexion Abierta" );
                return conexion;
             } 
            
            catch( SQLException e ) 
            {
                System.out.println( "No se pudo abrir la bd: "+e.getMessage() );
                return null;
            }

    }
    
    public Connection getConnetion()
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
    
}
