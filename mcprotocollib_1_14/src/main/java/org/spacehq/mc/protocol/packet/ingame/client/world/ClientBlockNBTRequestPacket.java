package org.spacehq.mc.protocol.packet.ingame.client.world;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

import java.io.IOException;

import org.spacehq.mc.protocol.data.game.entity.metadata.Position;
import org.spacehq.mc.protocol.packet.MinecraftPacket;
import org.spacehq.mc.protocol.util.NetUtil;

public class ClientBlockNBTRequestPacket extends MinecraftPacket {
    private int transactionId;
    private Position position;

    @SuppressWarnings("unused")
    private ClientBlockNBTRequestPacket() {
    }

    public ClientBlockNBTRequestPacket(int transactionId, Position position) {
        this.transactionId = transactionId;
        this.position = position;
    }

    public int getTransactionId() {
        return this.transactionId;
    }

    public Position getPosition() {
        return this.position;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.transactionId = in.readVarInt();
        this.position = NetUtil.readPosition(in);
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeVarInt(this.transactionId);
        NetUtil.writePosition(out, this.position);
    }
}
