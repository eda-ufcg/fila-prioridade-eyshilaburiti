public class HeapFilaPrioridade implements FilaPrioridade {

	private Heap heap;

	public HeapFilaPrioridade(int capacidade) {
		this.heap = new Heap(capacidade);
	}

	// adicionar o pair no heap
	public void add(String elemento, int prioridade) {
		Pair pair = new Pair(elemento, prioridade);
		this.heap.add(pair);
	}

	// recuperar a raiz
	public String removeNext() {
		if(this.heap.isEmpty()){
			return "Vazio";
		}
		return this.heap.remove().getElemento();
	}
}