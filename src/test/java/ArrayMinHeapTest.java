import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class ArrayMinHeapTest {

    private ArrayMinHeap classUnderTest;
    private ArrayMinHeap preState;

    @BeforeEach
    void createCountryCatalogues() {
        classUnderTest = new ArrayMinHeap();
        preState = new ArrayMinHeap();
    }

    @Nested
    class WhenEmpty {

        @Test
        void size_empty_returnsZero(){
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
