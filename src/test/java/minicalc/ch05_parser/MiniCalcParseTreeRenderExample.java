package minicalc.ch05_parser;

import java.io.IOException;

public class MiniCalcParseTreeRenderExample  {

    private static final String RESOURCES_FOLDER = "src/test/resources/";

    private static final ParseTreeRenderer RENDERER = new MiniCalcParseTreeRenderer();

    public static void main(String[] args) throws IOException {
        System.out.println(RENDERER.render(RESOURCES_FOLDER + "examples/rectangle.mc"));
    }
}
