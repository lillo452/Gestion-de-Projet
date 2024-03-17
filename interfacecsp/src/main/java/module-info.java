module files.interfacecsp {
    requires javafx.controls;
    requires javafx.fxml;


    opens files.interfacecsp to javafx.fxml;
    exports files.interfacecsp;
}