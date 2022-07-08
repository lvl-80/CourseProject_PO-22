package com.lvl80.lingua.Lobby;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LobbyApp extends Application {
    private static Stage stage;
    @Override
    public void start(Stage _stage) throws IOException {
        stage = _stage;
        FXMLLoader fxmlLoader = new FXMLLoader(LobbyApp.class.getResource("LobbyApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        _stage.setTitle("Lingua Profile");
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