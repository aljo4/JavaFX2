package sample;

public class AccountDetails {
    //fields
    int detailsID;
    int height;
    int weight;
    Account aAccount;


    public AccountDetails(int detailsID, int height, int weight, Account aAccount) {
        this.detailsID = detailsID;
        this.height = height;
        this.weight = weight;
        this.aAccount = aAccount;
    }

    public int getDetailsID() {
        return detailsID;
    }

    public void setDetailsID(int detailsID) {
        this.detailsID = detailsID;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Account getaAccount() {
        return aAccount;
    }

    public void setaAccount(Account aAccount) {
        this.aAccount = aAccount;
    }
}
