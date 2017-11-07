package minicalc.ch04;

import java.io.IOException;
import java.text.MessageFormat;
import static minicalc.ch04.MiniCalcTestUtils.lexerForCode;
import static minicalc.ch04.MiniCalcTestUtils.readSourceFile;
import org.antlr.v4.runtime.Token;
import org.minicalc.MiniCalcLexer;

public class MiniCalcLexerExample
{
	private static final String RESOURCES_DIR = "src/test/resources/";

	public static void main(String[] args) throws IOException {

		final MiniCalcLexer lexer = lexerForCode(readSourceFile(RESOURCES_DIR + "examples/rectangle.mc"));

		Token token = null;

		do {

			token = lexer.nextToken();

			System.out.println(formatToken(token));

		} while (-1 != token.getType());

	}

	private static String formatToken(Token token) {

		return MessageFormat.format("L{0}({1}-{2}) {3} ''{4}''",
									token.getLine(),
									token.getStartIndex(),
									token.getStopIndex(),
									MiniCalcLexer.VOCABULARY.getSymbolicName(token.getType()),
									token.getText().replace("\n", "\\n")
												   .replace("\r", "\\r")
												   .replace("\t", "\\t"));
	}
}
