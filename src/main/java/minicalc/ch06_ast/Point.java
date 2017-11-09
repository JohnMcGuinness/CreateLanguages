package minicalc.ch06_ast;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Point  {

    public int line;
    public int column;

    public static Point Point(int line, int column) {
        return new Point(line, column);
    }

    private Point(int line, int column) {
        this.line = line;
        this.column = column;
    }

    /**
     * Translate the Point to an offset in the original code stream.
     */
    public int offset(String code) {

        final List<String> lines = Arrays.asList(code.split("\n"));
        final int newLines = line - 1;
        return lines.subList(0, line - 1)
                    .stream()
                    .collect(Collectors.summingInt(s -> s.length())) + newLines + column;
    }

    public boolean isBefore(Point p) {
        return line < p.line || (line == p.line && column < p.column);
    }

    @Override
    public String toString() {
        return MessageFormat.format("Line {0}, Column {1}", line, column);
    }
}
