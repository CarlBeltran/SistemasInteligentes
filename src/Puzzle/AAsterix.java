package Puzzle;

import java.util.PriorityQueue;

public class AAsterix implements Search<Board> {

    Heuristic<Board> heuristic;

    public AAsterix(Heuristic<Board> heuristic){
        this.heuristic = heuristic;
    }

    @Override
    public int search(Board initial, Board solution) {
        PriorityQueue<Board> list = new PriorityQueue<>();
        list.add(initial);
        int nodes = 0;
        while (!list.isEmpty()){
            for( Board b : Search.nextMovements(list.poll()) ){
                if( b.equals(solution) )
                    return nodes;
                b.setDistanceTotal(b.getDistance() + heuristic.estimate(b, solution));
                list.add(b);
                nodes++;
            }
        }
        return nodes;
    }
}
