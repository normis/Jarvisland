package org.jarvisland.levels.room;

import org.jarvisland.userBase.Monster;
import org.jarvisland.userBase.MonsterFactory;

public abstract class AbstractMonsterRoom extends AbstractRoom {

	protected MonsterFactory mf;
	protected Monster monster;
	
	abstract public MonsterFactory getMonsterFactory();
	
	public void initialiser() {
		mf = getMonsterFactory();
		monster = mf.getMonstre();
	}

}
