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
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * удаляет книгу с полки
     * 
     * @param book индекс книги которую надо удалить
     */
    public void removeBook(int index) {
        books.remove(index);
    }

    /**
     * возвращает количество книг на полке
     * 
     * @return количество книг
     */
    public int getNumOfBooks() {
        return books.size();
    }

    /**
     * ищет книгу по автору
     * 
     * @param author автор книги
     * @return -1 если не найдено, иначе индекс данной книги
     */
    public int getBookByAuthor(String author) {
        int idx = 0;
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                return idx;
            }
            ++idx;
        }
        return -1;
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
