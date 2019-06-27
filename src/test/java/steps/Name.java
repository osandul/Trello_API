package steps;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Name {
    BOARD("Board"),
    TO_DO("To Do");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}