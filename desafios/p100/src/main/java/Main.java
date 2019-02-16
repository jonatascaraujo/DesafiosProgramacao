import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
	
	static Map<Integer, Integer> mapaNumeroCiclicos= new HashMap<Integer, Integer>();
	
	public static void main(String args[]) {
		int menor, maior;
		
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			//pega o dois numeros
			menor = scan.nextInt();
			maior = scan.nextInt();
			
			int tamanhoCiclico = executaAlgoritmo(menor, maior);
			
			System.out.println(menor + " " + maior + " " + tamanhoCiclico);
			scan.nextLine();
		}
		scan.close();
	}

	static int executaAlgoritmo(int menor, int maior) {
		//garante a ordem
		if(maior<menor){
			int temp = maior;
			maior=menor;
			menor =temp;
		}
		
		int maiorTamanhoCiclico = 0;
		for (int i = menor; i <= maior; i++) {
			int tamanhoCiclico = executaConjectura(i);
			maiorTamanhoCiclico = maiorTamanhoCiclico<tamanhoCiclico?tamanhoCiclico:maiorTamanhoCiclico;
		}
		return maiorTamanhoCiclico;
	}

	
	static int executaConjectura(int n) {
		int ciclico = 1;
		if (mapaNumeroCiclicos.containsKey(n)) {
			return mapaNumeroCiclicos.get(n);
		}
		if (n != 1) {
			ciclico += executaConjectura((n % 2 == 1) ? (3 * n + 1) : (n / 2));
		}
		mapaNumeroCiclicos.put(n, ciclico);
		return ciclico;
	}

}
