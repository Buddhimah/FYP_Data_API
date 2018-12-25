a da# FYP_Data_API
This can be used to get the water meter data stored in the server. Or store the data using UDP messages. 

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


How to get data?
Send a GET request to http://192.248.15.157:8081/meter/all 
![image](https://user-images.githubusercontent.com/29881881/48465684-b5f6cc00-e809-11e8-8ba2-e3a4bf347f1e.png)

Data will be received in the JSON format. 

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

How to Store data?
For our final year project, we are using NB-iOT and 6Lowpan Mesh network as Communication Protocols stacks. Hence UDP messages will be used to transfer data. This application has functionality to receive those UDP messages and store them in MySQL database. 

Send UDP packet in the format 
Id:data
Here id is the meter id 
: is the delimiter
Data is meter data

IP ADDRESS : 192.248.15.157
Port : 57
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

![image](https://user-images.githubusercontent.com/29881881/48465696-bb541680-e809-11e8-8e37-7cad4a06d7c1.png)


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

![image](https://user-images.githubusercontent.com/29881881/48465699-bf803400-e809-11e8-8ef8-1a9b6bcc4c65.png)

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Code for sending UDP Packets

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;

import java.net.*;


class UDPClient

{
   public static void main(String args[]) throws Exception
   
   {
   
      BufferedReader inFromUser =
         new BufferedReader(new InputStreamReader(System.in)); 
      DatagramSocket clientSocket = new DatagramSocket();
      
      InetAddress IPAddress = InetAddress.getByName("192.248.15.157");
      
      byte[] sendData = new byte[10000];
      
      byte[] receiveData = new byte[2048];
      
      String sentence = inFromUser.readLine();
      
      sendData = sentence.getBytes();
      
	System.out.println(sendData);
	
	System.out.println(sendData.length);	
	
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 57);
      clientSocket.send(sendPacket);
      
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      
      String modifiedSentence = new String(receivePacket.getData());
      
      System.out.println("FROM SERVER:" + modifiedSentence);
      
      clientSocket.close();
      
   }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
![1](https://user-images.githubusercontent.com/29881881/50408034-c7b88f80-0809-11e9-819a-41a29ff53224.JPG)
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
![2](https://user-images.githubusercontent.com/29881881/50408036-cab38000-0809-11e9-8592-49d7571fc03b.JPG)
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
![3](https://user-images.githubusercontent.com/29881881/50408038-cd15da00-0809-11e9-8e87-5f4620529cd6.JPG)
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
![4](https://user-images.githubusercontent.com/29881881/50408044-e4ed5e00-0809-11e9-8d58-af657fe3fc75.JPG)