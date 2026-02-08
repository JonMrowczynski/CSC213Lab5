# Lab 4 - Intellij + Gradle 4evr <3

**Author**: Jon Mrowczynski

## Part 1a: Setting up a Local Intellij Project

1. Open Intellij and create a New Project by going to *File -> New -> Project*.
2. Name the project *Lab4* and select a JDK version of 21.
    - Intellij should be able to autodetect the locally installed JDK 21 on the system. This is fine to select.
3. Leave the *Build system:* selected as *Intellij*.
    - **Later** we will use Gradle! A very powerful project management/build system that makes handling larger, more complex
      projects a comparative breeze.
4. Ensure *Add sample code* is unchecked and then click *Create*.
5. Add the below code into a Java source file in the *src* directory and give it an appropriate name.
    - You can add a new source file to the project by right-clicking on the *src* directory and going to *New -> Java Class*.
    - **Notice that the src directory is colored blue**!
```java
import java.io.File;
import java.io.FileFilter;

/**
 * Lists all the subdirectories contained in the same directory as this Java source file.
 *
 * @author Jon Mrowczynski
 */
public class SubDirLister {
	
	public static void main(String[] args) {
		// Create a new File object that points to the directory that contains this Java source file.
		final var file = new File(".");
		// Get an array of all the found Files in this directory that are also directories.
		final var dirs = file.listFiles(new FileFilter() {
			@Override public boolean accept(final File file) { return file.isDirectory(); }
		});
		if (dirs == null) { return; } // Include a null guard just in case. This should never fire if used properly.
		// List all the found subdirectories.
		System.out.println("The subdirectories found include: ");
		for (final var dir : dirs) { System.out.println(dir); }
	}
}
```
6. Add the below code into a **different** Java source file in the *src* directory just like above and make sure to also give it an
   appropriate name!
```java
/**
 * Represents a simple point in 2D space. The main method is really only here to demo the functionality of this class
 * upon the modifications made and normally wouldn't be included.
 *
 * @author Jon Mrowczynski
 */
public class Point2D {
	
	private final int x;
	
	private final int y;
	
	public Point2D(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	
	public static void main(String[] args) {
		// Create a Point2D and print it.
		final var p1 = new Point2D(3, 4);
		// TODO: Hm, the below line of code prints the reference of Point2D p1...can you change the toString method
		//  so that Point2Ds are printed as (x, y) instead?
		System.out.println("I am a 2D point at: " + p1);
		System.out.println("I am another 2D point at: " + new Point2D(10, 11) + "\n");
		
		// Create another Point2D and make comparisons to this .
		final var p2 = new Point2D(3, 4);
		System.out.println("p1 == p2 ? --> " + (p1 == p2));
		System.out.println("p1.equals(p2) ? --> " + p1.equals(p2));
	}
	
	public final int getX() { return x; }
	
	public final int getY() { return y; }
	
	@Override public final boolean equals(final Object obj) {
		return (obj instanceof Point2D p) && (p.x == x) && (p.y == y);
	}
	
	/**
	 * Creates a {@link String} representation for a {@link Point2D} in the form (x, y).
	 *
	 * @return a {@link String} representing this {@link Point2D}.
	 */
	@Override public String toString() { return super.toString(); }
}
```

## Part 1b: Intro to Intellij's Built-in Tools

We could have an entire course dedicated to learning Intellij! We will only go
over an **extremely** small number of its more commonly used features. We'll cover more throughout the semester and I'm sure you'll pick
up more on your own.

Open/View the `SubDirLister` class and click on the *Run* button next to *Current File*. This runs the currently selected/viewed
Java source file. **Notice this program was compiled and run without explicitly invoking `javac` or `java`!**

- Notice that you can do the same thing by clicking the *Run* button on the same line as `main`.

### Q1: When the program is run, what is printed below `The subdirectories found include:`? Copy and paste your answer below.

```
[Answer Here]
```

Notice how `new FileFilter()` is faded compared to the rest of the code. Click somewhere within the text `new FileFilter()` and press
`Alt+Enter` or `Cmd+Enter`. You can use this keyboard shortcut anywhere in Intellij's editor to get Intellij's suggested edits, which are
next to the yellow lightbulb icon. Select the *Replace with lambda* option. 

### Q2: What is the new code that was generated?

```java
[Answer Here]
```

### Q3: Does the output of the program differ if it is run again with these changes? If so, how?

[Answer Here]

Notice how `import java.io.FileFilter` is now similarly formatted to how `new FileFilter()` was before removed by
Intellij.

Click anywhere in Intellij's text editor for this file and press `Ctrl+Alt+Shift+L` or `Ctrl+Cmd+Shift+L`. This should bring up a *Reformat File* window. You can see what code it will automatically reformat in the *Scope* section and what kinds of reformatting will be
   performed in the *Options* section. These defaults are usually fine. Click *Run* to run these reformattings.
   
Among other things, this *Optimizes Imports* which removes any and all unused imports.

There should be a yellow squiggle under the new text that Intellij generated. This is another way for Intellij to tell you it
has suggested edits for improving your code. Click on any of the text that is underlined with this yellow squiggle, press
`Alt+Enter` or `Cmd+Enter`, and now select *Replace lambda with a method reference*.

### Q4: What is a lambda?

[Answer here]

### Q5: What is a method reference?

[Answer here]

### Q6: What is the new code that was generated?
```java
[Answer Here]
```

### Q7: Does the output of the program differ if it is run again with these changes? If so, how?

[Answer Here]

## Part 1c: Converting a `class` to a `record`.

Now open/view the `Point2D` class, run it, and examine the output. Notice that the first few lines of output print the `Point2D`
**reference** rather than a nicely formatted `String` representing the 2D point.

1. Change its `toString()` method as indicated by the TODO in the file. 
	- **Hint**: Make sure to use the instance variables directly
   rather than calling the getter functions.
2. Ensure you correctly formatted the `String` representation of a `Point2D` by running the file.
3. Once you get this working, delete the `TODO` comment.

There should now be a faded yellow squiggle under `Point2D`. Click somewhere on `Point2D`, press `Alt+Enter` or `Cmd+Enter`, and select
*Convert to record class*.

### Q8: Does the output of the program differ if it is run again with these changes? If so, how?

[Answer Here]

### Q9: Why does `p1 == p2` return `false` while `p1.equals(p2)` return `true`?

[Answer Here]

### Task 1: Admire the simplicity of the `Point2D` `record` vs. the original equivalently functional `Point2D` `class`.

## Part 2: Intellij + Gradle!

You can clone repos from the terminal...or you could just use Intellij to clone it for you! You can access the *Clone
Repository* window through two different ways:

- If you don't have a project currently open, click *Clone Repository*.
- If you have a project currently open, go to `*Main Menu* -> *New* -> *Project from Version Control...*.

Now copy and past the HTTPS URL of the repo you want to clone into the *URL* field. Here, we will clone:
https://github.com/JonMrowczynski/CSC213SimpleGradleProject.git

Ensure that you are cloning the repo into a desirable directory location and then click *Clone*. This not only clones the
repository...

However, if the repo included files from a build system that's recognized by Intellij, it will automatically setup the project
for you! This should be the case for this repo.

Follow the README in this repository before continuing to the last Part.

## Part 3: Submit Work to the corresponding D2L Dropbox

Submit to D2L:
- For Part 1 your:
   1. SubDirLister.java
   2. Point2D.java
   3. Filled out README.md
- For Part 2 your:
   1. Range.java
   2. RangeTest.java
   3. Filled out README.md
