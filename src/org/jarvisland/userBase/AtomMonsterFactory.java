package org.jarvisland.userBase;

public class AtomMonsterFactory implements MonsterFactory {
	
	@Override
	public Monster getMonstre() {
		return new AtomMonster("Atom Monster", 25, 2);
	}

}
