package source;

import java.time.LocalDate;

public class Designer extends Person {
    private String preferredTool;

    public Designer(String id, String name, LocalDate birthDate, String nationality, String preferredTool) {
        super(id, name, birthDate, nationality);
        this.preferredTool = preferredTool;
    }

    @Override
    public String toString() {
        return String.format("Designer{name='%s', tool='%s', born='%s'}", getName(), preferredTool, getBirthDate());
    }
}