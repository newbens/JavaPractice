package shejimoshi.Proxy.staticProxy;

public class TeacherDaoProxy implements ITeacherDao {

    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;

    }

    @Override
    public void teach() {
        System.out.println("��ʼ����");
        target.teach();
        System.out.println("���������");
    }
}
