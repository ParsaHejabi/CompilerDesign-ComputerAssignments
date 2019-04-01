class Symbol{
    public int id;
    public String string;

    Symbol(String string, int id){
        this.id = id;
        this.string = string;
    }
}

%%

%class CScanner
%unicode
%line
%column

%function CScannerFunction
%type Symbol

%{
    StringBuffer string = new StringBuffer();
%}

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
WHITE_SPACE_CHAR = [\n\r\ \t\b\012]
WhiteSpace = {NONNEWLINE_WHITE_SPACE_CHAR} | {NEWLINE} | {WHITE_SPACE_CHAR}

/* identifiers */
//All variable names must begin with a letter of the alphabet or an underscore( _ ).
Identifier = ({ALPHA}|_)({ALPHA}|{DIGIT}|_)*

/* comments */
InputCharacter = [^\r\n]
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {NEWLINE}?
CommentContent       = ( [^*] | \*+ [^/*] )*

%state STRING
%state CHAR
%state ENDCHAR

%%

/* keywords */
<YYINITIAL> "auto"                  {return new Symbol(yytext(), 1);}
<YYINITIAL> "int"                   {return new Symbol(yytext(), 1);}
<YYINITIAL> "const"                 {return new Symbol(yytext(), 1);}
<YYINITIAL> "short"                 {return new Symbol(yytext(), 1);}
<YYINITIAL> "break"                 {return new Symbol(yytext(), 1);}
<YYINITIAL> "long"                  {return new Symbol(yytext(), 1);}
<YYINITIAL> "continue"              {return new Symbol(yytext(), 1);}
<YYINITIAL> "signed"                {return new Symbol(yytext(), 1);}
<YYINITIAL> "case"                  {return new Symbol(yytext(), 1);}
<YYINITIAL> "register"              {return new Symbol(yytext(), 1);}
<YYINITIAL> "default"               {return new Symbol(yytext(), 1);}
<YYINITIAL> "sizeof"                {return new Symbol(yytext(), 1);}
<YYINITIAL> "char"                  {return new Symbol(yytext(), 1);}
<YYINITIAL> "return"                {return new Symbol(yytext(), 1);}
<YYINITIAL> "do"                    {return new Symbol(yytext(), 1);}
<YYINITIAL> "static"                {return new Symbol(yytext(), 1);}
<YYINITIAL> "double"                {return new Symbol(yytext(), 1);}
<YYINITIAL> "struct"                {return new Symbol(yytext(), 1);}
<YYINITIAL> "float"                 {return new Symbol(yytext(), 1);}
<YYINITIAL> "unsigned"              {return new Symbol(yytext(), 1);}
<YYINITIAL> "else"                  {return new Symbol(yytext(), 1);}
<YYINITIAL> "switch"                {return new Symbol(yytext(), 1);}
<YYINITIAL> "for"                   {return new Symbol(yytext(), 1);}
<YYINITIAL> "void"                  {return new Symbol(yytext(), 1);}
<YYINITIAL> "enum"                  {return new Symbol(yytext(), 1);}
<YYINITIAL> "typedef"               {return new Symbol(yytext(), 1);}
<YYINITIAL> "goto"                  {return new Symbol(yytext(), 1);}
<YYINITIAL> "volatile"              {return new Symbol(yytext(), 1);}
<YYINITIAL> "extern"                {return new Symbol(yytext(), 1);}
<YYINITIAL> "union"                 {return new Symbol(yytext(), 1);}
<YYINITIAL> "if"                    {return new Symbol(yytext(), 1);}
<YYINITIAL> "while"                 {return new Symbol(yytext(), 1);}

<YYINITIAL>{

/* identifiers */
{Identifier}                        {return new Symbol(yytext(), 2);}

/* literals */
{DecIntegerLiteral}                 {return new Symbol(yytext(), 3);}
{HexIntegerLiteral}                 {return new Symbol(yytext(), 3);}
{FloatLiteral}                      {return new Symbol(yytext(), 4);}
{FloatScientificLiteral}            {return new Symbol(yytext(), 4);}
\"                                  {string.setLength(0); yybegin(STRING);}
\'                                  {string.setLength(0); yybegin(CHAR);}

/* comments */
{Comment}                           {return new Symbol(yytext(), 7);}

/* whitespace */
{NONNEWLINE_WHITE_SPACE_CHAR}       {return new Symbol(yytext(), 8);}
{NEWLINE}                           {return new Symbol(yytext(), 9);}

}

<STRING>{
\"                                  {yybegin(YYINITIAL); return new Symbol(string.toString(), 5);}
[^\n\r\"\\]+                        {string.append(yytext());}
\\t                                 {string.append('\t');}
\\n                                 {string.append('\n');}
\\r                                 {string.append('\r');}
\\\"                                {string.append('\"');}
\\                                  {string.append('\\');}
}

<CHAR>{
[^\n\r\\\']                         {string.append(yytext()); yybegin(ENDCHAR);}
\\t                                 {string.append('\t'); yybegin(ENDCHAR);}
\\n                                 {string.append('\n'); yybegin(ENDCHAR);}
\\r                                 {string.append('\r'); yybegin(ENDCHAR);}
\\\"                                {string.append('\"'); yybegin(ENDCHAR);}
\\                                  {string.append('\\'); yybegin(ENDCHAR);}
}

<ENDCHAR>{
\'                                  {yybegin(YYINITIAL); return new Symbol(string.toString(), 6);}
}

/* error fallback */
[^]                                 {throw new Error("Illegal character <"+yytext()+">");}