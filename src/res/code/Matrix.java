package res.code;

public class Matrix {

    private Box[][] map;

    Matrix(Box box){
        map = new Box[Ranges.getSize().x][Ranges.getSize().y];
        for (Coord coord : Ranges.getAllCoords())
            map[coord.x][coord.y] = box;
    }

    Box get (Coord coord){
        if (Ranges.inRange(coord))
            return map[coord.x][coord.y];
        return null;
    }

    void set(Coord coord, Box box){
        if (Ranges.inRange(coord))
            map[coord.x][coord.y] = box;
    }

    void setX(Coord coord) {
        this.set(coord,Box.X);
    }

    void setO(Coord coord) {
        this.set(coord,Box.O);
    }

    public Box get(Coord coord,int x, int y) {
        if (Ranges.inRange(coord))
            return map[coord.x][coord.y];
        return null;
    }
}
