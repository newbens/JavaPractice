package shejimoshi.ResponsibilityChain;

public class Client {
    public static void main(String[] args) {
        ParchaseRequest parchaseRequest = new ParchaseRequest(1, 31000, 1);
        //创建审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        CollegeApprover collegeApprover = new CollegeApprover("李院长");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("王校长");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("牛校长");
        //连接  成环状
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        departmentApprover.processRequest(parchaseRequest);
    }
}
