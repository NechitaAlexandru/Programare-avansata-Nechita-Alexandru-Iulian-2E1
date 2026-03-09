package source;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        Programmer alice = new Programmer("P01", "Alice", LocalDate.of(1995, 4, 12), "US", "Java");
        Designer bob = new Designer("P02", "Bob", LocalDate.of(1992, 8, 22), "UK", "Figma");
        Person charlie = new Person("P03", "Charlie", LocalDate.of(1998, 11, 5), "Canada");
        Company techCorp = new Company("C01", "Tech Corp", "IT Services");
        Company designStudio = new Company("C02", "Alpha Design", "Graphic Design");

        network.addProfile(alice);
        network.addProfile(bob);
        network.addProfile(charlie);
        network.addProfile(techCorp);
        network.addProfile(designStudio);

        alice.addRelationship(bob, "University Friend");
        alice.addRelationship(techCorp, "Lead Java Developer");

        bob.addRelationship(alice, "Mutual Friend");
        bob.addRelationship(designStudio, "Senior UI/UX Designer");

        charlie.addRelationship(alice, "Mentee");
        charlie.addRelationship(techCorp, "Contractor");
        charlie.addRelationship(designStudio, "Freelance Illustrator");

        network.printNetwork();
    }
}