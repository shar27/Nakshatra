
// Program on Rpi to receive the grid generated from floorplan 
// Uses sockets to receive data 

import java.net.*;
import java.io.*;
public class Clientside
{
    private Socket s = null;
    private DataInputStream  in  = null;
    private DataOutputStream out = null;
 int[][] a=new int[15][15];
 String num1;
    public Clientside(String address, int port)
    {
        try
        {
            s = new Socket(address, port);
            System.out.println("Connected");
            InputStream is=s.getInputStream();
			InputStreamReader iss=new InputStreamReader(is);
			BufferedReader receive=new BufferedReader(iss);
			for(int i=0;i<a[0].length;i++){
                    for(int j=0;j<a.length;j++){
			        num1=receive.readLine();
			        a[j][i]=Integer.parseInt(num1);
			        System.out.print(a[j][i]);
			     }
			     System.out.println(" ");
			 }
              s.close();
  }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
       
        catch(IOException i)
        {
            System.out.println(i);
        }
        
    }
 public static void main(String args[])
    {
        Clientside c = new Clientside("192.168.43.230", 5000);
    }
}


