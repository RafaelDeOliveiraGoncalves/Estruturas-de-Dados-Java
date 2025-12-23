import java.util.ArrayDeque; 
import java.util.Iterator; // Necessário para iterar de forma reversa no array

public class PilhaDinamica<T> {
    private ArrayDeque<T> array;

    public PilhaDinamica(){
        this.inicializa();
    }

    public int getTopo(){
        return this.array.size()-1; // Se retornar -1 a Pilha está vazia
    }

    private void inicializa(){
        this.array = new ArrayDeque<>();
    }

    public void esvazia(){
        this.array.clear();
    }

    public boolean vazia(){
        return (this.array.isEmpty());
    }

    public void push(T k){
        this.array.addLast(k);
    }

    public T pop() throws PilhaVaziaException{
        if(this.vazia()){
            throw new PilhaVaziaException();
        }
        T k = this.array.removeLast();
        return k;
    }

    public T topo() throws PilhaVaziaException{
        if(this.vazia()){
            throw new PilhaVaziaException();
        }
        T k = this.array.peekLast();
        return k;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Topo\n");
        Iterator<T> elem = this.array.descendingIterator();
        while(elem.hasNext()){
            sb.append(elem.next());
            if(elem.hasNext()){
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}
