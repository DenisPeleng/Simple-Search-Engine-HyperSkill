package search;

import search.KeywordSearch.KeywordSearch;
import search.KeywordSearch.KeywordSearchFactory;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean isWorkingMenu = true;

    public static void startMenu(String[] args) {
        ContactsStorage contactsStorage = new ContactsStorage();
        String filePathContacts = null;
        boolean isReadFromFile = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("--data")) {
                filePathContacts = args[i + 1];
                isReadFromFile = true;
            }
        }
        if (isReadFromFile) {
            contactsStorage.addContactsFromFile(filePathContacts);
            contactsStorage.createIndexesMap();
        } else {
            addContactsMenu(contactsStorage);
        }

        while (isWorkingMenu) {
            startMainMenu(contactsStorage);
        }

    }

    public static void addContactsMenu(ContactsStorage contactsStorage) {
        System.out.println("Enter the number of people:");
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter all people:");
        for (int i = 0; i < numberOfPeople; i++) {
            String currentStr = scanner.nextLine();
            contactsStorage.addContact(currentStr);
        }
        contactsStorage.createIndexesMap();
        System.out.println();
    }


    public static void searchResultsMenu(ContactsStorage contactsStorage) {
        KeywordSearchFactory keywordSearchFactory = new KeywordSearchFactory();
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String typeOfSearch = scanner.nextLine().toLowerCase();
        System.out.println("Enter a name or email to search all suitable people.");
        String dataToSearch = scanner.nextLine();
        KeywordSearch keywordSearch = keywordSearchFactory.doSearch(typeOfSearch, contactsStorage, dataToSearch);
        List<String> resultSearch = keywordSearch.searchForKeyword();
        if (!resultSearch.isEmpty()) {
            System.out.printf("%d persons found:\n", resultSearch.size());
            for (String data : resultSearch
            ) {
                System.out.println(data);
            }
        } else {
            System.out.println("No matching people found.");
        }
    }

    public static void startMainMenu(ContactsStorage contactsStorage) {
        System.out.println("=== Menu ===\n" +
                           "1. Find a person\n" +
                           "2. Print all people\n" +
                           "0. Exit");
        String nextLine = scanner.nextLine();
        int input = nextLine.isEmpty() ? -1 : Integer.parseInt(nextLine);
        System.out.println();
        switch (input) {
            case 1:
                searchResultsMenu(contactsStorage);
                break;
            case 2:
                contactsStorage.printAllData();
                break;
            case 0:
                System.out.println("Bye!");
                isWorkingMenu = false;
                break;
            default:
                System.out.println("Incorrect option! Try again.");
                break;
        }
        System.out.println();
    }
}
