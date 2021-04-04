package shejimoshi.ResponsibilityChain;

public class DepartmentApprover extends Approver {

    public DepartmentApprover(String name) {
        super(name);
    }



    @Override
    public void processRequest(ParchaseRequest parchaseRequest) {
        if (parchaseRequest.getPrice() < 5000) {
            System.out.println(parchaseRequest.getId()+"±»"+this.name+"´¦Àí");
        }else {
            approver.processRequest(parchaseRequest);
        }
    }
}
