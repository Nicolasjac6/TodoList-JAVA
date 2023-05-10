module com.example.todolistjavafxml {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.todolistjavafxml to javafx.fxml;
    exports com.example.todolistjavafxml;
}