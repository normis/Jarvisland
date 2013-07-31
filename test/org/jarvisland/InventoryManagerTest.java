package org.jarvisland;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryManagerTest {

	@Test
	public void testAddItem() {
		InventoryManager.getInstance().addItem("item");
		assertTrue(InventoryManager.getInstance().hasItem("item"));
	}

	
	
	
}
