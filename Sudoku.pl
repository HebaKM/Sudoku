%% The module "clpfd", constraint logic programming over finite domains,
%% is needed to specify the range of numbers to search
?- use_module(library(clpfd)).


sudoku(Rows):-
    % returns true if the integer represent the number of elements in a list
    length(Rows, 9),  % ensures there are 9 rows in the list

    % length_/2 is the goal. maplist makes sure that the goal is applied on each element in the list
    maplist(length_(9), Rows),

    % concatenates list of lists
    append(Rows, Vs),  % combined all Rows(List of Lists) into the list Vs

    % makes sure that the elements in a list are under a specific domain
    Vs ins 1..9,  % ensures that the elements of list Vs are numbers between 1-9

    % all_distinct is the goal.
    maplist(all_distinct, Rows),  % ensures that each row is distinct.

    % transpose/2 changes rows into columns and columns into rows.
    transpose(Rows, Columns),  % flips the matrix

    maplist(all_distinct, Columns),  % ensures that each column is distinct.

    Rows = [A,B,C,D,E,F,G,H,I],  % create variables A-I for each row

    block(A, B, C),  % make sure all values in these three rows (three 3x3 blocks) are distinct
    block(D, E, F),  % and these rows/blocks
    block(G, H, I).  % and these rows/blocks

length_(L, Ls) :- length(Ls, L). % ensures there are 9 elements in the list


% blocks/3 ensures that each block (3x3 grid) contains only distinct values
block([], [], []).
block([A,B,C|Bs1], [D,E,F|Bs2], [G,H,I|Bs3]) :-
        all_distinct([A,B,C,D,E,F,G,H,I]),
        block(Bs1, Bs2, Bs3).

% Sudoku easy level template
problem(1,[['_','_','_',8,'_',9,'_','_',5],
            ['_','_',5,'_',1,4,2,'_',7],
            [7,'_','_',3,'_','_','_',4,'_'],
            ['_','_','_',9,8,'_',6,'_',2],
            [1,'_',2,'_',6,'_',4,'_',8],
            [8,'_',6,'_',5,2,'_','_','_'],
            ['_',2,'_','_','_',6,'_','_',1],
            [6,'_',1,2,9,'_',5,'_','_'],
            [4,'_','_',1,'_',8,'_','_','_']]).

% Sudoku medium level template
problem(2,[['_',4,'_','_',9,'_','_',3,'_'],
            ['_','_',9,6,'_','_','_',2,5],
            [3,'_','_','_','_',5,'_',9,'_'],
            ['_','_',8,'_',2,'_',9,7,'_'],
            ['_','_','_',3,'_',7,'_','_','_'],
            ['_',7,3,'_',5,'_',6,'_','_'],
            ['_',9,'_',1,'_','_','_','_',4],
            [5,3,'_','_','_',9,2,'_','_'],
            ['_',1,'_','_',4,'_','_',6,'_']]).

% Sudoku hard level template
problem(3,[['_','_','_','_','_','_','_','_','_'],
            ['_','_','_','_','_',3,'_',8,5],
            ['_','_',1,'_',2,'_','_','_','_'],
            ['_','_','_',5,'_',7,'_','_','_'],
            ['_','_',4,'_','_','_',1,'_','_'],
            ['_',9,'_','_','_','_','_','_','_'],
            [5,'_','_','_','_','_','_',7,3],
            ['_','_',2,'_',1,'_','_','_','_'],
            ['_','_','_','_',4,'_','_','_',9]]).


solve_problem(Rows) :-
        sudoku(Rows),  % solves the puzzle
        maplist(writeln, Rows).  % show the solution (writeln, i.e., println each row)

% For prolog interpreter.
% -------------------------------

% Starts game
start:-
    nl, write(''),nl,
    write('Welcome to the Sudoku Game'),
    welcome_Msg.

% asks user to choose level
welcome_Msg:-
    nl, write(''),nl,
    write('Please choose a level (end to exit):'), nl,
    write('------------------------'), nl,
    write('1 - Easy'), nl,
    write('2 - Medium'), nl,
    write('3 - Hard'), nl, nl,
    write('-->> Enter your choice: '),
    read(X),
    X \= end,
    display(X),
    solve,
    fin.

% displays problem for user to solve
display(X):-
    problem(X,Rows),
    maplist(writeln, Rows),
    nl.

% reads user solution
solve:-
    nl,
    write('Enter your answer:'),
    read(L),nl,
    solve_problem(L),
    welcome_Msg.

% ends game
fin:-
    nl,
    write('===< End >===').

