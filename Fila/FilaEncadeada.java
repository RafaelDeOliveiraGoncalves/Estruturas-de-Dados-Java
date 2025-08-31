
public class FilaEncadeada<T extends Comparable<T>> {
    private ListaEncadeada<T> lista;
    private No<T> r;

    public FilaEncadeada(){
        this.lista = new ListaEncadeada<>();
        this.r = null;
    }

    public void esvazia(){
        this.lista.setCabeca(null);
        this.r = null;
    }

    public boolean vazia(){
        return this.lista.getCabeca()==null;
    }

    public void enfila(T k){
        No<T> p = new No(k);
        if(this.vazia()){
            this.lista.setCabeca(p);
            this.r = p;
        }
        else{
            this.r.setProximo(p);
            this.r = p;
        }
    }

    public T desenfila() throws FilaVaziaException{
        if(this.vazia()){
            throw new FilaVaziaException();
        }
        No<T> p = this.lista.getCabeca();
        T k = p.getChave();
        this.lista.setCabeca(this.lista.getCabeca().getProximo());
        if(this.vazia()){
            this.r = null;
        }
        return k;
    }

    public T frente() throws FilaVaziaException{
        if(this.vazia()){
            throw new FilaVaziaException();
        }
        return this.lista.getCabeca().getChave();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Start -> ");
        No<T> p = this.lista.getCabeca();
        while(p!=null){
            sb.append(p.getChave());
            if(p.getProximo()!=null){
                sb.append(" ");
            }
            p = p.getProximo();
        }
        sb.append("<- End");
        return sb.toString();
    }
}
