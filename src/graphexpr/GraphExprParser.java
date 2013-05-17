
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Fri May 17 15:17:54 CEST 2013
//----------------------------------------------------

package graphexpr;

import java_cup.runtime.*;
import java.util.List;
import java.util.ArrayList;
import pregroup.SimpleType;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Fri May 17 15:17:54 CEST 2013
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
    "\000\031\000\002\002\005\000\002\002\004\000\002\002" +
    "\003\000\002\004\004\000\002\003\003\000\002\003\003" +
    "\000\002\006\003\000\002\006\004\000\002\006\004\000" +
    "\002\006\003\000\002\006\006\000\002\006\003\000\002" +
    "\006\007\000\002\011\007\000\002\005\005\000\002\005" +
    "\003\000\002\010\011\000\002\007\003\000\002\007\003" +
    "\000\002\012\003\000\002\012\004\000\002\013\004\000" +
    "\002\013\007\000\002\014\003\000\002\014\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\066\000\004\023\005\001\002\000\022\004\022\005" +
    "\023\007\033\013\032\016\025\020\027\022\034\025\026" +
    "\001\002\000\006\007\014\017\013\001\002\000\006\002" +
    "\011\012\010\001\002\000\006\002\uffff\012\uffff\001\002" +
    "\000\004\023\005\001\002\000\004\002\000\001\002\000" +
    "\006\002\001\012\001\001\002\000\022\004\uffec\005\uffec" +
    "\007\uffec\013\uffec\016\uffec\020\uffec\022\uffec\025\uffec\001" +
    "\002\000\006\026\015\027\016\001\002\000\004\010\uffe9" +
    "\001\002\000\004\010\uffea\001\002\000\004\010\020\001" +
    "\002\000\004\017\021\001\002\000\022\004\uffeb\005\uffeb" +
    "\007\uffeb\013\uffeb\016\uffeb\020\uffeb\022\uffeb\025\uffeb\001" +
    "\002\000\014\002\ufff6\010\ufff6\011\ufff6\012\ufff6\015\ufff6" +
    "\001\002\000\004\007\066\001\002\000\006\002\ufffd\012" +
    "\ufffd\001\002\000\014\002\ufff8\010\ufff8\011\ufff8\012\ufff8" +
    "\015\ufff8\001\002\000\014\002\ufffb\010\ufffb\011\ufffb\012" +
    "\ufffb\015\ufffb\001\002\000\020\004\022\005\023\013\032" +
    "\016\025\020\027\022\034\025\026\001\002\000\006\002" +
    "\ufffe\012\ufffe\001\002\000\006\002\ufffc\012\ufffc\001\002" +
    "\000\020\004\022\005\023\013\032\016\025\020\027\022" +
    "\034\025\026\001\002\000\020\004\022\005\023\013\032" +
    "\016\025\020\027\022\034\025\026\001\002\000\020\004" +
    "\022\005\023\013\032\016\025\020\027\022\034\025\026" +
    "\001\002\000\014\002\ufff9\010\ufff9\011\ufff9\012\ufff9\015" +
    "\ufff9\001\002\000\004\011\037\001\002\000\010\006\042" +
    "\021\043\024\041\001\002\000\004\011\uffee\001\002\000" +
    "\006\010\uffef\011\uffef\001\002\000\006\010\ufff0\011\ufff0" +
    "\001\002\000\020\004\022\005\023\013\032\016\025\020" +
    "\027\022\034\025\026\001\002\000\004\011\045\001\002" +
    "\000\020\004\022\005\023\013\032\016\025\020\027\022" +
    "\034\025\026\001\002\000\004\010\047\001\002\000\006" +
    "\002\ufff1\012\ufff1\001\002\000\004\011\uffed\001\002\000" +
    "\004\015\052\001\002\000\004\007\055\001\002\000\006" +
    "\014\063\015\062\001\002\000\006\014\ufff2\015\ufff2\001" +
    "\002\000\010\006\042\021\043\024\041\001\002\000\004" +
    "\011\057\001\002\000\020\004\022\005\023\013\032\016" +
    "\025\020\027\022\034\025\026\001\002\000\004\010\061" +
    "\001\002\000\006\014\ufff4\015\ufff4\001\002\000\004\007" +
    "\055\001\002\000\014\002\ufff5\010\ufff5\011\ufff5\012\ufff5" +
    "\015\ufff5\001\002\000\006\014\ufff3\015\ufff3\001\002\000" +
    "\014\002\ufffa\010\ufffa\011\ufffa\012\ufffa\015\ufffa\001\002" +
    "\000\006\006\042\024\041\001\002\000\004\010\070\001" +
    "\002\000\014\002\ufff7\010\ufff7\011\ufff7\012\ufff7\015\ufff7" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\066\000\010\002\005\004\006\013\003\001\001\000" +
    "\010\003\027\006\023\010\030\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\006\004\011\013" +
    "\003\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\014\016\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\006\064" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\006" +
    "\050\001\001\000\004\006\035\001\001\000\004\006\034" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\007" +
    "\037\012\043\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\006\047\001\001\000\002\001" +
    "\001\000\004\006\045\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\005" +
    "\052\011\053\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\007\037\012\055\001\001\000\002\001\001\000" +
    "\004\006\057\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\011\063\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\007\066\001\001\000\002" +
    "\001\001\000\002\001\001" });

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



