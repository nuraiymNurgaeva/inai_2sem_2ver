package com.courseproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class SalaryController1 {

        ObservableList<String> roles = FXCollections.observableArrayList("hrmanager", "worker", "director");

        @FXML
        private Button ApplySalaryButtom;

        @FXML
        private TextField bonus;

        @FXML
        private Text errorLabel;

        @FXML
        private TextField name;

        @FXML
        private TextField position;

        @FXML
        private ComboBox<String> role;

        @FXML
        private TextField salary;

        @FXML
        Label lbl = new Label();

        @FXML
        public void initialize() throws SQLException {

                role.setItems(roles);
                role.setOnAction(event -> lbl.setText(role.getValue()));
                ApplySalaryButtom.setOnAction(ActionEvent->{
                });

    }}
