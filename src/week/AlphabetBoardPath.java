package week;

import java.util.ArrayList;
import java.util.List;

public class AlphabetBoardPath {
    public static void main(String[] args) {
        AlphabetBoardPath a = new AlphabetBoardPath();
        System.out.println(a.alphabetBoardPath("leet"));
    }
    class Point {
        int x;
        int y;
    }
    public String alphabetBoardPath(String target) {
        List<Point> points = new ArrayList<>(target.length());
        Point first = new Point();
        first.x = 0;
        first.y = 0;
        points.add(first);
        String[] board = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        for (int i = 0; i < target.length(); i++) {
            String t = target.substring(i, i+1);
            for (int j = 0; j < board.length; j++) {
                int x = board[j].indexOf(t);
                if (x != -1) {
                    Point point = new Point();
                    point.x = x;
                    point.y = j;
                    points.add(point);

                }
            }
        }
        StringBuilder results = new StringBuilder();
        for (int i = 0; i < points.size()-1; i++) {
            Point point1 = points.get(i);
            Point point2 = points.get(i+1);
            int subX = point1.x - point2.x;
            int subY = point1.y - point2.y;
            while (point1.x != point2.x || point1.y != point2.y) {
                if (subY < 0 && !(point1.x > 0 && point1.y == 4) && point1.y != point2.y) {
                    results.append("D");
                    point1.y += 1;
                }
                if (subY > 0  && point1.y != point2.y) {
                    results.append("U");
                    point1.y -= 1;
                }
                if (subX < 0  && point1.x != point2.x) {
                    results.append("R");
                    point1.x += 1;
                }
                if (subX > 0 && point1.x != point2.x) {
                    results.append("L");
                    point1.x -= 1;
                }
            }
            results.append("!");
        }

        return results.toString();
    }
}

/*
*
*Aa Bb Cc Dd Ee 
* Ff Gg Hh Ii Jj 
* Kk Ll Mm Nn Oo 
* Pp Qq Rr Ss Tt 
* Uu Vv Ww Xx Yy 
* Zz
* */