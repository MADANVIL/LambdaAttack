package org.spacehq.mc.protocol.packet.ingame.server;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

import java.io.IOException;

import org.spacehq.mc.protocol.data.message.Message;
import org.spacehq.mc.protocol.packet.MinecraftPacket;

public class ServerDisconnectPacket extends MinecraftPacket {
    private Message message;

    @SuppressWarnings("unused")
    private ServerDisconnectPacket() {
    }

    public ServerDisconnectPacket(String text) {
        this(Message.fromString(text));
    }

    public ServerDisconnectPacket(Message message) {
        this.message = message;
    }

    public Message getReason() {
        return this.message;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.message = Message.fromString(in.readString());
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.message.toJsonString());
    }

    @Override
    public boolean isPriority() {
        return true;
    }
}
