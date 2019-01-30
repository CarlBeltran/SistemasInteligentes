package Puzzle;

public class Missplaced implements Heuristic<Board> {

    @Override
    public int estimate(Board actual, Board goal) {
        int res = 0;
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3 ; j++) {
                res += ( goal.getBoard()[i][j] == actual.getBoard()[i][j] )? 0 : 1;
            }
        }
        return res;
    }

}
