import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

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

        @Test
        void add_empty_returnsTrue() {
            assertThat(classUnderTest.add(10))
                    .isTrue();
        }

        @Test
        void peek_empty_throwsException() {
            assertThatExceptionOfType(NoSuchElementException.class)
                    .isThrownBy(classUnderTest::peek);
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

            @Test
            void add_singleton_returnsTrue() {
                assertThat(classUnderTest.add(10))
                        .isTrue();
            }

            @Test
            void peek_singleton_returnsMinimumElement() {
                assertThat(classUnderTest.peek())
                        .isEqualTo(10);
            }

            @Test
            void peek_singleton_unalteredHeap() {
                classUnderTest.peek();
                assertThat(classUnderTest)
                        .usingRecursiveComparison()
                        .isEqualTo(preState);
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

                @BeforeEach
                void addSingleInteger() {
                    classUnderTest.add(9);
                    classUnderTest.add(15);
                    classUnderTest.add(5);
                    classUnderTest.add(10);
                    preState.add(9);
                    preState.add(15);
                    preState.add(5);
                    preState.add(10);
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

                @Test
                void add_many_returnsTrue() {
                    assertThat(classUnderTest.add(10))
                            .isTrue();
                }

                @Test
                void peek_many_returnsMinimumElement() {
                    assertThat(classUnderTest.peek())
                            .isEqualTo(5);
                }

                @Test
                void peek_many_unalteredHeap() {
                    classUnderTest.peek();
                    assertThat(classUnderTest)
                            .usingRecursiveComparison()
                            .isEqualTo(preState);
                }
            }
        }
    }

    @Nested
    class WhenLarge {

        @Test
        void enqueue_large_successfullyExpandsCapacity() {
            for (int i = 0; i < 1000; i++) {
                classUnderTest.add(i);
            }
            assertThat(classUnderTest.size())
                    .isEqualTo(1000);
        }
    }
}
