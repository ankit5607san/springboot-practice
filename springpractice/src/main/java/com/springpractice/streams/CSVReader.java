package com.springpractice.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader
{
    public static void main(String[] args)
    {
        try
        {
            readCsv("D:\\Projects\\springboot-practice\\springpractice\\src\\main\\resources\\sheet1.csv").forEach(System.out::println);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static List<List<String>> readCsv(String filePath) throws IOException, SecurityException
    {
        List<List<String>> result = new ArrayList<>();

        Files.lines(Paths.get(filePath))
                .skip(1) // Skip header row (optional)
                .map(line -> line.split(",")).forEach(row -> result.add(List.of(row)));

        return result;
    }
}
