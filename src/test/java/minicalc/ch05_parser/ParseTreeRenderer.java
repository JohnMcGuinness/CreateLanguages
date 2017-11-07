package minicalc.ch05;

import java.io.IOException;
import static minicalc.ch04.MiniCalcTestUtils.parseCode;
import static minicalc.ch04.MiniCalcTestUtils.readSourceFile;
import static minicalc.ch05.ParseTreeElement.toParseTree;
import org.antlr.v4.runtime.Vocabulary;

public abstract class ParseTreeRenderer  {

    protected abstract Vocabulary vocabulary();

    public static ParseTreeRenderer forVocabulary(Vocabulary vocabulary) {
        return new ParseTreeRenderer() {
            @Override
            public Vocabulary vocabulary() {
                return vocabulary;
            }
        };
    }

    public final String render(String file) throws IOException {
         return toParseTree(parseCode(readSourceFile(file)),vocabulary()).multiLineString("");
    }
}
