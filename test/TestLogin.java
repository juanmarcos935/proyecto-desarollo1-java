import java.sql.SQLException;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;
import org.junit.Assert.*;
import proyecto.desarrollo1.java.DAOs.DAOUsuario;


public class TestLogin extends TestCase {
    
    private DAOUsuario daousuario;
    
    public void escenario() {
        daousuario = new DAOUsuario();
    }
    
    @Test
    public void testUsuarioLogin1() throws SQLException {
        escenario();
        assertEquals(-1,daousuario.verificarSiExisteUsuarioConLogin("asdf"));
    }
    
    @Test
    public void testUsuarioLogin2() throws SQLException {
        escenario();
        assertEquals(1,daousuario.verificarSiExisteUsuarioConLogin("admin"));
    }
    
    @Test
    public void testUsuarioLoginPasswordActivo1() throws SQLException {
        escenario();
        assertEquals(1,daousuario.usuarioConsultaLoginPassword_DevuelveActivo("admin", "admin"));
    }
    
    @Test
    public void testUsuarioLoginPasswordActivo2() throws SQLException {
        escenario();
        assertEquals(0,daousuario.usuarioConsultaLoginPassword_DevuelveActivo("admin2", "admin2"));
    }
    
    @Test
    public void testUsuarioLoginTipo1() throws SQLException {
        escenario();
        assertEquals(1,daousuario.usuario_ConsultaLogin_DevuelveTipo("admin"));
    }
    
    @Test
    public void testUsuarioLoginTipo2() throws SQLException {
        escenario();
        assertEquals(2,daousuario.usuario_ConsultaLogin_DevuelveTipo("gerente"));
    }
    
    @Test
    public void testUsuarioLoginTipo3() throws SQLException {
        escenario();
        assertEquals(3,daousuario.usuario_ConsultaLogin_DevuelveTipo("operador"));
    }
    
    @Test
    public void testUsuarioLoginEstado1() throws SQLException {
        escenario();
        assertEquals(1,daousuario.verificarEstadoDeUsuarioConLogin("admin"));
    }
    
    @Test
    public void testUsuarioLoginEstado2() throws SQLException {
        escenario();
        assertEquals(0,daousuario.verificarEstadoDeUsuarioConLogin("admin2"));
    }
    
}