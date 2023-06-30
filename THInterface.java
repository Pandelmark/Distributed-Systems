import java.rmi.*;
import java.util.*;

//Remote Interface
//Αφορούν μόνο τον client
public interface THInterface extends Remote
{
    //Κράτηση Θέσεων
    String book(String type, int number, String name) throws RemoteException;
    //Λίστα Πελατών
    ArrayList<String> guests() throws RemoteException;
    //Λίστα με υπόλοιπες θέσεις
    ArrayList<Integer> cancelSeats(String type, int number, String name) throws RemoteException;
    
    //Λιστα διαθεσιμων θεσεων
    //java TΗClient list <hostname>:
    ArrayList<String> lista() throws RemoteException;
}