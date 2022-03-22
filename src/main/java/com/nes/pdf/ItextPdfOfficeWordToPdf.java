package com.nes.pdf;

import com.itextpdf.pdfoffice.OfficeConverter;

import java.io.File;

/**
 * commons-7.2.1.jar
 * licensing-base-4.0.1.jar
 * pdfoffice-2.0.1.jar
 * slf4j-log4j12.jar
 */
public class ItextPdfOfficeWordToPdf {

    public static void main(String[] args) throws Exception {
        //LicenseKey.loadLicenseFile(new File("license.json"));
        File pdfOutFile = new File("out_office.pdf");
        File demoFile = new File("/home/wdq/下载/2022年重庆市博士后科学基金项目申报书1-正文.docx");
        OfficeConverter.convertOfficeDocumentToPdf(demoFile, pdfOutFile);
    }
}
