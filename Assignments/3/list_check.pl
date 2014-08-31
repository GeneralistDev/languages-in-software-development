% List length predicate
list_length([], 0).
list_length([_|T], N) :- list_length(T,M), N is M+1.

% List concatenation predicate
list_concatenation([],Xs,Xs).
list_concatenation([H|Xs],Ys,[H|Zs]) :- list_concatenation(Xs,Ys,Zs).

% List equality predicate
equal([],[]) :- true.
equal([Xhead|Xtail],[Yhead|Ytail]) :- Xhead =:= Yhead, equal(Xtail, Ytail). 

% Check that concatenating the empty set to Xs equals Xs
checkA(Xs) :- list_concatenation([],Xs,R), equal(R,Xs).

% Check that concatenating two strings equals the length of the sum
% of individual lengths of the substrings
checkB(Xs, Ys) :-	list_concatenation(Xs,Ys,Rs),
					list_length(Rs, Rl),
					list_length(Xs, Xl),
					list_length(Ys, Yl),
					Rl =:= Xl + Yl.
