package com.shashank.ps.streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamDemo {

    public static void main(String[] args) {
        intNumberStream().forEach(e -> System.out.print(e + " "));
        System.out.println("----------------------------");
        intNumberStream().filter(number -> number < 5)
                .forEach(System.out::println);
        System.out.println("----------------------------");
        intNumberStream().filter(number -> number < 10)
                .skip(2)
                .forEach(System.out::println);
        System.out.println("----------------------------");
        Integer firstGreat = intNumberStream().filter(number -> number > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(firstGreat);

        System.out.println("----------------------------");

        userStream().forEach(System.out::println);
        userStream().map(User::getFirsName)
                .forEach(System.out::println);

        System.out.println("----------------------------");

        intNumberStream()
                .flatMap(id -> userStream().filter(user -> user.getId() == id))
                .map(User::getFirsName)
                .forEach(System.out::println);

        System.out.println("----------------------------");

        userStream()
                .filter(u -> intNumberStream().anyMatch(i -> i == u.getId() ))
                .forEach(System.out::println);
    }

    public static Stream<Integer> intNumberStream() {
        return Stream.iterate(0, i -> i+2).limit(20);
    }

    public static Stream<User> userStream() {
        return Stream.of(
                new User(2, "Lionel", "Messi"),
                new User(4, "Peter", "Parker"),
                new User(5, "Robert", "Johnson"),
                new User(6, "Mike", "Harrison"),
                new User(8, "Nikki", "Wiesz"),
                new User(9, "Judy", "Bella"),
                new User(10, "Isa", "Issac")
        );
    }
}

@AllArgsConstructor
@Getter
@Setter
@ToString
class User {
    private int id;
    private String firsName;
    private String lastName;
}
