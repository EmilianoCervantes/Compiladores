import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {

	public static void main(String[] args) throws IOException {
		CharStream input = CharStreams.fromStream(System.in); 
		ExprLexer lexer = new ExprLexer(input);
		//ExprLexer lexer = new ExprLexer(CharStreams.fromString("1%2/1%5+2%3"));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprParser parser = new ExprParser(tokens);
		ParseTree tree = parser.prog(); 
		System.out.println(tree.toStringTree(parser)); 
		ParseTreeWalker walker = new ParseTreeWalker();
		MyListener listener = new MyListener();
		walker.walk(listener, tree); 

	}

}
