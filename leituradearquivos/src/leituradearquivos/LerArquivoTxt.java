package leituradearquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivoTxt {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream entradaArquivo = new FileInputStream(
				new File("C:\\Users\\Clayt\\git\\leituraarquivos\\leituradearquivos\\src\\arquivo.txt"));

		// lendo as linhas
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");

		// lendo o arquivo
		// enquanto meu arquivo tiver dados
		while (lerArquivo.hasNext()) {
			String linha = lerArquivo.nextLine();
			// ignorando a linha fazia
			if (linha != null && !linha.isEmpty()) {
				System.out.println(linha);
			}
		}
	}

}
