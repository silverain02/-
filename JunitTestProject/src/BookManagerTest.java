import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//Juint Test
public class BookManagerTest {

    private BookManager bookManager;

    @BeforeEach
    public void setUp() {
        bookManager = new BookManager();
    }

    @Test
    public void testAddBook() {
        String result1 = bookManager.addBook("1", "자바기초", "Jane", 2021);
        String result2 = bookManager.addBook("2", "소프트웨어 공학", "Tom", 2014);
        String result3 = bookManager.addBook("3", "분산 컴퓨팅", "Yoon", 2024);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        assertEquals("Book{id:'1', 제목:'자바기초', 저자:'Jane', 출판년도:2021} 도서가 추가되었습니다.", result1);
        assertEquals("Book{id:'2', 제목:'소프트웨어 공학', 저자:'Tom', 출판년도:2014} 도서가 추가되었습니다.", result2);
        assertEquals("Book{id:'3', 제목:'분산 컴퓨팅', 저자:'Yoon', 출판년도:2024} 도서가 추가되었습니다.", result3);
    }

    @Test
    public void testAddExistingBook() {
        bookManager.addBook("1", "자바기초", "Jane", 2021);
        String result = bookManager.addBook("1", "자바기초", "Jane", 2021);
        
        System.out.println(result);
        
        assertEquals("해당 id(1)은 이미 존재합니다.", result);
    }

    @Test
    public void testSearchBook() {
        bookManager.addBook("1", "자바기초", "Jane", 2021);
        bookManager.addBook("2", "소프트웨어 공학", "Tom", 2014);
        bookManager.addBook("3", "분산 컴퓨팅", "Yoon", 2024);

        Book book1 = bookManager.searchBook("1");
        Book book2 = bookManager.searchBook("2");
        Book book3 = bookManager.searchBook("3");

        System.out.println("검색결과 ");
        System.out.println(book1.getId() + book1.getTitle() );
        System.out.println("검색결과 ");
        System.out.println(book2.getId() + book2.getTitle());
        System.out.println("검색결과 ");
        System.out.println(book3.getId() + book3.getTitle())
        ;
        assertNotNull(book1);
        assertEquals("자바기초", book1.getTitle());

        assertNotNull(book2);
        assertEquals("소프트웨어 공학", book2.getTitle());

        assertNotNull(book3);
        assertEquals("분산 컴퓨팅", book3.getTitle());
    }

    @Test
    public void testSearchNonExistingBook() {
        Book book = bookManager.searchBook("4");
        
        System.out.println("검색결과: " );
        System.out.println(book);
        
        assertNull(book);
    }
    
    @Test
    public void testSearchBookBinarySearch() {
        bookManager.addBook("1", "자바기초", "Jane", 2021);
        bookManager.addBook("2", "소프트웨어 공학", "Tom", 2014);
        bookManager.addBook("3", "분산 컴퓨팅", "Yoon", 2024);

        Book book1 = bookManager.search_bs("1");
        Book book2 = bookManager.search_bs("2");
        Book book3 = bookManager.search_bs("3");

        System.out.println("이진 검색 결과");
        System.out.println(book1.getId() + book1.getTitle());
        System.out.println("이진 검색 결과");
        System.out.println(book2.getId() + book2.getTitle());
        System.out.println("이진 검색 결과");
        System.out.println(book3.getId() + book3.getTitle());

        assertNotNull(book1);
        assertEquals("자바기초", book1.getTitle());

        assertNotNull(book2);
        assertEquals("소프트웨어 공학", book2.getTitle());

        assertNotNull(book3);
        assertEquals("분산 컴퓨팅", book3.getTitle());
    }

    @Test
    public void testSearchNonExistingBookBinarySearch() {
        Book book = bookManager.search_bs("4");

        System.out.println("이진 검색 결과: ");
        System.out.println(book);

        assertNull(book);
    }

    @Test
    public void testRemoveBook() {
        bookManager.addBook("1", "자바기초", "Jane", 2021);
        bookManager.addBook("2", "소프트웨어 공학", "Tom", 2014);
        bookManager.addBook("3", "분산 컴퓨팅", "Yoon", 2024);

        String result1 = bookManager.removeBook("1");
        String result2 = bookManager.removeBook("2");
        String result3 = bookManager.removeBook("3");

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        assertEquals("Book{id:'1', 제목:'자바기초', 저자:'Jane', 출판년도:2021} 도서가 제거되었습니다.", result1);
        assertEquals("Book{id:'2', 제목:'소프트웨어 공학', 저자:'Tom', 출판년도:2014} 도서가 제거되었습니다.", result2);
        assertEquals("Book{id:'3', 제목:'분산 컴퓨팅', 저자:'Yoon', 출판년도:2024} 도서가 제거되었습니다.", result3);
    }

    @Test
    public void testRemoveNonExistingBook() {
        String result = bookManager.removeBook("4");
        
        System.out.println(result);
        
        assertEquals("해당 id(4)를 가진 도서가 없습니다.", result);
    }
}
