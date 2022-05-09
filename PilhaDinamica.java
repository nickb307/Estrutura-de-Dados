
public class PilhaDinamica<T>  implements Pilha<T>{

	private ListaEncadeada<T> lista;
	
	public PilhaDinamica() {
		lista = new ListaEncadeada<T>(); 
	}
		
	@Override
	public void push(T valor) {
		lista.inserir(valor);		
	}

	@Override
	public T pop() {
		T valor = this.peek();
		lista.retirar(valor);
		return valor;
	}

	@Override
	public T peek() {
		if (this.estaVazia()) {
			throw new RuntimeException("Pilha está vazia");
		}
		return this.lista.pegar(lista.getTamanho() -1);
	}

	@Override
	public boolean estaVazia() {
		return (lista.estaVazia()); 
	}

	@Override
	public void liberar() {
		lista = new ListaEncadeada<T>(); 		
	}

	public String toString() {
		return lista.exibir();
	}
	
	
}
