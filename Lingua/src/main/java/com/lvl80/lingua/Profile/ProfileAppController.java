package com.lvl80.lingua.Profile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvl80.lingua.Authorization.AuthorizationApp;
import com.lvl80.lingua.Lobby.LobbyApp;
import com.lvl80.lingua.Types.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ProfileAppController {
    @FXML
    private Label labelMail;
    @FXML
    private Label labelLogin;
    @FXML
    private Label labelLevel;
    @FXML
    private Label labelMistakes;
    @FXML
    private Label labelMark;

    // чтение данныъ с файла для профиля
    @FXML
    public void initialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(new File("settings/lastloginsession.json"), User.class);
        // установка значений
        labelMail.setText(user.getMail());
        labelLogin.setText(user.getLogin());
        labelLevel.setText(String.valueOf(user.getLevel()));
        labelMistakes.setText(String.valueOf(user.getMistakes()));
        labelMark.setText(Float.toString(user.getMark()));
    }

    // функция возврата в лобби
    public void backToLobby() throws IOException {
        LobbyApp lobbyApp = new LobbyApp();
        lobbyApp.start(new Stage());
        ProfileApp.getStage().close();
    }

    // выход из аккаунта
    public void backToAuthorization() throws IOException {
        AuthorizationApp authorizationApp = new AuthorizationApp();
        authorizationApp.start(new Stage());
        ProfileApp.getStage().close();
    }
}
