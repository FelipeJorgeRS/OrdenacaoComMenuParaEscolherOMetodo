import java.util.Arrays;
import java.util.Scanner;

public class MultiOrdenacao {

	//M�TODO DE ORDENA��O BOLHA
	public static int [] ordenacaoPorBubbleSort(int vetor[]) {
	
		int comparacoes =0;// guarda a quantidade de compara��es feitas
		int trocas=0; // guarda a quantidade de trocas realizadas
		int temp=0;
		boolean trocou = false;
		 
	for (int i=0; i<vetor.length-1 ; i++){
		for (int j=0; j<vetor.length-i-1; j++){
			comparacoes++;
			if (vetor[j] > vetor[j+1]){
				trocas++;
				temp = vetor[j];
				vetor[j]=vetor[j+1];
				vetor[j+1]=temp;
				trocou = true;
				 } 
            System.out.println(Arrays.toString(vetor)); // Imprime o vetor a cada itera��o
			}
		if (!trocou) break;// Se nenhuma troca foi feita na passagem completa, a lista j� est� ordenada e � retornada
		}
		return new int []{comparacoes, trocas} ;
	}

	
	//M�TODO DE ORDENA��O POR SELE��O
	public static int[] ordenacaoPorSelecao(int vetor[]){
	int comparacoes =0;
	int trocas=0;
	int auxiliar;
	int posicaoMenor; 
		for (int i=0; i<vetor.length-1; i++) {
		posicaoMenor = i;
		for (int j=i+1; j<=vetor.length-1; j++) {
			comparacoes ++;
			if (vetor[j] < vetor[posicaoMenor]) {
				posicaoMenor = j;
				trocas ++;
			// troca o menor elemento (que esta na posicao menor) com o elemento da posicao i
				auxiliar = vetor[i];
				vetor[i] = vetor[posicaoMenor];
				vetor[posicaoMenor] = auxiliar;
				}
			System.out.println(Arrays.toString(vetor));
			}
		} 
		return new int []{comparacoes, trocas} ;
	}
	
	
	//M�TODO DE ORDENA��O POR INSER��O
	public static int[] ordenacaoPorInsercao(int vetor[]) {
	
	int comparacoes=0;
	int trocas=0;
	int temp=0;
		for (int i=1; i <  vetor.length; i++){
			
			temp = vetor[i];
			int j;
			for (j=i-1; j >=0 && temp < vetor[j]; j--) {
			comparacoes ++;
			vetor[j+1] = vetor[j];
			System.out.println(Arrays.toString(vetor));
			}
			vetor[j+1]=temp; // a atualiza��o da vari�vel tem que ser feita neste escopo(fora do loop interno)
			trocas++;

		}
		return new int []{comparacoes, trocas};
	}	
	

	public static void impressaoMetodoBolha(int VetorOriginal[]) {
		int temp[];
		// clonar o vetor durante as tres impressoes garqante que ele entre desordenado em cada m�todo

		temp= VetorOriginal.clone();
		int [] retornoBolha = ordenacaoPorBubbleSort(temp);
		System.out.println("O vetor ordenado pelo m�todo Bolha �: "+ Arrays.toString(temp) );
		System.out.println("O n�mero de compara��es do m�todo Bolha �: " + retornoBolha[0]);		
		System.out.println("O n�mero de trocas do m�todo Bolha �: " + retornoBolha[1]);		
	}

	public static void impressaoMetodoSelecao(int VetorOriginal[]) {
		int temp[];
		
		temp= VetorOriginal.clone();
		int []retornoSelecao=ordenacaoPorSelecao(temp); 
		System.out.println("\nO vetor ordenado pelo m�todo Sele��o �: "+ Arrays.toString(temp) );
		System.out.println("O n�mero de compara��es do m�todo de Sele��o �: " + retornoSelecao[0]);		
		System.out.println("O n�mero de trocas do m�todo de Sele��o �: " + retornoSelecao[1]);		
	}
	public static void impressaoMetodoInsercao(int VetorOriginal[]) {
		int temp[];
		temp= VetorOriginal.clone();
		int[] retornoInsercao=ordenacaoPorInsercao(temp);
		System.out.println("\nO vetor ordenado pelo m�todo de Inser��o �: " +Arrays.toString(temp) );
		System.out.println("O n�mero de compara��es do m�todo de Inser��o �: " + retornoInsercao[0]);		
		System.out.println("O n�mero de trocas do m�todo de Inser��o �: " + retornoInsercao[1] +"\n");		
}
	
	public static void main(String[] args) {
	int [] vetorInicial= {10,9,8,7,6,5,4,3,2,1,0}; String desordenado = "vetor totalmente desodernado(inverso)";
		
		Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o m�todo de ordena��o:");
        System.out.println("1. Ordena��o por Bolha");
        System.out.println("2. Ordena��o por Sele��o");
        System.out.println("3. Ordena��o por Inser��o");
        System.out.print("Digite o n�mero do m�todo: ");
        
        int escolha = scanner.nextInt();

    
        switch (escolha) {
            case 1:
                impressaoMetodoBolha(vetorInicial);
                break;
            case 2:
            	impressaoMetodoSelecao(vetorInicial);
                break;
            case 3:
               impressaoMetodoInsercao(vetorInicial);
                break;
            default:
                System.out.println("Op��o inv�lida!");
                break;
        }
		
	}
}
