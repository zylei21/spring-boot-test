package com.cibei.springbootredis;

import com.cibei.springbootredis.persistence.dao.RedisDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    @Autowired
    private RedisDao redisDao;
    @Test
    public void contextLoads() {
        redisDao.setValue("张三","男性");
        redisDao.setValue("香香","女性");

        System.out.println(redisDao.getValue("张三"));
        System.out.println(redisDao.getValue("李四"));
        System.out.println(redisDao.getValue("香香"));
    }
    JedisPool pool;
    Jedis jedis;

    @Before
    public void setUp(){
        jedis=new Jedis("localhost");
    }

    /**
     * redis 存储操作
     * curd
     */
    @Test
    public void testBasicString(){
        //添加数据
        jedis.set("name","meepo");
        System.out.println(jedis.get("name"));

        //修改数据
        //1.在原来的基础上修改数据
        jedis.append("name","data");
        System.out.println(jedis.get("name"));
        //2.直接覆盖原来的数据
        jedis.set("name","poo");
        System.out.println(jedis.get(("name")));
        //删除key对应的记录
        jedis.del("name");
        System.out.println("删除:"+jedis.get("name"));
        jedis.mset("name","zhangsan","sex","男");
        System.out.println(jedis.mget("name","sex"));
    }

    /**
     * jedis 操作map
     *
     */
    @Test
    public void testMap(){
        Map<String,String> user=new HashMap<>();
        user.put("name","张三");
        user.put("sex","男");
        user.put("password","123");
        user.put("age","30");
        jedis.hmset("user",user);

        //取出name,结果是泛型的list
        List<String> rsmap=jedis.hmget("user","name");
        System.out.println(rsmap);
        //删除map中的某个键值
        jedis.hdel("user","sex");
        System.out.println("删除后获取sex"+jedis.hmget("user","sex"));
        System.out.println("获取长度:"+jedis.hlen("user"));
        System.out.println("判断key是否存在user:"+jedis.exists("user"));
        System.out.println("获取所有的keys:"+jedis.hkeys("user"));
        System.out.println("获取所有值:"+jedis.hvals("user"));

        Iterator<String> iterator=jedis.hkeys("user").iterator();
        for (;;){
            if (iterator.hasNext()){
                String key=iterator.next();
                System.out.println(key+":"+jedis.hmget("user",key));
            }
            break;
        }
    }
    /**
     * jedis 操作list
     */
    @Test
    public void testList(){
        //开始前,先移除所有的内容
        jedis.del("java framework");
        //第一个是key,第二个是起始位置,第三个是结束位置
        System.out.println(jedis.lrange("java framework",0,1));
        //先向key java framework中存放三条数据
        jedis.lpush("java framework","spring");
        jedis.lpush("java framework","struts");
        jedis.lpush("java framework","hibernate");
        //再取出所有jedis.lrange是按范围取出
        //第一个
        System.out.println(jedis.lrange("java framework",0,-1));
    }

    @Test
    public void test() throws InterruptedException {
        //keys中传入的可以用通配符
        System.out.println(jedis.keys("*")); //返回当前库中所有的key  [sose, sanme, name, dota, foo, sname, java framework, user, braand]
        System.out.println(jedis.keys("*name"));//返回的sname   [sname, name]
        System.out.println(jedis.del("sanmdde"));//删除key为sanmdde的对象  删除成功返回1 删除失败（或者不存在）返回 0
        System.out.println(jedis.ttl("sname"));//返回给定key的有效时间，如果是-1则表示永远有效
        jedis.setex("timekey", 10, "min");//通过此方法，可以指定key的存活（有效时间） 时间为秒
        Thread.sleep(5000);//睡眠5秒后，剩余时间将为<=5
        System.out.println(jedis.ttl("timekey"));   //输出结果为5
        jedis.setex("timekey", 1, "min");        //设为1后，下面再看剩余时间就是1了
        System.out.println(jedis.ttl("timekey"));  //输出结果为1
        System.out.println(jedis.exists("key"));//检查key是否存在
        System.out.println(jedis.rename("timekey","time"));
        System.out.println(jedis.get("timekey"));//因为移除，返回为null
        System.out.println(jedis.get("time")); //因为将timekey 重命名为time 所以可以取得值 min

        //jedis 排序
        //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
        jedis.del("a");//先清除数据，再加入数据进行测试
        jedis.rpush("a", "1");
        jedis.lpush("a","6");
        jedis.lpush("a","3");
        jedis.lpush("a","9");
        System.out.println(jedis.lrange("a",0,-1));// [9, 3, 6, 1]
        System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //输入排序后结果
        System.out.println(jedis.lrange("a",0,-1));

    }

}
