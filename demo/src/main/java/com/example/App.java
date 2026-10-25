package com.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("demo\\src\\main\\java\\com\\example\\audio-library.json");

            Gson gson = new Gson();

            Type songListType = new TypeToken<List<Song>>() {}.getType();

            List<Song> songs = gson.fromJson(reader, songListType);

            reader.close();

            Scanner scanner = new Scanner(System.in);
            String choice;

            do {
            System.out.println("\n=== Spotify-like Player ===");
            System.out.println("[H] Home");
            System.out.println("[S] Search");
            System.out.println("[L] Library");
            System.out.println("[Q] Quit");
            System.out.print("Choose an option: ");

            choice = scanner.nextLine().trim();

            switch (choice.toUpperCase()) {

                case "H":
                    System.out.println("\n=== Home ===");

                    for (Song song : songs) {
                        System.out.println(song.name() + " - " + song.artist());
                    }
                    break; 

                case "S":
                    System.out.println("\nSearch is coming soon!");
                    break;

                case "L":
                    System.out.println("\n=== Your Library ===");

                    for (Song song : songs) {
                        System.out.println(
                            "Title: " + song.name() + "\n" +
                            "Artist: " + song.artist() + "\n" +
                            "Year: " + song.year() + "\n" +
                            "Genre: " + song.genre() + "\n" +
                            "File: " + song.fileName() + "\n"
                        );
                    }
                    break;

                case "Q":
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println(
                        "Invalid option. Please choose H, S, L, or Q."
                    );

                }

                } while (!choice.equalsIgnoreCase("Q"));

            scanner.close();

            } catch (Exception e) {
              System.out.println("Error loading songs.");
              e.printStackTrace();
             }
    }
}

