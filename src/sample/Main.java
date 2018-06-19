package sample;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application  {
    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        Atsiliepimai atsiliepimuregistracija = new Atsiliepimai(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
