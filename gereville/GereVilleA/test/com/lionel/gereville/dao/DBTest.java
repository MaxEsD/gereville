package com.lionel.gereville.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class DBTest {

	@Test
	public void test() {
		assertNotNull(Connect.cConnect());
	}

}
