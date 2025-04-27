package live.kavinduj.theserenitymhtc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import live.kavinduj.theserenitymhtc.bo.BOFactory;
import live.kavinduj.theserenitymhtc.bo.custom.impl.UserBOImpl;
import live.kavinduj.theserenitymhtc.dto.UserDTO;
import live.kavinduj.theserenitymhtc.exeception.InvalidCredentialsException;
import live.kavinduj.theserenitymhtc.exeception.NotFoundException;
import live.kavinduj.theserenitymhtc.util.PasswordUtils;

import java.io.IOException;

public class LogInController {

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Button btSignIn;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    private final UserBOImpl userBO = (UserBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.USER);

    @FXML
    void navHomePage(ActionEvent event) throws IOException {
        String userName = txtEmail.getText();
        String password = txtPassword.getText();

        try {
            if (userName.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Email or password cannot be empty");
            }

            boolean userExists = userBO.cheackUser(userName);
            if (!userExists) {
                throw new NotFoundException("User not found with the provided email");
            }

            UserDTO userDTO = userBO.cheackPassword(userName);
            String hashedPassword = userDTO.getPassword();
            boolean isPasswordValid = PasswordUtils.verifyPassword(password, hashedPassword);

            if (!isPasswordValid) {
                throw new InvalidCredentialsException("Invalid password");
            }

            String role = userDTO.getRole();
            if (role.equals("Admin")) {
                mainAnchor.getChildren().clear();
                mainAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminDash.fxml")));
            } else if (role.equals("Receptionist")) {
                mainAnchor.getChildren().clear();
                mainAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/ReceptionistDash.fxml")));
            }

        } catch (NotFoundException | InvalidCredentialsException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void navSignUp(MouseEvent event) throws IOException {
        mainAnchor.getChildren().clear();
        mainAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/SignUp.fxml")));
    }
}