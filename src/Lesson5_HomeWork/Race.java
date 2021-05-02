package Lesson5_HomeWork;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private ArrayList<Stage> stages;
    private int countWinner;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
    public boolean getWinner (){
        countWinner++;
        return countWinner==1;
    }
    public void clearWinnerCounter(){
        countWinner = 0;
    }
}
