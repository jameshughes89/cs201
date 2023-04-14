import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class HeapTest {

    private Heap<Integer> classUnderTest;
    private Heap<Integer> preState;

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


    }
}