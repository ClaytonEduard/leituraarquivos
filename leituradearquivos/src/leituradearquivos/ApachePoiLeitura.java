package leituradearquivos;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiLeitura {

	public static void main(String[] args) throws Exception {

		FileInputStream entrada = new FileInputStream(
				new File("C:\\Users\\Clayt\\git\\leituraarquivos\\leituradearquivos\\src\\arquivo_excel.xls"));

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);// prepara a entrada do arquivo
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); // pega a primeira planilha do arquivo gerado

		Iterator<Row> linhaIterator = planilha.iterator();
		// percorer
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		while (linhaIterator.hasNext()) { // enquanto tiver dados ele vai rodar
			Row linha = linhaIterator.next();// dasdos do arquivo

			// instanciando pessoa
			Pessoa pessoa = new Pessoa();
			Iterator<Cell> celulas = linha.iterator();
			while (celulas.hasNext()) {// percorrer as celulas
				Cell cell = celulas.next();

				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				}

			} // fim das celulas da linha

			pessoas.add(pessoa);
		}

		entrada.close();// terminou de ler o arquivo
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}
}
