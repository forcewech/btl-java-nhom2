/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Interfaces.ErrorDatabase;
import Models.KeHoachBaoTri;
import Models.KeHoachBaoTriDAO;
import Models.NghiepVuBaoTriTaiSan;
import Models.NghiepVuBaoTriTaiSanDAO;
import Models.NhiemVuBaoTri;
import Models.NhiemVuBaoTriDAO;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author thinh
 */
public class XuatFileExcel {
    private Workbook wb;
    private String pathFile;
    private KeHoachBaoTri keHoachBaoTri;
    private List<NhiemVuBaoTri> nhiemVuBaoTriList;
    private NhiemVuBaoTriDAO nhiemVuBaoTriDAO;
    private NghiepVuBaoTriTaiSanDAO nghiepVuBaoTriTaiSanDAO;
    private int indexRow = 0;
    
    public XuatFileExcel(String pathFile, KeHoachBaoTri keHoachBaoTri) throws IOException {
        wb = new XSSFWorkbook();
        this.pathFile = pathFile;
        
        initDAO();
        
        this.keHoachBaoTri = keHoachBaoTri;
        setDataForNhiemVuBaoTriList();
    }
    
    public XuatFileExcel(String pathFile) {
        wb = new XSSFWorkbook();
        this.pathFile = pathFile;
    }
    
    private void initDAO() {
        nhiemVuBaoTriDAO = new NhiemVuBaoTriDAO();
        nghiepVuBaoTriTaiSanDAO = new NghiepVuBaoTriTaiSanDAO();
    }
    
    private void setDataForNhiemVuBaoTriList() {
        nhiemVuBaoTriList = new ArrayList<>();
        try {
            nhiemVuBaoTriList = (ArrayList<NhiemVuBaoTri>) nhiemVuBaoTriDAO.getAllNhiemVuBaoTriByiDKeHoachBaoTri(keHoachBaoTri.getiD());
        }catch(SQLException ex) {
            ErrorDatabase errorDatabase = new ErrorDatabase();
            errorDatabase.HienThiThongBaoLoi(ex.getMessage());
        }
    }
    
