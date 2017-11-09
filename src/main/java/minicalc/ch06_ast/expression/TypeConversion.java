package minicalc.ch06_ast.expression;

import minicalc.ch06_ast.expression.Expression;
import minicalc.ch06_ast.Position;
import minicalc.ch06_ast.type.Type;

public final class TypeConversion implements Expression {

    private final Expression expression;
    private final Type targetType;
    private final Position position;

    public static TypeConversion TypeConversion(Expression expression, Type targetType, Position position) {
        return new TypeConversion(expression, targetType, position);
    }

    private TypeConversion(Expression expression, Type targetType, Position position) {
        this.expression = expression;
        this.targetType = targetType;
        this.position = position;
    }

    @Override
    public Position position() {
        return position;
    }

    public Expression expression() {
        return expression;
    }

    public Type targetType() {
        return this.targetType;
    }
}
