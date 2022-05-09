
public class FilaDinamica<T> implements Fila<T> {

	ListaEncadeada<T> lista;
	
	public FilaDinamica() {
		lista = new ListaEncadeada<T>();
	}
	
	
	
	@Override
	public void inserir(T valor) {
		lista.inserir(valor);
		
	}

	@Override
	public T retirar() {
		T valor = this.peek();
		lista.retirar(valor);
		return valor; 
	}

	@Override
	public T peek() {
		try {
			return lista.pegar(0);
		} catch (IndexOutOfBoundsException iob) {
			throw new RuntimeException("Fila está vazia");
		}
	}

	@Override
	public boolean estaVazia() {
		return lista.estaVazia();
	}

	@Override
	public void liberar() {
		lista = new ListaEncadeada<T>();
		
	}
	
	public String toString() {
		return lista.exibir();
	}

}
