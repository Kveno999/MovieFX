module com.example.moviefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.moviefx to javafx.fxml;
    exports com.example.moviefx;
}