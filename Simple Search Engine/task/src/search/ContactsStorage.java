package search;

import search.KeywordSearch.InvertedIndexSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ContactsStorage {
    private List<String> contacts = new ArrayList<>();
    private HashMap<String, Set<Integer>> invertedIndexesMap = new HashMap<>();

    ContactsStorage() {
    }

    public ContactsStorage(ContactsStorage contactsStorage) {
        this.contacts.addAll(contactsStorage.getContacts());
        createIndexesMap();
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    public List<String> getContacts() {
        return contacts;
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
