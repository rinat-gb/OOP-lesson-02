package oop.lesson_02;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Bookshelf для книжного шкафа
 */
public class Bookshelf {
    private int maxNumOfShelves;
    private List<Shelf> shelves;

    /**
     * конструктор
     * 
     * @param maxNumOfShelves максимальное количество полок в шкафу
     */
    public Bookshelf(int maxNumOfShelves) {
        this.maxNumOfShelves = maxNumOfShelves;
        this.shelves = new ArrayList<>();
    }

    /**
     * Возвращает количество полок в шкафу
     * 
     * @return int количество полок
     */
    public int getNumOfShelves() {
        return shelves.size();
    }

    /**
     * Возвращает полку по индексу
     * 
     * @param index индекс номера полки (начинается от 0)
     * @return полка
     */
    public Shelf getShelf(int index){
        return shelves.get(index);
    }

    /**
     * Добавляет полку в шкаф
     * 
     * @param shelf полка
     * @return false если добвление НЕ успешно, иначе true
     */
    public boolean addShelf(Shelf shelf) {
        if (shelves.size() == maxNumOfShelves) {
            return false;
        }
        shelves.add(shelf);
        return true;
    }

    /**
     * возвращает количество книг в шкафу на всех полках
     * 
     * @return количество книг
     */
    public int getNumOfBooks() {
        int num = 0;

        for (Shelf shelf : shelves) {
            num += shelf.getNumOfBooks();
        }
        return num;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < shelves.size(); i++) {
            stringBuilder.append(String.format("На полке номер %d расположены книги:\n\n", i + 1));
            stringBuilder.append(shelves.get(i).toString());
        }
        return stringBuilder.toString();
    }
}
