package com.fyp.UDP.FYP;

/**
 * Created by Buddhima on 11/14/2018.
 */
import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Receiver {
    public static void main(String[] args) {
        int port = args.length == 0 ? 57 : Integer.parseInt(args[0]);
        new Receiver().run(port);
    }




    public void run(int port) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(port);
            byte[] receiveData = new byte[20];
            String sendString = "polo";
            byte[] sendData = sendString.getBytes("UTF-8");

            System.out.printf("Listening on udp:%s:%d%n",
                    InetAddress.getLocalHost().getHostAddress(), port);
            DatagramPacket receivePacket = new DatagramPacket(receiveData,
                    receiveData.length);

            while(true)
            {
                serverSocket.receive(receivePacket);
                String sentence = new String( receivePacket.getData(), 0,
                        receivePacket.getLength() );
                System.out.println("RECEIVED: " + sentence);
                try {
                    POST.sendPost(sentence);
                }catch (Exception e){
                    System.out.println("Exception Thrown Check the input format (id:data ) example: 1001:12345");

                }
                // now send acknowledgement packet back to sender
                InetAddress IPAddress = receivePacket.getAddress();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                        IPAddress, receivePacket.getPort());
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        // should close serverSocket in finally block
    }
}
