package com.javatechie.aws.lambda.util;

import static com.javatechie.aws.lambda.util.Utils.redondearDecimales;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;

import com.javatechie.aws.lambda.domain.response.CasoWordFileResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WordUtil {

	public ByteArrayResource getWordFile(CasoWordFileResponse response) {
		try {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			XWPFDocument document = new XWPFDocument();
			XWPFParagraph title = document.createParagraph();
			XWPFRun titleRun = title.createRun();
			titleRun.setText(response.getDenominacionCaso());
			titleRun.setFontSize(18);
			XWPFParagraph subTitle = document.createParagraph();
			XWPFRun subTitleRun = subTitle.createRun();
			subTitleRun.setText("Orden de inspección: " + response.getOrdenInspeccion());
			subTitleRun.setBold(true);
			/*
			 * Para la tabla
			 */
			// create table 1
			XWPFParagraph subTitleTable1 = document.createParagraph();
			XWPFRun subTitleTableRun1 = subTitleTable1.createRun();
			subTitleTableRun1.setText("Informe Ejecutivo");
			subTitleTableRun1.setBold(true);
			
			XWPFTable table1 = document.createTable();
			table1.setWidth("100%");
			XWPFTableRow tableRowOne1 = table1.getRow(0);
			tableRowOne1.getCell(0).setText("Fecha Inicio");
			tableRowOne1.addNewTableCell().setText(response.getFechaInicio());
			XWPFTableRow tableRowTwo1 = table1.createRow();
			tableRowTwo1.getCell(0).setText("Estado del caso");
			tableRowTwo1.getCell(1).setText(response.getEstadoCaso());
			XWPFTableRow tableRowThree1 = table1.createRow();
			tableRowThree1.getCell(0).setText("Etapa");
			tableRowThree1.getCell(1).setText(response.getEtapa());
			XWPFTableRow tableRowFour1 = table1.createRow();
			tableRowFour1.getCell(0).setText("Resumen");
			tableRowFour1.getCell(1).setText(response.getResumen());

			// create table 2
			XWPFParagraph subTitleTable2 = document.createParagraph();
			XWPFRun subTitleTableRun2 = subTitleTable2.createRun();
			subTitleTableRun2.setBold(true);
			
			subTitleTableRun2.setText("Análisis de riesgo:");
			XWPFTable table2 = document.createTable();
			table2.setWidth("100%");
			XWPFTableRow tableRowOne2 = table2.getRow(0);
			tableRowOne2.getCell(0).setText("Origen del Caso");
			tableRowOne2.addNewTableCell().setText(response.getOrigenCaso());
			XWPFTableRow tableRowTwo2 = table2.createRow();
			tableRowTwo2.getCell(0).setText("Trabajadores involucrados");
			tableRowTwo2.getCell(1).setText(response.getTrabajadoresInvolucrados().toString());
			XWPFTableRow tableRowThree2 = table2.createRow();
			tableRowThree2.getCell(0).setText("Multa Potencial");
			tableRowThree2.getCell(1).setText(redondearDecimales(response.getMultaPotencial(), 2).toString());
			XWPFTableRow tableRowFour2 = table2.createRow();
			tableRowFour2.getCell(0).setText("Provisiones");
			tableRowFour2.getCell(1).setText(response.getProvisiones());
			XWPFTableRow tableRowFive2 = table2.createRow();
			tableRowFive2.getCell(0).setText("Riesgo");
			tableRowFive2.getCell(1).setText(response.getRiesgo());

			// create table 3
			XWPFParagraph subTitleTable3 = document.createParagraph();
			XWPFRun subTitleTableRun3 = subTitleTable3.createRun();
			subTitleTableRun3.setText("Actuaciones");
			subTitleTableRun3.setBold(true);
			
			XWPFTable table3 = document.createTable();
			table3.setWidth("100%");
			XWPFTableRow tableRowOne3 = table3.getRow(0);
			tableRowOne3.getCell(0).setText("Fecha");
			tableRowOne3.addNewTableCell().setText("Tipo Actuación");
			List<Map<String, String>> actuaciones = response.getActuaciones();
			for (int i = 0; i < actuaciones.size(); i++) {
				XWPFTableRow row3 = table3.createRow();
				row3.getCell(0).setText(actuaciones.get(i).get("fecha"));
				row3.getCell(1).setText(actuaciones.get(i).get("tipoActuacion"));
			}

			document.write(stream);
			document.close();
			return new ByteArrayResource(stream.toByteArray());
		} catch (Exception e) {
			log.info("Exception {}", e);
			return null;
		}
	}
}
