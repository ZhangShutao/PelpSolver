p | q | r | s | t.
p :- q.
p :- r.
p :- s.
p :- t.
q | r :- p.
s :- p, q, t.
s :- p, r, t.
t :- p, q, s.
t :- p, r, s.
s :- K[0, 1) not t.