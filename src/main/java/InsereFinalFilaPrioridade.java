import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {

		// criando o pair
		Pair pair = new Pair(elemento, prioridade);

		// adicionando no final da fila
		this.fila.add(pair);
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {

		Pair maiorPrioridade = new Pair("", 0);

		// procurando o de maior prioridade O(n)
		for(Pair pair : fila){
			if(pair.getPrioridade() > maiorPrioridade.getPrioridade()){
				maiorPrioridade = pair;
			}
		}

		// removendo o de maior prioridade
		this.fila.remove(maiorPrioridade);

		// retornando o elemento removido
		return maiorPrioridade.getElemento();
	}
	 public static void main(String[] args) {
		FilaPrioridade insereFinal = new InsereFinalFilaPrioridade(5);

		insereFinal.add("a", 1);
		insereFinal.add("b", 2);
		insereFinal.add("c", 3);
		insereFinal.add("d", 4);
		insereFinal.add("e", 5);

		System.out.println(insereFinal.removeNext());
		System.out.println(insereFinal.removeNext());
		System.out.println(insereFinal.removeNext());
		System.out.println(insereFinal.removeNext());
		System.out.println(insereFinal.removeNext());
		System.out.println(insereFinal.removeNext());
		System.out.println(insereFinal.removeNext());
	 }
}
