 import org.antlr.v4.runtime.*;
 import org.antlr.v4.runtime.tree.*;
    
public class Main {

	public static void main( String[] args) throws Exception 
	{

		CharStream input = CharStreams.fromStream(System.in); 
		PostfijoLexer lexer = new PostfijoLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PostfijoParser parser = new PostfijoParser(tokens);
		ParseTree tree = parser.expr(); 
		//System.out.println(tree.toStringTree(parser)); 
		ParseTreeWalker walker = new ParseTreeWalker();
		MyListener listener = new MyListener();
		walker.walk(listener, tree); 
	}


}
