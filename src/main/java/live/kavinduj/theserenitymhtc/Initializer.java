package live.kavinduj.theserenitymhtc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Initializer extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent load = FXMLLoader.load((getClass().getResource("/view/LogIn.fxml")));
        stage.setScene(new Scene(load));
        stage.setTitle("The Serenity MHTC");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}