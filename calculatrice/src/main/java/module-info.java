module calculatricenpi {
    requires javafx.controls;
    requires javafx.fxml;

    opens calculatricenpi.View to javafx.fxml;
    exports calculatricenpi.View;
}
