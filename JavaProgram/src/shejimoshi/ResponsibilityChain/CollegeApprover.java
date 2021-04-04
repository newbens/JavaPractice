package shejimoshi.ResponsibilityChain;

public class CollegeApprover extends Approver {

    public CollegeApprover(String name) {
        super(name);
    }



    @Override
    public void processRequest(ParchaseRequest parchaseRequest) {
        if (5000 < parchaseRequest.getPrice() && parchaseRequest.getPrice() <= 10000) {
            System.out.println(parchaseRequest.getId()+"±»"+this.name+"´¦Àí");
        }else {
            approver.processRequest(parchaseRequest);
        }
    }
}
