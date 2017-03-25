innocent(X) :- K(0,1] not guilty(X), suspect(X).
warrant(X) :- K[0.5, 1] guilty(X), suspect(X).

guilty(X) :- witness(X), suspect(X).
guilty(X) :- not alibi(X), suspect(X). [1]
guilty(X) :- motivation(X), suspect(X). [1]
guilty(X) | not guilty(X) :- suspect(X).

suspect(tom).
motivation(tom).