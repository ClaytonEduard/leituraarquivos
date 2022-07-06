package leituradearquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws Exception {
		File file = new File(
				"C:\\Users\\Clayt\\git\\leituraarquivos\\leituradearquivos\\src\\leituradearquivos\\arquivo_excel.xsl");

		// verificar se existe o arquivo criado
		if (!file.exists()) {
			file.createNewFile();
		}

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
		pessoa3.setNome("Joao");

		// colocar as pessoas dentro de umalista
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);

		// usado para escrever a planilha
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planiha de Pessoas"); // criar a planilha

		int numeroLinha = 0;
		
		for (Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinha++); // criando a linha na planilha
			int celula = 0;

			// criar as linhas conforme o contador
			Cell celNome = linha.createCell(celula++);
			// pegando os dados da celula
			celNome.setCellValue(p.getNome());

			Cell celEmail = linha.createCell(celula++);
			// pegando os dados da celula
			celEmail.setCellValue(p.getEmail());

			Cell celIdade = linha.createCell(celula++);
			// pegando os dados da celula
			celIdade.setCellValue(p.getIdade());

		}

		// saida dos dados

		FileOutputStream saida = new FileOutputStream(file);

		hssfWorkbook.write(saida); // escreve a plilha em arquivo

		saida.flush();
		saida.close();
		
		System.out.println("Planilha criada");
	}

}