public String name;


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
          case 24: // exp ::= EXPR 
            {
              Integer RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = e; 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("exp",10, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // exp ::= EXPL 
            {
              Integer RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = -e; 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("exp",10, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // stype ::= IDENT LPAREN exp RPAREN COLON 
            {
              SimpleType RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-4)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-4)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-4)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).value;
		 RESULT = new SimpleType(i,e); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("stype",9, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-4)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // stype ::= IDENT COLON 
            {
              SimpleType RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).value;
		 RESULT = new SimpleType(i,0); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("stype",9, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // prop ::= REL node 
            {
              PropExpr RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		NodeExpr v = (NodeExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = new RelExpr(v); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("prop",8, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // prop ::= string 
            {
              PropExpr RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = new CstExpr(s); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("prop",8, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // string ::= STR 
            {
              String RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = s; 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("string",5, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // string ::= NAME 
            {
              String RESULT =null;
		 RESULT = name; 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("string",5, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // triple ::= LPAREN node COMMA prop COMMA node RPAREN 
            {
              TripleExpr RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-5)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-5)).right;
		NodeExpr n = (NodeExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-5)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)).right;
		PropExpr p = (PropExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)).value;
		int oleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).left;
		int oright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).right;
		NodeExpr o = (NodeExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).value;
		 RESULT = new TripleExpr(n,p,o); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("triple",6, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-6)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // double_list ::= double 
            {
              List<DoubleExpr> RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		DoubleExpr e = (DoubleExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 List<DoubleExpr> l = new ArrayList();
               l.add(e);
               RESULT = l; 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("double_list",3, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // double_list ::= double_list PLUS double 
            {
              List<DoubleExpr> RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).right;
		List<DoubleExpr> t = (List<DoubleExpr>)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		DoubleExpr e = (DoubleExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 t.add(e);
               RESULT = t; 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("double_list",3, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-2)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // double ::= LPAREN prop COMMA node RPAREN 
            {
              DoubleExpr RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)).right;
		PropExpr s = (PropExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)).value;
		int nleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).right;
		NodeExpr n = (NodeExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).value;
		 RESULT = new DoubleExpr(s,n); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("double",7, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-4)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // node ::= LCRO node PLUS double_list RCRO 
            {
              NodeExpr RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)).right;
		NodeExpr n = (NodeExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)).value;
		int lleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).right;
		List<DoubleExpr> l = (List<DoubleExpr>)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).value;
		 RESULT = new PlusExpr(n,l); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("node",4, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-4)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // node ::= NODE_FRESH 
            {
              NodeExpr RESULT =null;
		 RESULT = new FreshExpr(); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("node",4, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
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
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("node",4, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-3)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // node ::= NULL 
            {
              NodeExpr RESULT =null;
		 RESULT = new NullExpr(); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("node",4, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // node ::= OBJ node 
            {
              NodeExpr RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		NodeExpr v = (NodeExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = new ObjExpr(v); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("node",4, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // node ::= SUB node 
            {
              NodeExpr RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		NodeExpr v = (NodeExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = new SubExpr(v); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("node",4, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // node ::= VAR 
            {
              NodeExpr RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		Integer v = (Integer)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = new VarExpr(v); 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("node",4, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // pattern ::= triple 
            {
              PatternExpr RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		TripleExpr t = (TripleExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = t; 
              CUP$GraphExprParser$result = parser.getSymbolFactory().newSymbol("pattern",1, ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()), RESULT);
            }
          return CUP$GraphExprParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // pattern ::= node 
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
          case 3: // expr ::= stype pattern 
            {
              GraphExpr RESULT =null;
		int stleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).left;
		int stright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).right;
		SimpleType st = (SimpleType)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.elementAt(CUP$GraphExprParser$top-1)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).left;
		int pright = ((java_cup.runtime.Symbol)CUP$GraphExprParser$stack.peek()).right;
		PatternExpr p = (PatternExpr)((java_cup.runtime.Symbol) CUP$GraphExprParser$stack.peek()).value;
		 RESULT = new GraphExpr(st,p); 
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

