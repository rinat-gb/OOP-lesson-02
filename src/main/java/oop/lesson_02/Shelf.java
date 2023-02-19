package oop.lesson_02;

import java.util.ArrayList;
import java.util.List;

/*
 * Класс Shelf для книжной полки
 * 
 * Просто содержит в себе книги
 */
public class Shelf {
    List<Book> books;

    public Shelf() {
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    /**
     * добавляет книгу на полку
     * 
     * @param book новая книга
     */
    public void addBook(Book book){
        books.add(book);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Book book : books) {
            stringBuilder.append(book.toString());
            stringBuilder.append("\n\n");
        }
        return stringBuilder.toString();
    }
}
