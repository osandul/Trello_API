package steps;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Name {
    BOARD("Test Board"),
    TO_DO("To Do"),
    CARD("Test Card");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}