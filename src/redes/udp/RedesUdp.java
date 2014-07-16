package redes.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class RedesUdp {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException{
        InetAddress IPAddress = InetAddress.getByName("localhost");
        DatagramSocket clientSocket = new DatagramSocket();
        DatagramSocket serverSocket = new DatagramSocket(8400);
   
        byte[] datos = new byte[2048];
        DatagramPacket packet = new DatagramPacket(datos, datos.length);
        DatagramPacket sendPacket;
        Boolean run =true;
        while(run){
            serverSocket.receive(packet);
            InetAddress ip = packet.getAddress();
            System.out.println(packet.getLength());
            System.out.println(ip.toString());
            //System.out.println(clientSocket.isConnected());
            sendPacket =  new DatagramPacket(datos , datos.length, IPAddress, 8500);
            clientSocket.send(sendPacket);
        } 
        clientSocket.close();
        serverSocket.close();
    }
    
}
