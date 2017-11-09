package minicalc.ch06_ast.stringlitpart;

import minicalc.ch06_ast.expression.Expression;
import minicalc.ch06_ast.Position;

public final class ExpressonStringLitPart implements StringLitPart {

    private final Expression expression;
    private final Position position;

    public static ExpressonStringLitPart ExpressonStringLitPart(Expression expression, Position position) {
        return new ExpressonStringLitPart(expression, position);
    }

    private ExpressonStringLitPart(Expression expression, Position position) {
        this.expression = expression;
        this.position = position;
    }

    @Override
    public Position position() {
        return position;
    }

    public Expression expression() {
        return expression;
    }
}
