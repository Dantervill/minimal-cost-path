import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinCostPathTest {

    @ParameterizedTest
    @MethodSource("costCaseData")
    void findMinCostCase(int[][] actual, int expected) {
        assertEquals(expected, MinCostPath.findMinCost(actual));
    }

    static Collection<Object[]> costCaseData() {
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

        return List.of(
                new Object[]{human, 10},
                new Object[]{swamper, 15},
                new Object[]{woodman, 12}
                );
    }
}
