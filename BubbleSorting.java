import java.util.Random;
import java.util.stream.IntStream;

/**
 * Runs a bubble sort algorithm multiple times on two different kinds of arrays, one of {@link Integer}s and the
 * other of {@link Double}s. This is done to help test and implement our {@link ElapsedTimer} object instances.
 *
 * @author Jon Mrowczynski
 */
public class BubbleSorting {
	
	public static void main(String[] args) {
		final var random = new Random(); // This is created to generate the list of random Numbers.

		/*
			TODO: Implement ElapsedTimer in ElapsedTimer.java! Once you have done that, you can delete this comment.
		 */
		
		// TODO: Create an instance of ElapsedTimer
		System.out.println("Executing 1st for loop:");
		for (int i = 0; i < 100; ++i) {
			// TODO: Start the timer
			final var ints = random.ints(10_000).boxed().toArray(Integer[]::new);
			bubbleSort(ints);
			// TODO: Stop the timer.
		}
		
		// TODO: Print out the average elapsed time it took to create the array of Integers and bubble sort them.
		
		// TODO: Create a 2nd instance of ElapsedTimer.
		System.out.println("Executing 2nd for loop:");
		for (int i = 0; i < 100; ++i) {
			// TODO: Start the timer.
			final var doubles = random.doubles(10_000).boxed().toArray(Double[]::new);
			bubbleSort(doubles);
			// TODO: Stop the timer.
		}
		
		// TODO: Print out the average elapsed time it took to create the array of Doubles and bubble sort them.
	}
	
	/**
	 * Sorts the given array of {@link Number}s using bubble sort. The sorting is done inplace.
	 *
	 * @param vals the array of {@link Number}s that are to be bubble sorted.
	 * @param <T>  the type of {@link Number} stored in the array.
	 */
	private static <T extends Number> void bubbleSort(final T[] vals) {
		final var bound = vals.length - 1;
		IntStream.range(0, bound).forEach(i -> IntStream.range(0, bound - i).forEach(j -> {
			if (vals[j].doubleValue() > vals[j + 1].doubleValue()) {
				final var temp = vals[j];
				vals[j] = vals[j + 1];
				vals[j + 1] = temp;
			}
		}));
	}
}
