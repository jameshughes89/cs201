import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayMinHeapTest {

    private ArrayMinHeap<Integer> classUnderTest;
    private ArrayMinHeap<Integer> preState;

    @BeforeEach
    void createCountryCatalogues() {
        classUnderTest = new ArrayMinHeap<>();
        preState = new ArrayMinHeap<>();
    }

    @Nested
    class WhenEmpty {

        @Test
        void size_empty_returnsZero() {
            assertThat(classUnderTest.size())
                    .isEqualTo(0);
        }

        @Nested
        class WhenSingleton {

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

            }
        }
    }
}
