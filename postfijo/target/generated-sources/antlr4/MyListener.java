
public class MyListener extends PostfijoBaseListener {
	public void exitTerm(PostfijoParser.TermContext ctx) {
		System.out.print(ctx.getText());
	}
	
	public void exitExpr(PostfijoParser.ExprContext ctx) {
		if(ctx.getChildCount() == 3) {
			System.out.print(ctx.children.get(1).getText());	
		}
		
	}
	
}
