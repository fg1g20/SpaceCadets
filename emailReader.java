import java.io.*;
import java.io.IOException;
import java.net.URL;

public class emailReader {
    public static void main(String[] args) throws IOException {
        printer p = new printer();

        String webAddress = "https://www.ecs.soton.ac.uk/people/";//main part of ecs people's directory URL

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //reader object to take keyboard inputs
        System.out.println("EMAIL ID: ");

        webAddress = webAddress + reader.readLine();//takes keyboard input (email ID) and concatenates it with the main directory URL

        p.print(webAddress);

        URL url = new URL(webAddress);//System.out.println(webAddress);
        BufferedReader urlReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String name = "";
        String htmlLine = urlReader.readLine();
        while (htmlLine != null){
            //p.print(htmlLine);
            if (htmlLine.contains("<title>")){ //name is located on the line with the title tag
                name = htmlLine.substring(11, htmlLine.indexOf("|"));
            }
            htmlLine = urlReader.readLine();
        }
        if (name == ""){
            System.out.println("No name found.");
        } else{
            System.out.println(name);
        }
    }
}
