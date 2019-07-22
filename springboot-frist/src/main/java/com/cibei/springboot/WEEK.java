package com.cibei.springboot;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/05 17:19
 */
public enum WEEK {

    Monday("星期一"),
    Tuesday("星期二"),
    Wednesday("星期三"),
    Thursday("星期四"),
    Friday("星期五"),
    Saturday("星期六"),
    Sunday("星期六");
    private String chinese;
    private WEEK(String chinese){
        this.chinese =chinese;
    }
    public String toChinese(){
        return chinese;
    }
}
