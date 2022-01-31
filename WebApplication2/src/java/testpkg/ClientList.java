package testpkg;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name="clientlist", eager = true)
@SessionScoped
public class ClientList implements Serializable{
    
    private static final long serialVersionUID=1L;
    private static List<Client> clientList;
    private int currentId;

    public int getCurrentId() { return currentId; }
    public void setCurrentId(int currentId) { this.currentId = currentId; }
    
    static{
        clientList=new LinkedList<>();
        clientList.add(new Client("Bob","Marinh","fdf@ghdg22"));
        clientList.add(new Client("Tom","Brinh" ,"fdf@ghdg43"));
        clientList.add(new Client("Ann","Detinh","fdf@ghdg67"));
        clientList.add(new Client("Lom","Ghyinh","fdf@ghdg88"));
        clientList.add(new Client("Jon","Noilnh","fdf@ghdg17"));
    }
    public List<Client> getClientList() { return clientList; }

    public String editClient(){
        Client client=null;

        for(Client cl : clientList)
            if (cl.getId()==currentId) { client=cl; break; }
        
        if (client!=null){
            Client curClient=(Client) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("client");
            if (curClient!=null) {
                curClient.setFname(client.getFname());
                curClient.setLname(client.getLname());
                curClient.setMail(client.getMail());
                curClient.setDiscount(client.getDiscount());
            }  
            return "success";
        }
        else return "failure";
    }
}
