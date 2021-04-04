package shejimoshi.ResponsibilityChain;

public abstract class Approver {

    Approver approver;  //下一个处理者
    String  name; //名字

    public Approver(String name) {
        this.name = name;
    }

    //下一个处理者
    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    //处理审批的方法
    public abstract void processRequest(ParchaseRequest parchaseRequest);
}
