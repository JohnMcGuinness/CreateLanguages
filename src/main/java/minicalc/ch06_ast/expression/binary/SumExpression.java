package minicalc.ch06_ast.expression.binary;

import minicalc.ch06_ast.Position;
import minicalc.ch06_ast.expression.Expression;

public final class SumExpression implements BinaryExpression {

    private final Position position;
    private final Expression left;
    private final Expression right;

    public static SumExpression SumExpression(Expression left, Expression right, Position position)  {
        return new SumExpression(left, right, position);
    }

    private SumExpression(Expression left, Expression right, Position position) {
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
