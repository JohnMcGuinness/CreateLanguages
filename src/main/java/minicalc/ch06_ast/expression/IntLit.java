package minicalc.ch06_ast.expression;

import minicalc.ch06_ast.expression.Expression;
import minicalc.ch06_ast.Position;

public final class IntLit implements Expression {

    public final String value;
    public final Position position;

    public static IntLit IntLit(String value, Position position) {
        return new IntLit(value, position);
    }

    private IntLit(String value, Position position) {
        this.value = value;
        this.position = position;
    }

    @Override
    public Position position() {
        return position;
    }

    public String value() {
        return value;
    }
}
