import java.util.*;


public class MyListener extends ExprBaseListener {
	Stack<Fraccion> pila = new Stack<Fraccion>();
	
	@Override public void exitProg(ExprParser.ProgContext ctx) { 
		Fraccion f = pila.pop();
		System.out.println("resultado " + f);
	}
	
	@Override public void exitTerm(ExprParser.TermContext ctx) { 
		if(ctx.oper != null) {
			Fraccion b = pila.pop();
			Fraccion a = pila.pop();
			if (ctx.oper.getType() == ExprLexer.MULTIPLICACION) {
				int num = a.getNumerador() * b.getNumerador();
				int den = a.getDenominador() * b.getDenominador();
				pila.push(new Fraccion(num, den));
			}
			else {
				int num = a.getNumerador() * b.getDenominador();
				int den = a.getDenominador() * b.getNumerador();
				pila.push(new Fraccion(num, den));
			}
		}
	}
	
	@Override public void enterFactor(ExprParser.FactorContext ctx) {
		if(ctx.FRAC() != null) {
			String str = ctx.getText();
			int pos = str.indexOf('%');
			int num = Integer.parseInt(str.substring(0, pos));
			int den = Integer.parseInt(str.substring(pos+1));
			Fraccion f = new Fraccion(num,den);
			pila.push(f);
		}
	}
	@Override public void exitExpr(ExprParser.ExprContext ctx) {
		if(ctx.oper != null) {
			Fraccion b = pila.pop();
			Fraccion a = pila.pop();
			switch (ctx.oper.getType())  {
			case ExprLexer.SUMA : 
				int num = a.getNumerador() * b.getDenominador() + b.getNumerador() * a.getDenominador();
				int den = a.getDenominador() * b.getDenominador();
				pila.push(new Fraccion(num, den));
				break;
			case ExprLexer.RESTA :
				num = a.getNumerador() * b.getDenominador() - b.getNumerador() * a.getDenominador();
				den = a.getDenominador() * b.getDenominador();
				pila.push(new Fraccion(num, den));
				break;
			}
		}
		
	}
}
