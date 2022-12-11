package search.KeywordSearch;


import java.util.*;

public class InvertedIndexSearch {


    public static HashMap<String, Set<Integer>> createIndexesMap(List<String> ListContacts) {
        HashMap<String, Set<Integer>> invertedIndexesMap = new HashMap<>();
        for (int i = 0; i < ListContacts.size(); i++) {
            String[] arrayOfLine = ListContacts.get(i).split(" ");
            for (String str : arrayOfLine) {
                String s = str.toLowerCase();
                Set<Integer> newSetIndexes = new HashSet<>();
                if (invertedIndexesMap.containsKey(s.toLowerCase())) {
                    Set<Integer> setIndexes = invertedIndexesMap.get(s);
                    newSetIndexes.addAll(setIndexes);
                    newSetIndexes.add(i);
                    invertedIndexesMap.replace(s, setIndexes, newSetIndexes);
                } else {
                    newSetIndexes.add(i);
                    invertedIndexesMap.put(s, newSetIndexes);
                }

            }
        }
        return invertedIndexesMap;
    }

    public static ArrayList<String> invertedIndexesSearch(List<String> contactsList, String keyword, HashMap<String, Set<Integer>> invertedIndexesMap) {
        ArrayList<String> result = new ArrayList<>();
        if (invertedIndexesMap.containsKey(keyword)) {
            Set<Integer> setIndexes = invertedIndexesMap.get(keyword);
            for (Integer index : setIndexes
            ) {
                result.add(contactsList.get(index));
            }
        }
        return result;
    }
}
