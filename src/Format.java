

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class Format {
    public Format() throws Exception {
        ArrayList<String> para = new ArrayList();
        String[] text = Menu.getInput();
        XWPFDocument doc = new XWPFDocument();

        for(int x = 0; x <= 6; ++x) {
            para.add(text[x]);
        }

        String NAME = (String)para.get(0) + " " + (String)para.get(1);
        createHead(doc, NAME);
        createHead(doc, (String)para.get(2));
        createHead(doc, (String)para.get(3));
        createHead(doc, (String)para.get(4));
        createTitle(doc, (String)para.get(5));
        createParagraph(doc, (String)para.get(6));
        File file = new File(text[7] + ".docx");
        FileOutputStream out = new FileOutputStream(file, true);
        doc.write(out);
        out.close();
    }

    private static void createParagraph(XWPFDocument document, String para) {
        XWPFParagraph paraOne = document.createParagraph();
        paraOne.setSpacingBetween(2.0);
        paraOne.setFirstLineIndent(700);
        XWPFRun one = paraOne.createRun();
        one.setFontSize(12);
        one.setFontFamily("Arial");
        one.setText(para);
    }

    private static void createHead(XWPFDocument document, String para) {
        XWPFParagraph header = document.createParagraph();
        header.setSpacingBetween(2.0);
        XWPFRun run = header.createRun();
        run.setFontSize(12);
        run.setFontFamily("Arial");
        run.setText(para);
    }

    private static void createTitle(XWPFDocument document, String para) {
        XWPFParagraph Title1 = document.createParagraph();
        Title1.setSpacingBetween(2.0);
        Title1.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun two = Title1.createRun();
        two.setFontSize(12);
        two.setFontFamily("Arial");
        two.setText(para);
    }
}
