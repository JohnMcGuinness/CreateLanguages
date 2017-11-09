package minicalc.ch06_ast.expression.binary;

import minicalc.ch06_ast.expression.Expression;
import minicalc.ch06_ast.Position;
import minicalc.ch06_ast.expression.Expression;

public final class DivisionExpression implements BinaryExpression {

    private final Position position;
    private final Expression left;
    private final Expression right;

    public DivisionExpression(Expression left, Expression right, Position position) {
        this.left = left;
        this.right = right;
        this.position = position;
    }

    @Override
    public Expression left() {
        return this.left;
    }

    @Override
    public Expression right() {
        return this.right;
    }

    @Override
    public Position position() {
        return this.position;
    }
}
