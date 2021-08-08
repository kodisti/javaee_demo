package hu.ulyssys.java.course.maven.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/hello-servlet")
public class HelloWorldServlet extends HttpServlet {
    // Belefogjuk tölteni a CDI-t ebbe alkalmazásba
    // jól át másoljuk eddigi CDI-os szolgáltatásainkat
    // 3 Servlet.
    // 1 egyik egy táblázatott fog készíteni HTML servicek álltali adatokat
    // 2 Megcsinálunk egy olyan servlet PDF elkészítettünk, azt böngészőven le lehessen tölteni
    // 3 XLS is az export Servletet

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Ez az én címem</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>This is a Heading</h1>\n" +
                "<p>This is a paragraph.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n");

    }

    //POST - adatokat küldünk a szerver

}
