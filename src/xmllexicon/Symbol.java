package xmllexicon;

public class Symbol
{
    public final int type;
    public final int line;
    public final int col;
    public Object val;

    public Symbol(int t, int l, int c)
    {
        type = t;
        line = l;
        col = c;
        val = 0;
    }

    public Symbol(int t, int l, int c, Object v)
    {
        type = t;
        line = l;
        col = c;
        val = v;
    }
}

