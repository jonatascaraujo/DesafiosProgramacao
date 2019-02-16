import java.util.Scanner;

public class Main {

	static int n;
	static int[][] tabuleiro;
	static int[] maxOnLines;
	static int max;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		max = n * n;
		char[] caracteres;
		while (n != 0 && scan.hasNext()) {
			tabuleiro = new int[n][n];
			maxOnLines = new int[n];
			boolean aux = false;

			for (int linha = 0; linha < n; linha++) {
				caracteres = scan.next().toCharArray();
				for (int coluna = 0; coluna < n; coluna++) {
					if (caracteres[coluna] == 'X') {
						tabuleiro[linha][coluna] = -1;
						if (aux) {
							maxOnLines[linha]++;
						}
						aux = false;
						max--;
					} else {
						aux = true;
					}
				}
				if (aux) {
					maxOnLines[linha]++;
				}
			}
			System.out.println(executar(0));
			;
			if (scan.hasNextInt()) {
				n = scan.nextInt();
			}
		}
		scan.close();
	}

	private static int executar(int count) {
		int temp = count;
		int aux = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((maxOnLines[i] > 0) && (canAdd(i, j))) {
					tabuleiro[i][j] = 1;
					maxOnLines[i]--;
					aux = executar(count + 1);
					tabuleiro[i][j] = 0;
					maxOnLines[i]++;
					if (aux == max) {
						return aux;
					}
					temp = aux > temp ? aux : temp;
				}
			}
		}

		return temp;

	}

	private static boolean canAdd(int linha, int coluna) {
		boolean hasTowerOnLine = false;
		boolean hasTowerOnColumm = false;
		if (tabuleiro[linha][coluna] == 0) {
			for (int i = 0; i < n; i++) {
				switch (tabuleiro[linha][i]) {
				case 1:
					if (hasTowerOnLine) {
						return false;
					}
					hasTowerOnLine = true;
					break;
				case -1:
					hasTowerOnLine = false;
					break;
				case 0:
					if (i == coluna) {
						if (hasTowerOnLine) {
							return false;
						}
						hasTowerOnLine = true;
					}
				default:
					break;
				}
				switch (tabuleiro[i][coluna]) {
				case 1:
					if (hasTowerOnColumm) {
						return false;
					}
					hasTowerOnColumm = true;
					break;
				case -1:
					hasTowerOnColumm = false;
					break;
				case 0:
					if (i == linha) {
						if (hasTowerOnColumm) {
							return false;
						}
						hasTowerOnColumm = true;
					}
				default:
					break;
				}
			}
			return true;
		}
		return false;
	}

}
