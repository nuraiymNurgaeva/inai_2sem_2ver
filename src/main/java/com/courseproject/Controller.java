package com.courseproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    static int userId;
    static String userName;
    static String userLogin;
    static String userRole;
    static int userSalary;
    static String userPos;
    static int userBonus;

    static void setUser(int id, String name, String login, String role, int salary, String pos, int bonus) {
        userId = id;
        userName = name;
        userLogin = login;
        userSalary = salary;
        userRole = role;
        userPos = pos;
        userBonus = bonus;

        System.out.println(userId);
        System.out.println(userName);
        System.out.println(userLogin);
        System.out.println(userSalary);
        System.out.println(userRole);
        System.out.println(userPos);
        System.out.println(userBonus);

    }
    static void setUserId(int id) {
        userId = id;
        System.out.println(userId);
    }
    @FXML
    private Text greetings;

    @FXML
    private Label infoLabel;

    @FXML
    private Button logout;

    @FXML
    protected void initialize() {
        logout.setOnAction(event -> {
            System.out.println("exit");
            logout.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("log_in.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.show();
        });
    };

    }
