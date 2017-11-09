package minicalc.ch06_ast;

import static minicalc.ch06_ast.Point.Point;
import org.antlr.v4.runtime.Token;

public final class TokenOps  {

    private TokenOps(){}

    public static Point startPoint(Token token) {
        return Point(token.getLine(), token.getCharPositionInLine());
    }

    public static Point endPoint(Token token) {
        return Point(token.getLine(), (token.getCharPositionInLine() + token.getText().length()));
    }
}
