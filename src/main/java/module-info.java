module com.courseproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.base;

    opens com.courseproject to javafx.fxml;
    exports com.courseproject;
}