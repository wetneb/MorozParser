package pregroup;

//! Implementation of Moroz's algorithm
public class Parser<BT extends BasicType<BT>>
{
	private PhraseString<BT> phrase;
	//! Length of the TypePhrase
	private int n;
	//! To what other simple type is this simple type linked ?
	private int[] link;
	//! Is the substring [i,j] reductible to 1 ?
	private int[][] state;
	//! Index of words
	private int[] widx;
	
	public final static int UNDEF = -1;
	
	public Parser(PhraseString<BT> phr)
	{
		phrase = phr;
		n = phrase.size();
		link = new int[n];
		state = new int[n][n];
		widx = new int[n];
	
		for(int i = 0; i < n; i++)
		{
			link[i] = UNDEF;
			if(i == 0)
				widx[i] = 0;
			else if(get(i).isLB())
				widx[i] = widx[i-1] + 1;
			else widx[i] = widx[i-1];
			
			for(int j = 0; j < n; j++)
				state[i][j] = UNDEF;
			
		}
	}
	
	public boolean run()
	{
		return reductible(0,n-1);
	}
	
	private boolean reductible(int i, int j)
	{
		if(i < 0 || i >= n || j < 0 || j >= n || i > j)
			return false;
		if(state[i][j] != UNDEF)
			return state[i][j] == 1;
		
		boolean result = computeReductible(i,j);
		state[i][j] = (result ? 1 : 0);
		return result;
	}
	
	private boolean computeReductible(int i, int j)
	{
		// Base case
		if(i == j)
			return (isType(i) && isUnit(i));
		else if(j == i+1)
			return (isType(i)
				  && isType(j)
				  && gcon(i,j));
		else if(isType(i) && isType(j)
				&& isStar(i+1)
				&& isStar(j-1)
				&& widx[j] == widx[i]+1
				&& gcon(i,j))
			return true;
		
		if(isType(i) && isType(j))
		{
			// A1a
			for(int k = i+1; k < j-1; k++)
				if(isType(k) && reductible(i,k) && reductible(k+1,j))
					return true;
			
			// A1b
			for(int k = i+1; k < j-1; k++)
				if(isRB(k) && isLB(k+1) && reductible(i,k) && reductible(k+1,j))
					return true;
			
			// A2
			if(gcon(i,j) && reductible(i+1, j-1))
				return true;
		}
		
		// A3a
		if(isLB(i) && isType(j) && widx[i] < widx[j])
		{
			for(int k = i+1; k < j && widx[k] == widx[i]; k++)
				if(isStar(k) && reductible(k+1,j))
					return true;
		}
		
		// A3b
		if(isRB(j) && isType(i) && widx[i] < widx[j])
		{
			for(int k = j-1; k > i && widx[k] == widx[j]; k--)
				if(isStar(k) && reductible(i,k-1))
					return true;
		}
		
		// A4a
		if(isType(i) && isType(j) && isStar(i+1) && gcon(i,j)
				&& widx[i] != widx[j])
		{
			for(int k = i+1; k <j && widx[k] == widx[i]; k++)
				if(isLB(k+1) && reductible(k+1,j-1))
					return true;
		}
		
		// A4b
		if(isType(i) && isType(j) && isStar(j-1) && gcon(i,j)
				&& widx[i] != widx[j])
		{
			for(int k = j-1; k > i && widx[k] == widx[j]; k--)
				if(isRB(k-1) && reductible(i+1,k-1))
					return true;
		}
		
		// A4c
		if(isType(i) && isType(j) &&
		   isStar(i+1) && isStar(j-1) &&
		   1 + widx[i] < widx[j] &&
		   gcon(i,j))
		{
			int k, k2;
			for(k = i+1; k < j && !isRB(k); k++);
			for(k2 = j-1; k2 > i && !isLB(k2); k2--);
			if(reductible(k,k2))
				return true;
		}
		
		// A5
		if(isLB(i) && isRB(j))
		{
			for(int k = i+1; k < j && !isRB(k); k++)
			{
				if(isType(k) && isStar(k-1))
				{
					for(int k2 = j-1; k2 > i && !isLB(k2); k2--)
					{
						if(isType(k2) && isStar(k2+1) &&
							reductible(k,k2))
							return true;
					}
				}
			}
		}
		
			
		return false;
	}
	
	private PhraseElem get(int pos)
	{
		return phrase.get(pos);
	}
	
	private SimpleType<BT> at(int pos)
	{
		return ((TypeElem<BT>)phrase.get(pos)).val;
	}
	
	private boolean isType(int pos)
	{
		return get(pos).isType();
	}
	
	private boolean isLB(int pos)
	{
		return get(pos).isLB();
	}
	
	private boolean isRB(int pos)
	{
		return get(pos).isRB();
	}
	
	private boolean isStar(int pos)
	{
		return get(pos).isStar();
	}
	
	private boolean isUnit(int pos)
	{
		return (isType(pos) && at(pos).isUnit());
	}
	
	private boolean gcon(int i, int j)
	{
		return (isType(i) && isType(j) && at(i).gcon(at(j)));
	}
	
}
