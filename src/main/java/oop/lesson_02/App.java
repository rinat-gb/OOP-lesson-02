/*
 * Урок 2. Принципы ООП Абстракция и интерфейсы. Пример проектирования
 * 
 * Доделать задания, которые не успели на семинаре.
 * Переписать прошлое домашнее задание с использованием принципа инкапсуляции
 *
 * *** Необязательное задание**
 * Написать программу - реализацию книжного шкафа в библиотеке.
 * Должны иметь возможность добавлять \ удалять книги.
 * Узнать кол-во книг
 * При запросе сообщить есть ли такая книга у нас или нет
 * Делаем с принципом инкапсуляции. Используем геттеры, сеттеры, конструкторы
 * 
 * Так как на семинаре я всё успел, а ДЗ для прошлого семинара я и так делал
 * с использованием принципа инкапсуляции, то тут я реализую "необязательное задание",
 * то есть книжный шкаф в библиотеке.
 */
package oop.lesson_02;

public final class App {
    public static void main(String[] args) {
        // создаём книжный шкаф с двумя полками
        Bookshelf bookshelf = new Bookshelf(2);

        // создаём три книги
        Book book1 = new Book("детектив", "Конан Дойл", "Шерлок Холмс");
        Book book2 = new Book("мелодрама", "Маргарет Митчел", "Унесённые ветром");
        Book book3 = new Book("детектив", "Жорж Сименон", "Мегрэ");

        // создаём книжную полку
        Shelf shelf1 = new Shelf();

        // помещаем книги на полку
        shelf1.addBook(book1);
        shelf1.addBook(book2);
        shelf1.addBook(book3);

        // добавляем полку в шкаф, проверяя успешно ли добавилось
        if (!bookshelf.addShelf(shelf1)) {
            System.out.println("Ошибка добавления полки!");
        }

        // создаём ещё две книги
        Book book4 = new Book("приключения", "Александр Дюма", "Три мушкетёра");
        Book book5 = new Book("сказки", "Шарль Перро", "Красная шапочка");

        // создаём книжную полку
        Shelf shelf2 = new Shelf();

        // помещаем книги на полку
        shelf2.addBook(book4);
        shelf2.addBook(book5);

        // добавляем полку в шкаф, проверяя успешно ли добавилось
        if (!bookshelf.addShelf(shelf2)) {
            System.out.println("Ошибка добавления полки!");
        }

        // создаём ещё книгу
        Book book6 = new Book("учебник", "Школа", "Букварь");

        // создаём книжную полку
        Shelf shelf3 = new Shelf();

        // помещаем книгу на полку
        shelf3.addBook(book6);

        // добавляем полку в шкаф, проверяя успешно ли добавилось
        // тут должна быть ошибка добавления потому что мы создали шкаф
        // на две полки, а это получается уже третья
        if (!bookshelf.addShelf(shelf2)) {
            System.out.println("Ошибка добавления полки!");
            System.out.printf("В шкафу всего %d книжные полки!\n\n", bookshelf.getNumOfShelves());
        }

        // говорим сколько полок в шкафу
        System.out.printf("В книжном шкафу %d книжные полки\n", bookshelf.getNumOfShelves());

        // говорим сколько всего книг в шкафу
        System.out.printf("В книжном шкафу всего %d книг\n", bookshelf.getNumOfBooks());

        // показываем содержимое шкафа
        System.out.println("Содержимое шкафа:\n");
        System.out.println(bookshelf);

        // ищем книгу несуществующего автора на первой полке
        String noAuthor = "Несуществующий";
        int noBookIdx = bookshelf.getShelf(0).getBookByAuthor(noAuthor);

        if (noBookIdx != -1) {
            System.out.printf("что-то пошло не так, книги автора \"%s\" не должно быть\n", noAuthor);
        } else {
            System.out.printf("книги автора \"%s\" нет\n", noAuthor);
        }

        // ищем книгу существующего автора на второй полке
        String authorExists = "Шарль Перро";
        int bookIdx = bookshelf.getShelf(1).getBookByAuthor(authorExists);

        if (bookIdx == -1) {
            System.out.println("что-то пошло не так, такая книга автора \"" + authorExists + "\" должна быть!");
        } else {
            System.out.println("Книга автора \"" + authorExists + "\" найдена по индексу " + bookIdx);
        }

        // удаляем найденную книгу
        System.out.println("Удаляем эту книгу");
        bookshelf.getShelf(1).removeBook(bookIdx);

        // опять показываем содержимое шкафа
        System.out.println("Содержимое шкафа:\n");
        System.out.println(bookshelf);
    }
}
