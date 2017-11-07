package minicalc.ch04_lexer;

import static minicalc.ch04_lexer.MiniCalcTestUtils.lexerForCode;
import static minicalc.ch04_lexer.MiniCalcTestUtils.listOf;
import static minicalc.ch04_lexer.MiniCalcTestUtils.tokensContent;
import static minicalc.ch04_lexer.MiniCalcTestUtils.tokensNames;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MiniCalcLexerTest {

    @Test
    public void parseVarDeclarationAssignedAnIntegerLiteral() {
        assertEquals(listOf("VAR",
                            "ID",
                            "ASSIGN",
                            "INTLIT",
                            "EOF"),
                     tokensNames(lexerForCode("var a = 1")));
    }

    @Test
    public void parseVarDeclarationAssignedADecimalLiteral() {
        assertEquals(listOf("VAR",
                            "ID",
                            "ASSIGN",
                            "DECLIT",
                            "EOF"),
                     tokensNames(lexerForCode("var a = 1.23")));
    }

    @Test
    public void parseVarDeclarationAssignedASum() {
        assertEquals(listOf("VAR",
                            "ID",
                            "ASSIGN",
                            "INTLIT",
                            "PLUS",
                            "INTLIT",
                            "EOF"),
                     tokensNames(lexerForCode("var a = 1 + 2")));
    }

    @Test
    public void parseMathematicalExpression() {
        assertEquals(listOf("INTLIT",
                            "PLUS",
                            "ID",
                            "ASTERISK",
                            "INTLIT",
                            "DIVISION",
                            "INTLIT",
                            "MINUS",
                            "INTLIT",
                            "EOF"),
                     tokensNames(lexerForCode("1 + a * 3 / 4 - 5")));
    }

    @Test
    public void parseMathematicalExpressionWithParenthesis() {
        assertEquals(listOf("INTLIT",
                            "PLUS",
                            "LPAREN",
                            "ID",
                            "ASTERISK",
                            "INTLIT",
                            "RPAREN",
                            "MINUS",
                            "DECLIT",
                            "EOF"),
                     tokensNames(lexerForCode("1 + (a * 3) - 5.12")));
    }

    @Test
    public void parseCast() {
        assertEquals(listOf("ID",
                            "ASSIGN",
                            "ID",
                            "AS",
                            "INT",
                            "EOF"),
                     tokensNames(lexerForCode("a = b as Int")));
    }

    @Test
    public void parseSimpleString() {
        assertEquals(listOf("STRING_OPEN",
                            "STRING_CONTENT",
                            "STRING_CLOSE",
                            "EOF"),
                     tokensNames(lexerForCode("\"hi!\"")));
    }

    @Test
    public void parseStringWithNewlineEscape() {
        String code = "\"hi!\\n\"";

        assertEquals(listOf("\"",
                            "hi!",
                            "\\n",
                            "\"",
                            "EOF"),
                     tokensContent(lexerForCode(code)));

        assertEquals(listOf("STRING_OPEN",
                            "STRING_CONTENT",
                            "ESCAPE_NEWLINE",
                            "STRING_CLOSE",
                            "EOF"),
                     tokensNames(lexerForCode(code)));
    }

    @Test
    public void parseStringWithSlashEscape() {

        assertEquals(listOf("STRING_OPEN",
                            "STRING_CONTENT",
                            "ESCAPE_SLASH",
                            "STRING_CLOSE",
                            "EOF"),
                     tokensNames(lexerForCode("\"hi!\\\\\"")));
    }

    @Test
    public void parseStringWithDelimiterEscape() {

        assertEquals(listOf("STRING_OPEN",
                            "STRING_CONTENT",
                            "ESCAPE_STRING_DELIMITER",
                            "STRING_CLOSE",
                            "EOF"),
                     tokensNames(lexerForCode("\"hi!\\\"\"")));
    }

    @Test
    public void parseStringWithSharpEscape() {
        assertEquals(listOf("STRING_OPEN",
                            "STRING_CONTENT",
                            "ESCAPE_SHARP",
                            "STRING_CLOSE",
                            "EOF"),
                     tokensNames(lexerForCode("\"hi!\\#\"")));
    }

    @Test
    public void parseStringWithInterpolation() {

        String code = "\"hi #{name}. This is a number: #{5 * 4}\"";

        assertEquals(listOf("\"",
                            "hi ",
                            "#{",
                            "name",
                            "}",
                            ". This is a number: ",
                            "#{",
                            "5",
                            "*",
                            "4",
                            "}",
                            "\"",
                            "EOF"),
                     tokensContent(lexerForCode(code)));

        System.out.println(tokensNames(lexerForCode(code)));

        assertEquals(listOf("STRING_OPEN",
                            "STRING_CONTENT",
                            "INTERPOLATION_OPEN",
                            "ID",
                            "INTERPOLATION_CLOSE",
                            "STRING_CONTENT",
                            "INTERPOLATION_OPEN",
                            "INTLIT",
                            "ASTERISK",
                            "INTLIT",
                            "INTERPOLATION_CLOSE",
                            "STRING_CLOSE",
                            "EOF"),
                     tokensNames(lexerForCode(code)));
    }

}
