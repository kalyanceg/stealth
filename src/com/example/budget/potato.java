package com.example.budget;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;




public class potato implements Runnable{
	
  public void query()throws Exception{
	  URL url=new URL(urlinp+"&ctf="+ctf);
	
	  BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
      String con="";
      
      
      String inputLine;
      while ((inputLine = in.readLine()) != null)
          
              	  
          if(inputLine.contains("search-result-reviews right")){
        	  String inputLinesp[]=inputLine.split("<a href=");
        	  String urlzom[]=inputLinesp[1].split("\"");
        	  String hotnamearr[]=urlzom[1].split("/");
        	  hotels.add(hotnamearr[2].replaceAll("-", " "));
    
        	  con+="http://www.zomato.com"+(urlzom[1])+"\n";
        	  
          }
      in.close();
      
      
      //System.out.println(hotname);
      //System.out.println(con);
  }
/*  public static void main(String args[])throws Exception{
	  
	  query( "http://www.zomato.com/mumbai/restaurants?q=C.+S.+T.+Road",2);
  }*/


String urlinp="";
int ctf=0;
Thread t;
double lat,lon;

ArrayList<String> hotels=new ArrayList<String>();
public potato(String url,int ctf, double lat,double lon){
	this.urlinp=url;
	this.ctf=ctf;
	t=new Thread(this);
	this.lat=lat;
	this.lon=lon;
	t.start();
	
}
public void run() {
	
	try{
	String mapsurlst=	"http://maps.googleapis.com/maps/api/geocode/xml?latlng="+lat+","+lon+"&sensor=true";
	URL mapsurl=new URL(mapsurlst);
	String con="";
    
	BufferedReader in = new BufferedReader(new InputStreamReader(mapsurl.openStream()));
    
    String inputLine;
    while ((inputLine = in.readLine()) != null){
    	con+=inputLine;
	}
    String stname="";
    String cityname="";
    InputSource is = new InputSource();
    is.setCharacterStream(new StringReader(con));
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(is);
    Element docEle = doc.getDocumentElement();
    NodeList acList = docEle.getElementsByTagName("address_component");
    for(int i=0;i<acList.getLength();i++){
    	Node node = acList.item(i);
    	Element e = (Element) node;
    	 NodeList nodeList = e.getElementsByTagName("type");
    	 if(nodeList.item(0).getChildNodes().item(0).getNodeValue().equals("route")){
    		 stname=(e.getElementsByTagName("long_name").item(0).getChildNodes().item(0).getNodeValue());
    		 
    	 }
    	 if(nodeList.item(0).getChildNodes().item(0).getNodeValue().equals("locality")){
    		 cityname=(e.getElementsByTagName("long_name").item(0).getChildNodes().item(0).getNodeValue());
    		 break;
    	 }
    }
    cityname=cityname.toLowerCase();
    stname=stname.replace(" ", "+");
    System.out.println(cityname+" "+stname);
    this.urlinp=this.urlinp+cityname+"/restaurants?q="+stname;
    if(cityname.equals("chennai")||cityname.equals("mumbai"))
      query();
    else
    	this.hotels.add("Sorry we dont cover your location now");
   			
	}
	catch(Exception e){
		System.out.println("issue"+e);
	}
	
}
}