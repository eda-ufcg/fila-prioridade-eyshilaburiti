import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class HeapTest {
    
    @Test
	public void testOrdenado() {
		FilaPrioridade heap = new HeapFilaPrioridade(5);
		heap.add("a", 1);
		heap.add("b", 2);
		heap.add("c", 3);
		heap.add("d", 4);
		heap.add("e", 5);

		assertEquals("e", heap.removeNext());
		assertEquals("d", heap.removeNext());
		assertEquals("c", heap.removeNext());
		assertEquals("b", heap.removeNext());
		assertEquals("a", heap.removeNext());
	}

	@Test
	public void testOrdenadoReverso() {
		FilaPrioridade heap = new HeapFilaPrioridade(5);
		heap.add("a", 5);
		heap.add("b", 4);
		heap.add("c", 3);
		heap.add("d", 2);
		heap.add("e", 1);

		assertEquals("a", heap.removeNext());
		assertEquals("b", heap.removeNext());
		assertEquals("c", heap.removeNext());
		assertEquals("d", heap.removeNext());
		assertEquals("e", heap.removeNext());
	}

	@Test
	public void testComNegativo() {
		FilaPrioridade heap = new HeapFilaPrioridade(5);
		heap.add("a", 7);
		heap.add("b", 2);
		heap.add("c", 1);
		heap.add("d", 9);
		heap.add("e", -1);

		assertEquals("d", heap.removeNext());
		assertEquals("a", heap.removeNext());
		assertEquals("b", heap.removeNext());
		assertEquals("c", heap.removeNext());
		assertEquals("e", heap.removeNext());
	}

	@Test
	public void testResize() {
		FilaPrioridade heap = new HeapFilaPrioridade(5);
		heap.add("a", 7);
		heap.add("b", 2);
		heap.add("c", 1);
		heap.add("d", 9);
		heap.add("e", -1);

		assertEquals("d", heap.removeNext());
		assertEquals("a", heap.removeNext());
		assertEquals("b", heap.removeNext());
		assertEquals("c", heap.removeNext());
		assertEquals("e", heap.removeNext());

		heap.add("a", 7);
		heap.add("b", 2);
		heap.add("c", 1);
		heap.add("d", 9);
		heap.add("e", -1);
		heap.add("f", 10);
		heap.add("g", -2);

		assertEquals("f", heap.removeNext());
		assertEquals("d", heap.removeNext());
		assertEquals("a", heap.removeNext());
		assertEquals("b", heap.removeNext());
		assertEquals("c", heap.removeNext());
		assertEquals("e", heap.removeNext());
		assertEquals("g", heap.removeNext());
	}

	 
	@Test
	public void testVazio() {
		FilaPrioridade heap = new HeapFilaPrioridade(5);
		heap.add("a", 7);
		heap.add("b", 2);
		heap.add("c", 1);

		assertEquals("a", heap.removeNext());
		assertEquals("b", heap.removeNext());
		assertEquals("c", heap.removeNext());
		assertEquals("Vazio", heap.removeNext());
	}
	
	@Test
	public void testRepetidos() {
		FilaPrioridade heap = new HeapFilaPrioridade(5);
		heap.add("a", 7);
		heap.add("b", 2);
		heap.add("c", 1);
		heap.add("d", 7);
		// ("d", 7), ("a", 7), ("b", 2), ("c", 1)

		assertEquals("a", heap.removeNext());
		assertEquals("d", heap.removeNext());
		assertEquals("b", heap.removeNext());
		assertEquals("c", heap.removeNext());
	}
}
