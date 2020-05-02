
/**
 *
 * Nó a ser armazenado na lista.
 *
 */
public class No {

    /**
     * Dado a ser armazenado no nó.
     */
    private int dado;

    /**
     * Construtor sem parâmetros.
     */
    public No() {
        this.dado = 0;
    }

    /**
     * Construtor com parâmetros.
     *
     * @param dado um valor do tipo inteiro.
     */
    public No(int dado) {
        this.dado = dado;
    }

    /**
     * Recuperador de dado.
     *
     * @return Um inteiro com o dado do nó.
     */
    public int getDado() {
        return dado;
    }

    /**
     * Modificador de dado.
     *
     * @param dado Um valor inteiro a ser atribuído para o dado.
     */
    public void setDado(int dado) {
        this.dado = dado;
    }

    /**
     * Retorna o valor em String do dado.
     *
     * @return Uma string com o valor do dado do nó.
     */
    public String paraString() {
        return "OID: " + this + " / dado: " + getDado();
    }
}