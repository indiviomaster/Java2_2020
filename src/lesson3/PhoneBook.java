package lesson3;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class PhoneBook {
    Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String name, String phone){
        List<String> phoneList = phoneBook.get(name);
        if (phoneList == null) phoneList = new ArrayList<>();
        phoneList.add(phone);
        phoneBook.put(name, phoneList);
    }

    @Override
    public String toString() {

        return "База\n"+phoneBook;
    }

    public List<String> get(String name) {

        return phoneBook.get(name);
    }


}
