public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Olga")
                .setSurname("Frolova")
                .setAge(40)
                .setAddress("Murmansk")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Andrey")
                .build();
        System.out.println(mom + " has a son " + son);

        try {
            //missing required fields
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        try {
            //invalid age
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
