package com.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class App {

    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("demo\\src\\main\\java\\com\\example\\audio-library.json");

            Gson gson = new Gson();

            Type songListType = new TypeToken<List<Song>>() {}.getType();

            List<Song> songs = gson.fromJson(reader, songListType);

            reader.close();

            for (Song song : songs) {
                System.out.println(
                    "Title: " + song.name() + "\n" +
                    "Artist: " + song.artist() + "\n" +
                    "Year: " + song.year() + "\n" +
                    "Genre: " + song.genre() + "\n" +
                    "File: " + song.fileName() + "\n"
                );
            }

        } catch (Exception e) {
            System.out.println("Error loading songs.");
            e.printStackTrace();
        }
    }
}
