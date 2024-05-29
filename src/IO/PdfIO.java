
package IO;

import Models.NhaCungCap;
import Models.PhieuNhap;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PdfIO {
    
    private static File fontFile = new File("fonts/vuArial.ttf");
    
    public static void handleExportPdfFile(JPanel mainView, PhieuNhap phieuNhap, NhaCungCap nhaCungCap) {
        File defaultFile = new File("PhieuNhap.pdf");
        JFileChooser fChooser = new JFileChooser();
        fChooser.setSelectedFile(defaultFile);
        int result = fChooser.showSaveDialog(mainView);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = fChooser.getSelectedFile().getAbsolutePath();
                createPdf(filePath, phieuNhap, nhaCungCap);
                JOptionPane.showMessageDialog(null, "Lưu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | DocumentException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Xuất file không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }     
    };
        
    public static void createPdf(String filePath, PhieuNhap phieuNhap, NhaCungCap nhaCungCap) throws IOException, DocumentException{
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        BaseFont bf = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font fontTitle = new Font(bf, 18);
        Font font = new Font(bf, 14);
        document.open(); 
        String title = "PHIẾU NHẬP HÀNG";
        String ngay[] = phieuNhap.getNgayTao().split(" ");
        String ngayTao[] = ngay[0].split("/");
        String ngayTaoPhieu = "Ngày " + ngayTao[0] + " tháng " + ngayTao[1] + " năm " + ngayTao[2];
        document.add(new Paragraph(title, fontTitle));
        document.add(new Paragraph(ngayTaoPhieu, font));
        
        document.close();
    }
}
