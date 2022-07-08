package com.lvl80.lingua.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvl80.lingua.Lobby.LobbyApp;
import com.lvl80.lingua.Types.User;
import com.lvl80.lingua.Types.UserList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestAppController {
    @FXML
    private AnchorPane ap1;
    @FXML
    private AnchorPane ap2;
    @FXML
    private AnchorPane ap3;
    @FXML
    private AnchorPane ap4;
    @FXML
    private AnchorPane ap5;
    @FXML
    private AnchorPane ap6;
    @FXML
    private AnchorPane ap7;
    @FXML
    private AnchorPane ap8;
    @FXML
    private AnchorPane ap9;
    @FXML
    private AnchorPane ap10;
    @FXML
    private AnchorPane ap11;
    @FXML
    private AnchorPane ap12;
    @FXML
    private AnchorPane ap13;
    @FXML
    private AnchorPane ap14;
    @FXML
    private AnchorPane ap15;
    @FXML
    private AnchorPane ap16;
    @FXML
    private RadioButton rb1;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb3;
    @FXML
    private RadioButton rb4;
    @FXML
    private RadioButton rb5;
    @FXML
    private RadioButton rb6;
    @FXML
    private RadioButton rb7;
    @FXML
    private RadioButton rb8;
    @FXML
    private RadioButton rb9;
    @FXML
    private RadioButton rb10;
    @FXML
    private RadioButton rb11;
    @FXML
    private RadioButton rb12;
    @FXML
    private RadioButton rb13;
    @FXML
    private RadioButton rb14;
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Label lbl4;
    @FXML
    private Label lbl5;
    @FXML
    private Label lbl6;
    @FXML
    private Label lbl7;
    @FXML
    private Label lbl8;
    @FXML
    private Label lbl9;
    @FXML
    private Label lbl10;
    @FXML
    private Label lbl11;
    @FXML
    private Label lbl12;
    @FXML
    private Label lbl13;
    @FXML
    private Label lbl14;
    @FXML
    private Label lbl15;
    @FXML
    private Label lbl16;
    // лист слайдов
    private List<AnchorPane> apList = new ArrayList<>();
    private List<Label> lblList = new ArrayList<>();
    // переменная ответов
    private String answer = "";

    // функция возврата в лобби
    public void backToLobby() throws IOException {
        LobbyApp lobbyApp = new LobbyApp();
        lobbyApp.start(new Stage());
        TestApp.getStage().close();
    }

    @FXML
    public void initialize(){
        apList.add(ap1);
        apList.add(ap2);
        apList.add(ap3);
        apList.add(ap4);
        apList.add(ap5);
        apList.add(ap6);
        apList.add(ap7);
        apList.add(ap8);
        apList.add(ap9);
        apList.add(ap10);
        apList.add(ap11);
        apList.add(ap12);
        apList.add(ap13);
        apList.add(ap14);
        apList.add(ap15);
        apList.add(ap16);

        lblList.add(lbl1);
        lblList.add(lbl2);
        lblList.add(lbl3);
        lblList.add(lbl4);
        lblList.add(lbl5);
        lblList.add(lbl6);
        lblList.add(lbl7);
        lblList.add(lbl8);
        lblList.add(lbl9);
        lblList.add(lbl10);
        lblList.add(lbl11);
        lblList.add(lbl12);
        lblList.add(lbl13);
        lblList.add(lbl14);
        lblList.add(lbl15);
    }

    // функция начала
    public void showTest1(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap1);
    }

    public void showTest2(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap2);
    }

    public void showTest3(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap3);
    }

    public void showTest4(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap4);
    }

    public void showTest5(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap5);
    }

    public void showTest6(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap6);
    }
    public void showTest7(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap7);
    }
    public void showTest8(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap8);
    }

    public void showTest9(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap9);
    }

    public void showTest10(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap10);
    }

    public void showTest11(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap11);
    }

    public void showTest12(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap12);
    }

    public void showTest13(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap13);
    }

    public void showTest14(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap14);
    }

    public void showTest15(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap15);
    }

    public void showFinal(){
        for (AnchorPane ap_ : apList)
            ap_.setVisible(ap_ == ap16);
    }

    public void checkTest1(){
        // количество правильных ответов
        answer += rb1.isSelected() ? "1" : "0";
        // если ответ неправильный - выдать ошибку
        if (!rb1.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неправильный ответ!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в ответе. Код между фигурными скобками называется блоком.");
            alert.showAndWait();
        }
        // переход на следующий вопрос
        showTest2();
    }

    public void checkTest2(){
        // количество правильных ответов
        answer += rb2.isSelected() ? "1" : "0";
        // если ответ неправильный - выдать ошибку
        if (!rb2.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неправильный ответ!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в ответе. arr[1] обращается ко второй строке двумерного массива, которая содержит 5 элементов.");
            alert.showAndWait();
        }
        // переход на следующий вопрос
        showTest3();
    }

    public void checkTest3(){
        // количество правильных ответов
        answer += rb3.isSelected() ? "1" : "0";
        // если ответ неправильный - выдать ошибку
        if (!rb3.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неправильный ответ!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в ответе. char – это примитивный тип, а Character – класс-оболочка. Класс оболочка – это класс, который служит оболочкой для примитивных типов данных. Так как экземпляры этих классов являются объектами, они имеют ряд полезных методов.");
            alert.showAndWait();
        }
        // переход на следующий вопрос
        showTest4();
    }

    public void checkTest4(){
        // количество правильных ответов
        answer += rb4.isSelected() ? "1" : "0";
        // если ответ неправильный - выдать ошибку
        if (!rb4.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неправильный ответ!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в ответе. Оператор + используется для объединения строк. Например, выражение «Hello» + « world» равно «Hello world».");
            alert.showAndWait();
        }
        // переход на следующий вопрос
        showTest5();
    }

    public void checkTest5(){
        // количество правильных ответов
        answer += rb5.isSelected() ? "1" : "0";
        // если ответ неправильный - выдать ошибку
        if (!rb5.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неправильный ответ!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в ответе. Класс Object является суперклассом для всех других классов в Java.");
            alert.showAndWait();
        }
        // переход на следующий вопрос
        showTest6();
    }

    public void checkTest6(){
        // количество правильных ответов
        answer += rb6.isSelected() ? "1" : "0";
        // если ответ неправильный - выдать ошибку
        if (!rb6.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неправильный ответ!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в ответе. В отличие от целых чисел, деление значений с плавающей запятой на ноль никаких исключений не вызывает. Арифметика чисел с плавающей запятой реализована в соответствии со стандартом IEEE 754, который требует возвращения специального значения «Infinity» (Бесконечность), когда положительное число делится на ноль.");
            alert.showAndWait();
        }
        // переход на следующий вопрос
        showTest7();
    }

    public void checkTest7(){
        // количество правильных ответов
        answer += rb7.isSelected() ? "1" : "0";
        // если ответ неправильный - выдать ошибку
        if (!rb7.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неправильный ответ!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в ответе. Массивы в Java реализованы как объекты. В приведенной выше программе arr1 и arr2 – это ссылки, указывающие на разные объекты с одинаковым содержимым. Оператор == не сравнивает содержимое объектов, а сравнивает только ссылки.");
            alert.showAndWait();
        }
        // переход на следующий вопрос
        showTest8();
    }

    public void checkTest8(){
        // количество правильных ответов
        answer += rb8.isSelected() ? "1" : "0";
        // если ответ неправильный - выдать ошибку
        if (!rb8.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неправильный ответ!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в ответе. Возникнет ошибка компиляции, поскольку 1 используется в условии цикла. В отличие от C++, Java не позволяет неявно преобразовывать целочисленные значения в boolean.");
            alert.showAndWait();
        }
        // переход на следующий вопрос
        showTest9();
    }

    public void checkTest9(){
        // количество правильных ответов
        answer += rb9.isSelected() ? "1" : "0";
        // если ответ неправильный - выдать ошибку
        if (!rb9.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неправильный ответ!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в ответе. Поскольку строки неизменяемы в Java, для увеличения эффективности производительности и экономии памяти используется интернирование строк (string interning). Интернирование строк – это метод, при котором сохраняется только одна копия каждого различного строкового значения. Следовательно, обе ссылки (str1 и str2) указывают на одну и ту же ячейку памяти.");
            alert.showAndWait();
        }
        // переход на следующий вопрос
        showTest10();
    }

    public void checkTest10(){
        // количество правильных ответов
        answer += rb10.isSelected() ? "1" : "0";
        // если ответ неправильный - выдать ошибку
        if (!rb10.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неправильный ответ!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в ответе. Вызов нестатических методов из статических функций запрещен, поскольку нестатические методы связаны с экземплярами класса.");
            alert.showAndWait();
        }
        // переход на следующий вопрос
        showTest11();
    }

    public void checkTest11(){
        // количество правильных ответов
        answer += rb11.isSelected() ? "1" : "0";
        // если ответ неправильный - выдать ошибку
        if (!rb11.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неправильный ответ!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в ответе. Программа выведет 0. В утверждении «num = num++» используется постфиксный оператор инкремента. Поэтому порядок действий следующий: сохранить значение числа во временной переменной, увеличить ее значение на единицу и присвоить переменной num.");
            alert.showAndWait();
        }
        // переход на следующий вопрос
        showTest12();
    }

    public void checkTest12(){
        // количество правильных ответов
        answer += rb12.isSelected() ? "1" : "0";
        // если ответ неправильный - выдать ошибку
        if (!rb12.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неправильный ответ!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в ответе. Java не запрещает перегрузку функции main. Но имеющая String[] в качестве аргумента функция main всегда служит точкой входа в программу.");
            alert.showAndWait();
        }
        // переход на следующий вопрос
        showTest13();
    }

    public void checkTest13(){
        // количество правильных ответов
        answer += rb13.isSelected() ? "1" : "0";
        // если ответ неправильный - выдать ошибку
        if (!rb13.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неправильный ответ!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в ответе. Переменная real не равна самой себе. Как такое возможно? Арифметика с плавающей запятой реализована в соответствии со стандартом IEEE 754, который требует возвращения специального значения «NaN» (от английского “Not a Number” – не число), когда ноль делится на ноль. В спецификации также указано, что NaN не равно никакому значению с плавающей запятой, включая само себя.");
            alert.showAndWait();
        }
        // переход на следующий вопрос
        showTest14();
    }

    public void checkTest14(){
        // количество правильных ответов
        answer += rb14.isSelected() ? "1" : "0";
        // если ответ неправильный - выдать ошибку
        if (!rb14.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неправильный ответ!");
            alert.setHeaderText(null);
            alert.setContentText("Вы допустили ошибку в ответе. Размер типа byte составляет 8 бит, а его диапазон [-128, 127]. Все целые числа со знаком в современных компьютерах представлены в виде дополнительного кода (twos-compliment). Когда арифметическая операция дает результат, превышающий максимум, происходит переполнение. В данном случае двоичное представление 127 равно 01111111, при добавлении 1 получаем 10000000, что в дополнительном коде равно -128.");
            alert.showAndWait();
        }
        // переход на следующий вопрос
        showTest15();
    }

    public void checkTest15() throws IOException {
        // количество правильных ответов
        answer += "1";
        float mark = 0f;
        // отобразить результат
        for (int i = 0; i < 15; i++){
            // в зависимости от ответа менять цвет текста
            lblList.get(i).setTextFill(
                    ((answer.charAt(i) == '1') ? Color.GREEN : Color.RED));
            // установить, на какие вопросы и как ответил пользователь
            lblList.get(i).setText(
                    lblList.get(i).getText() +
                            ((answer.charAt(i) == '1') ? "Правильно" : "Неправильно"));
            mark += (answer.charAt(i) == '1') ? 1f : 0f;
        }
        // средняя оценка за тест
        char[] result = Float.toString((mark * 10) / 15).toCharArray();
        String result_ = String.valueOf(result[0]);
        if (mark == 10f) result_ = "10";
        lbl16.setText(
                lbl16.getText() + result_);
        // установить оценку для пользователя
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(new File("settings/lastloginsession.json"), User.class);
        UserList list = mapper.readValue(new File("settings/users.json"), UserList.class);
        for (User user_ : list.getUsers())
            if (user_.getMail().equals(user.getMail()) && user_.getLogin().equals(user.getLogin()))
                // если оценка пользователя меньше полученной, то переписываем её
                if (user_.getMark() < Float.parseFloat(result_) && user.getMark() < Float.parseFloat(result_)){
                    user_.setMark(Float.parseFloat(result_));
                    user.setMark(Float.parseFloat(result_));
                }
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("settings/lastloginsession.json"), user);
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("settings/users.json"), list);
        // переход на финальную стадию
        showFinal();
    }
}
