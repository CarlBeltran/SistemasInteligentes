package Puzzle;

import java.util.HashSet;
import java.util.LinkedList;

public class IterativeDFS implements Search<Board>{
    boolean res = false;

    @Override
    public int search(Board initial, Board solution) {
        int nodes = 0;
        res = false;
        for (int i = 0; !res; i++) {
            nodes += DFSIteration(initial, solution, i);
        }
        return nodes;
    }


    public int DFSIteration(Board initial, Board solution, int maxDepth){
        LinkedList<Board> list  = new LinkedList<>();
        HashSet<Board> visited = new HashSet<>();
        list.add(initial);
        int nodes = 0;
        while( !list.isEmpty() ){
            nodes ++;
            Board board = list.removeFirst();
            if(!visited.contains(board) && board.getDistance() < maxDepth)
                for( Board b : Search.nextMovements(board) ){
                    if( b.equals(solution) ){
                        res = true;
                        return nodes;
                    }
                    list.addFirst(b);
                }
            visited.add(board);
        }
        return nodes;
    }

}
