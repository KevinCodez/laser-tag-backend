package edu.uark.laserbacks.game;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

@Slf4j
@Service
@EnableAsync
public class UdpServer {
    private final DatagramSocket incomingSocket;
    private final DatagramSocket outgoingSocket;
    private final GameService service;
    private byte[] inbound;
    private byte[] outbound = new byte[16];

    public UdpServer(GameService service) throws SocketException {
        this.service = service;
        outgoingSocket = new DatagramSocket(7500);
        incomingSocket = new DatagramSocket(7501);
    }

    @SneakyThrows
    @Async
    public void run() {

        while (service.getGame().isRunning()) {
            inbound = new byte[32];
            DatagramPacket packet
                    = new DatagramPacket(inbound, inbound.length);
            incomingSocket.receive(packet);
            InetAddress address = packet.getAddress();
            // incoming data int:int (player sending : player hit)
            String received = data(inbound);
            log.debug("UDP Packet: {}", received);
            int sender = 0;
            int playerHit = 0;
            try {
                log.debug("Shooter [{}]", received.substring(0, received.indexOf(":")));
                log.debug("Shot [{}]", received.substring(received.indexOf(":")+1));
                sender = Integer.parseInt(received.substring(0, received.indexOf(":")));
                playerHit = Integer.parseInt(received.substring(received.indexOf(":")+1));
            } catch (NumberFormatException e) {
                log.error(e.getLocalizedMessage());
            }

            // Score calculations
            service.registerHit(sender, playerHit);

            sendUdpReply(address, playerHit);
        }
        incomingSocket.close();
        outgoingSocket.close();
    }

    private void sendUdpReply(InetAddress address, int player) throws IOException {
        outbound = ByteBuffer.allocate(Integer.SIZE/8).putInt(player).array();
        DatagramPacket packet
                = new DatagramPacket(outbound, outbound.length, address, 4445);
        outgoingSocket.send(packet);
    }

    private String data(byte[] byteArray){
        if(byteArray == null)
            return null;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(byteArray[i] != 0){
            sb.append((char)byteArray[i]);
            i++;
        }
        return sb.toString();
    }

}