class Symbol{
    public String string;
    Symbol(String string){
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
FloatLiteral = (([0-9]*).([0-9]+))|(([0-9]+).([0-9]*))
FloatScientificLiteral = ([0-9]+)(e|E)((\+|-)?)([0-9]+)

/* whitespace */
NONNEWLINE_WHITE_SPACE_CHAR = [\ \t\b\012]
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
<YYINITIAL> "auto"          {return new Symbol(yytext());}
<YYINITIAL> "int"           {return new Symbol(yytext());}
<YYINITIAL> "const"         {return new Symbol(yytext());}
<YYINITIAL> "short"         {return new Symbol(yytext());}
<YYINITIAL> "break"         {return new Symbol(yytext());}
<YYINITIAL> "long"          {return new Symbol(yytext());}
<YYINITIAL> "continue"      {return new Symbol(yytext());}
<YYINITIAL> "signed"        {return new Symbol(yytext());}
<YYINITIAL> "case"          {return new Symbol(yytext());}
<YYINITIAL> "register"      {return new Symbol(yytext());}
<YYINITIAL> "default"       {return new Symbol(yytext());}
<YYINITIAL> "sizeof"        {return new Symbol(yytext());}
<YYINITIAL> "char"          {return new Symbol(yytext());}
<YYINITIAL> "return"        {return new Symbol(yytext());}
<YYINITIAL> "do"            {return new Symbol(yytext());}
<YYINITIAL> "static"        {return new Symbol(yytext());}
<YYINITIAL> "double"        {return new Symbol(yytext());}
<YYINITIAL> "struct"        {return new Symbol(yytext());}
<YYINITIAL> "float"         {return new Symbol(yytext());}
<YYINITIAL> "unsigned"      {return new Symbol(yytext());}
<YYINITIAL> "else"          {return new Symbol(yytext());}
<YYINITIAL> "switch"        {return new Symbol(yytext());}
<YYINITIAL> "for"           {return new Symbol(yytext());}
<YYINITIAL> "void"          {return new Symbol(yytext());}
<YYINITIAL> "enum"          {return new Symbol(yytext());}
<YYINITIAL> "typedef"       {return new Symbol(yytext());}
<YYINITIAL> "goto"          {return new Symbol(yytext());}
<YYINITIAL> "volatile"      {return new Symbol(yytext());}
<YYINITIAL> "extern"        {return new Symbol(yytext());}
<YYINITIAL> "union"         {return new Symbol(yytext());}
<YYINITIAL> "if"            {return new Symbol(yytext());}
<YYINITIAL> "while"         {return new Symbol(yytext());}

<YYINITIAL>{

/* identifiers */
{Identifier}                        {return new Symbol(yytext());}

/* literals */
{DecIntegerLiteral}                 {return new Symbol(yytext());}
{HexIntegerLiteral}                 {return new Symbol(yytext());}
{FloatLiteral}                      {return new Symbol(yytext());}
{FloatScientificLiteral}            {return new Symbol(yytext());}
\"                                  {string.setLength(0); yybegin(STRING);}
\'                                  {string.setLength(0); yybegin(CHAR);}

/* comments */
{Comment}                           {}

/* whitespace */
{WhiteSpace}                        {}

}

<STRING>{
\"                                  {yybegin(YYINITIAL); return new Symbol(string.toString());}
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
\'                                  {yybegin(YYINITIAL); return new Symbol(string.toString());}
}

/* error fallback */
[^]                                 {throw new Error("Illegal character <"+yytext()+">");}