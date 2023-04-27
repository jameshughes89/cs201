import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class HeapTest {

    private Heap<Integer> classUnderTest;
    private Heap<Integer> preState;

    private <T> boolean check_equals(Heap<T> heap1, Heap<T> heap2) {
        if (heap1.size() != heap2.size()) {
            return false;
        }
        while (!heap1.isEmpty()) {
            if (!Objects.equals(heap1.remove(), heap2.remove())) {
                return false;
            }
        }
        return true;
    }

    @BeforeEach
    void createClassUnderTest() {
        classUnderTest = new Heap<>((Comparator<Integer>) Comparator.naturalOrder());
        preState = new Heap<>((Comparator<Integer>) Comparator.naturalOrder());
    }

    @Nested
    class WhenEmpty {

        @Test
        void add_empty_returnsTrue() {
            assertThat(classUnderTest.add(99)).isTrue();
        }

        @Test
        void remove_empty_throwsNoSuchElementException() {
            assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(classUnderTest::remove);
        }

        @Test
        void peek_empty_throwsNoSuchElementException() {
            assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(classUnderTest::peek);
        }

        @Test
        void size_empty_returnsZero() {
            assertThat(classUnderTest.size()).isEqualTo(0);
        }

        @Test
        void size_empty_unchanged() {
            classUnderTest.size();
            assertThat(check_equals(classUnderTest, preState)).isTrue();
        }

        @Test
        void isEmpty_empty_returnsTrue() {
            assertThat(classUnderTest.isEmpty()).isTrue();
        }

        @Test
        void isEmpty_empty_unchanged() {
            classUnderTest.isEmpty();
            assertThat(check_equals(classUnderTest, preState)).isTrue();
        }

        @Test
        void toString_empty_returnsString() {
            assertThat(classUnderTest.toString()).isEqualTo("[]");
        }

        @Nested
        class WhenSingleton {

            @BeforeEach
            void addSingleton() {
                classUnderTest.add(10);
                preState.add(10);
            }

            @Test
            void add_singleton_returnsTrue() {
                assertThat(classUnderTest.add(99)).isTrue();
            }

            @Test
            void remove_singleton_returnsElement() {
                assertThat(classUnderTest.remove()).isEqualTo(10);
            }

            @Test
            void remove_singleton_emptyHeap() {
                classUnderTest.remove();
                assertThat(check_equals(classUnderTest,
                        new Heap<>((Comparator<Integer>) Comparator.naturalOrder()))).isTrue();
            }

            @Test
            void peek_singleton_returnsElement() {
                assertThat(classUnderTest.peek()).isEqualTo(10);
            }

            @Test
            void peek_singleton_unchanged() {
                classUnderTest.peek();
                assertThat(check_equals(classUnderTest, preState)).isTrue();
            }

            @Test
            void size_singleton_returnsSize() {
                assertThat(classUnderTest.size()).isEqualTo(1);
            }

            @Test
            void size_singleton_unchanged() {
                classUnderTest.size();
                assertThat(check_equals(classUnderTest, preState)).isTrue();
            }

            @Test
            void isEmpty_singleton_returnsFalse() {
                assertThat(classUnderTest.isEmpty()).isFalse();
            }

            @Test
            void isEmpty_singleton_unchanged() {
                classUnderTest.isEmpty();
                assertThat(check_equals(classUnderTest, preState)).isTrue();
            }

            @Test
            void toString_singleton_returnsString() {
                assertThat(classUnderTest.toString()).isEqualTo("[10]");
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

                @BeforeEach
                void addMany() {
                    classUnderTest.add(20);
                    classUnderTest.add(20);
                    classUnderTest.add(10);
                    classUnderTest.add(5);
                    classUnderTest.add(15);
                    preState.add(20);
                    preState.add(20);
                    preState.add(10);
                    preState.add(5);
                    preState.add(15);
                }

                @Test
                void add_many_returnsTrue() {
                    assertThat(classUnderTest.add(99)).isTrue();
                }

                @Test
                void remove_many_returnsElement() {
                    assertThat(classUnderTest.remove()).isEqualTo(5);
                }

                @Test
                void remove_many_change() {
                    Heap<Integer> expected = new Heap<>((Comparator<Integer>) Comparator.naturalOrder());
                    expected.add(10);
                    expected.add(10);
                    expected.add(15);
                    expected.add(20);
                    expected.add(20);
                    classUnderTest.remove();
                    assertThat(check_equals(classUnderTest, expected)).isTrue();
                }

                @Test
                void peek_many_returnsElement() {
                    assertThat(classUnderTest.peek()).isEqualTo(5);
                }

                @Test
                void peek_many_unchanged() {
                    classUnderTest.peek();
                    assertThat(check_equals(classUnderTest, preState)).isTrue();
                }

                @Test
                void size_many_returnsSize() {
                    assertThat(classUnderTest.size()).isEqualTo(6);
                }

                @Test
                void size_many_unchanged() {
                    classUnderTest.size();
                    assertThat(check_equals(classUnderTest, preState)).isTrue();
                }

                @Test
                void isEmpty_many_returnsFalse() {
                    assertThat(classUnderTest.isEmpty()).isFalse();
                }

                @Test
                void isEmpty_many_unchanged() {
                    classUnderTest.isEmpty();
                    assertThat(check_equals(classUnderTest, preState)).isTrue();
                }

                @Test
                void toString_many_returnsString() {
                    assertThat(classUnderTest.toString()).isEqualTo("[5, 10, 15, 20, 10, 20]");
                }
            }
        }
    }
}