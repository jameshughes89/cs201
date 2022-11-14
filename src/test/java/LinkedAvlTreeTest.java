import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

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
        void size_empty_returnsZero() {
            assertThat(classUnderTest.size())
                    .isEqualTo(0);
        }

        void isEmpty_empty_returnsTrue() {
            assertThat(classUnderTest.isEmpty())
                    .isTrue();
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
