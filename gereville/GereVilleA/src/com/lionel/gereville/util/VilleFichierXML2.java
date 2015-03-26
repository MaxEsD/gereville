/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lionel.gereville.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.lionel.gereville.model.Ville;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

/**
 *
 * @author pf
 */
public class VilleFichierXML2
{

	public static  String fileName = "villes_xml2.xml"; // nom par defaut
	private static XStream xstream = new XStream(new StaxDriver());

                
        public static void store(List<Ville> lv) throws Exception{
       
				//encodage de la liste en XML
				String xml = xstream.toXML(lv);

				//serialization dans un fichier
				FileOutputStream fos = new FileOutputStream(fileName);
				fos.write(xml.getBytes());
				
				fos.close();
				
				
				
			
        	
        }
        
        /**
         * restore a ListVille from file
         * @return null si aucune ville
         */
        public static List<Ville> retrieve() throws Exception{
        	
        	FileInputStream fileInputStream = new FileInputStream(fileName);
        	List<Ville> o = (List<Ville>) xstream.fromXML(fileInputStream);
        	
      
			return o;
          
        }
        
}
