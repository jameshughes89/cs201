import org.junit.jupiter.api.*;
import org.junit.runner.notification.RunListener;

import static org.assertj.core.api.Assertions.*;

public class LinkedAvlTreeTest {

    private LinkedAvlTree classUnderTest;
    private LinkedAvlTree preState;

    @BeforeEach
    void createCountryCatalogues() {
        classUnderTest = new LinkedAvlTree();
        preState = new LinkedAvlTree();
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
