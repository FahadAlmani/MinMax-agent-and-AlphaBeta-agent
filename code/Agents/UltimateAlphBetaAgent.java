package Agents;

import java.util.Date;
import othello.GameState;
import othello.OthelloPlayer;
import othello.Square;

public class UltimateAlphBetaAgent extends OthelloPlayer {
	
	public UltimateAlphBetaAgent(String name) {
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
			int tmp = alphabeta(New,depth,Integer.MIN_VALUE,Integer.MAX_VALUE,false);
			if(score < tmp) {
				score =tmp;
				Result = moves[i];
			}
		}
		
		return Result;
	}
	public int alphabeta(GameState currentState, int depth, int alpha,int beta, boolean max) {
		Square moves[] = currentState.getValidMoves(currentState.getCurrentPlayer()).toArray(new Square[0]);
		Square Opponentmoves[] = currentState.getValidMoves(currentState.getOpponent(currentState.getOpponent(currentState.getCurrentPlayer()))).toArray(new Square[0]);
		if(depth == 0 || (moves.length == 0 && Opponentmoves.length == 0))
			return currentState.getScore(currentState.getCurrentPlayer());
		if(max == true) {
			int maxvalue = Integer.MIN_VALUE;
			 for(int i=0;i<moves.length;i++) {
				 GameState gamestste = (GameState) currentState.clone();
				int value = alphabeta(gamestste.applyMove(moves[i]),depth-1,alpha,beta,false);
				if(maxvalue<value)
					maxvalue =value;
				if(alpha < value)
					alpha = value;
				if(beta <= alpha)
					break;
			}
				return maxvalue;
			
		}
			else {
				int minvalue  = Integer.MAX_VALUE;
				 for(int i=0;i<Opponentmoves.length;i++) {
				GameState gamestste = (GameState) currentState.clone();
				int value = alphabeta(gamestste.applyMove(Opponentmoves[i]),depth-1,alpha,beta,true);
				if(minvalue > value)
					minvalue = value;
				if(beta > value)
					beta = value;
				if(beta <= alpha)
					break;
				}
				return minvalue ;
			}
	}
}
