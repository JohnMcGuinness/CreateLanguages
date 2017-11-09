package minicalc.ch06_ast;

import static minicalc.ch06_ast.Point.Point;

public final class Position {

    public final Point start;
    public final Point end;

    public static Position Position(int startLine, int startCol, int endLine, int endCol) {
        return Position(Point(startLine, startCol), Point(endLine, endCol));
    }

    public static Position Position(Point start, Point end) {
        return new Position(start, end);
    }

    private Position(Point start, Point end) {

        if(end.isBefore(start)) {
            throw new IllegalArgumentException("Start must be before end");
        }

        this.start = start;
        this.end = end;
    }

    /**
     * Given the whole code extract the portion of text corresponding to this position
     */
    public String text(String wholeText) {
        return wholeText.substring(start.offset(wholeText), end.offset(wholeText));
    }

    public int length(String code) {
        return end.offset(code) - start.offset(code);
    }
}
