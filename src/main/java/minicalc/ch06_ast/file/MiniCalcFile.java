package minicalc.ch06_ast.file;

import minicalc.ch06_ast.statement.Statement;
import java.util.List;
import minicalc.ch06_ast.Position;
import minicalc.ch06_ast.Node;

public final class MiniCalcFile implements Node {

    private final List<Statement> statements;
    private final Position position;

    public MiniCalcFile(List<Statement> statements, Position position) {
        this.position = position;
        this.statements = statements;
    }

    @Override
    public Position position() {
        return position;
    }

    public List<Statement> statements() {
        return statements;
    }
}
