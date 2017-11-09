package minicalc.ch06_ast.statement;

import minicalc.ch06_ast.Position;
import minicalc.ch06_ast.expression.Expression;

public final class VarDeclaration implements ValueDeclaration {

    private final Expression value;
    private final String name;
    private final Position position;

    public static VarDeclaration VarDeclaration(Expression value, String name, Position position) {
        return new VarDeclaration(value, name, position);
    }

    private VarDeclaration(Expression value, String name, Position position) {
        this.value = value;
        this.name = name;
        this.position = position;
    }

    @Override
    public Position position() {
        return position;
    }

    @Override
    public String name() {
        return name;
    }

    public Expression value() {
        return value;
    }

}
