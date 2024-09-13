import java.util.Arrays;

public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {

		if(this.fila.length - 1 == ){
			
		}

		Pair pair = new Pair(elemento, prioridade);
		int posicao = 0;

		// adicionando na primeira posição caso a fila esteja vazia
		if(this.head == -1){
			this.head += 1;
			this.last += 1;
			this.fila[this.head] = pair;
		} else {
			this.last += 1;
			this.fila[this.last] = pair;

			int j = this.fila[this.last];

			while(j >= this.head && this.fila[j].getPrioridade() > this.fila[j - 1].getPrioridade()){
				swap(j, j - 1);
				j -= 1;
			}
		}
	}

	private void swap(int i, int j){
		int aux = this.fila[i];
		this.fila[i] = this.fila[j];
		this.fila[j] = aux;
	}

	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		this.head += 1;
	}

	public String toString(){
		return Arrays.toString(fila);
	}

	public static void main(String[] args) {
		FilaPrioridade insertion = new InsereOrdenadoFilaPrioridade(5);

		insertion.add("a", 1);
		insertion.add("b", 2);
		insertion.add("c", 3);
		insertion.add("d", 4);
		insertion.add("e", 5);

		System.out.println(insertion.toString());

		//System.out.println(insereFinal.removeNext());
		//System.out.println(insereFinal.removeNext());
		//System.out.println(insereFinal.removeNext());
		//System.out.println(insereFinal.removeNext());
		//System.out.println(insereFinal.removeNext());
		//System.out.println(insereFinal.removeNext());
		//System.out.println(insereFinal.removeNext());
	 }

}
