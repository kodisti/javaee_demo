package hu.ulyssys.java.course.javaee.demo.vehicle.service.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Car;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.CarService;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.PDFExportService;

import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class PDFExportServiceImpl implements PDFExportService {
    @Inject
    private CarService carService;

    @Override
    public InputStream processExport() {
        try {
            Document document = new Document();
            //Memóriába betöltsük fájl tartalmát
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, stream);
            document.open();
            for (Car car : carService.getAll()) {
                document.add(new Paragraph("Id: " + car.getId() + ", gyártó: " + car.getManufacturer() + ", típus: " + car.getType()));
            }
            document.close();

            return new ByteArrayInputStream(stream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
