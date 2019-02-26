import java.util.HashSet;
import java.util.LinkedList;

public class DFS implements Search<Board> {
    @Override
    public int search( Board initial, Board solution) {
        LinkedList<Board> list  = new LinkedList<>();
        HashSet<Board> visited = new HashSet<>();
        list.add(initial);
        int nodes = 0;
        while( !list.isEmpty() ){
            nodes ++;
            Board board = list.removeFirst();
            if(!visited.contains(board))
                for( Board b : Search.nextMovements(board) ){
                    if( b.equals(solution) )
                        return nodes;
                    list.addFirst(b);
                }
            visited.add(board);
        }
        return nodes;
    }
}
