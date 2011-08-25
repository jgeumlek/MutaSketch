package MutaSketchGame;

import java.util.HashMap;
import java.util.Map;

//Tracks the full game state. Players, the chains, etc.
public class GameOverview {
	
	private class PlayerChain {
		//The player and their current chain
		private Player player;
		private Chain chain;
		//The player's relations to others.
		PlayerChain previous;
		PlayerChain next;
		//Networking issues, need to deal with players dropping out.
		boolean isActive = true;
		
		public PlayerChain(Player player, Chain chain, PlayerChain prev, PlayerChain next) {
			this.player = player;
			this.chain = chain;
			this.previous = prev;
			this.next = next;
		}
	}
	//Maps usernames to the relevant info.
	//Note that the PlayerChain nodes form a circular linked list.
	//A map of names is convenient for data access,
	//the linked list eases in passing the chains around to the next player.
	Map<String,PlayerChain> players;
	//Used for convenient player linkages in forming a circular list.
	//Head and Tail don't really hold much meaning in this sense, 
	//but it does fit the order in which the nodes are stored.
	PlayerChain head,tail;
	
	public GameOverview() {
		players = new HashMap<String,PlayerChain>();
	}
	
	public void addPlayer(Player player) {
		
		PlayerChain newNode = new PlayerChain(player,null,tail,head);
		//Is this the first player?
		if (head == null && tail == null) {
			head = newNode;
			tail = newNode;
		}
		players.put(player.getName(), newNode);
		//Maintain the circular linked list.
		tail.next = newNode;
		head.previous = newNode;
		
		tail = newNode;
	}
}
