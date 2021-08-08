package hu.ulyssys.java.course.maven.vehicle.jsf;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class FileDownloadView {

    private StreamedContent file;

    public FileDownloadView() {
        file = DefaultStreamedContent.builder()
                .name("downloaded_boromir.jpg")
                .contentType("image/jpg")
                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/boromir.jpg"))
                .build();
    }

    public StreamedContent getFile() {
        return file;
    }
}
