step(1). step(2).
next(1, 2). next(2, 3).
time(1). time(2). time(3).
status(holding). status(dry).

-holds(X, 1) :- status(X), not holds(X, 1).
holds(X, T2) :- holds(X, T1), next(T1, T2), not -holds(X, T2), step(T1).
-holds(X, T2) :- -holds(X, T1), next(T1, T2), not holds(X, T2), step(T1).
action(pick, T) | action(bake, T) :- step(T).
:- action(pick, X), action(bake, X).

holds(holding, Y) :- holds(dry, X), -holds(holding, X), action(pick, X), next(X, Y), step(X). [3]
holds(holding, Y) :- -holds(dry, X), -holds(holding, X), action(pick, X), next(X, Y), step(X). [-1]
holds(dry, Y) :- action(bake, X), next(X, Y), step(X). [3]

-holds(holding, 1).
holds(dry, 1). [-1]

success :- holds(holding, 3).
goal :- K(0.8,1] success.
:- not goal.
:- K[0,1) action(A, S), action(A, S).