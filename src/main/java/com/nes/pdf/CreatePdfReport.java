package com.nes.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;

/**
 * com.itextpdf:itextpdf:5.5.13 手动生成pdf
 */
public class CreatePdfReport {

    // 定义全局的字体静态变量

    private static Font headfont;
    private static Font keyfont;
    private static Font textfont;
    // 最大宽度
    private static int maxWidth = 520;
    private static BaseFont bfChinese;

    // 静态代码块
    static {
        try {
            // 不同字体（这里定义为同一种字体：包含不同字号、不同style）
            bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            headfont = new Font(bfChinese, 14, Font.BOLD);
            keyfont = new Font(bfChinese, 10, Font.BOLD);
            textfont = new Font(bfChinese, 10, Font.NORMAL);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        // 1.新建document对象
        Document document = new Document(PageSize.A4, 20, 20, 20, 20);

        // 2.建立一个书写器(Writer)与document对象关联
        File file = new File("bbf.pdf");
        file.createNewFile();

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        // 水印
        writer.setPageEvent(new Watermark("重庆巴巴实科技有限公司"));
        // 页眉/页脚
        //writer.setPageEvent(new MyHeaderFooter());

        // 3.打开文档
        document.open();
        document.addTitle("创新型中小企业培育报告");// 标题
        document.addAuthor("Author@umiz");// 作者
        document.addSubject("Subject@iText pdf sample");// 主题
        document.addKeywords("Keywords@iTextpdf");// 关键字
        document.addCreator("Creator@umiz`s");// 创建者

        // 4.向文档中添加内容
        generatePDF(document);

        // 5.关闭文档
        document.close();
    }

    private static void generatePDF(Document document) throws Exception {

        Image image = Image.getInstance("/home/wdq/图片/bbf1.png");
        image.scalePercent(50);
        image.setAbsolutePosition(0, 0);
        //添加第一页封面
        document.add(image);
        // 段落1
        Paragraph paragraph = new Paragraph("创新型中小企业培育报告", new Font(bfChinese, 40, Font.BOLD, BaseColor.WHITE));
        //设置文字居中 0靠左   1，居中     2，靠右
        paragraph.setAlignment(1);
        //行间距
        paragraph.setLeading(15f);
        //设置段落上空白
        paragraph.setSpacingBefore(180f);
        document.add(paragraph);

        // 段落2
        paragraph = new Paragraph("重庆巴巴实科技有限公司", new Font(bfChinese, 20, Font.BOLD, BaseColor.WHITE));
        //设置文字居中 0靠左   1，居中     2，靠右
        paragraph.setAlignment(1);
        paragraph.setLeading(15f);
        //设置段落上空白
        paragraph.setSpacingBefore(30);
        document.add(paragraph);

        // 段落3
        paragraph = new Paragraph("企业名称：重庆巴巴实科技有限公司\n" +
                "统一社会信用代码：122349877665834\n" +
                "法定代表人姓名：张三\n" +
                "注册地区：重庆市巴南区",
                new Font(bfChinese, 13, Font.NORMAL, BaseColor.BLACK));
        //设置文字居中 0靠左   1，居中     2，靠右
        paragraph.setAlignment(1);
        paragraph.setLeading(15f);
        //设置段落上空白
        paragraph.setSpacingBefore(220);
        document.add(paragraph);

        // 段落3
        paragraph = new Paragraph("报告说明:\n" +
                "本报告更新时间为2022-02-16，本报告根据您授权查询企业及自主填写的企业相关信息生产，报告内容仅供参考。",
                new Font(bfChinese, 10, Font.NORMAL, BaseColor.GRAY));
        //设置文字居中 0靠左   1，居中     2，靠右
        paragraph.setAlignment(Element.ALIGN_LEFT);
        paragraph.setLeading(15f);
        //设置段落上空白
        paragraph.setSpacingBefore(80);
        document.add(paragraph);


        //新起一页
        document.newPage();
        // 段落
        paragraph = new Paragraph("1.1 差异指标",
                new Font(bfChinese, 30, Font.BOLD, new BaseColor(0, 103, 199)));
        //设置文字居中 0靠左   1，居中     2，靠右
        paragraph.setAlignment(Element.ALIGN_LEFT);
        paragraph.setLeading(20f);
        paragraph.setFirstLineIndent(2);
        //设置段落上空白
        paragraph.setSpacingBefore(16);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);

        //创建表格
        PdfPTable table = createTable(new float[]{120, 200, 120, 120, 120});
        //表头
        table.addCell(createHeaderCell("指标分类", headfont));
        table.addCell(createHeaderCell("指标", headfont));
        table.addCell(createHeaderCell("要求指标", headfont));
        table.addCell(createHeaderCell("企业指标", headfont));
        table.addCell(createHeaderCell("匹配结果", headfont));

        //表内容 第二行
        table.addCell(createCell("专业发展类指标", textfont));
        table.addCell(createCell("1.企业主营业务收入占营业收入的比例\n" +
                "A.70%（含）以上（30分）\n" +
                "B.60%（含）-70%（20分）\n" +
                "C.50%（含）-60%（10分）\n" +
                "D.50%以下（0分）", textfont));
        table.addCell(createCell("不低于10分", textfont));
        table.addCell(createCell("0分(企业主营业务收入占营业收入的比例：50%以下）", textfont));
        table.addCell(createCell("不匹配", textfont));
        //第三行
        table.addCell(createCell("综合指标得分", textfont));
        table.addCell(createCell("创新基础类指标+财务健康类指标+专业化发展类指标", textfont));
        table.addCell(createCell("不低于60分", textfont));
        table.addCell(createCell("50分", textfont));
        table.addCell(createCell("不匹配", textfont));

        table.setSpacingAfter(40);
        document.add(table);

        /*********************第二个表************************************/
        //创建表格
        table = createTable(new float[]{200, 120, 120, 120});
        //表头
        table.addCell(createHeaderCell("指标", headfont));
        table.addCell(createHeaderCell("要求指标", headfont));
        table.addCell(createHeaderCell("企业指标", headfont));
        table.addCell(createHeaderCell("匹配结果", headfont));
        //第2行
        table.addCell(createCell("（一）企业为有效期内的高新技术企业、省级以上“专精特新”中小企业、国家级专精特新“小巨人”企业、制造业单项冠军企业；\n" +
                "（二）企业近五年内主导制定过国际标准、国家标准、行业标准或地方标准；\n" +
                "（三）企业近三年内以股权融资形式，单轮次获得合格的机构投资者投笔100万元人民币（以实际到位资金计算）以上的；\n" +
                "（四）企业近五年内获得过国家级、省级科技奖励,并在获奖单位中排在前三名的；\n" +
                "（五）企业拥有经认定的省部级以上研发型机构。", textfont));
        table.addCell(createCell("同时符合条件中的一项，则可以直接确认为创新型中小企业。", textfont));
        table.addCell(createCell("不满足任何一个条件。", textfont));
        table.addCell(createCell("不匹配", textfont));
        table.setSpacingAfter(40);

        document.add(table);

        /////////////////////////////////////////////////////////
        // 段落
        paragraph = new Paragraph("1.2 培育建议",
                new Font(bfChinese, 30, Font.BOLD, new BaseColor(0, 103, 199)));
        //设置文字居中 0靠左   1，居中     2，靠右
        paragraph.setAlignment(Element.ALIGN_LEFT);
        paragraph.setLeading(20f);
        paragraph.setFirstLineIndent(2);
        //设置段落上空白
        paragraph.setSpacingBefore(16);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);

