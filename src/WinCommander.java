
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author florenthaxha
 */
public class WinCommander {

    /**
     * @param args the command line arguments
     */
    public String  ipAddress;
    public WinCommander(){
        
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    
    public String getPingCommand(){
        String command = "ping -n 5 " + getIpAddress();
        return command;
    }
    
    public static void main(String[] args) throws IOException {
        pingServer("128.199.144.199");
        pingServer("167.99.51.33");
        pingServer("46.101.253.149");
    }
    
    public static void pingServer(String ip){
        WinCommander winC = new WinCommander();
        
        winC.setIpAddress(ip);
        
        try{
            Process sysProcess = Runtime.getRuntime().exec(winC.getPingCommand());
            
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(sysProcess.getInputStream()));
            
            int pings = 0;
            int timeouts = 0;
            int other = 0;
            
            String line;
            System.out.println("Reading the input stream...");
            
            while((line = streamReader.readLine()) != null){
                System.out.println(line);
                if(line.startsWith("Reply from") || line.startsWith("64 bytes from")){
                    pings++;
                }else {
                    if(line.startsWith("Request timed out")) {
                        timeouts++;
                    } else {
                        other++;
                    }
                }
            }
            if(pings > 1){
                System.out.println("Success!");
            } else {
                System.out.println("Failed!");
            }
        }catch(IOException ex) {
            System.err.print(ex.getMessage());
        }
    }
}
