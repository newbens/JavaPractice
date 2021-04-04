package day_one;

import com.sun.deploy.util.StringUtils;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
class User {
    private Integer id;
    private String name;
    private Integer age;

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/*------------------------------Stream到底是什么-----------------------------------
                            是数据渠道，用于操作数据源（计算，筛选，过滤）
  Stream特点：stream不会自己存储元素，不会改变源对象，会返回一个持有结果的新stream，stream是延迟执行，只有在需要结果的时候才会执行

*/
public class StremDemo {
    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
        list.stream().filter(user -> {
            return user.getId() % 2 == 0;
        }).filter(user -> {
            return user.getAge() > 24;
        }).map(user -> {
            return user.getName().toUpperCase();
        }).sorted((o1,o2) -> {return o2.compareTo(o1);}).limit(1)
        .forEach(System.out::println);


        //----------------------------四大函数型接口--------------------------
        //函数型接口  有输入有输出
        Function<String, Integer> function = s -> {
            return s.length();
        };
        System.out.println(function.apply("fsfdsfsdf"));
        //断定型接口  返回ture或false
        Predicate<String> predicate = s -> {
            return s.isEmpty();
        };
        System.out.println(predicate.test("123"));
        //消费性接口      返回void
        Consumer<String> consumer = s -> {
            System.out.println("我是Consumer函数型接口\t" + s);
        };
        consumer.accept("牛犇");
        //供给型接口             无输入有输出
        Supplier<String> supplier = () -> {
            return "Supplier";
        };
        System.out.println(supplier.get());


    }
}


