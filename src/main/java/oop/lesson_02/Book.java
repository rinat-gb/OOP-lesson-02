package oop.lesson_02;

/**
 * Класс Book для книг
 * 
 * Содержит название жанра, ФИО автора и название книги
 */
public class Book {
    private String genre;
    private String author;
    private String name;

    public Book(String genre, String author, String name) {
        this.genre = genre;
        this.author = author;
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Жанр: " + genre + "\nАвтор: " + author + "\nНазвание: " + name;
    }
}
