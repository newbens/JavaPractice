package shejimoshi.composite;

public class Client {

    public static void main(String[] args) {
        OrganizationComponment qinghua = new University("�廪��ѧ", "�й�������ѧ��");
        OrganizationComponment com = new College("�����ѧԺ", "��Ժ");
        OrganizationComponment man = new College("��ϢѧԺ", "��Ժ");
        com.add(new Department("�������","���"));
        com.add(new Department("���繤��","����"));
        com.add(new Department("�ƿ�","�ƿ�"));
        man.add(new Department("ͨ�Ź���","ͨ��"));
        man.add(new Department("��Ϣ����","��Ϣ"));

        qinghua.add(com);
        qinghua.add(man);

        qinghua.print();



    }
}
