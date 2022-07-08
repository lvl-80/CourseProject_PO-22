package com.lvl80.lingua.Level2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvl80.lingua.Lobby.LobbyApp;
import com.lvl80.lingua.Types.User;
import com.lvl80.lingua.Types.UserList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Level2AppController {
    @FXML
    private ScrollPane sp1;
    @FXML
    private ScrollPane sp2;
    @FXML
    private ScrollPane sp3;
    @FXML
    private ScrollPane sp4;
    @FXML
    private ScrollPane sp5;
    @FXML
    private ScrollPane sp6;
    @FXML
    private ScrollPane sp7;
    @FXML
    private ScrollPane sp8;
    @FXML
    private ScrollPane sp9;
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf4;
    @FXML
    private TextField tf5;
    @FXML
    private TextField tf6;
    @FXML
    private RadioButton rb1;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb3;
    @FXML
    private RadioButton rb4;


    private List<ScrollPane> spList = new ArrayList<>();

    @FXML
    public void initialize(){
        spList.add(sp1);
        spList.add(sp2);
        spList.add(sp3);
        spList.add(sp4);
        spList.add(sp5);
        spList.add(sp6);
        spList.add(sp7);
        spList.add(sp8);
        spList.add(sp9);
    }

    // функция возврата в лобби
    public void backToLobby() throws IOException {
        LobbyApp lobbyApp = new LobbyApp();
        lobbyApp.start(new Stage());
        Level2App.getStage().close();
    }

    // функции работы с темами (переключение тем)
    public void showSubtheme1(){
        for (ScrollPane sp_ : spList)
            sp_.setVisible(sp_ == sp1);
    }

    public void showSubtheme2(){
        for (ScrollPane sp_ : spList)
            sp_.setVisible(sp_ == sp2);
    }

    public void showSubtheme3(){
        for (ScrollPane sp_ : spList)
            sp_.setVisible(sp_ == sp3);
    }

    public void showSubtheme4(){
        for (ScrollPane sp_ : spList)
            sp_.setVisible(sp_ == sp4);
    }

    public void showSubtheme5(){
        for (ScrollPane sp_ : spList)
            sp_.setVisible(sp_ == sp5);
    }

    public void showSubtheme6(){
        for (ScrollPane sp_ : spList)
            sp_.setVisible(sp_ == sp6);
    }

    public void showSubtheme7(){
        for (ScrollPane sp_ : spList)
            sp_.setVisible(sp_ == sp7);
    }

    public void showSubtheme8(){
        for (ScrollPane sp_ : spList)
            sp_.setVisible(sp_ == sp8);
    }

    public void showSubtheme9(){
        for (ScrollPane sp_ : spList)
            sp_.setVisible(sp_ == sp9);
    }

    public void checkLevel2Test() throws IOException {
        // проверка правильности теста
        if (tf1.getText().equals("7") && tf2.getText().equals("x") && tf3.getText().equals("&&")
                && tf4.getText().equals("72") && tf5.getText().equals("for") && tf6.getText().equals("x")
                && rb1.isSelected() && !rb2.isSelected() && rb3.isSelected() && !rb4.isSelected())
        {
            // считывание информации о пользователе
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(new File("settings/lastloginsession.json"), User.class);
            // если уровень соответствует 2, то повышаем до 3
            if (user.getLevel() == 2) {
                UserList list = mapper.readValue(new File("settings/users.json"), UserList.class);
                int index;
                for (User user_ : list.getUsers())
                    if (user_.getMail().equals(user.getMail()) && user_.getLogin().equals(user.getLogin())) {
                        user_.setLevel(user.getLevel() + 1);
                        user.setLevel(user.getLevel() + 1);
                    }
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File("settings/lastloginsession.json"), user);
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File("settings/users.json"), list);
            }
            // открытие лобби после прохождения теста (в любом случае)
            LobbyApp lobbyApp = new LobbyApp();
            lobbyApp.start(new Stage());
            Level2App.getStage().close();
            // если данные теста неправильные - вывести ошибку
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в тесте. Пересмотрите варианты ответа (пробелы или регистр букв)");
            alert.showAndWait();
            // добавление ошибки к общему числу (запись инфы в файл)
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(new File("settings/lastloginsession.json"), User.class);
            UserList list = mapper.readValue(new File("settings/users.json"), UserList.class);
            for (User user_ : list.getUsers())
                if (user_.getMail().equals(user.getMail()) && user_.getLogin().equals(user.getLogin())) {
                    user_.setMistakes(user.getMistakes() + 1);
                    user.setMistakes(user.getMistakes() + 1);
                }
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("settings/lastloginsession.json"), user);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("settings/users.json"), list);
        }
    }
}
