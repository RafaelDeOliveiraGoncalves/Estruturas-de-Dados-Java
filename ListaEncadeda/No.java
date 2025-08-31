public class No<T extends Comparable<T>>{
    private T chave;
    private No<T> proximo;

    //Construtor
    public No(T chave){
        this.chave = chave;
        this.proximo = null;
    }

    //Encapsulamento
    public void setChave(T chave){
        this.chave = chave;
    }

    public T getChave(){
        return this.chave;
    }

    public void setProximo(No<T> proximo){
        this.proximo = proximo;
    }

    public No<T> getProximo(){
        return this.proximo;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(this.chave != null){
            sb.append(this.chave);
            sb.append(" -> ");
            if(this.proximo!=null){
                sb.append(this.proximo.getChave());
            }
            else{
                sb.append("null");
            }
            return sb.toString();
        }
        sb.append("No vazio");
        return sb.toString();
    }

}
