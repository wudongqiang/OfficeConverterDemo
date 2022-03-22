package com.nes.pdf;

import com.aspose.words.Document;
import com.aspose.words.LoadOptions;
import com.aspose.words.SaveFormat;

/**
 * 使用破解版本aspose-words-21.1-jdk17.jar 操作word to pdf
 */
public class AsposeWordToPdf {

    public static void main(String[] args) throws Exception {
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setConvertMetafilesToPng(true);
        Document wpd = new Document("/home/wdq/下载/巴巴实创新型中小企业培育报告-模板(待定).docx", loadOptions);
        wpd.save("output.pdf", SaveFormat.PDF);
    }
}
