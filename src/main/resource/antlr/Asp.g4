/**
 * 概率认知逻辑语言的词法语法定义
 * 张舒韬
 * 2017-01-06
 */

grammar Asp;

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
// 弱约束符号
SOFT_IF : ':~';
// 弱约束等级符号
AT : '@';

//小数(点表示法)
DECIMAL : MINUS? ([1-9][0-9]* | ZERO ) DOT [0-9]+;
//正整数
POSITIVE_INT : [1-9][0-9]*;
//0
ZERO : '0';
//字符串
STRING : '"' ('\\"'|~('"'))* '"';

//普通谓词名，含中文
PREDICATE : [a-z_][a-zA-Z0-9_]*;
//变量
VAR : [A-Z][A-Za-z0-9_]*;

//空白字符或换行符
WS : ( ' ' | '\t' | '\n' | '\r')+ -> skip;
// 注释
LINE_COMMENT : '%' ~ ('\n' | '\r') * '\r'? '\n' {skip();} ;

/**
 * 语法定义
 **/

//整数
integer : MINUS? (POSITIVE_INT | ZERO);
//字符串
string : STRING;

//谓词
predicate : PREDICATE;
// 变量
var : VAR;
// 谓词/函数参数
param : (integer | string | predicate) # const_param
      | var                            # var_param;

// 客观字
literal : (NAF)* MINUS? predicate (LPAREN (param (COMMA param)*)? RPAREN)?;

// 规则首部
rule_head : literal (VBAR literal)*;
// 规则体部
rule_body : literal (COMMA literal)*;

reasoning_rule : rule_head DOT                                                              # fact_rule
               | IF rule_body DOT                                                           # constrain_rule
               | rule_head IF rule_body DOT                                                 # normal_rule
               | SOFT_IF rule_body DOT LSBRACK integer (AT integer)? (COMMA param)* RSBRACK # soft_constrain;

// ASP程序
program : reasoning_rule*;

// 回答集
answer_set : literal*;