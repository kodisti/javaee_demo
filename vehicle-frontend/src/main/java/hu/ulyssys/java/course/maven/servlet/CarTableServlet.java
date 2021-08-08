package hu.ulyssys.java.course.maven.servlet;

import hu.ulyssys.java.course.maven.vehicle.entity.Car;
import hu.ulyssys.java.course.maven.vehicle.service.CarService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/car")
public class CarTableServlet extends HttpServlet {

    @Inject
    private CarService carService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Ez az én címem</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>Ez a car oldal</h1>\n");
        builder.append("<table>");
        builder.append("<tr>");
        builder.append("<td>ID</td>");
        builder.append("<td>Típus</td>");
        builder.append("<td>Gyártó</td>");
        builder.append("<td>Rendszám</td>");
        builder.append("<td>Jármű típus</td>");
        builder.append("<td>Ajtók száma</td>");
        builder.append("</tr>");
        //for ciklust ami végig megy az összes Car-on, p-tag készítbelőle
        for (Car car : carService.getAll()) {
            builder.append("<tr>");
            builder.append("<td>" + car.getId() +
                    "</td>" +
                    " <td>" + car.getType() +
                    "</td>" +
                    " <td>" + car.getManufacturer() +
                    "</td>" +
                    "<td>Rendszám:" + car.getLicensePlateNumber() +
                    "</td>" +
                    "<td>Jármű típus:" + car.getVehicleType() +
                    "</td>" +
                    "<td>Ajtók száma:" + car.getDoorNumbers() +
                    "</td>");
            builder.append("</tr>");
        }
        builder.append("</table>");
        PrintWriter out = response.getWriter();
        out.println(new String(builder.toString().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8.name()));
        out.println("</body>\n" + "</html>\n");
    }
}
