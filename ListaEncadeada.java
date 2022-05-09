
public class ListaEncadeada<T> implements Lista<T> {
	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int qtdElem;

	@Override
	public void inserir(T valor) {
		NoLista<T> novo = new NoLista<T>();
		novo.setInfo(valor);

		if (estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		qtdElem++;
	}

	@Override
	public String exibir() {
		NoLista<T> p = primeiro;
		String valores = "";

		while (p != null) {
			valores += p.getInfo() + ";";
			p = p.getProximo();
		}
		return valores;
	}

	@Override
	public int buscar(T valor) {
		NoLista<T> p = primeiro;
		int posicao = 0;
		while (p != null) {
			if (p.getInfo().equals(valor)) {
				return posicao;
			}
			posicao++;
			p = p.getProximo();

		}
		return -1;

	}

	@Override
	public void retirar(T valor) {
		NoLista<T> anterior = null;
		NoLista<T> p = primeiro;
		while (p != null && p.getInfo() != valor) {
			anterior = p;
			p = p.getProximo();
		}
		if (p != null) {
			if (anterior == null) {
				primeiro = p.getProximo();
			} else {
				anterior.setProximo(p.getProximo());
			}
			qtdElem--;

			if (ultimo == p) {
				ultimo = anterior;
			}
		}

	}

	
	
	@Override
	public Lista<T> copiar() {
		NoLista<T> p = primeiro;
		Lista<T> lista = new ListaEncadeada<T>();

		while (p != null) {
			lista.inserir(p.getInfo());
			p = p.getProximo();
		}
		return lista;
	}

	@Override
	public void concatenar(Lista<T> outra) {

		for (int i = 0; i < outra.getTamanho(); i++) {
			inserir(outra.pegar(i));
			qtdElem++;
		}

	}

	
	public void setQtdElem(int qtdElem) {
		this.qtdElem = qtdElem;
	}

	@Override
	public int getTamanho() {
		return this.qtdElem;
	}

	@Override
	public boolean estaVazia() {
		return (qtdElem == 0);

	}

	@Override
	public Lista<T> dividir() {
		int metade = this.getTamanho() / 2;
		Lista<T> lista = new ListaEncadeada<T>();

		for (int i = metade; i < this.getTamanho(); i++) {
			lista.inserir(pegar(i));
		}
		qtdElem = metade;
		NoLista<T> p = primeiro;
		for (int i = 0; i < this.getTamanho(); i++) {
			p = p.getProximo();
		}
		ultimo = p;
		ultimo.setProximo(null);

		return lista;
	}

	public NoLista<T> getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(NoLista<T> primeiro) {
		this.primeiro = primeiro;
	}

	public NoLista<T> getUltimo() {
		return ultimo;
	}

	public void setUltimo(NoLista<T> ultimo) {
		this.ultimo = ultimo;
	}

	@Override
	public T pegar(int posicao) {
		if (posicao < 0 || posicao > this.getTamanho()) {
			throw new IndexOutOfBoundsException("posição " + posicao + " é inválida");
		}

		NoLista<T> p = primeiro;
		for (int i = 0; i < posicao; i++) {
			p = p.getProximo();
		}
		return p.getInfo();
	}

}
