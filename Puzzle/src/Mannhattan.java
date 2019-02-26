public class Mannhattan implements Heuristic<Board>{
    @Override
    public int estimate( Board actual, Board goal) {
        int res = 0;
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3 ; j++) {
                int[] my = actual.search( goal.getBoard()[i][j] );
                res += Math.abs(my[0]-i) + Math.abs(my[0]-j);
            }
        }
        return res;
    }
}