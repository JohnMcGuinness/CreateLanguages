package minicalc.ch06_ast.type;

import minicalc.ch06_ast.Position;

public final class StringType implements Type {

    private final Position position;

    private StringType(Position position) {
        this.position = position;
    }

    @Override
    public Position position() {
        return position;
    }
}
