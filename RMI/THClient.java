import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class THClient {
    public static String Input(){
        // Δημιουργία ενός αντικειμένου Scanner για ανάγνωση εισόδου από τον χρήστη
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Απάντηση (y=yes, n=no): ");
        String userInput = scanner.nextLine();
        
        // Κλείσιμο του Scanner
        scanner.close();
        return userInput;
    }

    public static void main(String[] args) {
        //Ο client θα πρέπει να τρέχει στο command line ως εξής:
        //Ελέγχουμε αν δεν εχουν εισαχθεί ορίσματα τότε να εκτυπώνει τα ορίσματα που μπορούν να δωθούν java THClient
        /*
        *       java TΗClient: αν καμία άλλη παράμετρος δεν προσδιορίζεται, το πρόγραμμα θα πρέπει απλά να 
        *       τυπώνει στην οθόνη πως ακριβώς (με τι παραμέτρους) πρέπει να τρέξει ο χρήστης την εντολή
        */
        if(args.length == 0)
        {
            PrintCommands();
            return;
        }
        
        try {
            THInterface in = (THInterface)Naming.lookup("rmi://localhost:1099/TH"); 
            String command = args[0];
            //args[1]="localhost";
            //Έλεγχος παραπάνω ορισμάτων
            
            switch(command)
            {
                /*
                *       java TΗClient list <hostname>: να τυπώνεται ως αποτέλεσμα στην οθόνη μία λίστα με τις διαθέσιμες
                *       θέσεις (για κάθε τύπο και κόστος) στο θέατρο - π.χ. στην ακόλουθη μορφή:
                *       κ1 θέσεις Πλατεία - Ζώνη Α (κωδικός: ΠΑ) - τιμή: 45 Ευρώ 
                *       κ2 θέσεις Πλατεία - Ζώνη Β (κωδικός: ΠΒ) - τιμή: 35 Ευρώ 
                *       κ3 θέσεις Πλατεία - Ζώνη Γ (κωδικός: ΠΓ) - τιμή: 25 Ευρώ 
                *       κ4 θέσεις Κεντρικός Εξώστης (κωδικός: ΚΕ) - τιμή: 30 Ευρώ 
                *       κ5 θέσεις Πλαϊνά Θεωρεία (κωδικός: ΠΘ) - τιμή: 20 Ευρώ 
                *       όπου τα κ1,κ2,κ3,κ4,κ5 υποδεικνύουν τον τρέχοντα αριθμό διαθέσιμων θέσεων κάθε τύπου.
                */
                case "list":
                    if (args.length < 2) {
                        System.out.println("Java THClient list <hostname>: Εμφάνιση των διαθέσιμων θέσεων και το κόστος\n");
                        
                    }
                    else{
                        //Εκτύπωση Διαθέσιμων Θέσεων
                        System.out.println(in.lista());
                    }
                    break;
                case "book":
                    if(args.length < 5) {
                        System.out.println("Java THClient book <hostname> <type> <number> <name>: Κράτηση θέσεων\n");
                        
                    }
                    else{
                        String type=args[2];
                        int number=Integer.parseInt(args[3]); //Μετατροπή string σε ακέραιο
                        String name=args[4];
                        
                    }

                    break;
                case "guest":
                    if(args.length < 2) {
                        System.out.println("Java THClient guest <hostname>:\n");
                    }
                    else{
                        
                    }
                    break;
                case "cancel":
                if(args.length < 5) {
                    System.out.println("Java THClient cancel <hostname> <type> <number> <name>: Ακύρωση κράτησης\n");
                    
                }
                else
                {
                    String type=args[2];
                    int number=Integer.parseInt(args[3]);
                    String name=args[4];
                }
                    
                    
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public static void PrintSeats()
    {
        
    }

    //Συνάρτηση που εκτυπώνει τα επιτρεπτά ορίσματα
    private static void PrintCommands() {
        
        System.out.println("Ορίσματα:\n");
        System.out.println("Java THClient: Εκτύπωση τον ορισμάτων\n");
        System.out.println("Java THClient list <hostname>: Εμφάνιση των διαθέσιμων θέσεων και το κόστος\n");
        System.out.println("Java THClient book <hostname> <type> <number> <name>: Κράτηση θέσεων\n");
        System.out.println("Java THClient guest <hostname>: Εκτύπωση λίστας πελατών που έχουν κάνει κράτηση\n");
        System.out.println("Java THClient cancel <hostname> <type> <number> <name>: Ακύρωση κράτησης\n");


    }

}
