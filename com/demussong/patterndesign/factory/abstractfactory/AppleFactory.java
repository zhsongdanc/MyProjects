package com.demussong.patterndesign.factory.abstractfactory;

import com.demussong.patterndesign.factory.abstractfactory.po.Computer;
import com.demussong.patterndesign.factory.abstractfactory.po.IPhone;
import com.demussong.patterndesign.factory.abstractfactory.po.MacBook;
import com.demussong.patterndesign.factory.abstractfactory.po.Phone;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/10/30 17:01
 */
public class AppleFactory implements IFactory{

    @Override
    public Computer createComputer() {
        return new MacBook();
    }

    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}
