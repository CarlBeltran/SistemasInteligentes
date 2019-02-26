import java.util.LinkedList;

public class BFS implements Search<Board> {

    @Override
    public int search( Board initial, Board solution ){
        LinkedList<Board> list  = new LinkedList<>();
        list.add(initial);
        int nodes = 0;
        while (!list.isEmpty()){
            nodes++;
            for( Board b : Search.nextMovements(list.removeFirst()) ){
                if( b.equals(solution) )
                    return nodes;
                list.addLast(b);
            }
        }
        return nodes;
    }

}