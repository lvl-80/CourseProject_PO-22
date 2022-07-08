package com.lvl80.lingua.Authorization;
// TODO шифровка пароля
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvl80.lingua.Lobby.LobbyApp;
import com.lvl80.lingua.Types.User;
import com.lvl80.lingua.Types.UserList;
import com.lvl80.lingua.Utils.Base64;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class AuthorizationAppController {
    // массив файлов
    private File[] files = {new File("settings/lastloginsession.json"), new File("settings/users.json")};
    @FXML
    private TextField inputLogin;
    @FXML
    private TextField inputMail;
    @FXML
    private PasswordField inputPassword;

    // логин в систему
    public void login() throws IOException {
        // проверка на авторизацию
        boolean isLogined = false;
        // экземпляр мапера для  Json
        ObjectMapper mapper = new ObjectMapper();
        // если файла последнего логина не существует - тогда создаём новый файл
        if (!files[0].exists()) {
            files[0].createNewFile();
            mapper.writeValue(new File("settings/lastloginsession.json"), new User());
        }
        // если файла не существует - тогда создаём новый файл
        // и заполняем его пустотой
        if (!files[1].exists()) {
            files[1].createNewFile();
            mapper.writeValue(new File("settings/users.json"), new UserList());
            login();
        }
        else{
            // если файл существует - тогда читем существующие данные
            // и заносим в лист, который потом итерируем с целью
            // проверки на корректность введенных данных
            UserList list = mapper.readValue(new File("settings/users.json"), UserList.class);
            for (User user : list.getUsers())
                if (user.getLogin().equals(inputLogin.getText()) &&
                                new String(Base64.decode(user.getPassword(),1), StandardCharsets.UTF_8).equals(inputPassword.getText()) &&
                                    user.getMail().equals(inputMail.getText()))
                {
                    // делаем пользователя авторизованным
                    isLogined = true;
                    // входим в лобби под новым аккаунтом
                    mapper.writerWithDefaultPrettyPrinter().writeValue(new File("settings/lastloginsession.json"),new User(inputLogin.getText(),inputMail.getText(),Base64.encodeToString(inputPassword.getText().getBytes(StandardCharsets.UTF_8),1),user.getLevel(),user.getMistakes(), user.getMark()));
                    // открытие окна с лобби
                    LobbyApp lobbyApp = new LobbyApp();
                    lobbyApp.start(new Stage());
                    AuthorizationApp.getStage().close();
                }
            // если пользователь не смог авторизоваться
            if (!isLogined) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ошибка!");
                alert.setHeaderText(null);
                alert.setContentText("Вы допустили ошибку при авторизации. Пересмотрите введенные данные.");
                alert.showAndWait();
            }
        }
    }

    // регистрация новых пользователей
    public void addNewUser() throws IOException {
        // экземпляр мапера для  Json
        ObjectMapper mapper = new ObjectMapper();
        // если файла последнего логина не существует - тогда создаём новый файл
        if (!files[0].exists())
            files[0].createNewFile();
        mapper.writeValue(files[0], new User());
        // если файла не существует - тогда создаём новый файл
        // и заполняем его пустотой
        if (!files[1].exists()) {
            files[1].createNewFile();
            mapper.writeValue(files[1], new UserList());
            addNewUser();
        }
        else {
            // проверка на нулевое количество строк
            // если количество строк = 0 - удаляем файл и создаем нормально
            for (File file : files){
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = null;
                int lines = 0;
                while ((line = bufferedReader.readLine()) != null) ++lines;
                if (lines == 0){
                    file.delete();
                    addNewUser();
                }
            }
            // если файл существует - тогда читем существующие данные
            // и заносим в лист, который потом дополняем новой
            // информацией из формы
            UserList list = mapper.readValue(new File("settings/users.json"), UserList.class);
            // проверка на пустой символ
            if (inputLogin.getText().length() > 3 && inputPassword.getText().length() > 3 && inputMail.getText().length() > 8) {
                if (list.getUsers().isEmpty()) {
                    list.getUsers().add(new User(inputLogin.getText(), inputMail.getText(), Base64.encodeToString(inputPassword.getText().getBytes(StandardCharsets.UTF_8),1), 1,0,0f));
                    // запись в файл со всеми пользователями
                    mapper.writerWithDefaultPrettyPrinter().writeValue(new File("settings/users.json"),list);
                    // входим в лобби под новым аккаунтом
                    mapper.writerWithDefaultPrettyPrinter().writeValue(new File("settings/lastloginsession.json"),new User(inputLogin.getText(),inputMail.getText(), Base64.encodeToString(inputPassword.getText().getBytes(StandardCharsets.UTF_8),1),1,0,0f));
                    // очищаем поля ввода
                    inputLogin.clear();
                    inputMail.clear();
                    inputPassword.clear();
                    // открытие окна с лобби
                    LobbyApp lobbyApp = new LobbyApp();
                    lobbyApp.start(new Stage());
                    AuthorizationApp.getStage().close();
                }
                else {
                    // статус регистрации
                    boolean registrationStatus = true;
                    for (User user : list.getUsers())
                        // если данные заняты - вывести ошибку
                        if (user.getLogin().equals(inputLogin.getText()) || user.getMail().equals(inputMail.getText())) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Ошибка!");
                            alert.setHeaderText(null);
                            alert.setContentText("Данный логин или почта уже заняты.");
                            alert.showAndWait();
                            registrationStatus = false;
                            break;
                        }
                    // если логин и почта не заняты - то добавляем нового пользователя в список
                    if (registrationStatus) {
                        list.getUsers().add(new User(inputLogin.getText(), inputMail.getText(),  Base64.encodeToString(inputPassword.getText().getBytes(StandardCharsets.UTF_8),1), 1, 0,0f));
                        // запись в файл со всеми пользователями
                        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("settings/users.json"), list);
                        // входим в лобби под новым аккаунтом
                        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("settings/lastloginsession.json"), new User(inputLogin.getText(), inputMail.getText(), Base64.encodeToString(inputPassword.getText().getBytes(StandardCharsets.UTF_8),1), 1, 0,0f));
                        // очищаем поля ввода
                        inputLogin.clear();
                        inputMail.clear();
                        inputPassword.clear();
                        // открытие окна с лобби
                        LobbyApp lobbyApp = new LobbyApp();
                        lobbyApp.start(new Stage());
                        AuthorizationApp.getStage().close();
                    }
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ошибка!");
                alert.setHeaderText(null);
                alert.setContentText("Вы допустили ошибку при регистрации. Пересмотрите введенные данные.");
                alert.showAndWait();
            }
        }
    }
}
