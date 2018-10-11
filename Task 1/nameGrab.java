import java.util.Scanner;
import java.net.*;
import java.io.*;

public class nameGrab
{
	public static String grabHTML(String url) throws Exception 
	{
		String out = "";
		URL website = new URL(url);
		URLConnection connect =  website.openConnection();
		BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream(), "UTF-8"));
		
		String Source = "";
		while ((Source = input.readLine()) != null) 
		{
			out += Source;
		}
		
		input.close();
		return out;
    }

	public static void main(String[] args) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter username:");
		String url = scan.nextLine();
		scan.close();
		
		url = "https://www.ecs.soton.ac.uk/people/" + url;
		String html = grabHTML(url);
		
		html = html.substring(html.indexOf("property=\"name\"") + 16);
		html = html.substring(0, html.indexOf("<"));
		System.out.println(html);
	}
}