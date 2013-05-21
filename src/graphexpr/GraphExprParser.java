
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Tue May 21 12:49:22 CEST 2013
//----------------------------------------------------

package graphexpr;

import java_cup.runtime.*;
import java.util.List;
import java.util.ArrayList;
import pregroup.SimpleType;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Tue May 21 12:49:22 CEST 2013
  */
public class GraphExprParser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public GraphExprParser() {super();}

  /** Constructor which sets the default scanner. */
  public GraphExprParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public GraphExprParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\025\000\002\002\005\000\002\002\004\000\002\002" +
    "\003\000\002\004\004\000\002\004\004\000\002\012\003" +
    "\000\002\012\003\000\002\003\003\000\002\003\003\000" +
    "\002\005\003\000\002\005\006\000\002\005\003\000\002" +
    "\005\003\000\002\005\006\000\002\005\006\000\002\007" +
    "\011\000\002\007\003\000\002\006\003\000\002\010\004" +
    "\000\002\010\007\000\002\011\007" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\057\000\004\015\005\001\002\000\022\004\030\005" +
    "\031\006\042\013\027\014\040\016\032\017\034\020\041" +
    "\001\002\000\006\006\020\012\017\001\002\000\006\002" +
    "\015\011\014\001\002\000\006\002\uffff\011\uffff\001\002" +
    "\000\006\017\011\020\013\001\002\000\006\002\ufffc\011" +
    "\ufffc\001\002\000\006\002\ufffd\011\ufffd\001\002\000\006" +
    "\002\ufffb\011\ufffb\001\002\000\004\015\005\001\002\000" +
    "\004\002\000\001\002\000\006\002\001\011\001\001\002" +
    "\000\022\004\uffef\005\uffef\006\uffef\013\uffef\014\uffef\016" +
    "\uffef\017\uffef\020\uffef\001\002\000\006\021\022\022\021" +
    "\001\002\000\004\007\025\001\002\000\004\007\023\001" +
    "\002\000\004\012\024\001\002\000\006\017\uffed\020\uffed" +
    "\001\002\000\004\012\026\001\002\000\022\004\uffee\005" +
    "\uffee\006\uffee\013\uffee\014\uffee\016\uffee\017\uffee\020\uffee" +
    "\001\002\000\004\006\057\001\002\000\012\002\ufff5\007" +
    "\ufff5\010\ufff5\011\ufff5\001\002\000\004\006\054\001\002" +
    "\000\012\002\ufff0\007\ufff0\010\ufff0\011\ufff0\001\002\000" +
    "\006\002\ufffa\011\ufffa\001\002\000\012\002\ufff8\007\ufff8" +
    "\010\ufff8\011\ufff8\001\002\000\012\002\ufff6\007\ufff6\010" +
    "\ufff6\011\ufff6\001\002\000\006\002\ufffe\011\ufffe\001\002" +
    "\000\006\002\ufff9\011\ufff9\001\002\000\004\006\051\001" +
    "\002\000\010\002\ufff1\007\ufff1\011\ufff1\001\002\000\016" +
    "\004\030\005\031\013\027\014\040\016\032\017\034\001" +
    "\002\000\004\010\044\001\002\000\016\004\030\005\031" +
    "\013\027\014\040\016\032\017\034\001\002\000\004\010" +
    "\046\001\002\000\016\004\030\005\031\013\027\014\040" +
    "\016\032\017\034\001\002\000\004\007\050\001\002\000" +
    "\010\002\ufff2\007\ufff2\011\ufff2\001\002\000\006\006\042" +
    "\020\041\001\002\000\004\007\053\001\002\000\012\002" +
    "\ufff3\007\ufff3\010\ufff3\011\ufff3\001\002\000\004\016\032" +
    "\001\002\000\004\007\056\001\002\000\012\002\ufff7\007" +
    "\ufff7\010\ufff7\011\ufff7\001\002\000\006\006\042\020\041" +
    "\001\002\000\004\007\061\001\002\000\012\002\ufff4\007" +
    "\ufff4\010\ufff4\011\ufff4\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\057\000\012\002\005\004\006\010\003\011\007\001" +
    "\001\000\012\003\035\005\032\006\034\007\036\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\012\011\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\010\004\015\010\003\011\007\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\006\005\042\006\034" +
    "\001\001\000\002\001\001\000\006\005\044\006\034\001" +
    "\001\000\002\001\001\000\006\005\046\006\034\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\007\051\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\006\054" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\007" +
    "\057\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$GraphExprParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$GraphExprParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$GraphExprParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$GraphExprParser$actions {
  private final GraphExprParser parser;

  /** Constructor */
  CUP$GraphExprParser$actions(GraphExprParser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$GraphExprParser$do_action(
    int                        CUP$GraphExprParser$act_num,
    java_cup.runtime.lr_parser CUP$GraphExprParser$parser,
    java.util.Stack            CUP$GraphExprParser$stack,
    int                        CUP$GraphExprParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$GraphExprParser$result;

      /* select the action based on the action number */
      switch (CUP$GraphExprParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // consumer_type ::= IDENT LPAREN EXP_ODD RPAREN COLON 
            {
              SimpleType RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-4)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-4)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-4)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).value;
		 RESULT = new SimpleType(i,e); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("consumer_type",7, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-4)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // producer_type ::= IDENT LPAREN EXP_EVEN RPAREN COLON 
            {
              SimpleType RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-4)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-4)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-4)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).value;
		 RESULT = new SimpleType(i,e); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("producer_type",6, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-4)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // producer_type ::= IDENT COLON 
            {
              SimpleType RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).value;
		 RESULT = new SimpleType(i,0); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("producer_type",6, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // string ::= STR 
            {
              String RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = s; 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("string",4, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // triple ::= STMT_VAR 
            {
              StmtExpr RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		Integer v = (Integer)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = new TripleVarExpr(v); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("triple",5, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // triple ::= LPAREN node COMMA node COMMA node RPAREN 
            {
              StmtExpr RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-5)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-5)).right;
		NodeExpr n = (NodeExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-5)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)).right;
		NodeExpr p = (NodeExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)).value;
		int oleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).left;
		int oright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).right;
		NodeExpr o = (NodeExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).value;
		 RESULT = new TripleExpr(n,p,o); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("triple",5, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-6)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // node ::= BETA LPAREN triple RPAREN 
            {
              NodeExpr RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).right;
		StmtExpr t = (StmtExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).value;
		 RESULT = new MorphExpr(true, t); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("node",3, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // node ::= ALPHA LPAREN triple RPAREN 
            {
              NodeExpr RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).right;
		StmtExpr t = (StmtExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).value;
		 RESULT = new MorphExpr(false, t); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("node",3, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // node ::= NODE_FRESH 
            {
              NodeExpr RESULT =null;
		 RESULT = new FreshExpr(); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("node",3, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // node ::= string 
            {
              NodeExpr RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = new LiteralExpr(s); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("node",3, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // node ::= NODE LPAREN string RPAREN 
            {
              NodeExpr RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).value;
		 RESULT = new NamedNodeExpr(n); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("node",3, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // node ::= NODE_VAR 
            {
              NodeExpr RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		Integer v = (Integer)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = new NodeVarExpr(v); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("node",3, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // pattern ::= triple 
            {
              PatternExpr RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		StmtExpr t = (StmtExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = t; 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("pattern",1, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // pattern ::= node 
            {
              PatternExpr RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		NodeExpr n = (NodeExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = n; 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("pattern",1, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // var ::= STMT_VAR 
            {
              Integer RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		Integer v = (Integer)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = v; 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("var",8, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // var ::= NODE_VAR 
            {
              Integer RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		Integer v = (Integer)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = v; 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("var",8, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // expr ::= consumer_type var 
            {
              GraphExpr RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).right;
		SimpleType t = (SimpleType)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).value;
		int vleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		Integer v = (Integer)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = new ConsumerExpr(t,v); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("expr",2, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // expr ::= producer_type pattern 
            {
              GraphExpr RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).right;
		SimpleType t = (SimpleType)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int pright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		PatternExpr p = (PatternExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = new ProducerExpr(t,p); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("expr",2, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // expr_list ::= expr 
            {
              List<GraphExpr> RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		GraphExpr e = (GraphExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 List<GraphExpr> l = new ArrayList<GraphExpr>();
               l.add(e);
               RESULT = l; 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("expr_list",0, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= expr_list EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).right;
		List<GraphExpr> start_val = (List<GraphExpr>)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).value;
		RESULT = start_val;
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$GraphExprParser$parser.done_parsing();
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // expr_list ::= expr_list SEP expr 
            {
              List<GraphExpr> RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).right;
		List<GraphExpr> l = (List<GraphExpr>)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		GraphExpr e = (GraphExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 l.add(e);
               RESULT = l; 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("expr_list",0, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

