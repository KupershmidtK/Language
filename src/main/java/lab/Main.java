package lab;

import lab.parser.LangGramLexer;
import lab.parser.LangGramParser;
import lab.parser.LangGramVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        String inputFile = null;
        if(args.length > 0) inputFile = args[0];

        InputStream is = System.in;
        try {
            if (args.length > 0)
                is = new FileInputStream(inputFile);

            CharStream input = CharStreams.fromStream(is);
            LangGramLexer lexer = new LangGramLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LangGramParser parser = new LangGramParser(tokens);
            ParseTree tree = parser.program();

            LangGramVisitor<Integer> visitor = new LangVisitor();
            visitor.visit(tree);

        } catch (FileNotFoundException e) {
            System.out.println("File " + inputFile + " not found");
        } catch (RecognitionException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}