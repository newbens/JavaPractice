package shejimoshi.ResponsibilityChain;

public abstract class Approver {

    Approver approver;  //��һ��������
    String  name; //����

    public Approver(String name) {
        this.name = name;
    }

    //��һ��������
    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    //���������ķ���
    public abstract void processRequest(ParchaseRequest parchaseRequest);
}
