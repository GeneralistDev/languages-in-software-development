
% Bubble list from left to right
% 
% LOGIC: 
%	Check the head against the head of the tail
%	swapping the heads if the first head is bigger than the second head.
%	recursively bubble the remaining tail with the correct swapped head.
%
bubble([],[]).
bubble([X],[X]).
bubble([X,Y|T], [Y|Z]) :- X > Y, bubble([X|T], Z).
bubble([X,Y|T], [X|Z]) :- X =< Y, bubble([Y|T], Z).

% Separate the head and the tail of the list
remove([H|T],H,T).

% Bubble sort the whole list
%
% LOGIC:
%	Bubble the list, reverse it and remove the head.
%	Bubble the tail of the resulting list. Repeat until all parts are sorted.
bubble_sort([],[]). 
bubble_sort([X], [X]).
bubble_sort(X,[H|L]) :- bubble(X, Y),
						reverse(Y, Z), 
						remove(Z,H,T), 
						reverse(T,C), 
						bubble_sort(C, L). 

