package com.ljs.vo;

/**
 * create by ljs on 2020/6/18 21:30
 * <p>
 * description:
 */
public class StudentVo {

    private String name;
    private Integer age;


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
        return "StudentVo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
