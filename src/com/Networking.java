package com;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by Ashraf-XCODER on 3/21/2017.
 */
public class Networking {

    public static void main(String[] args) throws UnknownHostException, SocketException {

        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

        NetworkInterface networkInterface = networkInterfaces.nextElement();
        while (networkInterfaces.hasMoreElements()){
            if (networkInterface.isUp() && !networkInterface.isLoopback()) {
                System.out.println(networkInterface.getName() + " " + networkInterface.getIndex());
                System.out.println(networkInterface.getMTU());
                networkInterface.getInterfaceAddresses().forEach(nI -> {
                    System.out.println(nI.getAddress().getHostAddress());//+ " Broadcast: " + nI.getBroadcast().getHostAddress());

                });
                //showAddresses(networkInterface.getInetAddresses());
            }

            networkInterface = networkInterfaces.nextElement();
        }

//        InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
//        for (int i = 0; i < addresses.length; i++) {
//            System.out.println(addresses[i]);
//        }
    }

    private static void showAddresses(Enumeration<InetAddress> inetAddresses) {
        InetAddress inetAddress = inetAddresses.nextElement();
        while (inetAddresses.hasMoreElements() && inetAddress != null){
            System.out.printf("%15s \n", inetAddress.getHostAddress());
            inetAddress = inetAddresses.nextElement();
        }
    }

    public static char getClass(InetAddress ia) {
        byte[] address = ia.getAddress( );
        if (address.length != 4) {
            throw new IllegalArgumentException("No IPv6 addresses!");
        }
        int firstByte = address[0];
        if ((firstByte & 0x80) == 0) return 'A';
        else if ((firstByte & 0xC0) == 0x80) return 'B';
        else if ((firstByte & 0xE0) == 0xC0) return 'C';
        else if ((firstByte & 0xF0) == 0xE0) return 'D';
        else if ((firstByte & 0xF8) == 0xF0) return 'E';
        else return 'F';
    }


}
