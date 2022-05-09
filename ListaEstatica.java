
public class ListaEstatica<T> implements Lista<T> {

	private int tamanho;
	private T[] info;

	public ListaEstatica() {
		info = (T[]) new Object[10];
		this.tamanho = 0;
	}

	public void redimensionar() {
		T[] novo = (T[]) new Object[info.length + 10];
		for (int i = 0; i < this.info.length; i++) {
			novo[i] = this.info[i];
		}
		info = novo;
	}

	@Override
	public void inserir(T valor) {
		if (this.tamanho == info.length) {
			this.redimensionar();
		} else {
			info[tamanho] = valor;
			tamanho++;
		}

	}

	@Override
	public String exibir() {
		String valores = "";
		for (int i = 0; i < this.tamanho; i++) {
			valores += this.info[i] + ", ";
		}
		return valores;
	}

	@Override
	public int buscar(T valor) {
		for (int i = 0; i < this.tamanho; i++) {
			if (this.info[i].equals(valor)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void retirar(T valor) {
		int pos = this.buscar(valor);
		if (pos != -1) {
			for (int i = pos; i < this.tamanho; i++) {
				info[i] = info[i + 1];
			}
			tamanho--;
		}
	}

	@Override
	public Lista<T> copiar() {
		Lista<T> copia = new ListaEstatica<T>();

		for (int i = 0; i < this.tamanho; i++) {
			copia.inserir(this.info[i]);
		}
		return copia;
	}

	@Override
	public void concatenar(Lista<T> outra) {
		for (int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}

	}

	@Override
	public int getTamanho() {
		return this.tamanho;
	}

	@Override
	public boolean estaVazia() {
		return (this.tamanho == 0);
	}

	@Override
	public Lista<T> dividir() {
		Lista<T> nova = new ListaEstatica<T>();
		int metade = this.tamanho/2;
		
		for(int i = metade; i< this.tamanho;i++) {
			nova.inserir(this.info[i]);
			
		}
		tamanho = metade; 
		return nova; 
		
	}

	@Override
	public T pegar(int posicao) {
		return info[posicao];
	}

}
