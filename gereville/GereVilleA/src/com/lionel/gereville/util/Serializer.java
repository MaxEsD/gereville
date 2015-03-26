package com.lionel.gereville.util;

import java.util.List;

import com.lionel.gereville.model.Ville;

public interface Serializer {

	
	public void store(List<Ville> villes) throws Exception;
	
	public List<Ville> restore();
	
}
