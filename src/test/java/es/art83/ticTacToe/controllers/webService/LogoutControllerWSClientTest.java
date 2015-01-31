package es.art83.ticTacToe.controllers.webService;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.webService.ControllerFactoryWebService;
import es.art83.ticTacToe.controllers.webService.LoginControllerWebService;
import es.art83.ticTacToe.controllers.webService.LogoutControllerWebService;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class LogoutControllerWSClientTest {

    private LoginControllerWebService login;

    private LogoutControllerWebService logout;

    private PlayerEntity playerEntity;

    @Before
    public void before() {
        ControllerFactoryWebService factory = new ControllerFactoryWebService();
        this.login = (LoginControllerWebService) factory.getLoginController();
        this.logout = (LogoutControllerWebService) factory.getLogoutController();
        this.playerEntity = new PlayerEntity("u", "pass");
        this.login.register(playerEntity);
    }

    @Test
    public void testIsSavedGame() {
        assertTrue(this.logout.savedGame());
    }

    @Test
    public void testLogout() {
        this.logout.logout();
        assertFalse(this.login.logged());
    }

    @Test
    public void testIsByeTrue() {
        this.logout.logout();
        assertTrue(this.logout.bye());
    }

    @Test
    public void testIsByeFalse() {
        assertFalse(this.logout.bye());
    }

    @After
    public void after() {
        new WebServicesManager<>(WS.PATH_SESSIONS, this.logout.getSessionId()).delete();
        new WebServicesManager<>(WS.PATH_PLAYERS, this.playerEntity.getUser()).delete();
    }
}
