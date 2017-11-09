package minicalc.ch06_ast.expression;

import minicalc.ch06_ast.expression.Expression;
import minicalc.ch06_ast.Position;

public final class UnaryMinusExpression implements Expression {

    private final Position position;
    private final Expression expression;

    public UnaryMinusExpression(Expression expression, Position position) {
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
