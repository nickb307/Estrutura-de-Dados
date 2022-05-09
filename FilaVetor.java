
public class FilaVetor<T> implements Fila<T> {

	private T[] info;
	private int limite;
	private int tamanho;
	private int inicio; //posicao do primeiro elemento	
	
	public FilaVetor(int limite) {
		info = (T[]) new Object[limite];
		this.tamanho = 0; 
		this.inicio = 0; 
		this.limite = limite; 
	}
	
	public int getTamanho() {
		return this.tamanho;
	}

	public int getLimite() {
		return this.limite;
	}
	
	@Override
	public void inserir(T valor) {
		if (this.tamanho == this.limite) {
			throw new RuntimeException("Fila está cheia");
		}
		int pos = (this.inicio+ this.tamanho) % this.limite; 
		this.info[pos] = valor;
		this.tamanho++; 
	}

	@Override
	public T retirar() {
		T valor = this.peek();
		this.info[this.inicio] = null; 
		this.inicio = (this.inicio + 1) % limite;
		this.tamanho--; 
		return valor; 
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new RuntimeException("Fila está vazia");
		}
		return this.info[inicio]; 
	}

	@Override
	public boolean estaVazia() {
		return (this.tamanho == 0);
	}

	@Override
	public void liberar() {
		info = (T[]) new Object[limite];
		this.tamanho = 0; 
		this.inicio = 0; 		
	}
	
	@Override
	public String toString() {
		String elementos = "";
		int posicao;
		for (int i = 0; i < this.getTamanho(); i++) { //ver quantas vezes vai fazer 
			posicao = (this.inicio + i) % this.limite;
			elementos += info[posicao] + ", ";
		}
		elementos = elementos.substring(0, Math.max(0, elementos.length() - 2));
		return "[" + elementos + "]";
	}


}
