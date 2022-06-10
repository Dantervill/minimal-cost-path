import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrganiserTest {

    @ParameterizedTest
    @MethodSource("paths")
    void getGridCase(int[][] expected, String filePath) {
        assertArrayEquals(expected, new Organiser().getGrid(filePath));
    }

    static Collection<Object[]> paths() {
        int[][] human = {
                {5,3,2,5},
                {2,3,1,1},
                {3,1,3,3},
                {1,2,1,1}
        };
        int[][] swamper = {
                {2,5,2,2},
                {2,5,2,2},
                {5,2,5,5},
                {2,2,2,2}
        };
        int[][] woodman = {
                {3,2,3,3},
                {3,2,2,2},
                {2,2,2,2},
                {2,3,2,2}
        };
        String humanPath = "C:\\Users\\Vlas\\Desktop\\Shortway\\src\\test\\resources\\test_1.txt";
        String swamperPath = "C:\\Users\\Vlas\\Desktop\\Shortway\\src\\test\\resources\\test_2.txt";
        String woodmanPath = "C:\\Users\\Vlas\\Desktop\\Shortway\\src\\test\\resources\\test_3.txt";
        return List.of(
                new Object[]{human, humanPath},
                new Object[]{swamper, swamperPath},
                new Object[]{woodman, woodmanPath}
        );
    }
}
