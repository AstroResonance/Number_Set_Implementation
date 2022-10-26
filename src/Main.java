import java.util.Arrays;

public final class Main {

    public static void main(String[] args) {

        final ArrayNumSet<Double> numSet = new ArrayNumSet<>(2);

        double[] values = {1, 3, 5, 6, 9, 18, 12};
        double[] valuesToRemove = {5, 9, 12};
        Number[] expectedValues = {1.0, 3.0, 6.0, 18.0, null, null, null, null};

        for (double value : values) {
			numSet.add(value);
		}

        for (double value : valuesToRemove) {
			numSet.remove(value);
		}

        if (!Arrays.equals(expectedValues, numSet.getArr())) {
            System.out.println("Expected: " + Arrays.toString(expectedValues));
            System.out.println("Actual: " + Arrays.toString(numSet.getArr()));
            throw new AssertionError();
        }

        System.out.println(numSet.contains(19.0));

        System.out.print("OK");
    }
}
