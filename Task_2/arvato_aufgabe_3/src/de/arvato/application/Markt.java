package de.arvato.application;

import java.util.List;
import java.lang.Math;

public class Markt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int getOptimalValue(float money, List<Flear> flears){
		int res = 0;
		float usedMoney = 0;
		List<Flear> buyFlears = null;
		Flear flear = new Flear();
		
		// erste Schleife um eine vorläufige Liste zu bekommen
		for (int i=0; i < flears.size(); i++) {
			flear = flears.get(i);
			if(buyFlears.isEmpty()) {
				usedMoney = usedMoney + flear.getPrice();
				buyFlears.add(flear);
			}else if(flear.getRating() > avgRating(buyFlears)) {
				usedMoney = usedMoney + flear.getPrice();
				buyFlears.add(flear);
			}
			
			float avgRating = avgRating(buyFlears);
			
			if (usedMoney > money) {
				buyFlears = correctBuys(buyFlears, avgRating, (usedMoney - money));
			}	
		}
		
		// zweite Schleife um zu prüfen, ob die erste Version der Liste die beste ist
		for (int i=0; i < buyFlears.size(); i++) {
			for (int j=0; j < flears.size(); j++) {
				// falls es in der ursprünglichen Liste noch einen Floh gibt, bei dem das Rating besser ist
				// und der Floh noch nicht in der Liste mit den Flöhen ist, die gekauft werden sollen,
				// werden die Flöhe ausgetauscht.
				if (buyFlears.get(i).getRating() < flears.get(j).getRating() && buyFlears.contains(flears.get(j)) == false) {
					buyFlears.add(i, flears.get(j));
					usedMoney = usedMoney + (buyFlears.get(i).getPrice() - flears.get(j).getPrice());
					buyFlears.remove(i + 1);
					
				}
				
				float avgRating = avgRating(buyFlears);
				
				if (usedMoney > money) {
					buyFlears = correctBuys(buyFlears, avgRating, (usedMoney - money));
				}
				
			}
		}
		
		return sumRating(buyFlears);
	}
	
	/**
	 * Berechnet das durchschnittliche Rating der übergebenen Liste
	 * 
	 * @param flears Liste mit den Flöhen
	 * @return durchschnittliches Rating
	 */
	public static float avgRating(List<Flear> flears) {
		int sumRating = 0;
		
		for(int i=0; i < flears.size(); i++) {
			sumRating = sumRating + flears.get(i).getRating();
		}
		
		return (sumRating / flears.size());
	}
	
	/**
	 * Korrigiert die übergebene Liste, indem ein Floh gelöscht wird, der das schlechteste Rating hat und
	 * die Kosten der Differenz zwischen dem benutztem Geld und dem vorgegebenem Geld entspricht.
	 * 
	 * @param flears Liste mit Flöhen
	 * @param avgRating durchschnittliches Rating der Flöhe
	 * @param moneyDiff Differenz zwischen aktuell benutztem Geld und vorgegebenem Betrag
	 * @return flears korrigierte Liste die unter dem vorgegebenem Geld liegt
	 */
	public static List<Flear> correctBuys(List<Flear> flears, float avgRating, float moneyDiff) {
		int indexWorstRating= -1;
		int worstRating = 10;
		Flear flear = new Flear();
		
		for(int i = 0; i < flears.size(); i++) {
			flear = flears.get(i);
			
			if(Math.round(flear.getPrice()) == Math.round(moneyDiff) && flear.getRating() < worstRating) {
				indexWorstRating = i;
				worstRating = flear.getRating();
			}
		}
		
		if(indexWorstRating != -1) {
			flears.remove(indexWorstRating);
		}else {
			correctBuys(flears, avgRating, Math.round(moneyDiff + 1));
		}
		
		return flears;
	}

	
	/**
	 * Summiert das Rating aller Flöhe aus der übergebenen List
	 * 
	 * @param flears List mit Flöhen
	 * @return rating Summe von jedem Floh aus der Liste
	 */
	public static int sumRating(List<Flear> flears) {
		int rating = 0;
		
		for (int i=0; i < flears.size(); i++) {
			rating = rating + flears.get(i).getRating();
		}
		return rating;
	}

}
