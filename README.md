# Lab 5 - Implementing Your First Object

**Author**: Justin Del Vecchio

**Edited by**: Jon Mrowczynski

**Objectives**:

- Implement your first Java object.
- Learn how to use objects to maintain state by using instance variables.
- Learn how to clear the state of an object by resetting instance variables back to their initial state.
- Learn how to compile multiple Java files with a single command.

**Description**: There are many ways to introduce object-oriented programming (OOP).
This lab uses the concept of an object with state.
'State' means that the object has a set of properties or attributes that describe its current condition or status.
The state of an object can change over time based on the actions performed on the object or the events that occur around
it.

There are two files you will use:

1. `ElapsedTimer.java` - A `class` that will be used to instantiate stateful objects where you will fill in the details.
2. `BubbleSorting.java` - A `class` that uses an `ElapsedTimer` object.

## Part 1: Review `BubbleSorting.java`

This simple class already contains a bubble sort implementation for you. It is implemented with Java's
[Stream](https://www.bing.com/search?q=java+21+Stream&cvid=f06d46ba989e4d8a900d64c0a66e24f8&gs_lcrp=EgRlZGdlKgYIABBFGDkyBggAEEUYOTIGCAEQABhAMgYIAhAAGEAyBggDEAAYQDIGCAQQABhAMgYIBRAAGEAyBggGEAAYQDIGCAcQABhAMgYICBAAGEDSAQgyMTM2ajBqNKgCCLACAQ&FORM=ANAB01&PC=U531)
API - Java's implementation of a functional/declarative programming paradigm.
All `Stream` functionalities can be done using other methods we already know, albeit in a more verbose and cumbersome
manner.
While you won't need to modify this function in any way, can you understand how the `bubbleSort` function works with
these `Stream`s?

You will focus on the `main` method, which is at the top of the file.
This method runs each of the 2 `for` loops 100 times.
The 1st `for` loop creates a random array of 10,000 `Integer`s, while the 2nd `for` loop creates a random array of
10,000 `Double`s. Both also use Java's Stream API to do so quite succinctly.
Can you understand what each `Stream` method call does?

Notice that we are using `Integer` and `Double` instead of `int` and `double`.

### Q1: What kind of classes are `Integer` and `Double`?

[Answer here]

Additionally, both loops already call the `bubbleSort` function to sort these arrays.

The comments in the `main` method **identify your tasks**! You will need to create code where you see the comments.

## Part 2: Review `ElapsedTimer`

The comments should also instruct you on what needs to be implemented.

Note that `ElapsedTimer` maintains:

- The total number of times start/stop has been run since the `ElapsedTimer` instance was created.
- The total amount of elapsed time in between **all** the start/stop events.

Lastly. `ElapsedTimer` should be able to find the average time for a start/stop event.

## Part 3: Implement the code for `BubbleSorting.java` and `ElapsedTimer.java`

Note, do not implement the `reset()` method in `ElapsedTimer` yet! 
Get it working non-optimally first! Here are some tips:

1. To compile all `.java` files in the current directory, you can enter the command:

```
javac *.java
```

2. Build incrementally! Meaning:
    1. Add code a few lines at a time until you reach a mini-milestone. For example - "I think I defined the instance
       variables
       I want."
    2. Compile at that point! You may have introduced *compilation errors* and it's best to catch those sooner rather
       than
       later! A common error new programmers make is generating a bunch of code, get multiple *compilation errors* when
       they
       *compile*, and are then overwhelmed by the volume of errors.
3. Test incrementally. Make sure to *run* your class incrementally as well. You may have introduced *runtime errors*.

On the instructor's 6-year-old mid-grade laptop, the average elapsed time for the first for loop was roughly 0.22s.

## Part 4: Implement the `reset()` method.

This method should, literally, reset the instance variables in `ElapsedTimer` to their initial state. You should:

1. Create `reset()` in `ElapsedTimer`.
2. Remove the code that creates the second `ElapsedTimer` between the `for` loops.
3. Replace the removed code with a call to `reset()`.
4. Make sure there is only one instance of `ElapsedTimer` used in the `main` method.
5. Run `BubbleSorting` and ensure that you get the similar results.
    - The times might vary a bit among the runs since the values in the arrays are random and the amount of time bubble
      sorting takes to run is dependent on how many swaps are required.

## Part 5: Submit to D2L

Submit to the corresponding D2L dropbox your:
1. `ElapsedTimer.java`
2. `BubbleSorting.java`
