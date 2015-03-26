/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lionel.gereville.util;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.lionel.gereville.model.Ville;

/**
 *
 * @author pf
 */
public class VilleFichierXML
{

	public static  String fileName = "villes_ser.xml"; // nom par defaut

                
        public static void store(List<Ville> lv) throws Exception{
        	XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));
       
				
				
				encoder.writeObject(lv);
				 
       
				if (encoder !=null)
					encoder.close();
				
				
			
        	
        }
        
        /**
         * restore a ListVille from file
         * @return null si aucune ville
         */
        public static List<Ville> retrieve() throws Exception{
        	
        	XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
        	List<Ville> villes =  (List<Ville>) decoder.readObject();
        	
        	decoder.close();
        	return villes;
        	
        
          
        }
        
}
