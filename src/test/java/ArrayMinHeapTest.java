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

        @Test
        void isEmpty_empty_returnsTrue() {
            assertThat(classUnderTest.isEmpty())
                    .isTrue();
        }

        @Nested
        class WhenSingleton {

            @BeforeEach
            void addSingleInteger() {
                classUnderTest.add(10);
                preState.add(10);
            }

            @Test
            void size_singleton_returnsOne() {
                assertThat(classUnderTest.size())
                        .isEqualTo(1);
            }

            @Test
            void isEmpty_singleton_returnsFalse() {
                assertThat(classUnderTest.isEmpty())
                        .isFalse();
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

                @BeforeEach
                void addSingleInteger() {
                    classUnderTest.add(9);
                    classUnderTest.add(15);
                    classUnderTest.add(5);
                    classUnderTest.add(11);
                    preState.add(9);
                    preState.add(15);
                    preState.add(5);
                    preState.add(11);
                }

                @Test
                void size_many_returnsCorrectSize() {
                    assertThat(classUnderTest.size())
                            .isEqualTo(5);
                }

                @Test
                void isEmpty_many_returnsFalse() {
                    assertThat(classUnderTest.isEmpty())
                            .isFalse();
                }
            }
        }
    }
}
