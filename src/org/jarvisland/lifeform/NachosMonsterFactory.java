package org.jarvisland.lifeform;

public class NachosMonsterFactory implements MonsterFactory {

	@Override
	public Monster getMonstre() {
		return new NachosMonster("Monstre Nachos", 150, 10);
	}

}
