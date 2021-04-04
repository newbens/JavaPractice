package shejimoshi.ResponsibilityChain;

public class ViceSchoolMasterApprover extends Approver {

    public ViceSchoolMasterApprover(String name) {
        super(name);
    }



    @Override
    public void processRequest(ParchaseRequest parchaseRequest) {
        if (10000< parchaseRequest.getPrice() && parchaseRequest.getPrice() <= 3000) {
            System.out.println(parchaseRequest.getId()+"±»"+this.name+"´¦Àí");
        }else {
            approver.processRequest(parchaseRequest);
        }
    }
}
