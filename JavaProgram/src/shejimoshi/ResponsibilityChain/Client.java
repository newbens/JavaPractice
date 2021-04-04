package shejimoshi.ResponsibilityChain;

public class Client {
    public static void main(String[] args) {
        ParchaseRequest parchaseRequest = new ParchaseRequest(1, 31000, 1);
        //����������
        DepartmentApprover departmentApprover = new DepartmentApprover("������");
        CollegeApprover collegeApprover = new CollegeApprover("��Ժ��");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("��У��");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("ţУ��");
        //����  �ɻ�״
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        departmentApprover.processRequest(parchaseRequest);
    }
}
