package http;

import java.sql.Date;

public class Student {
        int row;
        String name;
        String  number;
        int age;
        Date brith;
        String gende;


        public int getRow(){
            return row;
        }
        public String getName(){
            return name;
        }
        public String getNumber() { return number; }
        public int getAge() {return age;}
        public Date getBrith() {return brith;}
        public String getGende() {return gende;}
}
