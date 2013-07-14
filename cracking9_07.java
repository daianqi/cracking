/*
Implement the "paint fill" function that one might see on many image editting programs. That is, given a screen (represented
by a two-dimensional array of colors), a point, and a new color, fill in the surrounding area until the color changes from
the original color.
*/

public class cracking9_07 {
    
    enum Color {
        Black, White, Red, Yellow, Green
    }

    boolean paintFill(Color[][] screen, int x, int y, Color oldColor, Color newColor) {
        if(x<0||x>=screen[0].length||y<0||y>=screen.length) {
            return false;
        }
        if(screen[y][x] == oldColor) { //this is worth attention
            screen[y][x] = newColor;
            paintFill(screen, x-1, y, oldColor, newColor);
            paintFill(screen, x+1, y, oldColor, newColor);
            paintFill(screen, x, y-1, oldColor, newColor);
            paintFill(screen, x, y+1, oldColor, newColor);
        }
        return true;
    }

    boolean paintFill(Color[][] screen, int x, int y, Color newColor) {
        if(screen[y][x] == newColor)
            return false;
        return paintFill(screen, x, y, screen[y][x], newColor);
    }
}
