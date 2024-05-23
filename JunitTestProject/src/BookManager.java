import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books = new ArrayList<>();

    public String addBook(String id, String title, String author, int year) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
                return "해당 id(" + id + ")은 이미 존재합니다.";
            }
        }
        Book newBook = new Book(id, title, author, year);
        books.add(newBook);
        return "Book{id:'" + newBook.getId() + "', 제목:'" + newBook.getTitle() + "', 저자:'" + newBook.getAuthor() + "', 출판년도:" + newBook.getYear() + "} 도서가 추가되었습니다.";
    }

    public Book searchBook(String id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
                return books.get(i);
            }
        }
        return null; // 검색 결과가 없는 경우 null 반환
    }

    public String removeBook(String id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
                Book removedBook = books.remove(i);
                return "Book{id:'" + removedBook.getId() + "', 제목:'" + removedBook.getTitle() + "', 저자:'" + removedBook.getAuthor() + "', 출판년도:" + removedBook.getYear() + "} 도서가 제거되었습니다.";
            }
        }
        return "해당 id(" + id + ")를 가진 도서가 없습니다.";
    }
}