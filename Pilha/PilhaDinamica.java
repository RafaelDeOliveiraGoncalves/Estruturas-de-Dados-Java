import java.util.ArrayList;

public class PilhaDinamica<T> {
    private ArrayList<T> array;

    public PilhaDinamica(){
        this.inicializa();
    }

    public int getTopo(){
        return this.array.size()-1; // Se retornar -1 a Pilha está vazia
    }

    private void inicializa(){
        this.array = new ArrayList<>();
    }

    public void esvazia(){
        this.array.clear();
    }

    public boolean vazia(){
        return (this.array.isEmpty());
    }

    public void push(T k){
        this.array.add(k);
    }

    public T pop() throws PilhaVaziaException{
        if(this.vazia()){
            throw new PilhaVaziaException();
        }
        T k = this.array.remove(this.array.size()-1);
        return k;
    }

    public T topo() throws PilhaVaziaException{
        if(this.vazia()){
            throw new PilhaVaziaException();
        }
        T k = this.array.get(this.array.size()-1);
        return k;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Topo\n");
        for(int i=this.array.size()-1;i>=0;i--){
            sb.append(this.array.get(i));
            if(i>0){
                sb.append('\n');
            }
        }
        return sb.toString();
    }

}
