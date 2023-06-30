import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import javax.lang.model.util.ElementScanner6;

//Αφορούν μόνο τον server

public class THImpl extends UnicastRemoteObject implements THInterface{
    
    int A_size = 100;
    int B_size = 200;
    int C_size = 400;
    int Centr_size = 225;
    int Side_size = 75;

    public String zoneA[] = new String[A_size];
    public String zoneB[] = new String[B_size];
    public String zoneC[] = new String[C_size];
    public String zoneCentr[] = new String[Centr_size];
    public String zoneSide[] = new String[Side_size];
    
    public THImpl() throws RemoteException
    {
        super();
        int i;
        for(i=0; i<A_size; i++)
            zoneA[i] = "";
        for(i=0; i<B_size; i++)
            zoneB[i] = "";
        for(i=0; i<C_size; i++)
            zoneC[i] = "";
        for(i=0; i<Centr_size; i++)
            zoneCentr[i] = "";
        for(i=0; i<Side_size; i++)
            zoneSide[i] = "";
        
        
    }

    public ArrayList<String> lista() throws RemoteException{
        int i;
        int seatList[] = new int[5];
        String[] category ={"ΠΑ","ΠΒ","ΠΓ","ΚΕ","ΠΘ"};
        int[]   cost={45,35,25,30,20};
        ArrayList<String> list = new ArrayList<>();
        System.out.println("--Seats List function--");
        int emptyA = 0;
        int emptyB = 0;
        int emptyC = 0;
        int emptyCentr = 0;
        int emptySide = 0;

        for(i=0; i<A_size; i++)
            if(zoneA[i].equals(""))
                emptyA++;
        for(i=0; i<B_size; i++)
            if(zoneB[i].equals(""))
                emptyB++;
        for(i=0; i<C_size; i++)
            if(zoneC[i].equals(""))
                emptyC++;
        for(i=0; i<Centr_size; i++)
            if(zoneCentr[i].equals(""))
                emptyCentr++;
        for(i=0; i<Side_size; i++)
            if(zoneSide[i].equals(""))
                emptySide++;
        seatList[0] = emptyA;
        seatList[1] = emptyB;
        seatList[2] = emptyC;
        seatList[3] = emptyCentr;
        seatList[4] = emptySide;
        for(i=0; i<5; i++)
        {
            String l= seatList[i]+" θέσεις Πλατεία - Ζώνη Α (κωδικός: "+category[i]+") - τιμή: "+cost[i]+" Ευρώ\n";
            list.add(l);

        }

        return list; 
    }

    public String book(String type, int number, String name) throws RemoteException
    {
        double totcost=0;

        switch(type){
            case "ΠΑ":
                do{
                    if(number<A_size)
                    {
                        totcost+=45;
                        A_size-=number;
                        for(int i=0; i<A_size; i++)
                            zoneA[i]=name;
                        return "Έγινε με επιτυχία η κράτηση στο όνομα"+name+"με συνολικο κόστος"+totcost;
                    }
                    else if(number-A_size!=0){
                        return "Διαθέσιμες Θέσεις"+A_size;
                    }
                    else{
                        return "Δεν υπαρχουν";
                    }
                }while();
                

            case "ΠΒ":
                if(number<B_size)
                {
                    totcost+=35;
                    B_size-=number;
                    for(int i=0; i<B_size; i++)
                      zoneB[i]=name;
                    return "Έγινε με επιτυχία η κράτηση στο όνομα"+name+"με συνολικο κόστος"+totcost;
                    
                }
                else{
                    return "Δεν υπαρχουν διαθεσιμες θέσεις";
                }
            case "ΠΓ":
                if(number<C_size)
                {
                    totcost+=25;
                    C_size-=number;
                    for(int i=0; i<C_size; i++)
                        zoneC[i]=name;
                    return "Έγινε με επιτυχία η κράτηση στο όνομα"+name+"με συνολικο κόστος"+totcost;
                    
                }
                else{
                    return "Δεν υπαρχουν διαθεσιμες θέσεις";
                }
            case "ΚΕ":
                if(number<Centr_size)
                {   
                    totcost+=30;
                    Centr_size-=number;
                    for(int i=0; i<Centr_size; i++)
                        zoneCentr[i]=name;
                    return "Έγινε με επιτυχία η κράτηση στο όνομα"+name+"με συνολικο κόστος"+totcost;
                        
                }
                else{
                    return "Δεν υπαρχουν διαθεσιμες θέσεις";
                }
            case "ΠΘ":
                if(number<Side_size)
                {
                    totcost+=20;
                    Side_size-=number;
                    for(int i=0; i<Side_size; i++)
                        zoneSide[i]=name;
                    return "Έγινε με επιτυχία η κράτηση στο όνομα"+name+"με συνολικο κόστος"+totcost;
                }
                else{
                    return "Δεν υπαρχουν διαθεσιμες θέσεις";
                }
        }
        return "";

    }

    public ArrayList<String> guests() throws RemoteException
    {
        return new ArrayList<String>();
    }

    public ArrayList<Integer> cancelSeats(String type, int number, String name) throws RemoteException
    {
        return new ArrayList<Integer>();
    }

    
    
}
