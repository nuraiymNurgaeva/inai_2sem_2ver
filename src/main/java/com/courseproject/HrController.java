package com.courseproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HrController {

    @FXML
    private Button addUser;

    @FXML
    private Button apply;

    @FXML
    private Text greetings;

    @FXML
    private TableView<User> hrtable;

    @FXML
    private Button logout;

    @FXML
    private Button remUser;

    @FXML
    private TableColumn<User, Integer> tableBonus;

    @FXML
    private TableColumn<User, Integer> tableId;

    @FXML
    private TableColumn<User, String> tableLogin;

    @FXML
    private TableColumn<User, String> tableName;

    @FXML
    private TableColumn<User, String> tablePass;

    @FXML
    private TableColumn<User, String> tablePos;

    @FXML
    private TableColumn<User, String> tableRole;

    @FXML
    private TableColumn<User, Integer> tableSalary;

    ObservableList<User> usersList = FXCollections.observableArrayList();

    @FXML
    protected void initialize() throws SQLException {
        setHrtable();

        greetings.setText("Hello, dear " + Controller.userName + "!");
        addUser.setOnAction(event -> {
            System.out.println(Controller.userName+" add user");

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("adduser.fxml"));

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
        logout.setOnAction(event -> {
            System.out.println(Controller.userName+"exit");
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
    }
    @FXML
    private void setHrtable() throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet result = dbHandler.getAllUser();
        User user = new User();


        while(true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            usersList.add(new User(result.getInt("id"),
                    result.getString("name"),
                    result.getString("login"),
                    result.getString("password"),
                    result.getInt("salary"),
                    result.getString("role"),
                    result.getString("pos"),
                    result.getInt("bonus")));

        }
        tableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        tablePass.setCellValueFactory(new PropertyValueFactory<>("password"));
        tableSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tableRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        tablePos.setCellValueFactory(new PropertyValueFactory<>("pos"));
        tableBonus.setCellValueFactory(new PropertyValueFactory<>("bonus"));

        tableId.setSortType(TableColumn.SortType.DESCENDING);

        hrtable.setItems(usersList);
    }
}
