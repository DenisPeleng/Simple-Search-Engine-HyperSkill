package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ContactsStorage {
    private final List<String> contacts = new ArrayList<>();
    private HashMap<String, Set<Integer>> invertedIndexesMap = new HashMap<>();

    public List<String> searchByKeyword(String keyword) {
        List<String> result = new ArrayList<>();
        for (String currentStr : contacts
        ) {
            if (currentStr.toLowerCase().contains(keyword.toLowerCase())) {
                result.add(currentStr);
            }
        }
        return result;
    }

    public void addContact(String contactStr) {
        contacts.add(contactStr);
    }

    public void printAllData() {
        System.out.println("=== List of people ===");
        for (String data : contacts
        ) {
            System.out.println(data);
        }
    }

    public void addContactsFromFile(String filepath) {
        File fileWithContacts = new File(filepath);
        try (Scanner scannerFile = new Scanner(fileWithContacts)) {
            while (scannerFile.hasNext()) {
                contacts.add(scannerFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void createIndexesMap() {
        invertedIndexesMap = InvertedIndexSearch.createIndexesMap(contacts);
    }

    public List<String> searchByKeywordInvertedIndexMethod(String keyword) {
        return InvertedIndexSearch.invertedIndexesSearch(contacts, keyword.toLowerCase(), invertedIndexesMap);
    }
}
