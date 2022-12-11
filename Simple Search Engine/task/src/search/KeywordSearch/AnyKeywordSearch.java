package search.KeywordSearch;


import search.ContactsStorage;

import java.util.ArrayList;
import java.util.List;

public class AnyKeywordSearch extends KeywordSearch {

    AnyKeywordSearch(ContactsStorage contactsStorage, String keyword) {
        super(contactsStorage, keyword);
    }

    @Override
    public List<String> searchForKeyword() {
        ContactsStorage contactsStorage = getContactsStorage();
        String keywords = getKeyword();
        List<String> result = new ArrayList<>();
        String[] keywordsArr = keywords.split(" ");
        for (String s : keywordsArr) {
            result.addAll(contactsStorage.searchByKeywordInvertedIndexMethod(s));
        }
        return result;
    }
}
