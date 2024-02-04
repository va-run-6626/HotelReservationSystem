package Services;

public class CloseApplication {
    public void exit()throws InterruptedException{
        System.out.print("Exiting System");
        int i = 5;
        while (i != 0){
            System.out.print(".");
            Thread.sleep(450);
            i--;
        }
        System.out.println();
        System.out.println("Thanks for using HOTEL MANAGEMENT SYSTEM");
    }
}
