import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java.io.*;
%%

%class CScanner
%unicode
%cup
%line
%column
%char

%{
    public CScanner(Reader r, ComplexSymbolFactory sf) {
    		this(r);
    		this.sf=sf;
    }
    public Symbol symbol(String plaintext,int code) {
        return sf.newSymbol(plaintext,code,new Location("",yyline+1, yycolumn +1,yychar), new Location("",yyline+1,yycolumn+yylength(),yychar));
    }
    public Symbol symbol(String plaintext,int code,Integer number) {
        return sf.newSymbol(plaintext,code,new Location("",yyline+1, yycolumn +1,yychar), new Location("",yyline+1,yycolumn+yylength(),yychar),number);
    }
    private ComplexSymbolFactory sf;
    StringBuffer string = new StringBuffer();
%}
%eofval{
    return sf.newSymbol("EOF", sym.EOF);
%eofval}

ALPHA = [A-Za-z]
DIGIT = [0-9]

/* literals */
DecIntegerLiteral = 0 | [1-9][0-9]*
HexIntegerLiteral = 0(x|X)(([0-9]|[a-f]|[A-F])+)
FloatLiteral = (([0-9]*)\.([0-9]+))|(([0-9]+)\.([0-9]*))
FloatScientificLiteral = ([0-9]+)(e|E)((\+|-)?)([0-9]+)

/* whitespace */
NONNEWLINE_WHITE_SPACE_CHAR = [\ \t]
NEWLINE = \r|\n|\r\n
//WHITE_SPACE_CHAR = [\n\r\ \t\b\012]
//WhiteSpace = {NONNEWLINE_WHITE_SPACE_CHAR} | {NEWLINE} | {WHITE_SPACE_CHAR}

/* identifiers */
//All variable names must begin with a letter of the alphabet or an underscore( _ ).
Identifier = ({ALPHA}|_)({ALPHA}|{DIGIT}|_)*

/* comments */
InputCharacter = [^\r\n]
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment   = "/#" [^*] ~"#/" | "/#" "#"+ "/"
EndOfLineComment     = "##" {InputCharacter}*
//CommentContent       = ( [^*] | \*+ [^/*] )*

%state STRING
%state CHAR
%state ENDCHAR
%state SPECIALCHARSTR
%state SPECIALCHAR
%state POSTFIXID

%%

/* keywords */
<YYINITIAL> "begin"                 {return symbol(yytext(), sym.BEGIN);}
<YYINITIAL> "bool"                  {return symbol(yytext(), sym.BOOL);}
<YYINITIAL> "break"                 {return symbol(yytext(), sym.BREAK);}
<YYINITIAL> "case"                  {return symbol(yytext(), sym.CASE);}
<YYINITIAL> "char"                  {return symbol(yytext(), sym.CHAR);}
<YYINITIAL> "const"                 {return symbol(yytext(), sym.CONST);}
<YYINITIAL> "continue"              {return symbol(yytext(), sym.CONTINUE);}
<YYINITIAL> "default"               {return symbol(yytext(), sym.DEFAULT);}
<YYINITIAL> "double"                {return symbol(yytext(), sym.DOUBLE);}
<YYINITIAL> "else"                  {return symbol(yytext(), sym.ELSE);}
<YYINITIAL> "end"                   {return symbol(yytext(), sym.END);}
<YYINITIAL> "extern"                {return symbol(yytext(), sym.EXTERN);}
<YYINITIAL> "false"                 {return symbol(yytext(), sym.BOOL_CONST);}
<YYINITIAL> "function"              {return symbol(yytext(), sym.FUNCTION);}
<YYINITIAL> "float"                 {return symbol(yytext(), sym.FLOAT);}
<YYINITIAL> "for"                   {return symbol(yytext(), sym.FOR);}
<YYINITIAL> "if"                    {return symbol(yytext(), sym.IF);}
<YYINITIAL> "int"                   {return symbol(yytext(), sym.INT);}
<YYINITIAL> "long"                  {return symbol(yytext(), sym.LONG);}
<YYINITIAL> "return"                {return symbol(yytext(), sym.RETURN);}
<YYINITIAL> "record"                {return symbol(yytext(), sym.RECORD);}
<YYINITIAL> "sizeof"                {return symbol(yytext(), sym.SIZE_OF);}
<YYINITIAL> "string"                {return symbol(yytext(), sym.STRING);}
<YYINITIAL> "switch"                {return symbol(yytext(), sym.SWITCH);}
<YYINITIAL> "true"                  {return symbol(yytext(), sym.BOOL_CONST);}
<YYINITIAL> "auto"                  {return symbol(yytext(), sym.AUTO);}
<YYINITIAL> "void"                  {return symbol(yytext(), sym.VOID);}
<YYINITIAL> "until"                 {return symbol(yytext(), sym.UNTIL);}
<YYINITIAL> "of"                    {return symbol(yytext(), sym.OF);}
<YYINITIAL> "foreach"               {return symbol(yytext(), sym.FOREACH);}
<YYINITIAL> "repeat"                {return symbol(yytext(), sym.REPEAT);}
<YYINITIAL> "in"                    {return symbol(yytext(), sym.IN);}

