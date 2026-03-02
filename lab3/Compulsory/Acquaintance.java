package Compulsory;

public class Acquaintance {
    private Person person;
    private String relationshipType;

    public Acquaintance(Person person, String relationshipType) {
        this.person = person;
        this.relationshipType = relationshipType;
    }

    public Person getPerson() {
        return person;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    @Override
    public String toString() {
        return person.getName() + " (" + relationshipType + ")";
    }
}