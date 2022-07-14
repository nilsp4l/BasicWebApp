package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Nils";
        }
        else if(query.contains("plus")){
            String[] queryArray = query.split(" ");
            String sum = "0";
            for(int i = 0; i < queryArray.length; i++) {
                if(queryArray[i].equals("plus") && i - 1 >= 0 && i + 1 < queryArray.length){
                    sum = Integer.toString(Integer.parseInt(queryArray[i - 1]) + Integer.parseInt(queryArray[i + 1]));
                    break;
                }

            }
            return sum;
        }
        else if(query.contains("multiplied")){
            String[] queryArray = query.split(" ");
            String product = "0";
            for(int i = 0; i < queryArray.length; i++) {
                if(queryArray[i].equals("multiplied") && i - 1 >= 0 && i + 2 < queryArray.length){
                    product = Integer.toString(Integer.parseInt(queryArray[i - 1]) * Integer.parseInt(queryArray[i + 2]));
                    break;
                }

            }
            return product;
        }

        else if (query.contains("largest:")) {
            String[] queryArray = query.split(" ");
            String max = "0";
            int[] values = new int[0];
            for(int i = 0; i < query.length(); i++) {
                if(queryArray[i].equals("largest:")) {
                    values = new int[queryArray.length - (i + 1)];
                    for(int j = i + 1; j < queryArray.length; j++) {
                        values[j - (i + 1)] = Integer.parseInt(queryArray[j].replace(",", ""));
                    }
                    break;
                }

            }
            Arrays.sort(values, 0, values.length - 1);
            max = Integer.toString(values[values.length - 1]);
            return max;
        }
        else { // TODO extend the programm here
            return "";
        }
    }//
}
