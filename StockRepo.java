package StockManagement;
import java.util.ArrayList;

public class StockRepo {
    public static StockRepo instance;

    StockRepo() {

    }

    public static StockRepo getInstance() {
        if (instance == null) {
            instance = new StockRepo();
        }
        return instance;
    }

    public ArrayList<CompanyShare> list;
    {
        list = new ArrayList<>();
        list.add(new CompanyShare(1, "Tata", 10, 100));
        list.add(new CompanyShare(2, "Reliance", 15, 90));
        list.add(new CompanyShare(3, "Amazon", 20, 50));
    }


    public boolean isCompanyAvailable(String companyName, int noOfShare) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).companyName.equals(companyName)) {
                if (noOfShare <= list.get(i).noOfShare) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    void companyName() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).companyName);
        }

    }

}
