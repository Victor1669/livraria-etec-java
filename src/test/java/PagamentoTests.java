
import com.victor1669.models.PagamentoModel;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Victor1669
 */
public class PagamentoTests {

    PagamentoModel pagamento;

    @BeforeEach
    public void setUp() {
        pagamento = new PagamentoModel(1, 1, 1650);
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
