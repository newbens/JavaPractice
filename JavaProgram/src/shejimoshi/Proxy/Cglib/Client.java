package shejimoshi.Proxy.Cglib;

public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        TeacherDao teacher  = (TeacherDao) new ProxyFactory(teacherDao).getProxyInstance();
        teacher.teach();
    }
}
