import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
%%

%class Scanner
%unicode
%cup
%line
%column
%char

%{
     StringBuffer string = new StringBuffer();
     public Scanner(java.io.Reader in, ComplexSymbolFactory sf){
         this(in);
         symbolFactory = sf;
     }
     ComplexSymbolFactory symbolFactory;

     private Symbol symbol(String name, int sym) {
         return symbolFactory.newSymbol(name, sym, new Location(yyline+1,yycolumn+1,yychar), new Location(yyline+1,yycolumn+yylength(),yychar+yylength()));
     }

     private Symbol symbol(String name, int sym, Object val) {
         Location left = new Location(yyline+1,yycolumn+1,yychar);
         Location right= new Location(yyline+1,yycolumn+yylength(), yychar+yylength());
         return symbolFactory.newSymbol(name, sym, left, right,val);
     }
     private Symbol symbol(String name, int sym, Object val,int buflength) {
         Location left = new Location(yyline+1,yycolumn+yylength()-buflength,yychar+yylength()-buflength);
         Location right= new Location(yyline+1,yycolumn+yylength(), yychar+yylength());
         return symbolFactory.newSymbol(name, sym, left, right,val);
     }
     private void error(String message) {
         System.out.println("Error at line "+(yyline+1)+", column "+(yycolumn+1)+" : "+message);
     }
%}

%eofval{
     return symbolFactory.newSymbol("EOF", ParserSym.EOF, new Location(yyline+1,yycolumn+1,yychar), new Location(yyline+1,yycolumn+1,yychar+1));
%eofval}
%eofclose

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
WhiteSpace = {NONNEWLINE_WHITE_SPACE_CHAR} | {NEWLINE}

/* identifiers */
//All variable names must begin with a letter of the alphabet or an underscore( _ ).
Identifier = ({ALPHA}|_)({ALPHA}|{DIGIT}|_)*

