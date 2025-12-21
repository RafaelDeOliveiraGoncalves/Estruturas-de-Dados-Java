public class PilhaEncadeada<T extends Comparable<T>>{
    private ListaEncadeada<T> lista;
    private int tamanho;

    //Construtor
    public PilhaEncadeada(){
        this.lista = new ListaEncadeada<>();
        this.tamanho = 0;
    }

    public PilhaEncadeada(T k){
        this();
        this.push(k);
    }

    public void esvazia(){
        this.lista.setCabeca(null);
        this.tamanho = 0;
    }

    public boolean vazia(){
        return (this.lista.getCabeca() == null);
    }

    public void push(T k){
        this.lista.insere(k);
        this.tamanho++;
    }

    public T pop() throws PilhaVaziaException{
        if(this.vazia()){
            throw new PilhaVaziaException();
        }
        T k = this.lista.getCabeca().getChave();
        this.lista.setCabeca(this.lista.getCabeca().getProximo());
        this.tamanho--;
        return k;
    }

    public T top() throws PilhaVaziaException{
        if(this.vazia()){
            throw new PilhaVaziaException();
        }
        return lista.getCabeca().getChave();
    }

    public int len(){
        return this.tamanho;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Topo\n");
        No<T> p = this.lista.getCabeca();
        while(p!=null){
            sb.append(p.getChave());
            if(p.getProximo()!=null){
                sb.append('\n');
            }
            p = p.getProximo();
        }
        return sb.toString();
    }

}