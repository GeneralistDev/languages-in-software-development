% Bitwise logic gates built using NAND gate combinations

% Nand gate specification
c_nand(t,t,f).
c_nand(t,f,t).
c_nand(f,t,t).
c_nand(f,f,t).

% Bitwise AND
c_and(X,Y,Z) :-     c_nand(X,Y,R),
					c_nand(R,R,Z).

% Bitwise NOR
c_nor(X,Y,Z) :-     c_nand(X,X,X1),
					c_nand(Y,Y,Y1),
					c_nand(X1,Y1,R),
					c_nand(R,R,Z).

% Bitwise OR
c_or(X,Y,Z) :-      c_nand(X,X,X1),
					c_nand(Y,Y,Y1),
					c_nand(X1,Y1,Z).

% Bitwise XOR
c_xor(X,Y,Z) :-     c_nand(X,Y,R1),
					c_nand(X,R1,A),
					c_nand(Y,R1,B),
					c_nand(A,B,Z).

% Bitwise XNOR
c_xnor(X,Y,Z) :-	c_nand(X,Y,R1),
					c_nand(X,R1,A),
					c_nand(Y,R1,B),
					c_nand(A,B,C),
					c_nand(C,C,Z).

