package hu.ulyssys.java.course.maven.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//Fel is konfigráltuk, ha lesz REST endpointok, akkor base URL localhost:8080/api
@ApplicationPath("/api")
public class RestApplication extends Application {
}
