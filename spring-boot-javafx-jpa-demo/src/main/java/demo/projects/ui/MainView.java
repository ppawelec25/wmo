package demo.projects.ui;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import demo.projects.ui.ProjectsView;
import javafx.stage.Stage;

/**
 * Created by Paweł on 2016-03-15.
 */
@Component
public class MainView extends AbstractFxmlView {

    @FXML
    Button dopasuj;
    @FXML
    TextField wymagania;
    @FXML
    TextField typ;
    @FXML
    TextField ileTrwa;
    @FXML
    TextField zawnetrzne;
    @FXML
    TextField ux;
    @FXML
    TextField security;
    @FXML
    TextField bazadanych;

    @Autowired ProjectsView projectsView;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;
        if(event.getSource()==dopasuj){
            //get reference to the button's stage
            stage=(Stage) dopasuj.getScene().getWindow();
            stage.setScene(new Scene(projectsView.getView()));
            stage.show();
            System.out.println("WMO Kulas");
        }
    }
}