/* comments */
InputCharacter = [^\r\n]
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment   = "/#" [^#] ~"#/" | "/#" "#"+ "/"
EndOfLineComment     = "##" {InputCharacter}*

%state STRING
%state CHAR
%state ENDCHAR
%state SPECIALCHARSTR
%state SPECIALCHAR
%state POSTFIXID

%%

/* keywords */
<YYINITIAL> "begin"                 {return symbol(yytext(), ParserSym.BEGIN);}
<YYINITIAL> "bool"                  {return symbol(yytext(), ParserSym.BOOL);}
<YYINITIAL> "break"                 {return symbol(yytext(), ParserSym.BREAK);}
<YYINITIAL> "case"                  {return symbol(yytext(), ParserSym.CASE);}
<YYINITIAL> "char"                  {return symbol(yytext(), ParserSym.CHAR);}
<YYINITIAL> "const"                 {return symbol(yytext(), ParserSym.CONST);}
<YYINITIAL> "continue"              {return symbol(yytext(), ParserSym.CONTINUE);}
<YYINITIAL> "default"               {return symbol(yytext(), ParserSym.DEFAULT);}
<YYINITIAL> "double"                {return symbol(yytext(), ParserSym.DOUBLE);}
<YYINITIAL> "else"                  {return symbol(yytext(), ParserSym.ELSE);}
<YYINITIAL> "end"                   {return symbol(yytext(), ParserSym.END);}
<YYINITIAL> "extern"                {return symbol(yytext(), ParserSym.EXTERN);}
<YYINITIAL> "false"                 {return symbol(yytext(), ParserSym.BOOL_CONST);}
<YYINITIAL> "function"              {return symbol(yytext(), ParserSym.FUNCTION);}
<YYINITIAL> "float"                 {return symbol(yytext(), ParserSym.FLOAT);}
<YYINITIAL> "for"                   {return symbol(yytext(), ParserSym.FOR);}
<YYINITIAL> "if"                    {return symbol(yytext(), ParserSym.IF);}
<YYINITIAL> "int"                   {return symbol(yytext(), ParserSym.INT);}
<YYINITIAL> "long"                  {return symbol(yytext(), ParserSym.LONG);}
<YYINITIAL> "return"                {return symbol(yytext(), ParserSym.RETURN);}
<YYINITIAL> "record"                {return symbol(yytext(), ParserSym.RECORD);}
<YYINITIAL> "sizeof"                {return symbol(yytext(), ParserSym.SIZE_OF);}
<YYINITIAL> "string"                {return symbol(yytext(), ParserSym.STRING);}
<YYINITIAL> "switch"                {return symbol(yytext(), ParserSym.SWITCH);}
<YYINITIAL> "true"                  {return symbol(yytext(), ParserSym.BOOL_CONST);}
<YYINITIAL> "auto"                  {return symbol(yytext(), ParserSym.AUTO);}
<YYINITIAL> "void"                  {return symbol(yytext(), ParserSym.VOID);}
<YYINITIAL> "until"                 {return symbol(yytext(), ParserSym.UNTIL);}
<YYINITIAL> "of"                    {return symbol(yytext(), ParserSym.OF);}
<YYINITIAL> "foreach"               {return symbol(yytext(), ParserSym.FOREACH);}
<YYINITIAL> "repeat"                {return symbol(yytext(), ParserSym.REPEAT);}
<YYINITIAL> "in"                    {return symbol(yytext(), ParserSym.IN);}

<YYINITIAL> "=="                    {return symbol(yytext(), ParserSym.EQUAL_TO);}
<YYINITIAL> "!="                    {return symbol(yytext(), ParserSym.NOT_EQUAL_TO);}
<YYINITIAL> "<="                    {return symbol(yytext(), ParserSym.LESS_THAN_EQUAL_TO);}
<YYINITIAL> "<"                     {return symbol(yytext(), ParserSym.LESS_THAN);}
<YYINITIAL> ">"                     {return symbol(yytext(), ParserSym.GREATER_THAN);}
<YYINITIAL> ">="                    {return symbol(yytext(), ParserSym.GREATER_THAN_EQUAL_TO);}
<YYINITIAL> "="                     {return symbol(yytext(), ParserSym.EQUAL);}
<YYINITIAL> "not"                   {return symbol(yytext(), ParserSym.NOT_EXPR);}
<YYINITIAL> "~"                     {return symbol(yytext(), ParserSym.TILDE);}
<YYINITIAL> "&"                     {return symbol(yytext(), ParserSym.AND_BITWISE);}
<YYINITIAL> "and"                   {return symbol(yytext(), ParserSym.AND_COND);}
<YYINITIAL> "or"                    {return symbol(yytext(), ParserSym.OR_COND);}
<YYINITIAL> "|"                     {return symbol(yytext(), ParserSym.OR_BITWISE);}
<YYINITIAL> "^"                     {return symbol(yytext(), ParserSym.XOR_BITWISE);}
<YYINITIAL> "*"                     {return symbol(yytext(), ParserSym.TIMES);}
<YYINITIAL> "+"                     {return symbol(yytext(), ParserSym.PLUS);}
<YYINITIAL> "-"                     {return symbol(yytext(), ParserSym.MINUS);}
<YYINITIAL> "+="                    {return symbol(yytext(), ParserSym.PLUS_EQUAL);}
<YYINITIAL> "-="                    {return symbol(yytext(), ParserSym.MINUS_EQUAL);}
<YYINITIAL> "*="                    {return symbol(yytext(), ParserSym.TIMES_EQUAL);}
<YYINITIAL> "/="                    {return symbol(yytext(), ParserSym.DIVIDE_EQUAL);}
<YYINITIAL> "/"                     {return symbol(yytext(), ParserSym.DIVIDE);}
<YYINITIAL> "%"                     {return symbol(yytext(), ParserSym.MOD);}
<YYINITIAL> "("                     {return symbol(yytext(), ParserSym.LPAREN);}
<YYINITIAL> ")"                     {return symbol(yytext(), ParserSym.RPAREN);}
<YYINITIAL> "."                     {return symbol(yytext(), ParserSym.DOT);}
<YYINITIAL> ","                     {return symbol(yytext(), ParserSym.COMMA);}
<YYINITIAL> ":"                     {return symbol(yytext(), ParserSym.COLON);}
<YYINITIAL> ";"                     {return symbol(yytext(), ParserSym.SEMICOLON);}
<YYINITIAL> "["                     {return symbol(yytext(), ParserSym.LBRACKET);}
<YYINITIAL> "]"                     {return symbol(yytext(), ParserSym.RBRACKET);}
<YYINITIAL> "++"                    {return symbol(yytext(), ParserSym.PREFIX_PLUS_PLUS);}
<YYINITIAL> "--"                    {return symbol(yytext(), ParserSym.PREFIX_MINUS_MINUS);}

<YYINITIAL>{
/* identifiers */
//{Identifier}                        {yybegin(POSTFIXID); return symbol(yytext(), ParserSym.IDENTIFIER);}
{Identifier}                        {return symbol("IDENTIFIER", ParserSym.IDENTIFIER, yytext());}

/* literals */
{DecIntegerLiteral}                 {return symbol(yytext(), ParserSym.INT_CONST);}
{HexIntegerLiteral}                 {return symbol(yytext(), ParserSym.INT_CONST);}
{FloatLiteral}                      {return symbol(yytext(), ParserSym.REAL_CONST);}
{FloatScientificLiteral}            {return symbol(yytext(), ParserSym.REAL_CONST);}
\"                                  {string.setLength(0); string.append(yytext()); yybegin(STRING);}
\'                                  {string.setLength(0); string.append(yytext()); yybegin(CHAR);}

/* comments */
{Comment}                           {}

/* whitespace */
{WhiteSpace}                        {}
}

//<POSTFIXID>{
//\+\+                                {return symbol(yytext(), ParserSym.POSTFIX_PLUS_PLUS);}
//--                                  {return symbol(yytext(), ParserSym.POSTFIX_MINUS_MINUS);}
//[^]                                 {yybegin(YYINITIAL);}
//}

<STRING>{
\"                                  {string.append(yytext()); yybegin(YYINITIAL); return symbol(string.toString(),ParserSym.STRING_CONST);}
[^\n\r\"\\]                         {string.append(yytext());}
\\                                  {yybegin(SPECIALCHARSTR);}
}

<SPECIALCHARSTR>{
t                                   {string.append("\\t"); yybegin(STRING); return symbol("\\t", ParserSym.CHAR_CONST);}
n                                   {string.append("\\n"); yybegin(STRING); return symbol("\\n", ParserSym.CHAR_CONST);}
r                                   {string.append("\\r"); yybegin(STRING); return symbol("\\r", ParserSym.CHAR_CONST);}
\"                                  {string.append("\\\""); yybegin(STRING); return symbol("\\\"", ParserSym.CHAR_CONST);}
\'                                  {string.append("\\\'"); yybegin(STRING); return symbol("\\\'", ParserSym.CHAR_CONST);}
\\                                  {string.append("\\\\"); yybegin(STRING); return symbol("\\\\", ParserSym.CHAR_CONST);}
[^]                                 {error("Illegal character <"+ yytext()+">");}
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
\'                                  {string.append(yytext()); yybegin(YYINITIAL); return symbol(string.toString(), ParserSym.CHAR_CONST);}
[^]                                 {error("Illegal character <"+ yytext()+">");}
}

<ENDCHAR>{
\'                                  {string.append(yytext()); yybegin(YYINITIAL); return symbol(string.toString(), ParserSym.CHAR_CONST);}
[^]                                 {error("Illegal character <"+ yytext()+">");}
}

/* error fallback */
[^]                                 {error("Illegal character <"+ yytext()+">");}