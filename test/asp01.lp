fly(X) :- bird(X), not -fly(X).
-fly(X) :- bird(X), not fly(X).
-fly(X) :- penguin(X).
:- fly(tweety), -fly(tweety).
:- fly(tux), -fly(tux).
fly(tux).
