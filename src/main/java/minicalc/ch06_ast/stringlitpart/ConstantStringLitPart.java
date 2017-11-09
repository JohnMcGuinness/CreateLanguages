package minicalc.ch06_ast.stringlitpart;

import minicalc.ch06_ast.Position;

public final class ConstantStringLitPart implements StringLitPart {

    private final String content;
    private final Position position;

    public static ConstantStringLitPart ConstantStringLitPart(String content, Position position) {
        return new ConstantStringLitPart(content, position);
    }

    private ConstantStringLitPart(String content, Position position) {
        this.content = content;
        this.position = position;
    }

    @Override
    public Position position() {
        return position;
    }

    public String content() {
        return content;
    }
}
