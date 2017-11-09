package minicalc.ch06_ast;

import static minicalc.ch06_ast.Position.Position;
import static minicalc.ch06_ast.TokenOps.endPoint;
import static minicalc.ch06_ast.TokenOps.startPoint;
import org.antlr.v4.runtime.ParserRuleContext;

public final class ParserRuleContextOps  {

    private ParserRuleContextOps(){}

    public static Position toPosition(ParserRuleContext ctx, boolean considerPosition) {

        return considerPosition
                   ? Position(startPoint(ctx.start), endPoint(ctx.stop))
                   : null;
    }
}
