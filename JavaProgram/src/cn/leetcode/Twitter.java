package cn.leetcode;

import java.util.*;

public class Twitter {
    private static int time = 0;

    private class Tweet {        //推特类 用链表结构按时间线存储链表
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private class User {                //用户类
        private int id;
        private Set<Integer> follows;   //用Set存储好友列表
        public Tweet head;

        public User(int id) {
            follows = new HashSet<>();   //初始化好友列表
            this.id = id;
            follow(id);   //首先关注自己
        }

        public void follow(int userId) {           //关注功能
            follows.add(userId);
        }

        public void unfollow(int userId) {      //取消关注
            if (userId != id) {                   //不能取消关注自己
                follows.remove(userId);
            } else {
                System.out.println("输入错误！！！");
            }
        }

        public void post(int tweetId) {             //发布推特
            Tweet tweet = new Tweet(tweetId, time);  //实例化推特
            time++;
            //将新发布的推特头插法 插入链表
            tweet.next = head;
            head = tweet;
        }

    }

    private HashMap<Integer, User> userMap = new HashMap<>();  //将id与user映射，方便后续通过id查找用户

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        twitter.postTweet(2, 2);
        twitter.follow(1, 2);
        List res = twitter.getNews(1);
        System.out.println(res);
        twitter.unFollow(1, 2);
        List res2 = twitter.getNews(1);
        System.out.println(res2);

    }

    public void postTweet(int userId, int tweetId) {    //发布推特
        if (!userMap.containsKey(userId)) {    //首先判断是否存在用户，若不存在创建用户
            userMap.put(userId, new User(userId)); //将用户存入UserMap
        }
        User u = userMap.get(userId);   //通过userID获取user对象
        u.post(tweetId);
    }

    public List<Integer> getNews(int userId) {        //查看好友动态
        List<Integer> res = new ArrayList();          //利用数组存放推特
        if (!userMap.containsKey(userId)) return res;  //若没有user返回空
        Set<Integer> users = userMap.get(userId).follows;   //获取好友列表
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));  //创建优先队列，按时间大小排序
        for (int id : users) {                   //将头节点存入优先队列
            Tweet tweet = userMap.get(id).head;  //获得个人推特链表的头节点
            if (tweet == null) {
                continue;
            }
            pq.add(tweet);   //将头节点存入优先队列，队列会按时间进行排序
        }

        while (!pq.isEmpty()) {
            if (res.size() == 10) {  //最大显示数量
                break;
            }
            Tweet tweet = pq.poll(); //按时间顺序将推特存入数组
            res.add(tweet.id);

            if (tweet.next != null) {   //如果后面还有节点，加入优先队列重新排序。
                pq.add(tweet.next);
            }
        }
        return res;
    }

    public void follow(int userId, int followId) { //关注功能模块
        if (!userMap.containsKey(followId)) {   //若userMap没有此账号信息，返回错误
            System.out.println("没有此账号！！！");
        }
        userMap.get(userId).follow(followId);
        System.out.println("关注成功！！！");
    }

    public void unFollow(int userId, int unFollowId) {   //取关功能模块
        if (userMap.containsKey(unFollowId)) {
            userMap.get(userId).unfollow(unFollowId);
        }
    }
}
