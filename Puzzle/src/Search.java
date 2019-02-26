import java.util.LinkedList;

public interface Search<T> {

    int search(T initial, T solution);

    static LinkedList<Board> nextMovements(Board board){
        LinkedList<Board> list = new LinkedList<>();
        Board mod;
        int[] pos = board.getPos();
        if( pos[0] != 0 ){
            mod = board.move(pos[0]-1, pos[1]);
            mod.setDistanceTotal(mod.getDistance()+mod.misplaced());
            list.add(mod);
        }
        if( pos[0] != 2 ){
            mod = board.move(pos[0]+1, pos[1]);
            mod.setDistanceTotal(mod.getDistance()+mod.misplaced());
            list.add(mod);
        }
        if( pos[1] != 0 ){
            mod = board.move(pos[0], pos[1]-1);
            mod.setDistanceTotal(mod.getDistance()+mod.misplaced());
            list.add(mod);
        }
        if( pos[1] != 2 ){
            mod = board.move(pos[0], pos[1]+1);
            mod.setDistanceTotal(mod.getDistance()+mod.misplaced());
            list.add(mod);
        }
        return list;
    }

}
