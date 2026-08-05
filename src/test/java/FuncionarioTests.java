
import com.victor1669.classes.Bibliotecario;
import com.victor1669.models.FuncionarioModel;
import com.victor1669.classes.Gerente;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTests {

    static FuncionarioModel bibliotecario;
    static FuncionarioModel gerente;

    @BeforeEach
    public void setUpClass() {
        bibliotecario = new Bibliotecario("Teste", 1500);

        gerente = new Gerente("Gerenteste", 6000);
    }

    @Test
    void funcionariosDevemSerCriadosCorretamente() {
        assertAll("criar bibliotecario",
                () -> assertEquals("Teste", bibliotecario.getNome()),
                () -> assertEquals(1500, bibliotecario.getSalario())
        );

        assertAll("criar gerente",
                () -> assertEquals("Gerenteste", gerente.getNome()),
                () -> assertEquals(6000, gerente.getSalario())
        );
    }
}
