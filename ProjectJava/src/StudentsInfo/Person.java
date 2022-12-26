package StudentsInfo;

public class Person {
    private final String surname;

    enum Gender{
        Male,
        Female
    }

    public Person(String name){
        this.surname = name;
    }

    public String getSurname() {
        return null;
    }

    public String getName() {
        return null;
    }

    public String getSurnameName() {
        return surname;
    }
}
