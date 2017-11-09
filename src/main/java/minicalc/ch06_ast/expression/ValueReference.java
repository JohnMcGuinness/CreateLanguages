package minicalc.ch06_ast.expression;

import minicalc.ch06_ast.statement.ValueDeclaration;
import minicalc.ch06_ast.Position;
import minicalc.ch06_ast.ReferenceByName;

public class ValueReference implements Expression {

    private final ReferenceByName<ValueDeclaration> reference;
    private final Position position;

    public static ValueReference ValueReference(ReferenceByName<ValueDeclaration> reference, Position position) {
        return new ValueReference(reference, position);
    }

    private ValueReference(ReferenceByName<ValueDeclaration> reference, Position position) {
        this.reference = reference;
        this.position = position;
    }

    @Override
    public Position position() {
        return position;
    }

    public ReferenceByName<ValueDeclaration> reference() {
        return reference;
    }
}
