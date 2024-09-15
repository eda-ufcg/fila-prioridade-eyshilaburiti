import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class InsereOrdenadoTest {
    
    @Test
	public void testOrdenado() {
		FilaPrioridade insertion = new InsereOrdenadoFilaPrioridade(5);
		insertion.add("a", 1);
		insertion.add("b", 2);
		insertion.add("c", 3);
		insertion.add("d", 4);
		insertion.add("e", 5);

		assertEquals("e", insertion.removeNext());
		assertEquals("d", insertion.removeNext());
		assertEquals("c", insertion.removeNext());
		assertEquals("b", insertion.removeNext());
		assertEquals("a", insertion.removeNext());
	}

	@Test
	public void testOrdenadoReverso() {
		FilaPrioridade insertion = new InsereOrdenadoFilaPrioridade(5);
		insertion.add("a", 5);
		insertion.add("b", 4);
		insertion.add("c", 3);
		insertion.add("d", 2);
		insertion.add("e", 1);

		assertEquals("a", insertion.removeNext());
		assertEquals("b", insertion.removeNext());
		assertEquals("c", insertion.removeNext());
		assertEquals("d", insertion.removeNext());
		assertEquals("e", insertion.removeNext());
	}

	@Test
	public void testComNegativo() {
		FilaPrioridade insertion = new InsereOrdenadoFilaPrioridade(5);
		insertion.add("a", 7);
		insertion.add("b", 2);
		insertion.add("c", 1);
		insertion.add("d", 9);
		insertion.add("e", -1);

		assertEquals("d", insertion.removeNext());
		assertEquals("a", insertion.removeNext());
		assertEquals("b", insertion.removeNext());
		assertEquals("c", insertion.removeNext());
		assertEquals("e", insertion.removeNext());
	}

	@Test
	public void testResize() {
		FilaPrioridade insertion = new InsereOrdenadoFilaPrioridade(5);
		insertion.add("a", 7);
		insertion.add("b", 2);
		insertion.add("c", 1);
		insertion.add("d", 9);
		insertion.add("e", -1);

		assertEquals("d", insertion.removeNext());
		assertEquals("a", insertion.removeNext());
		assertEquals("b", insertion.removeNext());
		assertEquals("c", insertion.removeNext());
		assertEquals("e", insertion.removeNext());

		insertion.add("a", 7);
		insertion.add("b", 2);
		insertion.add("c", 1);
		insertion.add("d", 9);
		insertion.add("e", -1);
		insertion.add("f", 10);
		insertion.add("g", -2);

		assertEquals("f", insertion.removeNext());
		assertEquals("d", insertion.removeNext());
		assertEquals("a", insertion.removeNext());
		assertEquals("b", insertion.removeNext());
		assertEquals("c", insertion.removeNext());
		assertEquals("e", insertion.removeNext());
		assertEquals("g", insertion.removeNext());
	}

	@Test
	public void testVazio() {
		FilaPrioridade insertion = new InsereOrdenadoFilaPrioridade(5);
		insertion.add("a", 7);
		insertion.add("b", 2);
		insertion.add("c", 1);

		assertEquals("a", insertion.removeNext());
		assertEquals("b", insertion.removeNext());
		assertEquals("c", insertion.removeNext());
		assertEquals("Vazio", insertion.removeNext());
	}
	
	@Test
	public void testRepetidos() {
		FilaPrioridade insertion = new InsereOrdenadoFilaPrioridade(5);
		insertion.add("a", 7);
		insertion.add("b", 2);
		insertion.add("c", 1);
		insertion.add("d", 7);
		// ("d", 7), ("a", 7), ("b", 2), ("c", 1)

		assertEquals("d", insertion.removeNext());
		assertEquals("a", insertion.removeNext());
		assertEquals("b", insertion.removeNext());
		assertEquals("c", insertion.removeNext());
	}
}