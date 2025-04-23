package live.kavinduj.theserenitymhtc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashController {

    @FXML
    private AnchorPane loadPageAnchor;

    @FXML
    private Label patientsCount;

    @FXML
    private Label programsCount;

    @FXML
    private Label sessionsCount;

    @FXML
    private Label therapistsCount;

    @FXML
    void initialize() throws IOException {
        loadPageAnchor.getChildren().clear();
        loadPageAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/DashBoard.fxml")));
    }

    @FXML
    void navAppoinments(ActionEvent event) throws IOException {
        loadPageAnchor.getChildren().clear();
        loadPageAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/TherapySession.fxml")));
    }

    @FXML
    void navBilling(ActionEvent event) throws IOException {
        loadPageAnchor.getChildren().clear();
        loadPageAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Payment.fxml")));
    }

    @FXML
    void navDash(ActionEvent event) throws IOException {
        loadPageAnchor.getChildren().clear();
        loadPageAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/DashBoard.fxml")));
    }

    @FXML
    void navPatitnt(ActionEvent event) throws IOException {
        loadPageAnchor.getChildren().clear();
        loadPageAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Patient.fxml")));
    }

    @FXML
    void navReports(ActionEvent event) {

    }

    @FXML
    void navPrograms(ActionEvent event) throws IOException {
        loadPageAnchor.getChildren().clear();
        loadPageAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/TherapyProgram.fxml")));
    }

    @FXML
    void navTherapist(ActionEvent event) throws IOException {
        loadPageAnchor.getChildren().clear();
        loadPageAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Therapist.fxml")));
    }

    public void logoutOnAction(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/LogIn.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
        ((Stage) loadPageAnchor.getScene().getWindow()).close();
    }
}

