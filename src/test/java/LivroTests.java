
import com.victor1669.models.LivroModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class LivroTests {

    LivroModel lm;

    @BeforeEach
    public void setUpClass() {
        lm = new LivroModel(1, "1984", "George Orwell");
    }

    @Test
    public void livroDeveSerCriadoCorretamente() {

        assertAll("criar livro",
                () -> assertEquals("1984", lm.getNome()),
                () -> assertEquals("George Orwell", lm.getAutor())
        );
    }
}
