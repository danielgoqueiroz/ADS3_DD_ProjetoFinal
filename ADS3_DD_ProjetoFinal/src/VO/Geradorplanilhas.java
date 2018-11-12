package VO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Geradorplanilhas {

		public void gerarPlanilhasProducao(List<Producao> producoes, String caminho) {
			String[] colunasPlanilha = {"idProducao", "tipo","titulo" ,"ano" ,"sinopse" ,"genero" ,"diretor", "duracao","qtdTemporada"  };
			
			HSSFWorkbook planilha = new HSSFWorkbook();
			HSSFSheet abaPlanilha = planilha.createSheet("Produções");
			
			Row headerRow = abaPlanilha.createRow(0);
			
			for (int i = 0; i< colunasPlanilha.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(colunasPlanilha[i]);
			}
			
			int rowNum = 1;
			for (Producao prod: producoes) {
				Row novaLinha = abaPlanilha.createRow(rowNum++);
				
				novaLinha.createCell(0).setCellValue(prod.getIdProducao());
				novaLinha.createCell(1).setCellValue(prod.getTipo().getDeclaringClass().getName());
				novaLinha.createCell(2).setCellValue(prod.getTitulo());
				novaLinha.createCell(3).setCellValue(prod.getAno());
				novaLinha.createCell(4).setCellValue(prod.getSinopse());
				novaLinha.createCell(5).setCellValue(prod.getGenero().toString());
				novaLinha.createCell(6).setCellValue(prod.getDiretor());
				novaLinha.createCell(7).setCellValue(prod.getDuracao());
				novaLinha.createCell(0).setCellValue(prod.getQtdTemporadas());
				
				for (int i = 0; i < colunasPlanilha.length; i ++) {
					abaPlanilha.autoSizeColumn(i);
				}

				FileOutputStream fileOut = null;
				
				try {
					fileOut = new FileOutputStream(caminho + ".xls");
					planilha.write(fileOut);
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (fileOut != null) {
						try {
							fileOut.close();
							
						} catch (Exception e) {
							// TODO: handle exception
						}
						
					}
					
				}
				
			}
		}
}
