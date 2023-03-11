import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private final String firstname;
    private final String surname;
    private OptionalInt age = OptionalInt.empty();
    private String city;

    public Person(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public Person(String firstname, String surname, int age) {
        this.firstname = firstname;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public Person(String firstname, String surname, String city) {
        this.firstname = firstname;
        this.surname = surname;
        this.city = city;
    }

    public Person(String firstname, String surname, int age, String city) {
        this.firstname = firstname;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.city = city;
    }

    public boolean hasAge(){
        return age.isPresent();
    }

    public boolean hasAddress(){
        return city != null && !city.isEmpty();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void happyBirthday(){
        if(age.isPresent()){
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (age.isPresent() ? age.getAsInt() : "неясно")  +
                ", city='" + (!city.isEmpty() ? city : "неясно") + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstname, person.firstname) && Objects.equals(surname, person.surname) && Objects.equals(age, person.age) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, surname, age, city);
    }

    public PersonBuilder newChildBuilder(){
        return new PersonBuilder().setSurname(surname).setCity(city).setAge(0);
    }
}
