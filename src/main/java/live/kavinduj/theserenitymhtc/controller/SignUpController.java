package live.kavinduj.theserenitymhtc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import live.kavinduj.theserenitymhtc.bo.BOFactory;
import live.kavinduj.theserenitymhtc.bo.custom.impl.UserBOImpl;
import live.kavinduj.theserenitymhtc.dto.UserDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private Button btSignUp;

    @FXML
    private ChoiceBox<String> choiceRole;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private Label lblError;

    private final UserBOImpl userBO = (UserBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.USER);

    @FXML
    void SignupBtnOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {

        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        String role = choiceRole.getValue();
        String confirmPassword = txtConfirmPassword.getText();

        String lastId = userBO.getLastPK().orElse("U001");

        System.out.println(lastId);
        System.out.println(userName);
        System.out.println(password);
        System.out.println(role);
        System.out.println(confirmPassword);

        if(userName.isEmpty() || password.isEmpty() || role.isEmpty() || confirmPassword.isEmpty()){
            lblError.setText("Please fill all the fields");
            return;
        }

        if(password.length() < 8){
            lblError.setText("Password must be at least 8 characters");
            return;
        }

        if(!password.equals(confirmPassword)){
            lblError.setText("Password does not match");
            return;
        }

        if(userBO.cheackUser(userName)){
            lblError.setText("User already exist");
            return;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(lastId);
        userDTO.setUsername(userName);
        userDTO.setPassword(password);
        userDTO.setRole(role);

        boolean result = userBO.save(userDTO);

        if(result){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/LogIn.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
            Stage stage1 = (Stage) mainAnchor.getScene().getWindow();
            stage1.close();
            stage.setTitle("Log In");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("User sign up failed");
            alert.show();
            return;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceRole.getItems().addAll("Admin", "Receptionist");
    }

    public void navLogInPage(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/LogIn.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
        Stage stage1 = (Stage) mainAnchor.getScene().getWindow();
        stage1.close();
        stage.setTitle("Log In");
    }
}
