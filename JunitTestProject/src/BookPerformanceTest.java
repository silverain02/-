import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class BookPerformanceTest {

    private BookManager bookManager;

    @BeforeEach
    public void setUp() {
        // BookManager 인스턴스 생성 및 초기화
        bookManager = new BookManager();

        // 10000개의 책 데이터 추가
        for (int i = 0; i < 10000; i++) {
            String id = Integer.toString(i);
            String title = "제목" + i;
            String author = "저자" + i;
            int year = 2000 + (i % 25); // 출판년도는 2000년 ~ 2024년 사이로 임의 설정
            bookManager.addBook(id, title, author, year);
        }
    }


    @Test
    public void testSearchBookPerformance() {
        long startTime = System.nanoTime();

        // 1000번의 무작위 검색 수행
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            String randomId = Integer.toString(random.nextInt(10000));
            assertNotNull(bookManager.searchBook(randomId));
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  // 나노초를 밀리초로 변환
        System.out.println("searchBook() 성능 테스트: " + duration + "ms");
    }

    @Test
    public void testSearch_bsPerformance() {
        long startTime = System.nanoTime();

        // 1000번의 무작위 검색 수행
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            String randomId = Integer.toString(random.nextInt(10000));
            assertNotNull(bookManager.search_bs(randomId));
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  // 나노초를 밀리초로 변환
        System.out.println("search_bs() 성능 테스트: " + duration + "ms");
    }
}