package redes.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class RedesUdp {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException{        
        DatagramSocket clientSocket = new DatagramSocket();
        DatagramSocket serverSocket = new DatagramSocket(8400);
        InetAddress IPAddress = InetAddress.getByName("serverIP"); 
   
        byte[] datos = new byte[1024]; 

        DatagramPacket packet;
        DatagramPacket sendPacket;
        
        while(true){
            packet = new DatagramPacket(datos, datos.length);
            clientSocket.receive(packet);
            sendPacket =  new DatagramPacket(packet.getData(), datos.length, IPAddress, 8500);
            serverSocket.send(sendPacket);
        }  
    }
    
}
