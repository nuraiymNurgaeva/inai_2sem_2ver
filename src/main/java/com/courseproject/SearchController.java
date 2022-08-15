package com.courseproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

public class SearchController {
    @FXML
    private TableColumn<DirectorVariables1, Integer> SearchBonusColumn;

    @FXML
    private Button SearchButton;

    @FXML
    private TextField SearchField;

    @FXML
    private TableColumn<DirectorVariables1, Integer> SearchIDColumn;

    @FXML
    private Pane SearchMenu;

    @FXML
    private TableColumn<DirectorVariables1, String> SearchNameColumn;

    @FXML
    private TableColumn<DirectorVariables1, String> SearchPositionColumn;

    @FXML
    private TableColumn<DirectorVariables1, String> SearchRoleColumn;

    @FXML
    private TableColumn<DirectorVariables1, Integer> SearchSalaryColumn;

    @FXML
    private TableView<DirectorVariables1> SearchTable;

    @FXML
    public void initialize() throws SQLException {







    }

}
