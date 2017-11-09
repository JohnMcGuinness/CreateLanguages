package minicalc.ch06_ast.statement;

import minicalc.ch06_ast.statement.Statement;
import minicalc.ch06_ast.Position;
import minicalc.ch06_ast.ReferenceByName;
import minicalc.ch06_ast.expression.Expression;

public final class Assignment implements Statement {

    private final ReferenceByName<VarDeclaration> varDeclaration;
    private final Expression value;
    private final Position position;

    public static Assignment Assignment(ReferenceByName<VarDeclaration> varDeclaration, Expression value, Position position) {
        return new Assignment(varDeclaration, value, position);
    }
    
    private Assignment(ReferenceByName<VarDeclaration> varDeclaration, Expression value, Position position) {
        this.varDeclaration = varDeclaration;
        this.value = value;
        this.position = position;
    }

    @Override
    public Position position() {
        return position;
    }

    public Expression value() {
        return value;
    }

    public ReferenceByName<VarDeclaration> varDeclaration() {
        return varDeclaration;
    }

}
