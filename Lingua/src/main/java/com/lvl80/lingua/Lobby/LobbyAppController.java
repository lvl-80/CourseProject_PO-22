package com.lvl80.lingua.Lobby;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvl80.lingua.Level1.Level1App;
import com.lvl80.lingua.Level2.Level2App;
import com.lvl80.lingua.Level3.Level3App;
import com.lvl80.lingua.Level4.Level4App;
import com.lvl80.lingua.Level5.Level5App;
import com.lvl80.lingua.Literature.LiteratureApp;
import com.lvl80.lingua.Profile.ProfileApp;
import com.lvl80.lingua.Test.TestApp;
import com.lvl80.lingua.Types.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class LobbyAppController {
    @FXML
    private Label labelLevel;

    @FXML
    public void initialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(new File("settings/lastloginsession.json"), User.class);
        labelLevel.setText(String.valueOf(user.getLevel()));
    }

    // открытие разделов (func + номер раздела)
    public void func1() throws IOException {
        Level1App level1App = new Level1App();
        level1App.start(new Stage());
        LobbyApp.getStage().close();
    }
    public void func2() throws IOException {
        // проверка, чтобы нельзя было начать 2й уровень не пройдя 1й
        if (Integer.parseInt(labelLevel.getText()) > 2-1) {
            Level2App level2App = new Level2App();
            level2App.start(new Stage());
            LobbyApp.getStage().close();
            // если уровень равен 1 или меньше выводим ошибку
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка!");
            alert.setHeaderText(null);
            alert.setContentText("Для начала изучения раздела 2 необходимо пройти тест раздела 1.");
            alert.showAndWait();
        }
    }
    public void func3() throws IOException {
        // проверка, чтобы нельзя было начать 3й уровень не пройдя 2й
        if (Integer.parseInt(labelLevel.getText()) > 3-1) {
            Level3App level3App = new Level3App();
            level3App.start(new Stage());
            LobbyApp.getStage().close();
            // если уровень равен 2 или меньше выводим ошибку
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка!");
            alert.setHeaderText(null);
            alert.setContentText("Для начала изучения раздела 3 необходимо пройти тест раздела 2.");
            alert.showAndWait();
        }
    }
    public void func4() throws IOException {
        // проверка, чтобы нельзя было начать 4й уровень не пройдя 3й
        if (Integer.parseInt(labelLevel.getText()) > 4-1) {
            Level4App level4App = new Level4App();
            level4App.start(new Stage());
            LobbyApp.getStage().close();
            // если уровень равен 3 или меньше выводим ошибку
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка!");
            alert.setHeaderText(null);
            alert.setContentText("Для начала изучения раздела 4 необходимо пройти тест раздела 3.");
            alert.showAndWait();
        }
    }
    public void func5() throws IOException {
        // проверка, чтобы нельзя было начать 5й уровень не пройдя 4й
        if (Integer.parseInt(labelLevel.getText()) > 5-1) {
            Level5App level5App = new Level5App();
            level5App.start(new Stage());
            LobbyApp.getStage().close();
            // если уровень равен 4 или меньше выводим ошибку
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка!");
            alert.setHeaderText(null);
            alert.setContentText("Для начала изучения раздела 4 необходимо пройти тест раздела 3.");
            alert.showAndWait();
        }
    }

    public void openTest() throws IOException {
        TestApp testApp = new TestApp();
        testApp.start(new Stage());
        LobbyApp.getStage().close();
    }

    // особые вкладки
    public void openLiterature() throws IOException {
        LiteratureApp literatureApp = new LiteratureApp();
        literatureApp.start(new Stage());
        LobbyApp.getStage().close();
    }
    public void openProflie() throws IOException {
        ProfileApp profileApp = new ProfileApp();
        profileApp.start(new Stage());
        LobbyApp.getStage().close();
    }
}
