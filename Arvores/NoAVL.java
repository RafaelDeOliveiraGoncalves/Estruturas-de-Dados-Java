public class NoAVL<T extends Comparable<T>> {
    private T chave;
    private NoAVL<T> le;
    private NoAVL<T> ld;
    private int altura;

    public NoAVL(T chave){
        this.chave = chave;
        this.le = null;
        this.ld = null;
        this.altura = 0;
    }
    
    public T getChave(){
        return this.chave;
    }

    public void setChave(T chave){
        this.chave = chave;
    }

    public int getAltura(){
        return this.altura;
    }

    public void setAltura(int altura){
        this.altura = altura;
    }

    public NoAVL<T> getLe(){
        return this.le;
    }

    public void setLe(NoAVL<T> le){
        this.le = le;
    }

    public NoAVL<T> getLd(){
        return this.ld;
    }

    public void setLd(NoAVL<T> ld){
        this.ld = ld;
    }

}
