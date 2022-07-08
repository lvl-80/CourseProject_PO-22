package com.lvl80.lingua.Literature;

import com.lvl80.lingua.Lobby.LobbyApp;
import javafx.stage.Stage;
import java.io.IOException;

public class LiteratureAppController {
    // функция возврата в лобби
    public void backToLobby() throws IOException {
        LobbyApp lobbyApp = new LobbyApp();
        lobbyApp.start(new Stage());
        LiteratureApp.getStage().close();
    }
}
