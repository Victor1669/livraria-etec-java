
import com.victor1669.classes.Bibliotecario;
import com.victor1669.classes.Gerente;
import com.victor1669.services.FuncionarioService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ULTIMATEPC
 */
public class FuncionarioServiceTests {
    
    static FuncionarioService service;
    
    @BeforeAll
    public static void setUpClass() {
        service = new FuncionarioService();
    }
    
    @Test
    void deveCriarFuncionarioCorretamente(){
        var gerente = new Gerente("Teste", 6000.0);
        var gerenteService = service.criarFuncionario("Teste", "6000", "gerente");
        
        var bibliotecario = new Bibliotecario("Teste", 1500);
        var bibliotecarioService = service.criarFuncionario("Teste", "1500", "bibliotecario");
        
        assertEquals(gerente, gerenteService);
        assertEquals(bibliotecario, bibliotecarioService);
    }
    
    @Test
    void naoDeveCriarFuncionarioCasoNaoTenhaNome(){
        var funcionario = service.criarFuncionario("", "6000", "gerente");
        
        assertEquals(null, funcionario);
    }
    
    @Test
    void naoDeveCriarFuncionarioCasoNaoTenhaSalario(){
        var funcionario = service.criarFuncionario("Teste", "", "gerente");
        
        assertEquals(null, funcionario);
    }
    
    @Test
    void naoDeveCriarFuncionarioCasoNaoTenhaTipo(){
        var funcionario = service.criarFuncionario("Teste", "6000", "");
        
        assertEquals(null, funcionario);
    }
    
}
