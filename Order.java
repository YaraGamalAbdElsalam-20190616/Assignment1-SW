/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw1;

import java.util.Scanner;
import java.util.*;
import java.util.Arrays;

public class Order {
    Store store=new Store();
	
	private String sourceArea ;
        private String distinationArea ;
    
	public String getSourceArea() {
		return sourceArea;
	}
	public void setSourceArea(String sourceArea) {
		this.sourceArea = sourceArea;
	}
	public String getDistinationArea() {
		return distinationArea;
	}
	public void setDistinationArea(String distinationArea) {
		this.distinationArea = distinationArea;
	}
        public void checkSource(String source)
        {
            for(int i=0;i<store.FavouritreAreas.size();i++)
            {
                if(store.displayFavouritreAreas(i).equals(source))
                {
                   store.AddAllRides(source);
                }
            }
        }
        

}