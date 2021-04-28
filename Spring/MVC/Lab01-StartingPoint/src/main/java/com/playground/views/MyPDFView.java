package com.playground.views;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import org.springframework.web.servlet.view.document.AbstractPdfView;

public class MyPDFView  extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Table table = new Table(5);
        table.addCell("Cell1");
        table.addCell("Cell2");
        table.addCell("Cell3");
        table.addCell("Cell4");
        table.addCell("Cell5");

        document.add(table);
    
    }

    
}
