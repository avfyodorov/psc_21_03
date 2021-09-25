package misc.attestation.korshik;

import java.time.LocalDate;

public class User {
    private String name;
    private int steps;
    String surname;
    long age;
    public String middleName;
    public LocalDate regDate;

    public User(String name, int steps, String surname, long age, String middleName, LocalDate regDate) {
        this.name = name;
        this.steps = steps;
        this.surname = surname;
        this.age = age;
        this.middleName = middleName;
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", steps=" + steps +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", middleName='" + middleName + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
