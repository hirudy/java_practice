package ProvingGround;

import com.alibaba.fastjson.JSON;
import org.zhangyoubao.httpServer.response.JsonObjectResponse;

public class JsonOperation {
    private static class Person{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        private String name = "rudy";
        private int age;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        private Object data = new Object();
    }

    public static void main(String[] args){
        JsonObjectResponse t = JsonObjectResponse.createResponse();
        t.setData(new Person());

        String a = JSON.toJSONString(t);
        com.alibaba.fastjson.JSONObject t1 = JSON.parseObject(a);
        System.out.println(a);


//        Gson gson = new Gson();
//        String b = gson.toJson(person);
//        JsonObject t2 = gson.fromJson(jsonString,JsonObject.class);

//        System.out.println(b);
    }
}
