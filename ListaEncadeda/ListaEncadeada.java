public class ListaEncadeada<T extends Comparable<T>> {
    private No<T> cabeca;

    private  class TuplaNos{
        private No<T> atual;
        private No<T> anterior;
        
        public void setAtual(No<T> atual){
            this.atual = atual;
        }
        
        public No<T> getAtual(){
            return this.atual;
        }
        
        public void setAnterior(No<T> anterior){
            this.anterior = anterior;
        }
        
        public No<T> getAnterior(){
            return this.anterior;
        }
    } 

    //Construtores
    public ListaEncadeada(){
        this.cabeca = null;
    }
    public ListaEncadeada(T k){
        No<T> p = new No<>(k);
        this.setCabeca(p);
    }

    //Encapsulamento
    public void setCabeca(No<T> no){
        this.cabeca = no;
    }

    public No<T> getCabeca(){
        return this.cabeca;
    }

    public void imprime(){
        No<T> p = this.cabeca;
        while(p!=null){
            System.out.println(p.getChave());
            p = p.getProximo();
        }
    }

    public void inverter(){
        No<T> p = this.cabeca;
        No<T> r = null;
        while(p!=null){
            No<T> t = p.getProximo();
            p.setProximo(r);
            r = p;
            p = t;
        }
        this.cabeca = r;
    }

    public No<T> busca(T k){
        No<T> p = this.cabeca;
        while(p != null && !p.getChave().equals(k)){
            p = p.getProximo();
        }
        return p;
    }

    public No<T> buscaOrdenada(T k){
        No<T> p = this.cabeca;
        while(p != null && p.getChave().compareTo(k)<0){
            p = p.getProximo();
        }
        return p;
    }

    private TuplaNos buscaInsercao(T k){
        TuplaNos tupla = new TuplaNos();
        No<T> p = this.cabeca;
        No<T> ant = null;
        while(p!=null && p.getChave().compareTo(k)<0){
            ant = p;
            p = p.getProximo();
        }
        tupla.setAtual(p);
        tupla.setAnterior(ant);
        return tupla;
    }

    public void insere(T k){
        No<T> p = new No<>(k);
        p.setProximo(this.cabeca);
        this.cabeca = p;
    }

    public void insereOrdenado(T k){
        TuplaNos tupla = buscaInsercao(k);
        No<T> p = new No<>(k);
        if(tupla.getAnterior()==null){
            p.setProximo(this.cabeca);
            this.cabeca = p;
        }
        else{
            tupla.getAnterior().setProximo(p);
            p.setProximo(tupla.getAtual());
        }
    }

    public void deletar(T k){
        TuplaNos tupla = buscaInsercao(k);
        if(tupla.getAtual() == null || !tupla.getAtual().getChave().equals(k)){
            return;
        }
        if(tupla.getAnterior()==null){
            this.cabeca = tupla.getAtual().getProximo();
        }
        else{
            tupla.getAnterior().setProximo(tupla.getAtual().getProximo());
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        No<T> p = this.getCabeca();
        while(p!=null){
            sb.append(p.getChave());
            if(p.getProximo()!=null){
                sb.append(" -> ");
            }
            p = p.getProximo();
        }
        sb.append("]");
        return sb.toString();
    }
    
}
