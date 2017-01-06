/**
 * 概率认知逻辑语言的词法语法定义
 * 张舒韬
 * 2017-01-06
 */

grammar Pelp;

/**
 * 词法定义
 */

//左圆括号
LPAREN : '(';
//右圆括号
RPAREN : ')';
//左方括号
LSBRACK : '[';
//右方括号
RSBRACK : ']';
//左花括号
LCBRACK : '{';
//右花括号
RCBRACK : '}';

//逗号
COMMA : ',';
//点号
DOT : '.';
// 竖线
VBAR : '|';
//冒号
COLON : ':';
//减号、经典否定关键字
MINUS : '-';
// 弱否定
NAF : 'not';
// 推理符号
IF : ':-';
// 主观模态词
KNOW : 'K';

//小数(点表示法)
DECIMAL : MINUS? ([1-9][0-9]* | ZERO ) DOT [0-9]+;
//正整数
POSITIVE_INT : [1-9][0-9]*;
//0
ZERO : '0';
//字符串
STRING : '"' ('\\"'|~('"'))* '"';

//普通谓词名，含中文
PREDICATE : [a-zA-Z] [a-zA-Z0-9_-]*;
//变量
VAR : [A-Z] [A-Za-z0-9_]*;

//空白字符或换行符
WS : ( ' ' | '\t' | '\n' | '\r')+ -> skip;
// 注释
LINE_COMMENT : '%' ~ ('\n' | '\r') * '\r'? '\n' {skip();} ;

/**
 * 语法定义
 **/

//整数
integer : MINUS? (POSITIVE_INT | ZERO);
//小数
decimal : (DECIMAL | integer);
//字符串
string : STRING;

//谓词
predicate : PREDICATE;
// 变量
var : VAR | KNOW;
// 谓词/函数参数
param : (integer | decimal | string | var);

// 客观字
objective_literal : NAF? MINUS? predicate (LPAREN (param (COMMA param)*)? RPAREN)?;
// 主观字
subjective_literal : KNOW (LPAREN | LCBRACK) decimal COMMA decimal (RPAREN | RCBRACK) objective_literal;

// 规则首部
rule_head : objective_literal (VBAR objective_literal);
// 规则体部
rule_body : (objective_literal | subjective_literal) (COMMA (objective_literal | subjective_literal))*;

hard_rule : rule_head DOT                # fact_rule
          | IF rule_body DOT             # constrain_rule
          | rule_head IF rule_body DOT   # normal_rule;

soft_rule : hard_rule LPAREN decimal RPAREN;

program : (soft_rule | hard_rule)*;
