package minicalc.ch06_ast.expression;

import minicalc.ch06_ast.expression.Expression;
import java.util.List;
import minicalc.ch06_ast.Position;
import minicalc.ch06_ast.stringlitpart.StringLitPart;

public final class StringLit implements Expression {

    private final List<StringLitPart> parts;
    private final Position position;

    public static StringLit StringLit(List<StringLitPart> parts, Position position) {
        return new StringLit(parts, position);
    }

    private StringLit(List<StringLitPart> parts, Position position) {
        this.parts = parts;
        this.position = position;

    }

    @Override
    public Position position() {
        return position;
    }

    public List<StringLitPart> parts() {
        return parts;
    }
}
