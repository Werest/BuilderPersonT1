import java.util.OptionalInt;

public class PersonBuilder {
    private String firstname;
    private String surname;
    private OptionalInt age = OptionalInt.empty();
    private String city;

    public PersonBuilder setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if(age >= 0 && age < 130){
            this.age = OptionalInt.of(age);
        }else{
            throw new IllegalArgumentException("Недопустимый возраст человека!");
        }
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public Person build(){
        //Поля не заполнены
        if(firstname == null || surname == null || firstname.isEmpty() || surname.isEmpty()){
            throw new IllegalStateException("Не заполнены обязательные поля! Имя и Фамилия.");
        } else if (age.isPresent()) {
            return new Person(firstname, surname, age.getAsInt(), city);
        } else {
            return new Person(firstname, surname, city);
        }
    }
}
