package minicalc.ch06_ast.expression.binary;

import minicalc.ch06_ast.expression.Expression;
import minicalc.ch06_ast.expression.Expression;

public interface BinaryExpression extends Expression
{
    public Expression left();

    public Expression right();
}
