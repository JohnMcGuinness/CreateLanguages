package minicalc.ch06_ast.statement;

import minicalc.ch06_ast.statement.Statement;
import minicalc.ch06_ast.Position;
import minicalc.ch06_ast.expression.Expression;

public final class Print implements Statement {

    private final Expression value;
    private final Position position;

    public static Print Print(Expression value, Position position) {
        return new Print(value, position);
    }

    private Print(Expression value, Position position) {
        this.value = value;
        this.position = position;
    }

    @Override
    public Position position() {
        return position;
    }

    public Expression value() {
        return value;
    }
}