    public void ExportExcel() throws IOException {
        Sheet sheet = wb.createSheet("Kế hoạch bảo trì");
        
        writeThongTinChung(sheet);
        for(int i=0; i<nhiemVuBaoTriList.size(); i++) {
            try {
                writeNhiemVuBaoTri(sheet, nhiemVuBaoTriList.get(0));
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        
        try(FileOutputStream fos = new FileOutputStream(pathFile)) {
            wb.write(fos);
        }
    }
    
    private void writeThongTinChung(Sheet sheet) {
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        
        Row titleThongTinChungRow = sheet.createRow(indexRow);
        Cell cell1InTitleThongTinChungRow = titleThongTinChungRow.createCell(0);
        cell1InTitleThongTinChungRow.setCellValue("Thông tin chung");
        cell1InTitleThongTinChungRow.setCellStyle(style);
        CellRangeAddress mergedTitleCell = new CellRangeAddress(0, 0, 0, 1);
        sheet.addMergedRegion(mergedTitleCell);
        indexRow++;
        
        Row thoiGianBatDauRow = sheet.createRow(indexRow);
        Cell labelThoiGianBatDauRow = thoiGianBatDauRow.createCell(0);
        labelThoiGianBatDauRow.setCellValue("Thời gian bắt đầu");
        Cell valueThoiGianBatDauRow = thoiGianBatDauRow.createCell(1);
        valueThoiGianBatDauRow.setCellValue(keHoachBaoTri.getThoiGianBatDau().toString());
        indexRow ++;
        
        Row thoiGianKetThucRow = sheet.createRow(indexRow);
        Cell labelThoiGianKetThucRow = thoiGianKetThucRow.createCell(0);
        labelThoiGianKetThucRow.setCellValue("Thời gian kết thúc");
        Cell valuethoiGianKetThucRow = thoiGianKetThucRow.createCell(1);
        valuethoiGianKetThucRow.setCellValue(keHoachBaoTri.getThoiGianKetThuc().toString());
        indexRow ++;
        
        Row ghiChuRow = sheet.createRow(indexRow);
        Cell labelGhiChuRow = ghiChuRow.createCell(0);
        labelGhiChuRow.setCellValue("Ghi chú");
        Cell valueGhiChuRow = ghiChuRow.createCell(1);
        valueGhiChuRow.setCellValue(keHoachBaoTri.getGhiChu());
        indexRow ++;
    }
    
    private void writeNhiemVuBaoTri(Sheet sheet, NhiemVuBaoTri nhiemVuBaoTri) throws SQLException {
        CellStyle centerAlignStyle = wb.createCellStyle();
        centerAlignStyle.setAlignment(HorizontalAlignment.CENTER);
        
        Row titleNhiemVuBaoTriRow = sheet.createRow(indexRow);
        Cell titleNhiemVuBaoTriRow0 = titleNhiemVuBaoTriRow.createCell(0);
        titleNhiemVuBaoTriRow0.setCellValue("Nhiệm vụ bảo trì");
        titleNhiemVuBaoTriRow0.setCellStyle(centerAlignStyle);
        CellRangeAddress mergedTitleNhiemVuBaoTriCell = new CellRangeAddress(indexRow, indexRow, 0, 2);
        sheet.addMergedRegion(mergedTitleNhiemVuBaoTriCell);
        indexRow++;
        
        Row headerNhiemVuBaoTri = sheet.createRow(indexRow);
        Cell tenNhiemVuBaoTriHeader = headerNhiemVuBaoTri.createCell(0);
        tenNhiemVuBaoTriHeader.setCellStyle(centerAlignStyle);
        tenNhiemVuBaoTriHeader.setCellValue("Tên nhiệm vụ");
        Cell chiTietNhiemVuHeader = headerNhiemVuBaoTri.createCell(1);
        chiTietNhiemVuHeader.setCellStyle(centerAlignStyle);
        chiTietNhiemVuHeader.setCellValue("Chi tiết nhiệm vụ");
        Cell chiPhiHeader = headerNhiemVuBaoTri.createCell(2);
        chiPhiHeader.setCellValue("Chi phí");
        chiPhiHeader.setCellStyle(centerAlignStyle);
        indexRow++;
        
        Row valueNhiemVuBaoTri = sheet.createRow(indexRow);
        Cell tenNhiemVuBaoTriValue = valueNhiemVuBaoTri.createCell(0);
        tenNhiemVuBaoTriValue.setCellValue(nhiemVuBaoTri.getTenNhiemVu());
        tenNhiemVuBaoTriValue.setCellStyle(centerAlignStyle);
        Cell chiTietNhiemVuValue = valueNhiemVuBaoTri.createCell(1);
        chiTietNhiemVuValue.setCellValue(nhiemVuBaoTri.getChiTietNhiemVu());
        chiTietNhiemVuValue.setCellStyle(centerAlignStyle);
        Cell chiPhiValue = valueNhiemVuBaoTri.createCell(2);
        chiPhiValue.setCellValue(nhiemVuBaoTri.getChiPhi());
        chiPhiValue.setCellStyle(centerAlignStyle);
        indexRow++;
        
        List<NghiepVuBaoTriTaiSan> nghiepVuBaoTriTaiSansList = new ArrayList<>();
        nghiepVuBaoTriTaiSansList = nghiepVuBaoTriTaiSanDAO.getTSBT_TSPM_PM_TSbyiDNhiemVuBaoTri(nhiemVuBaoTri.getiD());
        for(int i=0; i<nghiepVuBaoTriTaiSansList.size(); i++) {
            writeTaiSanCanBaoTri(sheet, nghiepVuBaoTriTaiSansList.get(i));
        }
    }
    
    private void writeTaiSanCanBaoTri(Sheet sheet, NghiepVuBaoTriTaiSan nghiepVuBaoTriTaiSan) {
        CellStyle centerAlignStyle = wb.createCellStyle();
        centerAlignStyle.setAlignment(HorizontalAlignment.CENTER);
        
        Row taiSanBaoTriTitleRow = sheet.createRow(indexRow);
        Cell taiSanBaoTriTitleCell0 = taiSanBaoTriTitleRow.createCell(0);
        taiSanBaoTriTitleCell0.setCellStyle(centerAlignStyle);
        taiSanBaoTriTitleCell0.setCellValue("Tài sản cần bảo trì");
        CellRangeAddress mergedTaiSanBaoTri = new CellRangeAddress(indexRow, indexRow, 0, 3);
        sheet.addMergedRegion(mergedTaiSanBaoTri);
        indexRow++;
        
        Row taiSanBaoTriHeader = sheet.createRow(indexRow);
        Cell phongMayHeader = taiSanBaoTriHeader.createCell(0);
        phongMayHeader.setCellValue("Phòng máy");
        phongMayHeader.setCellStyle(centerAlignStyle);
        Cell tenTaiSanHeader = taiSanBaoTriHeader.createCell(1);
        tenTaiSanHeader.setCellValue("Tên tài sản");
        tenTaiSanHeader.setCellStyle(centerAlignStyle);
        Cell soLuongHeader = taiSanBaoTriHeader.createCell(2);
        soLuongHeader.setCellValue("Số lượng");
        soLuongHeader.setCellStyle(centerAlignStyle);
        Cell yeuCauBaoTriHeader = taiSanBaoTriHeader.createCell(3);
        yeuCauBaoTriHeader.setCellValue("Yêu cầu bảo trì");
        yeuCauBaoTriHeader.setCellStyle(centerAlignStyle);
        indexRow++;
        
        Row taiSanBaoTriValue = sheet.createRow(indexRow);
        Cell phongMayValue = taiSanBaoTriValue.createCell(0);
        phongMayValue.setCellValue(nghiepVuBaoTriTaiSan.getPhongMay().getTenPhong());
        phongMayValue.setCellStyle(centerAlignStyle);
        Cell tenTaiSanValue = taiSanBaoTriValue.createCell(1);
        tenTaiSanValue.setCellValue(nghiepVuBaoTriTaiSan.getTaiSan().getTenTaiSan());
        tenTaiSanValue.setCellStyle(centerAlignStyle);
        Cell soLuongValue = taiSanBaoTriValue.createCell(2);
        soLuongValue.setCellValue(nghiepVuBaoTriTaiSan.getTaiSanBaoTri().getSoLuong());
        soLuongValue.setCellStyle(centerAlignStyle);
        Cell yeuCauBaoTriValue = taiSanBaoTriValue.createCell(3);
        yeuCauBaoTriValue.setCellValue(nghiepVuBaoTriTaiSan.getTaiSanBaoTri().getYeuCauBaoTri());
        yeuCauBaoTriValue.setCellStyle(centerAlignStyle);
        indexRow++;
    }
    
    public static void main(String[] args) {
        XuatFileExcel test = null;
        KeHoachBaoTriDAO keHoachBaoTriDAO = new KeHoachBaoTriDAO();
        KeHoachBaoTri keHoachBaoTri = null;
        try {
            keHoachBaoTri = keHoachBaoTriDAO.getAllKeHoachBaoTri().get(0);
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            test = new XuatFileExcel("D:/test.xlsx", keHoachBaoTri);
            test.ExportExcel();
        } catch(IOException ex) {
            ex.printStackTrace();
        } 
    }
    
}
