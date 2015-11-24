package com.aegamesi.squeebsserver.messages;


import java.io.IOException;
import java.nio.ByteBuffer;

public class MessageOutDamage extends Message {
    public int userid;
    public int damage;

    public MessageOutDamage() {
        type = 13;
    }

    @Override
    public void write(ByteBuffer b) throws IOException {
        b.put((byte) userid);
        b.putShort((short) damage);
    }

    @Override
    public void read(ByteBuffer b) throws IOException {
        userid = b.get();
        damage = b.getShort();
    }
}
