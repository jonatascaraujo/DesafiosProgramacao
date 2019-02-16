import java.io.*;
import java.util.*;

/**
 * Classe criada para resolver o problema mochila binaria ecológica visto na
 * disciplina de desafios de programação II Co o professor Dr. Luciano Antonio
 * Digiampietri
 * 
 * @author jonatasaraujo
 *
 */
class Main {
	static int[] ReadLn(int maxLg, int quantidadeDeNumeros) {
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}

		if ((car < 0) && (lg == 0))
			return (null); // eof
		String temp = new String(lin, 0, lg);
		int res[] = new int[quantidadeDeNumeros];
		StringTokenizer idata;
		idata = new StringTokenizer(temp);
		for (int i = 0; i < quantidadeDeNumeros; i++) {
			res[i] = Integer.parseInt(idata.nextToken());
		}
		return res;
	}

	public static void main(String args[]){
		int v[];
		while ((v = ReadLn(255, 9)) != null) {
			executar(v);
		}
		System.out.println("teste");
		try {
			System.in.close();
		} catch (IOException e) {
		}
	}

	public static void executar(int[] v) {
		int num;
		int atual;
		String saida;

		// para BCG
		atual = v[1] + v[2] + v[3] + v[4] + v[6] + v[8];
		num = atual;
		saida = "BCG";

		// para BGC
		atual = v[1] + v[2] + v[3] + v[5] + v[6] + v[7];
		if (atual < num) {
			num = atual;
			saida = "BGC";
		}

		// para CBG
		atual = v[0] + v[1] + v[4] + v[5] + v[6] + v[8];
		if (atual < num) {
			num = atual;
			saida = "CBG";
		}
		// para CGB
		atual = v[0] + v[1] + v[3] + v[5] + v[7] + v[8];
		if (atual < num) {
			num = atual;
			saida = "CGB";
		}
		// para GBC
		atual = v[0] + v[2] + v[4] + v[5] + v[6] + v[7];
		if (atual < num) {
			num = atual;
			saida = "GBC";
		}
		// para GCB
		atual = v[0] + v[2] + v[3] + v[4] + v[7] + v[8];
		if (atual < num) {
			num = atual;
			saida = "GCB";
		}
		System.out.println(saida + " " + num);
	}
}
