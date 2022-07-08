module com.lvl80.lingua {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;

    opens com.lvl80.lingua.Lobby to javafx.fxml;
    exports  com.lvl80.lingua.Lobby;

    opens com.lvl80.lingua.Authorization to javafx.fxml,com.fasterxml.jackson.core,com.fasterxml.jackson.databind,com.fasterxml.jackson.annotation;
    exports com.lvl80.lingua.Authorization;

    opens com.lvl80.lingua.Types to com.fasterxml.jackson.core,com.fasterxml.jackson.databind,com.fasterxml.jackson.annotation;
    exports com.lvl80.lingua.Types;

    opens com.lvl80.lingua.Profile to javafx.fxml;
    exports com.lvl80.lingua.Profile;

    opens com.lvl80.lingua.Level1 to javafx.fxml;
    exports com.lvl80.lingua.Level1;

    opens com.lvl80.lingua.Level2 to javafx.fxml;
    exports com.lvl80.lingua.Level2;

    opens com.lvl80.lingua.Literature to javafx.fxml;
    exports com.lvl80.lingua.Literature;

    opens com.lvl80.lingua.Level3 to javafx.fxml;
    exports com.lvl80.lingua.Level3;

    opens com.lvl80.lingua.Level4 to javafx.fxml;
    exports com.lvl80.lingua.Level4;

    opens com.lvl80.lingua.Level5 to javafx.fxml;
    exports com.lvl80.lingua.Level5;

    opens com.lvl80.lingua.Test to javafx.fxml;
    exports com.lvl80.lingua.Test;
}