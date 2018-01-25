import java.util.*;

public class MiListener extends gramaticaBaseListener{
	Stack<Integer> pila = new Stack<>();
	@Override public void exitTerm(gramaticaParser.TermContext ctx) { 
		System.out.print(ctx.getText());
		pila.push(Integer.parseInt(ctx.getText()));
	}
	@Override public void exitExpr(gramaticaParser.ExprContext ctx) { 
		if(ctx.oper != null && ctx.oper.getType() == gramaticaParser.SUMA) {
			System.out.println("si");
		}
		else {
			System.out.println("no");
		}
		if(ctx.children.size() ==3) {
			System.out.print(ctx.children.get(1));
			int b = pila.pop();
			int a = pila.pop();
			switch (ctx.children.get(1).getText()) {
			case "+" : 
					pila.push(a+b);
					break;
			case "-" :
					pila.push(a-b);
					break;
			}
		}
	}
	@Override public void exitProg(gramaticaParser.ProgContext ctx) { 
		System.out.println();
		System.out.println(pila.pop());
	}
}
