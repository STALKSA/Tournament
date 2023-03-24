
package Tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {


    @Test
    public void testSecondPlayerWin() {
        Game game = new Game();

        Player player1 = new Player(1, "Валерия", 20);
        Player player2 = new Player(2, "Николай", 30);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Валерия", "Николай");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstPlayerWin() {
        Game game = new Game();

        Player player1 = new Player(1, "Валерия", 40);
        Player player2 = new Player(2, "Николай", 30);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Валерия", "Николай");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTie() {
        Game game = new Game();

        Player player1 = new Player(1, "Валерия", 40);
        Player player2 = new Player(2, "Николай", 40);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Валерия", "Николай");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExists() {
        Game game = new Game();

        Player player1 = new Player(1, "Валерия", 40);
        Player player2 = new Player(2, "Николай", 40);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotExistsException.class,
                () -> game.round("Игорь", "Валерия"));

    }

    @Test
    public void testWhenSecondPlayerNotExists() {
        Game game = new Game();

        Player player1 = new Player(1, "Валерия", 40);
        Player player2 = new Player(2, "Николай", 40);


        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotExistsException.class,
                () -> game.round("Валерия", "Олег"));

    }

    @Test
    public void testWhenBothPlayersNotExists() {
        Game game = new Game();

        Player player1 = new Player(1, "Валерия", 40);
        Player player2 = new Player(2, "Николай", 40);


        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotExistsException.class,
                () -> game.round("Павел", "Олег"));

    }

}
