
import com.victor1669.classes.Bibliotecario;
import com.victor1669.models.Funcionario;
import com.victor1669.classes.Gerente;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Victor1669
 */
public class FuncionarioTests {

    static Funcionario bibliotecario;
    static Funcionario gerente;

    @BeforeEach
    public void setUpClass() {
        bibliotecario = new Bibliotecario("Teste", 1500);

        gerente = new Gerente("Gerenteste", 6000);
    }

    @Test
    void funcionariosDevemSerCriadosCorretamente() {
        assertAll("criar bibliotecario",
                () -> assertEquals("Teste", bibliotecario.getNome()),
                () -> assertEquals(1500, bibliotecario.getSalario()),
                () -> assertEquals(0, bibliotecario.getBonus())
        );

        assertAll("criar gerente",
                () -> assertEquals("Gerenteste", gerente.getNome()),
                () -> assertEquals(6000, gerente.getSalario()),
                () -> assertEquals(0, gerente.getBonus())
        );
    }

    @Test
    void deveProcessarOPagamentoCorretamenteAposAtualizarOBonus() {
        bibliotecario.setFATOR_BONUS(0.1);
        bibliotecario.calcularBonus();
        assertEquals(150, bibliotecario.getBonus());

        double salarioFuncioanrio = bibliotecario.processarPagamento();

        gerente.setFATOR_BONUS(0.2);
        gerente.calcularBonus();
        assertEquals(1200, gerente.getBonus());

        double salarioGerente = gerente.processarPagamento();

        assertEquals(1650, salarioFuncioanrio);
        assertEquals(7200, salarioGerente);
    }
}
