package staticlist;

/**
 * Define a classe adaptadora para a lista estática afim
 * de seguir o modelo de classe do exercício.
 * <br><br>
 *
 * Neste exercício implementei da minha maneira e por isso
 * essa classe existe para facilitar o entendimento conforme
 * o modelo de classe proposto.
 * <br><br>
 *
 * Caso isso seja um problema, por favor, me avise para que
 * eu siga estritamente o modelo de classe proposto.
 *
 * @see StaticList
 */
public class ListaEstaticaAdapter {

    private final StaticList adapted;

    public ListaEstaticaAdapter() {
        this.adapted = new StaticListImpl();
    }

    public void inserir(int elemento) {
        adapted.add(elemento);
    }

    public void exibir() {
        System.out.println(adapted.toString());
    }

    public int buscar(int elemento) {
        return adapted.find(elemento);
    }

    public void retirar(int elemento) {
        adapted.remove(elemento);
    }

    public void liberar() {
        adapted.free();
    }

    public int obterElemento(int indice) {
        return adapted.get(indice);
    }

    public boolean estaVazia() {
        return adapted.isEmpty();
    }

    public int getTamanho() {
        return adapted.size();
    }

    @Override
    public String toString() {
        return adapted.toString();
    }
}
