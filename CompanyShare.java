package StockManagement;

public class CompanyShare {
    private static double sharePrice;
    public String companyName;
    public int noOfShare;
    public int companyNo;

    public CompanyShare(int companyNo, String name, int noOfShare, double sharePrice) {
        super();
        this.companyName = name;
        this.noOfShare = noOfShare;
        this.sharePrice = sharePrice;
        this.companyNo = companyNo;
    }
    public static double getSharePrice() {
        return sharePrice;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "companyName='" + companyName + '\'' +
                ", noOfShare=" + noOfShare +
                ", sharePrice=" + sharePrice +
                '}';
    }
}
