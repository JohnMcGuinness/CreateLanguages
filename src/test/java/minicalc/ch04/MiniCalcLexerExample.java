package minicalc.ch04;

import java.io.IOException;
import java.text.MessageFormat;
import static minicalc.ch04.MiniCalcTestUtils.lexerForCode;
import static minicalc.ch04.MiniCalcTestUtils.readSourceFile;
import org.antlr.v4.runtime.Token;
import org.minicalc.MiniCalcLexer;

public class MiniCalcLexerExample
{
	private static final String RESOURCES_FOLDER = "src/test/resources/";

	public static void main(String[] args) throws IOException {

		final MiniCalcLexer lexer = lexerForCode(readSourceFile(RESOURCES_FOLDER + "examples/rectangle.mc"));

		Token token = null;

		do {

			token = lexer.nextToken();
			String typeName = MiniCalcLexer.VOCABULARY.getSymbolicName(token.getType());

			String text = token.getText().replace("\n", "\\n")
										 .replace("\r", "\\r")
										 .replace("\t", "\\t");

			System.out.println(formatToken(token.getLine(),
										   token.getStartIndex(),
										   token.getStopIndex(),
										   typeName,
										   text));

		} while (-1 != token.getType());

	}

	private static String formatToken(int line, int startIndex, int stopIndex, String typeName, String text) {

		final String template = "L{0}({1}-{2}) {3} ''{4}''";

		return MessageFormat.format(template, line, startIndex, stopIndex, typeName, text);
	}
}
