public class NoAVL<T extends Comparable<T>> extends NoArvore<T> {
    private int altura;

    public NoAVL(T chave){
        super(chave);
        this.altura = 0;
    }
    
    public int getAltura(){
        return this.altura;
    }

    public void setAltura(int altura){
        this.altura = altura;
    }

    public NoAVL<T> getLd(){
        return (NoAVL<T>) super.getLd();
    }

    public NoAVL<T> getLe(){
        return (NoAVL<T>) super.getLe();
    }

}
