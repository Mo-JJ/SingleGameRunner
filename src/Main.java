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

        // for consistency, before running testing methods, comment out the above code
        // and try calling the desired method (just for the fresh start).
    }
    // test the singleton behavior.
    private static void testIsSingleton(){
        System.out.println("---Testing the Singleton design---");
        System.out.println(GameRunner.getInstance().equals(runner)); // true
        System.out.println(GameRunner.getInstance().equals(GameRunner.getInstance())); // true
        System.out.println("---Finished testing the Singleton design---");
    }
    // test normal flow: set, run, pause, resume, close
    private static void testNormalFlow(Game game){
        System.out.println("---Testing the normal flow---");
        runner.run(game);
        runner.pause();
        runner.resume();
        runner.close();
        System.out.println("---Finished testing the normal flow---");
   }
    // test trying to launch multiple games
    private static void testLaunchingMultipleGames(){
        System.out.println("---Testing launching multiple games---");
        runner.run(mario);
        runner.run(callOfDuty);
        runner.close();
        System.out.println("---Finished launching multiple games---");
    }
    // test trying to launch faulty games.
    private static void testLaunchingFaultyGames(){
        System.out.println("---Testing the launching faulty games---");
        runner.run(null);
        System.out.println("---Finished testing the launching faulty games---");
    }
    // test when no game is running: pause, resume, close
    private static void testWhenNoGameIsRunning(){
        System.out.println("---Testing when no game is running---");
        runner.pause();
        runner.resume();
        runner.close();
        System.out.println("---Finished when no game is running---");
    }
    // test pausing while paused, as well as resuming while already running:
    // pause, pause, resume, resume
    private static void testModifyingModes(){
        System.out.println("---Testing modifying the modes---");
        runner.run(callOfDuty);
        runner.pause();
        runner.pause();
        runner.resume();
        runner.resume();
        runner.close();
        System.out.println("---Finished modifying the modes---");
    }

}