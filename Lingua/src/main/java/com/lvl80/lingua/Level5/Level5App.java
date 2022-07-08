package com.lvl80.lingua.Level5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Level5App extends Application {
    private static Stage stage;
    @Override
    public void start(Stage _stage) throws IOException {
        stage = _stage;
        FXMLLoader fxmlLoader = new FXMLLoader(com.lvl80.lingua.Level5.Level5App.class.getResource("Level5App.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        _stage.setTitle("Lingua");
        _stage.setResizable(false);
        _stage.setScene(scene);
        _stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Stage getStage(){
        return stage;
    }
}