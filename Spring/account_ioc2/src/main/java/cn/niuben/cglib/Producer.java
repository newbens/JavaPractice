package cn.niuben.cglib;

public class Producer  {
    public void saleProduct(float money) {
        System.out.println("销售产品得到"+money);
    }

    public void afterSale(float money) {
        System.out.println("售后得到"+money);
    }

}
