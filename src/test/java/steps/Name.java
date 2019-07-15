package steps;

import lombok.AllArgsConstructor;
import properties.PropertyLoader;

@AllArgsConstructor
public enum Name {
    BOARD(PropertyLoader.getProperty("BOARD_NAME")),
    TO_DO(PropertyLoader.getProperty("LIST_NAME")),
    CARD(PropertyLoader.getProperty("CARD_NAME"));

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}