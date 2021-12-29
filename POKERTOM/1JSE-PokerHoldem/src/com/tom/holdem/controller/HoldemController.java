package com.phdareys.holdem.controller;

import com.phdareys.holdem.model.Card;
import com.phdareys.holdem.model.CardColor;
import com.phdareys.holdem.model.CardValue;
import com.phdareys.holdem.model.HoldemGame;

public class HoldemController {
		// check unicity of these 9 cards please!
	private final static Card[] P1Cards = {	// 2 cards Player1
            new Card (CardColor.DIAMOND, CardValue.ACE),
            new Card (CardColor.HEARTS, CardValue.ACE)
		};
	private final static Card[] P2Cards = {	// 2 cards Player2
            new Card (CardColor.CLUB, CardValue.TEN),
            new Card (CardColor.SPADE, CardValue.JACK)
		};
	private final static Card[] flopCards = new Card []{	// 3 cards on board
			new Card (CardColor.HEARTS, CardValue.SIX), 
			new Card (CardColor.HEARTS, CardValue.TEN), 
			new Card (CardColor.DIAMOND, CardValue.TEN) 
	};
	private final static Card turnCard = 
			new Card (CardColor.CLUB, CardValue.QUEEN); // another one	
	private final static Card riverCard = 
			new Card (CardColor.SPADE, CardValue.ACE); //finally!
		// draws number (the higher the more it fits to maths probas: 10000 is a good compromise)
	private final static int DRAWS = 1000;	
	private final static String INTRO = 
			"\tTEXAS HOLD'EM Poker\n" + 
					"\t\t\t-1/ 2 hidden cards are given to 2 players -> show % success chances of each player (including null)\n"+
					"\t\t\t-2/ flop: display 3 visible cards on board ->  update %\n"+
					"\t\t\t-3/ turn: display another 1 visible card on board -> update %\n"+
					"\t\t\t-4/ river: display another 1 visible card on board -> display Winner and best possible hand value\n"+
					"[rules: 0-100: 5 diff cards(highest wins); 100<200: 1 pair; 200<300: 2 pairs; 300<400: 3OfAKind; 400<500: Straight; 500: flush;\n600<700: full house; 700<800: square; 800<900: straight+flush; 900: royal straight flush]\n";

	public static void main(String[] args) {
		System.out.println(INTRO);
				// 1/ start with 2 cards each player and display probas
		HoldemGame holdem=new HoldemGame(P1Cards, P2Cards);	
		holdem.run(DRAWS);
		System.out.println(holdem);
				// 2/ flop -> display 3 cards on board and update probas
		holdem=new HoldemGame(P1Cards, P2Cards, flopCards);	
		holdem.run(DRAWS);
		System.out.println(holdem);
				// 3/ turn -> show another one and and update
		holdem=new HoldemGame(P1Cards, P2Cards, flopCards, turnCard);	
		holdem.run(DRAWS);
		System.out.println(holdem);
				// 4/ river -> show last card and display winner!
		holdem=new HoldemGame(P1Cards, P2Cards, flopCards, turnCard, riverCard);	
		holdem.run();
		System.out.println(holdem);

	}
}
