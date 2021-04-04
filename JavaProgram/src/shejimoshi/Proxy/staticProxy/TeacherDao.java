package shejimoshi.Proxy.staticProxy;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("葵花妈妈小课堂开课了！");
    }
}