<YYINITIAL> "=="                    {return symbol(yytext(), sym.EQUAL_TO);}
<YYINITIAL> "!="                    {return symbol(yytext(), sym.NOT_EQUAL_TO);}
<YYINITIAL> "<="                    {return symbol(yytext(), sym.LESS_THAN_EQUAL_TO);}
<YYINITIAL> "<"                     {return symbol(yytext(), sym.LESS_THAN);}
<YYINITIAL> ">"                     {return symbol(yytext(), sym.GREATER_THAN);}
<YYINITIAL> ">="                    {return symbol(yytext(), sym.GREATER_THAN_EQUAL_TO);}
<YYINITIAL> "="                     {return symbol(yytext(), sym.EQUAL);}
<YYINITIAL> "not"                   {return symbol(yytext(), sym.NOT_COND);}
<YYINITIAL> "~"                     {return symbol(yytext(), sym.COMPLEMENT_BITWISE);}
<YYINITIAL> "&"                     {return symbol(yytext(), sym.AND_BITWISE);}
<YYINITIAL> "and"                   {return symbol(yytext(), sym.AND_COND);}
<YYINITIAL> "|"                     {return symbol(yytext(), sym.OR_BITWISE);}
<YYINITIAL> "or"                    {return symbol(yytext(), sym.OR_COND);}
<YYINITIAL> "^"                     {return symbol(yytext(), sym.XOR_BITWISE);}
<YYINITIAL> "*"                     {return symbol(yytext(), sym.TIMES);}
<YYINITIAL> "+"                     {return symbol(yytext(), sym.PLUS);}
<YYINITIAL> "-"                     {return symbol(yytext(), sym.MINUS);}
<YYINITIAL> "+="                    {return symbol(yytext(), sym.PLUS_EQUAL);}
<YYINITIAL> "-="                    {return symbol(yytext(), sym.MINUS_EQUAL);}
<YYINITIAL> "*="                    {return symbol(yytext(), sym.TIMES_EQUAL);}
<YYINITIAL> "/="                    {return symbol(yytext(), sym.DIVIDE_EQUAL);}
<YYINITIAL> "/"                     {return symbol(yytext(), sym.DIVIDE);}
<YYINITIAL> "%"                     {return symbol(yytext(), sym.MOD);}
<YYINITIAL> "("                     {return symbol(yytext(), sym.LPAREN);}
<YYINITIAL> ")"                     {return symbol(yytext(), sym.RPAREN);}
<YYINITIAL> "["                     {return symbol(yytext(), sym.LBRACE);}
<YYINITIAL> "]"                     {return symbol(yytext(), sym.RBRACE);}
<YYINITIAL> "."                     {return symbol(yytext(), sym.DOT);}
<YYINITIAL> ","                     {return symbol(yytext(), sym.COMMA);}
<YYINITIAL> ":"                     {return symbol(yytext(), sym.COLON);}
<YYINITIAL> ";"                     {return symbol(yytext(), sym.SEMICOLON);}
<YYINITIAL> "++"                    {return symbol(yytext(), sym.PREFIX_PLUS_PLUS);}
<YYINITIAL> "--"                    {return symbol(yytext(), sym.PREFIX_MINUS_MINUS);}

