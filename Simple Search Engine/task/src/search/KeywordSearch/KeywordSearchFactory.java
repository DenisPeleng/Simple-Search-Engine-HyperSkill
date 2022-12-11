package search.KeywordSearch;


import search.ContactsStorage;

public class KeywordSearchFactory {

    public KeywordSearch doSearch(String type, ContactsStorage contactsStorage, String keyword) {

        switch (type) {
            case "all": {
                return new AllKeywordSearch(contactsStorage, keyword);
            }
            case "any": {
                return new AnyKeywordSearch(contactsStorage, keyword);
            }
            case "none": {
                return new NoneKeywordSearch(contactsStorage, keyword);
            }
            default: {
                System.out.println("Wrong input");
            }
        }
        return new AllKeywordSearch(contactsStorage, keyword);
    }

}
