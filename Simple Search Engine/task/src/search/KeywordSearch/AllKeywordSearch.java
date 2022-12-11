package search.KeywordSearch;


import search.ContactsStorage;

import java.util.List;

public class AllKeywordSearch extends KeywordSearch {
    AllKeywordSearch(ContactsStorage contactsStorage, String keyword) {
        super(contactsStorage, keyword);
    }

    @Override
    public List<String> searchForKeyword() {
        ContactsStorage contactsStorageNew = new ContactsStorage(getContactsStorage());
        String keywords = getKeyword();
        String[] keywordsArr = keywords.split(" ");
        for (String s : keywordsArr) {
            List<String> result = contactsStorageNew.searchByKeywordInvertedIndexMethod(s);
            contactsStorageNew.setContacts(result);
            contactsStorageNew.createIndexesMap();
        }
        return contactsStorageNew.getContacts();
    }
}
