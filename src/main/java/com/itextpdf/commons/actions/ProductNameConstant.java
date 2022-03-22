package com.itextpdf.commons.actions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * com.itextpdf.commons.actions.ProductNameConstant 重新此类，修改PRODUCT_NAMES变量
 */
public final class ProductNameConstant {
    public static final String ITEXT_CORE = "itext-core";
    public static final String PDF_HTML = "pdfHtml";
    public static final String PDF_SWEEP = "pdfSweep";
    public static final String PDF_OCR_TESSERACT4 = "pdfOcr-tesseract4";
    //新增产品名称 pdfOffice
    public static final Set<String> PRODUCT_NAMES = new HashSet(Arrays.asList("itext-core", "pdfOffice", "pdfHtml", "pdfSweep", "pdfOcr-tesseract4"));

    private ProductNameConstant() {
    }
}
