package Agents;

import java.util.Date;

import othello.GameState;
import othello.OthelloPlayer;
import othello.Square;

public class UltimateMinMaxAgent extends OthelloPlayer{
	
	
	
	public UltimateMinMaxAgent(String name) {
		super(name);
	}

	
	
	public Square getMove(GameState currentState, Date deadline) {
		int depth =4;
		int score =Integer.MIN_VALUE;
		Square Result = null;
		Square moves[] = currentState.getValidMoves(currentState.getCurrentPlayer()).toArray(new Square[0]);
		depth--;
		for (int i=0;i<moves.length;i++) {
			GameState New =(GameState) currentState.clone();
			 New =New.applyMove(moves[i]);
			int tmp = minmax(New,depth,false);
			if(score < tmp) {
				score =tmp;
				Result = moves[i];
			}
		}
		
		return Result;
	}
	public int minmax(GameState currentState, int depth, boolean max) {
		Square moves[] = currentState.getValidMoves(currentState.getCurrentPlayer()).toArray(new Square[0]);
		Square Opponentmoves[] = currentState.getValidMoves(currentState.getOpponent(currentState.getOpponent(currentState.getCurrentPlayer()))).toArray(new Square[0]);
		if(depth == 0 || (moves.length == 0 && Opponentmoves.length == 0))
			return currentState.getScore(currentState.getCurrentPlayer());
		if(max == true) {
			int maxvalue = Integer.MIN_VALUE;
			 for(int i=0;i<moves.length;i++) {
				 GameState gamestste = (GameState) currentState.clone();
				int value = minmax(gamestste.applyMove(moves[i]),depth-1,false);
				if(maxvalue<value)
					maxvalue =value;
			}
				return maxvalue;
			
		}
			else {
				int minvalue = Integer.MAX_VALUE;
				 for(int i=0;i<Opponentmoves.length;i++) {
				GameState gamestste = (GameState) currentState.clone();
				int value = minmax(gamestste.applyMove(Opponentmoves[i]),depth-1,true);
				if(minvalue>value)
					minvalue =value;
				}
				return minvalue;
			}
	}
}
