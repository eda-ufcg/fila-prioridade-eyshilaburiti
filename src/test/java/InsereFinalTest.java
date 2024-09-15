import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class InsereFinalTest {
    
	@Test
	public void testComNegativo() {
		FilaPrioridade insereFinal = new InsereFinalFilaPrioridade(5);
		insereFinal.add("a", 7);
		insereFinal.add("b", 2);
		insereFinal.add("c", 1);
		insereFinal.add("d", 9);
		insereFinal.add("e", -1);

		assertEquals("d", insereFinal.removeNext());
		assertEquals("a", insereFinal.removeNext());
		assertEquals("b", insereFinal.removeNext());
		assertEquals("c", insereFinal.removeNext());
		assertEquals("e", insereFinal.removeNext());
	}
}