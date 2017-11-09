package minicalc.ch06_ast.statement;

import java.util.Arrays;
import java.util.List;
import minicalc.ch06_ast.Node;


public interface Statement extends Node {

    public static List<Statement> statements(Statement... statements) {
        return Arrays.asList(statements);
    }

}
