import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    @Test
    public void searchByBooks() {
        Book book1 = new Book(1, "Первая книга", 5000, "Иван Иванов");
        Book book2 = new Book(2, "Вторая книга", 4500, "Алексей Петров");
        Book book3 = new Book(3, "Third Galaxy", 8000, "Dan Brown");

        Smartphones phone1 = new Smartphones(10, "iPhone 11", 55000, "Apple");
        Smartphones phone2 = new Smartphones(11, "Galaxy 10", 60000, "Samsung");
        Smartphones phone3 = new Smartphones(12, "Xiaomi 10", 45000, "Xiaomi");

        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product[] actual = manager.searchBy("книга");
        Product[] expected = {book1, book2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByProducts() {
        Book book1 = new Book(1, "Первая книга", 5000, "Иван Иванов");
        Book book2 = new Book(2, "Вторая книга", 4500, "Алексей Петров");
        Book book3 = new Book(3, "Third galaxy", 8000, "Dan Brown");

        Smartphones phone1 = new Smartphones(10, "iPhone 11", 55000, "Apple");
        Smartphones phone2 = new Smartphones(11, "Samsung galaxy 10", 60000, "Samsung");
        Smartphones phone3 = new Smartphones(12, "Xiaomi 10", 45000, "Xiaomi");

        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product[] actual = manager.searchBy("galaxy");
        Product[] expected = { book3, phone2 };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNull() {

        Repository repository = new Repository();
        Manager manager = new Manager(repository);

        Product[] actual = manager.searchBy("galaxy");
        Product[] expected = {  };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {

        Repository repository = new Repository();
        Manager manager = new Manager(repository);

        Book book1 = new Book(1, "Первая книга", 5000, "Иван Иванов");
        Book book2 = new Book(2, "Вторая книга", 4500, "Алексей Петров");
        Smartphones phone1 = new Smartphones(10, "iPhone 11", 55000, "Apple");
        Smartphones phone2 = new Smartphones(11, "Samsung galaxy 10", 60000, "Samsung");

        manager.add(book1);
        manager.add(book2);

        manager.add(phone1);
        manager.add(phone2);

        manager.removeByID(1);
        manager.removeByID(11);
        Product[] expected = { book2, phone1 };
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

}