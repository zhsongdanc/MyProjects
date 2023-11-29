package com.demussong.designpattern.visitor;

/*
 * @Author: demussong
 * @Description:
 *
 * 举个例子，假设你有一个表示动物园的对象结构，其中包含了各种动物的元素类，如 Lion、Tiger 和 Bear。你可能有一个 AnimalVisitor 访问者类，其中包含了 visit(Lion lion)、visit(Tiger tiger) 和 visit(Bear bear) 方法，用于处理与这些动物相关的操作。

现在，如果你想在动物园中添加新的动物，比如 Elephant，那么你需要在 AnimalVisitor 类中添加一个新的 visit(Elephant elephant) 方法。如果你有多个访问者类（比如 FeedingVisitor、CleaningVisitor 等），那么你需要在每一个访问者类中都添加这个新的方法。这会增加代码的复杂性，并可能导致错误。

此外，如果其他开发者创建了依赖于你的元素类的新访问者，那么当你添加新的元素类时，他们的代码可能会因为缺少新的访问者方法而出错。

因此，虽然访问者模式有很多优点，但在添加新的元素类时需要谨慎使用。
 * @Date: 2023/1/12 14:11
 */
public class VisitorMain {

    public static void main(String[] args) {

        //new一个朋友， 朋友接受我对朋友的描述做出一个判断
        Element1 element1 = new Element1();
        element1.accept(new FlowerVisitor());

//        SpecialElement specialElement = new SpecialElement();
//        specialElement.acceptSpecial(new FlowerVisitor());
    }
}
