package search;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void startMenu() {

        System.out.println("Enter the number of people:");
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter all people:");
        ContactsStorage contactsStorage = new ContactsStorage();
        for (int i = 0; i < numberOfPeople; i++) {
            String currentStr = scanner.nextLine();
            contactsStorage.addContact(currentStr);
        }
        System.out.println();
        searchInfoMenu(contactsStorage);
    }

    public static void searchInfoMenu(ContactsStorage contactsStorage) {
        System.out.println("Enter the number of search queries:");
        int amountQueries = Integer.parseInt(scanner.nextLine());
        System.out.println();
        for (int i = 0; i < amountQueries; i++) {


            searchResultsMenu(contactsStorage);
        }

    }

    public static void searchResultsMenu(ContactsStorage contactsStorage) {
        System.out.println("Enter data to search people:");
        String dataToSearch = scanner.nextLine();
        System.out.println();
        List<String> resultSearch = contactsStorage.searchByKeyword(dataToSearch);
        if (!resultSearch.isEmpty()) {
            System.out.println("Found people:");
            for (String data : resultSearch
            ) {
                System.out.println(data);
            }
        } else {
            System.out.println("No matching people found.");
        }
    }
}
