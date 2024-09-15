import java.util.Arrays;

public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;
	private int size;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}

	public boolean isEmpty(){
		return this.head == -1 && this.last == -1;
	}

	public boolean isFull(){
		return (this.last + 1) % this.fila.length == this.head;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {

		if(this.fila.length - 1 == this.last){
			resize();
		}

		Pair pair = new Pair(elemento, prioridade);
		this.size += 1;

		if(this.head == -1){
			this.head += 1;
		}

		this.last = (this.last + 1) % this.fila.length;
		this.fila[this.last] = pair;

		// trocando os elementos até o último ficar na posição correta
		for(int i = this.last; i > this.head; i--){
			if(this.fila[i].getPrioridade() >= this.fila[i - 1].getPrioridade()){
				swap(i, i - 1);
			}
		}
	}

	private void resize(){
		Pair[] novaFila = new Pair[this.fila.length * 2];
		int j = 0;

		for(int i = this.head; i < this.fila.length; i++){
			novaFila[j] = this.fila[i % this.fila.length];
			j++;
		}

		this.fila = novaFila;
	}

	private void swap(int i, int j){
		Pair aux = this.fila[i];
		this.fila[i] = this.fila[j];
		this.fila[j] = aux;
	}

	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {

		if(isEmpty()){
			return "Vazio";
		}

		this.size -= 1;
		String removed = this.fila[this.head].getElemento();

		if(this.head == this.last){
			this.head = -1;
			this.last = -1;
		} else {
			this.head = (this.head + 1) % this.fila.length;
		}
		return removed;
	}

	public String toString(){
		return Arrays.toString(fila);
	}
	public static void main(String[] args) {
		System.out.println("oi");
	 }
}
