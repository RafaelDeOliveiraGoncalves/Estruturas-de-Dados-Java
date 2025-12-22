import java.util.Arrays;

public class Heap<T extends Comparable<T>> {
    private T[] vetor;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public Heap(int capacidade){
        this.vetor = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public void inserir(T valor) throws HeapCheioException{
        if(tamanho == vetor.length){
            throw new HeapCheioException();
        }
        vetor[tamanho] = valor;
        sobeHeap(tamanho);
        tamanho++;
    }

    public T removeMax() throws HeapVazioException{
        if(this.tamanho == 0){
            throw new HeapVazioException();
        }
        T max = this.vetor[0];
        this.vetor[0] = this.vetor[this.tamanho-1];
        this.vetor[this.tamanho-1] = null;
        this.tamanho--;
        desceHeap(0);
        return max;
    }

    public void heapSort(){ 
        int n = this.tamanho;
        for(int i = n-1; i>0 ; i--){
            T temp = vetor[0];
            this.vetor[0] = this.vetor[i];
            this.vetor[i] = temp;
            desceHeap(0, i);
        }
    }

    private void sobeHeap(int i){
        T valor = this.vetor[i];
        while(i>0){
            int pai = (i-1)/2;
            if(this.vetor[pai].compareTo(valor) >= 0){
                break;
            }
            this.vetor[i] = this.vetor[pai];
            i = pai;
        }
        this.vetor[i] = valor;
    }

    private void desceHeap(int i){
        desceHeap(i, this.tamanho);
    }

    private void desceHeap(int i, int n){
        T valor = this.vetor[i];
        while(2*i + 1 < n){
            int filho = 2 * i + 1;
            if(filho + 1 < n && this.vetor[filho].compareTo(this.vetor[filho+1])<0){
                filho++;
            } 
            if(valor.compareTo(this.vetor[filho])>=0){
                break;
            }
            this.vetor[i] = this.vetor[filho];
            i = filho;
        }
        this.vetor[i] = valor;
    }

    public void imprimir(){
        System.out.println(Arrays.toString(Arrays.copyOf(this.vetor, this.tamanho)));
    }

}
















