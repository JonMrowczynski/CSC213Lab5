/**
 * A basic implementation for determining how long pieces of code take to execute. While more advanced techniques
 * should generally be used for more accurate timing, this is fine for our current purposes. Some implementation
 * details are left out of this class for simplicity, some of which are stated below:
 * <p>
 * This implementation assumes that {@link ElapsedTimer#stop()} is always called after a {@link ElapsedTimer#start()}
 * call. It is also assumed that a {@link ElapsedTimer#averageElapsedTime()}, {@link ElapsedTimer#reset()}, and
 * {@link ElapsedTimer#start()} are always called after a {@link ElapsedTimer#stop()} call. This is generally not
 * a safe assumption to make! However, it helps to simplify significantly simplify our implementation.
 *
 * @author Jon Mrowczynski
 */
public class ElapsedTimer {
	
	/**
	 * The number of times the {@link ElapsedTimer} was started and then stopped.
	 */
	// TODO: Declare a variable to keep track of the quantity described in the javadoc above.
	
	/**
	 * The time at which the {@link ElapsedTimer} was started.
	 */
	// TODO: Declare a variable to keep track of the quantity described in the javadoc above.
	
	/**
	 * The total elapsed time between start-stop event pairs.
	 */
	// TODO: Declare a variable to keep track of the quantity described in the javadoc above.
	
	/**
	 * Starts the timer.
	 */
	public void start() {
		// TODO: Implement this method.
	}
	
	/**
	 * Returns the average elapsed time of all paired start-stop events. This should only be called after
	 * {@link ElapsedTimer} has been stopped.
	 *
	 * @return The average elapsed time of all paired start-stop sequences.
	 */
	public double averageElapsedTime() {
		// TODO: Implement this method.
		return 0.0;
	}
	
	/**
	 * Stops the timer.
	 */
	public void stop() {
		// TODO: Implement this method.
	}
	
	/**
	 * Resets the {@link ElapsedTimer} back to its initial state.
	 */
	// TODO: Implement the reset method only once you get to Part 4!
}