        /////////////////////////////////////////////////////////
        // 段落
        paragraph = new Paragraph("（一）满足基本条件。",
                new Font(bfChinese, 16, Font.BOLD, BaseColor.RED));
        //设置文字居中 0靠左   1，居中     2，靠右
        paragraph.setAlignment(Element.ALIGN_LEFT);
        paragraph.setLeading(20f);
        paragraph.setFirstLineIndent(2);
        //设置段落上空白
        paragraph.setSpacingBefore(10);
        paragraph.setSpacingAfter(10);
        document.add(paragraph);
        /////////////////////////////////////////////////////////
        // 段落
        paragraph = new Paragraph("（二）不满足直接认定条件。",
                new Font(bfChinese, 16, Font.BOLD, BaseColor.RED));
        //设置文字居中 0靠左   1，居中     2，靠右
        paragraph.setAlignment(Element.ALIGN_LEFT);
        paragraph.setLeading(20f);
        paragraph.setFirstLineIndent(2);
        //设置段落上空白
        paragraph.setSpacingBefore(10);
        paragraph.setSpacingAfter(10);
        document.add(paragraph);
        /////////////////////////////////////////////////////////
        // 段落
        paragraph = new Paragraph("（三）评价指标中，专业发展类指标分数存在不足，企业可以提升主营业务收入占营业收入的比例。",
                new Font(bfChinese, 16, Font.BOLD, BaseColor.RED));
        //设置文字居中 0靠左   1，居中     2，靠右
        paragraph.setAlignment(Element.ALIGN_LEFT);
        paragraph.setLeading(20f);
        paragraph.setFirstLineIndent(2);
        //设置段落上空白
        paragraph.setSpacingBefore(10);
        paragraph.setSpacingAfter(40);
        document.add(paragraph);

