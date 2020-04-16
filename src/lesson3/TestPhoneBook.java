package lesson3;


public class TestPhoneBook {
    public static void main(String[] args) {
        String [][] phoneArray = {
                {"Андрей", "+7(923)233-2352"}, {"Сергей", "+7(923)233-2222"}, {"Дмитрий", "+7(923)233-2333"},
                {"Оля", "+7(923)233-2456"},    {"Валя", "+9(923)233-3362"},   {"Аня", "+7(923)253-3362"},
                {"Андрей", "+7(923)333-3362"}, {"Аня", "+7(923)633-3362"},    {"Андрей", "+7(923)235-2352"},
                {"Сергей", "+7(923)253-2222"}, {"Дмитрий", "+7(923)245-2333"},  {"Оля", "+7(923)233-2736"},
                {"Валя", "+9(923)277-3362"},   {"Аня", "+7(923)288-3362"},    {"Андрей", "+7(923)399-3362"},
                {"Аня", "+7(923)613-3362"}};
        String userName ="Оля";

        PhoneBook phone = new PhoneBook();

        for(int i=0;i<phoneArray.length;i++){
            phone.add(phoneArray[i][0],phoneArray[i][1]);
        }

        System.out.println(userName);

        for (String o: phone.get(userName)){
            System.out.println(o);
        }
    }
}


