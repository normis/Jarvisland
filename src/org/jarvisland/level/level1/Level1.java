package org.jarvisland.level.level1;

import org.jarvisland.level.AbstractLevel;

public class Level1 extends AbstractLevel {

	public Level1() {
		super(new SomeRoom());
	}

	@Override
	public boolean isCompleted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void notify(String event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "The Limbo";
	}
}
