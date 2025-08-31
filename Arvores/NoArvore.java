public class NoArvore<T extends Comparable<T>> {
    private T chave;
    private NoArvore<T> le,ld;

    public NoArvore(T chave){
        this.chave = chave;
        this.le = null;
        this.ld = null;
    }
    public NoArvore(T chave, NoArvore<T> le, NoArvore<T> ld){
        this.chave = chave;
        this.le = le;
        this.ld = ld;
    }

    public T getChave(){
        return this.chave;
    }

    public void setChave(T chave){
        this.chave = chave;
    }

    public NoArvore<T> getLe(){
        return this.le;
    }

    public void setLe(NoArvore<T> le){
        this.le = le;
    }

    public NoArvore<T> getLd(){
        return this.ld;
    }

    public void setLd(NoArvore<T> ld){
        this.ld = ld;
    }

}
