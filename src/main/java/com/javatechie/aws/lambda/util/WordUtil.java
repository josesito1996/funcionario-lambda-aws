package com.javatechie.aws.lambda.util;

import java.io.ByteArrayOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.javatechie.aws.lambda.domain.request.WordFileCasoRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WordUtil {

	public ByteArrayResource getWordFile(WordFileCasoRequest request) {
		try {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			XWPFDocument document = new XWPFDocument();
			XWPFParagraph title = document.createParagraph();
			XWPFRun titleRun = title.createRun();
			titleRun.setText("Denominacion del Caso");
			titleRun.setFontSize(18);
			XWPFParagraph subTitle = document.createParagraph();
			XWPFRun subTitleRun = subTitle.createRun();
			subTitleRun.setText("Orden de inspeccion : 2323423423423");
			subTitleRun.setBold(true);
			/*
			 * Para la tabla
			 */
			// create table
			XWPFParagraph subTitleTable = document.createParagraph();
			XWPFRun subTitleTableRun = subTitleTable.createRun();
			subTitleTableRun.setText("Informe Ejecutivo :");
			XWPFTable table = document.createTable();
			// create first row
			XWPFTableRow tableRowOne = table.getRow(0);
			tableRowOne.getCell(0).setText("Fecha Inicio");
			tableRowOne.addNewTableCell().setText("01/02/2020");

			// create second row
			XWPFTableRow tableRowTwo = table.createRow();
			tableRowTwo.getCell(0).setText("Estado del caso");
			tableRowTwo.getCell(1).setText("Concluido");

			// create 4° row
			XWPFTableRow tableRowThree = table.createRow();
			tableRowThree.getCell(0).setText("Etapa");
			tableRowThree.getCell(1).setText("Sancionadora");

			// create third row
			XWPFTableRow tableRowFour = table.createRow();
			tableRowFour.getCell(0).setText("Resumen");
			tableRowFour.getCell(1).setText("Este es un resumen de prueba");
			document.write(stream);
			document.close();
			return new ByteArrayResource(stream.toByteArray());
		} catch (Exception e) {
			log.info("Exception {}", e.getMessage());
			return null;
		}
	}
}
