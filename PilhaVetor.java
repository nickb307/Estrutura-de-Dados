
public class PilhaVetor<T> implements Pilha<T> {

	private T[] info;
	private int limite;
	private int tamanhoAtual;
	
	public PilhaVetor(int limite) {
		info = (T[]) new Object[limite];
		this.limite = limite;
		this.tamanhoAtual = 0;  
	}
	
	
	//inserir
	@Override
	public void push(T valor) {
		if(this.tamanhoAtual == this.limite) {
			throw new RuntimeException("A pilha está cheia");
		}
		this.info[tamanhoAtual] = valor;
		tamanhoAtual++;
	}

	//retirar ultimo elemento 
	@Override
	public T pop() {
		T valor = this.peek();
		this.info[tamanhoAtual - 1] = null;
		this.tamanhoAtual--;
		return valor; 
		
	}

	//pega o ultimo elemento 
	@Override
	public T peek() {
		if(estaVazia()) {
			throw new RuntimeException("A pilha está vazia");
		}
		
		return info[tamanhoAtual -1];
		
	}

	@Override
	public boolean estaVazia() {
		return(this.tamanhoAtual == 0);
	}

	@Override
	public void liberar() {
		info = (T[])new Object[limite];
		this.tamanhoAtual = 0;  
		
	}
	
	public String toString() {
		String valores = "";
		for(int i = 0; i<info.length; i++) {
			valores+= info[i] + ", ";
		}
		return valores; 
		
	}
	
	
	
	
}
