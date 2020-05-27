/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author michal
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Count: "  + "sxasxsaxsaxax");
        Client client = ClientBuilder.newClient();
        String count =
        client.target("http://localhost:8080/Complaints/" +
         "resources/complaints/count")
        .request(MediaType.TEXT_PLAIN)
        .get(String.class);

        System.out.println("Count: " + count);
        
        //a.
        System.out.println("zad a.");
        
        List<Complaint> allComplaints = client.target("http://localhost:8080/Complaints/"+"resources/complaints").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Complaint>>(){});

        for (Complaint c : allComplaints){
            System.out.println(c);
        }
        
        //b.
        System.out.println("zad b.");
        
        List<Complaint> openComplaits = client.target("http://localhost:8080/Complaints/"+"resources/complaints").queryParam("status", "open").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Complaint>>(){});

        if(openComplaits.size() > 0) {
            Complaint firstWithOpenStatus = client.target("http://localhost:8080/Complaints/"+"resources/complaints").path(openComplaits.get(0).getId().toString()).request(MediaType.APPLICATION_JSON).get(Complaint.class);
            System.out.println(firstWithOpenStatus);
          
            //c.
            System.out.println("zad c.");
            firstWithOpenStatus.setStatus("closed");
            Response r = client.target("http://localhost:8080/Complaints/"+"resources/complaints").path("1").request(MediaType.APPLICATION_JSON).put(Entity.entity(firstWithOpenStatus, MediaType.APPLICATION_JSON));
        }
        
        //d.
        System.out.println("zad d.");
        
        List<Complaint> allOpenComplaintsAfterChanges = client.target("http://localhost:8080/Complaints/"+"resources/complaints").queryParam("status", "open").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Complaint>>(){});

        for (Complaint c : allOpenComplaintsAfterChanges){
            System.out.println(c);
        }
        
                
        

        client.close(); 
    }
}
