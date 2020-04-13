/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package req.backing;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import req.entities.Request;
import req.facade.RequestFacadeLocal;
import req.entities.Request;
import java.time.LocalDate;
import javax.validation.constraints.Size;

/**u
 *
 * @author michal
 */

@Named(value = "requestList")
@RequestScoped
public class RequestList {
    @Size(min = 3, max = 10, message = "{request.size}")
    private String newRequest;

    private HtmlDataTable requestsDataTable;

    

    

    /**
     * Creates a new instance of RequestList
     */
    @Inject
    private RequestFacadeLocal requestFacade;
    public RequestList() {
    }
    public List<Request> getAllRequests() {
      System.out.print(requestFacade.count());
      System.out.print("xd");
      return requestFacade.findAll();
    }
    
    public String addRequest()
    {
        Request newR = new Request();
        newR.setRequestText(getNewRequest());
        newR.setRequestDate(LocalDate.now());
        requestFacade.create(newR);
        setNewRequest("");
        return null;
    }
    public String deleteRequest() { 
        Request req = (Request) getRequestsDataTable().getRowData();
        requestFacade.remove(req);
        
        return null;
    }
    
    /**
     * Get the value of newRequest
     *
     * @return the value of newRequest
     */
    public String getNewRequest() {
        return newRequest;
    }

    /**
     * Set the value of newRequest
     *
     * @param newRequest new value of newRequest
     */
    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }
    
    /**
     * Get the value of requestsDataTable
     *
     * @return the value of requestsDataTable
     */
    public HtmlDataTable getRequestsDataTable() {
        return requestsDataTable;
    }

    /**
     * Set the value of requestsDataTable
     *
     * @param requestsDataTable new value of requestsDataTable
     */
    public void setRequestsDataTable(HtmlDataTable requestsDataTable) {
        this.requestsDataTable = requestsDataTable;
    }
    
}
