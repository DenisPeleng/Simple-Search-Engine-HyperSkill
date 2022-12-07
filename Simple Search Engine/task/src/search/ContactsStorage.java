package search;

import java.util.ArrayList;
import java.util.List;

public class ContactsStorage {
    private final List<String> contacts = new ArrayList<>();

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
public void printAllData(){
    System.out.println("=== List of people ===");
    for (String data:contacts
         ) {
        System.out.println(data);
    }
}
}
