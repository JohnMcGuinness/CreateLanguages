package minicalc.ch06_ast.type;

import minicalc.ch06_ast.Position;

public final class IntType implements Type {

    private final Position position;

    private IntType(Position position) {
        this.position = position;
    }

    @Override
    public Position position() {
        return position;
    }
}
