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
import java.io.ObjectOutputStream;
import java.util.List;

import com.lionel.gereville.model.Pays;
import com.lionel.gereville.model.Ville;

/**
 *
 * @author pf
 */
public class VilleFichier
{

	public static  String fileName = "villes.txt"; // nom par defaut

                


       
        
        public static void store(List<Pays> lp) throws Exception{
        	ObjectOutputStream oFW = null;
				try {
					oFW= new ObjectOutputStream(new FileOutputStream(fileName));
				} catch (FileNotFoundException e) {
					throw new Exception("File not found" + e.getMessage());
					
				} catch (IOException e) {
					throw new Exception("Unable to write to file " +fileName);
				}
				
				
				 oFW.writeObject(lp);
				 
       
				 if (oFW !=null)
				try {
					oFW.close();
				} catch (IOException e) {
					//do nothing
				}
				
			
        	
        }
        
        /**
         * restore a ListVille from file
         * @return null si aucune ville
         */
        public static List<Pays> retrieve() throws Exception{
        	
        	List<Pays> o = null;
        	
        	ObjectInputStream iFW =null;
			try {
				iFW = new ObjectInputStream(new FileInputStream(fileName));
			} catch (FileNotFoundException e) {
				//do nothing here
				return null;
			} catch (IOException e) {
				throw new Exception("Unable to Read from file " +fileName);
			} 
				
			

			try {
				o = (List<Pays>) iFW.readObject();
			} catch (ClassNotFoundException e) {
				throw new Exception("Class ListeVille was not found in " +fileName);
			} catch (IOException e) {
				throw new Exception("Unable to Read from file " +fileName);
			}finally{
				if (iFW !=null)
					try {
						iFW.close();
					} catch (IOException e) {
						//do nothing
						e.printStackTrace();
					}
			}
      
			return o;
          
        }
        
}
