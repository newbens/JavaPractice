package shejimoshi.ResponsibilityChain;

public class SchoolMasterApprover extends Approver {

    public SchoolMasterApprover(String name) {
        super(name);
    }



    @Override
    public void processRequest(ParchaseRequest parchaseRequest) {
        if (30000< parchaseRequest.getPrice() ) {
            System.out.println(parchaseRequest.getId()+"±»"+this.name+"´¦Àí");
        }else {
            approver.processRequest(parchaseRequest);
        }
    }
}
