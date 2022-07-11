# MinMax-agent-and-AlphaBeta-agent
# Project description: 
    In this project I program an agent that uses Minimax and alpha-beta pruning to play the game of Othello. I do not 
    implement the game of Othello. You can test it by running the file "Othello.java".
# Project files description:
    The Othello implementation is structured as follows:
    • Othello.java: this class contains a main.
    • OthelloMove.java: this class contains a "move" (which player made the move and the coordinates of the move).
    • OthelloState.java: this is the core class, which implements most of the functionality of the game.
    •The functions you should be aware of, for implementing minimax are as follows:
    o public List getValidMoves (): returns the list of moves for the next player to move.
    o public List getValidMoves (int player): same as before, but you can specify which player you want to generate moves for.
    • OthelloPlayer.java: this is an abstract class defining an agent that plays Othello. Your agent should be implemented as a class that extends this one.
    • OthelloRandomPlayer.java: an example agent that plays Othello, it chooses moves at random.
