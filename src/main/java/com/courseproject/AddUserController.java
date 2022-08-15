package com.courseproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AddUserController {
    ObservableList<String> roles = FXCollections.observableArrayList("hrmanager", "worker", "director");

    @FXML
    private Button butAdd;

    @FXML
    private Text errorLabel;

    @FXML
    private TextField frFn;

    @FXML
    private TextField frSt;

    @FXML
    private TextField login;

    @FXML
    private TextField moFn;

    @FXML
    private TextField moSt;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private TextField position;

    @FXML
    private ComboBox<String> role;
    @FXML
    Label lbl = new Label();

    @FXML
    private TextField salary;

    @FXML
    private TextField thFn;

    @FXML
    private TextField thSt;

    @FXML
    private TextField tuFn;

    @FXML
    private TextField tuSt;

    @FXML
    private TextField weFn;

    @FXML
    private TextField weSt;

    @FXML
    protected void initialize() {
        role.setItems(roles);
        role.setOnAction(event -> lbl.setText(role.getValue()));
        butAdd.setOnAction(event -> {
            String nameValue = name.getText();
            String loginValue = login.getText();
            String passValue = password.getText();
            int salaryValue = Integer.parseInt(salary.getText());
            String positionValue = position.getText();
            DatabaseHandler dbHandler = new DatabaseHandler();

            if (!nameValue.equals("") && !loginValue.equals("")
                    && !passValue.equals("") && !positionValue.equals("") && role != null) {
                errorLabel.setText("");
                dbHandler.signUpUser(nameValue, loginValue, passValue, role.getValue(), salaryValue, positionValue, moSt.getText(), moFn.getText(), tuSt.getText(), tuFn.getText(), weSt.getText(), weFn.getText(), thSt.getText(), thFn.getText(), frSt.getText(), frFn.getText());
                System.out.println("Success!");
            } else {
                errorLabel.setText("Fill all fields.");
            }

    });

}}
