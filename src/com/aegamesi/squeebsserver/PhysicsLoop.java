package com.aegamesi.squeebsserver;

import com.aegamesi.squeebsserver.messages.MessageOutKillMonster;
import com.aegamesi.squeebsserver.messages.MessageOutMoveMonster;

import java.io.IOException;
import java.util.Random;

public class PhysicsLoop extends Thread {
    public Random r;
    public float save_timer = 300.0f;

    public PhysicsLoop() {
        r = new Random();
    }

    @Override
    public void run() {
        while (Main.running) {
            float dt = 1.0f / (float) Main.TPS;

            // auto save db
            save_timer -= dt;
            if(save_timer < 0.0f) {
                save_timer = 300.0f;
                Main.db.save();
            }

            // do monster stuff
            for (int i = 0; i < Main.db.monsters.length; i++) {
                Database.Monster m = Main.db.monsters[i];
                if (m == null)
                    continue;

                // monster movement
                m.move_timer -= dt;
                if (m.move_timer < 0.0f) {
                    m.move_timer = 3.0f + r.nextFloat() * 3.0f;
                    m.new_x = m.x - 150 + r.nextInt(300);

                    // echo
                    MessageOutMoveMonster moveMsg = new MessageOutMoveMonster();
                    moveMsg.mid = i;
                    moveMsg.new_x = m.new_x;
                    for (int j = 0; j < Main.clientHandler.players.length; j++) {
                        Client player = Main.clientHandler.players[j];
                        if (player == null)
                            continue;

                        try {
                            if (player.user.rm == m.rm) {
                                m.ttl = 60.0f;
                                player.sendMessage(moveMsg);
                            }
                        } catch (IOException e) {
                        }
                    }
                }

                // monster death / expiration
                m.ttl -= dt;
                if (m.hp < 1 || m.ttl < 0.0f) {
                    Main.db.monsters[i] = null;

                    MessageOutKillMonster killMsg = new MessageOutKillMonster();
                    killMsg.mid = i;
                    for (int j = 0; j < Main.clientHandler.players.length; j++) {
                        Client player = Main.clientHandler.players[j];
                        if (player == null)
                            continue;

                        try {
                            if (player.user.rm == m.rm)
                                player.sendMessage(killMsg);
                        } catch (IOException e) {
                        }
                    }
                }
            }


            try {
                Thread.sleep(1000 / Main.TPS);
            } catch (InterruptedException e) {
            }
        }
    }

    public int getMonstersInRoom(int rm) {
        int n = 0;
        for(Database.Monster m : Main.db.monsters)
            if(m != null && m.rm == rm)
                n++;
        return n;
    }
    public int getPlayersInRoom(int rm) {
        int n = 0;
        for(Database.User m : Main.db.users)
            if(m != null && m.rm == rm)
                n++;
        return n;
    }
    public int getItemsInRoom(int rm) {
        int n = 0;
        for(Database.Item m : Main.db.items)
            if(m != null && m.rm == rm)
                n++;
        return n;
    }
}