<YYINITIAL>{

/* identifiers */
{Identifier}                        {yybegin(POSTFIXID); return symbol(yytext(), sym.IDENTIFIER);}

<POSTFIXID>{
\+\+                                {return symbol(yytext(), sym.POSTFIX_PLUS_PLUS);}
--                                  {return symbol(yytext(), sym.POSTFIX_MINUS_MINUS);}
}

/* literals */
{DecIntegerLiteral}                 {return symbol(yytext(), sym.INT_CONST);}
{HexIntegerLiteral}                 {return symbol(yytext(), sym.INT_CONST);}
{FloatLiteral}                      {return symbol(yytext(), sym.REAL_CONST);}
{FloatScientificLiteral}            {return symbol(yytext(), sym.REAL_CONST);}
\"                                  {string.setLength(0); string.append(yytext()); yybegin(STRING);}
\'                                  {string.setLength(0); string.append(yytext()); yybegin(CHAR);}

/* comments */
{Comment}                           {}

/* whitespace */
{NONNEWLINE_WHITE_SPACE_CHAR}       {}
{NEWLINE}                           {}

}

<STRING>{
\"                                  {yybegin(YYINITIAL); string.append(yytext()); return symbol(string.toString(),sym.STRING_CONST);}
[^\n\r\"\\]                         {string.append(yytext());}
\\                                  {yybegin(SPECIALCHARSTR); return symbol(string.toString(), sym.STRING_CONST);}
}

<SPECIALCHARSTR>{
t                                   {yybegin(STRING); string.setLength(0); return symbol("\\t", sym.CHAR_CONST);}
n                                   {yybegin(STRING); string.setLength(0); return symbol("\\n", sym.CHAR_CONST);}
r                                   {yybegin(STRING); string.setLength(0); return symbol("\\r", sym.CHAR_CONST);}
\"                                  {yybegin(STRING); string.setLength(0); return symbol("\\\"", sym.CHAR_CONST);}
\'                                  {yybegin(STRING); string.setLength(0); return symbol("\\\'", sym.CHAR_CONST);}
\\                                  {yybegin(STRING); string.setLength(0); return symbol("\\\\", sym.CHAR_CONST);}
[^]                                 {throw new Error("Illegal character <"+yytext()+">"+" Line: " + yyline + ", Column: " + yycolumn);}
}

<CHAR>{
[^\n\r\\\']                         {string.append(yytext()); yybegin(ENDCHAR);}
\\t                                 {string.append("\\t"); yybegin(SPECIALCHAR);}
\\n                                 {string.append("\\n"); yybegin(SPECIALCHAR);}
\\r                                 {string.append("\\r"); yybegin(SPECIALCHAR);}
\\\"                                {string.append("\\\""); yybegin(SPECIALCHAR);}
\\\'                                {string.append("\\\'"); yybegin(SPECIALCHAR);}
\\\\                                {string.append("\\\\"); yybegin(SPECIALCHAR);}
}

<SPECIALCHAR>{
\'                                  {yybegin(YYINITIAL); string.append(yytext()); return symbol(string.toString(), sym.CHAR_CONST);}
[^]                                 {throw new Error("Illegal character <"+yytext()+">"+" Line: " + yyline + ", Column: " + yycolumn);}
}

<ENDCHAR>{
\'                                  {yybegin(YYINITIAL); string.append(yytext()); return symbol(string.toString(), sym.CHAR_CONST);}
[^]                                 {throw new Error("Illegal character <"+yytext()+">"+" Line: " + yyline + ", Column: " + yycolumn);}
}

/* error fallback */
[^]                                 {return symbol(yytext(), sym.error);}