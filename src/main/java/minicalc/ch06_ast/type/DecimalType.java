package minicalc.ch06_ast.type;

import minicalc.ch06_ast.Position;

public final class DecimalType implements Type {

    private final Position position;

    public static DecimalType DecimalType(Position position) {
        return new DecimalType(position);
    }

    private DecimalType(Position position) {
        this.position = position;
    }

    @Override
    public Position position() {
        return position;
    }
}
