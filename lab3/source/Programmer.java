package source;

import java.time.LocalDate;

public class Programmer extends Person {
    private String favoriteLanguage;

    public Programmer(String id, String name, LocalDate birthDate, String nationality, String favoriteLanguage) {
        super(id, name, birthDate, nationality);
        this.favoriteLanguage = favoriteLanguage;
    }

    @Override
    public String toString() {
        return String.format("Programmer{name='%s', language='%s', born='%s'}", getName(), favoriteLanguage, getBirthDate());
    }
}