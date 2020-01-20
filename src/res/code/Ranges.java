package res.code;

import java.util.ArrayList;

public class Ranges {

    static private Coord size; //razmer nawevo polia
    static private ArrayList<Coord> allCoords;

    static void setSize(Coord size) {
        Ranges.size = size;
        allCoords = new ArrayList<>();
        for (int x = 0; x < size.x; x++) {
            for (int y = 0; y < size.y; y++) {
                allCoords.add(new Coord(x, y));
            }
        }
    }

    static public Coord getSize() {
        return size;
    }

    static public ArrayList<Coord> getAllCoords() {
        return allCoords;
    }

    static boolean inRange(Coord coord) {
        return coord.x >= 0 && coord.x < size.x &&
                coord.y >= 0 && coord.y < size.y;

    }
}


