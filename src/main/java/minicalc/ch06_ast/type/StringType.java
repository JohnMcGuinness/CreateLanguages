package minicalc.ch06_ast.type;

import minicalc.ch06_ast.Position;

public final class StringType implements Type {

    private final Position position;

    public static StringType StringType(Position position) {
        return new StringType(position);
    }
    
    private StringType(Position position) {
        this.position = position;
    }

    @Override
    public Position position() {
        return position;
    }
}
