import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the {@link ElapsedTimer} class.
 * <p>
 * It is important to remember that even if ALL tests pass, that does not necessarily guarantee the correct operation
 * of the tested code. Rather, assuming the tests are written well, it just ensures the correct functionality of what
 * is being tested.
 *
 * @author Jon Mrowczynski
 */
class ElapsedTimerTest {
	
	/**
	 * The {@link ElapsedTimer} that is used in the tests.
	 */
	private ElapsedTimer timer;
	
	/**
	 * Pauses the operations of the current thread by about 1s. This helped function is used to allow some time to
	 * pass to help test the {@link ElapsedTimer}.
	 */
	private static void sleep1s() {
		try { Thread.sleep(1000); }
		catch (final InterruptedException e) { throw new AssertionError(e); }
	}
	
	/**
	 * Since a 1s delay is frequently used in the testing methods, this helper method makes sure that the average
	 * elapsed time is between 1s and 1.1s. At least 1s is going to pass from the 1s delay, but there is a bit of
	 * overhead that would make it slightly longer than 1s. That overhead shouldn't take more than 1/10th of a second
	 * though.
	 */
	void testTimeRange() {
		final var time = timer.averageElapsedTime();
		final var secondsDelay = 1;
		assertTrue(time > secondsDelay);
		assertTrue(time < secondsDelay + 0.1);
	}
	
	/**
	 * Creates a new {@link ElapsedTimer} for every test to make sure that no test influences the state of the timer
	 * that we are testing. Basically, we always want to start with a brand new testing object.
	 */
	@BeforeEach void setup() { timer = new ElapsedTimer(); }
	
	/**
	 * Performs some basic tests on the {@link ElapsedTimer} ensuring that it can function when used correctly.
	 */
	@Nested class BasicTimerTests {
		
		/**
		 * Tests that a reasonable average elapsed time is returned when a start and stop is performed roughly 1s
		 * apart.
		 */
		@Test void testNormalOperation() {
			timer.start();
			sleep1s();
			timer.stop();
			testTimeRange();
		}
		
		/**
		 * Tests that performing multiple starts in a row doesn't exhibit any sufficiently different behavior than
		 * normal operation.
		 */
		@Test void testMultipleStarts() {
			timer.start();
			timer.start();
			sleep1s();
			timer.stop();
			testTimeRange();
		}
		
		/**
		 * Tests that multiple start and stops return a reasonable response.
		 */
		@Test void testMultipleStartStops() {
			timer.start();
			sleep1s();
			timer.stop();
			timer.start();
			sleep1s();
			timer.stop();
			testTimeRange();
		}
		
		/**
		 * Tests that stopping the timer multiple times doesn't affect the end average elapsed time.
		 */
		@Test void testMultipleStops() {
			timer.start();
			sleep1s();
			timer.stop();
			timer.stop();
			testTimeRange();
		}
		
		/**
		 * Tests that the reset correctly resets the timer.
		 */
		@Test void testReset() {
			timer.start();
			sleep1s();
			timer.stop();
			testTimeRange();
			timer.reset();
			timer.start();
			sleep1s();
			timer.stop();
			testTimeRange();
		}
	}
	
	/**
	 * Performs more advanced tests on {@link ElapsedTimer} ensuring it can function more robustly. This is more like
	 * what you would want to write (in addition to the above tests) to test actual production code.
	 */
	@Nested class AdvancedTimerTests {
		
		/**
		 * A helper method that
		 */
		private void testInitialState() {
			assertEquals(0, timer.averageElapsedTime());
		}
		
		/**
		 * Tests that 0s is returned as the average elapsed time before the timer has even been started.
		 */
		@Test void testWithoutStarting() { testInitialState(); }
		
		/**
		 * Tests that reset sets the timer back to its initial state.
		 */
		@Test void testReset() {
			timer.start();
			sleep1s();
			timer.stop();
			testTimeRange();
			timer.reset();
			testInitialState();
		}
		
		/**
		 * Tests that starting the timer multiple times after it has been running for a while doesn't affect the end
		 * average elapsed time.
		 */
		@Test void testMultipleStarts() {
			timer.start();
			sleep1s();
			timer.start();
			timer.stop();
			testTimeRange();
		}
		
		/**
		 * Tests that the timer still returns 0s when {@link ElapsedTimer#stop()} is called without the timer having
		 * been started.
		 */
		@Test void testStopWithoutStarting() {
			timer.stop();
			testInitialState();
		}
	}
}