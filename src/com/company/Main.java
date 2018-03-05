package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

  private static boolean isPrime(int number) {
    return java.util.stream.IntStream.rangeClosed(2, (int) Math.sqrt(number)).allMatch(num -> number % num != 0);
  }

  public static void main(String[] args) throws IOException {

    List<Movie> list = Movie.getMovie();

//  List out all the movies with rating more than 8 and genre comedy.
    Movie user = list.stream().filter(u -> u.getGenre().equals("comedy") && u.getRating() > 8)
        .findFirst().orElse(null);
    assert user != null;
    System.out.println(user.getName());

// List out all the movies with release year greater than 2000 and rating less than 8.
    list.stream().filter(u -> u.getReleaaseYear() > 2000 && u.getRating() < 8)
        .forEach(u -> System.out.println(u.getName()));

  // List out all the movies with rating as even number.
    list.stream().filter(u -> u.getRating() % 2 == 0)
        .forEach(u -> System.out.println(u.getName()));


    //List out all the movies with rating equals to 7 and genre Sci-Fi.
    list.stream().filter(u -> u.getGenre().equals("sci-fi") && u.getRating() == 7)
        .forEach(u -> System.out.println(u.getName()));

    System.out.println("First List");

    java.util.List<Integer> firstList = java.util.stream.IntStream.rangeClosed(2, 100).boxed()
        .collect(toList());
    java.util.Collections.shuffle(firstList);
    firstList.forEach(System.out::println);

    System.out.println("Second List");
    java.util.List<Integer> secondList = java.util.stream.IntStream.range(1, 100).boxed()
        .collect(java.util.stream.Collectors.toCollection(java.util.ArrayList::new));
    java.util.Collections.shuffle(secondList);
    secondList.forEach(System.out::println);

    //Given two lists of integers, list1 and list 2. Create a list of multiplication of the corresponding elements.

    System.out.println("Resultant  list after multiplication:");

    System.out.println(firstList.stream()
        .flatMap(s1 -> secondList.stream().map(s2 -> s1 * s2))
        .collect(Collectors.toList()));


    // read the contents of a file and return a Map<String, String> with key as the common word and values as the count
    Map<String, Integer> wordCounter = Files.lines(Paths.get("src/demo"))
        .flatMap(line -> Stream.of(line.split("\\s+")))
        .map(String::toLowerCase)
        .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));
    System.out.println("frequency count of words in file:");
    System.out.println(wordCounter);

   // Count the number of each word in a sentence.


    Map<String,Long> wordCount= Pattern.compile("\\s+").splitAsStream("My name is joey joey is my name")
        .map(String::toLowerCase)
        .collect(Collectors.groupingBy(
            Function.identity(),
            Collectors.counting()
        ));
    List<String> result = new ArrayList<>();
    System.out.println("frequency count of words in a sentence:");
    wordCount.forEach((k, v) -> result.add("[" + k +"->" + v +"]"));
    System.out.println(result);

    // Create a List<Integer>(with 100 elements) of random number and then filter the prime numbers out of it.

    System.out.println("Prime Numbers:");
    System.out.println(firstList.stream()
        .filter(Main::isPrime)
        .collect(toList()));

  }


}


