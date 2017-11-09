package minicalc.ch06_ast.expression;

import minicalc.ch06_ast.expression.Expression;
import minicalc.ch06_ast.Position;

public final class DecLit implements Expression {

    public final String value;
    public final Position position;

    public static DecLit DecLit(String value, Position position) {
        return new DecLit(value, position);
    }

    private DecLit(String value, Position position) {
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
