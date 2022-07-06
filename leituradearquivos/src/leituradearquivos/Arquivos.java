package leituradearquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivos {
	public static void main(String[] args) throws IOException {

		// biblioteca de leitura do Java, passando o endereço do arquivo completo
		File arquivo = new File("C:\\Users\\Clayt\\git\\leituraarquivos\\leituradearquivos\\src\\aquivo.txt");
		// negando o arquivo
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		// escrevendo um arquivo
		FileWriter escreverArquivo = new FileWriter(arquivo);

		escreverArquivo.write("Meu texto do arquivo");
		// nova linha
		escreverArquivo.write("\n");
		escreverArquivo.write("Segunda linha \n");

		for (int i = 1; i <= 10; i++) {
			escreverArquivo.write("Meu texto do arquivo " + i + " \n");
		}

		// para perssistir as alteracoes
		escreverArquivo.flush();
		// fechar o arquivo
		escreverArquivo.close();
		
		
	}
}
