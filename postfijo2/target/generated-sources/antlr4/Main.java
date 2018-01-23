import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class Main {

	public static void main(String[] args)  throws Exception {
		CharStream input = CharStreams.fromStream(System.in); 
		gramaticaLexer lexer = new gramaticaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		gramaticaParser parser = new gramaticaParser(tokens);
		ParseTree tree = parser.prog(); 
		//System.out.println(tree.toStringTree(parser)); 
		ParseTreeWalker walker = new ParseTreeWalker();
		MiListener listener = new MiListener();
		walker.walk(listener, tree);
	}

}
