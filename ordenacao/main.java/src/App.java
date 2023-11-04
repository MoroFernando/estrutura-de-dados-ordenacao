import java.util.Random;

public class App {

    public void bubbleSort(int[] vetor){
      int tamanho = vetor.length;
      int temp = 0;
      int trocas = 0;
      int iteracoes = 0;

      long tempoInicio = System.currentTimeMillis();

      for(int i = 0; i < tamanho; i++){
        for(int j = 1; j < (tamanho - i); j++){
          iteracoes++;
          if(vetor[j-1] > vetor[j]){
            temp = vetor[j-1];
            vetor[j-1] = vetor[j];
            vetor[j] = temp;
            trocas++;
          }
        }
      }

      long tempoFim = System.currentTimeMillis();
      long tempoExecucao = tempoFim - tempoInicio;

      System.out.println("Tempo de execução: " + tempoExecucao + " ms");
      System.out.println("Número de trocas: " + trocas);
      System.out.println("Número de iterações: " + iteracoes);
    }

    public void quickSort(int[] vetor) {
      int trocas = 0;
      int iteracoes = 0;

      long tempoInicio = System.currentTimeMillis();

      int low = 0;
      int high = vetor.length - 1;

      int[] pilha = new int[vetor.length];
      int top = -1;

      pilha[++top] = low;
      pilha[++top] = high;

      while (top >= 0) {
          high = pilha[top--];
          low = pilha[top--];

          int pivot = vetor[high];
          int i = low - 1;

          for (int j = low; j <= high - 1; j++) {
              iteracoes++;
              if (vetor[j] < pivot) {
                  i++;
                  int temp = vetor[i];
                  vetor[i] = vetor[j];
                  vetor[j] = temp;
                  trocas++;
              }
          }

          int temp = vetor[i + 1];
          vetor[i + 1] = vetor[high];
          vetor[high] = temp;
          trocas++;

          int pivotIndex = i + 1;

          if (pivotIndex - 1 > low) {
              pilha[++top] = low;
              pilha[++top] = pivotIndex - 1;
          }

          if (pivotIndex + 1 < high) {
              pilha[++top] = pivotIndex + 1;
              pilha[++top] = high;
          }
      }

      long tempoFim = System.currentTimeMillis();
      long tempoExecucao = tempoFim - tempoInicio;

      System.out.println("Tempo de execução: " + tempoExecucao + " ms");
      System.out.println("Número de trocas: " + trocas);
      System.out.println("Número de iterações: " + iteracoes);
  }

    public void shellSort(int[] vetor) {
      int trocas = 0;
      int iteracoes = 0;
      int n = vetor.length;

      long tempoInicio = System.currentTimeMillis();

      for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
          int temp = vetor[i];
          int j;
          iteracoes++;

          for (j = i; j >= gap && vetor[j - gap] > temp; j -= gap) {
            vetor[j] = vetor[j - gap];
            trocas++;
          }
          vetor[j] = temp;
        }
      }

      long tempoFim = System.currentTimeMillis();
      long tempoExecucao = tempoFim - tempoInicio;
      
      System.out.println("Tempo de execução: " + tempoExecucao + " ms");
      System.out.println("Número de trocas: " + trocas);
      System.out.println("Número de iterações: " + iteracoes);
    }

    public static void main(String[] args) throws Exception {
      
      App app = new App();

      Random geradorRandomico = new Random();

      // Cria Vetores
      int[] array_50 = new int[50];
      int[] array_500 = new int[500];
      int[] array_1000 = new int[1000];
      int[] array_5000 = new int[5000];
      int[] array_10000 = new int[10000];

      int[][] vetores = {array_50, array_500, array_1000, array_5000, array_10000};
      
      // Preenche vetores com números randômicos
      for (int[] vetor : vetores){
        for(int posVetor = 0; posVetor < vetor.length; posVetor++){
          vetor[posVetor] = geradorRandomico.nextInt(1000) + 1;
        }
      }

      // Ordena com Bubble Sort
      System.out.println("#################### Bubble Sort ####################");
      System.out.println("");
      System.out.println("--> Array com 50 elementos:");
      app.bubbleSort(array_50);
      System.out.println("");
      System.out.println("--> Array com 500 elementos:");
      app.bubbleSort(array_500);
      System.out.println("");
      System.out.println("--> Array com 1000 elementos:");
      app.bubbleSort(array_1000);
      System.out.println("");
      System.out.println("--> Array com 5000 elementos:");
      app.bubbleSort(array_5000);
      System.out.println("");
      System.out.println("--> Array com 10000 elementos:");
      app.bubbleSort(array_10000);
      System.out.println("");

      // Ordena com Quick Sort
      System.out.println("#################### Quick Sort ####################");
      System.out.println("");
      System.out.println("--> Array com 50 elementos:");
      app.quickSort(array_50);
      System.out.println("");
      System.out.println("--> Array com 500 elementos:");
      app.quickSort(array_500);
      System.out.println("");
      System.out.println("--> Array com 1000 elementos:");
      app.quickSort(array_1000);
      System.out.println("");
      System.out.println("--> Array com 5000 elementos:");
      app.quickSort(array_5000);
      System.out.println("");
      System.out.println("--> Array com 10000 elementos:");
      app.quickSort(array_10000);
      System.out.println("");

      // Ordena com Shell Sort
      System.out.println("#################### Shell Sort ####################");
      System.out.println("");
      System.out.println("--> Array com 50 elementos:");
      app.shellSort(array_50);
      System.out.println("");
      System.out.println("--> Array com 500 elementos:");
      app.shellSort(array_500);
      System.out.println("");
      System.out.println("--> Array com 1000 elementos:");
      app.shellSort(array_1000);
      System.out.println("");
      System.out.println("--> Array com 5000 elementos:");
      app.shellSort(array_5000);
      System.out.println("");
      System.out.println("--> Array com 10000 elementos:");
      app.shellSort(array_10000);
      System.out.println("");
      
    }
}
