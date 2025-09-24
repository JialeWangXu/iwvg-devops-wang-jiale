package es.upm.miw.devops.code;
import java.util.stream.Stream;

public class UsersDatabase {

    public Stream<User> findAll() {

        return Stream.of(
                new User("1", "Oscar", "Fernandez"),
                new User("2", "Ana", "Blanco"),
                new User("3", "Oscar", "López"),
                new User("4", "Paula", "Torres"),
                new User("5", "Antonio", "Blanco"),
                new User("6", "Paula", "Torres")
        );
    }
}