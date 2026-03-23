package com.biblio.algorithm;

import com.biblio.model.Item;
import com.biblio.repository.Catalog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetCoverAlgorithm {

    public List<Item> findSmallestCoverage(Catalog catalog, Set<String> targetConcepts) {
        Set<String> remainingConcepts = new HashSet<>(targetConcepts);
        List<Item> selectedItems = new ArrayList<>();
        List<Item> availableItems = new ArrayList<>(catalog.getItems());

        while (!remainingConcepts.isEmpty()) {
            Item bestItem = null;
            long maxCovered = 0;

            for (Item item : availableItems) {

                long covered = item.getConcepts().stream()
                        .filter(remainingConcepts::contains)
                        .count();

                if (covered > maxCovered) {
                    maxCovered = covered;
                    bestItem = item;
                }
            }

            if (bestItem == null) {
                System.out.println("Avertisment: Nu se pot acoperi toate conceptele cu resursele actuale din catalog!");
                break;
            }

            selectedItems.add(bestItem);
            remainingConcepts.removeAll(bestItem.getConcepts());
            availableItems.remove(bestItem);
        }

        return selectedItems;
    }
}