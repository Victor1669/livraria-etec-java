
import com.victor1669.models.Pagamento;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Victor1669
 */
public class PagamentoTests {

    Pagamento pagamento;

    @BeforeEach
    public void setUp() {
        pagamento = new Pagamento(1, 1, 1650);
    }

    @Test
    void deveCriarPagamentoCorretamente() {
        assertAll("criar pagamento",
                () -> assertEquals(1, pagamento.getId()),
                () -> assertEquals(1, pagamento.getId_funcionario()),
                () -> assertEquals(1650, pagamento.getValorTotal())
        );
    }
}
