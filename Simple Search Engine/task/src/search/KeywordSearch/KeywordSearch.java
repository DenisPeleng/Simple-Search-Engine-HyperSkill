package search.KeywordSearch;

import search.ContactsStorage;

import java.util.List;

public abstract class KeywordSearch {
    private final String keyword;
    private final ContactsStorage contactsStorage;

    KeywordSearch(ContactsStorage contactsStorage, String keyword) {
        this.keyword = keyword;
        this.contactsStorage = contactsStorage;
    }

    public abstract List<String> searchForKeyword();

    public String getKeyword() {
        return keyword;
    }

    public ContactsStorage getContactsStorage() {
        return contactsStorage;
    }
}
