package hu.ulyssys.java.course.javaee.demo.vehicle.service.impl;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.AbstractVehicle;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Car;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Plane;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Ship;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.CarService;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.PlaneService;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.ShipService;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.XLSExportService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.inject.Inject;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class XLSExportServiceImpl implements XLSExportService {

    @Inject
    private CarService carService;

    @Inject
    private PlaneService planeService;

    @Inject
    private ShipService shipService;

    @Override
    public void processExport() {

        Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
        Sheet carSheet = wb.createSheet("Car");
        Sheet planeSheet = wb.createSheet("Plane");
        Sheet shipSheet = wb.createSheet("Ship");

        int i = 0;
        Row carHeader = carSheet.createRow(i);
        carHeader.createCell(0).setCellValue("Id");
        carHeader.createCell(1).setCellValue("Gyártó");
        carHeader.createCell(2).setCellValue("típus");
        carHeader.createCell(3).setCellValue("Jármű típusa");
        carHeader.createCell(4).setCellValue("Ajtók száma");

        i++;

        for (Car car : carService.getAll()) {
            Row row = createSheet(carSheet, i, car);
            row.createCell(4).setCellValue(car.getDoorNumbers());
            i++;
        }

        i = 0;
        Row planeHeader = planeSheet.createRow(i);
        planeHeader.createCell(0).setCellValue("Id");
        planeHeader.createCell(1).setCellValue("Gyártó");
        planeHeader.createCell(2).setCellValue("típus");
        planeHeader.createCell(3).setCellValue("Jármű típusa");
        i++;
        for (Plane plane : planeService.getAll()) {
            createSheet(planeSheet, i, plane);
            i++;
        }

        i = 0;
        Row shipHeader = shipSheet.createRow(i);
        shipHeader.createCell(0).setCellValue("Id");
        shipHeader.createCell(1).setCellValue("Gyártó");
        shipHeader.createCell(2).setCellValue("típus");
        shipHeader.createCell(3).setCellValue("Jármű típusa");
        i++;
        for (Ship ship : shipService.getAll()) {
            createSheet(shipSheet, i, ship);
            i++;
        }


        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {

            wb.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Row createSheet(Sheet sheet, int i, AbstractVehicle vehicle) {
        Row row = sheet.createRow(i);
        row.createCell(0).setCellValue(vehicle.getId());
        row.createCell(1).setCellValue(vehicle.getManufacturer());
        row.createCell(2).setCellValue(vehicle.getType());
        row.createCell(3).setCellValue(vehicle.getVehicleType().toString());
        return row;
    }

}
