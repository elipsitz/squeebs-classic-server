package com.aegamesi.squeebsserver;

import java.util.HashMap;
import java.util.Map;

public class MonsterSpawner {
    public static Map<Integer, MonsterInfo> monsterInfoMap = new HashMap<>();

    public boolean spawnOnPlayer = false; // whether or not to spawn when a player enters the room


    public static class MonsterInfo {
        public int id;
        public String name;
        public int hp;
        public int xp;
        public int arm;
        public int str;
        public double spd;
        public int gld;
        public boolean boss = false;

        public int item1 = 0;
        public int item2 = 0;
        public int item3 = 0;
        public int item4 = 0;
        public int item5 = 0;
        public double per1 = 0;
        public double per2 = 0;
        public double per3 = 0;
        public double per4 = 0;
        public double per5 = 0;
    }

    // initialize monster info
    static {
        MonsterInfo m;
        
        m = new MonsterInfo();
        m.id = 1;
        m.name = "Scarbab";
        m.hp = 10;
        m.xp = 1;
        m.arm = 1;
        m.str = 8;
        m.spd = 1;
        m.gld =  5;
        m.item1 = 1000+101;
        m.per1 = 0.01;
        m.item2 = 6000+1;
        m.per2 = 0.001;
        m.item3 = 6000+2;
        m.per3 = 0.001;
        monsterInfoMap.put(m.id, m);

        m = new MonsterInfo();
        m.id = 2;
        m.name = "Spiger";
        m.hp = 16;
        m.xp = 3;
        m.arm = 1;
        m.str = 12;
        m.gld =  10;
        m.spd = 1.2;
        m.item1 = 1000+102;
        m.per1 = 0.001;
        m.item2 = 1;
        m.per2 = 50;
        m.item3 = 2002;
        m.per3 = 0.001;
        monsterInfoMap.put(m.id, m);

        m = new MonsterInfo();
        m.id = 3;
        m.name = "Obstuger";
        m.hp = 50;
        m.xp = 5;
        m.arm = 3;
        m.gld = 20;
        m.str = 25;
        m.spd = 0.8;
        m.item1 = 1000+102;
        m.per1 = 0.01;
        m.item2 = 1;
        m.per2 = 50;
        m.item3 = 6003;
        m.per3 = 0.001;
        m.item4 = 5002;
        m.per4 = 0.001;
        monsterInfoMap.put(m.id, m);

        m = new MonsterInfo();
        m.id = 4;
        m.name = "Supa Obstuger";
        m.hp = 500;
        m.xp = 2000;
        m.arm = 10;
        m.gld= 1000;
        m.str = 80;
        m.spd = 1;
        m.item1 = 1000+102;
        m.per1 = 1;
        m.item2 = 1;
        m.per2 = 50;
        monsterInfoMap.put(m.id, m);

        m = new MonsterInfo();
        m.id = 5;
        m.name = "Bee";
        m.hp = 30;
        m.xp = 8;
        m.arm = 2;
        m.gld = 24;
        m.str = 35;
        m.spd = 1.2;
        m.item1 = 1102;
        m.per1 = 0.001;
        m.item2 = 6;
        m.per2 = 5;
        m.item3 = 6;
        m.per3 = 5;
        m.item4 = 5004;
        m.per4 = 0.001;
        monsterInfoMap.put(m.id, m);
        
        m = new MonsterInfo();
        m.id = 6;
        m.name = "Guard Bee";
        m.hp = 50;
        m.xp = 10;
        m.arm = 4;
        m.gld = 30;
        m.str = 40;
        m.spd = 1.2;
        m.item1 = 1005;
        m.per1 = 0.01;
        m.item2 = 1;
        m.per2 = 10;
        m.item3 = 2003;
        m.per3 = 0.001;
        m.item4 = 5003;
        m.per4 = 0.001;
        monsterInfoMap.put(m.id, m);
        
        m = new MonsterInfo();
        m.id = 7;
        m.name = "Queen Bee";
        m.hp = 1000;
        m.xp = 1000;
        m.arm = 10;
        m.gld = 1000;
        m.str = 100;
        m.spd = 0.2;
        m.item1 = 4016;
        m.per1 = 50;
        m.item2 = 4015;
        m.per2 = 50;
        m.item3 = 2005;
        m.per3 = 50;
        m.boss = true;
        monsterInfoMap.put(m.id, m);

        m = new MonsterInfo();
        m.id = 8;
        m.name = "Ice Spider";
        m.hp = 70;
        m.xp = 15;
        m.arm = 7;
        m.gld = 50;
        m.str = 60;
        m.spd = 1.4;
        m.item1 = 2006;
        m.per1 = 0.001;
        m.item2 = 4003;
        m.per2 = 0.001;
        m.item3 = 8004;
        m.per3 = 0.001;
        m.item4 = 5005;
        m.per4 = 0.001;
        monsterInfoMap.put(m.id, m);

        m = new MonsterInfo();
        m.id = 9;
        m.name = "Ice Thug";
        m.hp = 100;
        m.xp = 25;
        m.arm = 8;
        m.gld = 70;
        m.str = 80;
        m.spd = 1;
        m.item1 = 1008;
        m.per1 = 0.001;
        m.item2 = 4003;
        m.per2 = 0.001;
        m.item3 = 8004;
        m.per3 = 0.001;
        m.item4 = 5005;
        m.per4 = 0.001;
        monsterInfoMap.put(m.id, m);

        m = new MonsterInfo();
        m.id = 10;
        m.name = "Zombie";
        m.hp = 250;
        m.xp = 30;
        m.arm = 4;
        m.gld = 80;
        m.str = 100;
        m.spd = 0.8;
        m.item1 = 2001;
        m.per1 = 0.001;
        m.item2 = 1012;
        m.per2 = 0.001;
        m.item3 = 1006;
        m.per3 = 0.001;
        monsterInfoMap.put(m.id, m);

        m = new MonsterInfo();
        m.id = 11;
        m.name = "Strong Zombie";
        m.hp = 300;
        m.xp = 40;
        m.arm = 6;
        m.gld = 100;
        m.str = 120;
        m.spd = 0.8;
        m.item1 = 2001;
        m.per1 = 0.001;
        m.item2 = 1013;
        m.per2 = 0.001;
        m.item3 = 1006;
        m.per3 = 0.001;
        m.item4 = 4005;
        m.per4 = 0.001;
        monsterInfoMap.put(m.id, m);

        m = new MonsterInfo();
        m.id = 12;
        m.name = "Stalker";
        m.hp = 500;
        m.xp = 80;
        m.arm = 8;
        m.gld = 300;
        m.str = 180;
        m.spd = 1;
        m.item1 = 4007;
        m.per1 = 0.001;
        m.item2 = 1013;
        m.per2 = 0.001;
        m.item3 = 5008;
        m.per3 = 0.001;
        m.item4 = 6007;
        m.per4 = 0.001;
        monsterInfoMap.put(m.id, m);

        m = new MonsterInfo();
        m.id = 13;
        m.name = "Stalker Commander";
        m.hp = 1000;
        m.xp = 160;
        m.arm = 8;
        m.gld = 500;
        m.str = 200;
        m.spd = 1;
        m.item1 = 4007;
        m.per1 = 0.001;
        m.item2 = 1013;
        m.per2 = 0.001;
        m.item3 = 5008;
        m.per3 = 0.001;
        m.item4 = 6007;
        m.per4 = 0.001;
        monsterInfoMap.put(m.id, m);

        m = new MonsterInfo();
        m.id = 14;
        m.name = "Stalker General";
        m.hp = 2000;
        m.xp = 500;
        m.arm = 10;
        m.gld = 800;
        m.str = 250;
        m.spd = 1;
        m.boss = true;
        m.item1 = 4007;
        m.per1 = 50;
        m.item2 = 1013;
        m.per2 = 50;
        m.item3 = 7004;
        m.per3 = 50;
        m.item4 = 1029;
        m.per4 = 10;
        m.item5 = 1030;
        m.per5 = 10;
        monsterInfoMap.put(m.id, m);

        m = new MonsterInfo();
        m.id = 15;
        m.name = "Gigyice";
        m.hp = 5000;
        m.xp = 10000;
        m.arm = 20;
        m.gld = 10000;
        m.str = 300;
        m.spd = 1;
        m.item1 = 4008;
        m.per1 = 0.001;
        m.item2 = 4014;
        m.per2 = 10;
        m.item3 = 4011;
        m.per3 = 10;
        m.item4 = 4012;
        m.per4 = 10;
        m.boss = true;
        monsterInfoMap.put(m.id, m);

        m = new MonsterInfo();
        m.id = 16;
        m.name = "Megyice";
        m.hp = 400;
        m.xp = 100;
        m.arm = 40;
        m.gld = 400;
        m.str = 100;
        m.spd = 1;
        m.item1 = 2006;
        m.per1 = 0.001;
        m.item2 = 4003;
        m.per2 = 0.001;
        m.item3 = 8004;
        m.per3 = 0.001;
        m.item4 = 5005;
        m.per4 = 0.001;
    }
}
