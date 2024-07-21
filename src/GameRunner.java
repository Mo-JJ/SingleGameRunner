import java.util.Scanner;

public class GameRunner {
    private static GameRunner instance;
    private Game game;
    private boolean isPaused;
    private final static String ERROR_MESSAGE = "No games are currently running.";
    private final static String START_MESSAGE = "The runner is free and ready to run any game";

    private GameRunner(){
        System.out.println(START_MESSAGE);
    }
    public static GameRunner getInstance(){
        if (instance==null)
            instance = new GameRunner();
        return instance;
    }
    private void setGame(Game game) {
        this.game = game;
        setPaused(true);
        if (game!=null)
            launch(game);
    }
    private void setPaused(boolean paused) {
        isPaused = paused;
    }
    private void launch(Game game) {
        System.out.println("Launching "+game+"...");
        resume();
    }

    public void run(Game game){
        if (this.game!=null && game==null) {
            System.out.println("The game you tried to run is damaged or have missing information.");
            System.out.println(game+" continues to run without interruption.");
            return;
        }

        if (this.game==null)
            setGame(game);
        else if (this.game.equals(game))
            resume();
        else{
            pause();
            System.out.println("Warning, you're currently playing " + this.game + ", do you want to keep playing it?");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter 'yes' to keep playing and 'no' to close it and launch the new game:");
                String decision = scanner.nextLine();
                if (decision.equalsIgnoreCase("yes") || decision.equalsIgnoreCase("y")){
                    System.out.println("Game resumed.");
                    resume();
                    break;
                }else if (decision.equalsIgnoreCase("no") || decision.equalsIgnoreCase("n")){
                    close();
                    setGame(game);
                    break;
                }else
                    System.out.println("Invalid input: "+ decision +", Please only provide yes/no answer.");
            }
        }
    }
    public void pause(){
        if (game==null) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        if (isPaused)
            System.out.println(game+" is already in pause mode.");
        else {
            setPaused(true);
            System.out.println(game+" got paused.");
        }
    }
    public void resume(){
        if (game==null) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        if (!isPaused)
            System.out.println(game+" is already in running mode.");
        else {
            setPaused(false);
            System.out.println(game+" is running.");
        }
    }
    public void close(){
        if (game==null) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        if (!isPaused)
            pause();
        System.out.println("Closing "+game+"...");
        System.out.println(game + " got closed.");
        System.out.println(START_MESSAGE);
        setGame(null);
    }

}
