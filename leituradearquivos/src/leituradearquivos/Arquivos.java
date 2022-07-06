package leituradearquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
	public static void main(String[] args) throws IOException {

		// instanciando a classe pessoa

		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("maria@hotmail.com");
		pessoa1.setIdade(20);
		pessoa1.setNome("Maria Aparecida");
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("amauri@hotmail.com");
		pessoa2.setIdade(17);
		pessoa2.setNome("Amauri");

		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("joao@hotmail.com");
		pessoa3.setIdade(41);
		pessoa3.setNome("João");

		// colocar as pessoas dentro de umalista
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);

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
		for (Pessoa p : pessoas) {
			escreverArquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
		}

		// para perssistir as alteracoes
		escreverArquivo.flush();
		// fechar o arquivo
		escreverArquivo.close();

		// subindo para o git

	}
}
