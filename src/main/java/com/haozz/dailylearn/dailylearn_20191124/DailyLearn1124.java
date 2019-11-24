package com.haozz.dailylearn.dailylearn_20191124;


import java.util.function.Predicate;

public class DailyLearn1124 {

    Predicate<String> predicate1 = new Predicate() {
        @Override
        public boolean test(Object o) {
            return false;
        }
    };

    Predicate<String> predicate2 = (String name) ->{
      return "admin".equals(name);
    };


}
