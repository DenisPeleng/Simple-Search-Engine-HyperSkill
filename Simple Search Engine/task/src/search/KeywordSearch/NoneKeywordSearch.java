package search.KeywordSearch;

import search.ContactsStorage;

import java.util.ArrayList;
import java.util.List;

public class NoneKeywordSearch extends KeywordSearch {

    NoneKeywordSearch(ContactsStorage contactsStorage, String keyword) {
        super(contactsStorage, keyword);
    }

    @Override
    public List<String> searchForKeyword() {
        ContactsStorage contactsStorage = getContactsStorage();
        String keywords = getKeyword();
        List<String> result = new ArrayList<>(contactsStorage.getContacts());
        String[] keywordsArr = keywords.split(" ");
        for (String s : keywordsArr) {
            List<String> resultSearch = contactsStorage.searchByKeywordInvertedIndexMethod(s);
            result.removeAll(resultSearch);
        }
        return result;
    }
}
