package minicalc.ch04;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.minicalc.MiniCalcLexer;
import org.minicalc.MiniCalcParser;

public class MiniCalcTestUtils
{
	private MiniCalcTestUtils(){}

	public static MiniCalcLexer lexerForCode(String code) {
		return new MiniCalcLexer(CharStreams.fromString(code));
	}

	public static String readSourceFile(String path) throws FileNotFoundException, IOException {
		return Files.readAllLines(Paths.get(path)).stream().collect(Collectors.joining(System.lineSeparator()));
	}

	public static List<String> tokensContent(MiniCalcLexer lexer) {

		LinkedList<String> tokens = new LinkedList<>();

		Token t = null;

		do {

			t = lexer.nextToken();

			if( t.getType() == -1) {
				tokens.add("EOF");
			}
			else if( t.getType() != MiniCalcLexer.WS) {
				tokens.add(lexer.getText());
			}

		} while ( t.getType() != -1);

		return tokens;
	}

	public static List<String> tokensNames(MiniCalcLexer lexer) {

		LinkedList<String> tokens = new LinkedList<>();

		Token t = null;

		do {

			t = lexer.nextToken();

			if( t.getType() == -1) {
				tokens.add("EOF");
			}
			else if( t.getType() != MiniCalcLexer.WS) {
				tokens.add(MiniCalcLexer.VOCABULARY.getSymbolicName(t.getType()));
			}

		} while ( t.getType() != -1);

		return tokens;
	}

	public static MiniCalcParser.MiniCalcFileContext parseCode(String code) {
		return new MiniCalcParser(new CommonTokenStream(lexerForCode(code))).miniCalcFile();
	}

	public static List<String> listOf(String... strings) {
		return Arrays.asList(strings);
	}
}
