package shejimoshi.����ģʽ.�򵥹���;
/*
    ȱ�㣺
        û�����ؿ���ԭ��������µĳ�������Ҫ�ı䳵�����࣬������복�����ƹ�����û�л�����գ�
        �û����鲻�á��Ľ����������������Ĺ��ܱ��ÿһ��������
 */
public class CarFactory {
    public static Car getCar(String name) {
        if (name.equals("����")) {
            return new BaoMa();
        } else if (name.equals("����")) {
            return new DaZhong();
        } else return null;
    }
}
