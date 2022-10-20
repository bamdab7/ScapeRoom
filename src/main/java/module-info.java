module com.example.scaperoomnpc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scaperoomnpc to javafx.fxml;
    exports com.example.scaperoomnpc;
}