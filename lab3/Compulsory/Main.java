package Compulsory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person alice = new Programmer("P01", "Alice Smith");
        Person bob = new Designer("P02", "Bob Johnson");
        Company techCorp = new Company("C01", "Tech Corp");
        Company designStudio = new Company("C02", "Alpha Design");


        alice.addAcquaintance(bob, "University Friends");
        alice.addEmployment(techCorp, "Senior Java Developer");
        bob.addEmployment(designStudio, "Lead UX Designer");


        List<Profile> network = new ArrayList<>();
        network.add(alice);
        network.add(bob);
        network.add(techCorp);
        network.add(designStudio);

        System.out.println("--- Network Before Sorting ---");
        for (Profile p : network) {
            System.out.println(p);
        }


        network.sort(Comparator.comparing(Profile::getName));

        System.out.println("\n--- Network After Sorting ---");
        for (Profile p : network) {
            System.out.println(p);


            if (p instanceof Person person) {
                System.out.println("   Friends: " + Arrays.toString(person.getAcquaintances()));
                System.out.println("   Jobs: " + Arrays.toString(person.getEmployments()));
            }
        }
    }
}