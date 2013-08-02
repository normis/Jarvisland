package org.jarvisland.levels.room;

import org.jarvisland.lifeform.Monster;
import org.jarvisland.lifeform.MonsterFactory;

public abstract class AbstractMonsterRoom extends AbstractRoom {

	protected MonsterFactory mf;
	protected Monster monster;
	
	abstract public MonsterFactory getMonsterFactory();
	
	public void initialiser() {
		mf = getMonsterFactory();
		monster = mf.getMonstre();
	}

}
