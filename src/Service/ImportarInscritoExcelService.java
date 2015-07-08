/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*import org.apache.poi.hssf.usermodel.HSSFCell;import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
*/
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.InscritoService;

/**
 *
 * @author andre
 */
public class ImportarInscritoExcelService {
    
    private InscritoService inscritoService = new InscritoService();

    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String naturalidade;
    private String email;
    private String instituicao;

    public void lerArquivoXLS(String file) throws IOException {
        InputStream ExcelFileToRead = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row;
        HSSFCell cell;

        Iterator rows = sheet.rowIterator();

        while (rows.hasNext()) {
            row = (HSSFRow) rows.next();
            Iterator cells = row.cellIterator();

            while (cells.hasNext()) {
                cell = (HSSFCell) cells.next();

                if (cell.getColumnIndex() == 0) {
                    nome = cell.getStringCellValue();
                } else if (cell.getColumnIndex() == 1) {
                    cpf = cell.getStringCellValue();
                } else if (cell.getColumnIndex() == 2) {
                    dataNascimento = cell.getDateCellValue();
                } else if (cell.getColumnIndex() == 3) {
                    naturalidade = cell.getStringCellValue();
                } else if (cell.getColumnIndex() == 4) {
                    email = cell.getStringCellValue();
                } else if (cell.getColumnIndex() == 5) {
                    instituicao = cell.getStringCellValue();
                }
            }
            inscritoService.incluirInscritoImportadoExcel(nome, cpf, instituicao, naturalidade, dataNascimento, email);
        }

    }

    public void lerArquivoXLSX(String file) throws IOException {
        InputStream ExcelFileToRead = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row = null;
        XSSFCell cell;

        Iterator rows = sheet.rowIterator();

        while (rows.hasNext()) {
            row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();
                
                if (cell.getColumnIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "tá na primeira célula!!");
                    nome = cell.getStringCellValue();
                } else if (cell.getColumnIndex() == 1) {
                    JOptionPane.showMessageDialog(null, "tá na segunda célula!!");
                    cpf = cell.getStringCellValue();
                } else if (cell.getColumnIndex() == 2) {
                    JOptionPane.showMessageDialog(null, "tá na terceira célula!!");
                    dataNascimento = cell.getDateCellValue();
                } else if (cell.getColumnIndex() == 3) {
                    JOptionPane.showMessageDialog(null, "tá na quarta célula!!");
                    naturalidade = cell.getStringCellValue();
                } else if (cell.getColumnIndex() == 4) {
                    JOptionPane.showMessageDialog(null, "tá na quinta célula!!");
                    email = cell.getStringCellValue();
                } else if (cell.getColumnIndex() == 5) {
                    JOptionPane.showMessageDialog(null, "tá na sexta célula!!");
                    instituicao = cell.getStringCellValue();
                }
            }
            inscritoService.incluirInscritoImportadoExcel(nome, cpf, instituicao, naturalidade, dataNascimento, email);
        }

    }

    public void lerArquivo(String arquivo) throws IOException {
        if (arquivo.indexOf(".xlsx") > -1) {
            lerArquivoXLSX(arquivo);
        } else {
            lerArquivoXLS(arquivo);
        }

    }
}
