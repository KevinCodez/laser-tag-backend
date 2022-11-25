package edu.uark.laserbacks.game;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

@Slf4j
@Service
public class UdpServer extends Thread {
    private final DatagramSocket incomingSocket;
    private final DatagramSocket outgoingSocket;
    private final GameService service;
    private byte[] inbound = new byte[256];
    private byte[] outbound = new byte[256];

    public UdpServer(GameService service) throws SocketException {
        this.service = service;
        outgoingSocket = new DatagramSocket(7500);
        incomingSocket = new DatagramSocket(7501);
    }

    @SneakyThrows
    public void run() {

        while (service.getGame().isRunning()) {
            DatagramPacket packet
                    = new DatagramPacket(inbound, inbound.length);
            incomingSocket.receive(packet);

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(inbound, inbound.length, address, port);
            // incoming data int:int (player sending : player hit)
            String received
                    = new String(packet.getData(), 0, packet.getLength()).trim();
            System.out.println(received);
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
        inbound = ByteBuffer.allocate(Integer.SIZE/8).putInt(player).array();
        DatagramPacket packet
                = new DatagramPacket(outbound, outbound.length, address, 4445);
        outgoingSocket.send(packet);
    }

}