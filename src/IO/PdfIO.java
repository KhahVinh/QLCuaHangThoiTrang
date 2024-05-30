
package IO;

import Models.NhaCungCap;
import Models.PhieuNhap;
import Models.Product;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PdfIO {
    
    private static File fontFile = new File("fonts/vuTimes.ttf");
    
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
        Font fontTitle = new Font(bf, 18, Font.BOLD);
        Font font = new Font(bf, 12);
        Font font2 = new Font(bf, 12, Font.BOLD);
        document.open(); 
        String title = "PHIẾU NHẬP HÀNG\n";
        String ngay[] = phieuNhap.getNgayTao().split(" ");
        String ngayTao[] = ngay[0].split("/");
        String ngayTaoPhieu = "Ngày " + ngayTao[0] + " tháng " + ngayTao[1] + " năm " + ngayTao[2];
        String maPhieu = "Mã phiếu: " + phieuNhap.getMa();
        String thongTin = "Nhà cung cấp: " + nhaCungCap.getTen() + "\nĐiện thoại: " + nhaCungCap.getSoDienThoai() + "\nĐịa chỉ: " + nhaCungCap.getDiaChi();
        Paragraph pNgayTao = new Paragraph(ngayTaoPhieu, font);
        pNgayTao.setAlignment(Element.ALIGN_LEFT);
        Paragraph pMaPhieu = new Paragraph(maPhieu,font);
        pMaPhieu.setAlignment(Element.ALIGN_LEFT);
        Paragraph pTitle = new Paragraph(title, fontTitle);
        pTitle.setAlignment(Element.ALIGN_CENTER);
        Paragraph pDanhSach = new Paragraph("DANH SÁCH SẢN PHẨM\n\n", font2);
        pDanhSach.setAlignment(Element.ALIGN_CENTER);
        document.add(pTitle);
        document.add(pNgayTao);
        document.add(pMaPhieu);
        document.add(new Paragraph(thongTin, font));
        document.add(pDanhSach);
        PdfPTable tb = new PdfPTable(5);

            tb.addCell(new Paragraph("Mã sản phẩm", font));
            tb.addCell(new Paragraph("Tên sản phẩm", font));
            tb.addCell(new Paragraph("Loại", font));
            tb.addCell(new Paragraph("Số lượng", font));
            tb.addCell(new Paragraph("Giá bán", font));
            ArrayList<Product> listSP = new ArrayList<Product>();
            listSP = phieuNhap.getSanPhamNhap();
            for (int i = 0; i < listSP.size(); i++) {
                String Ma = listSP.get(i).getProductID();
                String Ten = listSP.get(i).getProductName();
                String Loai = listSP.get(i).getProductCategory();
                int soLuong = listSP.get(i).getProductQuantity();
                long giaBan = listSP.get(i).getProductPrice();
                tb.addCell(new Paragraph(Ma, font));
                tb.addCell(new Paragraph(Ten, font));
                tb.addCell(new Paragraph(Loai, font));
                tb.addCell(new Paragraph(Integer.toString(soLuong), font));
                tb.addCell(new Paragraph(String.format("%,d", giaBan), font));
            }
            document.add(tb);
            Paragraph pTongTien = new Paragraph("\nTổng tiền: " + String.format("%,d", phieuNhap.getTien()) + " VND", font);
            document.add(pTongTien);
        document.close();
    }
}
