package minicalc.ch05;

import java.util.LinkedList;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.TerminalNode;

public abstract class ParseTreeElement {

    public abstract String multiLineString(String indent);

    private static ParseTreeLeaf leaf(String type, String text) {
        return new ParseTreeLeaf(type, text);
    }

    private static ParseTreeNode node(String name) {
        return new ParseTreeNode(name);
    }

    public static ParseTreeNode toParseTree(ParserRuleContext node, Vocabulary vocabulary) {

        final ParseTreeNode res = node(node.getClass().getSimpleName().replace("Context", ""));

        node.children.forEach(c -> {

            if (c instanceof ParserRuleContext) {
                res.child(toParseTree(((ParserRuleContext) c), vocabulary));
            }
            else if (c instanceof TerminalNode) {
                res.child(leaf(vocabulary.getSymbolicName(((TerminalNode) c).getSymbol().getType()), c.getText()));
            }
        });

        return res;
    }

    public static class ParseTreeLeaf extends ParseTreeElement {

        private final String type;
        private final String text;

        private ParseTreeLeaf(String type, String text) {
            this.type = type;
            this.text = text;
        }

        @Override
        public String multiLineString(String indentation) {
            return (indentation == null ? "" : indentation) + "T:" + type + "[" + text + "]" + System.lineSeparator();
        }

        @Override
        public String toString() {
            return "T:" + type + "[" + text + "]";
        }
    }

    public static class ParseTreeNode extends ParseTreeElement {

        private LinkedList<ParseTreeElement> children = new LinkedList<>();
        private final String name;

        private ParseTreeNode(String name) {
            this.name = name;
        }

        public ParseTreeNode child(ParseTreeElement child) {
            children.add(child);
            return this;
        }

        @Override
        public String multiLineString(String indent) {

            final StringBuilder sb = new StringBuilder();

            sb.append(indent).append(name).append(System.lineSeparator());
            children.forEach(c -> sb.append(c.multiLineString(indent + "  ")));

            return sb.toString();
        }

        @Override
        public String toString() {
            return "Node(" + name + ")" + children.toString();
        }
    }
}
