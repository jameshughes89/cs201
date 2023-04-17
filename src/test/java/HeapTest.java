import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class HeapTest {

    private Heap<Integer> classUnderTest;
    private Heap<Integer> preState;

    // TODO --- Tests for non comparable types!?

    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        Heap<Integer> emptyA = new Heap<>();
        Heap<Integer> emptyB = new Heap<>();
        Heap<Integer> emptyComparator = new Heap<>((Comparator<Integer>) Comparator.naturalOrder());

        Heap<Integer> singletonA = new Heap<>();
        Heap<Integer> singletonB = new Heap<>();
        Heap<Integer> singletonComparator = new Heap<>((Comparator<Integer>) Comparator.naturalOrder());
        singletonA.add(10);
        singletonB.add(10);
        singletonComparator.add(10);

        Heap<Integer> manyA = new Heap<>();
        Heap<Integer> manyB = new Heap<>();
        Heap<Integer> manyComparator = new Heap<>((Comparator<Integer>) Comparator.naturalOrder());
        manyA.add(10);
        manyA.add(20);
        manyA.add(10);
        manyA.add(5);
        manyA.add(15);
        manyB.add(10);
        manyB.add(20);
        manyB.add(10);
        manyB.add(5);
        manyB.add(15);
        manyComparator.add(10);
        manyComparator.add(20);
        manyComparator.add(10);
        manyComparator.add(5);
        manyComparator.add(15);

        Heap<Integer> unequalDifferentValues = new Heap<>();
        unequalDifferentValues.add(100);
        unequalDifferentValues.add(200);
        unequalDifferentValues.add(100);
        unequalDifferentValues.add(50);
        unequalDifferentValues.add(150);

        Heap<Integer> unequalDifferentOrder = new Heap<>();
        unequalDifferentOrder.add(5);
        unequalDifferentOrder.add(10);
        unequalDifferentOrder.add(10);
        unequalDifferentOrder.add(15);
        unequalDifferentOrder.add(20);

        Heap<Integer> unequalDifferentSizes = new Heap<>();
        unequalDifferentSizes.add(10);
        unequalDifferentSizes.add(20);
        unequalDifferentSizes.add(10);
        unequalDifferentSizes.add(5);

        Heap<Integer> unequalSomeEqual = new Heap<>();
        unequalSomeEqual.add(10);
        unequalSomeEqual.add(20);
        unequalSomeEqual.add(10);
        unequalSomeEqual.add(5);
        unequalSomeEqual.add(20);

        Heap<Integer> unequalDifferentComparator = new Heap<>((Comparator<Integer>) Comparator.naturalOrder()
                .reversed());
        unequalDifferentComparator.add(10);
        unequalDifferentComparator.add(20);
        unequalDifferentComparator.add(10);
        unequalDifferentComparator.add(5);
        unequalDifferentComparator.add(15);

        new EqualsTester().addEqualityGroup(Heap.class)
                .addEqualityGroup(emptyA, emptyB, emptyComparator)
                .addEqualityGroup(singletonA, singletonB, singletonComparator)
                .addEqualityGroup(manyA, manyB, manyComparator)
                .addEqualityGroup(unequalDifferentValues)
                .addEqualityGroup(unequalDifferentOrder)
                .addEqualityGroup(unequalDifferentSizes)
                .addEqualityGroup(unequalSomeEqual)
                .addEqualityGroup(unequalDifferentComparator)
                .testEquals();
    }

    @BeforeEach
    void createClassUnderTest() {
        classUnderTest = new Heap<>();
        preState = new Heap<>();
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
        void isEmpty_empty_returnsTrue() {
            assertThat(classUnderTest.isEmpty()).isTrue();
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
                assertThat(classUnderTest).isEqualTo(new Heap<>());
            }

            @Test
            void peek_singleton_returnsElement() {
                assertThat(classUnderTest.peek()).isEqualTo(10);
            }

            @Test
            void peek_singleton_unchanged() {
                classUnderTest.peek();
                assertThat(classUnderTest).isEqualTo(preState);
            }

            @Test
            void size_singleton_returnsSzie() {
                assertThat(classUnderTest.size()).isEqualTo(1);
            }

            @Test
            void isEmpty_singleton_returnsFalse() {
                assertThat(classUnderTest.isEmpty()).isFalse();
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


            }
        }
    }
}