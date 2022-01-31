package testpkg;

import java.io.Serializable;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name="client", eager = true)
@SessionScoped
public class Client implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    private static int idLast=1;
    private int    id;
    private String fname;
    private String lname;
    private String mail;
    private int    discount;

    public Client() {}
    public Client(String fname, String lname, String mail) {
        id=idLast;
        idLast++;
        this.fname = fname;
        this.lname = lname;
        this.mail = mail;
    }

    public int getId() { return id; }
    
    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }

    public String getLname() { return lname; }
    public void setLname(String lname) { this.lname = lname; }  
    
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public int getDiscount() { return discount; }
    public void setDiscount(int discount) { this.discount = discount; }
    
    public int[] getDiscounts() { 
        return new int[]{0,5,10,15}; 
    }
    
    public void addClient(ActionEvent ev){
        Client client=new Client(fname,lname,mail);
        client.setDiscount(discount);
        
        ClientList list=(ClientList) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("clientlist");
        if (list!=null)  list.getClientList().add(client);
    }
    public void saveClient(ActionEvent ev){
        ClientList list=(ClientList) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("clientlist");
        if (list!=null) {
            Client curClient=null;
            
            for(Client cl : list.getClientList())
               if (cl.getId()==list.getCurrentId()) { curClient=cl; break; }
            
            if (curClient!=null) {
                curClient.setFname(fname);
                curClient.setLname(lname);
                curClient.setMail(mail);
                curClient.setDiscount(discount);
            }
        }
    }
    public void cancel(ActionEvent ev){
        FacesContext.getCurrentInstance().renderResponse();
    }
}
