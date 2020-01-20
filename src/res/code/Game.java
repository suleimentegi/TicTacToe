package res.code;

public class Game {

    Matrix map;
    private GameState state;
    private int countDraw;  // счетчик для считывание оставшиехся свободных полей
    private int placeXO;

    public void start(int rows,int cols){
        Ranges.setSize(new Coord(rows, cols));
        map = new Matrix(Box.ZERO);
        state = GameState.PLAYED;
        countDraw = rows * cols;
        placeXO = 0;
    }

    public Box getBox (Coord coord){
        return map.get(coord);
    }

    public GameState getState() {
        return state;
    }

    public void pressLeftButton (Coord coord){
        if (state != GameState.PLAYED) return;
        if (map.get(coord) == Box.ZERO){
            if (placeXO % 2 == 0)
                map.setX (coord);
            else
                map.setO(coord);
            --countDraw;
            placeXO++;
        }
        checkWinner(coord);
    }

    void checkWinner(Coord coord){
        if (state == GameState.PLAYED);
        if (countDraw == 0)
            state = GameState.DRAW;
        if (isWin(coord,"X"))
            state = GameState.WINX;
        if (isWin(coord,"O"))
            state = GameState.WINO;
    }

    boolean isWin(Coord c,String n){
        if (xConst(c,n) || yConst(c,n) || d1Const(c,n) || d2Const(c,n)) return true;
        return false;
    }

    boolean xConst(Coord c,String n){
        int count=0;
        String name = n;
        if (map.get(new Coord(c.x,c.y)) == Box.valueOf(name)){
            count++;
            if (map.get(new Coord(c.x,c.y-1)) == Box.valueOf(name)){
                count++;
                if (map.get(new Coord(c.x,c.y-2)) == Box.valueOf(name)){
                    count++;
                    if (map.get(new Coord(c.x,c.y-3)) == Box.valueOf(name)) {
                        count++;
                        if (map.get(new Coord(c.x, c.y - 4)) == Box.valueOf(name))
                            count++;
                    }
                }
            }
            if (map.get(new Coord(c.x,c.y+1)) == Box.valueOf(name)){
                count++;
                if (map.get(new Coord(c.x,c.y+2)) == Box.valueOf(name)){
                    count++;
                    if (map.get(new Coord(c.x,c.y+3)) == Box.valueOf(name)){
                        count++;
                        if (map.get(new Coord(c.x,c.y+4)) == Box.valueOf(name))
                            count++;
                    }
                }
            }
        }
        if (count >= 5) return true;
        return false;
    }

    boolean yConst(Coord c,String n){
        int count=0;
        String name = n;
        if (map.get(new Coord(c.x,c.y)) == Box.valueOf(name)){
            count++;
            if (map.get(new Coord(c.x-1,c.y)) == Box.valueOf(name)){
                count++;
                if (map.get(new Coord(c.x-2,c.y)) == Box.valueOf(name)){
                    count++;
                    if (map.get(new Coord(c.x-3,c.y)) == Box.valueOf(name)) {
                        count++;
                        if (map.get(new Coord(c.x - 4, c.y)) == Box.valueOf(name))
                            count++;
                    }
                }
            }

            if (map.get(new Coord(c.x+1,c.y)) == Box.valueOf(name)){
                count++;
                if (map.get(new Coord(c.x+2,c.y)) == Box.valueOf(name)){
                    count++;
                    if (map.get(new Coord(c.x+3,c.y)) == Box.valueOf(name)){
                        count++;
                        if (map.get(new Coord(c.x+4,c.y)) == Box.valueOf(name))
                            count++;
                    }
                }
            }
        }
        if (count >= 5) return true;
        return false;
    }

    boolean d1Const(Coord c,String n){
        int count=0;
        String name = n;
        if (map.get(new Coord(c.x,c.y)) == Box.valueOf(name)){
            count++;
            if (map.get(new Coord(c.x-1,c.y-1)) == Box.valueOf(name)){
                count++;
                if (map.get(new Coord(c.x-2,c.y-2)) == Box.valueOf(name)){
                    count++;
                    if (map.get(new Coord(c.x-3,c.y-3)) == Box.valueOf(name)) {
                        count++;
                        if (map.get(new Coord(c.x - 4, c.y - 4)) == Box.valueOf(name))
                            count++;
                    }
                }
            }

            if (map.get(new Coord(c.x+1,c.y+1)) == Box.valueOf(name)){
                count++;
                if (map.get(new Coord(c.x+2,c.y+2)) == Box.valueOf(name)){
                    count++;
                    if (map.get(new Coord(c.x+3,c.y+3)) == Box.valueOf(name)){
                        count++;
                        if (map.get(new Coord(c.x+4,c.y+4)) == Box.valueOf(name)){
                            count++;
                        }
                    }
                }
            }
        }
        if (count >= 5) return true;
        return false;
    }

    boolean d2Const(Coord c,String n){
        int count=0;
        String name = n;
        if (map.get(new Coord(c.x,c.y)) == Box.valueOf(name)){
            count++;
            if (map.get(new Coord(c.x+1,c.y-1)) == Box.valueOf(name)){
                count++;
                if (map.get(new Coord(c.x+2,c.y-2)) == Box.valueOf(name)){
                    count++;
                    if (map.get(new Coord(c.x+3,c.y-3)) == Box.valueOf(name)){
                        count++;
                        if (map.get(new Coord(c.x+4,c.y-4)) == Box.valueOf(name)) {
                            count++;
                        }
                    }
                }
            }

            if (map.get(new Coord(c.x-1,c.y+1)) == Box.valueOf(name)){
                count++;
                if (map.get(new Coord(c.x-2,c.y+2)) == Box.valueOf(name)){
                    count++;
                    if (map.get(new Coord(c.x-3,c.y+3)) == Box.valueOf(name)){
                        count++;
                        if (map.get(new Coord(c.x-4,c.y+4)) == Box.valueOf(name)){
                            count++;
                        }
                    }
                }
            }
        }
        if (count >= 5) return true;
        return false;
    }

}