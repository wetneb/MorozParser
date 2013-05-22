package util;

import java.io.IOException;

public class TokenizerException extends IOException
{
	private static final long serialVersionUID = 1L;
	public final String what;
	public TokenizerException(String s) { what = s; }
}
