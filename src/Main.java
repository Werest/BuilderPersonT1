public class Main {
    public static void main(String[] args) {
        Person friend = new PersonBuilder()
                .setFirstname("Алексей")
                .setSurname("Тест")
                .setCity("Ростов-на-Дону")
                .setAge(29)
                .build();

        Person daughter = friend.newChildBuilder()
                .setFirstname("Вероника")
                .build();

        System.out.println("У " + friend + " есть дочь, " + daughter);

        friend.happyBirthday();
        daughter.happyBirthday();

        System.out.println("-----1 год спустя-------");

        System.out.println(friend);
        System.out.println(daughter);

        try {
            new PersonBuilder().build();
        } catch (IllegalStateException exception){
            exception.printStackTrace();
        }

        try {
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException exception){
            exception.printStackTrace();
        }


        try {
            new PersonBuilder().setAge(200).build();
        } catch (IllegalArgumentException exception){
            exception.printStackTrace();
        }
    }
}