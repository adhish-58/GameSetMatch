package softeng.myapp;

public class player implements java.io.Serializable{
    String name;
    int ace, firstServe, secondServe, doubleFault;
    int winFirstServe, winSecondServe;
    int winner, forcedError, unforcedError;
    int set;
    boolean isSecondServe, isServing;
    String game;

    public player() {
        name = "";
        ace = 0;
        firstServe = 0;
        secondServe = 0;
        doubleFault = 0;
        winFirstServe = 0;
        winSecondServe = 0;
        winner = 0;
        forcedError = 0;
        unforcedError = 0;
        set = 0;
        isSecondServe = false;
        isServing = false;
        game = "0";
    }

    public void setName(String playerName) {
        name = playerName;
    }

    public void setAce( ) {
        ace += 1;
        setWinner( );
    }

    public void setFirstServe( ) {
        firstServe += 1;
    }

    public void setSecondServe( ) {
        isSecondServe = true;
        secondServe += 1;
    }

    public void setDoubleFault( ) {
        doubleFault += 1;
        setUnforcedError( );
    }

    public void setWinFirstServe( ) {
        winFirstServe += 1;
    }

    public void setWinSecondServe( ) {
        winSecondServe += 1;
    }

    public void setWinner( ) {
        winner += 1;
    }

    public void setForcedError( ) {
        forcedError += 1;
    }

    public void setUnforcedError( ) {
        unforcedError += 1;
    }

    public void setGame(String score) {
        game = score;
    }

    public void setIsSecondServe( ) {
        isSecondServe = false;
    }

    public void setIsServing(boolean bool) {
        isServing = bool;
    }

    public void setSet() {
        set += 1;
    }

    public String getName( ) {
        return name;
    }

    public int getAce( ) {
        return ace;
    }

    public int getFirstServe( ) {
        return firstServe;
    }

    public int getSecondServe( ) {
        return secondServe;
    }

    public int getDoubleFault( ) {
        return doubleFault;
    }

    public int getWinFirstServe( ) {
        return winFirstServe;
    }

    public int getWinSecondServe( ) {
        return winSecondServe;
    }

    public int getWinner( ) {
        return winner;
    }

    public int getForcedError( ) {
        return forcedError;
    }

    public int getUnforcedError( ) {
        return unforcedError;
    }

    public String getGame( ) {
        return game;
    }

    public boolean isSecondServe( ) {
        return isSecondServe;
    }

    public boolean isServing( ) {
        return isServing;
    }

    public int getSet() {
        return set;
    }
}