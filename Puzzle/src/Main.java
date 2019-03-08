import java.util.*;

public class Main {
    static final byte[][] goal = {{1, 2, 3},{4, 5, 6},{7, 8, 0 }};
    static final Board answer = new Board(goal);
    static Random rn = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        System.out.println("BFS\tIDDFS\tDFS\tMis\tMan");
        Search<Board>[] algoritmos = new Search[]{new BFS(), new IterativeDFS(), new DFS(), new AAsterisk(new Missplaced()), new AAsterisk(new Mannhattan())};

        for (int i = 0; i < 1000; i++) {
            Board init = generate(10);
            for (int j = 0; j < algoritmos.length; j++)
                System.out.print(algoritmos[j].search(init, answer)+"\t");
            System.out.println();
        }
    }

    public static Board generate(int movements){
        int[] pos =  {2, 2};
        Board board = new Board(goal, pos);
        for (int i = 0; i < movements ; i++) {
            int newCoord = rn.nextInt(3);
            Board newBoard;
            if(i%2==1){
                int[] newPos = {pos[0], newCoord};
                newBoard = board.move(newPos);
            }else{
                int[] newPos = {newCoord, pos[1]} ;
                newBoard = board.move(newPos);
            }
            if(newBoard.equals(board)){
                i--;
            }else{
                board = newBoard;
                pos = newBoard.getPos();
            }
        }
        board.setDistance(0);
        return board;
    }

}