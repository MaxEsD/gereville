package com.lionel.gereville.util;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.lionel.gereville.model.Ville;

public class XMLSerializer implements Serializer {

	public static  String fileName = "villes_ser.xml"; // nom par defaut

	
	@Override
	public void store(List<Ville> villes) throws Exception {
		XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));
		encoder.writeObject(villes);
		 

		if (encoder !=null)
			encoder.close();
		
	}

	@Override
	public List<Ville> restore() {
		// TODO Auto-generated method stub
		return null;
	}

}
