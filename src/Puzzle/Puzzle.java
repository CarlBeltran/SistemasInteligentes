package Puzzle;

import java.util.*;

public class Puzzle {
    static final byte[][] goal = {{1, 2, 3},{4, 5, 6},{7, 8, 0 }};
    static final Board answer = new Board(goal);
    static Random rn = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        System.out.println("BFS\tIDDFS\tDFS \tMan\tMis");
        BFS bfs = new BFS();
        AAsterix asterixMan = new AAsterix(new Mannhattan());
        AAsterix asterixMis = new AAsterix(new Missplaced());
        IterativeDFS idfs = new IterativeDFS();
        DFS dfs = new DFS();

        for (int i = 0; i < 1000; i++) {
            Board init = generate(10);
            System.out.print(bfs.search(init, answer)+"\t");
            System.out.print(idfs.search(init, answer)+"\t");
            System.out.print(dfs.search(init, answer)+"\t");
            System.out.print(asterixMan.search(init, answer)+"\t");
            System.out.print(asterixMis.search(init, answer)+"\n");
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