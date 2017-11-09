package minicalc.ch06_ast.statement;

import minicalc.ch06_ast.Position;
import minicalc.ch06_ast.type.Type;

public final class InputDeclaration implements ValueDeclaration {

    private final Type type;
    private final String name;
    private final Position position;

    public static InputDeclaration InputDeclaration(Type type, String name, Position position) {
        return new InputDeclaration(type, name, position);
    }

    private InputDeclaration(Type type, String name, Position position) {
        this.type = type;
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

    public Type type() {
        return type;
    }

}
