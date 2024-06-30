package com.springpractice.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class StreamExamples
{
    public static void main(String[] args)
    {

        //find sum of int numbers
        List<Integer> values = List.of(3, 5, 8, 2, 9, 10, 45);

        System.out.println(values.stream().mapToInt(Integer::intValue).sum());

        //find avg of int numbers
        List<Integer> values2 = List.of(3, 5, 8, 2, 9, 10, 45);

        OptionalDouble result2 = values2.stream().mapToInt(Integer::intValue).average();

        System.out.println(result2.isPresent() ? result2.getAsDouble() : "");

        //convert string list to uppercase
        List<String> convertToUppercase = List.of("sdfsvs", "sdfsdf", "werweef", "Fsfs");

        System.out.println(convertToUppercase.stream().map(String::toUpperCase).collect(Collectors.toList()));

        //find start with specific characters
        List<String> startsWith = List.of("sdfsvs", "sdfsdf", "werweef", "Fsfs");

        System.out.println(startsWith.stream().filter(row -> row.startsWith("sd")).count());

        //create map and sort it using values and return map
        Map<String, Integer> map = new HashMap<>();

        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 23);
        map.put("5", 6);
        map.put("6", 9);
        map.put("7", 10);

        map = map.entrySet().stream().sorted(comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o2, LinkedHashMap::new));
        System.out.println(map);


        // find avg for number of negative, positive & zeros
        List<Integer> numbers = List.of(1, 5, -1, 5, -5, -8, -2, 0, 0, 32, -52);

        long counts = numbers.size();

        float negativeValues = (numbers.stream().filter(row -> row < 0).count()) * 1.0f;
        float positiveValues = (numbers.stream().filter(row -> row > 0).count()) * 1.0f;
        float zeroesValues = (numbers.stream().filter(row -> row == 0).count()) * 1.0f;

        System.out.println((positiveValues / counts));
        System.out.println(negativeValues / counts);
        System.out.println(zeroesValues / counts);

        //find max repeated number
        List<Integer> arr = List.of(3, 2, 1, 3, 2, 3, 3, 4, 5, 6, 5, 6, 5);

        System.out.println(arr.stream()
                .collect(Collectors.groupingBy(integer -> integer, Collectors.counting()))
                .values()
                .stream()
                .mapToInt(Long::intValue)
                .max()
                .orElse(0));


        // sort string that contains numbers
        List<String> sorting = List.of("6", "234253535353534564664564646464646464645353", "31415926535897932384626433832795", "345", "3467", "4", "6", "9");

        System.out.println(sorting.stream().sorted((o1, o2) -> o1.length() < o2.length() ? -1 : o1.length() > o2.length() ? 1 : o1.compareTo(o2)).toList());

        // sort based on last number from digits into ascending order
        //29,48,63,55,81,93,87,72

        List<Integer> list = List.of(29,48,63,55,81,93,87,72);

        System.out.println(list.stream().sorted((o1,o2) ->
        {
            Integer a = o1 % 10;
            Integer b = o2 % 10;
            return a.compareTo(b);
        }).collect(Collectors.toList()));


        //find first non-repeating character from string
        String s1 = "Hello, Welcome to the Java World ";

        String s = s1.toLowerCase().chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(characterLongEntry ->
                        characterLongEntry.getKey() >= 'a'
                                && characterLongEntry.getKey() <= 'z'
                                && characterLongEntry.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().toString();

        System.out.println(s);

    }
}
