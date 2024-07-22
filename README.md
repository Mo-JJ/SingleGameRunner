# SingletonTask (Java)

This Java application helps manage a gaming console runner, allowing consoles to have only one runner component that manages single-game at a time functionality.
## Motivation

If you've ever played with gaming consoles like PlayStation or Xbox, you'll notice that they only allow one game to run at a time. To mirror this single-game constraint, the `GameRunner` class was designed using the Singleton design pattern, ensuring only one game can be managed and run at any given moment. This approach prevents the complexity and difficulty of managing multiple game runners simultaneously, aligning with the design of real-life gaming consoles that also have only one game runner. For a better understanding of the benefit of this design, take a look at `flow_charts.pdf` file

## Key Features for Users

-  Create your favorite games.
- **Run Games**: Start a new game and manage its execution.
- **Pause and Resume Games**: Pause the current game and resume it when needed.
- **Switch Games**: If a new game is started while another game is running, the user is prompted to either continue the current game or close it and start the new one.
- **Close Games**: Properly close the current game when done.

### GameRunner Class

The `GameRunner` class is designed as a Singleton to manage the execution of games. It contains methods to run, pause, resume, and close games. Here are the key components of the `GameRunner` class:

- **Game Control Methods**
    - `public void run(Game game)`: Runs the given game. If a game is already running, it asks the user whether to continue the current game or close it and start a new one.
    - `public void pause()`: Pauses the current game.
    - `public void resume()`: Resumes the current game.
    - `public void close()`: Closes the current game.

## Helping users getting started
### Adding Testing methods
Testing methods were created to allow users see how different actions are handled in different states.
_**Feel free to run each of these methods, one at a time if you want a fresh start.**_
### Adding Code Sample
Here is an example of how to use the `GameRunner` and `Game` classes:

```java
public class Main {
    private static final GameRunner runner = GameRunner.getInstance();
    private static final Game mario = new Game("Mario");
    private static final Game callOfDuty = new Game("Call of duty black ops");
    public static void main(String[] args) {
        runner.run(callOfDuty);
        runner.pause();
        runner.resume();
        runner.close();
        runner.run(mario);
    }
}