        /////////////////////////////////////////////////////////
        // 段落
        paragraph = new Paragraph("1.3 基本条件",
                new Font(bfChinese, 30, Font.BOLD, new BaseColor(0, 103, 199)));
        //设置文字居中 0靠左   1，居中     2，靠右
        paragraph.setAlignment(Element.ALIGN_LEFT);
        paragraph.setLeading(20f);
        paragraph.setFirstLineIndent(2);
        //设置段落上空白
        paragraph.setSpacingBefore(16);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);

        /*********************第三个表************************************/
        //创建表格
        table = createTable(new float[]{200, 120, 120, 120});
        table.setSpacingAfter(40);

        //表头
        table.addCell(createHeaderCell("指标", headfont));
        table.addCell(createHeaderCell("要求指标", headfont));
        table.addCell(createHeaderCell("企业指标", headfont));
        table.addCell(createHeaderCell("匹配结果", headfont));
        //第2行
        table.addCell(createCell("在中国境内（不包括港、澳.台地区）注册的企业", textfont));
        table.addCell(createCell("是", textfont));
        table.addCell(createCell("是。", textfont));
        table.addCell(createCell("匹配", textfont));
        //第3行
        table.addCell(createCell("符合《中小企业划型标准规定》的企业。", textfont));
        table.addCell(createCell("是", textfont));
        table.addCell(createCell("是。", textfont));
        table.addCell(createCell("匹配", textfont));
        //第4行
        table.addCell(createCell("企业注册成立一年以上。", textfont));
        table.addCell(createCell("是", textfont));
        table.addCell(createCell("是。", textfont));
        table.addCell(createCell("匹配", textfont));
        //第5行
        table.addCell(createCell("企业提供的产品和服务不属于国家规定的禁止、限制和淘汰类。", textfont));
        table.addCell(createCell("是", textfont));
        table.addCell(createCell("是。", textfont));
        table.addCell(createCell("匹配", textfont));
        //第6行
        table.addCell(createCell("企业在上年及当年内未发生重大安全、重大质量事故和严重环境违法，且企业未列入经营异常名录和严重违法失信企业名单。", textfont));
        table.addCell(createCell("是", textfont));
        table.addCell(createCell("是。", textfont));
        table.addCell(createCell("匹配", textfont));

        document.add(table);


        // 段落
        paragraph = new Paragraph("asdfasf",
                new Font(bfChinese, 10, Font.BOLD, new BaseColor(0, 103, 199)));
        //设置文字居中 0靠左   1，居中     2，靠右
        paragraph.setAlignment(Element.ALIGN_LEFT);
        paragraph.setLeading(20f);
        paragraph.setFirstLineIndent(2);
        //设置段落上空白
        paragraph.setSpacingBefore(16);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);
    }

    /**
     * 创建指定列宽、列数的表格
     *
     * @param widths
     * @return
     */
    public static PdfPTable createTable(float[] widths) {
        PdfPTable table = new PdfPTable(widths);
        try {
            table.setTotalWidth(maxWidth);
            table.setLockedWidth(true);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.getDefaultCell().setBorder(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    /**
     * 创建单元格(指定字体)
     *
     * @param value
     * @param font
     * @return
     */
    public static PdfPCell createCell(String value, Font font) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_TOP);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    /**
     * 创建单元格(指定字体)
     *
     * @param value
     * @param font
     * @return
     */
    public static PdfPCell createHeaderCell(String value, Font font) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setPhrase(new Phrase(value, font));

        cell.setPadding(10);
        cell.setBackgroundColor(new BaseColor(241, 241, 241));

        cell.setBorderWidthBottom(2);
        cell.setBorderColorBottom(new BaseColor(75, 127, 198));

        return cell;
    }
}
