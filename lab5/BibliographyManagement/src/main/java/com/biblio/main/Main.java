package com.biblio.main;

import com.biblio.algorithm.SetCoverAlgorithm;
import com.biblio.command.*;
import com.biblio.model.Article;
import com.biblio.model.Book;
import com.biblio.model.Item;
import com.biblio.repository.Catalog;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("========== PARTEA 1: COMPULSORY & HOMEWORK ==========");
            Catalog smallCatalog = new Catalog("MyRefs");

            Command add1 = new AddCommand(smallCatalog, new Book("book1", "The Art of Computer Programming", "https://google.com"));
            Command add2 = new AddCommand(smallCatalog, new Article("art1", "The Java Specification", "https://docs.oracle.com"));
            add1.execute();
            add2.execute();

            Command save = new SaveCommand(smallCatalog, "catalog.json");
            save.execute();

            LoadCommand load = new LoadCommand("catalog.json");
            load.execute();
            Catalog loadedCatalog = load.getCatalog();

            System.out.println("\n---> Afisare elemente (ListCommand):");
            Command list = new ListCommand(loadedCatalog);
            list.execute();

            System.out.println("\n---> Generare Raport HTML (ReportCommand) si Deschidere (ViewCommand)...");

            Command report = new ReportCommand(loadedCatalog);
            report.execute();

            Command view = new ViewCommand(loadedCatalog.findById("book1"));
            view.execute();


            System.out.println("\n========== PARTEA 2: ADVANCED (PERFORMANCE TEST) ==========");
            System.out.println("Generam 100 de concepte si 10.000 de carti...");

            Set<String> officialConcepts = new HashSet<>();
            officialConcepts.add("Graph theory");
            officialConcepts.add("Neural Networks");
            officialConcepts.add("Algorithm design techniques");
            officialConcepts.add("Object-oriented programming");
            for (int i = 5; i <= 100; i++) {
                officialConcepts.add("Concept_" + i);
            }
            List<String> conceptList = new ArrayList<>(officialConcepts);

            Catalog massiveCatalog = new Catalog("MassiveCatalog");
            Random random = new Random();

            for (int i = 1; i <= 10000; i++) {
                Book book = new Book("id_" + i, "Random Book " + i, "path");
                int numConcepts = random.nextInt(20) + 1;
                for (int j = 0; j < numConcepts; j++) {
                    book.addConcept(conceptList.get(random.nextInt(conceptList.size())));
                }
                massiveCatalog.add(book);
            }

            System.out.println("Pornim algoritmul Set Cover...");
            SetCoverAlgorithm algorithm = new SetCoverAlgorithm();

            long startTime = System.currentTimeMillis();
            List<Item> solution = algorithm.findSmallestCoverage(massiveCatalog, officialConcepts);
            long endTime = System.currentTimeMillis();

            System.out.println("-----------------------------------------");
            System.out.println("Timp de executie algoritm: " + (endTime - startTime) + " ms");
            System.out.println("Numar minim de resurse alese pentru a acoperi tot: " + solution.size());
            System.out.println("-----------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}