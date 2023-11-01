package com.demussong.designpattern.visitor2;

/*
 * @Author: demussong
 * @Description: ref:https://www.jianshu.com/p/1f1049d0a0f4
 *
 *
 * 被访问者一般是不变的，但这样做违反了迪米特法则
 * @Date: 2023/11/1 19:30
 */

public class VisitorMain {

    public static void main(String[] args) {
        Engineer engineer = new Engineer();
        engineer.setCodeLines(6000);
        engineer.setKpi("yes");

        PM pm = new PM();
        pm.setProductCounts(5);
        pm.setKpi("no");

//        CEO
    }


}
// 接收雇主访问
abstract class Employee {

    private String kpi;

    public abstract void accept(Employer employer);

    public String getKpi() {
        return kpi;
    }

    public void setKpi(String kpi) {
        this.kpi = kpi;
    }
}

class Engineer extends Employee {
    private int codeLines;

    @Override
    public void accept(Employer employer) {
        employer.visit(this);
    }

    public int getCodeLines() {
        return codeLines;
    }

    public void setCodeLines(int codeLines) {
        this.codeLines = codeLines;
    }
}
class PM extends Employee {
    private int productCounts;


    @Override
    public void accept(Employer employer) {
        employer.visit(this);

    }

    public int getProductCounts() {
        return productCounts;
    }

    public void setProductCounts(int productCounts) {
        this.productCounts = productCounts;
    }
}


abstract class Employer {

    // 主动访问的动作
    public abstract void visit(Employee employee);
}

class CEO extends Employer {

    @Override
    public void visit(Employee employee) {
        System.out.println("工程师代码量" + ((Engineer)employee).getCodeLines() + ". kpi:" + employee.getKpi());
    }
}

class CTO extends Employer {

    @Override
    public void visit(Employee employee) {
        System.out.println("PM产品量" + ((PM)employee).getProductCounts() + ". kpi:" + employee.getKpi());

    }
}
