package StockManagement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class StockService {
    int result;
    String traderName;
    ArrayList<TraderInformation> traderList = new ArrayList<>();
    StockRepo stockRepo = StockRepo.getInstance();
    public void traderName(String traderName){
        this.traderName = traderName;
    }

    public void buy(String companyName, int noOfShares, int balance){


        if(stockRepo.isCompanyAvailable(companyName, noOfShares)){

            double sharePrice = CompanyShare.getSharePrice();
            double amount = sharePrice * noOfShares;

            if(amount <= balance) {
                result = (int) (balance - noOfShares * sharePrice);
                System.out.println("The Share price of " + companyName + " company is " + sharePrice + " rupees " );
                System.out.println("You buy "+ noOfShares + " shares of " + companyName + " company & ur available balance is " + result);
                String operation = "Buy";
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String time = dtf.format(now);
                traderList.add(new TraderInformation(traderName,operation, companyName, noOfShares, time ));
            }
            else {
                System.out.println("You do not have sufficient balance to buy the share.");
            }
        }
        else {
            System.out.println("Stock not available ");
        }
    }

    public void sell(String companyName, int noOfShare){

        if(stockRepo.isCompanyAvailable(companyName, noOfShare)){
            double sharePrice = CompanyShare.getSharePrice();
            result = (int) (result + noOfShare * sharePrice);
            System.out.println("The Share price of " + companyName + " company is " + sharePrice + "rupees" );
            System.out.println("You sell "+ noOfShare+ " shares of " + companyName + " company & ur balance is " + result);
            String operation = "Sell";
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String time = dtf.format(now);
            traderList.add(new TraderInformation(traderName,operation, companyName, noOfShare, time ));
        }
        else {
            System.out.println("Stock not available ");
        }
    }
    public void printReport(){
        for (int i = 0; i < traderList.size(); i++ ){
            System.out.println(traderList.get(i));
        }
    }
}
