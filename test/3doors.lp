% 每个盒子都以相同的可能性存在奖品
has_key(X) :- box(X). [1]

% 选手选择每个盒子的可能性都相同
select(X) :- box(X). [1]

% 主持人以相同的可能性打开未被选择并且没有奖品的盒子
cannot_open(X) :- select(X).
cannot_open(X) :- has_key(X).
open(X) :- box(X), not cannot_open(X). [1]

% select, open, has_key 有且只能有一个
-has_key(Y) :- has_key(X), box(Y), X!=Y.
-select(Y) :- select(X), box(Y), X!=Y.
-open(Y) :- open(X), box(Y), X!=Y.

:- box(X), not has_key(X), not -has_key(X).
:- box(X), not open(X), not -open(X).
:- box(X), not select(X), not -select(X).

can_switch(X) :- box(X), not select(X), not open(X).

win_stay :- select(X), has_key(X).
win_switch :- switch(X), has_key(X).

% 选手改变选择
switch(X) :- #PL(win_stay, win_switch), can_switch(X), select(Y).

% 改变选择只能改一次，且一定改一次
-switch(Y) :- switch(X), can_switch(Y), X!=Y.
:- can_switch(X), not switch(X), not -switch(X).

% 盒子数量可以增加
box(1).
box(2).
box(3).