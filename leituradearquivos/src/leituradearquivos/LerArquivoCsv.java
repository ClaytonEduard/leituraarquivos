package leituradearquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoCsv {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream entradaArquivo = new FileInputStream(
				new File("C:\\Users\\Clayt\\git\\leituraarquivos\\leituradearquivos\\src\\arquivo.csv"));

		// lendo as linhas
		@SuppressWarnings("resource")
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		// lendo o arquivo
		// enquanto meu arquivo tiver dados
		while (lerArquivo.hasNext()) {
			String linha = lerArquivo.nextLine();
			// ignorando a linha fazia
			if (linha != null && !linha.isEmpty()) {
				System.out.println(linha);
				String[] dados = linha.split("\\;");
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[1]);
				pessoa.setIdade(Integer.parseInt(dados[2]));
				
				pessoas.add(pessoa);
			}
			
		}
	}

}
