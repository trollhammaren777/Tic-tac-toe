package maxim.botin.model;

public class Game {
    private final Field field;
    private final Player[] players;
    private final String name;

    public Game(final Field field, final Player[] players, String name) {
        this.field = field;
        this.name = name;
        this.players = players;
    }

    public Field getField() {
        return field;
    }

    public Player[] getPlayer() {
        return players;
    }

    public String getName() {
        return name;
    }
}
